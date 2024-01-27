package org.example;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.*;

public class PrimeNumberProcesser {

    //logger as out method at the end
    private static final Logger logger = LogManager.getLogger(PrimeNumberProcesser.class);

    public static List excelData = new ArrayList();

    //import and saving all data to the List "excelData" for next processing
    public static void importExcel(String path) {
        try
            (FileInputStream importedData = new FileInputStream(path);

            Workbook workbook = new XSSFWorkbook(importedData)) {

            Sheet sheet = workbook.getSheetAt(0);

            int columnIndex = 1;

            for (Row row : sheet) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    excelData.add(cell.toString());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
    }
    }

    public static List<Integer> sortedExcelData = new ArrayList();

        /*Sorting data - ignoring invalid and getting valid data for next processing.
    Allowed to add are objects, which could be transformed to positive numbers (only numbers without illegal character), greater
    than 1, without decimal point and white-spaces around.
    */
    public static void sortExcelData() {
        for (Object valid : excelData) {

            String trimmedData = valid.toString().trim();

            if (NumberUtils.isCreatable(trimmedData) && NumberUtils.isParsable(trimmedData)) {
                int isNumber = NumberUtils.createNumber(trimmedData).intValue();

                if (isNumber > 1) {
                    sortedExcelData.add(isNumber);
                }
            }
        }
    }


    public static List<Integer> primeNumbers = new ArrayList();

    //get only prime numbers to the final List "primeNumbers" (using method "isPrimeNumber" during iteration)
    public static void notePrimeNumber() {
        for (Integer candidate : sortedExcelData) {
            if (isPrimeNumber(candidate)) {
                primeNumbers.add(candidate);
            }
        }
    }

    //if number is prime number = true and could be use for next step (method for "for" above)
    public static boolean isPrimeNumber(int testedNumber) {
        for (int i = 2; i <= Math.sqrt(testedNumber); i++) {
            if (testedNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    //write all prime numbers by logger
    public static void generateData() {
        for (int generate : primeNumbers) {
            logger.info(generate);
        }
    }

}

