/*-------------------------------------------------------------------
* NAME   : Aprj10050Dao
* DESC   : 설정_양식
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
public class Aprj10050Dao extends AprjDao {

    /**
     * 설정_양식검색리스트
     * @param Aprj10050Model 설정_양식
     * @return List<Aprj10050Model> 설정_양식리스트
     */
    public List<Aprj10050Model> srchAprj10050List(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10050Query.selectAPRJ10050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식검색리스트수
     * @param Aprj10050Model 설정_양식
     * @return String 설정_양식리스트수
     */
    public String srchAprj10050Cnt(Aprj10050Model param) throws CommonException {
        try {
            return ((Aprj10050Model) sessionConn.selectOne("Aprj10050Query.selectAPRJ10050_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식검색
     * @param Aprj10050Model 설정_양식
     * @return Aprj10050Model 설정_양식
     */
    public Aprj10050Model srchAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return (Aprj10050Model) sessionConn.selectOne("Aprj10050Query.selectAPRJ10050_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식입력
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식입력수
     */
    public int insertAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10050Query.insertAPRJ10050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식수정
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식수정수
     */
    public int updateAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10050Query.updateAPRJ10050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식수정
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식수정수
     */
    public int copyAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10050Query.insertAPRJ10050_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식삭제
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식삭제수
     */
    public int deleteAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10050Query.deleteAPRJ10050_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}