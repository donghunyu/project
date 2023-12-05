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
                                <input type="text" name="coId"                     id="coId"                     value="<c:out value="${resultHeader.coId                      }"/>" title="업체 ID"  maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 명</strong>
                                <p>
                                <input type="text" name="coNm"                     id="coNm"                     value="<c:out value="${resultHeader.coNm                      }"/>" title="업체 명"  maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 ID</strong>
                                <p>
                                <input type="text" name="opId"                 id="opId"                 value="<c:out value="${resultHeader.opId                  }"/>" class="w-full" title="업무 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 버전</strong>
                                <p>
                                <input type="text" name="opSerNum"             id="opSerNum"             value="<c:out value="${resultHeader.opSerNum              }"/>" class="w-full" title="업무 일련번호" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group w-full">
                                <strong>업무 명</strong>
                                <p>
                                <input type="text" name="opNm"                 id="opNm"                 value="<c:out value="${resultHeader.opNm                  }"/>" class="w-full" title="업무 명" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                                <input type="hidden" name="coId"                     id="coId"                     value="<c:out value="${resultHeader.coId                      }"/>" class="w-full" title="업체 ID" />
                                <input type="hidden" name="coNm"                     id="coNm"                     value="<c:out value="${resultHeader.coNm                      }"/>" class="w-full" title="업체 명" />
                            <div class="input-group">
                                <strong>업무 ID</strong>
                                <p>
                                <input type="text" name="opId"                 id="opId"                 value="<c:out value="${resultHeader.opId                  }"/>" class="w-full" title="업무 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 일련번호</strong>
                                <p>
                                <input type="text" name="opSerNum"             id="opSerNum"             value="<c:out value="${resultHeader.opSerNum              }"/>" class="w-full" title="업무 일련번호" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group w-full">
                                <strong>업무 명</strong>
                                <p>
                                <input type="text" name="opNm"                 id="opNm"                 value="<c:out value="${resultHeader.opNm                  }"/>" class="w-full" title="업무 명" readonly="readonly"/>
                                </p>
                            </div>
</c:if>

