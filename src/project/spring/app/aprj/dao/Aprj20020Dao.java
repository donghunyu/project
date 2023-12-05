/*-------------------------------------------------------------------
* NAME   : Aprj20020Dao
* DESC   : 프로젝트_통제
* Author : 
* DATE   : 2018-11-16
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
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj20020Dao extends AprjDao {

    /**
     * 프로젝트_통제검색리스트
     * @param Aprj20020Model 프로젝트_통제
     * @return List<Aprj20020Model> 프로젝트_통제리스트
     */
    public List<Aprj20020Model> srchAprj20020List(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20020Query.selectAPRJ20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제검색리스트수
     * @param Aprj20020Model 프로젝트_통제
     * @return String 프로젝트_통제리스트수
     */
    public String srchAprj20020Cnt(Aprj20020Model param) throws CommonException {
        try {
            return ((Aprj20020Model) sessionConn.selectOne("Aprj20020Query.selectAPRJ20020_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제검색
     * @param Aprj20020Model 프로젝트_통제
     * @return Aprj20020Model 프로젝트_통제
     */
    public Aprj20020Model srchAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return (Aprj20020Model) sessionConn.selectOne("Aprj20020Query.selectAPRJ20020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제검색리스트
     * @param Aprj20020Model 프로젝트_통제
     * @return List<Aprj20020Model> 프로젝트_통제리스트
     */
    public List<Aprj20020Model> srchAprj20020ExcelList(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20020Query.selectAPRJ20020_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제입력
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제입력수
     */
    public int insertAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20020Query.insertAPRJ20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제입력
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제입력수
     */
    public int insertAprj20020Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20020Query.insertAPRJ20020_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제수정
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제수정수
     */
    public int updateAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20020Query.updateAPRJ20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제삭제
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제삭제수
     */
    public int deleteAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20020Query.deleteAPRJ20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제삭제
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제삭제수
     */
    public int deleteAprj20020All() throws CommonException {
        try {
            return sessionConn.update("Aprj20020Query.deleteAPRJ20020_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제삭제
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제삭제수
     */
    public int deleteAprj20020Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20020Query.deleteAPRJ20020_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}