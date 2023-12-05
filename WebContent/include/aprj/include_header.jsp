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

<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/include/aprj/include_resource.jsp" %>
<%@ include file="/include/aprj/include_function.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> 반응성을 끄기위해 viewport meta tag를 삭제-->
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    
    <title>프로젝트관리 시스템</title>
    
    
    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet" type="text/css" href="<%= cssLoc %>/base.css">
    <link rel="stylesheet" type="text/css" href="<%= cssLoc %>/style.css">
    
    <script type="text/javascript" src="<%= javascriptLoc %>/common.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/string.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/numeric.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/date.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/control_format.js"></script>
    
    <script type="text/javascript" src="<%= javascriptLoc %>/page.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/pagingBox.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/window.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/message_box.js"></script>
    
    <script type="text/javascript" src="<%= javascriptLoc %>/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%= javascriptLoc %>/common-ui.js"></script>
    
    <script type="text/javascript" src="<%= javascriptLoc %>/jquery-function.js"></script>
    <script type="text/javascript" src="<%= bootStrapJsLoc %>/bootstrap.js"></script>
    <script type="text/javascript" src="<%= bootStrapJsLoc %>/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="<%= javascriptLoc %>/loading/loading.css">
    <script type="text/javascript" src="<%= javascriptLoc %>/loading/loading.js"></script>

</head>

<%@ include file="/include/aprj/include_popup.jsp" %>

