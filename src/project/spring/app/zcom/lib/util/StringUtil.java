package project.spring.app.zcom.lib.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class StringUtil
{
    public StringUtil() {
    }

    /**************************************************************************
    *  Null값을 Default값으로 변경
    **************************************************************************/
    public static String nullToStr(Object object, String sDefault)
    {
        if ( object == null ) {
            return sDefault;
        }
        return object.toString();
    }

    public static String nullToStr(String sString, String sDefault)
    {
        if ( sString == null || sString.equals("null") ) {
            return sDefault;
        }
        return sString;
    }

    public static String nullToStr(String sString)
    {
        return nullToStr(sString, "");
    }

    public static int nullToInt(String sString, int nDefault)
    {
        int nReturn = nDefault;
      
        try { 
            nReturn = Integer.parseInt(sString.trim());
        } catch ( Exception e ) {
        }
        
        return nReturn;
    }

    public static int nullToInt(String sString)
    {
        return nullToInt(sString, 0);
    }

    /**************************************************************************
    *  Null값을 Default값으로 변경
    **************************************************************************/
    public static boolean isNull(Object object)
    {
        if ( object == null ) {
            return true;
        }
        
        if ( "".equals(object) ) {
            return true;
        }
        
        return false;
    }

    /**************************************************************************
    *  문자열에서 숫자값만 return
    **************************************************************************/
    public static String getNumeric(String sString)
    {
        return getNumber(sString, "-.");
    }

    public static String getNumber(String sString)
    {
        return getNumber(sString, "");
    }

    public static String getNumber(String sString, String sAddString)
    {
        String sReturn = "";
        String sNumber = "0123456789" + sAddString;

        if ( sString == null ) { return sReturn; }

        for (int i = 0; i < sString.length(); i++ ) {
            if ( sNumber.indexOf(sString.charAt(i)) > -1 ) {
                sReturn = sReturn + sString.charAt(i);
            }
        }
        return sReturn;
    }


    /**************************************************************************
    *  숫자에 세자리마다 쉼표를 찍는다.
    **************************************************************************/
    public static String getNumFormat(double dNumber)
    {
        NumberFormat  numFormat = NumberFormat.getCurrencyInstance();
        DecimalFormat decFormat = (DecimalFormat) numFormat;

        String pattern = "";

        if ( ( dNumber % 1 ) == 0 ) {
            pattern = "###,###,###,##0";
        } else {
            pattern = "###,###,###,##0.##";
        }

        decFormat.applyPattern(pattern);
        return decFormat.format(dNumber);
    }

    public static String getNumFormat(String sString)
    {
        try
        {
            double dNumber = Double.parseDouble(sString);
            return getNumFormat(dNumber);
        }
        catch (NumberFormatException ex)
        {
            return "0";
        }
    }

    public static String getFloatFormat(float value)
    {
    	return getFloatFormat(Float.toString(value));
    }
    
    public static String getFloatFormat(String sString)
    {
        try
        {
            double dNumber = Double.parseDouble(sString);

            NumberFormat  numFormat = NumberFormat.getCurrencyInstance();
            DecimalFormat decFormat = (DecimalFormat) numFormat;

            String pattern = "";
            pattern = "###,###,###,##0";

            decFormat.applyPattern(pattern);
            return decFormat.format(dNumber);
        }
        catch (NumberFormatException ex)
        {
            return "0";
        }
    }

    /*****************************************************************************
    *  split
    *****************************************************************************/
    public static ArrayList<String> splitArray(String str, String separatorChar) {
        String[] arrayStr = StringUtils.split(str, separatorChar);
        ArrayList<String> listStr = new ArrayList<String>();
        
        for ( int i = 0; i < arrayStr.length; i++ ) {
        	if ( arrayStr[i].trim().length() == 0 ) {
        		continue;
        	}
        	
        	listStr.add(arrayStr[i].trim());
        }

        return listStr;
    }
    

    public static String[] split(String sString, String regex) {
    	
    	ArrayList<String> array = new ArrayList<String>();
    	
    	if ( sString == null ) {
    		sString = "";
    	}
    	
    	int nLoc = -1;
    	int nLen = regex.length();
    	while ( true ) {
    		nLoc = sString.indexOf(regex);
    		if ( nLoc < 0 ) {
    			array.add(sString);
    			break;
    		}
    		
    		array.add(sString.substring(0, nLoc).trim());
    		sString = sString.substring(nLoc + nLen);
    	}
    	
    	return (String[]) array.toArray();
    }
    /**************************************************************************
    *  숫자 한글로 읽기
    **************************************************************************/
    public static String getKorPrice(String sContractAmt) {
        String[] units = {"십", "백", "천", "만", "십", "백", "천", "억", "십", "백", "천", "조", "십", "백", "천" };
        String[] numStr = { "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
        int numSize = sContractAmt.length();

        String amtStr = "";

        for (int i = 0; i < numSize; i++) {
            int aa = sContractAmt.charAt(i) - '0';

            if ( aa == 0 ) {
               if ( (numSize -2 - i) % 4 == 3 ) {
                  amtStr += units[numSize -2 - i];
               }

               continue;
            }

            if ( i == numSize - 1 ) {
                amtStr += numStr[aa - 1];
            } else {
                amtStr += numStr[aa - 1] + units[numSize - 2 - i];
            }

            if (i-1 != numSize) {
              amtStr += " ";
            }
        }
        return amtStr;
    }
     
     
    /*****************************************************************************
    *  원하는 문자열 길이 만큼
    *****************************************************************************/
    public static String getMaxLengthMore(String sStr, int nLen) {
    	   
        if ( sStr == null ) {
     		return "";
     	}
     	
        String sReturnStr = sStr;
        int    nCount     = 0;                // 단위 문장 길이
        
        try {
            for (int i = 0; i < sStr.length(); i++) {
            	nCount = nCount + sStr.substring(i, i + 1).getBytes("UTF-8").length;
  
                if (nCount > nLen) {
                    sReturnStr = sStr.substring(0, i) + "...";
                    break;
                }
            }
        } catch (Exception e) {

        } 

        sReturnStr = sReturnStr.replace('\n', '\0');
        sReturnStr = sReturnStr.replace('\r', '\0');
        return sReturnStr;
    }
     
     
    /*****************************************************************************
    *  증가함수
    *****************************************************************************/
    public static String getIncreaseValue(String sSource, String sHead, int nLength) {
        try {
	 		int nInc = Integer.parseInt(sSource.substring(sHead.length())) + 1;
	 		return sHead + getLpad(nInc + "", "0", nLength - sHead.length());
	 	} catch ( Exception e) {
	 		return sHead + getLpad("1", "0", nLength - sHead.length());
	 	}
    }
    
    
    /*****************************************************************************
    *  LPAD
    *****************************************************************************/
    public static String getLpad(String sSource, String inString, int nLength) {
     	String sReturn = "";
      	 
      	if ( sSource == null ) {
      		sReturn = "";
      	} else {
      		sReturn = sSource;
      	}
      	 
     	int nCount = sReturn.length();
      	for ( int i = nCount; i < nLength; i++ ) {
      		sReturn = inString + sReturn;

         	if ( sReturn.length() > nLength ) {
         		sReturn = sReturn.substring(sReturn.length() - nLength);
          	}
      	}
      	
      	return sReturn;
    }

    
    /*****************************************************************************
    *  RPAD
    *****************************************************************************/
    public static String getRpad(String sSource, String inString, int nLength) {
     	String sReturn = "";
      	 
      	if ( sSource == null ) {
      		sReturn = "";
      	} else {
      		sReturn = sSource;
      	}
      	 
     	int nCount = sReturn.length();
      	for ( int i = nCount; i < nLength; i++ ) {
      		sReturn = sReturn + inString;
      		
         	if ( sReturn.length() > nLength ) {
         		sReturn = sReturn.substring(sReturn.length() - nLength);
          	}
      	}
      	
      	return sReturn;
    }


    /*****************************************************************************
    *  List 합치기
    *****************************************************************************/
    public static List<Object> addList(List<Object> arrayTarger, List<Object> arrayAttact) {
      	if ( arrayTarger == null ) {
      		return arrayAttact;
      	}
      	if ( arrayAttact == null ) {
      		return arrayTarger;
      	}
      	 
      	for ( int i = 0; i < arrayAttact.size(); i++ ) {
      		arrayTarger.add(arrayAttact.get(i));
      	}
      	
      	return arrayTarger;
    }
    
    
    /*****************************************************************************
     *  BASE64, URL 인코딩하기
     *****************************************************************************/
    public static String encCharset(String value, String fromCharset, String toCharset) throws Exception {
    	if ( value == null ) { return ""; }
    	return new String(value.getBytes(fromCharset), toCharset);
    }
    

    /**************************************************************************
     *  Length만큼 빈 공간을 채워 리턴
     **************************************************************************/
    public static String getLenString(String sStr) {
    	int nDefaultLength = 24;
    	return getLenString(sStr, nDefaultLength);
    }

    public static String getLenString(String sStr, int nCount) {
         if ( sStr == null ) { sStr = ""; }
         int nLen = nCount - sStr.length();

         for ( int i = 0; i < nLen; i++ ) {
             sStr = sStr + " ";
         }
         
         return sStr;
    }
    
    public static String toHtmlFormat(String szSRC ) {

        if(szSRC == null || "".equals(szSRC) )
            return "" ;

        String sRtn = "";
        
        szSRC = szSRC.replaceAll("&"    ,"&amp;"                    );
        szSRC = szSRC.replaceAll("<"    ,"&lt;"                     );
        szSRC = szSRC.replaceAll(">"    ,"&gt;"                     );
        szSRC = szSRC.replaceAll(" "    ,"&nbsp;"                   );
        szSRC = szSRC.replaceAll("\""   ,"&quot;"                   );
        szSRC = szSRC.replaceAll("\'"   ,"&#39;"                    );
        szSRC = szSRC.replaceAll("\t"   ,"&nbsp;&nbsp;&nbsp;&nbsp;" );
        szSRC = szSRC.replaceAll("\r\n" ,"<br/>"                    );
        szSRC = szSRC.replaceAll("\n"   ,"<br/>"                    );
        
        sRtn  = szSRC;
        
        return sRtn ;
    }


    /*****************************************************************************
     *  Format
     *****************************************************************************/
    public static String getMaskFormat(String str, String mask, int[] len) {
    	if ( str == null ) return "";
    	
    	String temp   = str;
    	String result = "";
    	
    	for ( int i = 0; i < len.length; i++ )  {
    		if ( temp.length() <= len[i] ) {
    			result = result + temp;
    			break;
    		}
    		
    		result = result + temp.substring(0, len[i]) + mask;
    		temp   = temp.substring(len[i]);
    	}
    	
    	return result;
    }
    
    public static String getBizNum(String str) {
    	String mask = "-";
    	int[] len   = {3, 2, 5};
    	return getMaskFormat(str, mask, len);
    }
    
    public static String getPrintStackTrace(Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
}
