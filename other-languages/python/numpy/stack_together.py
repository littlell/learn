import numpy as np
from numpy import newaxis

# create instance of default random number generator
rg = np.random.default_rng(1)

a = np.floor(10 * rg.random((2, 2)))
print(a)
b = np.floor(10 * rg.random((2, 2)))
print(b)

print("vstack")
print(np.vstack((a, b)))
print("hstack")
print(np.hstack((a, b)))

print(np.column_stack((a, b)))
a = np.array([4., 2.])
b = np.array([3., 8.])
print(np.column_stack((a, b)))
print(np.hstack((a, b)))
print(a[:, newaxis])
print(np.column_stack((a[:, newaxis], b[:, newaxis])))
print(np.hstack((a[:, newaxis], b[:, newaxis])))

print(np.r_[1:4, 0, 4])