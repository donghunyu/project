/*-------------------------------------------------------------------
* NAME   : Zcom99011Service
* DESC   : 관리자_코드
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.zcom.dao.Zcom99011Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99010Model;

@Service
public class Zcom99011Service extends AprjService {

    @Autowired
    private Zcom99011Dao daoZcom99011;

    /**
     * 관리자_코드검색리스트
     * @param Zcom99010Model 관리자_코드
     * @return List<Zcom99010Model> 관리자_코드리스트
     */
    public List<Zcom99010Model> srchZcom99011List(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99011.srchZcom99011List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드검색리스트수
     * @param Zcom99010Model 관리자_코드
     * @return String 관리자_코드리스트수
     */
    public String srchZcom99011Cnt(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99011.srchZcom99011Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드검색
     * @param Zcom99010Model 관리자_코드
     * @return Zcom99010Model 관리자_코드
     */
    public Zcom99010Model srchZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99011.srchZcom99011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드저장
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드저장수
     */
    public int saveZcom99011(Zcom99010Model param) throws CommonException {
        try {
            int nCount = updateZcom99011(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99011(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드입력
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드입력수
     */
    public int insertZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99011.insertZcom99011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드수정
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드수정수
     */
    public int updateZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99011.updateZcom99011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드삭제
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드삭제수
     */
    public int deleteZcom99011(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99011.deleteZcom99011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}