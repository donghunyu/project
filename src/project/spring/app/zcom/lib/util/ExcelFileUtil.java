package project.spring.app.zcom.lib.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
    
    /*****************************************************************************
    *  Sheet 생성
    *****************************************************************************/
    public static Sheet getSheet(String filePath) {
    	
        File excelFile = new File(filePath);
        
        Sheet sheet = null;
        
        try {
            // 엑셀 2003
            HSSFWorkbook metabook = new HSSFWorkbook(new FileInputStream(excelFile));
            sheet = ((HSSFWorkbook) metabook).getSheetAt(0);
        } catch (Exception e) {
            //e.printStackTrace();
            try {
                // 엑셀 2007
                XSSFWorkbook metabook = new XSSFWorkbook(new FileInputStream(excelFile));
                sheet = ((XSSFWorkbook) metabook).getSheetAt(0);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        
        return sheet;
    }

    /*****************************************************************************
     *  Sheet 생성
     *****************************************************************************/
    public static HSSFSheet getHSSFsheet(String filePath) throws IOException {
        File excelFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(excelFile);
        
        try {
            HSSFWorkbook metabook = new HSSFWorkbook(inputStream);
            return metabook.getSheetAt(0);
        } catch (Exception e1) {
            if( inputStream != null ) {
                inputStream.close();
            }
        }
        
        return null;
    }
    
    /*****************************************************************************
     *  Sheet 생성
     *****************************************************************************/
    public static XSSFSheet getXSSFsheet(String filePath) throws IOException {
        File excelFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(excelFile);
        
        try {
            XSSFWorkbook metabook = new XSSFWorkbook(inputStream);
            return metabook.getSheetAt(0);
        } catch (Exception e) {
            if( inputStream != null ) {
                inputStream.close();
            }
        }
        
        return null;
    }
    
    /*****************************************************************************
    *  Cell 값
    *****************************************************************************/
    public static String getCell(Cell cell) {
        String value = "";
        
        if ( cell == null ) {
        	return value;
        }
        
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            DecimalFormat decimalFormat = new DecimalFormat("###############.##");
            value = decimalFormat.format(cell.getNumericCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            value = cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            value = cell.getCellFormula();
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            value = "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            value = cell.getBooleanCellValue() + "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            value = "";
        }
        
        return value;
    }
    
    /*****************************************************************************
    *  Cell 값
    *****************************************************************************/
    public static String getCell(Row row, int cellNum) {
        return getCell(row.getCell(cellNum));
    }
    
    
    /*****************************************************************************
    *  Cell 값(날짜)
    *****************************************************************************/
    public static String getCellDate(Cell cell, String format) {
        String value = "";
        
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            value = sdf.format(cell.getDateCellValue());
        }
        
        return value;
    }
}
