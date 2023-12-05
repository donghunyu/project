/*-------------------------------------------------------------------
* NAME   : Aprj10020Service
* DESC   : 설정_업무담당
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

import project.spring.app.aprj.dao.Aprj10020Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10020Service extends AprjService {

    @Autowired
    private Aprj10020Dao daoAprj10020;

    /**
     * 설정_업무담당검색리스트
     * @param Aprj10020Model 설정_업무담당
     * @return List<Aprj10020Model> 설정_업무담당리스트
     */
    public List<Aprj10020Model> srchAprj10020List(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.srchAprj10020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당검색리스트수
     * @param Aprj10020Model 설정_업무담당
     * @return String 설정_업무담당리스트수
     */
    public String srchAprj10020Cnt(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.srchAprj10020Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당검색
     * @param Aprj10020Model 설정_업무담당
     * @return Aprj10020Model 설정_업무담당
     */
    public Aprj10020Model srchAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.srchAprj10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당검색리스트
     * @param Aprj10020Model 설정_업무담당
     * @return List<Aprj10020Model> 설정_업무담당리스트
     */
    public File srchAprj10020ExcelList(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.srchAprj10020ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당저장
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당저장수
     */
    public int saveAprj10020(Aprj10020Model param) throws CommonException {
        try {
            int nCount = updateAprj10020(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10020(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당입력
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당입력수
     */
    public int insertAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.insertAprj10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당입력
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당입력수
     */
    public int insertAprj10020Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10020.insertAprj10020Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당수정
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당수정수
     */
    public int updateAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.updateAprj10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당삭제
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당삭제수
     */
    public int deleteAprj10020(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10020.deleteAprj10020(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당삭제
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당삭제수
     */
    public int deleteAprj10020All() throws CommonException {
        try {
            return daoAprj10020.deleteAprj10020All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 설정_업무담당삭제
     * @param Aprj10020Model 설정_업무담당
     * @return int 설정_업무담당삭제수
     */
    public int deleteAprj10020Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10020.deleteAprj10020Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}