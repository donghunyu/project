/*-------------------------------------------------------------------
* NAME   : Aprj10020Dao
* DESC   : 설정_업무담당
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
import project.spring.app.aprj.model.Aprj10020Model;
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
public class Aprj10020Dao extends AprjDao {

    /**
     * 설정_업무담당검색리스트
     * @param Aprj10020Model 설정_업무담당
     * @return List<Aprj10020Model> 설정_업무담당리스트
     */
    public List<Aprj10020Model> srchAprj10020List(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10020Query.selectAPRJ10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당검색리스트수
     * @param Aprj10020Model 설정_업무담당
     * @return String 설정_업무담당리스트수
     */
    public String srchAprj10020Cnt(Aprj10020Model param) throws CommonException {
        try {
            return ((Aprj10020Model) sessionConn.selectOne("Aprj10020Query.selectAPRJ10020_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당검색
     * @param Aprj10020Model 설정_업무담당
     * @return Aprj10020Model 설정_업무담당
     */
    public Aprj10020Model srchAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return (Aprj10020Model) sessionConn.selectOne("Aprj10020Query.selectAPRJ10020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당검색리스트
     * @param Aprj10020Model 설정_업무담당
     * @return List<Aprj10020Model> 설정_업무담당리스트
     */
    public File srchAprj10020ExcelList(Aprj10020Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                     ".trim());
	        map.put("coNm        ".trim(), "업체 명                     ".trim());
	        map.put("opChrgId    ".trim(), "업무 담당 ID                ".trim());
	        map.put("opChrgNm    ".trim(), "업무 담당 명                ".trim());
	        map.put("opChrgCtt   ".trim(), "업무 담당 내용              ".trim());
	        
	        map.put("astClId     ".trim(), "자산구분 ID                 ".trim());
	        map.put("astClNm     ".trim(), "자산구분 명                 ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "업무담당_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj10020Query.selectAPRJ10020_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 설정_업무담당입력
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당입력수
     */
    public int insertAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10020Query.insertAPRJ10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당입력
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당입력수
     */
    public int insertAprj10020Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10020Query.insertAPRJ10020_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당수정
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당수정수
     */
    public int updateAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10020Query.updateAPRJ10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당삭제
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당삭제수
     */
    public int deleteAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10020Query.deleteAPRJ10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당삭제
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당삭제수
     */
    public int deleteAprj10020All() throws CommonException {
        try {
            return sessionConn.update("Aprj10020Query.deleteAPRJ10020_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당삭제
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당삭제수
     */
    public int deleteAprj10020Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10020Query.deleteAPRJ10020_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}