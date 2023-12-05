/*-------------------------------------------------------------------
* NAME   : Bacr10110Service
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

package project.spring.app.bacr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.bacr.lib.object.BacrModel;
import project.spring.app.bacr.lib.object.BacrService;
import project.spring.app.bacr.dao.Bacr10110Dao;
import project.spring.app.bacr.model.Bacr10110Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr10110Service extends BacrService {

    @Autowired
    private Bacr10110Dao daoBacr10110;

    /**
     * 기본정보_회원정검색리스트
     * @param Bacr10110Model 기본정보_회원정
     * @return List<Bacr10110Model> 기본정보_회원정리스트
     */
    public List<Bacr10110Model> srchBacr10110List(Bacr10110Model param) throws CommonException {
        try {
            return daoBacr10110.srchBacr10110List(param);
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
            return daoBacr10110.srchBacr10110Cnt(param);
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
            return daoBacr10110.srchBacr10110(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원정저장
     * @param Bacr10110Model 기본정보_회원정
     * @return int 기본정보_회원정저장수
     */
    public int saveBacr10110(Bacr10110Model param) throws CommonException {
        try {
            int nCount = updateBacr10110(param);
            if ( nCount == 0 ) {
                nCount = insertBacr10110(param);
            }
            return nCount;
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
            return daoBacr10110.insertBacr10110(param);
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
            return daoBacr10110.updateBacr10110(param);
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
            return daoBacr10110.deleteBacr10110(param);
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
            return daoBacr10110.deleteBacr10110All();
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
            return daoBacr10110.deleteBacr10110Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}