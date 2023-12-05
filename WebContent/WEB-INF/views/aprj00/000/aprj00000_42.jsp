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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10010_40 %>";

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
        requestDtl(coId, astCd);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, astCd) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId").value = coId;
        document.getElementById("astCd").value = astCd;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10010_41 %>" + getParam();

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
                <div class="titlearea">
                    <h3>업무 리스트</h3>
                </div>


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

                            <jsp:include page="/include/aprj/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>조회 일자</strong>
                                <p>
                                    <span class="date_box"><input type="text" name="srchStaDt" id="srchStaDt" value="${srchStaDt}" title="조회 시작 일자" format="date"/></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="srchEndDt" id="srchEndDt" value="${srchEndDt}" title="조회 종료 일자" format="date"/></span>
                                </p>
                            </div>

                            <div class="input-group">
                                <strong>자산 코드</strong>
                                <p>
                            <span class="select-box w-full">
                                <select name="srchAstCd"                    id="srchAstCd"                    class="form-control input-sm">
                                    <option value="">전체</option>
                                    <c:forEach var="code" items="${astCdList}" varStatus="status">
                                    <option value="${code.cd}" <c:if test="${code.cd == srchAstCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                </select>
                            </span>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>자산 명</strong>
                                <p>
                                <input type="text" name="srchAstNm"                    id="srchAstNm"                    value="<c:out value="${srchAstNm                     }"/>" class="w-full" title="자산 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>자산 내용</strong>
                                <p>
                                <input type="text" name="srchAstCtt"                   id="srchAstCtt"                   value="<c:out value="${srchAstCtt                    }"/>" class="w-full" title="자산 내용" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>삭제 여부</strong>
                                <p>
                                <input type="text" name="srchDelYn"                    id="srchDelYn"                    value="<c:out value="${srchDelYn                     }"/>" class="w-full" title="삭제 여부" />
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
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>업체 ID</th>
                            <th>자산 코드</th>
                            <th>자산 명</th>
                            <th>자산 내용</th>
                            <th>삭제 여부</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.astCd}"/>');">
                            <td class="center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.coId}"/>_<c:out value="${row.astCd}"/>"></td>
                            <td class="center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="left"  ><c:out value="${row.astCd                         }"/></td>
                            <td class="left"  ><c:out value="${row.astNm                         }"/></td>
                            <td class="left"  ><c:out value="${row.astCtt                        }"/></td>
                            <td class="left"  ><c:out value="${row.delYn                         }"/></td>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>
                </div>
                <!-- bodyarea -->

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