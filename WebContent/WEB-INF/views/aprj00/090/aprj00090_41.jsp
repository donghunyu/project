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
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_EXCEL_EXECUTE %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkSave() {
        if ( isEmptyObject(document.getElementById(Trim("uploadFile                    ")), Trim("파일                          ")) ) return false;

        return true;
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        DisabledBackColor();
        fncInitControl();

        try {
        	message();
        } catch (e) {

        }
        
        try {
            <c:if test="${!empty msgCtt}" >
            opener.requestSrch();
            self.close();
            </c:if>
        } catch (e) {

        }
    }

    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( getKeyCode(event) == 13 )
        {
            if ( event.srcElement.name.indexOf("srch") == 0 ) {
                requestSrch();
            }
        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;
    
     
</script>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline" enctype="multipart/form-data">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1><c:out value="${resultObject.workNm}"/> 엑셀 업로드</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                    <div class="input-group">
                        <strong><c:out value="${workNm}"/></strong>
                        <p>
                        <input type="hidden" name="workId"                 id="workId"                 value="<c:out value="${workId                  }"/>" class="w-full" />
                        <input type="hidden" name="workNm"                 id="workNm"                 value="<c:out value="${workNm                  }"/>" class="w-full" />
                        </p>
                    </div>
               </div>
            </div>
            <!--//filter-->
            
            <table class="table form">
                <caption class="blind">상세정보</caption>
                <colgroup>
                    <col style="width:15%">
                    <col style="width:35%">
                    <col style="width:15%">
                    <col style="width:35%">
                </colgroup>
                <tbody>
                    <tr>
                        <th>첨부파일</th>
                        <td colspan="3">
                            <input type="file" name="uploadFile" id="uploadFile" value="" title="첨부파일" class="w-full" />
                        </td>
                    </tr>
                </tbody>
            </table>
                    
            <!-- bodyarea -->
            <div class="bodyarea">
                <div class="btnarea_bottom">
                    <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
                </div>
            </div>
            <!--//bodyarea-->
                
        </div>
        <!--//본문 bodyarea--> 
    </div>
    <!--//box-->
    
    <!-- footer -->
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
    
</div>
<!--//modal-->
</form>
</body>
</html>
