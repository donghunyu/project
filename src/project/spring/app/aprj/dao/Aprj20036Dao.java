/*-------------------------------------------------------------------
* NAME   : Aprj20036Dao
* DESC   : 프로젝트_결제담당자
* Author : 
* DATE   : 2019-01-30
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

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj20036Dao extends AprjDao {

    /**
     * 프로젝트_결제담당자검색리스트
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return List<Aprj20030Model> 프로젝트_결제담당자리스트
     */
    public List<Aprj20030Model> srchAprj20036List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20036Query.selectAPRJ20036_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색리스트수
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return String 프로젝트_결제담당자리스트수
     */
    public String srchAprj20036Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20036Query.selectAPRJ20036_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public Aprj20030Model srchAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20036Query.selectAPRJ20036_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public List<Aprj20030Model> srchAprj20036Batch(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20036Query.selectAPRJ20036_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public List<Aprj20030Model> srchAprj20036High(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20036Query.selectAPRJ20036_04", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public List<Aprj20030Model> srchAprj20036OpChrg(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20036Query.selectAPRJ20036_05", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public Aprj20030Model srchAprj20036Exist(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20036Query.selectAPRJ20036_06", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색리스트
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return List<Aprj20030Model> 프로젝트_결제담당자리스트
     */
    public List<Aprj20030Model> srchAprj20036UserList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20036Query.selectAPRJ20036_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색리스트수
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return String 프로젝트_결제담당자리스트수
     */
    public String srchAprj20036UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20036Query.selectAPRJ20036_11", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자입력
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자입력수
     */
    public int insertAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.insertAPRJ20036_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자입력
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자입력수
     */
    public int insertAprj20036Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.insertAPRJ20036_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자입력
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자입력수
     */
    public int insertAprj20036VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.insertAPRJ20036_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자수정
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자수정수
     */
    public int updateAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.updateAPRJ20036_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.deleteAPRJ20036_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036All() throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.deleteAPRJ20036_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.deleteAPRJ20036_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036Add(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20036Query.deleteAPRJ20036_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}