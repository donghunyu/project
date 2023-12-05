/*-------------------------------------------------------------------
* NAME   : Aprj20011Service
* DESC   : 프로젝트_첨부파일
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

import project.spring.app.aprj.dao.Aprj20011Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20011Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20011Service extends AprjService {

    @Autowired
    private Aprj20011Dao daoAprj20011;

    /**
     * 프로젝트_첨부파일검색리스트
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return List<Aprj20011Model> 프로젝트_첨부파일리스트
     */
    public List<Aprj20011Model> srchAprj20011PrjList(Aprj20011Model param) throws CommonException {
        try {
            return daoAprj20011.srchAprj20011PrjList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일검색리스트수
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return String 프로젝트_첨부파일리스트수
     */
    public List<Aprj20011Model> srchAprj20011OpList(Aprj20011Model param) throws CommonException {
        try {
            return daoAprj20011.srchAprj20011OpList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일검색
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return Aprj20011Model 프로젝트_첨부파일
     */
    public Aprj20011Model srchAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return daoAprj20011.srchAprj20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일저장
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일저장수
     */
    public int saveAprj20011(Aprj20011Model param) throws CommonException {
        try {
            int nCount = updateAprj20011(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20011(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일입력
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일입력수
     */
    public int insertAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return daoAprj20011.insertAprj20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일수정
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일수정수
     */
    public int updateAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return daoAprj20011.updateAprj20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일삭제
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일삭제수
     */
    public int deleteAprj20011(Aprj20011Model param) throws CommonException {
        try {
            return daoAprj20011.deleteAprj20011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일삭제
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일삭제수
     */
    public int deleteAprj20011All() throws CommonException {
        try {
            return daoAprj20011.deleteAprj20011All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_첨부파일삭제
     * @param Aprj20011Model 프로젝트_첨부파일
     * @return int 프로젝트_첨부파일삭제수
     */
    public int deleteAprj20011Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20011.deleteAprj20011Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}