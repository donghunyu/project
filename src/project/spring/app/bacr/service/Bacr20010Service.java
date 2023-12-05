/*-------------------------------------------------------------------
* NAME   : Bacr20010Service
* DESC   : 대회_대회
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
import project.spring.app.bacr.dao.Bacr20010Dao;
import project.spring.app.bacr.model.Bacr20010Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr20010Service extends BacrService {

    @Autowired
    private Bacr20010Dao daoBacr20010;

    /**
     * 대회_대회검색리스트
     * @param Bacr20010Model 대회_대회
     * @return List<Bacr20010Model> 대회_대회리스트
     */
    public List<Bacr20010Model> srchBacr20010List(Bacr20010Model param) throws CommonException {
        try {
            return daoBacr20010.srchBacr20010List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회검색리스트수
     * @param Bacr20010Model 대회_대회
     * @return String 대회_대회리스트수
     */
    public String srchBacr20010Cnt(Bacr20010Model param) throws CommonException {
        try {
            return daoBacr20010.srchBacr20010Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회검색
     * @param Bacr20010Model 대회_대회
     * @return Bacr20010Model 대회_대회
     */
    public Bacr20010Model srchBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return daoBacr20010.srchBacr20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회저장
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회저장수
     */
    public int saveBacr20010(Bacr20010Model param) throws CommonException {
        try {
            int nCount = updateBacr20010(param);
            if ( nCount == 0 ) {
                nCount = insertBacr20010(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회입력
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회입력수
     */
    public int insertBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return daoBacr20010.insertBacr20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회수정
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회수정수
     */
    public int updateBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return daoBacr20010.updateBacr20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회삭제
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회삭제수
     */
    public int deleteBacr20010(Bacr20010Model param) throws CommonException {
        try {
            return daoBacr20010.deleteBacr20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회삭제
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회삭제수
     */
    public int deleteBacr20010All() throws CommonException {
        try {
            return daoBacr20010.deleteBacr20010All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 대회_대회삭제
     * @param Bacr20010Model 대회_대회
     * @return int 대회_대회삭제수
     */
    public int deleteBacr20010Co(BacrModel param) throws CommonException {
        try {
            return daoBacr20010.deleteBacr20010Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}