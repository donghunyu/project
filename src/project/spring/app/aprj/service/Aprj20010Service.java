/*-------------------------------------------------------------------
* NAME   : Aprj20010Service
* DESC   : 프로젝트_프로젝트
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

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.dao.Aprj20010Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20010Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20010Service extends AprjService {

    @Autowired
    private Aprj20010Dao daoAprj20010;

    /**
     * 프로젝트_프로젝트검색리스트
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return List<Aprj20010Model> 프로젝트_프로젝트리스트
     */
    public List<Aprj20010Model> srchAprj20010List(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.srchAprj20010List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트검색리스트수
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return String 프로젝트_프로젝트리스트수
     */
    public String srchAprj20010Cnt(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.srchAprj20010Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트검색리스트
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return List<Aprj20010Model> 프로젝트_프로젝트리스트
     */
    public File srchAprj20010ExcelList(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.srchAprj20010ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트검색
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return Aprj20010Model 프로젝트_프로젝트
     */
    public Aprj20010Model srchAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.srchAprj20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트저장
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트저장수
     */
    public int saveAprj20010(Aprj20010Model param) throws CommonException {
        try {
            int nCount = updateAprj20010(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20010(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트입력
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트입력수
     */
    public int insertAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.insertAprj20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트입력
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트입력수
     */
    public int insertAprj20010Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20010.insertAprj20010Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트수정
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트수정수
     */
    public int updateAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.updateAprj20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트삭제
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트삭제수
     */
    public int deleteAprj20010(Aprj20010Model param) throws CommonException {
        try {
            return daoAprj20010.deleteAprj20010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트삭제
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트삭제수
     */
    public int deleteAprj20010All() throws CommonException {
        try {
            return daoAprj20010.deleteAprj20010All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_프로젝트삭제
     * @param Aprj20010Model 프로젝트_프로젝트
     * @return int 프로젝트_프로젝트삭제수
     */
    public int deleteAprj20010Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20010.deleteAprj20010Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}