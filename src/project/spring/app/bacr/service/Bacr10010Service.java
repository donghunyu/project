/*-------------------------------------------------------------------
* NAME   : Bacr10010Service
* DESC   : 기본정보_정
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
import project.spring.app.bacr.dao.Bacr10010Dao;
import project.spring.app.bacr.model.Bacr10010Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Bacr10010Service extends BacrService {

    @Autowired
    private Bacr10010Dao daoBacr10010;

    /**
     * 기본정보_정검색리스트
     * @param Bacr10010Model 기본정보_정
     * @return List<Bacr10010Model> 기본정보_정리스트
     */
    public List<Bacr10010Model> srchBacr10010List(Bacr10010Model param) throws CommonException {
        try {
            return daoBacr10010.srchBacr10010List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정검색리스트수
     * @param Bacr10010Model 기본정보_정
     * @return String 기본정보_정리스트수
     */
    public String srchBacr10010Cnt(Bacr10010Model param) throws CommonException {
        try {
            return daoBacr10010.srchBacr10010Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정검색
     * @param Bacr10010Model 기본정보_정
     * @return Bacr10010Model 기본정보_정
     */
    public Bacr10010Model srchBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return daoBacr10010.srchBacr10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정저장
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정저장수
     */
    public int saveBacr10010(Bacr10010Model param) throws CommonException {
        try {
            int nCount = updateBacr10010(param);
            if ( nCount == 0 ) {
                nCount = insertBacr10010(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정입력
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정입력수
     */
    public int insertBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return daoBacr10010.insertBacr10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정수정
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정수정수
     */
    public int updateBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return daoBacr10010.updateBacr10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정삭제
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정삭제수
     */
    public int deleteBacr10010(Bacr10010Model param) throws CommonException {
        try {
            return daoBacr10010.deleteBacr10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정삭제
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정삭제수
     */
    public int deleteBacr10010All() throws CommonException {
        try {
            return daoBacr10010.deleteBacr10010All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 기본정보_정삭제
     * @param Bacr10010Model 기본정보_정
     * @return int 기본정보_정삭제수
     */
    public int deleteBacr10010Co(BacrModel param) throws CommonException {
        try {
            return daoBacr10010.deleteBacr10010Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}