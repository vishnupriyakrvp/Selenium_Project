package com.vishnu.yahoo;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.Test;

public class Driver_yahoo {
	static Workbook wb;
	static Sheet ws, ws1, ws2, ws3;
	static FileInputStream fs;
	static String testr, classname, func;

	@Test(priority = 1)
	public static void fn_executetests() throws Exception {

		fs = new FileInputStream("F:\\Workspace\\Keyword\\testdata\\data.xls");
		wb = Workbook.getWorkbook(fs);
		// get TestCases sheet
		ws1 = wb.getSheet(1);
		for (int r = 1; r < ws1.getRows(); r++) {
			testr = ws1.getCell(7, r).getContents();

			if (testr.matches("yes")) {
				classname = ws1.getCell(5, r).getContents();
				Class c = Class.forName(classname);
				func = ws1.getCell(6, r).getContents();
				Method m = c.getMethod(func, null); // //datatype for
													// arguments,,,, if no
													// arguments null
				Object obj = c.newInstance();
				m.invoke(obj, null); // //////pass the values for the method

			}
		}
	}

}
