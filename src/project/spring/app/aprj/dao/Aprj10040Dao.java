/*-------------------------------------------------------------------
* NAME   : Aprj10040Dao
* DESC   : 설정_업무주기
* Author : 
* DATE   : 2018-11-07
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.dao;

import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.model.Aprj10040Model;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj10040Dao extends AprjDao {

    /**
     * 설정_업무주기검색리스트
     * @param Aprj10040Model 설정_업무주기
     * @return List<Aprj10040Model> 설정_업무주기리스트
     */
    public List<Aprj10040Model> srchAprj10040List(Aprj10040Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10040Query.selectAPRJ10040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색리스트수
     * @param Aprj10040Model 설정_업무주기
     * @return String 설정_업무주기리스트수
     */
    public String srchAprj10040Cnt(Aprj10040Model param) throws CommonException {
        try {
            return ((Aprj10040Model) sessionConn.selectOne("Aprj10040Query.selectAPRJ10040_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색
     * @param Aprj10040Model 설정_업무주기
     * @return Aprj10040Model 설정_업무주기
     */
    public Aprj10040Model srchAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return (Aprj10040Model) sessionConn.selectOne("Aprj10040Query.selectAPRJ10040_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색리스트
     * @param Aprj10040Model 설정_업무주기
     * @return List<Aprj10040Model> 설정_업무주기리스트
     */
    public File srchAprj10040ExcelList(Aprj10040Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                        ".trim());
	        map.put("coNm        ".trim(), "업체 명                        ".trim());
	        map.put("cyclId      ".trim(), "주기 ID                        ".trim());
	        map.put("cyclNm      ".trim(), "주기 명                        ".trim());
	        map.put("prdCnt      ".trim(), "기간 수                        ".trim());
	        map.put("cyclClCd    ".trim(), "주기 구분 코드                 ".trim());
	        map.put("cyclClNm    ".trim(), "주기 구분 명                   ".trim());
	        map.put("stdDt       ".trim(), "기준 일자                      ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "업무주기_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj10040Query.selectAPRJ10040_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 설정_업무주기입력
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기입력수
     */
    public int insertAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10040Query.insertAPRJ10040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기입력
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기입력수
     */
    public int insertAprj10040Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10040Query.insertAPRJ10040_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기수정
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기수정수
     */
    public int updateAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10040Query.updateAPRJ10040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기삭제
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기삭제수
     */
    public int deleteAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10040Query.deleteAPRJ10040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기삭제
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기삭제수
     */
    public int deleteAprj10040All() throws CommonException {
        try {
            return sessionConn.update("Aprj10040Query.deleteAPRJ10040_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기삭제
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기삭제수
     */
    public int deleteAprj10040Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10040Query.deleteAPRJ10040_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}