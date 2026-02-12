import numpy as np
from numpy import pi

a = np.array([2, 3, 4])
print(a.dtype)
b = np.array([1.2, 3.5, 5.1])
print(b.dtype)

b = np.array([(1.5, 2, 3), (4, 5, 6)])
print(b)

c = np.array([[1, 2], [3, 4]], dtype=complex)
print(c)

print(np.zeros((3, 4)))
print(np.ones((2, 3, 4), dtype=np.int16))
print(np.empty((2, 3)))

print(np.arange(10, 30, 5))
print(np.arange(0, 2, 0.3))

print(np.linspace(0, 2, 9))
x = np.linspace(0, 2 * pi, 100)
print(x)
f = np.sin(x)
print(f)