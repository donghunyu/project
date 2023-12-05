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

<%@ include file="/include/zcom/include_header.jsp" %>

<script type="text/javascript">

    /**************************************************************************
     *  검색
     **************************************************************************/
    function requestSrch() {
        requestPage(1);
    }

    /**************************************************************************
     *  검색 요청
     **************************************************************************/
    function requestPage(pageNo) {
        if ( !chkPage() ) {
            return false;
        }

        document.getElementById("pageNo").value = pageNo;

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99022_40 %>";

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
     *  초기화
     **************************************************************************/
    function requestInit() {
        requestDtl(serNum, menuId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(serNum, menuId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("serNum").value = serNum;
        document.getElementById("menuId").value = menuId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99022_41 %>" + getParam();

        document.getElementById("targetLayer").value = "detailLayer";
        requestPostAjax(action, setTable, document.getElementById("targetLayer").value);
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDtl() {

        return true;
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99022_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("serNum                        ")), Trim("일련번호                      ")) ) return false;

        return true;
    }

    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDel() {
        if ( !chkDel() ) {
            alert("삭제 대상이 없습니다. 삭제 대상을 선택하십시요.");
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99022_80 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDel() {
        del = document.getElementsByName("delKey");
        if ( del.length > 0 ) {
            for ( var i = 0; i < del.length; i++ ) {
                if ( del[i].checked == true ) {
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        DisabledBackColor();
        fncInitControl();

        try {
        	setPaging();
        } catch (e) {

        }
        try {
        	$.setDatePickerRange($("#srchStaDt"), $("#srchEndDt"));
        } catch (e) {

        }
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
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>권한 메뉴 등록</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                    <div class="input-group">
                        <strong>일련번호</strong>
                        <p>
                            <input type="text" name="serNum"                       id="serNum"                       value="<c:out value="${resultObject.serNum                        }"/>" title="일련번호"                     maxlength="22"   class="w-full" readonly="readonly"/>
                        </p>
                    </div>
                    <div class="input-group">
                        <strong>메뉴 권한 명</strong>
                        <p>
                            <input type="text" name="menuAuthNm"                   id="menuAuthNm"                   value="<c:out value="${resultObject.menuAuthNm                    }"/>" title="메뉴 권한 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                        </p>
                    </div>
                    <c:if test="${resultObject.menuAuthCd == '1000'}">
                    <div class="input-group">
                        <strong>사용자 권한 명</strong>
                        <p>
                            <input type="text" name="userAuthNm"                   id="userAuthNm"                   value="<c:out value="${resultObject.userAuthNm                    }"/>" title="사용자 권한 명"               maxlength="40"   class="w-full" readonly="readonly"/>
                        </p>
                    </div>
                    </c:if>
                    <c:if test="${resultObject.menuAuthCd == '2000'}">
                    <div class="input-group">
                        <strong>사용자</strong>
                        <p>
                            <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-p40" readonly="readonly"/>
                            <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-p50" readonly="readonly"/>
                        </p>
                    </div>
                    </c:if>
                </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            <div class="list-top">
                <div class="select-box">

                </div>
                <div class="btnarea">
                    <div class="btn default" title="삭제" onclick="requestDel(); return false;">삭제</div>
                </div>
                <!--//btnarea-->
            </div>
            
            
            <table class="table table-bordered table-hover table-condensed">
                <colgroup>
                    <col style="width:30px">
                    <col style="width:60px">
                    <col width="10%" />
                    <col width="20%" />
                    <col width="10%" />
                    <col width="*" />
                    <col width="15%" />
                </colgroup>
                <tr>
                    <th><input type="checkbox" name="delKeyAll" id="delKeyAll" onclick="selectAll(event);" title="모두 선택"></th>
                    <th>No.</th>
                    <th>상위 메뉴 ID</th>
                    <th>상위 메뉴 명</th>
                    <th>메뉴 ID</th>
                    <th>메뉴 명</th>
                    <th>ACTION ID</th>
                </tr>


                <!-- 리스트 -->
                <c:forEach var="row" items="${resultList}" varStatus="status">
                <tr>
                    <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.menuId}"/>" <c:if test="${row.chkMenuId != null}">checked</c:if>></td>
                    <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                    <td class="tx-center"><c:out value="${row.supMenuId                     }"/></td>
                    <td class="tx-left"  ><c:out value="${row.supMenuNm                     }"/></td>
                    <td class="tx-center"><c:out value="${row.menuId                        }"/></td>
                    <td class="tx-left"  ><c:out value="${row.menuNm                        }"/></td>
                    <td class="tx-left"  ><c:out value="${row.actId                         }"/></td>
                </tr>
                </c:forEach>
            </table>

            <!-- bodyarea -->
            <div class="bodyarea">
                <div id="detailLayer">
                </div>
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
    <jsp:include page="/include/zcom/include_footer.jsp" />
    <!--//footer -->
    
</div>
<!--//modal-->
</form>
</body>
</html>
