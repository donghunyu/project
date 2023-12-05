package project.spring.app.aprj.constants;

import java.net.InetAddress;

import project.spring.app.zcom.constants.ApplicationConstants_Zcom;

public class ApplicationConstants_Aprj extends ApplicationConstants_Zcom {

    public static final String DOMAIN                 = "http://localhost:8080/"            ;  // 도메인
//    public static final String DOMAIN                 = ":8080/project/"            ;  // 도메인
    
    
    public static final String TEMP_DIR_PATH         = "/gadian2018/IO/temp/project/"               ;  // temp
    public static final String UPLOAD_DIR_PATH       = "/gadian2018/IO/project/uploadFile/"         ;  // 파일저장경로
    public static final String UPLOAD_EXCEL_PATH     = "/gadian2018/IO/project/excel/uploadFile/"   ;  // 파일저장경로
    public static final String DOWNLOAD_EXCEL_PATH   = "/gadian2018/IO/project/excel/downloadFile/" ;  // 파일저장경로
    
    public static final String USER_AUTH_ADMIN       = "1000"      ;  // admin
    // Error 
    public static final String MESSAGE_CODE           = "msgCd";
    public static final String MESSAGE_CTT            = "msgCtt";
    public static final String MESSAGE_ERROR_CTT     = "msgError";

    public static final String RESPONSE_DATA_TYPE_HTTP  = "HTTP";  // UNIAPlus IP
    public static final String RESPONSE_DATA_TYPE_JSON  = "JSON";  // UNIAPlus IP
    public static final String RESPONSE_DATA_TYPE_XML   = "XML";   // UNIAPlus IP

    public static final String RESPONSE_TYPE            = "resTyp";  // UNIAPlus IP
    public static final String RESPONSE_DATA_TYPE       = RESPONSE_DATA_TYPE_JSON;  // UNIAPlus IP

    public static final String USER_AUTH_CD_ADMIN       = "1000";   // 사용자 권한 코드 슈퍼어드민 
    
    public static final String REQ_TYP_CD_1000       = "1000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_1001       = "1001";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_2000       = "2000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_2001       = "2001";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_3000       = "3000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_5000       = "5000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_5001       = "5001";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_6000       = "6000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_6001       = "6001";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_6002       = "6002";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_7000       = "7000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_8000       = "8000";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_8001       = "8001";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_8002       = "8002";   // 요청 종류 코드 일반 
    public static final String REQ_TYP_CD_9000       = "9000";   // 요청 종류 코드 일반 
    
    
    public static final String RES_ST_CD_1000       = "1000";   // 응답 상태 코드 
    public static final String RES_ST_CD_2000       = "2000";   // 응답 상태 코드 
    public static final String RES_ST_CD_3000       = "3000";   // 응답 상태 코드 
    public static final String RES_ST_CD_4000       = "4000";   // 응답 상태 코드 
    
    public static final String SIGN_CL_CD_1000      = "1000";   // 서명 구분 코드 
    public static final String SIGN_CL_CD_2000      = "2000";   // 서명 구분 코드 
    
    
    
    
    public static String getDomain() {
    	String domain = "http://localhost:8080/";
    	
    	try {
	    	InetAddress local = InetAddress.getLocalHost();
	    	System.out.println("Local IP : " + local.getHostAddress());//내 아이피
	
	    	if ( local.getHostAddress().equals("183.111.138.210") ) {
	    		domain = "http://gadian.kr/";
	    	}
    	} catch ( Exception e ) {
    		
    	}
    	
    	return domain;
    }
}
