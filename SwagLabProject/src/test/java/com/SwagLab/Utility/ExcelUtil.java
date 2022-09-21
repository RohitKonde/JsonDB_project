package com.SwagLab.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static XSSFWorkbook wb;

	public ExcelUtil() {
		File f1 = new File(System.getProperty("user.dir") + "\\config\\data.xlsx");
		try {
			FileInputStream fs = new FileInputStream(f1);
			wb = new XSSFWorkbook(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getData(int row, int cell) {
		return wb.getSheet("userdata").getRow(row).getCell(cell).getStringCellValue();
	}
}
