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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10040_90 %>";

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
    function returnDtl(coId, cyclId, cyclNm, prdCnt, cyclClCd, stdDt) {
        var data = '{'
//                  + '"coId"      :"' + coId       +'",'
//                  + '"cyclId"    :"' + cyclId     +'",'
//                  + '"cyclNm"    :"' + cyclNm     +'",'
                 + '"prdCnt"    :"' + prdCnt     +'",'
                 + '"cyclClCd"  :"' + cyclClCd   +'",'
                 + '"stdDt"     :"' + stdDt      +'" '
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
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10040_70 %>";

        document.form1.target = "_self";
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
        <h1>주기</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_co_popup2.jsp" />
                            
                            <div class="input-group">
                                <strong>주기 ID</strong>
                                <p>
                                <input type="text" name="srchCyclCd"                   id="srchCyclCd"                   value="<c:out value="${srchCyclCd                    }"/>" class="w-full" title="주기 코드" format="upper"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>주기 명</strong>
                                <p>
                                <input type="text" name="srchCyclNm"                   id="srchCyclNm"                   value="<c:out value="${srchCyclNm                    }"/>" class="w-full" title="주기 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>주기 구분 코드</strong>
                                <p>
                                <span class="select-box w-full">
                                <select name="srchCyclClCd"                 id="srchCyclClCd"                 class="form-control input-sm">
                                    <option value="">전체</option>
                                    <c:forEach var="code" items="${cyclClCdList}" varStatus="status">
                                    <option value="${code.cd}" <c:if test="${code.cd == srchCyclClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                </select>
                                </span>
                                </p>
                            </div>
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
                            <col width="15%" />
                            <col width="30%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>주기 ID</th>
                            <th>주기 명</th>
                            <th>기간</th>
                            <th>기준 일시</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.cyclId}"/>', '<c:out value="${row.cyclNm}"/>', '<c:out value="${row.prdCnt}"/>', '<c:out value="${row.cyclClCd}"/>', '<c:out value="${row.stdDtFormat}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.cyclId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.cyclNm                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.prdCnt                        }"/> <c:out value="${row.cyclClNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stdDtFormat                   }"/></td>
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
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
    
</div>
<!--//modal-->
</form>
</body>
</html>
