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
                            <jsp:include page="/include/aprj/com/include_co_detail.jsp" />

                            <tr>
                                <th>업체 ID</th>
                                <td>
                                    <input type="text" name="coId"                         id="coId"                         value="<c:out value="${resultObject.coId                          }"/>" title="업체 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>업무 ID</th>
                                <td>
                                    <input type="text" name="opId"                         id="opId"                         value="<c:out value="${resultObject.opId                          }"/>" title="업무 ID"                      maxlength="10"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>업무 일련번호</th>
                                <td>
                                    <input type="text" name="opSerNum"                     id="opSerNum"                     value="<c:out value="${resultObject.opSerNum                      }"/>" title="업무 일련번호"                maxlength="22"   class="w-full" />
                                </td>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultObject.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" />
                                </td>
                                <th>응답 일련번호</th>
                                <td>
                                    <input type="text" name="resSerNum"                    id="resSerNum"                    value="<c:out value="${resultObject.resSerNum                     }"/>" title="응답 일련번호"                maxlength="22"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>처리 상태 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="tranStCd"                     id="tranStCd"                     class="w-full">
                                    <c:forEach var="code" items="${tranStCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.tranStCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>처리 일자</th>
                                <td>
                                    <span class="date_box"><input type="text" name="tranDt"                       id="tranDt"                       value="<c:out value="${resultObject.tranDtFormat                  }"/>" title="처리 일자"                    maxlength="8"    class="w-full"/></span>
                                </td>
                            </tr>
                            <tr>
                                <th>유효 일자</th>
                                <td colspan="3">
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date"></span>
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
        setKeyDisabled(document.getElementById(Trim("opChrgId                      ")));
        setKeyDisabled(document.getElementById(Trim("userId                        ")));
        setKeyDisabled(document.getElementById(Trim("resSerNum                     ")));
    }

    setKeyReadonly();

</script>
