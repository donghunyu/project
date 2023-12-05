/*-------------------------------------------------------------------
* NAME   : Aprj20030Service
* DESC   : 프로젝트_업무
* Author : 
* DATE   : 2018-11-16
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20031Service;
import project.spring.app.aprj.service.Aprj20032Service;
import project.spring.app.aprj.service.Aprj20033Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20035Service;
import project.spring.app.aprj.service.Aprj20036Service;
import project.spring.app.aprj.service.Aprj20038Service;
import project.spring.app.aprj.service.Aprj20039Service;
import project.spring.app.aprj.service.Aprj20040Service;
import project.spring.app.aprj.service.Aprj20041Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;

@Service
public class Aprj20030AutoOpSchedule extends AprjService {

    // 업무
    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20031Service serviceAprj20031;

    @Autowired
    Aprj20032Service serviceAprj20032;

    @Autowired
    Aprj20033Service serviceAprj20033;

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Aprj20035Service serviceAprj20035;

    @Autowired
    Aprj20036Service serviceAprj20036;

    @Autowired
    Aprj20038Service serviceAprj20038;

    @Autowired
    Aprj20039Service serviceAprj20039;

    
    
    @Autowired
    Aprj20040Service serviceAprj20040;

    @Autowired
    Aprj20041Service serviceAprj20041;
    
    /**
     * 프로젝트_업무검색리스트
     * @param Aprj20030Model 프로젝트_업무
     * @return List<Aprj20030Model> 프로젝트_업무리스트
     */
    // 매일 08시 작업
    @Scheduled(cron="0 0 0 * * ?")
    public void srchAprj20030AutoOpList() throws CommonException {
    	try {
    		Aprj20030Model param = new Aprj20030Model();
    		param.setPageRowCnt("99999");
    		
    		
    		// today
            List<Aprj20030Model> opList = serviceAprj20030.srchAprj20030TodayList(param);
    		
            String toDay = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
            
    		for ( int i = 0; i < opList.size(); i++ ) {
    			param = opList.get(i);
    			
    			param.setTranStCd("2000");
    			param.setTranDt  (toDay);
    			param.setBatchUser();
    			
    			serviceAprj20030.updateAprj20030Tran(param);
    		}
    		
    		// Auto Schedule
            opList = serviceAprj20030.srchAprj20030ScheduleList(param);
    		
            Aprj20030Model temp = new Aprj20030Model();
    		for ( int i = 0; i < opList.size(); i++ ) {
    			param = opList.get(i);
    			
    			// 기존버전 마감
    			param.setTranStCd("3000");
    			param.setTranDt  (toDay);
    			param.setBatchUser();

    			serviceAprj20030.updateAprj20030Tran(param);
    			
    			// 신규 버전
    			param.setStdDt   (toDay);
    			
    			param.setTranStCd("2000");
    			param.setTranDt  (toDay);
    			
    			param.setBatchUser();
    			
    			serviceAprj20030.insertAprj20030VerUp(param);
    			
    	        temp.setCoId    (param.getCoId         ());
    	        temp.setOpId    (param.getOpId         ());
    	        temp.setOpSerNum(param.getVerUpOpSerNum());
    	        
                serviceAprj20031.deleteAprj20031(temp);
                serviceAprj20032.deleteAprj20032(temp);
                serviceAprj20033.deleteAprj20033(temp);
                serviceAprj20034.deleteAprj20034(temp);
//                serviceAprj20035.deleteAprj20035(temp);
                serviceAprj20036.deleteAprj20036(temp);
                serviceAprj20038.deleteAprj20038(temp);
                serviceAprj20039.deleteAprj20039(temp);
                serviceAprj20040.deleteAprj20040(temp);
                serviceAprj20041.deleteAprj20041(temp);


                serviceAprj20031.insertAprj20031VerUp(param);
                serviceAprj20032.insertAprj20032VerUp(param);
                serviceAprj20033.insertAprj20033VerUp(param);
                serviceAprj20034.insertAprj20034VerUp(param);
//                serviceAprj20035.insertAprj20035VerUp(param);
                serviceAprj20036.insertAprj20036VerUp(param);
                serviceAprj20038.insertAprj20038VerUp(param);
                serviceAprj20039.insertAprj20039VerUp(param);
                serviceAprj20040.insertAprj20040VerUp(param);
                serviceAprj20041.insertAprj20041VerUp(param);
    		}
    		
    		
    		//System.out.println("----------------------------------- SCHEDULE Second1 : " + DateUtil.getCurrentDateTime());
    	} catch ( Exception e ) {
    		
    	}
    	
    	
    }

}