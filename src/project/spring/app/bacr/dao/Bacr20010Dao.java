/*-------------------------------------------------------------------
* NAME   : Bacr20010Dao
* DESC   : 대회_대회
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
import project.spring.app.bacr.model.Bacr20010Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr20010Dao extends BacrDao {

    /**
     * 대회_대회검색리스트
     * @param Bacr20010Model 대회_대회
     * @return List<Bacr20010Model> 대회_대회리스트
     */
    public List<Bacr20010Model> srchBacr20010List(Bacr20010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr20010Query.selectBACR20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회검색리스트수
     * @param Bacr20010Model 대회_대회
     * @return String 대회_대회리스트수
     */
    public String srchBacr20010Cnt(Bacr20010Model param) throws CommonException {
        try {
            return ((Bacr20010Model) sessionConn.selectOne("Bacr20010Query.selectBACR20010_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회검색
     * @param Bacr20010Model 대회_대회
     * @return Bacr20010Model 대회_대회
     */
    public Bacr20010Model srchBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return (Bacr20010Model) sessionConn.selectOne("Bacr20010Query.selectBACR20010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회입력
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회입력수
     */
    public int insertBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20010Query.insertBACR20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회수정
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회수정수
     */
    public int updateBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20010Query.updateBACR20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회삭제
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회삭제수
     */
    public int deleteBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr20010Query.deleteBACR20010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회삭제
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회삭제수
     */
    public int deleteBacr20010All() throws CommonException {
        try {
            return sessionConn.update("Bacr20010Query.deleteBACR20010_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회삭제
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회삭제수
     */
    public int deleteBacr20010Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr20010Query.deleteBACR20010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}