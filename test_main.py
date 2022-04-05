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
        #from main import createCsv
        try:
            'points.csv'.is_file()
        except:
            print("No file exists")


class TestExcelToCsv(TestCase):
    def test_excel_to_csv(self):
        from main import excelToCsv
        self.assertFalse(excelToCsv() ==  [
            [0,1, 1000],
            [1,2,3],
            [2,3,2],
            [3,4,1]
        ])
