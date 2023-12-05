/*-------------------------------------------------------------------
* NAME   : Aprj10030Service
* DESC   : 설정_결제
* Author : 
* DATE   : 2018-11-08
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

import project.spring.app.aprj.dao.Aprj10030Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10030Service extends AprjService {

    @Autowired
    private Aprj10030Dao daoAprj10030;

    /**
     * 설정_결제검색리스트
     * @param Aprj10030Model 설정_결제
     * @return List<Aprj10030Model> 설정_결제리스트
     */
    public List<Aprj10030Model> srchAprj10030List(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.srchAprj10030List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제검색리스트수
     * @param Aprj10030Model 설정_결제
     * @return String 설정_결제리스트수
     */
    public String srchAprj10030Cnt(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.srchAprj10030Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제검색
     * @param Aprj10030Model 설정_결제
     * @return Aprj10030Model 설정_결제
     */
    public Aprj10030Model srchAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.srchAprj10030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제검색리스트
     * @param Aprj10030Model 설정_결제
     * @return List<Aprj10030Model> 설정_결제리스트
     */
    public List<Aprj10030Model> srchAprj10030ExcelList(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.srchAprj10030ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제저장
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제저장수
     */
    public int saveAprj10030(Aprj10030Model param) throws CommonException {
        try {
            int nCount = updateAprj10030(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10030(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제입력
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제입력수
     */
    public int insertAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.insertAprj10030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제입력
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제입력수
     */
    public int insertAprj10030Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10030.insertAprj10030Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제수정
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제수정수
     */
    public int updateAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.updateAprj10030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제삭제
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제삭제수
     */
    public int deleteAprj10030(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10030.deleteAprj10030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제삭제
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제삭제수
     */
    public int deleteAprj10030All() throws CommonException {
        try {
            return daoAprj10030.deleteAprj10030All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제삭제
     * @param Aprj10030Model 설정_결제
     * @return int 설정_결제삭제수
     */
    public int deleteAprj10030Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10030.deleteAprj10030Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}