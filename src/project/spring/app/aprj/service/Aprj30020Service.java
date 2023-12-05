/*-------------------------------------------------------------------
* NAME   : Aprj20030Service
* DESC   : 보고서_업무 현황
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

import project.spring.app.aprj.dao.Aprj30020Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj30020Service extends AprjService {

    @Autowired
    private Aprj30020Dao daoAprj30020;

    /**
     * 보고서_업무검색리스트
     * @param Aprj20030Model 보고서_업무
     * @return List<Aprj20030Model> 보고서_업무리스트
     */
    public List<Aprj20030Model> srchAprj30020List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj30020.srchAprj30020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 보고서_업무검색리스트수
     * @param Aprj20030Model 보고서_업무
     * @return String 보고서_업무리스트수
     */
    public String srchAprj30020Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj30020.srchAprj30020Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}