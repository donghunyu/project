/*-------------------------------------------------------------------
* NAME   : Zcom99011Dao
* DESC   : 관리자_코드
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
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99010Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99011Dao extends AprjDao {

    /**
     * 관리자_코드검색리스트
     * @param Zcom99010Model 관리자_코드
     * @return List<Zcom99010Model> 관리자_코드리스트
     */
    public List<Zcom99010Model> srchZcom99011List(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99011Query.selectZCOM99011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드검색리스트수
     * @param Zcom99010Model 관리자_코드
     * @return String 관리자_코드리스트수
     */
    public String srchZcom99011Cnt(Zcom99010Model param) throws CommonException {
        try {
            return ((Zcom99010Model) sessionConn.selectOne("Zcom99011Query.selectZCOM99011_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드검색
     * @param Zcom99010Model 관리자_코드
     * @return Zcom99010Model 관리자_코드
     */
    public Zcom99010Model srchZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return (Zcom99010Model) sessionConn.selectOne("Zcom99011Query.selectZCOM99011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드입력
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드입력수
     */
    public int insertZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99011Query.insertZCOM99011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드수정
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드수정수
     */
    public int updateZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99011Query.updateZCOM99011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드삭제
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드삭제수
     */
    public int deleteZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99011Query.deleteZCOM99011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}