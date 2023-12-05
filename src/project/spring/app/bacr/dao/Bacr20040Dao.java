/*-------------------------------------------------------------------
* NAME   : Bacr20040Dao
* DESC   : 대회_참가자
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
import project.spring.app.bacr.model.Bacr20040Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr20040Dao extends BacrDao {

    /**
     * 대회_참가자검색리스트
     * @param Bacr20040Model 대회_참가자
     * @return List<Bacr20040Model> 대회_참가자리스트
     */
    public List<Bacr20040Model> srchBacr20040List(Bacr20040Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr20040Query.selectBACR20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자검색리스트수
     * @param Bacr20040Model 대회_참가자
     * @return String 대회_참가자리스트수
     */
    public String srchBacr20040Cnt(Bacr20040Model param) throws CommonException {
        try {
            return ((Bacr20040Model) sessionConn.selectOne("Bacr20040Query.selectBACR20040_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자검색
     * @param Bacr20040Model 대회_참가자
     * @return Bacr20040Model 대회_참가자
     */
    public Bacr20040Model srchBacr20040(Bacr20040Model param) throws CommonException {
        try {
            return (Bacr20040Model) sessionConn.selectOne("Bacr20040Query.selectBACR20040_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자입력
     * @param Bacr20040Model 대회_참가자
     * @return int 대회_참가자입력수
     */
    public int insertBacr20040(Bacr20040Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20040Query.insertBACR20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자수정
     * @param Bacr20040Model 대회_참가자
     * @return int 대회_참가자수정수
     */
    public int updateBacr20040(Bacr20040Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20040Query.updateBACR20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자삭제
     * @param Bacr20040Model 대회_참가자
     * @return int 대회_참가자삭제수
     */
    public int deleteBacr20040(Bacr20040Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20040Query.deleteBACR20040_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자삭제
     * @param Bacr20040Model 대회_참가자
     * @return int 대회_참가자삭제수
     */
    public int deleteBacr20040All() throws CommonException {
        try {
            return sessionConn.update("Bacr20040Query.deleteBACR20040_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자삭제
     * @param Bacr20040Model 대회_참가자
     * @return int 대회_참가자삭제수
     */
    public int deleteBacr20040Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr20040Query.deleteBACR20040_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}