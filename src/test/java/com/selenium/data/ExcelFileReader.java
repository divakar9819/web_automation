package com.selenium.data;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Divakar Verma
 * @created_at : 13/05/2024 - 10:27 am
 * @mail_to: vermadivakar2022@gmail.com
 */
public class ExcelFileReader {

    @DataProvider(name = "testData")
    public static Object[][] getTestData() throws IOException {

        // read file
        FileInputStream file = new FileInputStream(new File("/home/divakar_verma/Documents/dummyTestData.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];

        for(int i=0;i<rowCount;i++){
            Row row = sheet.getRow(i+1);
            for(int j=0;j<colCount;j++){
                Cell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }

        file.close();
        return data;
    }


    @Test(dataProvider = "testData")
    public void login(String username, String password){
        System.out.println(username +" : "+password);
    }

}
