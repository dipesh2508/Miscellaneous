import math
import numpy as np
from scipy import stats

# Math library example
value = 4.5
print(f"Square root of {value} is {math.sqrt(value):.2f}")

# NumPy library example
arr1 = np.array([1, 2, 3, 4, 5])
arr2 = np.array([6, 7, 8, 9, 10])

# Adding two NumPy arrays
sum_array = np.add(arr1, arr2)
print("Sum of arrays:", sum_array)

# SciPy library example
data = [2.5, 3.0, 2.7, 2.8, 3.2, 2.9, 3.3, 3.1, 3.6, 3.0]
mean = np.mean(data)
std_dev = np.std(data)

# Calculate t-statistic and p-value using SciPy
t_statistic, p_value = stats.ttest_1samp(data, 3.0)

print(f"Mean: {mean:.2f}, Standard Deviation: {std_dev:.2f}")
print(f"t-statistic: {t_statistic:.2f}, p-value: {p_value:.4f}")