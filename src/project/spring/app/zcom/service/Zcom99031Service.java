/*-------------------------------------------------------------------
* NAME   : Zcom99031Service
* DESC   : 관리자_업체
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.zcom.dao.Zcom99031Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99031Model;

@Service
public class Zcom99031Service extends AprjService {

    @Autowired
    private Zcom99031Dao daoZcom99031;

    /**
     * 관리자_업체검색리스트
     * @param Zcom99031Model 관리자_업체
     * @return List<Zcom99031Model> 관리자_업체리스트
     */
    public List<Zcom99031Model> srchZcom99031List(Zcom99031Model param) throws CommonException {
        try {
            return daoZcom99031.srchZcom99031List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체검색리스트수
     * @param Zcom99031Model 관리자_업체
     * @return String 관리자_업체리스트수
     */
    public String srchZcom99031Cnt(Zcom99031Model param) throws CommonException {
        try {
            return daoZcom99031.srchZcom99031Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체검색
     * @param Zcom99031Model 관리자_업체
     * @return Zcom99031Model 관리자_업체
     */
    public Zcom99031Model srchZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return daoZcom99031.srchZcom99031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체저장
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체저장수
     */
    public int saveZcom99031(Zcom99031Model param) throws CommonException {
        try {
            int nCount = updateZcom99031(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99031(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체입력
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체입력수
     */
    public int insertZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return daoZcom99031.insertZcom99031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체수정
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체수정수
     */
    public int updateZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return daoZcom99031.updateZcom99031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체삭제
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체삭제수
     */
    public int deleteZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return daoZcom99031.deleteZcom99031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체삭제
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체삭제수
     */
    public int deleteZcom99031All() throws CommonException {
        try {
            return daoZcom99031.deleteZcom99031All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체삭제
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체삭제수
     */
    public int deleteZcom99031Co(AprjModel param) throws CommonException {
        try {
            return daoZcom99031.deleteZcom99031Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}