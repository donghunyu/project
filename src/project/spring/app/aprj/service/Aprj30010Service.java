/*-------------------------------------------------------------------
* NAME   : Aprj20030Service
* DESC   : 보고서_프로젝트 현황
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

import project.spring.app.aprj.dao.Aprj30010Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj30010Service extends AprjService {

    @Autowired
    private Aprj30010Dao daoAprj30010;

    /**
     * 보고서_프로젝트검색리스트
     * @param Aprj20030Model 보고서_프로젝트
     * @return List<Aprj20030Model> 보고서_프로젝트리스트
     */
    public List<Aprj20030Model> srchAprj30010List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj30010.srchAprj30010List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 보고서_프로젝트검색리스트수
     * @param Aprj20030Model 보고서_프로젝트
     * @return String 보고서_프로젝트리스트수
     */
    public String srchAprj30010Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj30010.srchAprj30010Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}