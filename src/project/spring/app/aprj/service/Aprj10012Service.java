/*-------------------------------------------------------------------
* NAME   : Aprj10012Service
* DESC   : 설정_자산
* Author : 
* DATE   : 2019-01-18
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

import project.spring.app.aprj.dao.Aprj10012Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10012Service extends AprjService {

    @Autowired
    private Aprj10012Dao daoAprj10012;

    /**
     * 설정_자산검색리스트
     * @param Aprj10010Model 설정_자산
     * @return List<Aprj10010Model> 설정_자산리스트
     */
    public List<Aprj10010Model> srchAprj10012List(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.srchAprj10012List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산검색리스트수
     * @param Aprj10010Model 설정_자산
     * @return String 설정_자산리스트수
     */
    public String srchAprj10012Cnt(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.srchAprj10012Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산검색
     * @param Aprj10010Model 설정_자산
     * @return Aprj10010Model 설정_자산
     */
    public Aprj10010Model srchAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.srchAprj10012(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산검색리스트
     * @param Aprj10010Model 설정_자산
     * @return List<Aprj10010Model> 설정_자산리스트
     */
    public File srchAprj10012ExcelList(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.srchAprj10012ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산저장
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산저장수
     */
    public int saveAprj10012(Aprj10010Model param) throws CommonException {
        try {
            int nCount = updateAprj10012(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10012(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산입력
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산입력수
     */
    public int insertAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.insertAprj10012(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산입력
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산입력수
     */
    public int insertAprj10012Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10012.insertAprj10012Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산수정
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산수정수
     */
    public int updateAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.updateAprj10012(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산삭제
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산삭제수
     */
    public int deleteAprj10012(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10012.deleteAprj10012(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 설정_자산삭제
     * @param Aprj10010Model 설정_자산
     * @return int 설정_자산삭제수
     */
    public int deleteAprj10012All() throws CommonException {
        try {
            return daoAprj10012.deleteAprj10012All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    /**
     * 설정_자산삭제
     * @param Aprj10012Model 설정_자산
     * @return int 설정_자산삭제수
     */
    public int deleteAprj10012Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10012.deleteAprj10012Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}