/*-------------------------------------------------------------------
* NAME   : Aprj10021Dao
* DESC   : 설정_업무담당자
* Author : 
* DATE   : 2018-12-12
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
public class Aprj10021Dao extends AprjDao {

    /**
     * 설정_업무담당자검색리스트
     * @param Aprj10020Model 설정_업무담당자
     * @return List<Aprj10020Model> 설정_업무담당자리스트
     */
    public List<Aprj10020Model> srchAprj10021List(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10021Query.selectAPRJ10021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트수
     * @param Aprj10020Model 설정_업무담당자
     * @return String 설정_업무담당자리스트수
     */
    public String srchAprj10021Cnt(Aprj10020Model param) throws CommonException {
        try {
            return ((Aprj10020Model) sessionConn.selectOne("Aprj10021Query.selectAPRJ10021_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색
     * @param Aprj10020Model 설정_업무담당자
     * @return Aprj10020Model 설정_업무담당자
     */
    public Aprj10020Model srchAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return (Aprj10020Model) sessionConn.selectOne("Aprj10021Query.selectAPRJ10021_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트
     * @param Aprj10020Model 설정_업무담당자
     * @return List<Aprj10020Model> 설정_업무담당자리스트
     */
    public List<Aprj10020Model> srchAprj10021UserList(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10021Query.selectAPRJ10021_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트수
     * @param Aprj10020Model 설정_업무담당자
     * @return String 설정_업무담당자리스트수
     */
    public String srchAprj10021UserCnt(Aprj10020Model param) throws CommonException {
        try {
            return ((Aprj10020Model) sessionConn.selectOne("Aprj10021Query.selectAPRJ10021_04", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트수
     * @param Aprj10020Model 설정_업무담당자
     * @return String 설정_업무담당자리스트수
     */
    public List<Aprj10020Model> srchAprj10021StmList(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj10021Query.selectAPRJ10021_05", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자입력
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자입력수
     */
    public int insertAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10021Query.insertAPRJ10021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자수정
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자수정수
     */
    public int updateAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10021Query.updateAPRJ10021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자삭제
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자삭제수
     */
    public int deleteAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return sessionConn.update("Aprj10021Query.deleteAPRJ10021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자삭제
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자삭제수
     */
    public int deleteAprj10021All() throws CommonException {
        try {
            return sessionConn.update("Aprj10021Query.deleteAPRJ10021_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 설정_업무담당자삭제
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자삭제수
     */
    public int deleteAprj10021Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Aprj10021Query.deleteAPRJ10021_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
}