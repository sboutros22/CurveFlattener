import csv

import matplotlib.pyplot as plt
from matplotlib import style
import pandas as pd


# takes excel file and converts it to csv
def excelToCsv():
    df = pd.read_excel("C:\\Users\\johnd\\Downloads\\points.xlsx")
    df.to_csv('points.csv', index=None, header=True)

data = [
        [1, 2],
        [2, 8],
        [7, 20],
        [8, 4]
    ]
# another way of making a csv. Could be used later to manipulate points for the math conversion
def createCsv(data):
    header = ['x_coordinates, y_coordinates']
    df = pd.DataFrame(data)
    with open('points.csv', 'w', encoding='UTF8', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(header)
        writer.writerows(data)
    return data


data = createCsv(data)
df = pd.DataFrame(data)


# createCsv()

# Displaying the current csv
def readCsv():
    df = pd.read_csv('points.csv')
    print(df)


readCsv()


# Displays the csv file in graph format. Also saves the graph as a .jpg
def displayCsv():
    style.use('ggplot')
    df = pd.read_csv('points.csv')
    df.plot()
    plt.savefig('testplot.png')
    plt.autoscale(False)
    plt.ylim(-1, 20)
    plt.show()


displayCsv()


# Exports the data to a .xls file
def exportXls():
    df.to_excel(r'C:\Users\ncont\PycharmProjects\CurveFlattener1\export_dataframe.xlsx', index=False, header=True)


exportXls()


def exportCsv():
    df.to_csv(r'C:\Users\ncont\PycharmProjects\CurveFlattener1\points.csv', index=None, header=True)


exportCsv()

newData = [
    [1, 2],
    [2, 8],
    [7, 12],
    [8, 4]
]


def getAverage(nums): #Contos
    sum = 0
    for ind, x in enumerate(data):
        sum += data[ind][1]
    return sum / len(nums)
print("avg: ", getAverage(data))


print("Old data", data)


def flattener(data, lowerFactor): #Contos
    avg = getAverage(data)
    for idx, x in enumerate(data):

        if data[idx][1] > avg:
            data[idx][1] = int(data[idx][1] / lowerFactor)
        else:
            data[idx][1] = int(data[idx][1] / (lowerFactor / 2))
    return data

# displayCsv()
# data = createCsv(flattener(data,4))
# df = pd.DataFrame(data)
# displayCsv()
# print("lowered data", data)

def lowerSlopeAgain(data, lowerFactor):
    if (lowerFactor == 0):
        print("You're a dumbass")
        return
    avg = getAverage(data)
    print("average; ", avg)
    for idx, x in enumerate(data):
        distance = (avg - data[idx][1]) / lowerFactor
        data[idx][1] = data[idx][1] + ((avg - data[idx][1]) - distance)
        # if (data[idx][1] >= avg):
        #     data[idx][1] = data[idx][1] + (abs(data[idx][1] - avg))
        # else:
        #     data[idx][1] = data[idx][1] - (abs(data[idx][1] - avg))
    return data

#Test
data = createCsv(lowerSlopeAgain(newData, 4))
df = pd.DataFrame(data)
displayCsv()
df = pd.DataFrame(newData)
print("lowered data", newData)



