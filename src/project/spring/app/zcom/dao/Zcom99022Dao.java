/*-------------------------------------------------------------------
* NAME   : Zcom99022Dao
* DESC   : 관리자_사용자메뉴
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
import project.spring.app.zcom.model.Zcom99022Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99022Dao extends AprjDao {

    /**
     * 관리자_사용자메뉴검색리스트
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return List<Zcom99022Model> 관리자_사용자메뉴리스트
     */
    public List<Zcom99022Model> srchZcom99022List(Zcom99022Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99022Query.selectZCOM99022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴검색리스트수
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return String 관리자_사용자메뉴리스트수
     */
    public String srchZcom99022Cnt(Zcom99022Model param) throws CommonException {
        try {
            return ((Zcom99022Model) sessionConn.selectOne("Zcom99022Query.selectZCOM99022_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴검색
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return Zcom99022Model 관리자_사용자메뉴
     */
    public Zcom99022Model srchZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return (Zcom99022Model) sessionConn.selectOne("Zcom99022Query.selectZCOM99022_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴입력
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴입력수
     */
    public int insertZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99022Query.insertZCOM99022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴수정
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴수정수
     */
    public int updateZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99022Query.updateZCOM99022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴삭제
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴삭제수
     */
    public int deleteZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99022Query.deleteZCOM99022_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}