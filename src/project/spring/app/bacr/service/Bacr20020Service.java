/*-------------------------------------------------------------------
* NAME   : Bacr20020Service
* DESC   : 대회_참가구분
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
import project.spring.app.bacr.dao.Bacr20020Dao;
import project.spring.app.bacr.model.Bacr20020Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr20020Service extends BacrService {

    @Autowired
    private Bacr20020Dao daoBacr20020;

    /**
     * 대회_참가구분검색리스트
     * @param Bacr20020Model 대회_참가구분
     * @return List<Bacr20020Model> 대회_참가구분리스트
     */
    public List<Bacr20020Model> srchBacr20020List(Bacr20020Model param) throws CommonException {
        try {
            return daoBacr20020.srchBacr20020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분검색리스트수
     * @param Bacr20020Model 대회_참가구분
     * @return String 대회_참가구분리스트수
     */
    public String srchBacr20020Cnt(Bacr20020Model param) throws CommonException {
        try {
            return daoBacr20020.srchBacr20020Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분검색
     * @param Bacr20020Model 대회_참가구분
     * @return Bacr20020Model 대회_참가구분
     */
    public Bacr20020Model srchBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return daoBacr20020.srchBacr20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분저장
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분저장수
     */
    public int saveBacr20020(Bacr20020Model param) throws CommonException {
        try {
            int nCount = updateBacr20020(param);
            if ( nCount == 0 ) {
                nCount = insertBacr20020(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분입력
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분입력수
     */
    public int insertBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return daoBacr20020.insertBacr20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분수정
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분수정수
     */
    public int updateBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return daoBacr20020.updateBacr20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분삭제
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분삭제수
     */
    public int deleteBacr20020(Bacr20020Model param) throws CommonException {
        try {
            return daoBacr20020.deleteBacr20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분삭제
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분삭제수
     */
    public int deleteBacr20020All() throws CommonException {
        try {
            return daoBacr20020.deleteBacr20020All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가구분삭제
     * @param Bacr20020Model 대회_참가구분
     * @return int 대회_참가구분삭제수
     */
    public int deleteBacr20020Co(BacrModel param) throws CommonException {
        try {
            return daoBacr20020.deleteBacr20020Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}