package project.spring.app.zcom.lib.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil
{
    private static Locale lLocale               = Locale.KOREA;
    private static String sDateSeparator        = "-" ;
    private static String sTimeSeparator        = ":" ;
    private static String sDotSeparator         = "." ;
    private static String sHangulYearSeparator  = "년";
    private static String sHangulMonthSeparator = "월";
    private static String sHangulDaySeparator   = "일";

    private static String sDateFormat           = "yyyy" + sDateSeparator + "MM" + sDateSeparator + "dd";
    private static String sDateTimeFormat       = "yyyy" + sDateSeparator + "MM" + sDateSeparator + "dd" + " " + "HH" + sTimeSeparator + "mm" + sTimeSeparator + "ss";

    public static String sDateFormatYM          = "yyyy" + sDateSeparator + "MM";
    public static String sDateFormatYMD         = "yyyy" + sDateSeparator + "MM" + sDateSeparator + "dd";
    public static String sDateFormatYMDH        = sDateFormatYMD + " " + "HH";
    public static String sDateFormatYMDHM       = sDateFormatYMD + " " + "HH" + sTimeSeparator + "mm";
    public static String sDateFormatYMDHMS      = sDateFormatYMD + " " + "HH" + sTimeSeparator + "mm" + sTimeSeparator + "ss";
    public static String sDateFormatH           = "HH";
    public static String sDateFormatHM          = "HH" + sTimeSeparator + "mm";
    public static String sDateFormatHMS         = "HH" + sTimeSeparator + "mm" + sTimeSeparator + "ss";
    
    public static String sDateUtcFormatYMDHMSZ  = sDateFormatYMD + "'T'" + sDateFormatHMS + sDotSeparator + "SSS" + "ZZ";
    
    public static String sDateHangulFormatYM    = "yyyy" + sHangulYearSeparator + "MM" + sHangulMonthSeparator;
    public static String sDateHangulFormatYMD   = "yyyy" + sHangulYearSeparator + "MM" + sHangulMonthSeparator + "dd" + sHangulDaySeparator;
    
    public static String sDateInputFormatYM     = "yyyy" + "MM";
    public static String sDateInputFormatYMD    = "yyyy" + "MM" + "dd";
    public static String sDateInputFormatYMDH   = sDateInputFormatYMD + "HH";
    public static String sDateInputFormatYMDHM  = sDateInputFormatYMD + "HH" + "mm";
    public static String sDateInputFormatYMDHMS = sDateInputFormatYMD + "HH" + "mm" + "ss";

    private static String[] aDayOfWeek          = {"일", "월", "화", "수", "목", "금", "토"};
    
    public static String INFINITE_DT            = "99991231";
    
    public static String KOR_TIME_ZONE = "+09:00";
    public static int KOR_TIME = 9;
    
    public DateUtil() {
    }

    /**************************************************************************
    *  문자열에서 숫자값만 return
    **************************************************************************/
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


    /*****************************************************************************
    *  현재 날짜를 리턴한다.
    *****************************************************************************/
    public static String getCurrentDate(String sDateFormat) {
        Calendar cToday = Calendar.getInstance();
        SimpleDateFormat simDateFormat = new SimpleDateFormat(sDateFormat);

        return simDateFormat.format(cToday.getTime());
    }

    public static String getCurrentDate() {
        return getCurrentDate(sDateFormat);
    }

    public static String getCurrentDateTime() {
        return getCurrentDate(sDateTimeFormat);
    }

    /*****************************************************************************
     *  날짜형식 출력
     *****************************************************************************/
    public static String getDateFormat(Date dDate, String sDateFormat, Locale lLocale) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(sDateFormat, lLocale);
   	    return dateFormat.format(dDate);
    }

    public static String getDateFormat(Date dDate, String sDateFormat) {
   	    return getDateFormat(dDate, sDateFormat, lLocale);
    }
    	 
    public static String getDateFormat(Date dDate) {
   	    return getDateFormat(dDate, sDateFormat, lLocale);
    }
    	 
    public static String getDateFormat(String sDate, String sDateFormat) {
    	if ( sDate == null ) {
    		return "";
    	}
   	    return getDateFormat(getDate(sDate), sDateFormat, lLocale);
    }
    	 
    /*****************************************************************************
     *  날짜형식
     *****************************************************************************/
    public static String getDateFormat(String sDate) {
        if ( sDate == null) {
            return "";
        }

        String sReturn = "";
        String sDateInputFormat  = "";
        String sDateOutputFormat = "";

        String sTempDate = getNumber(sDate);
        if ( sTempDate.length() > 14 ) {
        	sTempDate = sTempDate.substring(0, 14);
        }

        switch (sTempDate.length())
        {
            case 6 :
            	sDateInputFormat  = sDateInputFormatYM;
            	sDateOutputFormat = sDateFormatYM;
                break;
            case 8 :
            	sDateInputFormat  = sDateInputFormatYMD;
            	sDateOutputFormat = sDateFormatYMD;
                break;
            case 10 :
            	sDateInputFormat  = sDateInputFormatYMDH;
            	sDateOutputFormat = sDateFormatYMDH;
                break;
            case 12 :
            	sDateInputFormat  = sDateInputFormatYMDHM;
            	sDateOutputFormat = sDateFormatYMDHM;
                break;
            case 14 :
            	sDateInputFormat  = sDateInputFormatYMDHMS;
            	sDateOutputFormat = sDateFormatYMDHMS;
                break;
            default :
            	sDateInputFormat  = sDateInputFormatYMD;
            	sDateOutputFormat = sDateFormatYMD;
                break;
        }

        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat(sDateInputFormat);
         	Date dDate = dateFormat.parse(sTempDate);
         	sReturn    = getDateFormat(dDate, sDateOutputFormat);
        } catch ( Exception e ) {
        	sReturn    = sDate;
        }
         
        return sReturn;
    }

    /*****************************************************************************
    *  날짜형식
    *****************************************************************************/
    public static Date getDate(String sDate) {
        String sDateInputFormat  = "";
         
        if ( sDate == null) {
            return null;
        }

        String sTempDate = getNumber(sDate);
        if ( sTempDate.length() > 14 ) {
        	sTempDate = sTempDate.substring(0, 14);
        }

        switch (sTempDate.length())
        {
            case 6 :
            	sDateInputFormat  = sDateInputFormatYM;
                break;
             case 8 :
            	sDateInputFormat  = sDateInputFormatYMD;
                break;
             case 10 :
            	sDateInputFormat  = sDateInputFormatYMDH;
                break;
             case 12 :
            	sDateInputFormat  = sDateInputFormatYMDHM;
                break;
             case 14 :
            	sDateInputFormat  = sDateInputFormatYMDHMS;
                break;
            default :
                sDateInputFormat  = sDateInputFormatYMD;
                break;
        }

        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat(sDateInputFormat);
         	return dateFormat.parse(sTempDate);
        } catch ( Exception e ) {
        	return null;
        }
    }
    
    
    /*****************************************************************************
     *  현재날짜에서 요일을 추출한다.
     *****************************************************************************/
    public static String getDayOfWeek(String sDate)
    {
      	return getDayOfWeek(getDate(sDate));
    }
      

    /*****************************************************************************
     *  현재날짜에서 요일을 추출한다.
     *****************************************************************************/
    public static String getDayOfWeek(Date dDate)
    {
    	String sReturn = "";
        try {
            Calendar cToday = Calendar.getInstance();
         	cToday.setTime(dDate);
         	
         	sReturn = aDayOfWeek[cToday.get(Calendar.DAY_OF_WEEK) - 1];
        } catch ( Exception e ) {
        	sReturn    = "";
        }
         
        return sReturn;
    }
      

   /*****************************************************************************
    *  현재날짜에서 nYear 맡큼 빼거나 더한 년 을 반환
    *****************************************************************************/
    public static String getAddYear(String sDate, int nYear)
    {
       String sReturn = "";
        try {
            Calendar cToday = Calendar.getInstance();
            Date dDate = getDate(sDate);
           
            cToday.setTime(dDate);
            cToday.add(Calendar.YEAR, nYear);
           
            return getDateFormat(cToday.getTime());
        } catch ( Exception e ) {
           sReturn    = "";
        }
        
        return sReturn;
    }
    
   /*****************************************************************************
    *  현재날짜에서 nMonth 맡큼 빼거나 더한 월 을 반환
    *****************************************************************************/
    public static String getAddMonth(String sDate, int nMonth)
    {
    	String sReturn = "";
        try {
            Calendar cToday = Calendar.getInstance();
        	 Date dDate = getDate(sDate);
        	
        	 cToday.setTime(dDate);
        	 cToday.add(Calendar.MONTH, nMonth);
        	
            return getDateFormat(cToday.getTime());
        } catch ( Exception e ) {
        	sReturn    = "";
        }
        
        return sReturn;
    }
      

   /*****************************************************************************
    *  현재날짜에서 nDay 맡큼 빼거나 더한 날짜 을 반환
    *****************************************************************************/
    public static String getAddDate(String sDate, int nDay)
    {
    	String sReturn = "";
        try {
            Calendar cToday = Calendar.getInstance();
        	  Date dDate = getDate(sDate);
        	
        	  cToday.setTime(dDate);
        	  cToday.add(Calendar.DAY_OF_MONTH, nDay);
        	
            return getDateFormat(cToday.getTime());
        } catch ( Exception e ) {
        	sReturn    = "";
        }
        
        return sReturn;
    }
       

   /*****************************************************************************
    *  현재날짜에서 nHour(시간) 맡큼 빼거나 더한 시간을 반환
    *****************************************************************************/
    public static String getAddHour(String sDate, int nHour, String sDateFormat, Locale lLocale)
    {
        String sReturn = "";
        try {
            Calendar cToday = Calendar.getInstance();
      	    Date dDate = getDate(sDate);
      	
      	    cToday.setTime(dDate);
      	    cToday.add(Calendar.HOUR_OF_DAY, nHour);
      	
            return getDateFormat(cToday.getTime(), sDateFormat, lLocale);
        } catch ( Exception e ) {
        	sReturn    = "";
        }
          
        return sReturn;
    }
       
    public static String getAddHour(String sDate, int nHour)
    {
    	return getAddHour(sDate, nHour, sDateFormat, lLocale);
    }

    public static String getAddHour(String sDate, int nHour, String sDateFormat)
    {
    	return getAddHour(sDate, nHour, sDateFormat, lLocale);
    }

   /*****************************************************************************
    *  현재날짜에서 nSec(초) 맡큼 빼거나 더한 시간을 반환
    *****************************************************************************/
    public static String getAddTms(String sDate, int nSec, String sDateFormat, Locale lLocale)
    {
        String sReturn = "";
        try {
            Calendar cToday = Calendar.getInstance();
      	    Date dDate = getDate(sDate);
      	
      	    cToday.setTime(dDate);
      	    cToday.add(Calendar.SECOND, nSec);
      	
            return getDateFormat(cToday.getTime(), sDateFormat, lLocale);
        } catch ( Exception e ) {
        	e.printStackTrace();
        	sReturn    = "";
        }
          
        return sReturn;
    }
       
    public static String getAddTms(String sDate, int nSec)
    {
    	return getAddTms(sDate, nSec, sDateFormat, lLocale);
    }

    public static String getAddTms(String sDate, int nSec, String sDateFormat)
    {
    	return getAddTms(sDate, nSec, sDateFormat, lLocale);
    }

    /**************************************************************************
    *  월의 마지막 날짜를 계산한다.
    **************************************************************************/
    public static String getLastDay(String sDate)
    {
        String[] lastday = { "31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};

        int nYear  = 0;
        int nMonth = 0;

        nYear  = Integer.parseInt(sDate.substring(0, 4));
        nMonth = Integer.parseInt(sDate.substring(4, 6));

        if((nYear%4 == 0) && (nYear%100 != 0) || (nYear%400 == 0)) {
            lastday[1] = "29";
        }

        return lastday[nMonth - 1];
    }

    /**************************************************************************
    *  UTC Format으로 변경
    **************************************************************************/
    public static String getUtcFormat(String sDate) {
        String strDtm = getNumber(sDate);
        
        if( strDtm.length() < 14 ) {
            return null;
        }
        
        DateTimeFormatter inputFormatter = DateTimeFormat.forPattern(sDateInputFormatYMDHMS);
        DateTime inputTime = inputFormatter.parseDateTime(strDtm);
        
        DateTimeFormatter outputFormatter = DateTimeFormat.forPattern(sDateUtcFormatYMDHMSZ);
        String result = outputFormatter.print(inputTime);
        
        return result;
    }
    
    /**
     * 
     * @param sDate
     * @return
     */
    public static String getCurrentUtcFormatZ() {
        return getUtcFormatZ(getCurrentDate(sDateInputFormatYMDHMS));
    }
    
    /**
     * 
     * @param sDate
     * @return
     */
    public static String getUtcFormatZ(String sDate) {
        String strDtm = getNumber(sDate);
        
        if( strDtm.length() < 14 ) {
            return null;
        }
        
        DateTimeFormatter inputFormatter = DateTimeFormat.forPattern(sDateInputFormatYMDHMS);
        DateTime inputTime = inputFormatter.parseDateTime(strDtm);
        
        DateTimeFormatter outputFormatter = DateTimeFormat.forPattern(sDateUtcFormatYMDHMSZ);
        String result = outputFormatter.print(inputTime.minus(KOR_TIME));
        
        return result.substring(0, result.indexOf("+")) + "Z";
    }
    
    /**
     * UTC Time 을 가져온다.
     * @return
     */
    public static String getUTCTime() {
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        return dateTime.toString();
    }
    
    public static String[] getTimeEntrys(int maxVal) {
        String[] entrys = new String[maxVal];
        
        for(int i = 0; i < maxVal; i++) {
            entrys[i] = StringUtil.getLpad(String.valueOf(i), "0", 2);
        }
        
        return entrys;
    }
}
