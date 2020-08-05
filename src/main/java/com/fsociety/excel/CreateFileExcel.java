package com.fsociety.excel;

import com.fsociety.model.ListPerson;
import com.fsociety.model.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CreateFileExcel {

    public void createExcel(){

        //create blanc workbook is a excel docuemten
        XSSFWorkbook workbook=new XSSFWorkbook();

        //create a blanck sheet from excel docuemtn
        XSSFSheet sheet =workbook.createSheet("Person detalis");

        //this data need to be writtem (Object[])
        Map<String,Object[]>data=new TreeMap<String, Object[]>();
        data.put("1",new Object[]{"id","Name","First LastName","Second LastName"});//header
        data.put("2",new Object[]{1,"Emmanuel","Hernandez","Ramirez"});//rows and columns
        data.put("3",new Object[]{2,"Orlando","Romero","Masias"});
        data.put("4",new Object[]{3,"Esfayro","Fragoso","Escarscega"});
        data.put("5",new Object[]{4,"Edgar","Serrano",""});
        //Iterate over data and write to sheet
        Set<String>keySet=data.keySet();
        int rowNum=0;
        for (String key:keySet){
            Row row=sheet.createRow(rowNum++);
            Object[] objArr =data.get(key);
            int cellNum=0;
            for (Object obj:objArr){
                //this line create a cel in the next column of that roe
                Cell cell=row.createCell(cellNum++);
                if (obj instanceof String){
                    cell.setCellValue((String)obj);
                }else if (obj instanceof Integer){
                    cell.setCellValue((Integer)obj);
                }
            }
        }
        try {
            //this Writes the workbook
            FileOutputStream out=new FileOutputStream(new File("E:\\Documents\\Person.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Person.xlsx written successfully on disk. ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createExcelWhitModel(){
        String []header={"id","name","First LastName","Second LastName","dateBirth","curp"};
        XSSFWorkbook whWorkbook=new XSSFWorkbook();
        Sheet sheet=whWorkbook.createSheet("Person");
        Row row=sheet.createRow(0);
        for (int i = 0; i <header.length ; i++) {
            Cell cell=row.createCell(i);
            cell.setCellValue(header[i]);
        }
        //getAll de jpa repository haciando una llamada a la base de dotos y esto regresa una lista de personas
        List<Person>listPerson= ListPerson.getAllPerson();
        int initRow=1;
        for (Person person:listPerson) {
            row=sheet.createRow(initRow);
            row.createCell(0).setCellValue(person.getId());
            row.createCell(1).setCellValue(person.getName());
            row.createCell(2).setCellValue(person.getFirstLastName());
            row.createCell(3).setCellValue(person.getSecondLastName());
            row.createCell(4).setCellValue(person.getDateBirth());
            row.createCell(5).setCellValue(person.getCurp());
            initRow++;
        }
        try {
         FileOutputStream out =new FileOutputStream(new File("E:\\Documents\\Person-whit-model.xlsx"));
         whWorkbook.write(out);
         out.close();
         whWorkbook.close();
         System.out.println("Person-whit-model.xlsx written successfully on disk.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
