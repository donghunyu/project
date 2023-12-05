/*-------------------------------------------------------------------
* NAME   : Aprj20011Dao
* DESC   : 프로젝트_첨부파일
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
import project.spring.app.aprj.model.Aprj20011Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj20011Dao extends AprjDao {

    /**
     * 프로젝트_첨부파일검색리스트
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return List<Aprj20011Model> 프로젝트_첨부파일리스트
     */
    public List<Aprj20011Model> srchAprj20011PrjList(Aprj20011Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20011Query.selectAPRJ20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일검색리스트수
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return String 프로젝트_첨부파일리스트수
     */
    public List<Aprj20011Model> srchAprj20011OpList(Aprj20011Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20011Query.selectAPRJ20011_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일검색
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return Aprj20011Model 프로젝트_첨부파일
     */
    public Aprj20011Model srchAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return (Aprj20011Model) sessionConn.selectOne("Aprj20011Query.selectAPRJ20011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일입력
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일입력수
     */
    public int insertAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20011Query.insertAPRJ20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일수정
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일수정수
     */
    public int updateAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20011Query.updateAPRJ20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일삭제
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일삭제수
     */
    public int deleteAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20011Query.deleteAPRJ20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일삭제
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일삭제수
     */
    public int deleteAprj20011All() throws CommonException {
        try {
            return sessionConn.update("Aprj20011Query.deleteAPRJ20011_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일삭제
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일삭제수
     */
    public int deleteAprj20011Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20011Query.deleteAPRJ20011_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}