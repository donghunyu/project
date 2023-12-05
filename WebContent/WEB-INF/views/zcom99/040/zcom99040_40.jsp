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
    function requestSrch(type) {
        requestPage(1, type);
    }

    /**************************************************************************
     *  검색 요청
     **************************************************************************/
    function requestPage(pageNo, type) {
        if ( !chkPage() ) {
            return false;
        }

        document.getElementById("pageNo").value = pageNo;

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_40 %>";
        if (type == "USER") {
        	action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_50 %>";
        } else if ( type == "SIGN" ) {
            action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_51 %>";
        } else if ( type == "OP" ) {
            action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_52 %>";
        }

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
        requestDtl(tmpLoginId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(tmpLoginId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("tmpLoginId").value = tmpLoginId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("tmpLoginId                    ")), Trim("임시 로그인 ID                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("scrUrl                        ")), Trim("화면 URL                      ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effStaDt                      ")), Trim("유효 시작 일자                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effEndDt                      ")), Trim("유효 종료 일자                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("delYn                         ")), Trim("삭제 여부                     ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99040_80 %>";

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
                document.getElementById("srchEndDt").value = now.format("yyyy-MM-dd");
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
    <jsp:include page="/include/zcom/menu/topMenu.jsp" />


    <div class="container">
        <div class="inner">

	    <!-- top menu -->
	    <jsp:include page="/include/zcom/menu/leftMenu.jsp" />

            <div class="content">


            <!-- navi Menu -->
            <jsp:include page="/include/zcom/menu/naviMenu.jsp" />


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

                            <jsp:include page="/include/zcom/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>조회 일자</strong>
                                <p>
                                    <span class="date_box"><input type="text" name="srchStaDt" id="srchStaDt" value="${srchStaDt}" title="조회 시작 일자" format="date"/></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="srchEndDt" id="srchEndDt" value="${srchEndDt}" title="조회 종료 일자" format="date"/></span>
                                </p>
                            </div>

                            <div class="input-group">
                                <strong>임시 로그인 ID</strong>
                                <p>
                                <input type="text" name="srchTmpLoginId"               id="srchTmpLoginId"               value="<c:out value="${srchTmpLoginId                }"/>" class="w-full" title="임시 로그인 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 ID</strong>
                                <p>
                                <input type="text" name="srchUserId"                   id="srchUserId"                   value="<c:out value="${srchUserId                    }"/>" class="w-full" title="사용자 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 명</strong>
                                <p>
                                <input type="text" name="srchUserNm"                   id="srchUserNm"                   value="<c:out value="${srchUserNm                    }"/>" class="w-full" title="사용자 명" />
                                </p>
                            </div>

                        </div>
                        <!-- form-group -->

                        <div class="btnarea">
                            <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                        </div>

                    </div>
                    <!-- filter area -->


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
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                            <col width="15%" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>임시 로그인 ID</th>
                            <th>사용자 ID</th>
                            <th>사용자 명</th>
                            <th>화면 URL</th>
                            <th>유효 일자</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.tmpLoginId}"/>');">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.tmpLoginId}"/>"></td>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.tmpLoginId                    }"/></td>
                            <td class="tx-center"><c:out value="${row.userId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.scrUrl                        }"/></td>
                            <td class="tx-center"><c:out value="${row.effDt                         }"/></td>
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
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
		            <div id="detailLayer">
		                <jsp:include page="./zcom99040_41.jsp" />
		            </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="업무 갱신" onclick="requestSrch('OP'  );return false;">업무 갱신</div>
                        <div class="btn default" title="업무 메일" onclick="requestSrch('USER');return false;">업무 메일</div>
                        <div class="btn default" title="결제 메일" onclick="requestSrch('SIGN');return false;">결제 메일</div>
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
    <jsp:include page="/include/zcom/include_footer.jsp" />
    <!--//footer -->
</div>
<!--//wrap -->

</form>
</body>
</html>