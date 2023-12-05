/*-------------------------------------------------------------------
* NAME   : Zcom99020Service
* DESC   : 관리자_메뉴
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
import project.spring.app.zcom.dao.Zcom99020Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99020Model;

@Service
public class Zcom99020Service extends AprjService {

    @Autowired
    private Zcom99020Dao daoZcom99020;

    /**
     * 관리자_메뉴검색리스트
     * @param Zcom99020Model 관리자_메뉴
     * @return List<Zcom99020Model> 관리자_메뉴리스트
     */
    public List<Zcom99020Model> srchZcom99020List(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.srchZcom99020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴검색리스트수
     * @param Zcom99020Model 관리자_메뉴
     * @return String 관리자_메뉴리스트수
     */
    public String srchZcom99020Cnt(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.srchZcom99020Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴검색
     * @param Zcom99020Model 관리자_메뉴
     * @return Zcom99020Model 관리자_메뉴
     */
    public Zcom99020Model srchZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.srchZcom99020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴검색
     * @param Zcom99020Model 관리자_메뉴
     * @return Zcom99020Model 관리자_메뉴
     */
    public List<Zcom99020Model> srchZcom99020TopMenuList(Zcom99020Model param) throws CommonException {
        try {
        	return daoZcom99020.srchZcom99020TopMenuList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴별 메뉴명리스트 조회
     * @param Zcom99020Model 관리자_메뉴
     * @return List<Zcom99020Model> 관리자_메뉴별 메뉴명리스트
     */
    public Zcom99020Model srchZcom99020NaviMenu(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.srchZcom99020NaviMenu(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴저장
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴저장수
     */
    public int saveZcom99020(Zcom99020Model param) throws CommonException {
        try {
            int nCount = updateZcom99020(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99020(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴입력
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴입력수
     */
    public int insertZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.insertZcom99020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴수정
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴수정수
     */
    public int updateZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.updateZcom99020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_메뉴삭제
     * @param Zcom99020Model 관리자_메뉴
     * @return int 관리자_메뉴삭제수
     */
    public int deleteZcom99020(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.deleteZcom99020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}