/*-------------------------------------------------------------------
* NAME   : Bacr10010Dao
* DESC   : 기본정보_정
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
import project.spring.app.bacr.model.Bacr10010Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr10010Dao extends BacrDao {

    /**
     * 기본정보_정검색리스트
     * @param Bacr10010Model 기본정보_정
     * @return List<Bacr10010Model> 기본정보_정리스트
     */
    public List<Bacr10010Model> srchBacr10010List(Bacr10010Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr10010Query.selectBACR10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정검색리스트수
     * @param Bacr10010Model 기본정보_정
     * @return String 기본정보_정리스트수
     */
    public String srchBacr10010Cnt(Bacr10010Model param) throws CommonException {
        try {
            return ((Bacr10010Model) sessionConn.selectOne("Bacr10010Query.selectBACR10010_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정검색
     * @param Bacr10010Model 기본정보_정
     * @return Bacr10010Model 기본정보_정
     */
    public Bacr10010Model srchBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return (Bacr10010Model) sessionConn.selectOne("Bacr10010Query.selectBACR10010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정입력
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정입력수
     */
    public int insertBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10010Query.insertBACR10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정수정
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정수정수
     */
    public int updateBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10010Query.updateBACR10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정삭제
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정삭제수
     */
    public int deleteBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10010Query.deleteBACR10010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정삭제
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정삭제수
     */
    public int deleteBacr10010All() throws CommonException {
        try {
            return sessionConn.update("Bacr10010Query.deleteBACR10010_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정삭제
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정삭제수
     */
    public int deleteBacr10010Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr10010Query.deleteBACR10010_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}