<script type="text/javascript">

    /**************************************************************************
     *  Page이동
     **************************************************************************/
    function movePage(actId, menuId) {
        var action = "<%= baseLoc %>/" + actId;
        
//         document.getElementById("pageNo"   ).value = '1';
//         document.getElementById("selMenuId").value = menuId;

//         document.form1.target = "";
//         document.form1.method = "post";
//         document.form1.action = action + getParam();
//         document.form1.submit();

//         loading();

        
        addParam("newPage", true);
        addParam("selMenuId", menuId);
        var url = "";
        if (action.indexOf('?', 0) > 0) {
            url = action + getParamSep('&');
        } else {
            url = action + getParam();
        }
         
        location.href = url;
        loading();
    }
    
    
    /**************************************************************************
     *  상세서브
     **************************************************************************/
    function setTable(msg) {
        $("#"+$("#targetLayer").val()).html("");
        $("#"+$("#targetLayer").val()).html(msg);

        DisabledBackColor();
        fncInitControl();
    }
     
    
    /**************************************************************************
     *  로그아웃
     **************************************************************************/
    function logout() {
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_LOGOUT %>";
        
        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action;
        document.form1.submit();
        
        loading();
    }
    
    
    /**************************************************************************
     *  정보 변경
     **************************************************************************/
    function info() {
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99030_50 %>";
        
        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action;
        document.form1.submit();
        
        loading();
    }
    
    
    /**************************************************************************
     *  요청 Submit
     **************************************************************************/
    function requestSubmit(actionId, target, isLoading) {
        var action = "<%= baseLoc %>/" + actionId;
        
        if(isNull(target)) {
            target = "";
        }
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
        
        loading();
    }
        
    
    /**************************************************************************
     *  페이징처리
     **************************************************************************/
    function setPaging() {
        var gridPagingId    = "gridPaging"      ;
        var currPage        = "${pageNo}"       ;
        var pageCount       = "${pageRowCnt}"   ;
        var groupCount      = "${grpPageCnt}"   ;
        var totalCount      = "${resultListCnt}";
        var reqPagingFuncNm = "requestPage";
        var delBtnYn        = false;
         
        pagingBox.setPage(gridPagingId, currPage, pageCount, groupCount, totalCount, reqPagingFuncNm, delBtnYn);
    }
    
    
    /**************************************************************************
     *  요청 Ajax Submit
     **************************************************************************/
    function requestAjaxSubmit(actionId, layerId, callback, loadingType) {
        var action = "<%= baseLoc %>/" + actionId + getParam();
         
        if( isNull(callback) ) {
            callback = setTable;
        }
         
        document.getElementById("targetLayer").value = layerId;
        requestPostAjax(action, callback, document.getElementById("targetLayer").value, "", "", "", "", loadingType);
    }
    
    
    /**************************************************************************
     *  화면 종료 요청
     **************************************************************************/
    function requestClose() {
 	    window.close();
    }

     
    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( getKeyCode(event) == 13 ) {
            if ( event.srcElement.name.indexOf("srch") == 0 ) {
                requestSrch();
            }
        }

        // Delete key
		if ( getKeyCode(event) == 46 ) {
            if ( event.srcElement.name == "coId" ) {
            	if ( event.srcElementreadOnly = true ) {
	                document.getElementById("coId").value = "";
	                document.getElementById("coNm").value = "";
            	}
            }

            if ( event.srcElement.name == "deptId" ) {
            	if ( event.srcElementreadOnly = true ) {
	                document.getElementById("deptId").value = "";
	                document.getElementById("deptNm").value = "";
            	}
            }

            if ( event.srcElement.name == "supDeptId" ) {
            	if ( event.srcElementreadOnly = true ) {
	                document.getElementById("supDeptId").value = "";
	                document.getElementById("supDeptNm").value = "";
            	}
            }

            if ( event.srcElement.name == "userId" ) {
            	if ( event.srcElementreadOnly = true ) {
	                document.getElementById("userId").value = "";
	                document.getElementById("userNm").value = "";
            	}
            }

            if ( event.srcElement.name == "supUserId" ) {
            	if ( event.srcElementreadOnly = true ) {
	                document.getElementById("supUserId").value = "";
	                document.getElementById("supUserNm").value = "";
            	}
            }
            
            if ( event.srcElement.name == "prjId" ) {
                if ( event.srcElementreadOnly = true ) {
                    document.getElementById("prjId").value = "";
                    document.getElementById("prjNm").value = "";
                }
            }
        }
    }

      
    /**************************************************************************
     *  EXCEL 다운로드
     **************************************************************************/
    function uploadExcel(workId) {
        
        addParam("workId", workId);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_EXCEL_UPLOAD %>" + getParam();
        var target = "EXCEL_UPLOAD";
        openPopup(target, '', 600, 400, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
     
    
</script>


<script type="text/javascript">
    
    
    /**************************************************************************
     *  프로젝트 검색
     **************************************************************************/
    function movePrj() {
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20010_40 %>" + getParam();
        var target = "";
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    
    /**************************************************************************
     *  통제 검색
     **************************************************************************/
    function moveCtrl() {
        var keyId = "prjId";
        var keyNm = "프로젝트";
        
        var key = document.getElementById(keyId);
        
        if ( Trim(key.value) == "" ) {
            alert(keyNm + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(keyNm + "을(를)를 먼저 등록하세요.");
            return false;
        }
    
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_40 %>" + getParam();
        var target = "";
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }


    /**************************************************************************
     *  업무 검색
     **************************************************************************/
    function moveOp() {
        var keyId = "ctrlSerNum";
        var keyNm = "통제";
        
        var key = document.getElementById(keyId);
        
        if ( Trim(key.value) == "" ) {
            alert(keyNm + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(keyNm + "을(를)를 먼저 등록하세요.");
            return false;
        }
    
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_40 %>" + getParam();
        var target = "";
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }


    /**************************************************************************
     *  요청 검색
     **************************************************************************/
    function moveReq() {
        var keyId = "opSerNum";
        var keyNm = "업무";
        
        var key = document.getElementById(keyId);
        
        if ( Trim(key.value) == "" ) {
            alert(keyNm + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(keyNm + "을(를)를 먼저 등록하세요.");
            return false;
        }
    
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20040_40 %>" + getParam();
        var target = "";
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }


</script>



<c:if test="${!empty msgCtt}" >
<script type="text/javascript">
    function message() {
        createMsg("<c:out value="${msgCtt}"/>");
        alert("<c:out value="${msgCtt}"/>");
    }
</script>
</c:if>
