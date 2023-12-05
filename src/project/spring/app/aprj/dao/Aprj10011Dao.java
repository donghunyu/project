/*-------------------------------------------------------------------
* NAME   : Aprj10011Dao
* DESC   : 설정_자산구분자산
* Author : 
* DATE   : 2019-01-18
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
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj10011Dao extends AprjDao {

    /**
     * 설정_자산구분자산검색리스트
     * @param Aprj10010Model 설정_자산구분자산
     * @return List<Aprj10010Model> 설정_자산구분자산리스트
     */
    public List<Aprj10010Model> srchAprj10011List(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10011Query.selectAPRJ10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산검색리스트수
     * @param Aprj10010Model 설정_자산구분자산
     * @return String 설정_자산구분자산리스트수
     */
    public String srchAprj10011Cnt(Aprj10010Model param) throws CommonException {
        try {
            return ((Aprj10010Model) sessionConn.selectOne("Aprj10011Query.selectAPRJ10011_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산검색
     * @param Aprj10010Model 설정_자산구분자산
     * @return Aprj10010Model 설정_자산구분자산
     */
    public Aprj10010Model srchAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return (Aprj10010Model) sessionConn.selectOne("Aprj10011Query.selectAPRJ10011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산입력
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산입력수
     */
    public int insertAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10011Query.insertAPRJ10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산수정
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산수정수
     */
    public int updateAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10011Query.updateAPRJ10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산삭제
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산삭제수
     */
    public int deleteAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10011Query.deleteAPRJ10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
    

    /**
     * 설정_자산구분자산삭제
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산삭제수
     */
    public int deleteAprj10011All() throws CommonException {
        try {
            return sessionConn.update("Aprj10011Query.deleteAPRJ10011_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
    

    /**
     * 설정_자산구분자산삭제
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산삭제수
     */
    public int deleteAprj10011Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10011Query.deleteAPRJ10011_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}