/*-------------------------------------------------------------------
* NAME   : Bacr20100Service
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

package project.spring.app.bacr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.bacr.lib.object.BacrModel;
import project.spring.app.bacr.lib.object.BacrService;
import project.spring.app.bacr.dao.Bacr20100Dao;
import project.spring.app.bacr.model.Bacr20100Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr20100Service extends BacrService {

    @Autowired
    private Bacr20100Dao daoBacr20100;

    /**
     * 대회_점수검색리스트
     * @param Bacr20100Model 대회_점수
     * @return List<Bacr20100Model> 대회_점수리스트
     */
    public List<Bacr20100Model> srchBacr20100List(Bacr20100Model param) throws CommonException {
        try {
            return daoBacr20100.srchBacr20100List(param);
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
            return daoBacr20100.srchBacr20100Cnt(param);
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
            return daoBacr20100.srchBacr20100(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_점수저장
     * @param Bacr20100Model 대회_점수
     * @return int 대회_점수저장수
     */
    public int saveBacr20100(Bacr20100Model param) throws CommonException {
        try {
            int nCount = updateBacr20100(param);
            if ( nCount == 0 ) {
                nCount = insertBacr20100(param);
            }
            return nCount;
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
            return daoBacr20100.insertBacr20100(param);
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
            return daoBacr20100.updateBacr20100(param);
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
            return daoBacr20100.deleteBacr20100(param);
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
            return daoBacr20100.deleteBacr20100All();
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
            return daoBacr20100.deleteBacr20100Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}