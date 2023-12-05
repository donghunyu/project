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


<!-- Layer -->
<input type="hidden" name="targetLayer"    id="targetLayer"    value=""/>

<input type="hidden" name="selMenuId"      id="selMenuId"      value="<c:out value="${selMenuId     }"/>"/>
<input type="hidden" name="pageNo"         id="pageNo"         value="<c:out value="${pageNo        }"/>"/>
<input type="hidden" name="returnFunction" id="returnFunction" value="<c:out value="${returnFunction}"/>" />

    <div class="footer" style="z-index:-1;">
        <p>COPYRIGHT GADIAN Security. CO., LTD. ALL RIGHTS RESERVED.</p>
    </div>
