<%@ page
  info         = "DongHun Yu"
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

<c:if test="${sessionUser.userAuthCd == '1000'}">
    <c:if test="${empty resultObject}">
                            <c:forEach var="code" items="${coList}" varStatus="status">
                                <c:if test="${status.index == 0}">
                                    <c:set var="coId" value="${code.coId}"/>
                                    <c:set var="coNm" value="${code.coNm}"/>
                                </c:if>
                                <c:if test="${code.coId == srchCoId}">
                                    <c:set var="coId" value="${code.coId}"/>
                                    <c:set var="coNm" value="${code.coNm}"/>
                                </c:if>
                            </c:forEach>
                            <tr>
                                <th>업체 ID</th>
                                <td>
                                    <input type="text" name="coId"                         id="coId"                         value="<c:out value="${coId                          }"/>" title="업체 ID"                 maxlength="10"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>업체 명</th>
                                <td>
                                    <input type="text" name="coNm"                         id="coNm"                         value="<c:out value="${coNm                          }"/>" title="업체 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
    </c:if>
    <c:if test="${!empty resultObject}">
                            <tr>
                                <th>업체 ID</th>
                                <td>
                                    <input type="text" name="coId"                         id="coId"                         value="<c:out value="${resultObject.coId                          }"/>" title="업체 ID"                 maxlength="10"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>업체 명</th>
                                <td>
                                    <input type="text" name="coNm"                         id="coNm"                         value="<c:out value="${resultObject.coNm                          }"/>" title="업체 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
    </c:if>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                    <input type="hidden" name="coId"                         id="coId"                         value="<c:out value="${sessionUser.coId                          }"/>" title="업체 ID"                      maxlength="10"   class="w-full"  />
                    <input type="hidden" name="coNm"                         id="coNm"                         value="<c:out value="${sessionUser.coNm                          }"/>" title="업체 명"                      maxlength="100"  class="w-full" />

</c:if>
