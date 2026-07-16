/*
 * 联合索引最左前缀原则 — 模拟演示
 *
 * 编译：cd jvm/java-basics && mvn compile -q
 * 运行（从 jvm/java-basics 目录执行）：
 *   java -cp target/classes com.demo.jvm.basics.cs.db.db_leftmost_prefix_L2
 */

package com.demo.jvm.basics.cs.db;

import java.util.*;

public class db_leftmost_prefix_L2 {

    static class Tuple implements Comparable<Tuple> {
        final int a, b, c;

        Tuple(int a, int b, int c) { this.a = a; this.b = b; this.c = c; }

        @Override
        public int compareTo(Tuple o) {
            if (a != o.a) return a - o.a;
            if (b != o.b) return b - o.b;
            return c - o.c;
        }

        @Override
        public String toString() {
            return String.format("(%2d, %2d, %2d)", a, b, c);
        }
    }

    static class CompositeIndex {
        final List<Tuple> data;
        final String label;

        CompositeIndex(String label, List<Tuple> data) {
            this.label = label;
            Collections.sort(data); // 模拟 B+ 树索引排序
            this.data = data;
        }

        // 模拟索引查找：返回能否利用索引（二分查找）加速
        // 匹配规则 = 索引定义 (a, b, c)，查询条件支持 = 和 >/>=/</<= 混合
        // 此处简化：仅演示 equals + 范围前缀场景
        boolean canUseIndex(String queryDesc, int[] fixedValues) {
            // fixedValues 长度 = 连续前缀长度
            // 如 [a_val]           → 前缀长度 1，可用索引
            // 如 [a_val, b_val]    → 前缀长度 2，可用索引
            // 如 [a_val, b_val, c_val] → 前缀长度 3，可用索引
            // 如 []（无 a）         → 无用
            // 如 [a_val, -1, c_val] → 跳过 b，无用（只有 a 可用，c 不能用）
            int prefixLen = 0;
            for (int i = 0; i < fixedValues.length; i++) {
                if (i == 0 && fixedValues[i] < 0) break; // 没有左前缀
                if (fixedValues[i] < 0) break;           // 跳过了中间列
                prefixLen++;
            }
            // 如果 fixedValues 中有 -1（跳过列），且跳过的不是最后一列
            boolean hasGap = false;
            for (int i = 0; i < fixedValues.length - 1; i++) {
                if (fixedValues[i] >= 0 && fixedValues[i + 1] < 0) {
                    hasGap = true;
                    break;
                }
            }
            boolean usable = prefixLen > 0; // 至少第一列有值
            if (hasGap) {
                System.out.printf("  %-40s → 前缀仅 %d 列可用（%s 后的列无法走索引）%n",
                        queryDesc, prefixLen,
                        prefixLen == 1 ? "a" : prefixLen == 2 ? "b" : "");
                return true; // 部分可用
            }
            if (usable) {
                System.out.printf("  %-40s → 可用索引（前缀匹配 %d 列）%n",
                        queryDesc, prefixLen);
            } else {
                System.out.printf("  %-40s → 无法使用索引（无左前缀）%n", queryDesc);
            }
            return usable;
        }

        // 展示索引排序后的数据
        void printSortedData() {
            System.out.println("索引 (a, b, c) 排序后的数据（前 40 条）：");
            for (int i = 0; i < Math.min(40, data.size()); i++) {
                System.out.print(data.get(i).toString());
                if ((i + 1) % 5 == 0) System.out.println();
                else System.out.print("  ");
            }
            if (data.size() > 40) System.out.println("  ... 共 " + data.size() + " 条");
            System.out.println();
        }
    }

