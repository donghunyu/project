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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_50 %>";

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
//        if ( isEmptyObject(document.getElementById(Trim("srchStaDt                      ")), Trim("검색 시작일자                 ")) ) return false;
//        if ( isEmptyObject(document.getElementById(Trim("srchEndDt                      ")), Trim("검색 종료일자                 ")) ) return false;

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
        var resSerNum = "";
        var stmSeqNum = "";

        requestDtl(coId, opId, opSerNum, opChrgId, userId, resSerNum, stmSeqNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opId, opSerNum, opChrgId, userId, resSerNum, stmSeqNum) {
        if ( !chkDtl(stmSeqNum) ) {
            return false;
        }

        addParam("coId"     , coId     );
        addParam("opId"     , opId     );
        addParam("opSerNum" , opSerNum );
        addParam("opChrgId" , opChrgId );
        addParam("userId"   , userId   );
        addParam("resSerNum", resSerNum);
        addParam("stmSeqNum", stmSeqNum);
        
        addParam("newPage", true);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_51 %>" + getParam();
        var target = "APRJ20053";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDtl(stmSeqNum) {
        if ( stmSeqNum == null ) {
        	alert('아직 결제자가 지정되지 않았습니다. 결제자 지정 작업이 필요합니다.');
        	return false;
        }
    	
    	
        return true;
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("opChrgId                      ")), Trim("업무 담당 ID                  ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("resSerNum                     ")), Trim("요청 일련번호                 ")) ) return false;
//        if ( isEmptyObject(document.getElementById(Trim("stmOpChrgId                   ")), Trim("결제 업무 담당 ID             ")) ) return false;
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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_80 %>";

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
<!-- 
                            <div class="input-group">
                                <strong>조회 일자</strong>
                                <p>
                                    <span class="date_box"><input type="text" name="srchStaDt" id="srchStaDt" value="${srchStaDt}" title="조회 시작 일자" format="date"/></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="srchEndDt" id="srchEndDt" value="${srchEndDt}" title="조회 종료 일자" format="date"/></span>
                                </p>
                            </div>
 -->
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
                            <col width="*" />
                            <col width="15%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>결제 순번</th>
                            <th>업무 ID</th>
                            <th>업무 명</th>
                            <th>업무 담당 명</th>
                            <th>사용자 명</th>
                            <th>결제 업무 담당 명</th>
                            <th>결제 사용자 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.opId}"/>', '<c:out value="${row.opSerNum}"/>', '<c:out value="${row.opChrgId}"/>', '<c:out value="${row.userId}"/>', '<c:out value="${row.resSerNum}"/>', '<c:out value="${row.stmSeqNum}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmSeqNum                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opId                          }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opNm                          }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmOpChrgNm                   }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmUserNm                     }"/></td>
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
