/*-------------------------------------------------------------------
* NAME   : Zcom99020Dao
* DESC   : 관리자_메뉴
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
import project.spring.app.zcom.model.Zcom99020Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99020Dao extends AprjDao {

    /**
     * 관리자_메뉴검색리스트
     * @param Zcom99020Model 관리자_메뉴
     * @return List<Zcom99020Model> 관리자_메뉴리스트
     */
    public List<Zcom99020Model> srchZcom99020List(Zcom99020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99020Query.selectZCOM99020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴검색리스트수
     * @param Zcom99020Model 관리자_메뉴
     * @return String 관리자_메뉴리스트수
     */
    public String srchZcom99020Cnt(Zcom99020Model param) throws CommonException {
        try {
            return ((Zcom99020Model) sessionConn.selectOne("Zcom99020Query.selectZCOM99020_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴검색
     * @param Zcom99020Model 관리자_메뉴
     * @return Zcom99020Model 관리자_메뉴
     */
    public Zcom99020Model srchZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return (Zcom99020Model) sessionConn.selectOne("Zcom99020Query.selectZCOM99020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴검색
     * @param Zcom99020Model 관리자_메뉴
     * @return Zcom99020Model 관리자_메뉴
     */
    public List<Zcom99020Model> srchZcom99020TopMenuList(Zcom99020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99020Query.selectZCOM99020_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴별 메뉴명리스트 조회
     * @param Zcom99020Model 관리자_메뉴
     * @return List<Zcom99020Model> 관리자_메뉴별 메뉴명리스트
     */
    public Zcom99020Model srchZcom99020NaviMenu(Zcom99020Model param) throws CommonException {
        try {
            return (Zcom99020Model) sessionConn.selectOne("Zcom99020Query.selectZCOM99020_04", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴입력
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴입력수
     */
    public int insertZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99020Query.insertZCOM99020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴수정
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴수정수
     */
    public int updateZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99020Query.updateZCOM99020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴삭제
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴삭제수
     */
    public int deleteZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99020Query.deleteZCOM99020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}