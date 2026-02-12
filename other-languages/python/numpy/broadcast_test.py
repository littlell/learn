print("示例 1：标量与数组（最常用）")
import numpy as np

arr = np.array([[1, 2, 3],
                [4, 5, 6]]) # Shape: (2, 3)
scalar = 10

result = arr + scalar
print(arr)
print(scalar)
print(result)


print("示例 2：向量与矩阵（行广播与列广播）")
# 案例：对矩阵的每一列减去不同的均值
matrix = np.random.randn(4, 3) # Shape: (4, 3)
print(matrix)
mean_per_column = matrix.mean(axis=0) # 计算每列的均值，Shape: (3,)
print(mean_per_column)

# 从每一行中减去 mean_per_column
centered_matrix = matrix - mean_per_column
print(centered_matrix) # 输出: (4, 3)


print("示例 3：不兼容的形状（会报错）")
a = np.array([[1, 2, 3],
              [4, 5, 6]]) # Shape: (2, 3)
b = np.array([1, 2])       # Shape: (2,)

print(a)
print(b)

try:
    result = a + b
except ValueError as e:
    print(f"Error: {e}")
# 输出：Error: operands could not be broadcast together with shapes (2,3) (2,)
