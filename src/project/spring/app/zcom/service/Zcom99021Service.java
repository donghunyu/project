/*-------------------------------------------------------------------
* NAME   : Zcom99021Service
* DESC   : 관리자_메뉴권한
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
import project.spring.app.zcom.dao.Zcom99021Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99021Model;

@Service
public class Zcom99021Service extends AprjService {

    @Autowired
    private Zcom99021Dao daoZcom99021;

    /**
     * 관리자_메뉴권한검색리스트
     * @param Zcom99021Model 관리자_메뉴권한
     * @return List<Zcom99021Model> 관리자_메뉴권한리스트
     */
    public List<Zcom99021Model> srchZcom99021List(Zcom99021Model param) throws CommonException {
        try {
            return daoZcom99021.srchZcom99021List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한검색리스트수
     * @param Zcom99021Model 관리자_메뉴권한
     * @return String 관리자_메뉴권한리스트수
     */
    public String srchZcom99021Cnt(Zcom99021Model param) throws CommonException {
        try {
            return daoZcom99021.srchZcom99021Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한검색
     * @param Zcom99021Model 관리자_메뉴권한
     * @return Zcom99021Model 관리자_메뉴권한
     */
    public Zcom99021Model srchZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return daoZcom99021.srchZcom99021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한저장
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한저장수
     */
    public int saveZcom99021(Zcom99021Model param) throws CommonException {
        try {
            int nCount = updateZcom99021(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99021(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한입력
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한입력수
     */
    public int insertZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return daoZcom99021.insertZcom99021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한수정
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한수정수
     */
    public int updateZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return daoZcom99021.updateZcom99021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴권한삭제
     * @param Zcom99021Model 관리자_메뉴권한
     * @return int 관리자_메뉴권한삭제수
     */
    public int deleteZcom99021(Zcom99021Model param) throws CommonException {
        try {
            return daoZcom99021.deleteZcom99021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}