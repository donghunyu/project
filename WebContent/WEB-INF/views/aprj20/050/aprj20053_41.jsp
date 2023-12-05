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
                                    <input type="text" name="stmSerNum"                    id="stmSerNum"                    value="<c:out value="${resultObject.stmSerNum                     }"/>" title="결제 일련번호"                class="w-full" readonly="readonly"/>
                                </td>
                                <th>서명 구분 코드</th>
                                <td>
                                    <input type="text" name="signClCd"                     id="signClCd"                     value="<c:out value="${resultObject.signClCd                      }"/>" title="서명 구분 코드"               class="w-p30" readonly="readonly"/>
                                    <input type="text" name="signClNm"                     id="signClNm"                     value="<c:out value="${resultObject.signClNm                      }"/>" title="서명 구분 명"                 class="w-p50" readonly="readonly"/>
<!-- 
                                    <span class="select-box w-full" style="disabled : true;">
                                    <select name="signClCd"                     id="signClCd"                     class="w-full">
                                    <c:forEach var="code" items="${signClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.signClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
-->
                                </td>
                            </tr>
                            <tr>
                                <th>서명 일시</th>
                                <td>
                                    <input type="text" name="signDtm"                      id="signDtm"                      value="<c:out value="${resultObject.signDtmFormat                 }"/>" title="서명 일시"                    class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>블록체인</th>
                                <td colspan="3">
                                    <input type="text" name="blcinVal"                     id="blcinVal"                     value="<c:out value="${resultObject.blcinVal                      }"/>" title="블록체인"                     class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>서명 내용</th>
                                <td>
                                    <textarea          name="signCtt"                      id="signCtt"                                                                                              title="서명 내용"                    class="w-full" onKeyUp="setMaxLength();" readonly="readonly"><c:out value="${resultObject.signCtt}"/></textarea>
                                </td>
                            <tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {

    }

    setKeyReadonly();

</script>
