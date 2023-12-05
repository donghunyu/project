/*-------------------------------------------------------------------
* NAME   : Aprj10022Dao
* DESC   : 설정_업무자산구분
* Author : 
* DATE   : 2018-11-07
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
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj10022Dao extends AprjDao {

    /**
     * 설정_업무자산구분검색리스트
     * @param Aprj10020Model 설정_업무자산구분
     * @return List<Aprj10020Model> 설정_업무자산구분리스트
     */
    public List<Aprj10020Model> srchAprj10022List(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10022Query.selectAPRJ10022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분검색리스트수
     * @param Aprj10020Model 설정_업무자산구분
     * @return String 설정_업무자산구분리스트수
     */
    public String srchAprj10022Cnt(Aprj10020Model param) throws CommonException {
        try {
            return ((Aprj10020Model) sessionConn.selectOne("Aprj10022Query.selectAPRJ10022_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분검색
     * @param Aprj10020Model 설정_업무자산구분
     * @return Aprj10020Model 설정_업무자산구분
     */
    public Aprj10020Model srchAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return (Aprj10020Model) sessionConn.selectOne("Aprj10022Query.selectAPRJ10022_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분입력
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분입력수
     */
    public int insertAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10022Query.insertAPRJ10022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분입력
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분입력수
     */
    public int insertAprj10022Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10022Query.insertAPRJ10022_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분수정
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분수정수
     */
    public int updateAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10022Query.updateAPRJ10022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분삭제
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분삭제수
     */
    public int deleteAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10022Query.deleteAPRJ10022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분삭제
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분삭제수
     */
    public int deleteAprj10022All() throws CommonException {
        try {
            return sessionConn.update("Aprj10022Query.deleteAPRJ10022_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분삭제
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분삭제수
     */
    public int deleteAprj10022Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10022Query.deleteAPRJ10022_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}