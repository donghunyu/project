/*-------------------------------------------------------------------
* NAME   : Aprj20030Dao
* DESC   : 프로젝트_업무버전
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
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.StringUtil;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj20030Dao extends AprjDao {

    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public List<Aprj20030Model> srchAprj20030List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public String srchAprj20030Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20030Query.selectAPRJ20030_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public Aprj20030Model srchAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20030Query.selectAPRJ20030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public List<Aprj20030Model> srchAprj20030UserList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public String srchAprj20030UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20030Query.selectAPRJ20030_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public Aprj20030Model srchAprj20030User(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20030Query.selectAPRJ20030_05", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public List<Aprj20030Model> srchAprj20030UserMailList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_06", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public List<Aprj20030Model> srchAprj20030ScheduleList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_07", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public List<Aprj20030Model> srchAprj20030TodayList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_08", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public List<Aprj20030Model> srchAprj20030ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public File srchAprj20030ExcelList_(Aprj20030Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId         ".trim(), "업체 ID                      ".trim());
	        map.put("coNm         ".trim(), "업체 명                      ".trim());
	        map.put("opId         ".trim(), "업무 ID                      ".trim());
	        map.put("opSerNum     ".trim(), "업무 일련번호                ".trim());
	        map.put("opSeqNum     ".trim(), "업무 순번                    ".trim());
	        map.put("opVer        ".trim(), "요청 버전                    ".trim());
	        map.put("opNm         ".trim(), "업무 명                      ".trim());
	        map.put("opCtt        ".trim(), "업무 내용                    ".trim());
	        map.put("cyclId       ".trim(), "주기 ID                      ".trim());
	        map.put("cyclNm       ".trim(), "주기 명                      ".trim());
	        map.put("prdCnt       ".trim(), "기간 수                      ".trim());
	        map.put("cyclClCd     ".trim(), "주기 구분 코드               ".trim());
	        map.put("cyclClNm     ".trim(), "주기 구분 명                 ".trim());
	        map.put("stdDt        ".trim(), "기준 일자                    ".trim());
	        map.put("stmId        ".trim(), "결제 ID                      ".trim());
	        map.put("stmNm        ".trim(), "결제 명                      ".trim());
	        map.put("effStaDt     ".trim(), "유효 시작 일자               ".trim());
	        map.put("effEndDt     ".trim(), "유효 종료 일자               ".trim());
	        map.put("tranDt       ".trim(), "처리 일자                    ".trim());
	        map.put("tranStCd     ".trim(), "처리 상태 코드               ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "업무_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Aprj20030Query.selectAPRJ20030_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public List<Aprj20030Model> srchAprj20030StmExcelList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20030Query.selectAPRJ20030_11", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public String srchAprj20030UserOpId(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20030Query.insertAPRJ20030_00_3", param)).getOpId();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전입력
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전입력수
     */
    public int insertAprj20030(Aprj20030Model param) throws CommonException {
        try {
        	
        	if ( StringUtil.isNull(param.getOpSerNum()) ) {
                param.setOpSerNum(((Aprj20030Model) sessionConn.selectOne("Aprj20030Query.insertAPRJ20030_00_1", param)).getOpSerNum());
        	}
        	
            return sessionConn.update("Aprj20030Query.insertAPRJ20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전입력
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전입력수
     */
    public int insertAprj20030Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.insertAPRJ20030_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전입력
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전입력수
     */
    public int insertAprj20030VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.insertAPRJ20030_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전수정
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전수정수
     */
    public int updateAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.updateAPRJ20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전수정
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전수정수
     */
    public int updateAprj20030Tran(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.updateAPRJ20030_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전수정
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전수정수
     */
    public int updateAprj20030Prj(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.updateAPRJ20030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전삭제
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전삭제수
     */
    public int deleteAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.deleteAPRJ20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전삭제
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전삭제수
     */
    public int deleteAprj20030All() throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.deleteAPRJ20030_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전삭제
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전삭제수
     */
    public int deleteAprj20030Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20030Query.deleteAPRJ20030_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}