<%@ page
  info         = ""
  language     = "java"
  session      = "true"
  buffer       = "16kb"
  autoFlush    = "true"
  isThreadSafe = "true"
  isErrorPage  = "false"
  contentType  = "text/html; charset=utf-8"
  pageEncoding = "UTF-8"
%>

<%@ page import="project.spring.app.aprj.constants.ActionConstants_Aprj" %>

<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


    <!-- Fixed navbar -->
    <div class="header">
        <div class="inner">
            <h1><a href="#" title="프로젝트 관리 시스템 home으로 이동" onclick="movePage('<%=ActionConstants_Aprj.ACTION_HOME%>'); return false;">프로젝트 관리 시스템</a></h1>
            <div class="t-global">
                <span class="user"><c:out value="${sessionUser.userNm}"/></span>
                <a href="#" onclick="info  (); return false;" title="정보변경"><i class="i-cinfo"></i>정보변경</a>
                <a href="#" onclick="logout(); return false;" title="로그아웃"><i class="i-logout"></i>로그아웃</a>
            </div>
        </div>
        <!--//inner-->  
    </div>  
