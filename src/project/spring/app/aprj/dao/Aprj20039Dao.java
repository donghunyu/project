/*-------------------------------------------------------------------
* NAME   : Aprj20039Dao
* DESC   : 프로젝트_업무자산
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
public class Aprj20039Dao extends AprjDao {

    /**
     * 프로젝트_업무자산검색리스트
     * @param Aprj20030Model 프로젝트_업무자산
     * @return List<Aprj20030Model> 프로젝트_업무자산리스트
     */
    public List<Aprj20030Model> srchAprj20039List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20039Query.selectAPRJ20039_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산
     * @return String 프로젝트_업무자산리스트수
     */
    public String srchAprj20039Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20039Query.selectAPRJ20039_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색
     * @param Aprj20030Model 프로젝트_업무자산
     * @return Aprj20030Model 프로젝트_업무자산
     */
    public Aprj20030Model srchAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20039Query.selectAPRJ20039_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색리스트
     * @param Aprj20030Model 프로젝트_업무자산
     * @return List<Aprj20030Model> 프로젝트_업무자산리스트
     */
    public List<Aprj20030Model> srchAprj20039GroupList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20039Query.selectAPRJ20039_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산
     * @return String 프로젝트_업무자산리스트수
     */
    public String srchAprj20039GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20039Query.selectAPRJ20039_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int insertAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.insertAPRJ20039_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int insertAprj20039Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.insertAPRJ20039_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int insertAprj20039VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.insertAPRJ20039_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int selectInsertAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.insertAPRJ20039_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산수정
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산수정수
     */
    public int updateAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.updateAPRJ20039_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산삭제
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산삭제수
     */
    public int deleteAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.deleteAPRJ20039_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산삭제
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산삭제수
     */
    public int deleteAprj20039All() throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.deleteAPRJ20039_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산삭제
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산삭제수
     */
    public int deleteAprj20039Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20039Query.deleteAPRJ20039_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}