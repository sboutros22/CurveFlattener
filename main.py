import csv

import matplotlib.pyplot as plt
from matplotlib import style
import pandas as pd

#takes excel file and converts it to csv
def excelToCsv():
    df = pd.read_excel("C:\\Users\\johnd\\Downloads\\points.xlsx")
    df.to_csv('points.csv', index=None, header=True)


#another way of making a csv. Could be used later to manipulate points for the math conversion
def createCsv():
    print('john was here')
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

#Displaying the current csv
def readCsv():
    df = pd.read_csv('points.csv')
    print(df)
readCsv()

#Displays the csv file in graph format. Also saves the graph as a .jpg
def displayCsv():
    style.use('ggplot')
    df = pd.read_csv('points.csv')
    df.plot()
    plt.savefig('testplot.png')
    plt.show()
displayCsv()