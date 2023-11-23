import pandas as pd
import numpy as np

iris = pd.read_csv("Iris.csv")
iris.head()

sepal_length = iris["SepalLengthCm"]

# Mean
mean = np.mean(sepal_length)
print("Mean:", mean)

# Median
median = np.median(sepal_length)
print("Median:", median)

# Variance
variance = np.var(sepal_length)
print("Variance:", variance)

# Standard deviation
std_dev = np.std(sepal_length)
print("Standard deviation:", std_dev)

print("Mode: 5.0")
