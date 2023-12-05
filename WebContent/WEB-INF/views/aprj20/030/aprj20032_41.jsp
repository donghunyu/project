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
                                <th>결제 일련번호</th>
                                <td>
                                    <input type="text" name="stmSerNum"                    id="stmSerNum"                    value="<c:out value="${resultObject.stmSerNum                     }"/>" title="결제 일련번호"                maxlength="5"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 순번</th>
                                <td>
                                    <input type="text" name="stmSeqNum"                    id="stmSeqNum"                    value="<c:out value="${resultObject.stmSeqNum                     }"/>" title="결제 순번"                    maxlength="5"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>결제 구분 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="stmClCd"                      id="stmClCd"                      class="w-full">
                                    <c:forEach var="code" items="${stmClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.stmClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>결제 권한 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="stmAuthCd"                    id="stmAuthCd"                    class="w-full" onchange="changeStmAuthCd(); return false;">
                                    <c:forEach var="code" items="${stmAuthCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.stmAuthCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                            </tr>
                            <tr id="op_chrg_area">
                                <th>결제 업무 담당 ID</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('STM_OP_CHRG'); return false;">찾기</div>
                                    <input type="text" name="stmOpChrgId"                  id="stmOpChrgId"                  value="<c:out value="${resultObject.stmOpChrgId                   }"/>" title="결제 업무 담당 ID"            maxlength="10"   class="w-p50"  readonly="readonly"/>
                                </td>
                                <th>결제 업무 담당 명</th>
                                <td>
                                    <input type="text" name="stmOpChrgNm"                  id="stmOpChrgNm"                  value="<c:out value="${resultObject.stmOpChrgNm                   }"/>" title="결제 업무 담당 명"                             class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("opId                          ")));
        setKeyDisabled(document.getElementById(Trim("opSerNum                      ")));
        setKeyDisabled(document.getElementById(Trim("stmSerNum                     ")));
    }

    setKeyReadonly();

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function changeStmAuthCd() {
        var DivObject = document.getElementById("op_chrg_area");
        
        if ( document.getElementById("stmAuthCd").value == 2000 ) {
            DivObject.style.display = "";
        } else {
            DivObject.style.display = "none";
        }
    }

    changeStmAuthCd();
    
</script>
