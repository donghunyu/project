/*-------------------------------------------------------------------
* NAME   : Aprj10010Service
* DESC   : 설정_자산구분
* Author : 
* DATE   : 2018-09-12
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

import project.spring.app.aprj.dao.Aprj10010Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10010Service extends AprjService {

    @Autowired
    private Aprj10010Dao daoAprj10010;

    /**
     * 설정_자산구분검색리스트
     * @param Aprj10010Model 설정_자산구분
     * @return List<Aprj10010Model> 설정_자산구분리스트
     */
    public List<Aprj10010Model> srchAprj10010List(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.srchAprj10010List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분검색리스트수
     * @param Aprj10010Model 설정_자산구분
     * @return String 설정_자산구분리스트수
     */
    public String srchAprj10010Cnt(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.srchAprj10010Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분검색
     * @param Aprj10010Model 설정_자산구분
     * @return Aprj10010Model 설정_자산구분
     */
    public Aprj10010Model srchAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.srchAprj10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분검색리스트
     * @param Aprj10010Model 설정_자산구분
     * @return List<Aprj10010Model> 설정_자산구분리스트
     */
    public File srchAprj10010ExcelList(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.srchAprj10010ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분저장
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분저장수
     */
    public int saveAprj10010(Aprj10010Model param) throws CommonException {
        try {
            int nCount = updateAprj10010(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10010(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분입력
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분입력수
     */
    public int insertAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.insertAprj10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분입력
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분입력수
     */
    public int insertAprj10010Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10010.insertAprj10010Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분수정
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분수정수
     */
    public int updateAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.updateAprj10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분삭제
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분삭제수
     */
    public int deleteAprj10010(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10010.deleteAprj10010(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분삭제
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분삭제수
     */
    public int deleteAprj10010All() throws CommonException {
        try {
            return daoAprj10010.deleteAprj10010All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분삭제
     * @param Aprj10010Model 설정_자산구분
     * @return int 설정_자산구분삭제수
     */
    public int deleteAprj10010Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10010.deleteAprj10010Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
    
}