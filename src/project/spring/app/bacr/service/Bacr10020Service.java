/*-------------------------------------------------------------------
* NAME   : Bacr10020Service
* DESC   : 기본정보 과녁
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
import project.spring.app.bacr.dao.Bacr10020Dao;
import project.spring.app.bacr.model.Bacr10020Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr10020Service extends BacrService {

    @Autowired
    private Bacr10020Dao daoBacr10020;

    /**
     * 기본정보 과녁검색리스트
     * @param Bacr10020Model 기본정보 과녁
     * @return List<Bacr10020Model> 기본정보 과녁리스트
     */
    public List<Bacr10020Model> srchBacr10020List(Bacr10020Model param) throws CommonException {
        try {
            return daoBacr10020.srchBacr10020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁검색리스트수
     * @param Bacr10020Model 기본정보 과녁
     * @return String 기본정보 과녁리스트수
     */
    public String srchBacr10020Cnt(Bacr10020Model param) throws CommonException {
        try {
            return daoBacr10020.srchBacr10020Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁검색
     * @param Bacr10020Model 기본정보 과녁
     * @return Bacr10020Model 기본정보 과녁
     */
    public Bacr10020Model srchBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return daoBacr10020.srchBacr10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁저장
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁저장수
     */
    public int saveBacr10020(Bacr10020Model param) throws CommonException {
        try {
            int nCount = updateBacr10020(param);
            if ( nCount == 0 ) {
                nCount = insertBacr10020(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁입력
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁입력수
     */
    public int insertBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return daoBacr10020.insertBacr10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁수정
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁수정수
     */
    public int updateBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return daoBacr10020.updateBacr10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁삭제
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁삭제수
     */
    public int deleteBacr10020(Bacr10020Model param) throws CommonException {
        try {
            return daoBacr10020.deleteBacr10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁삭제
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁삭제수
     */
    public int deleteBacr10020All() throws CommonException {
        try {
            return daoBacr10020.deleteBacr10020All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 과녁삭제
     * @param Bacr10020Model 기본정보 과녁
     * @return int 기본정보 과녁삭제수
     */
    public int deleteBacr10020Co(BacrModel param) throws CommonException {
        try {
            return daoBacr10020.deleteBacr10020Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}