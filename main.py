import csv

import matplotlib.pyplot as plt
from matplotlib import style
import pandas as pd


# takes excel file and converts it to csv
def excelToCsv():
    df = pd.read_excel("C:\\Users\\Simon\\Downloads\\CurveFlattener-John\\CurveFlattener-John\\points.xlsx")
    df.to_csv('points.csv', index=None, header=True)
    print("excel data", df)


excelToCsv()


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
    [2, 10],
    [7, 10],
    [8, 4]
]
df = pd.DataFrame(data)
data2 = [
    [1, 2],
    [2, 10],
    [7, 10],
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
def displayCsvBefore(before):
    style.use('ggplot')
    # df = pd.read_csv('points.csv')
    plt.plot(before)
    # plt.plot(after)
    # plt.savefig('testplot.png')
    plt.autoscale(False)
    plt.ylim(-1, 20)
    plt.show()


def displayCsvAfter(after):
    style.use('ggplot')
    # df = pd.read_csv('points.csv')
    after = lowerSlopeAgain(df, 2)
    plt.plot(after)
    # plt.plot(after)
    # plt.savefig('testplot.png')
    plt.autoscale(False)
    plt.ylim(-1, 20)
    plt.show()


# displayCsv()


# Exports the data to a .xls file
# def exportXls():
#     df.to_excel(r'C:\Users\jacx2\Documents\python\export_dataframe.xlsx', index=False, header=True)
#
#
# exportXls()
#
#
# def exportCsv():
#     df.to_csv(r'C:\Users\jacx2\Documents\python\points.csv', index=None, header=True)
#
#
# exportCsv()


def getAverage(nums):  # Contos
    sum = 0
    for ind, x in enumerate(nums):
        sum += nums[ind][1]
    return sum / len(nums)


print("avg: ", getAverage(data))


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
        print("for test", loweredData)
    return loweredData


# Test
newData = lowerSlopeAgain(data2, 4)
df1 = pd.DataFrame(data)
df2 = pd.DataFrame(newData)
print("Old data", data)
print("lowered data", newData)
displayCsvBefore(df2)
displayCsvAfter(df1)