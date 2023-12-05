/*-------------------------------------------------------------------
* NAME   : Aprj20010Dao
* DESC   : 프로젝트_프로젝트
* Author : 
* DATE   : 2018-11-16
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
import project.spring.app.aprj.model.Aprj20010Model;
import project.spring.app.aprj.model.Aprj20030Model;
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
public class Aprj20010Dao extends AprjDao {

    /**
     * 프로젝트_프로젝트검색리스트
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return List<Aprj20010Model> 프로젝트_프로젝트리스트
     */
    public List<Aprj20010Model> srchAprj20010List(Aprj20010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20010Query.selectAPRJ20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트검색리스트수
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return String 프로젝트_프로젝트리스트수
     */
    public String srchAprj20010Cnt(Aprj20010Model param) throws CommonException {
        try {
            return ((Aprj20010Model) sessionConn.selectOne("Aprj20010Query.selectAPRJ20010_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트검색리스트
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return List<Aprj20010Model> 프로젝트_프로젝트리스트
     */
    public File srchAprj20010ExcelList(Aprj20010Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                        ".trim());
	        map.put("coNm        ".trim(), "업체 명                        ".trim());
	        map.put("prjId       ".trim(), "프로젝트 ID                    ".trim());
	        map.put("prjNm       ".trim(), "프로젝트 명                    ".trim());
	        map.put("prjCtt      ".trim(), "프로젝트 내용                  ".trim());
	
	        map.put("ctrlNum     ".trim(), "통제 번호                      ".trim());
	        map.put("ctrlNm      ".trim(), "통제 명                        ".trim());
	        map.put("ctrlCtt     ".trim(), "통제 내용                      ".trim());
	        
	        map.put("astClId     ".trim(), "자산구분 ID                    ".trim());
	        map.put("astClNm     ".trim(), "자산구분 명                    ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "프로젝트_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj20010Query.selectAPRJ20010_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 프로젝트_프로젝트검색
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return Aprj20010Model 프로젝트_프로젝트
     */
    public Aprj20010Model srchAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return (Aprj20010Model) sessionConn.selectOne("Aprj20010Query.selectAPRJ20010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트입력
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트입력수
     */
    public int insertAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20010Query.insertAPRJ20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트입력
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트입력수
     */
    public int insertAprj20010Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20010Query.insertAPRJ20010_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트수정
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트수정수
     */
    public int updateAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20010Query.updateAPRJ20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트삭제
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트삭제수
     */
    public int deleteAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20010Query.deleteAPRJ20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트삭제
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트삭제수
     */
    public int deleteAprj20010All() throws CommonException {
        try {
            return sessionConn.update("Aprj20010Query.deleteAPRJ20010_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트삭제
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트삭제수
     */
    public int deleteAprj20010Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20010Query.deleteAPRJ20010_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}