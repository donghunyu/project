package project.spring.app.zcom.lib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;

public class SpreadsheetXml {

    private static final String XML_ENCODING = "UTF-8";
    private static String[][] arrChars = new String[][] {
    	                                                     {"\"", "&quot;"}, 
    	                                                     {"'" , "&apos;"}, 
    	                                                     {"<" , "&lt;"  }, 
    	                                                     {">" , "&gt;"  }, 
    	                                                     {"&" , "&amp;" } 
    	                                                  };
    
    public SpreadsheetXml() {

    }
    
    public StringBuffer beginSheet() throws Exception {
    	StringBuffer string = new StringBuffer();
    	string.append("<?xml version=\"1.0\" encoding=\""+XML_ENCODING+"\"?>\n");
    	string.append("    <worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">\n");
    	string.append("        <sheetData>\n");

        return string;
    }

    public StringBuffer endSheet() throws Exception {
    	StringBuffer string = new StringBuffer();
    	string.append("        </sheetData>\n");
    	string.append("</worksheet>\n");

    	return string;
    }

    /**
     * Insert a new row
     *
     * @param rownum 0-based row number
     */
    public StringBuffer insertRow(int rownum) throws Exception {
    	StringBuffer string = new StringBuffer();
    	string.append("            <row r=\""+(rownum+1)+"\">\n");

    	return string;
    }

    /**
     * Insert row end marker
     */
    public StringBuffer endRow() throws Exception {
    	StringBuffer string = new StringBuffer();
    	string.append("            </row>\n");

    	return string;
    }

    public StringBuffer createCell(int rownum, int columnIndex, String value, int styleIndex) throws Exception {
    	String ref = new CellReference(rownum, columnIndex).formatAsString();
    	StringBuffer string = new StringBuffer();
    	string.append("                <c r=\"" + ref + "\" t=\"inlineStr\">\n");
    	string.append("                    <is><t>" + changeSpecialChar(value) + "</t></is>\n");
    	string.append("                </c>\n");

    	return string;
    }

    public StringBuffer createCell(int rownum, int columnIndex, String value) throws Exception {
    	return createCell(rownum, columnIndex, value, -1);
    }

    public StringBuffer createCell(int rownum, int columnIndex, double value, int styleIndex) throws Exception {
    	String ref = new CellReference(rownum, columnIndex).formatAsString();
    	StringBuffer string = new StringBuffer();
    	string.append("                <c r=\"" + ref + "\" t=\"inlineStr\">\n");
    	string.append("                    <v>" + value + "</v>\n");
    	string.append("                </c>\n");

    	return string;
    }

    public StringBuffer createCell(int rownum, int columnIndex, double value) throws Exception {
    	return createCell(rownum, columnIndex, value, -1);
    }

    public StringBuffer createCell(int rownum, int columnIndex, Calendar value, int styleIndex) throws Exception {
    	return createCell(rownum, columnIndex, DateUtil.getExcelDate(value, false), styleIndex);
    }


    /**
     * Insert row end marker
     */
    public String changeSpecialChar(String value) throws Exception {
    	if ( value == null ) return "";

    	for ( int i = 0; i < 5; i++ ) {
    		value = value.replace(arrChars[i][0], arrChars[i][1]);
    	}
    	
    	return value;
    }

    
    public static void substitute(File zipfile, File tmpfile, String entry, OutputStream out) throws Exception {
        ZipFile zip = new ZipFile(zipfile);

        ZipOutputStream zos = new ZipOutputStream(out);

        @SuppressWarnings("unchecked")
        Enumeration<ZipEntry> en = (Enumeration<ZipEntry>) zip.entries();
        while (en.hasMoreElements()) {
            ZipEntry ze = en.nextElement();
            if(!ze.getName().equals(entry)){
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
	
    public static void copyStream(InputStream in, OutputStream out) throws Exception {
        byte[] chunk = new byte[1024];
        int count;
        while ((count = in.read(chunk)) >=0 ) {
          out.write(chunk,0,count);
        }
    }

	
}
