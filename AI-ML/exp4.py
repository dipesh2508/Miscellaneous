# Importing required libraries
import pandas as pd
import matplotlib.pyplot as plt

# Creating a sample dataset (you can replace this with your dataset)
data = {
    'Name': ['Dipesh', 'Isheta', 'Ashutosh', 'Shariq', 'Ayushi'],
    'Age': [21, 20, 20, 20, 20],
    'Salary': [82000, 79000, 63000, 58000, 60000]
}

# Creating a Pandas DataFrame
df = pd.DataFrame(data)

# Displaying the DataFrame
print("DataFrame:")
print(df)

# Basic statistics of the dataset
print("\nBasic Statistics:")
print(df.describe())

# Creating a bar chart using Matplotlib
plt.figure(figsize=(8, 4))
plt.bar(df['Name'], df['Salary'])
plt.title('Salary Distribution')
plt.xlabel('Name')
plt.ylabel('Salary')
plt.show()
