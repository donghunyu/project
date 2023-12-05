/*-------------------------------------------------------------------
* NAME   : Aprj20021Dao
* DESC   : 프로젝트_통제자산
* Author : 
* DATE   : 2018-10-31
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
public class Aprj20021Dao extends AprjDao {

    /**
     * 프로젝트_통제자산검색리스트
     * @param Aprj20020Model 프로젝트_통제자산
     * @return List<Aprj20020Model> 프로젝트_통제자산리스트
     */
    public List<Aprj20020Model> srchAprj20021List(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20021Query.selectAPRJ20021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산검색리스트수
     * @param Aprj20020Model 프로젝트_통제자산
     * @return String 프로젝트_통제자산리스트수
     */
    public String srchAprj20021Cnt(Aprj20020Model param) throws CommonException {
        try {
            return ((Aprj20020Model) sessionConn.selectOne("Aprj20021Query.selectAPRJ20021_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산검색
     * @param Aprj20020Model 프로젝트_통제자산
     * @return Aprj20020Model 프로젝트_통제자산
     */
    public Aprj20020Model srchAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return (Aprj20020Model) sessionConn.selectOne("Aprj20021Query.selectAPRJ20021_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산입력
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산입력수
     */
    public int insertAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20021Query.insertAPRJ20021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산입력
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산입력수
     */
    public int insertAprj20021Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20021Query.insertAPRJ20021_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산수정
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산수정수
     */
    public int updateAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20021Query.updateAPRJ20021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산삭제
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산삭제수
     */
    public int deleteAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20021Query.deleteAPRJ20021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산삭제
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산삭제수
     */
    public int deleteAprj20021All() throws CommonException {
        try {
            return sessionConn.update("Aprj20021Query.deleteAPRJ20021_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산삭제
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산삭제수
     */
    public int deleteAprj20021Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20021Query.deleteAPRJ20021_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}