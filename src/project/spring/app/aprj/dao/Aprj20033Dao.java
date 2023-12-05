/*-------------------------------------------------------------------
* NAME   : Aprj20033Dao
* DESC   : 프로젝트_업무담당
* Author : 
* DATE   : 2019-01-15
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
public class Aprj20033Dao extends AprjDao {

    /**
     * 프로젝트_업무담당검색리스트
     * @param Aprj20030Model 프로젝트_업무담당
     * @return List<Aprj20030Model> 프로젝트_업무담당리스트
     */
    public List<Aprj20030Model> srchAprj20033List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20033Query.selectAPRJ20033_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당
     * @return String 프로젝트_업무담당리스트수
     */
    public String srchAprj20033Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20033Query.selectAPRJ20033_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색
     * @param Aprj20030Model 프로젝트_업무담당
     * @return Aprj20030Model 프로젝트_업무담당
     */
    public Aprj20030Model srchAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20033Query.selectAPRJ20033_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색리스트
     * @param Aprj20030Model 프로젝트_업무담당
     * @return List<Aprj20030Model> 프로젝트_업무담당리스트
     */
    public List<Aprj20030Model> srchAprj20033GroupList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20033Query.selectAPRJ20033_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당
     * @return String 프로젝트_업무담당리스트수
     */
    public String srchAprj20033GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20033Query.selectAPRJ20033_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int insertAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.insertAPRJ20033_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int insertAprj20033Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.insertAPRJ20033_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int insertAprj20033VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.insertAPRJ20033_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int selectInsertAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.insertAPRJ20033_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당수정
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당수정수
     */
    public int updateAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.updateAPRJ20033_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당수정
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당수정수
     */
    public int updateAprj20033Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.updateAPRJ20033_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.deleteAPRJ20033_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033All() throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.deleteAPRJ20033_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.deleteAPRJ20033_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20033Query.deleteAPRJ20033_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


}