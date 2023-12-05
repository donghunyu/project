/*-------------------------------------------------------------------
* NAME   : Aprj10040Service
* DESC   : 설정_업무주기
* Author : 
* DATE   : 2018-11-07
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

import project.spring.app.aprj.dao.Aprj10040Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10040Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10040Service extends AprjService {

    @Autowired
    private Aprj10040Dao daoAprj10040;

    /**
     * 설정_업무주기검색리스트
     * @param Aprj10040Model 설정_업무주기
     * @return List<Aprj10040Model> 설정_업무주기리스트
     */
    public List<Aprj10040Model> srchAprj10040List(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.srchAprj10040List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색리스트수
     * @param Aprj10040Model 설정_업무주기
     * @return String 설정_업무주기리스트수
     */
    public String srchAprj10040Cnt(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.srchAprj10040Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색
     * @param Aprj10040Model 설정_업무주기
     * @return Aprj10040Model 설정_업무주기
     */
    public Aprj10040Model srchAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.srchAprj10040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기검색리스트
     * @param Aprj10040Model 설정_업무주기
     * @return List<Aprj10040Model> 설정_업무주기리스트
     */
    public File srchAprj10040ExcelList(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.srchAprj10040ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기저장
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기저장수
     */
    public int saveAprj10040(Aprj10040Model param) throws CommonException {
        try {
            int nCount = updateAprj10040(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10040(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기입력
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기입력수
     */
    public int insertAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.insertAprj10040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기입력
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기입력수
     */
    public int insertAprj10040Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10040.insertAprj10040Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기수정
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기수정수
     */
    public int updateAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.updateAprj10040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기삭제
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기삭제수
     */
    public int deleteAprj10040(Aprj10040Model param) throws CommonException {
        try {
            return daoAprj10040.deleteAprj10040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기삭제
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기삭제수
     */
    public int deleteAprj10040All() throws CommonException {
        try {
            return daoAprj10040.deleteAprj10040All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무주기삭제
     * @param Aprj10040Model 설정_업무주기
     * @return int 설정_업무주기삭제수
     */
    public int deleteAprj10040Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10040.deleteAprj10040Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}