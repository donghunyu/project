/*-------------------------------------------------------------------
* NAME   : Aprj10052Dao
* DESC   : 설정_선택항목
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
public class Aprj10052Dao extends AprjDao {

    /**
     * 설정_선택항목검색리스트
     * @param Aprj10050Model 설정_선택항목
     * @return List<Aprj10050Model> 설정_선택항목리스트
     */
    public List<Aprj10050Model> srchAprj10052List(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10052Query.selectAPRJ10052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목검색리스트수
     * @param Aprj10050Model 설정_선택항목
     * @return String 설정_선택항목리스트수
     */
    public String srchAprj10052Cnt(Aprj10050Model param) throws CommonException {
        try {
            return ((Aprj10050Model) sessionConn.selectOne("Aprj10052Query.selectAPRJ10052_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목검색
     * @param Aprj10050Model 설정_선택항목
     * @return Aprj10050Model 설정_선택항목
     */
    public Aprj10050Model srchAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return (Aprj10050Model) sessionConn.selectOne("Aprj10052Query.selectAPRJ10052_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목입력
     * @param Aprj10050Model 설정_선택항목
     * @return int 설정_선택항목입력수
     */
    public int insertAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10052Query.insertAPRJ10052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목수정
     * @param Aprj10050Model 설정_선택항목
     * @return int 설정_선택항목수정수
     */
    public int updateAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10052Query.updateAPRJ10052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목수정
     * @param Aprj10050Model 설정_선택항목
     * @return int 설정_선택항목수정수
     */
    public int copyAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10052Query.insertAPRJ10052_01", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목삭제
     * @param Aprj10050Model 설정_선택항목
     * @return int 설정_선택항목삭제수
     */
    public int deleteAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10052Query.deleteAPRJ10052_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}