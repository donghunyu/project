/*-------------------------------------------------------------------
* NAME   : Zcom99010Service
* DESC   : 관리자_그룹코드
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
import project.spring.app.zcom.dao.Zcom99010Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99010Model;

@Service
public class Zcom99010Service extends AprjService {

    @Autowired
    private Zcom99010Dao daoZcom99010;

    /**
     * 관리자_그룹코드검색리스트
     * @param Zcom99010Model 관리자_그룹코드
     * @return List<Zcom99010Model> 관리자_그룹코드리스트
     */
    public List<Zcom99010Model> srchZcom99010List(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99010.srchZcom99010List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드검색리스트수
     * @param Zcom99010Model 관리자_그룹코드
     * @return String 관리자_그룹코드리스트수
     */
    public String srchZcom99010Cnt(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99010.srchZcom99010Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드검색
     * @param Zcom99010Model 관리자_그룹코드
     * @return Zcom99010Model 관리자_그룹코드
     */
    public Zcom99010Model srchZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99010.srchZcom99010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드저장
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드저장수
     */
    public int saveZcom99010(Zcom99010Model param) throws CommonException {
        try {
            int nCount = updateZcom99010(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99010(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드입력
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드입력수
     */
    public int insertZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99010.insertZcom99010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드수정
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드수정수
     */
    public int updateZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99010.updateZcom99010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드삭제
     * @param Zcom99010Model 관리자_그룹코드
     * @return int 관리자_그룹코드삭제수
     */
    public int deleteZcom99010(Zcom99010Model param) throws CommonException {
        try {
            return daoZcom99010.deleteZcom99010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}