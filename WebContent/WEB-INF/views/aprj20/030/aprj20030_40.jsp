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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_40 %>";

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
        var coId     = "";
        var opId     = "";
        var opSerNum = "";

        requestDtl(coId, opId, opSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opId, opSerNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId"    ).value = coId;
        document.getElementById("opId"    ).value = opId;
        document.getElementById("opSerNum").value = opSerNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("opNm                          ")), Trim("업무 명                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("prdCnt                        ")), Trim("기간 수                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("stdDt                         ")), Trim("기준 일자                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("drftUserId                    ")), Trim("기안 사용자 ID                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("drftUserNm                    ")), Trim("기안 사용자 명                ")) ) return false;
        
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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_80 %>";

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
     *  EXCEL 다운로드
     **************************************************************************/
    function downloadExcel() {
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_70 %>";

        document.form1.target = "_self";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
     
    
    /**************************************************************************
     *  EXCEL 다운로드
     **************************************************************************/
    function downloadExcelStm() {
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_71 %>";

        document.form1.target = "_self";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
     
    
    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestCopy() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_01 %>" + getParam();
        
        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  업무 통제
     **************************************************************************/
    function openAPRJ20031() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20031_40 %>" + getParam();
        var target = "APRJ20031";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  결제
     **************************************************************************/
    function openAPRJ20032() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20032_40 %>" + getParam();
        var target = "APRJ20032";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  업무 담당
     **************************************************************************/
    function openAPRJ20033() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20033_50 %>" + getParam();
        var target = "APRJ20033_50";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  업무 담당
     **************************************************************************/
    function openAPRJ20035() {
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
     *  자산 구분
     **************************************************************************/
    function openAPRJ20038() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20038_50 %>" + getParam();
        var target = "APRJ20038_50";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  요청
     **************************************************************************/
    function openAPRJ20040() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20040_40 %>" + getParam();
        var target = "APRJ20040";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  메일발송
     **************************************************************************/
    function openZcom99040() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_01 %>" + getParam();
        var target = "";
//        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function openAPRJ20011() {
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
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_40 %>" + getParam();
        var target = "APRJ20011";
        openPopup(target, '', 900, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
</script>


<body>
<form id="form1" name="form1" class="form-inline">
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

                            <jsp:include page="/include/aprj/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>프로젝트 ID</strong>
                                <p>
                                <input type="text" name="srchPrjId"                    id="srchPrjId"                    value="<c:out value="${srchPrjId                     }"/>" class="w-full" title="프로젝트 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>프로젝트 명</strong>
                                <p>
                                <input type="text" name="srchPrjNm"                    id="srchPrjNm"                    value="<c:out value="${srchPrjNm                     }"/>" class="w-full" title="프로젝트 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 ID</strong>
                                <p>
                                <input type="text" name="srchCtrlId"                   id="srchCtrlId"                   value="<c:out value="${srchCtrlId                    }"/>" class="w-full" title="통제 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 명</strong>
                                <p>
                                <input type="text" name="srchCtrlNm"                   id="srchCtrlNm"                   value="<c:out value="${srchCtrlNm                    }"/>" class="w-full" title="통제 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 ID</strong>
                                <p>
                                <input type="text" name="srchOpId"                     id="srchOpId"                     value="<c:out value="${srchOpId                      }"/>" class="w-full" title="업무 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 명</strong>
                                <p>
                                <input type="text" name="srchOpNm"                     id="srchOpNm"                     value="<c:out value="${srchOpNm                      }"/>" class="w-full" title="업무 명" />
                                </p>
                            </div>
                        </div>

                        <div class="btnarea">
                            <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                        </div>
                    </div>

                    <div class="list-top">
                        <div class="select-box">
                            <select title="정렬방법" id="pageRowCnt" name="pageRowCnt" onchange="requestSrch(); return false;">
		                        <option value="10" <c:if test="${pageRowCnt == 10}">selected</c:if>>10개씩 보기</option>
		                        <option value="20" <c:if test="${pageRowCnt == 20}">selected</c:if>>20개씩 보기</option>
		                        <option value="30" <c:if test="${pageRowCnt == 30}">selected</c:if>>30개씩 보기</option>
                            </select>
                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="결제 엑셀업로드"   onclick="uploadExcel('OP_STM');return false;">결제 엑셀업로드</div>
                            <div class="btn default" title="결제 엑셀다운로드" onclick="downloadExcelStm();return false;">결제 엑셀다운로드</div>
                            <div class="btn default" title="엑셀업로드"   onclick="uploadExcel('OP');return false;">엑셀업로드</div>
                            <div class="btn default" title="엑셀다운로드" onclick="downloadExcel();return false;">엑셀다운로드</div>
                            <div class="btn default" title="삭제" onclick="requestDel();return false;">삭제</div>
                        </div>
                    </div>
                    <table class="table list" id="item_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="20%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>업무 ID</th>
                            <th>업무 명</th>
                            <th>업무 내용</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.opId}"/>', '<c:out value="${row.opSerNum}"/>');">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.coId}"/>_<c:out value="${row.opId}"/>_<c:out value="${row.opSerNum}"/>"></td>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opId                          }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opNm                          }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opCtt                         }"/></td>
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
                    <h4>업무 상세정보</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj20030_41.jsp" />
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="메일발송"   onclick="openZcom99040();return false;">메일발송</div>
                        <div class="btn default" title="첨부파일"   onclick="openAPRJ20011();return false;">첨부파일</div>
                        <div class="btn default" title="요청"       onclick="openAPRJ20040();return false;">요청</div>
                        <div class="btn default" title="통제"       onclick="openAPRJ20031();return false;">통제</div>
                        <div class="btn default" title="결제"       onclick="openAPRJ20032();return false;">결제</div>
                        <div class="btn default" title="업무담당"   onclick="openAPRJ20033();return false;">업무담당</div>
                        <div class="btn default" title="자산구분"   onclick="openAPRJ20038();return false;">자산구분</div>
                        <div class="btn default" title="업무이관"   onclick="openAPRJ20035();return false;">업무이관</div>
                        <div class="btn default" title="저장"       onclick="requestSave();return false;">저장</div>
                        <div class="btn default" title="초기화"     onclick="requestInit();return false;">초기화</div>
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
