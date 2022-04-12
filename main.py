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
    print('Jacob was here')
    header = ['x_coordinates, y_coordinates']
    data = [
    [1,2],
    [2,8],
    [7,60],
    [8,4]
    ]
    df=pd.DataFrame(data)
    with open('points.csv', 'w', encoding= 'UTF8', newline = '') as f:
        writer = csv.writer(f)
        writer.writerow(header)
        writer.writerows(data)
    return data
data = createCsv()
df = pd.DataFrame(data)
#createCsv()

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

#Exports the data to a .xls file
def exportXls():
    df.to_excel(r'C:\Users\jacx2\Documents\python\export_dataframe.xlsx', index=False, header=True)
exportXls()

def exportCsv():
    df.to_csv(r'C:\Users\jacx2\Documents\python\points.csv', index=None, header=True)
exportCsv()