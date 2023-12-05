/*-------------------------------------------------------------------
* NAME   : Zcom99030Dao
* DESC   : 관리자_사용자
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.dao;

import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.model.Zcom99030Model;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99030Dao extends AprjDao {

    /**
     * 관리자_사용자검색리스트
     * @param Zcom99030Model 관리자_사용자
     * @return List<Zcom99030Model> 관리자_사용자리스트
     */
    public List<Zcom99030Model> srchZcom99030List(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99030Query.selectZCOM99030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자검색리스트수
     * @param Zcom99030Model 관리자_사용자
     * @return String 관리자_사용자리스트수
     */
    public String srchZcom99030Cnt(Zcom99030Model param) throws CommonException {
        try {
            return ((Zcom99030Model) sessionConn.selectOne("Zcom99030Query.selectZCOM99030_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자검색
     * @param Zcom99030Model 관리자_사용자
     * @return Zcom99030Model 관리자_사용자
     */
    public Zcom99030Model srchZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return (Zcom99030Model) sessionConn.selectOne("Zcom99030Query.selectZCOM99030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자검색리스트
     * @param Zcom99030Model 관리자_사용자
     * @return List<Zcom99030Model> 관리자_사용자리스트
     */
    public File srchZcom99030ExcelList(Zcom99030Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                     ".trim());
	        map.put("coNm        ".trim(), "업체 명                     ".trim());
	        map.put("userId      ".trim(), "사용자 ID                   ".trim());
	        map.put("userNm      ".trim(), "사용자 명                   ".trim());
//	        map.put("userPwd_    ".trim(), "사용자 비밀번호             ".trim());
//	        map.put("pwdUpdtDt   ".trim(), "비밀번호 수정 일자          ".trim());
	        map.put("userAuthCd  ".trim(), "사용자 권한 코드            ".trim());
	        map.put("userAuthNm  ".trim(), "사용자 권한 명              ".trim());
                                                                      
	        map.put("deptId     ".trim(), "부서 ID                      ".trim());
	        map.put("deptNm     ".trim(), "부서 명                      ".trim());
	        map.put("opChrgId   ".trim(), "업무 담당 ID                 ".trim());
	        map.put("opChrgNm   ".trim(), "업무 담당 명                 ".trim());
	        map.put("ofcLvlClCd ".trim(), "직급 구분 코드               ".trim());
	        map.put("ofcLvlClNm ".trim(), "직급 구분 명                 ".trim());
                                                                      
	        map.put("phonNum    ".trim(), "전화 번호                    ".trim());
	        map.put("mailAddr   ".trim(), "메일 주소                    ".trim());
//	        map.put("iniScrUrl  ".trim(), "초기 화면 URL                ".trim());
	        map.put("effStaDt   ".trim(), "유효 시작 일자               ".trim());
	        map.put("effEndDt   ".trim(), "유효 종료 일자               ".trim());

            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "업체담당자_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Zcom99030Query.selectZCOM99030_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 관리자_사용자입력
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자입력수
     */
    public int insertZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.insertZCOM99030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.updateZCOM99030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030User(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.updateZCOM99030_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030PwdInit(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.updateZCOM99030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030LastLoginDtm(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.updateZCOM99030_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자삭제
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자삭제수
     */
    public int deleteZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.deleteZCOM99030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자삭제
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자삭제수
     */
    public int deleteZcom99030All() throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.deleteZCOM99030_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자삭제
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자삭제수
     */
    public int deleteZcom99030Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Zcom99030Query.deleteZCOM99030_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}