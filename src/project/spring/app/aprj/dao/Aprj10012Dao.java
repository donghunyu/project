/*-------------------------------------------------------------------
* NAME   : Aprj10012Dao
* DESC   : 설정_자산
* Author : 
* DATE   : 2019-01-18
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
import project.spring.app.aprj.model.Aprj10010Model;
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
public class Aprj10012Dao extends AprjDao {

    /**
     * 설정_자산검색리스트
     * @param Aprj10010Model 설정_자산
     * @return List<Aprj10010Model> 설정_자산리스트
     */
    public List<Aprj10010Model> srchAprj10012List(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10012Query.selectAPRJ10012_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산검색리스트수
     * @param Aprj10010Model 설정_자산
     * @return String 설정_자산리스트수
     */
    public String srchAprj10012Cnt(Aprj10010Model param) throws CommonException {
        try {
            return ((Aprj10010Model) sessionConn.selectOne("Aprj10012Query.selectAPRJ10012_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산검색
     * @param Aprj10010Model 설정_자산
     * @return Aprj10010Model 설정_자산
     */
    public Aprj10010Model srchAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return (Aprj10010Model) sessionConn.selectOne("Aprj10012Query.selectAPRJ10012_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색리스트
     * @param Aprj10040Model 설정_업무주기
     * @return List<Aprj10040Model> 설정_업무주기리스트
     */
    public File srchAprj10012ExcelList(Aprj10010Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                        ".trim());
	        map.put("coNm        ".trim(), "업체 명                        ".trim());
	        map.put("astId       ".trim(), "자산 ID                     ".trim());
	        map.put("astNm       ".trim(), "자산 명                     ".trim());
	        map.put("astCtt      ".trim(), "자산 내용                   ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "자산_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj10012Query.selectAPRJ10012_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 설정_자산입력
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산입력수
     */
    public int insertAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10012Query.insertAPRJ10012_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산입력
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산입력수
     */
    public int insertAprj10012Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10012Query.insertAPRJ10012_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산수정
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산수정수
     */
    public int updateAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10012Query.updateAPRJ10012_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산삭제
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산삭제수
     */
    public int deleteAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10012Query.deleteAPRJ10012_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 설정_자산삭제
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산삭제수
     */
    public int deleteAprj10012All() throws CommonException {
        try {
            return sessionConn.update("Aprj10012Query.deleteAPRJ10012_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 설정_자산삭제
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산삭제수
     */
    public int deleteAprj10012Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10012Query.deleteAPRJ10012_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}