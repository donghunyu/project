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

<%@ include file="/include/aprj/include_header.jsp" %>

<body>

</body>

<c:if test="${!empty msgCtt}" >
<script type="text/javascript">
        alert("<c:out value="${msgCtt}"/>");
</script>
</c:if>

<script type="text/javascript">
    function goLogin() {
        addParam("selMenuId"   , "<c:out value="${selMenuId   }"/>");
        parent.location.href = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_LOGOUT %>" + getParam();
    }
    
    goLogin();
</script>


</html>
