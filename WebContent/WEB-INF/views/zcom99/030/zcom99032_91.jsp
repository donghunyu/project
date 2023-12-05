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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99032_91 %>";

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
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>부서 조직도</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
<c:if test="${sessionUser.userAuthCd == '1000'}">
                            <div class="input-group">
                                <strong>업체 ID</strong>
                                <p>
                                <input type="text" name="coId"                         id="coId"                         value="<c:out value="${sessionUser.coId                      }"/>" title="업체 ID"  class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 명</strong>
                                <p>
                                <input type="text" name="coNm"                         id="coNm"                         value="<c:out value="${sessionUser.coNm                      }"/>" title="업체 명"  class="w-full" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                                <input type="hidden" name="coId"                       id="coId"                         value="<c:out value="${sessionUser.coId                      }"/>" title="업체 ID"  class="w-full"  />
                                <input type="hidden" name="coNm"                       id="coNm"                         value="<c:out value="${sessionUser.coNm                      }"/>" title="업체 명"  class="w-full" />
</c:if>

               </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            
            
                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="20%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>부서 ID</th>
                            <th>부서 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.deptId}"/>', '<c:out value="${row.deptNm}"/>');">
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-center"><c:out value="${row.deptId                        }"/></td>
                            <td class="tx-left"  >
                            <c:forEach begin="1" end="${row.lev}" step="1">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:forEach>
                            <c:out value="${row.deptNm                        }"/>
                            </td>
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
