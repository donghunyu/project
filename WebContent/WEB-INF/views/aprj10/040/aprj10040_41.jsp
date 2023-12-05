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
                                <th>주기 ID</th>
                                <td>
                                    <input type="text" name="cyclId"                       id="cyclId"                       value="<c:out value="${resultObject.cyclId                        }"/>" title="주기 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>주기 명</th>
                                <td>
                                    <input type="text" name="cyclNm"                       id="cyclNm"                       value="<c:out value="${resultObject.cyclNm                        }"/>" title="주기 명"                      maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>기간 수</th>
                                <td>
                                    <input type="text" name="prdCnt"                       id="prdCnt"                       value="<c:out value="${resultObject.prdCnt                        }"/>" title="기간 수"                      maxlength="5"    class="w-p30" format="numeric"/>
                                    <span class="select-box w-p20">
                                    <select name="cyclClCd"                     id="cyclClCd"                     class="w-full">
                                    <c:forEach var="code" items="${cyclClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.cyclClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>기준 일자</th>
                                <td>
                                    <span class="date_box"><input type="text" name="stdDt"                        id="stdDt"                        value="<c:out value="${resultObject.stdDtFormat                   }"/>" title="기준 일자"                    maxlength="10"    class="w-p40" format="10"/></span>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePicker($("#stdDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("cyclId                        ")));
    }

    setKeyReadonly();

</script>
