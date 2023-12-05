/*-------------------------------------------------------------------
* NAME   : Aprj20032Dao
* DESC   : 프로젝트_결제라인
* Author : 
* DATE   : 2018-12-06
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
public class Aprj20032Dao extends AprjDao {

    /**
     * 프로젝트_결제라인검색리스트
     * @param Aprj20030Model 프로젝트_결제라인
     * @return List<Aprj20030Model> 프로젝트_결제라인리스트
     */
    public List<Aprj20030Model> srchAprj20032List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20032Query.selectAPRJ20032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인검색리스트수
     * @param Aprj20030Model 프로젝트_결제라인
     * @return String 프로젝트_결제라인리스트수
     */
    public String srchAprj20032Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20032Query.selectAPRJ20032_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인검색
     * @param Aprj20030Model 프로젝트_결제라인
     * @return Aprj20030Model 프로젝트_결제라인
     */
    public Aprj20030Model srchAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20032Query.selectAPRJ20032_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인검색리스트
     * @param Aprj20030Model 프로젝트_결제라인
     * @return List<Aprj20030Model> 프로젝트_결제라인리스트
     */
    public List<Aprj20030Model> srchAprj20032ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20032Query.selectAPRJ20032_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.insertAPRJ20032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032Pool(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.insertAPRJ20032_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.insertAPRJ20032_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.insertAPRJ20032_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인수정
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인수정수
     */
    public int updateAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.updateAPRJ20032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인삭제
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인삭제수
     */
    public int deleteAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.deleteAPRJ20032_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인삭제
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인삭제수
     */
    public int deleteAprj20032All() throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.deleteAPRJ20032_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인삭제
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인삭제수
     */
    public int deleteAprj20032Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20032Query.deleteAPRJ20032_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}