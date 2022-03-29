
import matplotlib.pyplot as plt
from matplotlib import style
import pandas as pd
import csv

def createCsv():
    header = ['x_coordinates, y_coordinates']
    data = [
    [1,2],
    [2,8],
    [7,60],
    [8,4]
    ]
    with open('points.csv', 'w', encoding= 'UTF8', newline = '') as f:
        writer = csv.writer(f)
        writer.writerow(header)
        writer.writerows(data)
createCsv()

def readCsv():
    df = pd.read_csv('points.csv')
    print(df)
readCsv()

def displayCsv():
    style.use('ggplot')
    df = pd.read_csv('points.csv')
    df.plot()
    plt.show()
displayCsv()
