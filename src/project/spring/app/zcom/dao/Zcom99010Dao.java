/*-------------------------------------------------------------------
* NAME   : Zcom99010Dao
* DESC   : 관리자_그룹코드
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
public class Zcom99010Dao extends AprjDao {

    /**
     * 관리자_그룹코드검색리스트
     * @param Zcom99010Model 관리자_그룹코드
     * @return List<Zcom99010Model> 관리자_그룹코드리스트
     */
    public List<Zcom99010Model> srchZcom99010List(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99010Query.selectZCOM99010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드검색리스트수
     * @param Zcom99010Model 관리자_그룹코드
     * @return String 관리자_그룹코드리스트수
     */
    public String srchZcom99010Cnt(Zcom99010Model param) throws CommonException {
        try {
            return ((Zcom99010Model) sessionConn.selectOne("Zcom99010Query.selectZCOM99010_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드검색
     * @param Zcom99010Model 관리자_그룹코드
     * @return Zcom99010Model 관리자_그룹코드
     */
    public Zcom99010Model srchZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return (Zcom99010Model) sessionConn.selectOne("Zcom99010Query.selectZCOM99010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드입력
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드입력수
     */
    public int insertZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99010Query.insertZCOM99010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드수정
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드수정수
     */
    public int updateZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99010Query.updateZCOM99010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드삭제
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드삭제수
     */
    public int deleteZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99010Query.deleteZCOM99010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}