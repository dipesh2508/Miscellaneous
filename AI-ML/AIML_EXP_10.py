import pandas as pd
import matplotlib.pyplot as plt

# Load the Iris dataset
data = pd.read_csv('Iris.csv')

# Check the dataset's shape
print(data.shape)
# Display the first five rows of the dataset
print(data.head())
# Get a summary of the dataset's numerical columns
print(data.describe())

# Create histograms for each numerical variable
data.hist(figsize=(12, 8))
plt.subplots_adjust(bottom=0.1)
plt.show()

# Create scatter plots for pairwise relationships between numerical variables
data.plot.scatter(x='SepalLengthCm', y='SepalWidthCm')
plt.show()

data.plot.scatter(x='SepalLengthCm', y='PetalLengthCm')
plt.show()

data.plot.scatter(x='SepalLengthCm', y='PetalWidthCm')
plt.show()

data.plot.scatter(x='SepalWidthCm', y='PetalLengthCm')
plt.show()

data.plot.scatter(x='SepalWidthCm', y='PetalWidthCm')
plt.show()

data.plot.scatter(x='PetalLengthCm', y='PetalWidthCm')
plt.show()

# Create box plots for each numerical variable by species
data.boxplot(by='Species')
plt.show()

# Check for outliers using box plots and histograms
data.boxplot(by='Species')
plt.show()

data.hist(figsize=(12, 8))
plt.subplots_adjust(bottom=0.1)
plt.show()

# Examine the distribution of the 'species' variable
print(data['Species'].value_counts())

"""***21BCS2062_MEHAK SHARMA***"""

# Create bar charts to visualize the distribution of numerical variables within each species
data.groupby('Species')['SepalLengthCm'].hist()
plt.show()

data.groupby('Species')['SepalWidthCm'].hist()
plt.show()

data.groupby('Species')['PetalLengthCm'].hist()
plt.show()

data.groupby('Species')['PetalWidthCm'].hist()
plt.show()
