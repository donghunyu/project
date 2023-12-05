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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99030_90 %>";

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
     *  선택값반환
     **************************************************************************/
    function returnDtl(coId, userId, userNm) {
        var data = '{'
	             + '"reqSerNum" :"' + document.getElementById("reqSerNum").value  + '",'
	             + '"coId"      :"' + coId       + '",'
                 + '"userId"    :"' + userId     + '",'
                 + '"userNm"    :"' + userNm     + '" '
                 + '}';
        eval("opener." + document.getElementById("returnFunction").value + "(" + data + ")");
        self.close();
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


    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<input type="hidden" name="reqSerNum" id="reqSerNum" value="<c:out value="${reqSerNum}"/>"/>
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>사용자 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                            <jsp:include page="/include/zcom/com/include_co_popup2.jsp" />
                            
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
                        </div>
                    </div>
                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="*" />
                            <col width="15%" />
                            <col width="20%" />
                            <col width="15%" />
                            <col width="15%" />
                            <col width="15%" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업체 명</th>
                            <th>사용자 ID</th>
                            <th>사용자 명</th>
                            <th>부서 명</th>
                            <th>직급 구분 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.userId}"/>', '<c:out value="${row.userNm}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.coNm                          }"/></td>
                            <td class="tx-center"><c:out value="${row.userId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.deptNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ofcLvlClNm                    }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

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
