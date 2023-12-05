/*-------------------------------------------------------------------
* NAME   : Bacr10011Service
* DESC   : 기본정보 그룹
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
import project.spring.app.bacr.dao.Bacr10011Dao;
import project.spring.app.bacr.model.Bacr10011Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr10011Service extends BacrService {

    @Autowired
    private Bacr10011Dao daoBacr10011;

    /**
     * 기본정보 그룹검색리스트
     * @param Bacr10011Model 기본정보 그룹
     * @return List<Bacr10011Model> 기본정보 그룹리스트
     */
    public List<Bacr10011Model> srchBacr10011List(Bacr10011Model param) throws CommonException {
        try {
            return daoBacr10011.srchBacr10011List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹검색리스트수
     * @param Bacr10011Model 기본정보 그룹
     * @return String 기본정보 그룹리스트수
     */
    public String srchBacr10011Cnt(Bacr10011Model param) throws CommonException {
        try {
            return daoBacr10011.srchBacr10011Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹검색
     * @param Bacr10011Model 기본정보 그룹
     * @return Bacr10011Model 기본정보 그룹
     */
    public Bacr10011Model srchBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return daoBacr10011.srchBacr10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹저장
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹저장수
     */
    public int saveBacr10011(Bacr10011Model param) throws CommonException {
        try {
            int nCount = updateBacr10011(param);
            if ( nCount == 0 ) {
                nCount = insertBacr10011(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹입력
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹입력수
     */
    public int insertBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return daoBacr10011.insertBacr10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹수정
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹수정수
     */
    public int updateBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return daoBacr10011.updateBacr10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹삭제
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹삭제수
     */
    public int deleteBacr10011(Bacr10011Model param) throws CommonException {
        try {
            return daoBacr10011.deleteBacr10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹삭제
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹삭제수
     */
    public int deleteBacr10011All() throws CommonException {
        try {
            return daoBacr10011.deleteBacr10011All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보 그룹삭제
     * @param Bacr10011Model 기본정보 그룹
     * @return int 기본정보 그룹삭제수
     */
    public int deleteBacr10011Co(BacrModel param) throws CommonException {
        try {
            return daoBacr10011.deleteBacr10011Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}