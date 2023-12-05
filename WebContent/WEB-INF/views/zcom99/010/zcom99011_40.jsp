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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99011_40 %>";

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
        var cd = "";
        
        requestDtl(cd);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(cd) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("cd").value = cd;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99011_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99011_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("grpCd                         ")), Trim("그룹 코드                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("cd                            ")), Trim("코드                          ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("cdNm                          ")), Trim("코드 명                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("seqNum                        ")), Trim("순번                          ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effStaDt                      ")), Trim("유효 시작 일자                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effEndDt                      ")), Trim("유효 종료 일자                ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99011_80 %>";

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
        	$.setDatePickerRange($("#effStaDt"), $("#effEndDt"));
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
        <h1>코드 등록</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                    <div class="input-group">
                        <strong>그룹 코드</strong>
                        <p>
                            <input type="text" name="grpCd"                        id="grpCd"                        value="<c:out value="${resultGrpCd.grpCd                         }"/>" title="그룹 코드"                    class="w-p40" readonly="readonly"/>
                        </p>
                    </div>
                    <div class="input-group">
                        <strong>그룹 코드 명</strong>
                        <p>
                            <input type="text" name="grpCdNm"                      id="grpCdNm"                      value="<c:out value="${resultGrpCd.grpCdNm                       }"/>" title="그룹 코드 명"                 class="w-p90" readonly="readonly"/>
                        </p>
                    </div>
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
            <table class="table list">
                <caption class="blind">검색 목록</caption>
                <colgroup>
                    <col style="width:30px">
                    <col style="width:60px">
                    <col width="10%" />
                    <col width="10%" />
                    <col width="*" />
                    <col width="20%" />
                </colgroup>
                <thead>
                <tr>
                    <th><input type="checkbox" name="delKeyAll" id="delKeyAll" onclick="selectAll(event);" title="모두 선택"></th>
                    <th>번호</th>
                    <th>순번</th>
                    <th>코드</th>
                    <th>코드 명</th>
                    <th>유효 일자</th>
                </tr>
                <tbody>

                <!-- 리스트 -->
                <tbody>
                <c:forEach var="row" items="${resultList}" varStatus="status">
                <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.cd}"/>');">
                    <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" onclick="selectAll(event);" title="선택" value="<c:out value="${row.cd}"/>"></td>
                    <td class="tx-center"><c:out value="${status.count                      }"/></td>
                    <td class="tx-center"><c:out value="${row.seqNum                        }"/></td>
                    <td class="tx-center"><c:out value="${row.cd                            }"/></td>
                    <td class="tx-left"  ><c:out value="${row.cdNm                          }"/></td>
                    <td class="tx-center"><c:out value="${row.effDt                         }"/></td>
                </tr>
                </c:forEach>
                </tbody>
                
            </table>

            <!-- bodyarea -->
            <div class="bodyarea">
                <h4>코드 상세정보</h4>
                <div id="detailLayer">
                    <jsp:include page="./zcom99011_41.jsp" />
                </div>
                <div class="btnarea_bottom">
                    <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
                    <div class="btn default" title="초기화"   onclick="requestInit();return false;">초기화</div>
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
