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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99032_90 %>";

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
    function returnDtl(deptId, deptNm) {
        var data = '{'
                 + '"reqSerNum" :"' + document.getElementById("reqSerNum").value  + '",'
                 + '"deptId"    :"' + deptId   +'",'
                 + '"deptNm"    :"' + deptNm   + '" '
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
<input type="hidden" name="reqSerNum" id="reqSerNum" value="<c:out value="${reqSerNum}"/>"/>
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>부서 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                            <jsp:include page="/include/zcom/com/include_co_popup2.jsp" />

                            <div class="input-group">
                                <strong>부서 ID</strong>
                                <p>
                                <input type="text" name="srchDeptId"                   id="srchDeptId"                   value="<c:out value="${srchDeptId                    }"/>" class="w-full" title="부서 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>부서 명</strong>
                                <p>
                                <input type="text" name="srchDeptNm"                   id="srchDeptNm"                   value="<c:out value="${srchDeptNm                    }"/>" class="w-full" title="부서 명" />
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
                            <col width="20%" />
                            <col width="20%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업체 명</th>
                            <th>부서 ID</th>
                            <th>부서 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.deptId}"/>', '<c:out value="${row.deptNm}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.coNm                          }"/></td>
                            <td class="tx-center"><c:out value="${row.deptId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.deptNm                        }"/></td>
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
