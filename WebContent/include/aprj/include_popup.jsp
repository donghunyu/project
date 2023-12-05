<%@ page
  info         = "Project Management"
  language     = "java"
  session      = "true"
  buffer       = "16kb" 
  autoFlush    = "true"
  isThreadSafe = "true"
  isErrorPage  = "false"
  contentType  = "text/html; charset=utf-8"
%>

<%@ page import="project.spring.app.aprj.constants.ActionConstants_Aprj" %>

<script type="text/javascript">

    var ctx = '${pageContext.request.contextPath}';

    /**************************************************************************
     *  거래처 검색
     **************************************************************************/
    function requestPopup(type) {
    	
        returnFunction = "setData";
        switch ( type ) {
	        case 'USER' :
	            returnFunction = "setUser";
	            break;
            case 'SUP_USER' :
                returnFunction = "setSupUser";
                break;
            case 'DRFT_USER' :
                returnFunction = "setDrftUser";
                break;
            case 'AST_CL' :
                returnFunction = "setAstCl";
                break;
            case 'AST' :
                returnFunction = "setAst";
                break;
            case 'OP_AST' :
                returnFunction = "setOpAst";
                break;
            case 'OP_CHRG' :
                returnFunction = "setOpChrg";
                break;
            case 'STM_OP_CHRG' :
                returnFunction = "setStmOpChrg";
                break;
            case 'TRNSF_OP_CHRG' :
                returnFunction = "setTrnsfOpChrg";
                break;
            case 'OP_CHRG_USER' :
                returnFunction = "setOpChgrUser";
                break;
            case 'CYCL' :
                returnFunction = "setCycl";
                break;
            case 'PRJ' :
                returnFunction = "setPrj";
                break;
            case 'CTRL' :
                returnFunction = "setCtrl";
                break;
            case 'CO' :
                returnFunction = "setCo";
                break;
            case 'SRCH_CO' :
                returnFunction = "setSrchCo";
                break;
            case 'COPY_CO' :
                returnFunction = "setCopyCo";
                break;
            case 'DEPT' :
                returnFunction = "setDept";
                break;
            case 'SUP_DEPT' :
                returnFunction = "setSupDept";
                break;
            case 'STM' :
                returnFunction = "setStm";
                break;
            case 'AST_STM' :
                returnFunction = "setAstStm";
                break;
        }
        
        requestPopupType(type, returnFunction);
    }
    
    /**************************************************************************
     *  거래처 검색
     **************************************************************************/
    function requestPopupType(type, returnFunction) {
    	
    	switch ( type ) {
	        case 'USER' :
	            openUser(returnFunction);
	            break;
            case 'SUP_USER' :
                openUser(returnFunction);
                break;
            case 'DRFT_USER' :
                openUser(returnFunction);
                break;
            case 'AST_CL' :
                openAstCl(returnFunction);
                break;
            case 'AST' :
                openAst(returnFunction);
                break;
            case 'OP_AST' :
                openOpAst(returnFunction);
                break;
            case 'OP_CHRG' :
                openOpChrg(returnFunction);
                break;
            case 'STM_OP_CHRG' :
                openOpChrg(returnFunction);
                break;
            case 'TRNSF_OP_CHRG' :
                openOpChrg(returnFunction);
                break;
            case 'OP_CHRG_USER' :
                openOpChrgUser(returnFunction);
                break;
            case 'CYCL' :
                openCycl(returnFunction);
                break;
            case 'PRJ' :
                openPrj(returnFunction);
                break;
            case 'CTRL' :
                openCtrl(returnFunction);
                break;
            case 'CO' :
                openCo(returnFunction);
                break;
            case 'SRCH_CO' :
                openCo(returnFunction);
                break;
            case 'COPY_CO' :
                openCo(returnFunction);
                break;
            case 'DEPT' :
                openDept(returnFunction);
                break;
            case 'SUP_DEPT' :
                openDept(returnFunction);
                break;
            case 'STM' :
                openStm(returnFunction);
                break;
            case 'AST_STM' :
                openAstStm(returnFunction);
                break;
    	}
    }
    
    
    
    /**************************************************************************
     *  사용자 설정
     **************************************************************************/
    function setData(data) {
        for ( var key in data) {
            var val = data[key];
            if ( document.getElementById(key) != null ) {
                document.getElementById(key).value = val;
            }
        }
    }

    
    function setObjectValue(objId, objVal) {
        if ( document.getElementById(objId) != null ) {
            document.getElementById(objId).value = objVal;
        }
    }
    

    /**************************************************************************
     *  사용자 검색
     **************************************************************************/
    function openUser(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99030_90 %>";
        var target = "user";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setUser(data) {
    	setData(data);
    }

    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setSupUser(data) {
        document.getElementById("supUserId").value = data.userId;
        document.getElementById("supUserNm").value = data.userNm;
    }
    
    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setDrftUser(data) {
        document.getElementById("drftUserId").value = data.userId;
        document.getElementById("drftUserNm").value = data.userNm;
    }
    
    
    /**************************************************************************
     *  자산 구분 검색
     **************************************************************************/
    function openAstCl(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ10010_90 %>" + getParam();
        var target = "astCl";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  자산 구분 설정
     **************************************************************************/
    function setAstCl(data) {
        setData(data);
    }
    
    
    /**************************************************************************
     *  자산 검색
     **************************************************************************/
    function openAst(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ10012_90 %>" + getParam();
        var target = "ast";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setAst(data) {
        setData(data);
    }
    
    
    /**************************************************************************
     *  자산 검색
     **************************************************************************/
    function openOpAst(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20039_90 %>" + getParam();
        var target = "opAst";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setOpAst(data) {
        setData(data);
    }
    
    
    /**************************************************************************
     *  업무 검색
     **************************************************************************/
    function openOpChrg(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ10020_90 %>" + getParam();
        var target = "opChrg";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setOpChrg(data) {
        setData(data);
    }

    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setStmOpChrg(data) {
        document.getElementById("stmOpChrgId").value = data.opChrgId;
        document.getElementById("stmOpChrgNm").value = data.opChrgNm;
    }

    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setTrnsfOpChrg(data) {
        document.getElementById("trnsfOpChrgId").value = data.opChrgId;
        document.getElementById("trnsfOpChrgNm").value = data.opChrgNm;
    }

    
    /**************************************************************************
     *  사용자 검색
     **************************************************************************/
    function openOpChrgUser(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ10021_90 %>" + getParam();
        var target = "opChrgUser";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setOpChgrUser(data) {
        document.getElementById("trnsfOpChrgId").value = data.opChrgId;
        document.getElementById("trnsfOpChrgNm").value = data.opChrgNm;
        document.getElementById("trnsfUserId"  ).value = data.userId;
        document.getElementById("trnsfUserNm"  ).value = data.userNm;
    }

    
    
    /**************************************************************************
     *  업무 검색
     **************************************************************************/
    function openCycl(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ10040_90 %>" + getParam();
        var target = "cycl";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setCycl(data) {
        setData(data);
    }

    
    /**************************************************************************
     *  프로젝트 검색
     **************************************************************************/
    function openPrj(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20010_90 %>" + getParam();
        var target = "prj";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  프로젝트 설정
     **************************************************************************/
    function setPrj(data) {
        setData(data);
    }

    
    /**************************************************************************
     *  업무 검색
     **************************************************************************/
    function openCtrl(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_90 %>" + getParam();
        var target = "ctrl";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setCtrl(data) {
    	setData(data);
    }

    
    
    
    /**************************************************************************
     *  업체 검색
     **************************************************************************/
    function openCo(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99031_90 %>" + getParam();
        var target = "co";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  업체 설정
     **************************************************************************/
    function setCo(data) {
        setData(data);
    }

    
    /**************************************************************************
     *  업체 설정
     **************************************************************************/
    function setSrchCo(data) {
        document.getElementById("srchCoId").value = data.coId;
        document.getElementById("srchCoNm").value = data.coNm;
    }

    
    /**************************************************************************
     *  업체 설정
     **************************************************************************/
    function setCopyCo(data) {
        document.getElementById("copyCoId").value = data.coId;
        document.getElementById("copyCoNm").value = data.coNm;
    }

    
    
    /**************************************************************************
     *  업무 검색
     **************************************************************************/
    function openDept(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99032_90 %>" + getParam();
        var target = "dept";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setDept(data) {
    	setData(data);
    }

    /**************************************************************************
     *  업무 설정
     **************************************************************************/
    function setSupDept(data) {
        document.getElementById("supDeptId").value = data.deptId;
        document.getElementById("supDeptNm").value = data.deptNm;
    }

    
    
    
    /**************************************************************************
     *  결제 검색
     **************************************************************************/
    function openStm(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ10030_90 %>" + getParam();
        var target = "stm";
        openPopup(target, '', 800, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  결제 설정
     **************************************************************************/
    function setStm(data) {
    	setData(data);
    }

    
    
    /**************************************************************************
     *  결제 검색
     **************************************************************************/
    function openAstStm(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20039_91 %>" + getParam();
        var target = "astStm";
        openPopup(target, '', 800, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  결제 설정
     **************************************************************************/
    function setAstStm(data) {
        setData(data);
    }

    
    
    
</script>
