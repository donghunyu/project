/*-------------------------------------------------------------------
* NAME   : Zcom99032Dao
* DESC   : 관리자_부서
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
import project.spring.app.zcom.model.Zcom99032Model;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99032Dao extends AprjDao {

    /**
     * 관리자_부서검색리스트
     * @param Zcom99032Model 관리자_부서
     * @return List<Zcom99032Model> 관리자_부서리스트
     */
    public List<Zcom99032Model> srchZcom99032List(Zcom99032Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99032Query.selectZCOM99032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색리스트수
     * @param Zcom99032Model 관리자_부서
     * @return String 관리자_부서리스트수
     */
    public String srchZcom99032Cnt(Zcom99032Model param) throws CommonException {
        try {
            return ((Zcom99032Model) sessionConn.selectOne("Zcom99032Query.selectZCOM99032_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색
     * @param Zcom99032Model 관리자_부서
     * @return Zcom99032Model 관리자_부서
     */
    public Zcom99032Model srchZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return (Zcom99032Model) sessionConn.selectOne("Zcom99032Query.selectZCOM99032_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색리스트
     * @param Zcom99032Model 관리자_부서
     * @return List<Zcom99032Model> 관리자_부서리스트
     */
    public List<Zcom99032Model> srchZcom99032SubList(Zcom99032Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99032Query.selectZCOM99032_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색리스트
     * @param Zcom99032Model 관리자_부서
     * @return List<Zcom99032Model> 관리자_부서리스트
     */
    public File srchZcom99032ExcelList(Zcom99032Model param) throws CommonException {
        try {
	        LinkedHashMap<String, String> map  = new LinkedHashMap<String, String>();
	        map.put("coId        ".trim(), "업체 ID                     ".trim());
	        map.put("coNm        ".trim(), "업체 명                     ".trim());
	        map.put("deptId      ".trim(), "부서 ID                     ".trim());
	        map.put("deptNm      ".trim(), "부서 명                     ".trim());
	        map.put("deptCtt     ".trim(), "부서 내용                   ".trim());
	        map.put("supDeptId   ".trim(), "상위 부서 ID                ".trim());
	        map.put("supDeptNm   ".trim(), "상위 부서 명                ".trim());
            
    		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
    		FileUtil.mkdir(realUploadPath);
            
            String fileName = "부서_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
            return createExcelFile(sessionConn, "Zcom99032Query.selectZCOM99032_10", param, map, realUploadPath, fileName, true);
        } catch ( Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


    /**
     * 관리자_부서입력
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서입력수
     */
    public int insertZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99032Query.insertZCOM99032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서수정
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서수정수
     */
    public int updateZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99032Query.updateZCOM99032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서삭제
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서삭제수
     */
    public int deleteZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99032Query.deleteZCOM99032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서삭제
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서삭제수
     */
    public int deleteZcom99032All() throws CommonException {
        try {
            return sessionConn.update("Zcom99032Query.deleteZCOM99032_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서삭제
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서삭제수
     */
    public int deleteZcom99032Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Zcom99032Query.deleteZCOM99032_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}