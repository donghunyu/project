/*-------------------------------------------------------------------
* NAME   : Aprj20034Dao
* DESC   : 프로젝트_업무담당자
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
public class Aprj20034Dao extends AprjDao {

    /**
     * 프로젝트_업무담당자검색리스트
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return List<Aprj20030Model> 프로젝트_업무담당자리스트
     */
    public List<Aprj20030Model> srchAprj20034List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20034Query.selectAPRJ20034_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return String 프로젝트_업무담당자리스트수
     */
    public String srchAprj20034Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20034Query.selectAPRJ20034_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return Aprj20030Model 프로젝트_업무담당자
     */
    public Aprj20030Model srchAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return (Aprj20030Model) sessionConn.selectOne("Aprj20034Query.selectAPRJ20034_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색리스트
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return List<Aprj20030Model> 프로젝트_업무담당자리스트
     */
    public List<Aprj20030Model> srchAprj20034GroupList(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj20034Query.selectAPRJ20034_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return String 프로젝트_업무담당자리스트수
     */
    public String srchAprj20034GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj20034Query.selectAPRJ20034_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int insertAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.insertAPRJ20034_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int insertAprj20034Co(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.insertAPRJ20034_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int insertAprj20034VerUp(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.insertAPRJ20034_20", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int selectInsertAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.insertAPRJ20034_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자수정
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자수정수
     */
    public int updateAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.updateAPRJ20034_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자수정
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자수정수
     */
    public int updateAprj20034Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.updateAPRJ20034_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자수정
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자수정수
     */
    public int updateAprj20034Sign(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.updateAPRJ20034_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.deleteAPRJ20034_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034All() throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.deleteAPRJ20034_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.deleteAPRJ20034_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj20034Query.deleteAPRJ20034_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}