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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_40 %>";

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
        document.getElementById("stmClCd"    ).value = "1000";
        document.getElementById("stmAuthCd"  ).value = "3000";
        document.getElementById("stmAuthNm"  ).value = "사용자 추가";
        document.getElementById("stmDeptId"  ).value = "";
        document.getElementById("stmDeptNm"  ).value = "";
        document.getElementById("stmOpChrgId").value = "";
        document.getElementById("stmOpChrgNm").value = "";
        document.getElementById("stmSerNum"  ).value = "";
        document.getElementById("stmSeqNum"  ).value = "";
        document.getElementById("stmUserId"  ).value = "";
        document.getElementById("stmUserNm"  ).value = "";
        
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(stmSeqNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("stmSeqNum").value = stmSeqNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("stmUserId                     ")), Trim("결제 사용자 ID                ")) ) return false;
//        if ( isEmptyObject(document.getElementById(Trim("stmSerNum                     ")), Trim("결제 일련번호                 ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("stmOpChrgId                   ")), Trim("결제 업무 담당 ID             ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("stmSeqNum                     ")), Trim("결제 순번                     ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("stmClCd                       ")), Trim("결제 구분 코드                ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("signClCd                      ")), Trim("서명 구분 코드                ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("signDtm                       ")), Trim("서명 일시                     ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("signFilePath                  ")), Trim("서명 파일 경로                ")) ) return false;
//         if ( isEmptyObject(document.getElementById(Trim("signCtt                       ")), Trim("서명 내용                     ")) ) return false;

        return true;
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestBatch() {
    	
    	if ( !confirm("담당자 배정을 시작합니다. 기존의 결제 담당자를 삭제하고 기준에 맞는 담당자를 배정합니다. 계속 진행하시겠습니까?" ) ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_01 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDel() {
        if ( !chkDel() ) {
            alert("삭제 대상이 없습니다. 삭제 대상을 선택하십시요.");
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20036_80 %>";

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
     *  업무 담당 사용자 선택
     **************************************************************************/
    function openOpChrgUser() {
    	
        addParam("newPage", true);
        document.getElementById("returnFunction").value = "setOpChgrUser";
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20034_90 %>" + getParam();
        var target = "opChrgUser";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    
    /**************************************************************************
     *  업무 담당 사용자 선택
     **************************************************************************/
    function setOpChgrUser(data) {
        document.getElementById("opChrgId").value = data.opChrgId;
        document.getElementById("opChrgNm").value = data.opChrgNm;
        document.getElementById("userId"  ).value = data.userId;
        document.getElementById("userNm"  ).value = data.userNm;
    }

    
</script>



<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>업무 > 결제 > 결제자</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />

                            <div class="input-group">
                                <strong>업무 담당</strong>
                                <p>
                                <input type="text" name="opChrgId"              id="opChrgId"              value="<c:out value="${opChrgId            }"/>" class="w-p30" title="업무 담당 ID" readonly="readonly"/>
                                <input type="text" name="opChrgNm"              id="opChrgNm"              value="<c:out value="${opChrgNm            }"/>" class="w-p60" title="업무 담당 명" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자
<c:if test="${sessionUser.userAuthCd == '1000'}">
                    <div class="btn point-b" title="찾기" onclick="openOpChrgUser(); return false;"><i class="i-search"></i>찾기</div>
</c:if>
                                
                                </strong>
                                <p>
                                <input type="text" name="userId"                id="userId"                value="<c:out value="${userId              }"/>" class="w-p30" title="사용자 ID" readonly="readonly"/>
                                <input type="text" name="userNm"                id="userNm"                value="<c:out value="${userNm              }"/>" class="w-p60" title="사용자 명" readonly="readonly"/>
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
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="5%" />
                            <col width="5%" />
                            <col width="5%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>결제 순번</th>
                            <th>결제 일련번호</th>
                            <th>결제 구분 명</th>
                            <th>결제 권한 명</th>
                            <th>결제 부서 명</th>
                            <th>결제 사용자 명</th>
                            <th>결제 업무 담당 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.stmSeqNum}"/>');">
<c:if test="${row.stmAuthCd == '3000'}">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.stmSeqNum}"/>"></td>
</c:if>
<c:if test="${row.stmAuthCd != '3000'}">
                            <td class="tx-center"></td>
</c:if>
                        
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmSeqNum                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmSerNum                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmClNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmAuthNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmDeptNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmUserNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmOpChrgNm                   }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

                <!-- bodyarea -->
                <div class="bodyarea">
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj20036_41.jsp" />
                    </div>
                    <div class="btnarea_bottom">

<c:if test="${sessionUser.userAuthCd == '1000'}">
                        <div class="btn default" title="결제자 배정" onclick="requestBatch() ;return false;">결제자 배정</div>
</c:if>
                        <div class="btn default" title="저장"        onclick="requestSave();return false;">저장</div>
                        <div class="btn default" title="초기화"      onclick="requestInit();return false;">초기화</div>

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
