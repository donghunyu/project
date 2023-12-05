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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_COPY_DATA %>";

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
     *  삭제 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkDel() ) {
            alert("복사 대상이 없습니다. 복사 대상을 선택하십시요.");
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_COPY_EXECUTE %>";

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
        <h1>프로젝트 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                            <div class="input-group">
                                <strong>업체 ID</strong>
                                <p>
                                <input type="text" name="coId"                     id="coId"                     value="<c:out value="${resultHeader.coId                      }"/>" class="w-full" title="업체 ID"   readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 명</strong>
                                <p>
                                <input type="text" name="coNm"                     id="coNm"                     value="<c:out value="${resultHeader.coNm                      }"/>" class="w-full" title="업체 명"   readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 ID</strong>
                                <p>
                                <input type="text" name="userId"                   id="userId"                   value="<c:out value="${resultHeader.userId                    }"/>" class="w-full" title="사용자 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 명</strong>
                                <p>
                                <input type="text" name="userNm"                   id="userNm"                   value="<c:out value="${resultHeader.userNm                    }"/>" class="w-full" title="사용자 명" readonly="readonly"/>
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
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="15%" />
                            <col width="30%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>프로젝트 ID</th>
                            <th>프로젝트 명</th>
                            <th>프로젝트 내용</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.prjId}"/>"></td>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-center"><c:out value="${row.prjId                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.prjNm                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.prjCtt                        }"/></td>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->
                    
                <!-- bodyarea -->
                <div class="bodyarea">
                    <div id="detailLayer">
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
                    </div>
                </div>
                <!--//bodyarea-->

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
