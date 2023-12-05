/*-------------------------------------------------------------------
* NAME   : Aprj20052Dao
* DESC   : 프로젝트_응답첨부파일
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
public class Aprj20052Dao extends AprjDao {

    /**
     * 프로젝트_응답첨부파일검색리스트
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return List<Aprj20030Model> 프로젝트_응답첨부파일리스트
     */
    public List<Aprj20030Model> srchAprj20052List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20052Query.selectAPRJ20052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일검색리스트수
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return String 프로젝트_응답첨부파일리스트수
     */
    public String srchAprj20052Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20052Query.selectAPRJ20052_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일검색
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return Aprj20030Model 프로젝트_응답첨부파일
     */
    public Aprj20030Model srchAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20052Query.selectAPRJ20052_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일입력
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일입력수
     */
    public int insertAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20052Query.insertAPRJ20052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일수정
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일수정수
     */
    public int updateAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20052Query.updateAPRJ20052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일삭제
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일삭제수
     */
    public int deleteAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20052Query.deleteAPRJ20052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일삭제
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일삭제수
     */
    public int deleteAprj20052All() throws CommonException {
        try {
            return sessionConn.update("Aprj20052Query.deleteAPRJ20052_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일삭제
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일삭제수
     */
    public int deleteAprj20052Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20052Query.deleteAPRJ20052_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}