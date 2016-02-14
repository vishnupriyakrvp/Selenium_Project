package com.vishnu;


import java.io.File;

import java.io.IOException;

import java.util.Hashtable;
import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;


/**
10
 * This is a utility class created to read the excel test data file before performing the test steps.
11
 * This class loads the excel file and
12
 * reads its column entries.
13
 *
14
 */

 

public class ExcelReader {

                /**
18
                 * The worksheet to read in Excel file
19
                 */

 
                public static Sheet wrksheet;
                /**
23
                 * The Excel file to read
24
                 */

 

                public static Workbook wrkbook = null;

                /**
28
                 * Store the column data
29
                 */

 

                public static Hashtable<String, Integer> dict = new Hashtable<String, Integer>();

                /**
33
                 * Create a Constructor
34
                 *
35
                 * @param ExcelSheetPath
36
                 * @throws BiffException
37
                 * @throws WeblivException
38
                 */

 

                public ExcelReader(String ExcelSheetPath) throws IOException, BiffException {

 

                            // Initialize

                                try {

                                               wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));

                                               wrksheet = wrkbook.getSheet("Sheet1");

                                } catch (IOException e) {

                                                throw new IOException();

                                }

                }

                /**
51
                 * Returns the Number of Rows
52
                 *
53
                 * @return Rows
54
                 */

 

                public static int RowCount() {

                                return wrksheet.getRows();

                }

                /**
60
                 * Returns the Cell value by taking row and Column values as argument
61
                 *
62
                 * @param column
63
                 * @param row
64
                 * @return Cell contents
65
                 */

 

                public static String ReadCell(int column, int row) {

                                return wrksheet.getCell(column, row).getContents();

                }

                /**
71
                * Create Column Dictionary to hold all the Column Names
72
                 */

                public static void ColumnDictionary() {

                                // Iterate through all the columns in the Excel sheet and store the

                                // value in Hashtable

                                for (int col = 0; col < wrksheet.getColumns(); col++) {

                                                dict.put(ReadCell(col, 0), col);

                                }

                }

                /**
81
                 * Read Column Names
82
                 *
83
                 * @param colName
84
                 * @return value
85
                 */

 

                public static int GetCell(String colName) {

                                try {

                                                int value;

                                                value = ((Integer) dict.get(colName)).intValue();

                                                return value;

                                } catch (NullPointerException e) {

                                                return (0);

                                }

                }

}


