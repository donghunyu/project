/*-------------------------------------------------------------------
* NAME   : Aprj20040Dao
* DESC   : 프로젝트_요청
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
public class Aprj20040Dao extends AprjDao {

    /**
     * 프로젝트_요청검색리스트
     * @param Aprj20030Model 프로젝트_요청
     * @return List<Aprj20030Model> 프로젝트_요청리스트
     */
    public List<Aprj20030Model> srchAprj20040List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20040Query.selectAPRJ20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색리스트수
     * @param Aprj20030Model 프로젝트_요청
     * @return String 프로젝트_요청리스트수
     */
    public String srchAprj20040Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20040Query.selectAPRJ20040_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색
     * @param Aprj20030Model 프로젝트_요청
     * @return Aprj20030Model 프로젝트_요청
     */
    public Aprj20030Model srchAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20040Query.selectAPRJ20040_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색리스트
     * @param Aprj20030Model 프로젝트_요청
     * @return List<Aprj20030Model> 프로젝트_요청리스트
     */
    public List<Aprj20030Model> srchAprj20040UserList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20040Query.selectAPRJ20040_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색리스트수
     * @param Aprj20030Model 프로젝트_요청
     * @return String 프로젝트_요청리스트수
     */
    public String srchAprj20040UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20040Query.selectAPRJ20040_11", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public String srchAprj20040reqSeqNum(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20040Query.insertAPRJ20040_00_1", param)).getReqSeqNum();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public int insertAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.insertAPRJ20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public int insertAprj20040Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.insertAPRJ20040_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public int insertAprj20040VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.insertAPRJ20040_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청수정
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청수정수
     */
    public int updateAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.updateAPRJ20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청삭제
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청삭제수
     */
    public int deleteAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.deleteAPRJ20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청삭제
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청삭제수
     */
    public int deleteAprj20040All() throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.deleteAPRJ20040_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청삭제
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청삭제수
     */
    public int deleteAprj20040Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20040Query.deleteAPRJ20040_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}