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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20020_40 %>";

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
    function returnDtl(coId, prjId, prjNm, ctrlNum, ctrlNm) {
        var data = '{'
                 + '"coId"      :"' + coId       +'",'
                 + '"prjId"     :"' + prjId      +'",'
                 + '"prjNm"     :"' + prjNm      +'",'
                 + '"ctrlNum"   :"' + ctrlNum    +'",'
                 + '"ctrlNm"    :"' + ctrlNm     +'" '
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
                
                            <jsp:include page="/include/aprj/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>프로젝트 ID</strong>
                                <p>
                                <input type="text" name="srchPrjId"                    id="srchPrjId"                    value="<c:out value="${srchPrjId                     }"/>" class="w-full" title="프로젝트 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>프로젝트 명</strong>
                                <p>
                                <input type="text" name="srchPrjNm"                    id="srchPrjNm"                    value="<c:out value="${srchPrjNm                     }"/>" class="w-full" title="프로젝트 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 ID</strong>
                                <p>
                                <input type="text" name="srchCtrlId"                   id="srchCtrlId"                   value="<c:out value="${srchCtrlId                    }"/>" class="w-full" title="통제 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 명</strong>
                                <p>
                                <input type="text" name="srchCtrlNm"                   id="srchCtrlNm"                   value="<c:out value="${srchCtrlNm                    }"/>" class="w-full" title="통제 명" />
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
                        
                        </div>
                    </div>

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="30%" />
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>프로젝트 ID</th>
                            <th>프로젝트 명</th>
                            <th>통제 번호</th>
                            <th>통제 명</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.prjId}"/>', '<c:out value="${row.prjNm}"/>', '<c:out value="${row.ctrlNum}"/>', '<c:out value="${row.ctrlNm}"/>');">
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.prjId                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.prjNm                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ctrlNum                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ctrlNm                        }"/></td>
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
