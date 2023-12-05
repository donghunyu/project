/*-------------------------------------------------------------------
* NAME   : Aprj20039Service
* DESC   : 프로젝트_업무자산
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

import project.spring.app.aprj.dao.Aprj20039Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20039Service extends AprjService {

    @Autowired
    private Aprj20039Dao daoAprj20039;

    /**
     * 프로젝트_업무자산검색리스트
     * @param Aprj20030Model 프로젝트_업무자산
     * @return List<Aprj20030Model> 프로젝트_업무자산리스트
     */
    public List<Aprj20030Model> srchAprj20039List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.srchAprj20039List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산
     * @return String 프로젝트_업무자산리스트수
     */
    public String srchAprj20039Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.srchAprj20039Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색
     * @param Aprj20030Model 프로젝트_업무자산
     * @return Aprj20030Model 프로젝트_업무자산
     */
    public Aprj20030Model srchAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.srchAprj20039(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색리스트
     * @param Aprj20030Model 프로젝트_업무자산
     * @return List<Aprj20030Model> 프로젝트_업무자산리스트
     */
    public List<Aprj20030Model> srchAprj20039GroupList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.srchAprj20039GroupList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산
     * @return String 프로젝트_업무자산리스트수
     */
    public String srchAprj20039GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.srchAprj20039GroupCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산저장
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산저장수
     */
    public int saveAprj20039(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20039(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20039(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int insertAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.insertAprj20039(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int insertAprj20039Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.insertAprj20039Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int insertAprj20039VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.insertAprj20039VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산입력
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산입력수
     */
    public int selectInsertAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.selectInsertAprj20039(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산수정
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산수정수
     */
    public int updateAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.updateAprj20039(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산삭제
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산삭제수
     */
    public int deleteAprj20039(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20039.deleteAprj20039(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산삭제
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산삭제수
     */
    public int deleteAprj20039All() throws CommonException {
        try {
            return daoAprj20039.deleteAprj20039All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
    
    
    /**
     * 프로젝트_업무자산삭제
     * @param Aprj20030Model 프로젝트_업무자산
     * @return int 프로젝트_업무자산삭제수
     */
    public int deleteAprj20039Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20039.deleteAprj20039Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


}