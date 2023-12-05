<%@page import="project.spring.app.bacr.constants.ActionConstants_Bacr"%>
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

<script type="text/javascript">

    /**************************************************************************
     *  ID저장요청
     **************************************************************************/
    function confirmSave(checkbox) {
        var isRemember;

        if ( checkbox.checked ) {
            isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? PC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");

            if ( !isRemember ) {
                checkbox.checked = false;
                setCookie("saveUserId", "", -1);
            }
        }
    }

    /**************************************************************************
     *  로그인요청
     **************************************************************************/
    function requestLogin() {
        if ( !chkLogin() ) {
            return false;
        }

        if ( document.form1.idSave.checked == false ) {
            setCookie("saveUserId", "", -1);
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Bacr.ACTION_LOGIN %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action;
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 로그인요청
     **************************************************************************/
    function chkLogin() {
        if ( isEmptyObject(document.form1.srchUserId  , "사용자 ID"      ) ) return false;
        if ( isEmptyObject(document.form1.userPwd     , "사용자 비밀번호") ) return false;

        return true;
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {

        var saveUserId = getCookie("saveUserId");
        
        if ( saveUserId != null && saveUserId != "" ) {
            $("#userId" ).val(saveUserId);
            $("#userPwd").focus();
            $("#idSave").attr("checked", true);
        } else {
            $("#userId").focus();
        }

        try {
            message();
        } catch ( e ) {
        }

        try {
        	goHome();
        } catch ( e ) {
        }

    }

    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( event.keyCode == 13 ) {
            requestLogin();
        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>




<c:if test="${!empty sessionUser && home != null}" >
<script type="text/javascript">

	<c:if test="${idSave == '1'}">
	setCookie("saveUserId", "<c:out value="${userId}"/>", 365);
	</c:if>

    /**************************************************************************
     *  사용자 검색
     **************************************************************************/
    function goHome() {
        var action = ctx + "/" + '<c:out value="${home}"/>' + getParam();
        
        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
</script>
</c:if>

</head>


<body>
<div class="login_bg">  
    <div class="login_page">
        <div class="login_wrap">
            <div class="login_container">
                <div class="login_logo">
                    <h1><img src="<%= imgLoc %>/login-h1.png" alt="Login"></h1>
                </div>
                <div class="login">
                    <form name="form1">
                        <input type="hidden" id="selMenuId"    name="selMenuId"    value="${selMenuId   }"/>
                        <fieldset>
                        <legend>증적관리시스템 Login</legend>
                        <div class="login_area">
                            <ul>
                                <li>
                                    <span>아이디</span>
                                    <div class="email">
                                        <input id="srchUserId" name="srchUserId" class="form-control" title="아이디" type="text" placeholder="아이디" format="alpha" required autofocus />
                                    </div>
                                </li>
                                <li>
                                    <span>비밀번호</span>
                                    <div class="pwd">
                                        <input id="userPwd" name="userPwd" class="form-control" title="비밀번호" type="password" placeholder="비밀번호" required />
                                    </div>
                                </li>
                            </ul>
                            <div class="btn_login">
                            <a href="#" type="submit" onclick="requestLogin(); return false;">로그인</a>
                            </div>
                        </div>
                        <div class="login_check_info">
                            <input type="checkbox" id="idSave" name="idSave" value="1" onclick="confirmSave(this);">
                            <label for="idsave">아이디 저장</label>
                        </div>
                        </fieldset>
                    </form>
                </div>
            </div>
            <div class="copy_area">
                <p>COPYRIGHT GADIAN Security. CO., LTD. ALL RIGHTS RESERVED.</p>
            </div>
        </div>
        <!--//login_wrap-->
    </div>
</div>  
</body>
</html>

