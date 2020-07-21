package com.fsociety.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcel {

    public void readExcel(){
        //set direction file
        String baseDirection="E:\\Documents\\";
        String fullDirection=baseDirection+"Person.xlsx";
        try {
            FileInputStream file= new FileInputStream(new File(fullDirection));

            //Create workBook instance holding  reference to .xlsx file
            XSSFWorkbook workbook=new XSSFWorkbook(file);

            //Get frist/desired sheet from the workook
            XSSFSheet sheet=workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator=sheet.iterator();
            while (rowIterator.hasNext()){
                Row row=rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator=row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell=cellIterator.next();
                    switch (cell.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue()+"t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue()+"t");
                            break;
                    }
                }
                System.out.println();
            }
            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
