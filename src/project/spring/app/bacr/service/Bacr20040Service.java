/*-------------------------------------------------------------------
* NAME   : Bacr20040Service
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

package project.spring.app.bacr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.bacr.lib.object.BacrModel;
import project.spring.app.bacr.lib.object.BacrService;
import project.spring.app.bacr.dao.Bacr20040Dao;
import project.spring.app.bacr.model.Bacr20040Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr20040Service extends BacrService {

    @Autowired
    private Bacr20040Dao daoBacr20040;

    /**
     * 대회_참가자검색리스트
     * @param Bacr20040Model 대회_참가자
     * @return List<Bacr20040Model> 대회_참가자리스트
     */
    public List<Bacr20040Model> srchBacr20040List(Bacr20040Model param) throws CommonException {
        try {
            return daoBacr20040.srchBacr20040List(param);
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
            return daoBacr20040.srchBacr20040Cnt(param);
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
            return daoBacr20040.srchBacr20040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가자저장
     * @param Bacr20040Model 대회_참가자
     * @return int 대회_참가자저장수
     */
    public int saveBacr20040(Bacr20040Model param) throws CommonException {
        try {
            int nCount = updateBacr20040(param);
            if ( nCount == 0 ) {
                nCount = insertBacr20040(param);
            }
            return nCount;
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
            return daoBacr20040.insertBacr20040(param);
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
            return daoBacr20040.updateBacr20040(param);
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
            return daoBacr20040.deleteBacr20040(param);
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
            return daoBacr20040.deleteBacr20040All();
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
            return daoBacr20040.deleteBacr20040Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}