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
                            <div class="input-group w-full">
                                <strong>업체 ID</strong>
                                <p>
                                    <span class="select-box">
                                    <select name="srchCoId"                      id="srchCoId"                      class="w-full" onchange="requestSrch(); return false;">
                                    <c:forEach var="code" items="${coList}" varStatus="status">
		                                <c:if test="${status.index == 0}">
		                                    <c:set var="srchCoId" value="${code.coId}"/>
		                                    <c:set var="srchCoNm" value="${code.coNm}"/>
		                                </c:if>
		                                <c:if test="${code.coId == srchCoId}">
		                                    <c:set var="srchCoId" value="${code.coId}"/>
		                                    <c:set var="srchCoNm" value="${code.coNm}"/>
		                                </c:if>
                                        <option value="${code.coId}" <c:if test="${code.coId == srchCoId}">selected</c:if>>[ ${code.coId} ] ${code.coNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </p>
                                <input type="hidden" name="srchCoNm"                     id="srchCoNm"                     value="<c:out value="${srchCoNm                              }"/>" class="w-full" title="업체 명" />
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                                <input type="hidden" name="srchCoId"                     id="srchCoId"                     value="<c:out value="${sessionUser.coId                      }"/>" class="w-full" title="업체 ID" />
                                <input type="hidden" name="srchCoNm"                     id="srchCoNm"                     value="<c:out value="${sessionUser.coNm                      }"/>" class="w-full" title="업체 명" />
</c:if>

