import numpy as np
from numpy import newaxis

# create instance of default random number generator
rg = np.random.default_rng(1)

a = np.floor(10 * rg.random((2, 12)))
print(a)
# Split `a` into 3
print(np.hsplit(a, 3))
# Split `a` after the third and the fourth column
print(np.hsplit(a, (3, 4)))
