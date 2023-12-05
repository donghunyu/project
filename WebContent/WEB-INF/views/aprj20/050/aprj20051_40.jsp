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

<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/include/aprj/include_header.jsp" %>

<script type="text/javascript">

    /**************************************************************************
     *  검색
     **************************************************************************/
    function requestSrch() {
        requestPage(1);
    }

    /**************************************************************************
     *  검색 요청
     **************************************************************************/
    function requestPage(pageNo) {
        if ( !chkPage() ) {
            return false;
        }

        document.getElementById("pageNo").value = pageNo;

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_40 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
        
        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkPage() {

        return true;
    }

    /**************************************************************************
     *  초기화
     **************************************************************************/
    function requestInit() {
        var reqSerNum = "";

        requestDtl(reqSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(reqSerNum) {
        if ( !chkDtl() ) {
            return false;
        }

        return;
        document.getElementById("reqSerNum").value = reqSerNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_41 %>" + getParam();

        document.getElementById("targetLayer").value = "detailLayer";
        requestPostAjax(action, setTable, document.getElementById("targetLayer").value);
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDtl() {

        return true;
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestSave(resStCd) {
        if ( !chkSave() ) {
            return false;
        }

        addParam("resStCd", resStCd);
        addParam("addRow" , addRow );
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_00 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    var dateList = new Array();
    var dateCnt = 0;
    function addDateList(dateId) {
    	dateList[dateCnt] = dateId;
    	dateCnt++;
    }
    
    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkSave() {
    	/*
        if ( isEmptyObject(document.getElementById(Trim("coId                          ")), Trim("업체 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opId                          ")), Trim("업무 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opSerNum                      ")), Trim("업무 일련번호                 ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("reqTypCd                      ")), Trim("요청 종류 코드                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("reqCtt                        ")), Trim("요청 내용                     ")) ) return false;

        if ( document.getElementById("reqTypCd").value != "1000" ) {
            var objName = "항목값";
            var obj = document.getElementsByName("itmVal");
            
            if ( obj.length > 0 ) {
                for ( var i = 0; i < obj.length; i++ ) {
                    if ( isEmpty(obj[i].value) ) {
                        alert(objName + "은(는) 필수 입력항목입니다.");
                        obj[i].focus();
                        return false;
                    }
                }
            } else {
                alert(objName + "은(는) 필수 입력항목입니다.");
                return false;
            }
        }
        */
        var now  = new Date();
        var currDate = now.format("yyyyMMdd");

        var object;
        for ( var i = 0; i < dateCnt; i++ ) {
        	object = document.getElementById(dateList[i]);
        	if ( getNumber(object.value) > currDate ) {
        	alert("현재일보다 큰 일자는 선택 할 수 없습니다.");
        	object.focus();
        	return false;
        	}
        }
        
        if ( !checkAttachFile("uploadFile") ) {
        	return false;
        }
        
        return true;
    }

    
    
    
    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestRgst() {
        if ( !chkRgst() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_01 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkRgst() {

    	return true;
    }

    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDel() {
        if ( !chkDel() ) {
            alert("삭제 대상이 없습니다. 삭제 대상을 선택하십시요.");
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20052_80 %>" + getParam();

        document.getElementById("targetLayer").value = "detailLayer";
        requestPostAjax(action, setTable, document.getElementById("targetLayer").value);

//        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDel() {
        del = document.getElementsByName("delKey");
        if ( del.length > 0 ) {
            for ( var i = 0; i < del.length; i++ ) {
                if ( del[i].checked == true ) {
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    
    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        DisabledBackColor();
        fncInitControl();
        
        try {
        	setPaging();
        } catch (e) {

        }
        try {
        	$.setDatePickerRange($("#srchStaDt"), $("#srchEndDt"));
        } catch (e) {

        }
        try {
        	message();
        } catch (e) {

        }
        
        if ( "<c:out value="${resultHeader.resStCd}"/>" == "3000" ) {
        	setObjectDisabled();
        	DisabledBackColor();
        } else {
            if ( itmAddButton == true ) {
                document.getElementById("itmAddButton").style.display = "";
            }
        }
    }

    
    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( getKeyCode(event) == 13 )
        {
            if ( event.srcElement.name.indexOf("srch") == 0 ) {
                requestSrch();
            }
        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;


    /**************************************************************************
     *  EXCEL 다운로드
     **************************************************************************/
    function downloadExcel() {
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_70 %>";

        document.form1.target = "_self";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
     
    
    /**************************************************************************
     *  요청
     **************************************************************************/
    function openAPRJ20036() {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_40 %>" + getParam();
        var target = "APRJ20036";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function openAPRJ20052() {
        var keyId = "resSerNum";
        var keyNm = "응답";
        
        var key = document.getElementById(keyId);
        
        if ( Trim(key.value) == "" ) {
            alert(keyNm + "을(를) 먼저 등록하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(keyNm + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20052_40 %>" + getParam();
        var target = "APRJ20052";
        openPopup(target, '', 900, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    var reqSerNum = "";
    /***************************************************************************
     *  팝업 작업
     ***************************************************************************/
    function itmPopup(typCd, reqSerNum) {
    	
        type = "";
        returnFunction = "";
        addParam("reqSerNum", reqSerNum);
        
        switch ( typCd ) {
	        case '1000' :
	            type = "";
	            break;
	        case '1001' :
	            type = "";
	            break;
	        case '2000' :
                type = "";
	            break;
	        case '3000' :
                type = "";
	            break;
	        case '5000' :
                type = "";
	            break;
	        case '5001' :
                type = "";
	            break;
            case '6000' :
                type = "USER";
                returnFunction = "itmUser";
                break;
            case '6001' :
                type = "USER";
                returnFunction = "itmUser";
                break;
            case '6002' :
                type = "USER";
                returnFunction = "itmUser";
                break;
	        case '7000' :
                type = "DEPT";
                returnFunction = "itmDept";
	            break;
	        case '8000' :
                type = "OP_AST";
                returnFunction = "itmOpAst";
	            break;
            case '8001' :
                type = "AST_STM";
                returnFunction = "itmOpAstStm";
                break;
            case '8002' :
                type = "AST";
                returnFunction = "itmAst";
                break;
        }
    	
        requestPopupType(type, returnFunction);
    }


    /**************************************************************************
     *  사용자
     **************************************************************************/
    function itmUser(data) {
        document.getElementById("itm_" + data.reqSerNum).value = data.userId;
        document.getElementById("ctt_" + data.reqSerNum).value = data.userNm;
    }
    
    
    /**************************************************************************
     *  부서
     **************************************************************************/
    function itmDept(data) {
        document.getElementById("itm_" + data.reqSerNum).value = data.deptId;
        document.getElementById("ctt_" + data.reqSerNum).value = data.deptNm;
    }
    
    
    /**************************************************************************
     *  업무자산
     **************************************************************************/
    function itmOpAst(data) {
        document.getElementById("itm_" + data.reqSerNum).value = data.astId;
        document.getElementById("ctt_" + data.reqSerNum).value = data.astNm;
    }
    
    
    /**************************************************************************
     *  업무자산결제자
     **************************************************************************/
    function itmOpAstStm(data) {
        document.getElementById("itm_" + data.reqSerNum).value = data.opChrgId + "/" + data.opChrgNm;
        document.getElementById("ctt_" + data.reqSerNum).value = data.userId   + "/" + data.userNm;
    }
    
    
    /**************************************************************************
     *  자산
     **************************************************************************/
    function itmAst(data) {
        document.getElementById("itm_" + data.reqSerNum).value = data.astId;
        document.getElementById("ctt_" + data.reqSerNum).value = data.astNm;
    }
    
    
    var itmAddButton = false;
    /**************************************************************************
     *  사용자
     **************************************************************************/
    function itmAdd() {
    	itmAddButton = true;
    }
    
    
    /**************************************************************************
     *  점검요청 첨부파일 다운로드
     **************************************************************************/
    function requestDownload(coId, fileSerNum) {
         
        addParam("fileSerNum", fileSerNum);
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_FILE_DOWNLOAD2 %>";

        document.form1.target = "_self";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
     

    
    
</script>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline" enctype="multipart/form-data">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>업무 > 요청 > 응답 상세</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />
                            
                            <div class="input-group">
                                <strong>업무 담당 ID</strong>
                                <p>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultHeader.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 담당 명</strong>
                                <p>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultHeader.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 ID</strong>
                                <p>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultHeader.userId                        }"/>" title="사용자 ID"                   maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 명</strong>
                                <p>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultHeader.userNm                        }"/>" title="사용자 명"                   maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>

                            <div class="input-group">
                                <strong>응답 일련번호</strong>
                                <p>
                                    <input type="text" name="resSerNum"                    id="resSerNum"                    value="<c:out value="${resultHeader.resSerNum                     }"/>" title="응답 일련번호"               maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>응답 일자</strong>
                                <p>
                                    <input type="text" name="resDt"                        id="resDt"                        value="<c:out value="${resultHeader.resDtFormat                   }"/>" title="응답 상태 명"                maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>응답 상태 코드</strong>
                                <p>
                                    <input type="text"                                                                       value="<c:out value="${resultHeader.resStCd                       }"/>" title="응답 상태 코드"              maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>응답 상태 명</strong>
                                <p>
                                    <input type="text"                                                                       value="<c:out value="${resultHeader.resStNm                       }"/>" title="응답 상태 명"                maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
               </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            
            
                    <div class="list-top">
                        <div class="select-box">

                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="엑셀업로드" onclick="uploadExcel('RES');return false;">엑셀업로드</div>
                            <div class="btn default" title="엑셀다운로드" onclick="downloadExcel();return false;">엑셀다운로드</div>
                        </div>
                    </div>

                    <table class="table list" id="item_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="*" />
                            <col width="50%" />
                        </colgroup>
                        <tr>
                            <th>순번</th>
                            <th>요청 종류 코드</th>
                            <th>요청 내용</th>
                            <th>항목</th>
                        </tr>

                        <c:set var="addRow" value="0"/>
                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        
                        <c:if test="${reqSerNum == row.reqSerNum}">
                        <tr>
                            <!-- 단일선택 -->
                            <c:if test="${row.reqTypCd == '2000' }">
                            <td class="tx-left"   >
                                <input type="radio"    name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" <c:if test="${!empty row.resSerNum}">checked</c:if>/><c:out value="${row.itmVal}"/>
                            </td>
                            </c:if>
                            
                            <!-- 단일선택 -->
                            <c:if test="${row.reqTypCd == '2001' }">
                            <td class="tx-left"   >
                                <input type="radio"    name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" <c:if test="${!empty row.resSerNum}">checked</c:if>/><c:out value="${row.itmVal}"/>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <!-- 단항선택 -->
                            <c:if test="${row.reqTypCd == '3000' }">
                            <td class="tx-left"   >
                                <input type="checkbox" name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" <c:if test="${!empty row.resSerNum}">checked</c:if>/><c:out value="${row.itmVal}"/>
                            </td>
                            </c:if>
                        </tr>
                        </c:if>
        
        
                        <c:if test="${reqSerNum != row.reqSerNum}">
                        <c:set var="reqSerNum" value="${row.reqSerNum}"/>
                        <c:set var="rowspan" value="${row.itmCnt}"/>
                        <tr>
                            <c:if test="${!empty row.reqTypCd}">
                            <td class="tx-center" rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqSerNum                     }"/></td>
                            <td class="tx-center" rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqTypNm                      }"/></td>
                            <td class="tx-left"   rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqCtt                        }"/></td>
                            </c:if>
                            
                            <!-- 일반 -->
                            <c:if test="${row.reqTypCd == '1000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <!-- 텍스트 -->
                            <c:if test="${row.reqTypCd == '1001' }">
                            <td class="tx-left"   >
                                <textarea              name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" maxlength="1000" class="w-full" onKeyUp="setMaxLength();" ><c:out value="${row.resCtt}"/></textarea>
                            </td>
                            </c:if>
                            
                            <!-- 단일선택 -->
                            <c:if test="${row.reqTypCd == '2000' }">
                            <td class="tx-left"   >
                                <input type="radio"    name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" <c:if test="${!empty row.resSerNum}">checked</c:if>/><c:out value="${row.itmVal}"/>
                            </td>
                            </c:if>
                            
                            <!-- 단일입력 -->
                            <c:if test="${row.reqTypCd == '2001' }">
                            <td class="tx-left"   >
                                <input type="radio"    name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" <c:if test="${!empty row.resSerNum}">checked</c:if>/><c:out value="${row.itmVal}"/>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <!-- 단항선택 -->
                            <c:if test="${row.reqTypCd == '3000' }">
                            <td class="tx-left"   >
                                <input type="checkbox" name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" <c:if test="${!empty row.resSerNum}">checked</c:if>/><c:out value="${row.itmVal}"/>
                            </td>
                            </c:if>
                            
                            <!-- 일자 -->
                            <c:if test="${row.reqTypCd == '5000' }">
                            <td class="tx-left"   >
<c:if test="${'3000' != resultHeader.resStCd }">
                                <span class="date_box">
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${srchDt}"/></c:if>"  class="w-p30" format="date" readonly="readonly">
                                </span>
</c:if>
<c:if test="${'3000' == resultHeader.resStCd }">
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${srchDt}"/></c:if>"  class="w-p30" format="date" readonly="readonly">
</c:if>
                            </td>
                            </c:if>
                            
                            <!-- 과거일자 -->
                            <c:if test="${row.reqTypCd == '5001' }">
                            <td class="tx-left"   >
<c:if test="${'3000' != resultHeader.resStCd }">
                                <span class="date_box">
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${srchDt}"/></c:if>"  class="w-p30" format="date" readonly="readonly">
                                </span>
	<script type="text/javascript">
	addDateList("itm_<c:out value="${row.reqSerNum}"/>");
	</script>
                                
</c:if>
<c:if test="${'3000' == resultHeader.resStCd }">
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${srchDt}"/></c:if>"  class="w-p30" format="date" readonly="readonly">
</c:if>
                            </td>
                            </c:if>
                            
                            <!-- 사용자 -->
                            <c:if test="${row.reqTypCd == '6000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/><c:if test="${empty row.resId }"><c:out value="${sessionUser.userId}"/></c:if>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${sessionUser.userNm}"/></c:if>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 결제자 -->
                            <c:if test="${row.reqTypCd == '6001' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/><c:if test="${empty row.resId }"><c:out value="${sessionUser.userId}"/></c:if>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${sessionUser.userNm}"/></c:if>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 기안자 -->
                            <c:if test="${row.reqTypCd == '6002' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/><c:if test="${empty row.resId }"><c:out value="${resultHeader.drftUserId}"/></c:if>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${resultHeader.drftUserNm}"/></c:if>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 부서 -->
                            <c:if test="${row.reqTypCd == '7000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/><c:if test="${empty row.resId }"><c:out value="${sessionUser.deptId}"/></c:if>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/><c:if test="${empty row.resCtt}"><c:out value="${sessionUser.deptNm}"/></c:if>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 업무자산 -->
                            <c:if test="${row.reqTypCd == '8000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 업무자산결제자 -->
                            <c:if test="${row.reqTypCd == '8001' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 자산 -->
                            <c:if test="${row.reqTypCd == '8002' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resId }"/>"  class="w-p30" readonly="readonly"/>
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="찾기" onclick="itmPopup('<c:out value="${row.reqTypCd}"/>', '<c:out value="${row.reqSerNum}"/>'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                <input type="text"     name="ctt_<c:out value="${row.reqSerNum}"/>" id="ctt_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.resCtt}"/>"  class="w-p50" readonly="readonly"/>
                            </td>
                            </c:if>
                            
                            <!-- 양식추가 -->
                            <c:if test="${row.reqTypCd == '9000' }">
                            <td class="tx-right"   >
<c:if test="${'3000' != resultHeader.resStCd }">
                                <div class="btn point-b" title="항목추가" onclick="requestAddItem();return false;">항목추가</div>
</c:if>
                            </td>
                            </c:if>
                            
                            <c:if test="${empty row.reqTypCd}">
                            <c:set var="addRow" value="${row.reqSeqNum}"/>
                            <td class="tx-center"><a href="#" onclick="requestDelItem('<c:out value="${row.reqSeqNum}"/>'); return false;"><img src="<%= imgLoc %>/icon_del.gif"></a>
                            <td class="tx-center">[추가] <c:out value="${row.reqSeqNum}"/></td>
                            <td class="tx-right" >
                                <input type="text" name="addId" id="addId" value="<c:out value="${row.resId}"/>" class="w-full" title='항목 내용' maxlength="100" />
                            </td>
                            <td class="tx-right" >
                                <textarea name="addCtt" id="addCtt" maxlength="1000" class="w-full" onKeyUp="setMaxLength();"><c:out value="${row.resCtt}"/></textarea>
                            </td>
                            </c:if>
                        </tr>
                        </c:if>

                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->


                    
                <div class="bodyarea">
                    <h4>첨부파일</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj20051_41.jsp" />
                    </div>
                </div>
                
                <!-- bodyarea -->
                <div class="bodyarea">
                    <div class="btnarea_bottom">
<c:if test="${'3000' != resultHeader.resStCd }">
                        <div class="btn default" title="결제요청" onclick="requestSave('3000');return false;">결제요청</div>
                        <div class="btn default" title="임시저장" onclick="requestSave('2000');return false;">임시저장</div>
</c:if>
<c:if test="${'3000' == resultHeader.resStCd }">
                        <div class="btn default" title="결제취소" onclick="requestSave('4000');return false;">결제취소</div>
</c:if>
                        <div class="btn default" title="결제현황" onclick="openAPRJ20036();return false;">결제현황</div>
                    </div>
                </div>
                <!--//bodyarea-->
        </div>
        <!--//본문 bodyarea--> 
    </div>
    <!--//box-->
    
    
<script type="text/javascript">

    var addRow = <c:out value="${addRow}"/>;

    /**************************************************************************
     *  항목 추가
     **************************************************************************/
    function requestAddItem() {
     
        // 테이블지정
        var TableObject  ;
        var RowObject    ;

        var addRowObject ;
        var addCellObject;
        var nRow         ;

        TableObject = document.getElementById("item_table");

        // Row추가.
        nRow = TableObject.rows.length;
        addRowObject = TableObject.insertRow(nRow);

        addRow++;
        var cnt = 4;
        for ( var i = 0; i < cnt; i++ )
        {
            addCellObject = addRowObject.insertCell();
            
            switch ( i ) {
                // 순번
                case 0:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<a href=\"#\" onclick=\"requestDelItem('" + addRow + "'); return false;\"><img src=\"<%= imgLoc %>/icon_del.gif\"></a>";
                    addCellObject.innerHTML = innerHtml;
                    break;
             
                // 항목 값
                case 1:
                    addCellObject.innerHTML = "[추가] " + addRow;
                    break;
                    
                // 항목 내용
                case 2:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<input type=\"text\" name=\"addId\" id=\"addId\" value=\"\" class=\"w-full\" title='항목 내용' maxlength=\"100\" />";
                    addCellObject.innerHTML = innerHtml;
                    break;
                   
                // 삭제 icon
                case 3:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<textarea name=\"addCtt\" id=\"addCtt\" maxlength=\"1000\" class=\"w-full\" onKeyUp=\"setMaxLength();\"></textarea>";
                    addCellObject.innerHTML = innerHtml;
                    break;
            }
        }
    }
    
    
    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDelItem(rowNum) {
        var TableObject;

        TableObject = document.getElementById("item_table");
        // 중복검색
        for ( var i = 1; i <= TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            
            if ( RowObject.cells[1] == null ) {
            	continue;
            }
            
            if ( RowObject.cells[1].innerHTML == ("[추가] " + rowNum) ) {
                TableObject.deleteRow(i);
                break; 
            }
        }
        
        setRowNumItem();
    }

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function setRowNumItem() {
        // 테이블지정
        var TableObject  ;
        var RowObject    ;

        var addRowObject ;
        var addCellObject;
        var nRow         ;

        TableObject = document.getElementById("item_table");
        addRow = 0;
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            
            if ( RowObject.cells[1] == null ) {
                continue;
            }
            
            if ( RowObject.cells[1].innerHTML.indexOf("[추가]") < 0 ) {
                continue; 
            }
            
            addRow++;
            RowObject.cells[1].innerHTML = "[추가] " + addRow;
            RowObject.cells[0].innerHTML = "<a href=\"#\" onclick=\"requestDelItem('" + addRow + "'); return false;\"><img src=\"<%= imgLoc %>/icon_del.gif\"></a>";
        }
    }

    
</script>
        
    <!-- footer -->
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
    
</div>
<!--//modal-->
</form>
</body>
</html>

