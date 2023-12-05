/*-------------------------------------------------------------------
* NAME   : Bacr10020Dao
* DESC   : 기본정보 과녁
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
import project.spring.app.bacr.model.Bacr10020Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr10020Dao extends BacrDao {

    /**
     * 기본정보 과녁검색리스트
     * @param Bacr10020Model 기본정보 과녁
     * @return List<Bacr10020Model> 기본정보 과녁리스트
     */
    public List<Bacr10020Model> srchBacr10020List(Bacr10020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr10020Query.selectBACR10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁검색리스트수
     * @param Bacr10020Model 기본정보 과녁
     * @return String 기본정보 과녁리스트수
     */
    public String srchBacr10020Cnt(Bacr10020Model param) throws CommonException {
        try {
            return ((Bacr10020Model) sessionConn.selectOne("Bacr10020Query.selectBACR10020_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁검색
     * @param Bacr10020Model 기본정보 과녁
     * @return Bacr10020Model 기본정보 과녁
     */
    public Bacr10020Model srchBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return (Bacr10020Model) sessionConn.selectOne("Bacr10020Query.selectBACR10020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁입력
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁입력수
     */
    public int insertBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10020Query.insertBACR10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁수정
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁수정수
     */
    public int updateBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10020Query.updateBACR10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁삭제
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁삭제수
     */
    public int deleteBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10020Query.deleteBACR10020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁삭제
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁삭제수
     */
    public int deleteBacr10020All() throws CommonException {
        try {
            return sessionConn.update("Bacr10020Query.deleteBACR10020_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁삭제
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁삭제수
     */
    public int deleteBacr10020Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr10020Query.deleteBACR10020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}