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
     *  로그인성공시 시작페이지
     **************************************************************************/
    function startPage() {
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_LOGIN %>";
    	
        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action;
        document.form1.submit();
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        startPage();
    }

    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( event.keyCode == 13 )
        {

        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>

<body>
    <form method="post" name="form1">

    </form>
</body>

</html>
