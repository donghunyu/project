/*-------------------------------------------------------------------
* NAME   : Aprj20050Dao
* DESC   : 프로젝트_응답
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
public class Aprj20050Dao extends AprjDao {

    /**
     * 프로젝트_응답검색리스트
     * @param Aprj20030Model 프로젝트_응답
     * @return List<Aprj20030Model> 프로젝트_응답리스트
     */
    public List<Aprj20030Model> srchAprj20050List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20050Query.selectAPRJ20050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색리스트수
     * @param Aprj20030Model 프로젝트_응답
     * @return String 프로젝트_응답리스트수
     */
    public String srchAprj20050Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20050Query.selectAPRJ20050_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색
     * @param Aprj20030Model 프로젝트_응답
     * @return Aprj20030Model 프로젝트_응답
     */
    public Aprj20030Model srchAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20050Query.selectAPRJ20050_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색리스트수
     * @param Aprj20030Model 프로젝트_응답
     * @return String 프로젝트_응답리스트수
     */
    public String srchAprj20050ResCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20050Query.selectAPRJ20050_03", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답입력
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답입력수
     */
    public int insertAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20050Query.insertAPRJ20050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답수정
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답수정수
     */
    public int updateAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20050Query.updateAPRJ20050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답수정
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답수정수
     */
    public int updateAprj20050Sign(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20050Query.updateAPRJ20050_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20050Query.deleteAPRJ20050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20050All() throws CommonException {
        try {
            return sessionConn.update("Aprj20050Query.deleteAPRJ20050_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20050Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20050Query.deleteAPRJ20050_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}