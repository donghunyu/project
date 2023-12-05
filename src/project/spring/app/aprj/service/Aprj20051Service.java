/*-------------------------------------------------------------------
* NAME   : Aprj20051Service
* DESC   : 프로젝트_응답
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

import project.spring.app.aprj.dao.Aprj20051Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20051Service extends AprjService {

    @Autowired
    private Aprj20051Dao daoAprj20051;

    /**
     * 프로젝트_응답검색리스트
     * @param Aprj20030Model 프로젝트_응답
     * @return List<Aprj20030Model> 프로젝트_응답리스트
     */
    public List<Aprj20030Model> srchAprj20051List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.srchAprj20051List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색리스트수
     * @param Aprj20030Model 프로젝트_응답
     * @return String 프로젝트_응답리스트수
     */
    public String srchAprj20051Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.srchAprj20051Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색
     * @param Aprj20030Model 프로젝트_응답
     * @return Aprj20030Model 프로젝트_응답
     */
    public Aprj20030Model srchAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.srchAprj20051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색
     * @param Aprj20030Model 프로젝트_응답
     * @return Aprj20030Model 프로젝트_응답
     */
    public String srchAprj20051ReqSerNum(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.srchAprj20051ReqSerNum(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


	public List<Aprj20030Model> srchAprj20051ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.srchAprj20051ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
	}

    /**
     * 프로젝트_응답저장
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답저장수
     */
    public int saveAprj20051(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20051(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20051(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답입력
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답입력수
     */
    public int insertAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.insertAprj20051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답수정
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답수정수
     */
    public int updateAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.updateAprj20051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20051(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20051.deleteAprj20051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20051All() throws CommonException {
        try {
            return daoAprj20051.deleteAprj20051All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20051Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20051Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20051.deleteAprj20051Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


}