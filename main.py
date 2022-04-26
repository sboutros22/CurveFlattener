import csv

import matplotlib.pyplot as plt
from matplotlib import style
import pandas as pd


# takes excel file and converts it to csv
def excelToCsv():
    df = pd.read_excel("C:\\Users\\jacx2\\Documents\\python\\points.xlsx")
    df.to_csv('points.csv', index=None, header=True)


# another way of making a csv. Could be used later to manipulate points for the math conversion
def createCsv(data):
    header = ['x_coordinates, y_coordinates']
    df = pd.DataFrame(data)
    with open('points.csv', 'w', encoding='UTF8', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(header)
        writer.writerows(data)
    return data


# data = createCsv(data)
data = [
        [1, 2],
        [2, 20],
        [7, 20],
        [8, 4]
    ]
df = pd.DataFrame(data)
data2 = [
        [1, 2],
        [2, 20],
        [7, 20],
        [8, 4]
    ]
# df = pd.DataFrame(data2)

# createCsv()

# Displaying the current csv
def readCsv():
    df = pd.read_csv('points.csv')
    print(df)


# readCsv()


# Displays the csv file in graph format. Also saves the graph as a .jpg
def displayCsv(before):
    style.use('ggplot')
    # df = pd.read_csv('points.csv')
    plt.plot(before)
    # plt.plot(after)
    plt.savefig('testplot.png')
    plt.autoscale(False)
    plt.ylim(-1, 20)
    plt.show()


# displayCsv()


# Exports the data to a .xls file
def exportXls():
    df.to_excel(r'C:\Users\jacx2\Documents\python\export_dataframe.xlsx', index=False, header=True)


exportXls()


def exportCsv():
    df.to_csv(r'C:\Users\jacx2\Documents\python\points.csv', index=None, header=True)


exportCsv()


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

def lowerSlopeAgain(loweredData, lowerFactor):
    if (lowerFactor == 0):
        print("You're a dumbass")
        return
    avg = getAverage(loweredData)
    print("average; ", avg)
    for idx, x in enumerate(loweredData):
        distance = (avg - loweredData[idx][1]) / lowerFactor
        loweredData[idx][1] = loweredData[idx][1] + ((avg - loweredData[idx][1]) - distance)
        # print("Old data in method", data)
        # if (data[idx][1] >= avg):
        #     data[idx][1] = data[idx][1] + (abs(data[idx][1] - avg))
        # else:
        #     data[idx][1] = data[idx][1] - (abs(data[idx][1] - avg))
    return loweredData

#Test
newData = lowerSlopeAgain(data2, 4)
df1 = pd.DataFrame(data)
df2 = pd.DataFrame(newData)
print("Old data", data)
print("lowered data", newData)
print("lowered data", df2)
displayCsv(df2)
