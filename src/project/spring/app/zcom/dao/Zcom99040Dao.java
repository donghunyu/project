/*-------------------------------------------------------------------
* NAME   : Zcom99040Dao
* DESC   : 관리자_임시로그인
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.dao;

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99040Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99040Dao extends AprjDao {

    /**
     * 관리자_임시로그인검색리스트
     * @param Zcom99040Model 관리자_임시로그인
     * @return List<Zcom99040Model> 관리자_임시로그인리스트
     */
    public List<Zcom99040Model> srchZcom99040List(Zcom99040Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99040Query.selectZCOM99040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인검색리스트수
     * @param Zcom99040Model 관리자_임시로그인
     * @return String 관리자_임시로그인리스트수
     */
    public String srchZcom99040Cnt(Zcom99040Model param) throws CommonException {
        try {
            return ((Zcom99040Model) sessionConn.selectOne("Zcom99040Query.selectZCOM99040_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인검색
     * @param Zcom99040Model 관리자_임시로그인
     * @return Zcom99040Model 관리자_임시로그인
     */
    public Zcom99040Model srchZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return (Zcom99040Model) sessionConn.selectOne("Zcom99040Query.selectZCOM99040_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인입력
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인입력수
     */
    public int insertZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99040Query.insertZCOM99040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인수정
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인수정수
     */
    public int updateZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99040Query.updateZCOM99040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인삭제
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인삭제수
     */
    public int deleteZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99040Query.deleteZCOM99040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인삭제
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인삭제수
     */
    public int deleteZcom99040All() throws CommonException {
        try {
            return sessionConn.update("Zcom99040Query.deleteZCOM99040_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인삭제
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인삭제수
     */
    public int deleteZcom99040Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Zcom99040Query.deleteZCOM99040_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}