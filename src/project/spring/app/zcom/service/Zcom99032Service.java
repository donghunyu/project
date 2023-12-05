/*-------------------------------------------------------------------
* NAME   : Zcom99032Service
* DESC   : 관리자_부서
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

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.zcom.dao.Zcom99032Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99032Model;

@Service
public class Zcom99032Service extends AprjService {

    @Autowired
    private Zcom99032Dao daoZcom99032;

    /**
     * 관리자_부서검색리스트
     * @param Zcom99032Model 관리자_부서
     * @return List<Zcom99032Model> 관리자_부서리스트
     */
    public List<Zcom99032Model> srchZcom99032List(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.srchZcom99032List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색리스트수
     * @param Zcom99032Model 관리자_부서
     * @return String 관리자_부서리스트수
     */
    public String srchZcom99032Cnt(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.srchZcom99032Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색
     * @param Zcom99032Model 관리자_부서
     * @return Zcom99032Model 관리자_부서
     */
    public Zcom99032Model srchZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.srchZcom99032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색리스트
     * @param Zcom99032Model 관리자_부서
     * @return List<Zcom99032Model> 관리자_부서리스트
     */
    public List<Zcom99032Model> srchZcom99032SubList(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.srchZcom99032SubList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서검색리스트
     * @param Zcom99032Model 관리자_부서
     * @return List<Zcom99032Model> 관리자_부서리스트
     */
    public File srchZcom99032ExcelList(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.srchZcom99032ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서저장
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서저장수
     */
    public int saveZcom99032(Zcom99032Model param) throws CommonException {
        try {
            int nCount = updateZcom99032(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99032(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서입력
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서입력수
     */
    public int insertZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.insertZcom99032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서수정
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서수정수
     */
    public int updateZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.updateZcom99032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서삭제
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서삭제수
     */
    public int deleteZcom99032(Zcom99032Model param) throws CommonException {
        try {
            return daoZcom99032.deleteZcom99032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서삭제
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서삭제수
     */
    public int deleteZcom99032All() throws CommonException {
        try {
            return daoZcom99032.deleteZcom99032All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_부서삭제
     * @param Zcom99032Model 관리자_부서
     * @return int 관리자_부서삭제수
     */
    public int deleteZcom99032Co(AprjModel param) throws CommonException {
        try {
            return daoZcom99032.deleteZcom99032Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}