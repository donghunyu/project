/*-------------------------------------------------------------------
* NAME   : Bacr20020Dao
* DESC   : 대회_참가구분
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
import project.spring.app.bacr.model.Bacr20020Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr20020Dao extends BacrDao {

    /**
     * 대회_참가구분검색리스트
     * @param Bacr20020Model 대회_참가구분
     * @return List<Bacr20020Model> 대회_참가구분리스트
     */
    public List<Bacr20020Model> srchBacr20020List(Bacr20020Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr20020Query.selectBACR20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분검색리스트수
     * @param Bacr20020Model 대회_참가구분
     * @return String 대회_참가구분리스트수
     */
    public String srchBacr20020Cnt(Bacr20020Model param) throws CommonException {
        try {
            return ((Bacr20020Model) sessionConn.selectOne("Bacr20020Query.selectBACR20020_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분검색
     * @param Bacr20020Model 대회_참가구분
     * @return Bacr20020Model 대회_참가구분
     */
    public Bacr20020Model srchBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return (Bacr20020Model) sessionConn.selectOne("Bacr20020Query.selectBACR20020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분입력
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분입력수
     */
    public int insertBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20020Query.insertBACR20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분수정
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분수정수
     */
    public int updateBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20020Query.updateBACR20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분삭제
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분삭제수
     */
    public int deleteBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20020Query.deleteBACR20020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분삭제
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분삭제수
     */
    public int deleteBacr20020All() throws CommonException {
        try {
            return sessionConn.update("Bacr20020Query.deleteBACR20020_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분삭제
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분삭제수
     */
    public int deleteBacr20020Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr20020Query.deleteBACR20020_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}