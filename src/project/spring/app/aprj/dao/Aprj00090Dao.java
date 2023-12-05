/*-------------------------------------------------------------------
* NAME   : Aprj10010Dao
* DESC   : 설정_자산구분
* Author : 
* DATE   : 2018-09-12
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
public class Aprj00090Dao extends AprjDao {

    /**
     * 설정_자산구분검색리스트
     * @param Aprj10010Model 설정_자산구분
     * @return List<Aprj10010Model> 설정_자산구분리스트
     */
    public List<Aprj10010Model> srchAprj10010List(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10010Query.selectAPRJ10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분검색리스트수
     * @param Aprj10010Model 설정_자산구분
     * @return String 설정_자산구분리스트수
     */
    public String srchAprj10010Cnt(Aprj10010Model param) throws CommonException {
        try {
            return ((Aprj10010Model) sessionConn.selectOne("Aprj10010Query.selectAPRJ10010_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분검색
     * @param Aprj10010Model 설정_자산구분
     * @return Aprj10010Model 설정_자산구분
     */
    public Aprj10010Model srchAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return (Aprj10010Model) sessionConn.selectOne("Aprj10010Query.selectAPRJ10010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분검색리스트
     * @param Aprj10010Model 설정_자산구분
     * @return List<Aprj10010Model> 설정_자산구분리스트
     */
    public File srchAprj10010ExcelList(Aprj10010Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                     ".trim());
	        map.put("coNm        ".trim(), "업체 명                     ".trim());
	        map.put("astClId     ".trim(), "자산구분 ID                 ".trim());
	        map.put("astClNm     ".trim(), "자산구분 명                 ".trim());
	        map.put("astClCtt    ".trim(), "자산구분 내용               ".trim());
	        map.put("astId       ".trim(), "자산 ID                     ".trim());
	        map.put("astNm       ".trim(), "자산 명                     ".trim());
	        map.put("astCtt      ".trim(), "자산 내용                   ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "자산구분_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj10010Query.selectAPRJ10010_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 설정_자산구분입력
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분입력수
     */
    public int insertAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10010Query.insertAPRJ10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분수정
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분수정수
     */
    public int updateAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10010Query.updateAPRJ10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분삭제
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분삭제수
     */
    public int deleteAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10010Query.deleteAPRJ10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분삭제
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분삭제수
     */
    public int deleteAprj10010All() throws CommonException {
        try {
            return sessionConn.update("Aprj10010Query.deleteAPRJ10010_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}