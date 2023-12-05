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



            <div class="nav">
                <ul id="accordion" class="accordion">
                    
                <c:set var="supMenuId" value=""/>
                <c:forEach var="row" items="${topMenuList}" varStatus="status">

                    
                    <c:if test="${row.supMenuId != supMenuId}">


                    
                        <c:if test="${status.index != 0}">
                        </ul>
                    </li>
                        </c:if>


                        <c:if test="${row.supMenuId == naviMenu.supMenuId}">
                    <li class="default open">
                        </c:if>
                        <c:if test="${row.supMenuId != naviMenu.supMenuId}">
                    <li>
                        </c:if>


                        
                        
                        <c:set var="supMenuId" value="${row.supMenuId}"/>                    

                        <c:if test="${row.supMenuId == '10'}">
                        <div class="link"><i class="i-setting"></i><c:out value="${row.supMenuNm}"/></div>
                        </c:if>
                        <c:if test="${row.supMenuId == '20'}">
                        <div class="link"><i class="i-project"></i><c:out value="${row.supMenuNm}"/></div>
                        </c:if>
                        <c:if test="${row.supMenuId != '10' && row.supMenuId != '20' && row.supMenuId != '99' }">
                        <div class="link"><i class="i-project"></i><c:out value="${row.supMenuNm}"/></div>
                        </c:if>
                        <c:if test="${row.supMenuId == '99'}">
                        <div class="link"><i class="i-admin"></i><c:out value="${row.supMenuNm}"/></div>
                        </c:if>
                        <ul class="submenu">

                    </c:if>
                    
                            <li>
                            <a href="#" onclick="movePage('<c:out value="${row.actId}"/>', '<c:out value="${row.menuId}"/>');">
                                <c:out value="${row.menuNm}"/>
                            </a>
                            </li>

                </c:forEach>     
                        </ul>
                    </li>
            </div>