    static List<Tuple> generateData() {
        List<Tuple> list = new ArrayList<>();
        // 生成 3*5*5 = 75 条数据，覆盖 a∈[1,3], b∈[1,5], c∈[1,5]
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    list.add(new Tuple(a, b, c));
                }
            }
        }
        // 故意打乱，然后由 CompositeIndex 排序模拟索引组织
        Collections.shuffle(list, new Random(42));
        return list;
    }

    public static void main(String[] args) {
        System.out.println("=== 联合索引最左前缀原则 — 模拟演示 ===\n");
        System.out.println("索引定义：KEY `idx` (`a`, `b`, `c`)\n");

        CompositeIndex idx = new CompositeIndex("idx(a,b,c)", generateData());
        idx.printSortedData();

        System.out.println("--- 查询场景分析 ---\n");

        // 场景 1：等值匹配全部三列
        idx.canUseIndex("WHERE a=1 AND b=2 AND c=3", new int[]{1, 2, 3});
        // 场景 2：等值匹配前两列
        idx.canUseIndex("WHERE a=1 AND b=2", new int[]{1, 2});
        // 场景 3：等值匹配第一列
        idx.canUseIndex("WHERE a=1", new int[]{1});
        // 场景 4：范围匹配第一列
        idx.canUseIndex("WHERE a>1", new int[]{1}); // 简化，用 > 标记
        // 场景 5：等值 a + 范围 b
        idx.canUseIndex("WHERE a=1 AND b>2", new int[]{1, 2});
        // 场景 6：完全没有左前缀
        idx.canUseIndex("WHERE b=2", new int[]{-1, 2});
        // 场景 7：跳过左前缀
        idx.canUseIndex("WHERE c=3", new int[]{-1, -1, 3});
        // 场景 8：跳过中间列
        idx.canUseIndex("WHERE a=1 AND c=3", new int[]{1, -1, 3});
        // 场景 9：b 和 c 但无 a
        idx.canUseIndex("WHERE b=2 AND c=3", new int[]{-1, 2, 3});
        // 场景 10：a 等值 + b 范围 + c 等值
        idx.canUseIndex("WHERE a=1 AND b>2 AND c=3", new int[]{1, 2});

        System.out.println();
        System.out.println("--- 可视化：为什么 b 单独查询不走索引？---\n");
        visualizeNonPrefixQuery(idx);

        System.out.println("\n--- 可视化：为什么 a=1 AND c=3 只有 a 能走索引？---\n");
        visualizeSkippedMiddle(idx);
    }

    // 展示 b=2 时，相同 b 值分布在不同的 a 分区中
    static void visualizeNonPrefixQuery(CompositeIndex idx) {
        System.out.println("以排序后的索引顺序查看 b=2 的行（标记为 *）：");
        int count = 0;
        for (int i = 0; i < Math.min(45, idx.data.size()); i++) {
            Tuple t = idx.data.get(i);
            boolean match = t.b == 2;
            if (match) count++;
            String marker = match ? " *" : "  ";
            System.out.print(t + marker + "  ");
            if ((i + 1) % 3 == 0) System.out.println();
        }
        System.out.println();
        System.out.printf("结论：b=2 的行分散在 %d 个不同的 a 分区中，无法通过 B+ 树前缀定位。%n",
                idx.data.stream().filter(t -> t.b == 2).map(t -> t.a).distinct().count());
    }

    // 展示 a=1 AND c=3 时，c=3 在 a=1 内的分布
    static void visualizeSkippedMiddle(CompositeIndex idx) {
        System.out.println("索引按 (a,b,c) 排序，a=1 分区内按 b 再按 c 排序：");
        int shown = 0;
        for (Tuple t : idx.data) {
            if (t.a != 1) continue;
            if (shown >= 10) break;
            String marker = t.c == 3 ? " <-- c=3" : "";
            System.out.printf("  %s%s%n", t, marker);
            shown++;
        }
        System.out.println("在 a=1 分区中，c=3 分散在不同 b 值下，");
        System.out.println("因此 c 无法直接走索引（需要先确定 b 才能定位 c）。");
    }
}
