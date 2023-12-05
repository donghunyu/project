/*-------------------------------------------------------------------
* NAME   : Aprj10031Dao
* DESC   : 설정_결제라인
* Author : 
* DATE   : 2018-11-08
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
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj10031Dao extends AprjDao {

    /**
     * 설정_결제라인검색리스트
     * @param Aprj10030Model 설정_결제라인
     * @return List<Aprj10030Model> 설정_결제라인리스트
     */
    public List<Aprj10030Model> srchAprj10031List(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10031Query.selectAPRJ10031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인검색리스트수
     * @param Aprj10030Model 설정_결제라인
     * @return String 설정_결제라인리스트수
     */
    public String srchAprj10031Cnt(Aprj10030Model param) throws CommonException {
        try {
            return ((Aprj10030Model) sessionConn.selectOne("Aprj10031Query.selectAPRJ10031_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인검색
     * @param Aprj10030Model 설정_결제라인
     * @return Aprj10030Model 설정_결제라인
     */
    public Aprj10030Model srchAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return (Aprj10030Model) sessionConn.selectOne("Aprj10031Query.selectAPRJ10031_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인입력
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인입력수
     */
    public int insertAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10031Query.insertAPRJ10031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인입력
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인입력수
     */
    public int insertAprj10031Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10031Query.insertAPRJ10031_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인수정
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인수정수
     */
    public int updateAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10031Query.updateAPRJ10031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인삭제
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인삭제수
     */
    public int deleteAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10031Query.deleteAPRJ10031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인삭제
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인삭제수
     */
    public int deleteAprj10031All() throws CommonException {
        try {
            return sessionConn.update("Aprj10031Query.deleteAPRJ10031_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인삭제
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인삭제수
     */
    public int deleteAprj10031Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10031Query.deleteAPRJ10031_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}