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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.zcom.dao.Zcom99020Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99020Model;

@Service
public class Aprj00090Service extends AprjService {

    @Autowired
    private Zcom99020Dao daoZcom99020;

    /**
     * 관리자_메뉴검색리스트
     * @param Zcom99020Model 관리자_메뉴
     * @return List<Zcom99020Model> 관리자_메뉴리스트
     */
    public List<Zcom99020Model> srchZcom99020List(Zcom99020Model param) throws CommonException {
        try {
            return daoZcom99020.srchZcom99020List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
}