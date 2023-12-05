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

                <div class="titlearea">
                    <h3><c:out value="${naviMenu.menuNm}"/></h3>
                    <ul class="location">
                        <li><c:out value="${naviMenu.supMenuNm}"/></li>
                        <li><c:out value="${naviMenu.menuNm}"/></li>
                    </ul>
                </div>
        