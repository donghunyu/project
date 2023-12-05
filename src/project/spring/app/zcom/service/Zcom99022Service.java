/*-------------------------------------------------------------------
* NAME   : Zcom99022Service
* DESC   : 관리자_사용자메뉴
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
import project.spring.app.zcom.dao.Zcom99022Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99022Model;

@Service
public class Zcom99022Service extends AprjService {

    @Autowired
    private Zcom99022Dao daoZcom99022;

    /**
     * 관리자_사용자메뉴검색리스트
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return List<Zcom99022Model> 관리자_사용자메뉴리스트
     */
    public List<Zcom99022Model> srchZcom99022List(Zcom99022Model param) throws CommonException {
        try {
            return daoZcom99022.srchZcom99022List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴검색리스트수
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return String 관리자_사용자메뉴리스트수
     */
    public String srchZcom99022Cnt(Zcom99022Model param) throws CommonException {
        try {
            return daoZcom99022.srchZcom99022Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴검색
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return Zcom99022Model 관리자_사용자메뉴
     */
    public Zcom99022Model srchZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return daoZcom99022.srchZcom99022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴저장
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴저장수
     */
    public int saveZcom99022(Zcom99022Model param) throws CommonException {
        try {
            int nCount = updateZcom99022(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99022(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴입력
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴입력수
     */
    public int insertZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return daoZcom99022.insertZcom99022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴수정
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴수정수
     */
    public int updateZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return daoZcom99022.updateZcom99022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자메뉴삭제
     * @param Zcom99022Model 관리자_사용자메뉴
     * @return int 관리자_사용자메뉴삭제수
     */
    public int deleteZcom99022(Zcom99022Model param) throws CommonException {
        try {
            return daoZcom99022.deleteZcom99022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}