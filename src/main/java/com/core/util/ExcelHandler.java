package com.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream fis;
	FileOutputStream fos;
	File src;
	XSSFCellStyle style;

	public ExcelHandler(String fileName) {

		src = new File(fileName);

		try {

			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		}

		catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}

	}

	public String getData(int sheetIndex, int row, int coloumn) {

		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getStringCellValue();

		return data;

	}

	public String getData(String sheetName, int row, int coloumn) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue().toString();

		return data;
	}

	public int getRowCount(int Index) {
		int row = wb.getSheetAt(Index).getPhysicalNumberOfRows();

		row = row++;
		return row;

	}

	public boolean setCellData(String sheetName, int j, int rowNum, String data) {
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			if (rowNum <= 0)
				return false;
			int index = wb.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = wb.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(j))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			// cell style
			// CellStyle cs = wb.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			cell.setCellValue(data);
			fos = new FileOutputStream(src);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}