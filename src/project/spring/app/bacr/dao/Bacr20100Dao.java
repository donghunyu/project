/*-------------------------------------------------------------------
* NAME   : Bacr20100Dao
* DESC   : 대회_점수
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
import project.spring.app.bacr.model.Bacr20100Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr20100Dao extends BacrDao {

    /**
     * 대회_점수검색리스트
     * @param Bacr20100Model 대회_점수
     * @return List<Bacr20100Model> 대회_점수리스트
     */
    public List<Bacr20100Model> srchBacr20100List(Bacr20100Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr20100Query.selectBACR20100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수검색리스트수
     * @param Bacr20100Model 대회_점수
     * @return String 대회_점수리스트수
     */
    public String srchBacr20100Cnt(Bacr20100Model param) throws CommonException {
        try {
            return ((Bacr20100Model) sessionConn.selectOne("Bacr20100Query.selectBACR20100_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수검색
     * @param Bacr20100Model 대회_점수
     * @return Bacr20100Model 대회_점수
     */
    public Bacr20100Model srchBacr20100(Bacr20100Model param) throws CommonException {
        try {
            return (Bacr20100Model) sessionConn.selectOne("Bacr20100Query.selectBACR20100_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수입력
     * @param Bacr20100Model 대회_점수
     * @return int 대회_점수입력수
     */
    public int insertBacr20100(Bacr20100Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20100Query.insertBACR20100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수수정
     * @param Bacr20100Model 대회_점수
     * @return int 대회_점수수정수
     */
    public int updateBacr20100(Bacr20100Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20100Query.updateBACR20100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수삭제
     * @param Bacr20100Model 대회_점수
     * @return int 대회_점수삭제수
     */
    public int deleteBacr20100(Bacr20100Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20100Query.deleteBACR20100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수삭제
     * @param Bacr20100Model 대회_점수
     * @return int 대회_점수삭제수
     */
    public int deleteBacr20100All() throws CommonException {
        try {
            return sessionConn.update("Bacr20100Query.deleteBACR20100_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수삭제
     * @param Bacr20100Model 대회_점수
     * @return int 대회_점수삭제수
     */
    public int deleteBacr20100Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr20100Query.deleteBACR20100_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}