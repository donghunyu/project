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
                                <th>이관 일련번호</th>
                                <td>
                                    <input type="text" name="trnsfSerNum"                  id="trnsfSerNum"                  value="<c:out value="${resultObject.trnsfSerNum                   }"/>" title="이관 일련번호"                maxlength="22"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultObject.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultObject.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
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
                                <th>이관 업무 담당 ID</th>
                                <td>
                                    <input type="text" name="trnsfOpChrgId"                id="trnsfOpChrgId"                value="<c:out value="${resultObject.trnsfOpChrgId                 }"/>" title="이관 업무 담당 ID"            maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>이관 업무 담당 ID</th>
                                <td>
                                    <input type="text" name="trnsfOpChrgNm"                id="trnsfOpChrgNm"                value="<c:out value="${resultObject.trnsfOpChrgNm                 }"/>" title="이관 업무 담당 명"            maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>이관 사용자 ID</th>
                                <td>
                                    <input type="text" name="trnsfUserId"                  id="trnsfUserId"                  value="<c:out value="${resultObject.trnsfUserId                   }"/>" title="이관 사용자 ID"               maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>이관 사용자 ID</th>
                                <td>
                                    <input type="text" name="trnsfUserNm"                  id="trnsfUserNm"                  value="<c:out value="${resultObject.trnsfUserNm                   }"/>" title="이관 사용자 명"               maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>이관 내용</th>
                                <td colspan="3">
                                    <textarea          name="trnsfCtt"                     id="trnsfCtt"                                                                                             title="이관 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" readonly="readonly"><c:out value="${resultObject.trnsfCtt}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>이관 여부</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="trnsfTranCd"                   id="trnsfTranCd"                   class="w-full">
                                    <c:forEach var="code" items="${trnsfTranCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.trnsfTranCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>이관 일시</th>
                                <td>
                                    <input type="text" name="trnsfDtm"                     id="trnsfDtm"                     value="<c:out value="${resultObject.trnsfDtmFormat                }"/>" title="이관 일시"                    maxlength="14"   class="w-full"  readonly="readonly"/>
                                </td>
                            <tr>
                            <tr>
                                <th>이관 처리 내용</th>
                                <td colspan="3">
                                    <textarea          name="trnsfTranCtt"                 id="trnsfTranCtt"                                                                                         title="이관 처리 내용"               maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.trnsfTranCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("opId                          ")));
        setKeyDisabled(document.getElementById(Trim("opSerNum                      ")));
        setKeyDisabled(document.getElementById(Trim("trnsfSerNum                   ")));
    }

    setKeyReadonly();

</script>
