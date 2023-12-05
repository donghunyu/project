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
<%
    /* url 지정 페이지 */
    String baseLoc        = request.getContextPath();
    String homeLoc        = baseLoc + "/index.do";

    
    String javascriptLoc  = baseLoc + "/javascript";
    String cssLoc         = baseLoc + "/css";
    String includeLoc     = baseLoc + "/include/bacr/";
    String imgLoc         = baseLoc + "/images";
    
    String bootStrapCssLoc= baseLoc + "/bootstrap/css";
    String bootStrapJsLoc = baseLoc + "/bootstrap/js";
%>
