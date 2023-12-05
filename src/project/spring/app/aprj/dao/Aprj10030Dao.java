/*-------------------------------------------------------------------
* NAME   : Aprj10030Dao
* DESC   : 설정_결제
* Author : 
* DATE   : 2018-11-08
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.dao;

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj10030Dao extends AprjDao {

    /**
     * 설정_결제검색리스트
     * @param Aprj10030Model 설정_결제
     * @return List<Aprj10030Model> 설정_결제리스트
     */
    public List<Aprj10030Model> srchAprj10030List(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10030Query.selectAPRJ10030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제검색리스트수
     * @param Aprj10030Model 설정_결제
     * @return String 설정_결제리스트수
     */
    public String srchAprj10030Cnt(Aprj10030Model param) throws CommonException {
        try {
            return ((Aprj10030Model) sessionConn.selectOne("Aprj10030Query.selectAPRJ10030_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제검색
     * @param Aprj10030Model 설정_결제
     * @return Aprj10030Model 설정_결제
     */
    public Aprj10030Model srchAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return (Aprj10030Model) sessionConn.selectOne("Aprj10030Query.selectAPRJ10030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제검색리스트
     * @param Aprj10030Model 설정_결제
     * @return List<Aprj10030Model> 설정_결제리스트
     */
    public List<Aprj10030Model> srchAprj10030ExcelList(Aprj10030Model param) throws CommonException {
        try {
        	/*
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                        ".trim());
	        map.put("coNm        ".trim(), "업체 명                        ".trim());
	        map.put("stmId       ".trim(), "결제 ID                        ".trim());
	        map.put("stmNm       ".trim(), "결제 명                        ".trim());
	        map.put("stmCtt      ".trim(), "결제 내용                      ".trim());
	        
	        map.put("stmSerNum   ".trim(), "결제 일련번호                  ".trim());
	        map.put("stmClCd     ".trim(), "결제 구분 코드                 ".trim());
	        map.put("stmClNm     ".trim(), "결제 구분 명                   ".trim());
	        map.put("stmAuthCd   ".trim(), "결제 권한 코드                 ".trim());
	        map.put("stmAuthNm   ".trim(), "결제 권한 명                   ".trim());
	        map.put("opChrgId    ".trim(), "업무 담당 ID                   ".trim());
	        map.put("opChrgNm    ".trim(), "업무 담당 명                   ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "결제라인_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj10030Query.selectAPRJ10030_10", param, map, realUploadPath, fileName, true);
            */
            return sessionConn.selectList("Aprj10030Query.selectAPRJ10030_10", param);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 설정_결제입력
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제입력수
     */
    public int insertAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10030Query.insertAPRJ10030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제입력
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제입력수
     */
    public int insertAprj10030Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10030Query.insertAPRJ10030_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제수정
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제수정수
     */
    public int updateAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10030Query.updateAPRJ10030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제삭제
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제삭제수
     */
    public int deleteAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10030Query.deleteAPRJ10030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제삭제
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제삭제수
     */
    public int deleteAprj10030All() throws CommonException {
        try {
            return sessionConn.update("Aprj10030Query.deleteAPRJ10030_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제삭제
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제삭제수
     */
    public int deleteAprj10030Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10030Query.deleteAPRJ10030_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}