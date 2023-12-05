/*-------------------------------------------------------------------
* NAME   : Bacr10011Dao
* DESC   : 기본정보 그룹
* Author : 
* DATE   : 2023-02-13
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.bacr.dao;

import project.spring.app.bacr.lib.object.BacrDao;
import project.spring.app.bacr.lib.object.BacrModel;
import project.spring.app.bacr.model.Bacr10011Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr10011Dao extends BacrDao {

    /**
     * 기본정보 그룹검색리스트
     * @param Bacr10011Model 기본정보 그룹
     * @return List<Bacr10011Model> 기본정보 그룹리스트
     */
    public List<Bacr10011Model> srchBacr10011List(Bacr10011Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr10011Query.selectBACR10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹검색리스트수
     * @param Bacr10011Model 기본정보 그룹
     * @return String 기본정보 그룹리스트수
     */
    public String srchBacr10011Cnt(Bacr10011Model param) throws CommonException {
        try {
            return ((Bacr10011Model) sessionConn.selectOne("Bacr10011Query.selectBACR10011_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹검색
     * @param Bacr10011Model 기본정보 그룹
     * @return Bacr10011Model 기본정보 그룹
     */
    public Bacr10011Model srchBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return (Bacr10011Model) sessionConn.selectOne("Bacr10011Query.selectBACR10011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹입력
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹입력수
     */
    public int insertBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10011Query.insertBACR10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹수정
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹수정수
     */
    public int updateBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10011Query.updateBACR10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹삭제
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹삭제수
     */
    public int deleteBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10011Query.deleteBACR10011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹삭제
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹삭제수
     */
    public int deleteBacr10011All() throws CommonException {
        try {
            return sessionConn.update("Bacr10011Query.deleteBACR10011_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹삭제
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹삭제수
     */
    public int deleteBacr10011Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr10011Query.deleteBACR10011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}