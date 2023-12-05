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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_40 %>";

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
        var resSerNum = "";

        requestDtl(resSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(resSerNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("resSerNum").value = resSerNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("coId                          ")), Trim("업체 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opId                          ")), Trim("업무 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opSerNum                      ")), Trim("업무 일련번호                 ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opChrgId                      ")), Trim("업무 담당 ID                  ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("resSerNum                     ")), Trim("응답 일련번호                 ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("tranStCd                      ")), Trim("처리 상태 코드                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("tranDt                        ")), Trim("처리 일자                     ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_80 %>";

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

    
    /**************************************************************************
     *  요청
     **************************************************************************/
    function openAPRJ20051(resSerNum) {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        addParam("resSerNum", resSerNum);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_40 %>" + getParam();
        var target = "APRJ20051";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
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
        <h1>업무 > 요청 > 응답 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />
                            
                            <div class="input-group">
                                <strong>업무 담당 ID</strong>
                                <p>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultHeader.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 담당 명</strong>
                                <p>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultHeader.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 ID</strong>
                                <p>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultHeader.userId                        }"/>" title="사용자 ID"                   maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 명</strong>
                                <p>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultHeader.userNm                        }"/>" title="사용자 명"                   maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <!-- 
                            <div class="input-group">
                                <strong>부서 ID</strong>
                                <p>
                                    <input type="text" name="deptId"                       id="deptId"                       value="<c:out value="${resultHeader.deptId                        }"/>" title="부서 ID"                   maxlength="10"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>부서 명</strong>
                                <p>
                                    <input type="text" name="deptNm"                       id="deptNm"                       value="<c:out value="${resultHeader.deptNm                        }"/>" title="부서 명"                   maxlength="40"   class="w-full" readonly="readonly"/>
                                </p>
                            </div>
                             -->
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
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>응답 일련번호</th>
                            <th>응답 상태 코드</th>
                            <th>응답 상태 명</th>
                            <th>응답 일자</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="openAPRJ20051('<c:out value="${row.resSerNum}"/>'); return false;">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.resSerNum                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.resStCd                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.resStNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.resDtFormat                   }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

                <!-- bodyarea -->
                <div class="bodyarea">
                    <div class="btnarea_bottom">
                        <div class="btn default" title="신규등록" onclick="openAPRJ20051();return false;">신규등록</div>
                        <div class="btn default" title="초기화"   onclick="requestInit();return false;">초기화</div>
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
