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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_50 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("srchStaDt                      ")), Trim("검색 시작일자                 ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("srchEndDt                      ")), Trim("검색 종료일자                 ")) ) return false;

        return true;
    }

    /**************************************************************************
     *  초기화
     **************************************************************************/
    function requestInit() {
        var coId = "";
        var opId = "";
        var opSerNum = "";
        var opChrgId = "";
        var userId = "";
        var stmSeqNum = "";

        requestDtl(coId, opId, opSerNum, opChrgId, userId, stmSeqNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opId, opSerNum, opChrgId, userId, stmSeqNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId").value = coId;
        document.getElementById("opId").value = opId;
        document.getElementById("opSerNum").value = opSerNum;
        document.getElementById("opChrgId").value = opChrgId;
        document.getElementById("userId").value = userId;
        document.getElementById("stmSeqNum").value = stmSeqNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_51 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("stmSerNum                     ")), Trim("결제 일련번호                 ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opChrgId                      ")), Trim("업무 담당 ID                  ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("stmClCd                       ")), Trim("결제 구분 코드                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("stmUserId                     ")), Trim("결제 사용자 ID                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("signClCd                      ")), Trim("서명 구분 코드                ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_80 %>";

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
        	
            if ( isEmpty(document.getElementById("srchStaDt").value) ) {
                var now  = new Date();
                document.getElementById("srchStaDt").value = now.format("yyyy-MM-dd");
            }
            if ( isEmpty(document.getElementById("srchEndDt").value) ) {
                document.getElementById("srchEndDt").value = now.format("9999-12-31");
            }
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
     *  요청
     **************************************************************************/
    function openAPRJ20036() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_40 %>" + getParam();
        var target = "APRJ20036";
        openPopup(target, '', 1200, 800, "YES");
        
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
                            
<c:if test="${sessionUser.userAuthCd == '1000'}">
                            <div class="input-group">
                                <strong>결제 사용자 ID</strong>
                                <p>
                                <input type="text" name="srchStmUserId"                id="srchStmUserId"                value="<c:out value="${srchStmUserId                 }"/>" class="w-full" title="결제 사용자 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 사용자 명</strong>
                                <p>
                                <input type="text" name="srchStmUserNm"                id="srchStmUserNm"                value="<c:out value="${srchStmUserNm                 }"/>" class="w-full" title="결제 사용자 명" />
                                </p>
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                            <div class="input-group">
                                <strong>결제 사용자 ID</strong>
                                <p>
                                <input type="text" name="srchStmUserId"                id="srchStmUserId"                value="<c:out value="${sessionUser.userId            }"/>" class="w-full" title="사용자 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 사용자 명</strong>
                                <p>
                                <input type="text" name="srchStmUserNm"                id="srchStmUserNm"                value="<c:out value="${sessionUser.userNm            }"/>" class="w-full" title="사용자 명" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
                            <div class="input-group">
                                <strong>조회 일자</strong>
                                <p>
                                    <span class="date_box"><input type="text" name="srchStaDt" id="srchStaDt" value="${srchStaDt}" title="조회 시작 일자" format="date"/></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="srchEndDt" id="srchEndDt" value="${srchEndDt}" title="조회 종료 일자" format="date"/></span>
                                </p>
                            </div>
                        </div>

                        <div class="btnarea">
                            <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                        </div>
                    </div>

                    <div class="list-top">
                        <div class="select-box">
                            <select title="정렬방법">
                                <option>10개씩 보기</option>
                                <option>20개씩 보기</option>
                                <option>30개씩 보기</option>
                            </select>
                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="삭제" onclick="requestDel();return false;">삭제</div>
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
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업무 담당 명</th>
                            <th>사용자 명</th>
                            <th>결제 구분 명</th>
                            <th>결제 권한 명</th>
                            <th>결제 부서 명</th>
                            <th>결제 사용자 명</th>
                            <th>결제 업무 담당 명</th>
                            <th>서명 구분 명</th>
                            <th>서명 일시</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.opId}"/>', '<c:out value="${row.opSerNum}"/>', '<c:out value="${row.opChrgId}"/>', '<c:out value="${row.userId}"/>', '<c:out value="${row.stmSeqNum}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmClNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmAuthNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmDeptNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmUserNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmOpChrgNm                   }"/></td>
                            <td class="tx-left"  ><c:out value="${row.signClNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.signDtmFormat                 }"/></td>
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
                        <jsp:include page="./aprj20036_51.jsp" />
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="결제"       onclick="openAPRJ20036();return false;">결제</div>
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
