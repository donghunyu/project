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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20035_50 %>";

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
        var coId = "";
        var opId = "";
        var opSerNum = "";
        var prjId = "";
        var ctrlNum = "";
        var astClId = "";
        var trnsfSerNum = "";

        requestDtl(coId, opId, opSerNum, prjId, ctrlNum, astClId, trnsfSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opId, opSerNum, prjId, ctrlNum, astClId, trnsfSerNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId").value = coId;
        document.getElementById("opId").value = opId;
        document.getElementById("opSerNum").value = opSerNum;
        document.getElementById("prjId").value = prjId;
        document.getElementById("ctrlNum").value = ctrlNum;
        document.getElementById("astClId").value = astClId;
        document.getElementById("trnsfSerNum").value = trnsfSerNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20035_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20035_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("opSerNum                      ")), Trim("업무 일련번호                 ")) ) return false;
        
        <c:if test="${!empty resultOpChrg}">
        if ( isEmptyObject(document.getElementById(Trim("opChrgId                      ")), Trim("업무 담당 ID                  ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("trnsfOpChrgId                 ")), Trim("이관 업무 담당 ID             ")) ) return false;
        </c:if>
        <c:if test="${!empty resultUser}">
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("trnsfUserId                   ")), Trim("이관 사용자 ID                ")) ) return false;
        </c:if>
        
        if ( isEmptyObject(document.getElementById(Trim("trnsfCtt                      ")), Trim("이관 내용                     ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20035_80 %>";

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

</script>




<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>업무 > 통제 > 업무담당 > 담당자이관</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />

               </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
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
                            <tr>
                                <th>이관 일련번호</th>
                                <td>
                                    <input type="text" name="trnsfSerNum"                  id="trnsfSerNum"                  value="<c:out value="${resultObject.trnsfSerNum                   }"/>" title="이관 일련번호"                maxlength="22"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
<c:if test="${!empty resultOpChrg}">
                            <tr>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultOpChrg.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>업무 담당 명</th>
                                <td>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultOpChrg.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
</c:if>
<c:if test="${!empty resultUser}">
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultUser.userId                          }"/>" title="사용자 ID"                    maxlength="20"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultUser.userNm                          }"/>" title="사용자 명"                    maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
</c:if>
                        </tbody>
                    </table>
                    
                <div class="bodyarea">
                    <h4>이관</h4>
                </div>
                    
                    <table class="table form">
                        <caption class="blind">상세정보</caption>
                        <colgroup>
                            <col style="width:15%">
                            <col style="width:35%">
                            <col style="width:15%">
                            <col style="width:35%">
                        </colgroup>
                        <tbody>
<c:if test="${!empty resultOpChrg}">
                            <tr>
                                <th>이관 업무 담당 ID</th>
                                <td>
<c:if test="${empty resultUser}">
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('TRNSF_OP_CHRG'); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                    <input type="text" name="trnsfOpChrgId"                id="trnsfOpChrgId"                value="<c:out value="${resultObject.trnsfOpChrgId                 }"/>" title="이관 업무 담당 ID"            maxlength="10"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>이관 업무 담당 명</th>
                                <td>
                                    <input type="text" name="trnsfOpChrgNm"                id="trnsfOpChrgNm"                value="<c:out value="${resultObject.trnsfOpChrgNm                 }"/>" title="이관 업무 담당 명"            maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
</c:if>
<c:if test="${!empty resultUser}">
                            <tr>
                                <th>이관 사용자 ID</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('OP_CHRG_USER'); return false;"><i class="i-search"></i>찾기</div>
                                    <input type="text" name="trnsfUserId"                  id="trnsfUserId"                  value="<c:out value="${resultObject.trnsfUserId                   }"/>" title="이관 사용자 ID"               maxlength="20"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>이관 사용자 명</th>
                                <td>
                                    <input type="text" name="trnsfUserNm"                  id="trnsfUserNm"                  value="<c:out value="${resultObject.trnsfUserNm                   }"/>" title="이관 사용자 명"               maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
</c:if>
                            <tr>
                                <th>이관 내용</th>
                                <td colspan="3">
                                    <textarea          name="trnsfCtt"                     id="trnsfCtt"                                                                                             title="이관 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.trnsfCtt}"/></textarea>
                                </td>
                            </tr>
                        </tbody>
                    </table>


                <!-- bodyarea -->
                <div class="bodyarea">
                    <div class="btnarea_bottom">
                        <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
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
