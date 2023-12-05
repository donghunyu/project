/*-------------------------------------------------------------------
* NAME   : Bacr10110Dao
* DESC   : 기본정보_회원정
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
import project.spring.app.bacr.model.Bacr10110Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Bacr10110Dao extends BacrDao {

    /**
     * 기본정보_회원정검색리스트
     * @param Bacr10110Model 기본정보_회원정
     * @return List<Bacr10110Model> 기본정보_회원정리스트
     */
    public List<Bacr10110Model> srchBacr10110List(Bacr10110Model param) throws CommonException {
        try {
            return sessionConn.selectList("Bacr10110Query.selectBACR10110_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정검색리스트수
     * @param Bacr10110Model 기본정보_회원정
     * @return String 기본정보_회원정리스트수
     */
    public String srchBacr10110Cnt(Bacr10110Model param) throws CommonException {
        try {
            return ((Bacr10110Model) sessionConn.selectOne("Bacr10110Query.selectBACR10110_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정검색
     * @param Bacr10110Model 기본정보_회원정
     * @return Bacr10110Model 기본정보_회원정
     */
    public Bacr10110Model srchBacr10110(Bacr10110Model param) throws CommonException {
        try {
            return (Bacr10110Model) sessionConn.selectOne("Bacr10110Query.selectBACR10110_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정입력
     * @param Bacr10110Model 기본정보_회원정
     * @return int 기본정보_회원정입력수
     */
    public int insertBacr10110(Bacr10110Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10110Query.insertBACR10110_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정수정
     * @param Bacr10110Model 기본정보_회원정
     * @return int 기본정보_회원정수정수
     */
    public int updateBacr10110(Bacr10110Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10110Query.updateBACR10110_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정삭제
     * @param Bacr10110Model 기본정보_회원정
     * @return int 기본정보_회원정삭제수
     */
    public int deleteBacr10110(Bacr10110Model param) throws CommonException {
        try {
            return sessionConn.update("Bacr10110Query.deleteBACR10110_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정삭제
     * @param Bacr10110Model 기본정보_회원정
     * @return int 기본정보_회원정삭제수
     */
    public int deleteBacr10110All() throws CommonException {
        try {
            return sessionConn.update("Bacr10110Query.deleteBACR10110_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정삭제
     * @param Bacr10110Model 기본정보_회원정
     * @return int 기본정보_회원정삭제수
     */
    public int deleteBacr10110Co(BacrModel param) throws CommonException {
        try {
            return sessionConn.update("Bacr10110Query.deleteBACR10110_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}