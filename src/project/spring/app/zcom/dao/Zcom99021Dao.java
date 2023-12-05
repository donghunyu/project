/*-------------------------------------------------------------------
* NAME   : Zcom99021Dao
* DESC   : 관리자_메뉴권한
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
import project.spring.app.zcom.model.Zcom99021Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99021Dao extends AprjDao {

    /**
     * 관리자_메뉴권한검색리스트
     * @param Zcom99021Model 관리자_메뉴권한
     * @return List<Zcom99021Model> 관리자_메뉴권한리스트
     */
    public List<Zcom99021Model> srchZcom99021List(Zcom99021Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99021Query.selectZCOM99021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한검색리스트수
     * @param Zcom99021Model 관리자_메뉴권한
     * @return String 관리자_메뉴권한리스트수
     */
    public String srchZcom99021Cnt(Zcom99021Model param) throws CommonException {
        try {
            return ((Zcom99021Model) sessionConn.selectOne("Zcom99021Query.selectZCOM99021_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한검색
     * @param Zcom99021Model 관리자_메뉴권한
     * @return Zcom99021Model 관리자_메뉴권한
     */
    public Zcom99021Model srchZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return (Zcom99021Model) sessionConn.selectOne("Zcom99021Query.selectZCOM99021_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한입력
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한입력수
     */
    public int insertZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99021Query.insertZCOM99021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한수정
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한수정수
     */
    public int updateZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99021Query.updateZCOM99021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한삭제
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한삭제수
     */
    public int deleteZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99021Query.deleteZCOM99021_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}