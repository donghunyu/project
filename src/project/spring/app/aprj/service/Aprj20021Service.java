/*-------------------------------------------------------------------
* NAME   : Aprj20021Service
* DESC   : 프로젝트_통제자산
* Author : 
* DATE   : 2018-10-31
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

import project.spring.app.aprj.dao.Aprj20021Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20021Service extends AprjService {

    @Autowired
    private Aprj20021Dao daoAprj20021;

    /**
     * 프로젝트_통제자산검색리스트
     * @param Aprj20020Model 프로젝트_통제자산
     * @return List<Aprj20020Model> 프로젝트_통제자산리스트
     */
    public List<Aprj20020Model> srchAprj20021List(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20021.srchAprj20021List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산검색리스트수
     * @param Aprj20020Model 프로젝트_통제자산
     * @return String 프로젝트_통제자산리스트수
     */
    public String srchAprj20021Cnt(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20021.srchAprj20021Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산검색
     * @param Aprj20020Model 프로젝트_통제자산
     * @return Aprj20020Model 프로젝트_통제자산
     */
    public Aprj20020Model srchAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20021.srchAprj20021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산저장
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산저장수
     */
    public int saveAprj20021(Aprj20020Model param) throws CommonException {
        try {
            int nCount = updateAprj20021(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20021(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산입력
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산입력수
     */
    public int insertAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20021.insertAprj20021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산입력
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산입력수
     */
    public int insertAprj20021Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20021.insertAprj20021Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산수정
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산수정수
     */
    public int updateAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20021.updateAprj20021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산삭제
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산삭제수
     */
    public int deleteAprj20021(Aprj20020Model param) throws CommonException {
        try {
            return daoAprj20021.deleteAprj20021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산삭제
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산삭제수
     */
    public int deleteAprj20021All() throws CommonException {
        try {
            return daoAprj20021.deleteAprj20021All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_통제자산삭제
     * @param Aprj20020Model 프로젝트_통제자산
     * @return int 프로젝트_통제자산삭제수
     */
    public int deleteAprj20021Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20021.deleteAprj20021Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}