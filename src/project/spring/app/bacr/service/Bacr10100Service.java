/*-------------------------------------------------------------------
* NAME   : Bacr10100Service
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

package project.spring.app.bacr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.bacr.lib.object.BacrModel;
import project.spring.app.bacr.lib.object.BacrService;
import project.spring.app.bacr.dao.Bacr10100Dao;
import project.spring.app.bacr.model.Bacr10100Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr10100Service extends BacrService {

    @Autowired
    private Bacr10100Dao daoBacr10100;

    /**
     * 기본정보_회원검색리스트
     * @param Bacr10100Model 기본정보_회원
     * @return List<Bacr10100Model> 기본정보_회원리스트
     */
    public List<Bacr10100Model> srchBacr10100List(Bacr10100Model param) throws CommonException {
        try {
            return daoBacr10100.srchBacr10100List(param);
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
            return daoBacr10100.srchBacr10100Cnt(param);
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
            return daoBacr10100.srchBacr10100(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_회원저장
     * @param Bacr10100Model 기본정보_회원
     * @return int 기본정보_회원저장수
     */
    public int saveBacr10100(Bacr10100Model param) throws CommonException {
        try {
            int nCount = updateBacr10100(param);
            if ( nCount == 0 ) {
                nCount = insertBacr10100(param);
            }
            return nCount;
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
            return daoBacr10100.insertBacr10100(param);
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
            return daoBacr10100.updateBacr10100(param);
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
            return daoBacr10100.deleteBacr10100(param);
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
            return daoBacr10100.deleteBacr10100All();
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
            return daoBacr10100.deleteBacr10100Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}