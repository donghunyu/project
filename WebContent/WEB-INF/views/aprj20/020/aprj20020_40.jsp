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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_40 %>";

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
        var ctrlNum = "";

        requestDtl(coId, prjSerNum, ctrlSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(ctrlNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("ctrlNum").value = ctrlNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("coId                          ")), Trim("업체 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("prjId                         ")), Trim("프로젝트 ID                   ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("ctrlNum                       ")), Trim("통제 번호                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("ctrlNm                        ")), Trim("통제 명                       ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_80 %>";

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

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function openAPRJ20021() {
        var keyId = "ctrlNum";
        var keyNm = "통제 번호";
        
        var key = document.getElementById(keyId);
        
        if ( Trim(key.value) == "" ) {
            alert(keyNm + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(keyNm + "을(를)를 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20021_40 %>" + getParam();
        var target = "APRJ20021";
        openPopup(target, '', 900, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
</script>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>프로젝트 > 통제</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_co_popup.jsp" />

                            <div class="input-group">
                                <strong>프로젝트 ID</strong>
                                <p>
                                <input type="text" name="prjId"                        id="prjId"                        value="<c:out value="${resultHeader.prjId                     }"/>" class="w-p50"  title="프로젝트 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>프로젝트 명</strong>
                                <p>
                                <input type="text" name="prjNm"                        id="prjNm"                        value="<c:out value="${resultHeader.prjNm                     }"/>" class="w-full" title="프로젝트 명" readonly="readonly"/>
                                </p>
                            </div>

                            <div class="input-group">
                                <strong>통제 번호</strong>
                                <p>
                                <input type="text" name="srchCtrlNum"                  id="srchCtrlNum"                  value="<c:out value="${srchCtrlNum                            }"/>" class="w-full" title="통제 번호" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 명</strong>
                                <p>
                                <input type="text" name="srchCtrlNm"                   id="srchCtrlNm"                   value="<c:out value="${srchCtrlNm                             }"/>" class="w-full" title="통제 명" />
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
                            <select title="정렬방법" id="pageRowCnt" name="pageRowCnt" onchange="requestSrch(); return false;">
		                        <option value="10" <c:if test="${pageRowCnt == 10}">selected</c:if>>10개씩 보기</option>
		                        <option value="20" <c:if test="${pageRowCnt == 20}">selected</c:if>>20개씩 보기</option>
		                        <option value="30" <c:if test="${pageRowCnt == 30}">selected</c:if>>30개씩 보기</option>
                            </select>
                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="삭제" onclick="requestDel();return false;">삭제</div>
                        </div>
                    </div>

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="20%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>통제 번호</th>
                            <th>통제 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.ctrlNum}"/>');">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.ctrlNum}"/>"></td>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ctrlNum                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ctrlNm                        }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

                <!-- bodyarea -->
                <div class="bodyarea">
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj20020_41.jsp" />
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="자산 구분" onclick="openAPRJ20021();return false;">자산 구분</div>
                        <div class="btn default" title="저장"      onclick="requestSave();return false;">저장</div>
                        <div class="btn default" title="초기화"    onclick="requestInit();return false;">초기화</div>
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
