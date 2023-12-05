/*-------------------------------------------------------------------
* NAME   : Aprj20030Service
* DESC   : 보고서_부서 현황
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

import project.spring.app.aprj.dao.Aprj30030Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj30030Service extends AprjService {

    @Autowired
    private Aprj30030Dao daoAprj30030;

    /**
     * 보고서_부서검색리스트
     * @param Aprj20030Model 보고서_부서
     * @return List<Aprj20030Model> 보고서_부서리스트
     */
    public List<Aprj20030Model> srchAprj30030List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj30030.srchAprj30030List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 보고서_부서검색리스트수
     * @param Aprj20030Model 보고서_부서
     * @return String 보고서_부서리스트수
     */
    public String srchAprj30030Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj30030.srchAprj30030Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}