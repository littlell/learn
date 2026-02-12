import numpy as np
from math import pi

a = np.array([20, 30, 40, 50])
b = np.arange(4)
print(b)
c = a - b
print(c)
print(b ** 2)
print(10 * np.sin(a))
print(a < 35)

A = np.array([[1, 1],
              [0, 1]])
B = np.array([[2, 0],
              [3, 4]])
# elementwise product
print(A * B)
# matrix product
print(A @ B)
# another matrix product
print(A.dot(B))

# create instance of default random number generator
rg = np.random.default_rng(1)
a = np.ones((2, 3), dtype=int)
print(a)
b = rg.random((2, 3))
print(b)
a *= 3
print(a)
b += a
print(b)

a = np.ones(3, dtype=np.int32)
b = np.linspace(0, pi, 3)
print(b.dtype.name)
print(b)
c = a + b
print(c)
print(c.dtype.name)
d = np.exp(c * 1j)
print(d)
print(d.dtype.name)

a = rg.random((2, 3))
print(a)
print(a.sum())
print(a.min())
print(a.max())

b = np.arange(12).reshape(3, 4)
print(b)
print(b.sum(axis=0))
print(b.min(axis=1))
print(b.cumsum(axis=1))

B = np.arange(3)
print(B)
print(np.exp(B))
print(np.sqrt(B))
C = np.array([2., -1., 4.])
print(C)
print(np.add(B, C))

a = np.arange(10) ** 3
print(a)
print(a[2])
print(a[2:5])
a[:6:2] = 1000
print(a)
a[::-1]  # reversed a
for i in a:
    print(i ** (1 / 3.))


def f(x, y):
    return 10 * x + y


b = np.fromfunction(f, (5, 4), dtype=int)
print(b)
print(b[2, 3])
print(b[0:5, 1])
print(b[:, 1])
print(b[1:3, :])
print(b[-1])

c = np.array([[[0, 1, 2],  # a 3D array (two stacked 2D arrays)
               [10, 12, 13]],
              [[100, 101, 102],
               [110, 112, 113]]])
print(c.shape)
# same as c[1, :, :] or c[1]
print(c[1, ...])
print(c[1])
# same as c[:, :, 2]
print(c[..., 2])
print(c[:, :, 2])

b = np.fromfunction(f, (5, 4), dtype=int)
print(b)
for row in b:
    print(row)

for element in b.flat:
    print(element)