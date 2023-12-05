/*-------------------------------------------------------------------
* NAME   : Bacr20030Service
* DESC   : 대회_참가그룹
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
import project.spring.app.bacr.dao.Bacr20030Dao;
import project.spring.app.bacr.model.Bacr20030Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr20030Service extends BacrService {

    @Autowired
    private Bacr20030Dao daoBacr20030;

    /**
     * 대회_참가그룹검색리스트
     * @param Bacr20030Model 대회_참가그룹
     * @return List<Bacr20030Model> 대회_참가그룹리스트
     */
    public List<Bacr20030Model> srchBacr20030List(Bacr20030Model param) throws CommonException {
        try {
            return daoBacr20030.srchBacr20030List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹검색리스트수
     * @param Bacr20030Model 대회_참가그룹
     * @return String 대회_참가그룹리스트수
     */
    public String srchBacr20030Cnt(Bacr20030Model param) throws CommonException {
        try {
            return daoBacr20030.srchBacr20030Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹검색
     * @param Bacr20030Model 대회_참가그룹
     * @return Bacr20030Model 대회_참가그룹
     */
    public Bacr20030Model srchBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return daoBacr20030.srchBacr20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹저장
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹저장수
     */
    public int saveBacr20030(Bacr20030Model param) throws CommonException {
        try {
            int nCount = updateBacr20030(param);
            if ( nCount == 0 ) {
                nCount = insertBacr20030(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹입력
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹입력수
     */
    public int insertBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return daoBacr20030.insertBacr20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹수정
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹수정수
     */
    public int updateBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return daoBacr20030.updateBacr20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹삭제
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹삭제수
     */
    public int deleteBacr20030(Bacr20030Model param) throws CommonException {
        try {
            return daoBacr20030.deleteBacr20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹삭제
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹삭제수
     */
    public int deleteBacr20030All() throws CommonException {
        try {
            return daoBacr20030.deleteBacr20030All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_참가그룹삭제
     * @param Bacr20030Model 대회_참가그룹
     * @return int 대회_참가그룹삭제수
     */
    public int deleteBacr20030Co(BacrModel param) throws CommonException {
        try {
            return daoBacr20030.deleteBacr20030Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}