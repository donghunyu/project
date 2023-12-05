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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10030_90 %>";

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
        var stmId = "";

        requestDtl(coId, stmId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, stmId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId").value = coId;
        document.getElementById("stmId").value = stmId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10030_91 %>" + getParam();

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

    
    /**************************************************************************
     *  EXCEL 다운로드
     **************************************************************************/
    function returnSave() {
        key  = document.getElementById(Trim("stmId"));
        name = "결제";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20032_01 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }
     
    
</script>


<c:if test="${!empty msgCtt}" >
<script type="text/javascript">
    function message() {
        createMsg("<c:out value="${msgCtt}"/>");
        alert("<c:out value="${msgCtt}"/>");
        opener.requestSrch();
        window.close();
    }
</script>
</c:if>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>결제 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
<c:if test="${sessionUser.userAuthCd == '1000'}">
                            <div class="input-group">
                                <strong>업체 ID</strong>
                                <p>
                                <input type="text" name="srchCoId"                     id="srchCoId"                     value="<c:out value="${srchCoId                      }"/>" title="업체 ID"  maxlength="10"   class="w-p50" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 명</strong>
                                <p>
                                <input type="text" name="srchCoNm"                     id="srchCoNm"                     value="<c:out value="${srchCoNm                      }"/>" title="업체 명"  maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                                <input type="hidden" name="srchCoId"                     id="srchCoId"                     value="<c:out value="${sessionUser.coId                      }"/>" class="w-full" title="업체 ID" />
                                <input type="hidden" name="srchCoNm"                     id="srchCoNm"                     value="<c:out value="${sessionUser.coNm                      }"/>" class="w-full" title="업체 명" />
</c:if>
                            
                            <input type="hidden" name="opId"                 id="opId"                 value="<c:out value="${opId                  }"/>" class="w-full" title="업무 ID" readonly="readonly"/>
                            <input type="hidden" name="opSerNum"             id="opSerNum"             value="<c:out value="${opSerNum              }"/>" class="w-full" title="업무 일련번호" readonly="readonly"/>
                            
                            <div class="input-group">
                                <strong>결제 ID</strong>
                                <p>
                                <input type="text" name="srchStmId"                    id="srchStmId"                    value="<c:out value="${srchStmId                     }"/>" class="w-full" title="결제 ID" format="upper"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 명</strong>
                                <p>
                                <input type="text" name="srchStmNm"                    id="srchStmNm"                    value="<c:out value="${srchStmNm                     }"/>" class="w-full" title="결제 명" />
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
                            <th>결제 ID</th>
                            <th>결제 명</th>
                            <th>결제 내용</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.stmId}"/>'); return false;">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmId                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmNm                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmCtt                        }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

                <div class="bodyarea">
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj10030_91.jsp" />
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="선택"     onclick="returnSave(); return false;">선택</div>
                    </div>
                </div>
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
