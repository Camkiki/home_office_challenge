package services;

import model.VehicleDetails;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tolaf on 02/05/2018.
 */
public class VehicleDetailsService {


    //    this method is for reading an excel file using POI API
    public List<VehicleDetails> readExcelFile(String fileName) {
        List<VehicleDetails> vehicleList = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream(fileName);
            try {
                Workbook workbook = new XSSFWorkbook(excelFile);
                Sheet datatypeSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = datatypeSheet.iterator();
                iterator.next();
                while (iterator.hasNext()) {
                    VehicleDetails vehicleDetails = new VehicleDetails();
                    Row currentRow = iterator.next();
                    vehicleDetails.setRegistrationNumber(currentRow.getCell(0).getStringCellValue());
                    vehicleDetails.setMake(currentRow.getCell(1).getStringCellValue());
                    vehicleDetails.setColour(currentRow.getCell(2).getStringCellValue());
                    vehicleList.add(vehicleDetails);
                }
            } finally {
                excelFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }
}
