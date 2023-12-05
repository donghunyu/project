/*-------------------------------------------------------------------
* NAME   : Bacr20030Dao
* DESC   : 대회_참가그룹
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
import project.spring.app.bacr.model.Bacr20030Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr20030Dao extends BacrDao {

    /**
     * 대회_참가그룹검색리스트
     * @param Bacr20030Model 대회_참가그룹
     * @return List<Bacr20030Model> 대회_참가그룹리스트
     */
    public List<Bacr20030Model> srchBacr20030List(Bacr20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr20030Query.selectBACR20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹검색리스트수
     * @param Bacr20030Model 대회_참가그룹
     * @return String 대회_참가그룹리스트수
     */
    public String srchBacr20030Cnt(Bacr20030Model param) throws CommonException {
        try {
            return ((Bacr20030Model) sessionConn.selectOne("Bacr20030Query.selectBACR20030_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹검색
     * @param Bacr20030Model 대회_참가그룹
     * @return Bacr20030Model 대회_참가그룹
     */
    public Bacr20030Model srchBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return (Bacr20030Model) sessionConn.selectOne("Bacr20030Query.selectBACR20030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹입력
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹입력수
     */
    public int insertBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20030Query.insertBACR20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹수정
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹수정수
     */
    public int updateBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20030Query.updateBACR20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹삭제
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹삭제수
     */
    public int deleteBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20030Query.deleteBACR20030_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹삭제
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹삭제수
     */
    public int deleteBacr20030All() throws CommonException {
        try {
            return sessionConn.update("Bacr20030Query.deleteBACR20030_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹삭제
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹삭제수
     */
    public int deleteBacr20030Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr20030Query.deleteBACR20030_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}