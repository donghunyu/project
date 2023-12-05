/*-------------------------------------------------------------------
* NAME   : Aprj10051Dao
* DESC   : 설정_양식요청
* Author : 
* DATE   : 2018-10-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.dao;

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.model.Aprj10050Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj10051Dao extends AprjDao {

    /**
     * 설정_양식요청검색리스트
     * @param Aprj10050Model 설정_양식요청
     * @return List<Aprj10050Model> 설정_양식요청리스트
     */
    public List<Aprj10050Model> srchAprj10051List(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10051Query.selectAPRJ10051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청검색리스트수
     * @param Aprj10050Model 설정_양식요청
     * @return String 설정_양식요청리스트수
     */
    public String srchAprj10051Cnt(Aprj10050Model param) throws CommonException {
        try {
            return ((Aprj10050Model) sessionConn.selectOne("Aprj10051Query.selectAPRJ10051_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청검색
     * @param Aprj10050Model 설정_양식요청
     * @return Aprj10050Model 설정_양식요청
     */
    public Aprj10050Model srchAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return (Aprj10050Model) sessionConn.selectOne("Aprj10051Query.selectAPRJ10051_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청입력
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청입력수
     */
    public int insertAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10051Query.insertAPRJ10051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청수정
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청수정수
     */
    public int updateAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10051Query.updateAPRJ10051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청수정
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청수정수
     */
    public int copyAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10051Query.insertAPRJ10051_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청삭제
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청삭제수
     */
    public int deleteAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10051Query.deleteAPRJ10051_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}