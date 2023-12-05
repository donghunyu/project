/*-------------------------------------------------------------------
* NAME   : Zcom99040Service
* DESC   : 관리자_임시로그인
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
import project.spring.app.zcom.dao.Zcom99040Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99040Model;

@Service
public class Zcom99040Service extends AprjService {

    @Autowired
    private Zcom99040Dao daoZcom99040;

    /**
     * 관리자_임시로그인검색리스트
     * @param Zcom99040Model 관리자_임시로그인
     * @return List<Zcom99040Model> 관리자_임시로그인리스트
     */
    public List<Zcom99040Model> srchZcom99040List(Zcom99040Model param) throws CommonException {
        try {
            return daoZcom99040.srchZcom99040List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인검색리스트수
     * @param Zcom99040Model 관리자_임시로그인
     * @return String 관리자_임시로그인리스트수
     */
    public String srchZcom99040Cnt(Zcom99040Model param) throws CommonException {
        try {
            return daoZcom99040.srchZcom99040Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인검색
     * @param Zcom99040Model 관리자_임시로그인
     * @return Zcom99040Model 관리자_임시로그인
     */
    public Zcom99040Model srchZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return daoZcom99040.srchZcom99040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인저장
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인저장수
     */
    public int saveZcom99040(Zcom99040Model param) throws CommonException {
        try {
            int nCount = updateZcom99040(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99040(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인입력
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인입력수
     */
    public int insertZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return daoZcom99040.insertZcom99040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인수정
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인수정수
     */
    public int updateZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return daoZcom99040.updateZcom99040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_임시로그인삭제
     * @param Zcom99040Model 관리자_임시로그인
     * @return int 관리자_임시로그인삭제수
     */
    public int deleteZcom99040(Zcom99040Model param) throws CommonException {
        try {
            return daoZcom99040.deleteZcom99040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}