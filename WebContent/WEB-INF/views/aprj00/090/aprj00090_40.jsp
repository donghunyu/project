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
     *  검색 요청
     **************************************************************************/
    function requestPage(pageNo) {
        if ( !chkPage() ) {
            return false;
        }

        document.getElementById("pageNo").value = pageNo;

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_EXCEL_UPLOAD %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkPage() {

        return true;
    }

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

        <c:forEach var="row" items="${resultList}" varStatus="status">
        document.getElementById("file_<c:out value="${row.menuId}"/>").value = document.getElementById("uploadFile_<c:out value="${row.menuId}"/>").value;
        </c:forEach>

        return true;
    }

    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function clearFile(objId) {
        document.getElementById(objId).value = "";
    }


    /**************************************************************************
     *  데이터 전체 삭제
     **************************************************************************/
    function requestDeleteAll() {
        if ( !confirm("모든 데이터가 삭제 됩니다. 진행하시겠습니까?") ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_DATA_DELETE_ALL %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
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
<form id="form1" name="form1" class="form-inline" enctype="multipart/form-data">
<div class="wrap">

    <!-- top menu -->
    <jsp:include page="/include/aprj/menu/topMenu.jsp" />


    <div class="container">
        <div class="inner">

        <!-- top menu -->
        <jsp:include page="/include/aprj/menu/leftMenu.jsp" />

            <div class="content">


            <!-- navi Menu -->
            <jsp:include page="/include/aprj/menu/naviMenu.jsp" />


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

                        </div>
                        <!-- form-group -->

                        <div class="btnarea">
                        
                        </div>

                    </div>
                    <!-- filter area -->


                    <div class="list-top">
                        <div class="select-box">
                        
                        </div>
                        <div class="btnarea">
                        
                        </div>
                    </div>

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col width="15%" />
                            <col width="20%" />
                            <col width="*" />
                            <col style="width:30px">
                        </colgroup>
                        <tr>
                            <th>메뉴 ID</th>
                            <th>메뉴 명</th>
                            <th>파일</th>
                            <th>삭제</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr>
                            <td class="tx-left"  ><c:out value="${row.menuId}"/></td>
                            <td class="tx-left"  ><c:out value="${row.menuNm}"/></td>
                            <td class="tx-left"  ><input type="hidden" name="file_<c:out value="${row.menuId}"/>" id="file_<c:out value="${row.menuId}"/>"/><input type="file" name="uploadFile_<c:out value="${row.menuId}"/>" id="uploadFile_<c:out value="${row.menuId}"/>" value="" title="첨부파일" class="w-full" /></td>
                            <td class="tx-left"  ><a href="#" onclick="clearFile('uploadFile_<c:out value="${row.menuId}"/>');"><img src="<%= imgLoc %>/icon_del.gif"></a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>
                </div>
                <!-- bodyarea -->

                <!-- bodyarea -->
                <div class="bodyarea">
                    <div id="detailLayer">
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="데이터전체삭제" onclick="requestDeleteAll();return false;">데이터전체삭제</div>
                        <div class="btn default" title="저장"           onclick="requestSave     ();return false;">저장</div>
                    </div>
                </div>
                <!--//bodyarea-->
            </div>
            <!--//content-->
        </div>
        <!--//inner -->
    </div>
    <!--//container -->

    <!-- footer -->
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
</div>
<!--//wrap -->

</form>
</body>
</html>
