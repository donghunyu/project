/*-------------------------------------------------------------------
* NAME   : Aprj20053Dao
* DESC   : 프로젝트_응답결제
* Author : 
* DATE   : 2019-02-18
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
public class Aprj20053Dao extends AprjDao {

    /**
     * 프로젝트_응답결제검색리스트
     * @param Aprj20030Model 프로젝트_응답결제
     * @return List<Aprj20030Model> 프로젝트_응답결제리스트
     */
    public List<Aprj20030Model> srchAprj20053List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20053Query.selectAPRJ20053_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색리스트수
     * @param Aprj20030Model 프로젝트_응답결제
     * @return String 프로젝트_응답결제리스트수
     */
    public String srchAprj20053Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20053Query.selectAPRJ20053_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색
     * @param Aprj20030Model 프로젝트_응답결제
     * @return Aprj20030Model 프로젝트_응답결제
     */
    public Aprj20030Model srchAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20053Query.selectAPRJ20053_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색리스트
     * @param Aprj20030Model 프로젝트_응답결제
     * @return List<Aprj20030Model> 프로젝트_응답결제리스트
     */
    public List<Aprj20030Model> srchAprj20053UserList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20053Query.selectAPRJ20053_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색리스트수
     * @param Aprj20030Model 프로젝트_응답결제
     * @return String 프로젝트_응답결제리스트수
     */
    public String srchAprj20053UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20053Query.selectAPRJ20053_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색
     * @param Aprj20030Model 프로젝트_응답결제
     * @return Aprj20030Model 프로젝트_응답결제
     */
    public Aprj20030Model srchAprj20053User(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20053Query.selectAPRJ20053_05", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제입력
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제입력수
     */
    public int insertAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20053Query.insertAPRJ20053_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제수정
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제수정수
     */
    public int updateAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20053Query.updateAPRJ20053_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제삭제
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제삭제수
     */
    public int deleteAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20053Query.deleteAPRJ20053_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제삭제
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제삭제수
     */
    public int deleteAprj20053All() throws CommonException {
        try {
            return sessionConn.update("Aprj20053Query.deleteAPRJ20053_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제삭제
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제삭제수
     */
    public int deleteAprj20053Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20053Query.deleteAPRJ20053_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}