/*-------------------------------------------------------------------
* NAME   : Aprj20020Service
* DESC   : 프로젝트_통제
* Author : 
* DATE   : 2018-11-16
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.dao.Aprj20020Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20020Service extends AprjService {

    @Autowired
    private Aprj20020Dao daoAprj20020;

    /**
     * 프로젝트_통제검색리스트
     * @param Aprj20020Model 프로젝트_통제
     * @return List<Aprj20020Model> 프로젝트_통제리스트
     */
    public List<Aprj20020Model> srchAprj20020List(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.srchAprj20020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제검색리스트수
     * @param Aprj20020Model 프로젝트_통제
     * @return String 프로젝트_통제리스트수
     */
    public String srchAprj20020Cnt(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.srchAprj20020Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제검색
     * @param Aprj20020Model 프로젝트_통제
     * @return Aprj20020Model 프로젝트_통제
     */
    public Aprj20020Model srchAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.srchAprj20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제검색리스트
     * @param Aprj20020Model 프로젝트_통제
     * @return List<Aprj20020Model> 프로젝트_통제리스트
     */
    public List<Aprj20020Model> srchAprj20020ExcelList(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.srchAprj20020ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제저장
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제저장수
     */
    public int saveAprj20020(Aprj20020Model param) throws CommonException {
        try {
            int nCount = updateAprj20020(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20020(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제입력
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제입력수
     */
    public int insertAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.insertAprj20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제입력
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제입력수
     */
    public int insertAprj20020Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20020.insertAprj20020Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제수정
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제수정수
     */
    public int updateAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.updateAprj20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제삭제
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제삭제수
     */
    public int deleteAprj20020(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20020.deleteAprj20020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제삭제
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제삭제수
     */
    public int deleteAprj20020All() throws CommonException {
        try {
            return daoAprj20020.deleteAprj20020All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제삭제
     * @param Aprj20020Model 프로젝트_통제
     * @return int 프로젝트_통제삭제수
     */
    public int deleteAprj20020Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20020.deleteAprj20020Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}