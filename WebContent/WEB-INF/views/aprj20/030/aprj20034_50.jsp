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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20034_50 %>";

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
        var prjId = "";
        var ctrlNum = "";
        var astClId = "";
        var opChrgId = "";
        var userId = "";

        requestDtl(prjId, ctrlNum, astClId, opChrgId, userId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(prjId, ctrlNum, astClId, opChrgId, userId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("prjId").value = prjId;
        document.getElementById("ctrlNum").value = ctrlNum;
        document.getElementById("astClId").value = astClId;
        document.getElementById("opChrgId").value = opChrgId;
        document.getElementById("userId").value = userId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20034_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20034_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("opId                          ")), Trim("업무 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opSerNum                      ")), Trim("업무 일련번호                 ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("prjId                         ")), Trim("프로젝트 ID                   ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("ctrlNum                       ")), Trim("통제 번호                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("astClId                       ")), Trim("자산 구분 ID                  ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opChrgId                      ")), Trim("업무 담당 ID                  ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20034_80 %>";

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

    
    /**************************************************************************
     *  담당자
     **************************************************************************/
    function openAPRJ20034() {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20034_40 %>" + getParam();
        var target = "APRJ20034_40";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    
    /**************************************************************************
     *  이관 요청
     **************************************************************************/
    function openAPRJ20035(opChrgId, userId) {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        addParam("opChrgId", opChrgId);
        addParam("userId"  , userId  );
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20035_50 %>" + getParam();
        var target = "APRJ20035_50";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    
    /**************************************************************************
     *  이관
     **************************************************************************/
    function openAPRJ20035_40() {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20035_40 %>" + getParam();
        var target = "APRJ20035_40";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    
    /**************************************************************************
     *  응답
     **************************************************************************/
    function openAPRJ20050(opChrgId, userId) {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        addParam("opChrgId", opChrgId);
        addParam("userId"  , userId  );
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_40 %>" + getParam();
        var target = "APRJ20050";
        openPopup(target, '', 1200, 800, "YES");
        
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
        <h1>업무 > 통제 > 업무담당 > 업무담당자 상세</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />

               </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            
            
                    <div class="list-top">
                        <div class="select-box">
                            <select title="정렬방법">
                                <option>10개씩 보기</option>
                                <option>20개씩 보기</option>
                                <option>30개씩 보기</option>
                            </select>
                        </div>
                        <div class="btnarea">
                        </div>
                    </div>

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                            <col width="10%" />
                            <col width="10%" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업무 담당 ID</th>
                            <th>업무 담당 명</th>
                            <th>사용자 ID</th>
                            <th>사용자 명</th>
                            <th>응답 상태 명</th>
                            <th>작업 일시</th>
                            <th>요청 등록</th>
                            <th>업무 이관</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgId                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.resStNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.updtDtmFormat                 }"/></td>
                            <td class="tx-center"><div class="btn point-b" title="요청등록"      onclick="openAPRJ20050('<c:out value="${row.opChrgId}"/>', '<c:out value="${row.userId}"/>');return false;">요청등록</div></td>
                            <td class="tx-center"><div class="btn point-b" title="업무이관"      onclick="openAPRJ20035('<c:out value="${row.opChrgId}"/>', '<c:out value="${row.userId}"/>');return false;">업무이관</div></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

                <!-- bodyarea -->
                <div class="bodyarea">
                    <div class="btnarea_bottom">
                        <div class="btn default" title="업무이관"      onclick="openAPRJ20035_40();return false;">업무이관</div>
                        <div class="btn default" title="상세보기"      onclick="openAPRJ20034();return false;">상세보기</div>
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
