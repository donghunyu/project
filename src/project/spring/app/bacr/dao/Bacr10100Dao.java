/*-------------------------------------------------------------------
* NAME   : Bacr10100Dao
* DESC   : 기본정보_회원
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
import project.spring.app.bacr.model.Bacr10100Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr10100Dao extends BacrDao {

    /**
     * 기본정보_회원검색리스트
     * @param Bacr10100Model 기본정보_회원
     * @return List<Bacr10100Model> 기본정보_회원리스트
     */
    public List<Bacr10100Model> srchBacr10100List(Bacr10100Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr10100Query.selectBACR10100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원검색리스트수
     * @param Bacr10100Model 기본정보_회원
     * @return String 기본정보_회원리스트수
     */
    public String srchBacr10100Cnt(Bacr10100Model param) throws CommonException {
        try {
            return ((Bacr10100Model) sessionConn.selectOne("Bacr10100Query.selectBACR10100_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원검색
     * @param Bacr10100Model 기본정보_회원
     * @return Bacr10100Model 기본정보_회원
     */
    public Bacr10100Model srchBacr10100(Bacr10100Model param) throws CommonException {
        try {
            return (Bacr10100Model) sessionConn.selectOne("Bacr10100Query.selectBACR10100_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원입력
     * @param Bacr10100Model 기본정보_회원
     * @return int 기본정보_회원입력수
     */
    public int insertBacr10100(Bacr10100Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10100Query.insertBACR10100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원수정
     * @param Bacr10100Model 기본정보_회원
     * @return int 기본정보_회원수정수
     */
    public int updateBacr10100(Bacr10100Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10100Query.updateBACR10100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원삭제
     * @param Bacr10100Model 기본정보_회원
     * @return int 기본정보_회원삭제수
     */
    public int deleteBacr10100(Bacr10100Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10100Query.deleteBACR10100_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원삭제
     * @param Bacr10100Model 기본정보_회원
     * @return int 기본정보_회원삭제수
     */
    public int deleteBacr10100All() throws CommonException {
        try {
            return sessionConn.update("Bacr10100Query.deleteBACR10100_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원삭제
     * @param Bacr10100Model 기본정보_회원
     * @return int 기본정보_회원삭제수
     */
    public int deleteBacr10100Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr10100Query.deleteBACR10100_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}