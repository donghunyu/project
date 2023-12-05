/*-------------------------------------------------------------------
* NAME   : Aprj20031Dao
* DESC   : 프로젝트_업무통제
* Author : 
* DATE   : 2018-12-17
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
public class Aprj20031Dao extends AprjDao {

    /**
     * 프로젝트_업무통제검색리스트
     * @param Aprj20030Model 프로젝트_업무통제
     * @return List<Aprj20030Model> 프로젝트_업무통제리스트
     */
    public List<Aprj20030Model> srchAprj20031List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20031Query.selectAPRJ20031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제검색리스트수
     * @param Aprj20030Model 프로젝트_업무통제
     * @return String 프로젝트_업무통제리스트수
     */
    public String srchAprj20031Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20031Query.selectAPRJ20031_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제검색
     * @param Aprj20030Model 프로젝트_업무통제
     * @return Aprj20030Model 프로젝트_업무통제
     */
    public Aprj20030Model srchAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20031Query.selectAPRJ20031_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제검색리스트
     * @param Aprj20030Model 프로젝트_업무통제
     * @return List<Aprj20030Model> 프로젝트_업무통제리스트
     */
    public List<Aprj20030Model> srchAprj20031ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20031Query.selectAPRJ20031_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제입력
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제입력수
     */
    public int insertAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.insertAPRJ20031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제입력
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제입력수
     */
    public int insertAprj20031Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.insertAPRJ20031_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제입력
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제입력수
     */
    public int insertAprj20031VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.insertAPRJ20031_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제수정
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제수정수
     */
    public int updateAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.updateAPRJ20031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제삭제
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제삭제수
     */
    public int deleteAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.deleteAPRJ20031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제삭제
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제삭제수
     */
    public int deleteAprj20031All() throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.deleteAPRJ20031_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제삭제
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제삭제수
     */
    public int deleteAprj20031Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20031Query.deleteAPRJ20031_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}