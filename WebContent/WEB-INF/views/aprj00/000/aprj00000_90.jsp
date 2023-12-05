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

<script type="text/javascript">

	/**************************************************************************
	 *  사용자 검색
	 **************************************************************************/
	function requestHome() {
	    var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_HOME %>" + getParam();
	    
	    document.form1.target = "";
	    document.form1.method = "post";
	    document.form1.action = action + getParam();
	    document.form1.submit();
	}
	
</script>


</head>

<%-- <link rel="stylesheet" type="text/css" href="<%= cssLoc %>/reset.css" /> --%>
<link rel="stylesheet" type="text/css" href="<%= cssLoc %>/login.css?" />
</head>

<body style="background-image: none;">
    <div class="container">
        <form name="form1" class="form-signin">
            <h2 class="form-signin-heading">올바른 접근 경로가 아닙니다.</h2>

            <div class="btn btn-lg btn-primary btn-block" onclick="requestHome(); return false;">Home</div>
        </form>
    </div>
</body>
</html>