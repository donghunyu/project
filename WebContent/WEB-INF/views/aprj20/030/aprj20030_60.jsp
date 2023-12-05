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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_60 %>";

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
        var coId     = "";
        var opId     = "";
        var opSerNum = "";
        var opChrgId = "";
        var userId   = "";

        requestDtl(coId, opId, opSerNum, opChrgId, userId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opId, opSerNum, opChrgId, userId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId"    ).value = coId;
        document.getElementById("opId"    ).value = opId;
        document.getElementById("opSerNum").value = opSerNum;
        document.getElementById("opChrgId").value = opChrgId;
        document.getElementById("userId"  ).value = userId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_51 %>" + getParam();

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
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_00 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkSave() {
        if ( isEmptyObject(document.getElementById(Trim("coId                          ")), Trim("업체 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opId                          ")), Trim("업무 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opNm                          ")), Trim("업무 명                       ")) ) return false;
//        if ( isEmptyObject(document.getElementById(Trim("opSeqNum                      ")), Trim("업무 순번                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("prdCnt                        ")), Trim("기간 수                       ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_80 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
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
        var url = "<%= baseLoc %>/" + "doc/user_op_sample.xlsx";
        location.href = url;

    }
     
    
    /**************************************************************************
     *  요청
     **************************************************************************/
    function openAPRJ20050() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_40 %>" + getParam();
        var target = "APRJ20050";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function openAPRJ20011() {
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
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_40 %>" + getParam();
        var target = "APRJ20011";
        openPopup(target, '', 900, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  요청
     **************************************************************************/
    function openAPRJ20030_60() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_60 %>" + getParam();
        var target = "APRJ20030_60";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
</script>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>업무 > 보고서 등록</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>보고서 ID</strong>
                                <p>
                                <input type="text" name="srchOpId"                     id="srchOpId"                     value="<c:out value="${resultHeader.opId                      }"/>" class="w-full" title="업무 ID" readonly="readonly"/>
                                </p>
                            </div>

               </div>
                <!--//form-group-->
                <div class="btnarea">
                </div>
            </div>
            <!--//filter-->
            
                    <table class="table form">
                        <caption class="blind">상세정보</caption>
                        <colgroup>
                            <col style="width:15%">
                            <col style="width:35%">
                            <col style="width:15%">
                            <col style="width:35%">
                        </colgroup>
                        <tbody>
                            <jsp:include page="/include/aprj/com/include_co_detail.jsp" />
                            
                            <tr>
                                <th>보고 명</th>
                                <td colspan="3">
                                    <input type="text" name="opNm"                         id="opNm"                         value="<c:out value="${resultObject.opNm                          }"/>" title="업무 명"                      maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>보고 내용</th>
                                <td colspan="3">
                                    <textarea          name="opCtt"                        id="opCtt"                                                                                                title="업무 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" readonly="readonly"><c:out value="${resultObject.opCtt}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultObject.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>업무 담당 명</th>
                                <td>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultObject.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            <tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            <tr>
                        </tbody>
                    </table>
                    <br/>

                <!-- bodyarea -->
                <div class="bodyarea">
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj20030_61.jsp" />
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="저장"   onclick="requestSave(); return false;">저장</div>
                    </div>
                </div>
                <!--//bodyarea-->
                
        </div>
        <!--//본문 bodyarea--> 
    </div>
    <!--//box-->
    
    <!-- footer -->
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
    
</div>
<!--//modal-->
</form>
</body>
</html>
