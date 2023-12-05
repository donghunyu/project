/*-------------------------------------------------------------------
* NAME   : Aprj20051Dao
* DESC   : 프로젝트_응답
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

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.StringUtil;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj20051Dao extends AprjDao {

    /**
     * 프로젝트_응답검색리스트
     * @param Aprj20030Model 프로젝트_응답
     * @return List<Aprj20030Model> 프로젝트_응답리스트
     */
    public List<Aprj20030Model> srchAprj20051List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20051Query.selectAPRJ20051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색리스트수
     * @param Aprj20030Model 프로젝트_응답
     * @return String 프로젝트_응답리스트수
     */
    public String srchAprj20051Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20051Query.selectAPRJ20051_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색
     * @param Aprj20030Model 프로젝트_응답
     * @return Aprj20030Model 프로젝트_응답
     */
    public Aprj20030Model srchAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20051Query.selectAPRJ20051_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색
     * @param Aprj20030Model 프로젝트_응답
     * @return Aprj20030Model 프로젝트_응답
     */
    public String srchAprj20051ReqSerNum(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20051Query.insertAPRJ20051_00_2", param)).getReqSerNum();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


	public List<Aprj20030Model> srchAprj20051ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20051Query.selectAPRJ20051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
	}
    
    /**
     * 프로젝트_응답입력
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답입력수
     */
    public int insertAprj20051(Aprj20030Model param) throws CommonException {
        try {
        	if ( StringUtil.isNull(param.getItmSerNum()) ) {
        		param.setItmSerNum(((Aprj20030Model) sessionConn.selectOne("Aprj20051Query.insertAPRJ20051_00_1", param)).getItmSerNum());
        	}
        	
            return sessionConn.update("Aprj20051Query.insertAPRJ20051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답수정
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답수정수
     */
    public int updateAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20051Query.updateAPRJ20051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20051Query.deleteAPRJ20051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20051All() throws CommonException {
        try {
            return sessionConn.update("Aprj20051Query.deleteAPRJ20051_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20051Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20051Query.deleteAPRJ20051_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    
}