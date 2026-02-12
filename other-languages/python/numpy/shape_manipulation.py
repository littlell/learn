import numpy as np

# create instance of default random number generator
rg = np.random.default_rng(1)

a = np.floor(10 * rg.random((3, 4)))
print(a)
print(a.shape)
print(a.ravel())
print(a.reshape(6, 2))

print(a.T)
print(a.T.shape)
print(a.shape)

a.resize((2, 6))
print(a)

print(a.reshape(3, -1))