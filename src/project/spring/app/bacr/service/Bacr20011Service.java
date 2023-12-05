/*-------------------------------------------------------------------
* NAME   : Bacr20011Service
* DESC   : 대회_사대
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
import project.spring.app.bacr.dao.Bacr20011Dao;
import project.spring.app.bacr.model.Bacr20011Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr20011Service extends BacrService {

    @Autowired
    private Bacr20011Dao daoBacr20011;

    /**
     * 대회_사대검색리스트
     * @param Bacr20011Model 대회_사대
     * @return List<Bacr20011Model> 대회_사대리스트
     */
    public List<Bacr20011Model> srchBacr20011List(Bacr20011Model param) throws CommonException {
        try {
            return daoBacr20011.srchBacr20011List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대검색리스트수
     * @param Bacr20011Model 대회_사대
     * @return String 대회_사대리스트수
     */
    public String srchBacr20011Cnt(Bacr20011Model param) throws CommonException {
        try {
            return daoBacr20011.srchBacr20011Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대검색
     * @param Bacr20011Model 대회_사대
     * @return Bacr20011Model 대회_사대
     */
    public Bacr20011Model srchBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return daoBacr20011.srchBacr20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대저장
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대저장수
     */
    public int saveBacr20011(Bacr20011Model param) throws CommonException {
        try {
            int nCount = updateBacr20011(param);
            if ( nCount == 0 ) {
                nCount = insertBacr20011(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대입력
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대입력수
     */
    public int insertBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return daoBacr20011.insertBacr20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대수정
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대수정수
     */
    public int updateBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return daoBacr20011.updateBacr20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대삭제
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대삭제수
     */
    public int deleteBacr20011(Bacr20011Model param) throws CommonException {
        try {
            return daoBacr20011.deleteBacr20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대삭제
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대삭제수
     */
    public int deleteBacr20011All() throws CommonException {
        try {
            return daoBacr20011.deleteBacr20011All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_사대삭제
     * @param Bacr20011Model 대회_사대
     * @return int 대회_사대삭제수
     */
    public int deleteBacr20011Co(BacrModel param) throws CommonException {
        try {
            return daoBacr20011.deleteBacr20011Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}