import numpy as np
from numpy import newaxis

# create instance of default random number generator
rg = np.random.default_rng(1)

a = np.array([[0, 1, 2, 3],
              [4, 5, 6, 7],
              [8, 9, 10, 11]])
print(a)
b = a
print(b is a)
print(id(a))
print(id(b))

c = a.view()
print(c is a)
print(c.base is a)
print(c.flags.owndata)
c = c.reshape((2, 6))
print(c)
print(a)
c[0, 4] = 1234
print(c)
print(a)

s = a[:, 1:3]
print(s)
s[:] = 10
print(a)

d = a.copy()
print(d is a)
print(d.base is a)
d[0, 0] = 9999
print(a)
