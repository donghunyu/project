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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10020_90 %>";

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
        var coId = "";
        var opId = "";

        requestDtl(coId, opId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opChrgId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId"    ).value = coId;
        document.getElementById("opChrgId").value = opChrgId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10020_41 %>" + getParam();

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
     *  선택값반환
     **************************************************************************/
    function returnDtl(coId, opChrgId, opChrgNm, userId, userNm) {
        var data = '{'
                 + '"coId"      :"' + coId       +'",'
                 + '"opChrgId"  :"' + opChrgId   +'",'
                 + '"opChrgNm"  :"' + opChrgNm   +'",'
                 + '"userId"    :"' + userId     +'",'
                 + '"userNm"    :"' + userNm     +'" '
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

    
    /**************************************************************************
     *  EXCEL 다운로드
     **************************************************************************/
    function downloadExcel() {
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10020_70 %>";

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
        <h1>업무 담당자</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_co_search.jsp" />
                            
                            <div class="input-group">
                                <strong>업무 ID</strong>
                                <p>
                                <input type="text" name="srchOpId"                     id="srchOpId"                     value="<c:out value="${srchOpId                      }"/>" class="w-full" title="업무 ID" format="upper"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 명</strong>
                                <p>
                                <input type="text" name="srchOpNm"                     id="srchOpNm"                     value="<c:out value="${srchOpNm                      }"/>" class="w-full" title="업무 명" />
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
                            <col width="15%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업무 담당 ID</th>
                            <th>업무 담당 명</th>
                            <th>업무 담당자 ID</th>
                            <th>업무 담당자 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.opChrgId}"/>', '<c:out value="${row.opChrgNm}"/>', '<c:out value="${row.userId}"/>', '<c:out value="${row.userNm}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgId                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
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
