/*-------------------------------------------------------------------
* NAME   : Aprj20035Service
* DESC   : 프로젝트_담당자이관
* Author : 
* DATE   : 2019-01-15
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

import project.spring.app.aprj.dao.Aprj20035Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20035Service extends AprjService {

    @Autowired
    private Aprj20035Dao daoAprj20035;

    /**
     * 프로젝트_담당자이관검색리스트
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return List<Aprj20030Model> 프로젝트_담당자이관리스트
     */
    public List<Aprj20030Model> srchAprj20035List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.srchAprj20035List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관검색리스트수
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return String 프로젝트_담당자이관리스트수
     */
    public String srchAprj20035Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.srchAprj20035Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관검색
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return Aprj20030Model 프로젝트_담당자이관
     */
    public Aprj20030Model srchAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.srchAprj20035(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관저장
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관저장수
     */
    public int saveAprj20035(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20035(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20035(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관입력
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관입력수
     */
    public int insertAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.insertAprj20035(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관입력
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관입력수
     */
    public int insertAprj20035Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.insertAprj20035Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관입력
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관입력수
     */
    public int insertAprj20035VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.insertAprj20035VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관수정
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관수정수
     */
    public int updateAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.updateAprj20035(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관수정
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관수정수
     */
    public int updateAprj20035Tran(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.updateAprj20035Tran(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관삭제
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관삭제수
     */
    public int deleteAprj20035(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20035.deleteAprj20035(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관삭제
     * @param Aprj20030Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관삭제수
     */
    public int deleteAprj20035All() throws CommonException {
        try {
            return daoAprj20035.deleteAprj20035All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_담당자이관삭제
     * @param Aprj20035Model 프로젝트_담당자이관
     * @return int 프로젝트_담당자이관삭제수
     */
    public int deleteAprj20035Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20035.deleteAprj20035Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}