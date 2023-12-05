/*-------------------------------------------------------------------
* NAME   : Aprj20038Dao
* DESC   : 프로젝트_업무자산구분
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
public class Aprj20038Dao extends AprjDao {

    /**
     * 프로젝트_업무자산구분검색리스트
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return List<Aprj20030Model> 프로젝트_업무자산구분리스트
     */
    public List<Aprj20030Model> srchAprj20038List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20038Query.selectAPRJ20038_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return String 프로젝트_업무자산구분리스트수
     */
    public String srchAprj20038Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20038Query.selectAPRJ20038_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return Aprj20030Model 프로젝트_업무자산구분
     */
    public Aprj20030Model srchAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20038Query.selectAPRJ20038_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색리스트
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return List<Aprj20030Model> 프로젝트_업무자산구분리스트
     */
    public List<Aprj20030Model> srchAprj20038GroupList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20038Query.selectAPRJ20038_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return String 프로젝트_업무자산구분리스트수
     */
    public String srchAprj20038GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20038Query.selectAPRJ20038_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int insertAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.insertAPRJ20038_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int insertAprj20038Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.insertAPRJ20038_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int insertAprj20038VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.insertAPRJ20038_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int selectInsertAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.insertAPRJ20038_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분수정
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분수정수
     */
    public int updateAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.updateAPRJ20038_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분삭제
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분삭제수
     */
    public int deleteAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.deleteAPRJ20038_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분삭제
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분삭제수
     */
    public int deleteAprj20038All() throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.deleteAPRJ20038_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_업무자산구분삭제
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분삭제수
     */
    public int deleteAprj20038Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20038Query.deleteAPRJ20038_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


}