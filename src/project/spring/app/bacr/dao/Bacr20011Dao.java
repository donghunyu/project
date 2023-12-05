/*-------------------------------------------------------------------
* NAME   : Bacr20011Dao
* DESC   : 대회_사대
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
import project.spring.app.bacr.model.Bacr20011Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr20011Dao extends BacrDao {

    /**
     * 대회_사대검색리스트
     * @param Bacr20011Model 대회_사대
     * @return List<Bacr20011Model> 대회_사대리스트
     */
    public List<Bacr20011Model> srchBacr20011List(Bacr20011Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr20011Query.selectBACR20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대검색리스트수
     * @param Bacr20011Model 대회_사대
     * @return String 대회_사대리스트수
     */
    public String srchBacr20011Cnt(Bacr20011Model param) throws CommonException {
        try {
            return ((Bacr20011Model) sessionConn.selectOne("Bacr20011Query.selectBACR20011_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대검색
     * @param Bacr20011Model 대회_사대
     * @return Bacr20011Model 대회_사대
     */
    public Bacr20011Model srchBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return (Bacr20011Model) sessionConn.selectOne("Bacr20011Query.selectBACR20011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대입력
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대입력수
     */
    public int insertBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20011Query.insertBACR20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대수정
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대수정수
     */
    public int updateBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20011Query.updateBACR20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대삭제
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대삭제수
     */
    public int deleteBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20011Query.deleteBACR20011_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대삭제
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대삭제수
     */
    public int deleteBacr20011All() throws CommonException {
        try {
            return sessionConn.update("Bacr20011Query.deleteBACR20011_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대삭제
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대삭제수
     */
    public int deleteBacr20011Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr20011Query.deleteBACR20011_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}