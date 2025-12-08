package com.utilsPages;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils
{
    public static Object[][] getExcelData(String filePath, String sheetName)
    {
        Object[][] data=null;
        try
        {
            FileInputStream input=new FileInputStream(filePath);
            Workbook workbook=new XSSFWorkbook(input);
            Sheet sheet=workbook.getSheet(sheetName);
            int rows=sheet.getPhysicalNumberOfRows();
            int cols=sheet.getRow(0).getLastCellNum();
            data=new Object[rows - 1][cols];
            for(int i=1;i<rows;i++)
            {
                Row row=sheet.getRow(i);
                for(int j=0;j<cols;j++)
                {
                    Cell cell=row.getCell(j);
                    data[i-1][j]=cell.toString();
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return data;
    }
}