/*-------------------------------------------------------------------
* NAME   : Aprj20035Dao
* DESC   : 프로젝트_담당자이관
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
public class Aprj20035Dao extends AprjDao {

    /**
     * 프로젝트_담당자이관검색리스트
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return List<Aprj20030Model> 프로젝트_담당자이관리스트
     */
    public List<Aprj20030Model> srchAprj20035List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20035Query.selectAPRJ20035_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관검색리스트수
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return String 프로젝트_담당자이관리스트수
     */
    public String srchAprj20035Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20035Query.selectAPRJ20035_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관검색
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return Aprj20030Model 프로젝트_담당자이관
     */
    public Aprj20030Model srchAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20035Query.selectAPRJ20035_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관입력
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관입력수
     */
    public int insertAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.insertAPRJ20035_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관입력
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관입력수
     */
    public int insertAprj20035Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.insertAPRJ20035_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관입력
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관입력수
     */
    public int insertAprj20035VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.insertAPRJ20035_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관수정
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관수정수
     */
    public int updateAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.updateAPRJ20035_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관수정
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관수정수
     */
    public int updateAprj20035Tran(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.updateAPRJ20035_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관삭제
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관삭제수
     */
    public int deleteAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.deleteAPRJ20035_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관삭제
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관삭제수
     */
    public int deleteAprj20035All() throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.deleteAPRJ20035_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_담당자이관삭제
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관삭제수
     */
    public int deleteAprj20035Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20035Query.deleteAPRJ20035_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


}