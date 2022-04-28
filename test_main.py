from unittest import TestCase


# returns false because that is not what points.csv contains
class TestReadCsv(TestCase):
    def test_read_csv(self):
        from main import readCsv
        self.assertFalse(readCsv() == [
            [1, 2],
            [2, 8],
            [7, 60]
        ])


class Test(TestCase):
    def test_create_csv(self):
        from main import createCsv
        try:
            'points.csv'.is_file()
        except:
            print("No file exists")

class TestFlattenFunction(TestCase):
    def test_flatten_function(self):
        data = [
        [1, 2],
        [2, 20],
        [7, 20],
        [8, 4]
        ]
        from main import lowerSlopeAgain
        self.assertTrue(lowerSlopeAgain(data, 4) == [[1, 10], [2, 15], [7, 15], [8, 6]])

   #should fail because I changed the data point from 2 to 50
    def test_fail_flatten_function(self):
        data = [
        [1, 50],
        [2, 20],
        [7, 20],
        [8, 4]
        ]
        from main import lowerSlopeAgain
        self.assertFalse(lowerSlopeAgain(data, 4) == [[1, 10], [2, 15], [7, 15], [8, 6]])

    #should fail because I changed teh lowerSlopeAgain scale from 4 to 2
    def test_fail_scale_flatten_function(self):
        data = [
            [1, 2],
            [2, 20],
            [7, 20],
            [8, 4]
        ]
        from main import lowerSlopeAgain
        self.assertTrue(lowerSlopeAgain(data, 2) == [[1, 10], [2, 15], [7, 15], [8, 6]])

    #should return false because the program does not accept a 0 slope
    def test_fail_scale_flatten_function(self):
        data = [
            [1, 2],
            [2, 20],
            [7, 20],
            [8, 4]
        ]
        from main import lowerSlopeAgain
        self.assertFalse(lowerSlopeAgain(data, 0) == [[1, 10], [2, 15], [7, 15], [8, 6]])

class TestExcelToCsv(TestCase):
    def test_excel_to_csv(self):
        from main import excelToCsv
        self.assertFalse(excelToCsv() == [
            [0, 1, 1000],
            [1, 2, 3],
            [2, 3, 2],
            [3, 4, 1]
        ])

class TestGetAverage(TestCase):

    #should return true because it is being passed in that data and the output is 11.5
    def test_getAverage(self):
        from main import getAverage
        loweredData = [[1, 10], [2, 15], [7, 15], [8, 6]]
        self.assertTrue(getAverage(loweredData) == 11.5)

    #should return false because I changed the 10 to a 5
    def test_getAverage(self):
        from main import getAverage
        loweredData = [[1, 5], [2, 15], [7, 15], [8, 6]]
        self.assertFalse(getAverage(loweredData) == 12.5)

class EndToEnd(TestCase):
    def test_create_csv(self):
        from main import excelToCsv
        self.assertFalse(excelToCsv() == [
            [0, 1, 4],
            [1, 2, 3],
            [2, 3, 2],
            [3, 4, 1]
        ])
    def test_readCsv(self):
        from main import readCsv
        self.assertFalse(readCsv() == [
            [0, 1, 4],
            [1, 2, 3],
            [2, 3, 2],
            [3, 4, 1]
        ])

    def test_getAverage(self):
        from main import getAverage
        loweredData = [[1, 10], [2, 15], [7, 15], [8, 6]]
        self.assertTrue(getAverage(loweredData) == 11.5)

    def test_flatten(self):
        data = [
            [1, 2],
            [2, 10],
            [7, 10],
            [8, 4]
        ]
        from main import lowerSlopeAgain
        self.assertTrue(lowerSlopeAgain(data,4) == [[1, 10], [2, 15], [7, 15], [8, 6]])
