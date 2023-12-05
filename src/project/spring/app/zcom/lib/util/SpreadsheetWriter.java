package project.spring.app.zcom.lib.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadsheetWriter {
	private final Writer _out;
	private int _rownum;
    private String[][] arrChars = new String[][] {
        {"\"", "&quot;"}, 
        {"'" , "&apos;"}, 
        {"<" , "&lt;"  }, 
        {">" , "&gt;"  }, 
        {"&" , "&amp;" } 
    };

	public SpreadsheetWriter(Writer out) {
		this._out = out;
	}

	public void beginSheet() throws IOException {
		this._out
				.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?><worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">");

		this._out.write("<sheetData>\n");
	}

	public void endSheet() throws IOException {
		this._out.write("</sheetData>");
		this._out.write("</worksheet>");
	}

	public void insertRow(int rownum) throws IOException {
		this._out.write("<row r=\"" + (rownum + 1) + "\">\n");
		this._rownum = rownum;
	}

	public void endRow() throws IOException {
		this._out.write("</row>\n");
	}

	public void createCell(int columnIndex, String value, int styleIndex)
			throws Exception {
		String ref = new CellReference(this._rownum, columnIndex)
				.formatAsString();
		this._out.write("<c r=\"" + ref + "\" t=\"inlineStr\"");
		if (styleIndex != -1)
			this._out.write(" s=\"" + styleIndex + "\"");
		this._out.write(">");
		this._out.write("<is><t>" + changeSpecialChar(value) + "</t></is>");
		this._out.write("</c>");
	}

	public void createCell(int columnIndex, String value)
			throws Exception {
		createCell(columnIndex, value, -1);
	}

	public void createCell(int columnIndex, double value, int styleIndex)
			throws IOException {
		String ref = new CellReference(this._rownum, columnIndex)
				.formatAsString();
		this._out.write("<c r=\"" + ref + "\" t=\"n\"");
		if (styleIndex != -1)
			this._out.write(" s=\"" + styleIndex + "\"");
		this._out.write(">");
		this._out.write("<v>" + value + "</v>");
		this._out.write("</c>");
	}

	public void createCell(int columnIndex, double value)
			throws IOException {
		createCell(columnIndex, value, -1);
	}

	public void createCell(int columnIndex, Calendar value, int styleIndex)
			throws IOException {
		createCell(columnIndex, org.apache.poi.ss.usermodel.DateUtil.getExcelDate(value, false),
				styleIndex);
	}
	
    private String changeSpecialChar(String value) throws Exception {
    	if ( value == null ) return "";

    	for ( int i = 0; i < 5; i++ ) {
    		value = value.replace(arrChars[i][0], arrChars[i][1]);
    	}
    	
    	return value;
    }
    
    /**
     * 
     * @param zipfile
     *            the template file
     * @param tmpfile
     *            the XML file with the sheet data
     * @param entry
     *            the name of the sheet entry to substitute, e.g.
     *            xl/worksheets/sheet1.xml
     * @param out
     *            the stream to write the result to
     */
    public void substitute(File zipfile, File tmpfile, String entry, OutputStream out) throws IOException {
        ZipFile zip = new ZipFile(zipfile);
        
        ZipOutputStream zos = new ZipOutputStream(out);
        
        @SuppressWarnings("unchecked")
        Enumeration<ZipEntry> en = (Enumeration<ZipEntry>) zip.entries();
        while (en.hasMoreElements()) {
            ZipEntry ze = en.nextElement();
            if (!ze.getName().equals(entry)) {
                zos.putNextEntry(new ZipEntry(ze.getName()));
                InputStream is = zip.getInputStream(ze);
                copyStream(is, zos);
                is.close();
            }
        }
        zos.putNextEntry(new ZipEntry(entry));
        InputStream is = new FileInputStream(tmpfile);
        copyStream(is, zos);
        is.close();
        
        zip.close();
        zos.close();
    }
    
    private void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] chunk = new byte[1024];
        int count;
        while ((count = in.read(chunk)) >= 0) {
            out.write(chunk, 0, count);
        }
    }
    
    /**
     * 
     * @param wb
     * @return
     */
    public Map<String, XSSFCellStyle> createStyles(XSSFWorkbook wb) {
        Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();
        XSSFDataFormat fmt = wb.createDataFormat();
        
        /*
         * XSSFCellStyle style1 = wb.createCellStyle();
         * style1.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
         * style1.setDataFormat(fmt.getFormat("0.0%")); styles.put("percent",
         * style1);
         * 
         * XSSFCellStyle style2 = wb.createCellStyle();
         * style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
         * style2.setDataFormat(fmt.getFormat("0.0X")); styles.put("coeff",
         * style2);
         * 
         * XSSFCellStyle style3 = wb.createCellStyle();
         * style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
         * style3.setDataFormat(fmt.getFormat("$#,##0.00"));
         * styles.put("currency", style3);
         * 
         * XSSFCellStyle style4 = wb.createCellStyle();
         * style4.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
         * style4.setDataFormat(fmt.getFormat("mmm dd")); styles.put("date",
         * style4);
         */
        
        XSSFCellStyle style5 = wb.createCellStyle();
        XSSFFont font5 = wb.createFont();
        font5.setBold(true);
        font5.setFontHeight(9);
        style5.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style5.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style5.setBorderRight(XSSFCellStyle.BORDER_THIN); // 테두리 설정
        style5.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style5.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style5.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style5.setFont(font5);
        styles.put("header", style5);
        
        XSSFCellStyle style1 = wb.createCellStyle();
        XSSFFont font1 = wb.createFont();
        font1.setFontHeight(9);
        style1.setBorderRight(XSSFCellStyle.BORDER_THIN); // 테두리 설정
        style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style1.setFont(font1);
        styles.put("dataString", style1);
        
        XSSFCellStyle style2 = wb.createCellStyle();
        XSSFFont font2 = wb.createFont();
        font2.setFontHeight(9);
        style2.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style2.setBorderRight(XSSFCellStyle.BORDER_THIN); // 테두리 설정
        style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style2.setFont(font2);
        style2.setDataFormat(fmt.getFormat("###,###,###"));
        styles.put("dataNumber", style2);
        
        return styles;
    }
}
