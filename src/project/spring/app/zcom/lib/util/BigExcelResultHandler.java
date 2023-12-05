package project.spring.app.zcom.lib.util;



import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class BigExcelResultHandler implements ResultHandler {
    private int                           rowNum;
    private int                           totalDataCount;
    private int                           sheetNum;
    
    private XSSFWorkbook                  workbook;
    private XSSFSheet                     sheet;
    private LinkedHashMap<String, String> excelMap;
    
    private int                           maxRowCountPerSheet;
    
    // 엑셀 파일 작성 객체.
    private SpreadsheetWriter             shWriter;
    private Map<String, XSSFCellStyle>    styles;
    
    public BigExcelResultHandler(XSSFWorkbook workbook, Map<String, XSSFCellStyle> wbStyle, SpreadsheetWriter shWriter) {
        this.workbook = workbook;
        this.shWriter = shWriter;
        
        this.styles = wbStyle;
        
        init(0);
    }
    
    public BigExcelResultHandler(XSSFWorkbook workbook, Map<String, XSSFCellStyle> wbStyle, SpreadsheetWriter shWriter, LinkedHashMap<String, String> sheetMap, boolean isTitle) {
        this.workbook = workbook;
        this.shWriter = shWriter;
        
        this.styles = wbStyle;
        
        init(0);
        
        setExcelMap(sheetMap);
        
        if (isTitle) {
        	createSheetTiles();
        }
    }
    
    public BigExcelResultHandler(XSSFWorkbook workbook, Map<String, XSSFCellStyle> wbStyle, SpreadsheetWriter shWriter, int maxRowCountPerSheet) {
        this.workbook = workbook;
        this.shWriter = shWriter;
        
        this.styles = wbStyle;
        
        init(maxRowCountPerSheet);
    }
    
    private void init(int maxRowCountPerSheet) {
        this.rowNum = 0;
        this.sheetNum = 1;
        this.excelMap = new LinkedHashMap<String, String>();
        this.excelMap = generateExcelMap();
        this.maxRowCountPerSheet = maxRowCountPerSheet;
    }
    
    @Override
    public void handleResult(ResultContext context) {
    	@SuppressWarnings("rawtypes")
		Map dataMap = (Map) context.getResultObject();
    	addRow(dataMap);
    }
    
    /**
     * title row 작성.
     * 
     * @param wb
     * @param excelMap
     * @return
     */
	private void createSheetTiles() {
		if (this.styles == null) {
			addRow(this.excelMap, null);
		} else {
			addRow(this.excelMap, this.styles.get("header"));
		}
    }
    
    @SuppressWarnings("rawtypes")
    private void addRow(Map dataMap) throws RuntimeException {
        addRow(dataMap, null);
    }
    
    @SuppressWarnings("rawtypes")
    private void addRow(Map dataMap, XSSFCellStyle cellStyle) throws RuntimeException {
        Iterator keyData = this.excelMap.keySet().iterator();
        int i = 0;
        try {
            this.shWriter.insertRow(this.rowNum);
            
            while (keyData.hasNext()) {
                String key = (String) keyData.next();
                String value = dataMap.get(key) == null ? "" : dataMap.get(key).toString();
                
                value = StringUtil.nullToStr(value, "");
                
                if (cellStyle != null) {
                    this.shWriter.createCell(i, value, cellStyle.getIndex());
                } else {
                    if (dataMap.get(key) instanceof String) {
                        this.shWriter.createCell(i, value); //, this.styles.get("dataString").getIndex());
                    } else if (dataMap.get(key) instanceof BigDecimal) {
                        this.shWriter.createCell(i, Double.valueOf(value)); //, this.styles.get("dataNumber").getIndex());
                    } else {
                        this.shWriter.createCell(i, value); //, this.styles.get("dataString").getIndex());
                    }
                }
                
                i++;
            }
            this.shWriter.endRow();
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        // data count 증가.
        this.totalDataCount++;
        
        this.rowNum++;
    }
    
    public LinkedHashMap<String, String> generateExcelMap() {
    	return null;
    }
    
    public XSSFWorkbook getWorkbook() {
        return workbook;
    }
    
    protected LinkedHashMap<String, String> getExcelMap() {
        return excelMap;
    }
    
    protected void setExcelMap(LinkedHashMap<String, String> excelMap) {
        this.excelMap = excelMap;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getTotalDataCount() {
        return totalDataCount;
    }

    public void setTotalDataCount(int totalDataCount) {
        this.totalDataCount = totalDataCount;
    }

    public int getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
    }

    public int getMaxRowCountPerSheet() {
        return maxRowCountPerSheet;
    }

    public void setMaxRowCountPerSheet(int maxRowCountPerSheet) {
        this.maxRowCountPerSheet = maxRowCountPerSheet;
    }
}
