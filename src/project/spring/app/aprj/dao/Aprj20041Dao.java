/*-------------------------------------------------------------------
* NAME   : Aprj20041Dao
* DESC   : 프로젝트_선택항목
* Author : 
* DATE   : 2018-11-26
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
public class Aprj20041Dao extends AprjDao {

    /**
     * 프로젝트_선택항목검색리스트
     * @param Aprj20030Model 프로젝트_선택항목
     * @return List<Aprj20030Model> 프로젝트_선택항목리스트
     */
    public List<Aprj20030Model> srchAprj20041List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20041Query.selectAPRJ20041_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목검색리스트수
     * @param Aprj20030Model 프로젝트_선택항목
     * @return String 프로젝트_선택항목리스트수
     */
    public String srchAprj20041Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20041Query.selectAPRJ20041_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목검색
     * @param Aprj20030Model 프로젝트_선택항목
     * @return Aprj20030Model 프로젝트_선택항목
     */
    public Aprj20030Model srchAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20041Query.selectAPRJ20041_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목입력
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목입력수
     */
    public int insertAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.insertAPRJ20041_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목입력
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목입력수
     */
    public int insertAprj20041Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.insertAPRJ20041_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목입력
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목입력수
     */
    public int insertAprj20041VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.insertAPRJ20041_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목수정
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목수정수
     */
    public int updateAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.updateAPRJ20041_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목삭제
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목삭제수
     */
    public int deleteAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.deleteAPRJ20041_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목삭제
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목삭제수
     */
    public int deleteAprj20041All() throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.deleteAPRJ20041_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목삭제
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목삭제수
     */
    public int deleteAprj20041Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20041Query.deleteAPRJ20041_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}