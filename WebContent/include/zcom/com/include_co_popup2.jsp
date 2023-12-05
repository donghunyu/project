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
                            <div class="input-group">
                                <strong>업체 ID</strong>
                                <p>
                                <input type="text" name="srchCoId"                     id="srchCoId"                     value="<c:out value="${srchCoId                      }"/>" title="업체 ID"  maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 명</strong>
                                <p>
                                <input type="text" name="srchCoNm"                     id="srchCoNm"                     value="<c:out value="${srchCoNm                      }"/>" title="업체 명"  maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                                <input type="hidden" name="srchCoId"                   id="srchCoId"                     value="<c:out value="${srchCoId                      }"/>" class="w-full" title="업체 ID" />
                                <input type="hidden" name="srchCoNm"                   id="srchCoNm"                     value="<c:out value="${srchCoNm                      }"/>" class="w-full" title="업체 명" />
</c:if>
