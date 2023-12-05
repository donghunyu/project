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

<%@ include file="/include/bacr/include_header.jsp" %>
<%@ page import="project.spring.app.bacr.constants.ApplicationConstants_Bacr" %>

<script type="text/javascript">
	alert("HOME");
</script>




<c:if test="${!empty sessionUser }" >
    <script type="text/javascript">
        location.href = "<c:out value="${resultObject.scrUrl}"/>";
    </script>
</c:if>

</head>

<body style="background-image: none;">

</body>
</html>