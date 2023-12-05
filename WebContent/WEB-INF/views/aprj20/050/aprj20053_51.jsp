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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_51 %>";

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
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("resSerNum                     ")), Trim("요청 일련번호                 ")) ) return false;
//        if ( isEmptyObject(document.getElementById(Trim("stmOpChrgId                   ")), Trim("결제 업무 담당 ID             ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("stmUserId                     ")), Trim("결제 사용자 ID                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("signClCd                      ")), Trim("서명 구분 코드                ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_80 %>";

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
     *  요청상세
     **************************************************************************/
    function openAPRJ20051() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20051_40 %>" + getParam();
        var target = "APRJ20051";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    

    /**************************************************************************
     *  결제상세
     **************************************************************************/
    function openAPRJ20053() {
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
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20053_40 %>" + getParam();
        var target = "APRJ20053_40";
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
        <h1>업무 > 요청 > 응답</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />
                            
                            <div class="input-group">
                                <strong>업무 담당</strong>
                                <p>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultHeader.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultHeader.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자</strong>
                                <p>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultHeader.userId                        }"/>" title="사용자 ID"                   maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultHeader.userNm                        }"/>" title="사용자 명"                   maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>

                            <div class="input-group">
                                <strong>응답 상태</strong>
                                <p>
                                    <input type="text" name="resStCd"                      id="resStCd"                      value="<c:out value="${resultHeader.resStCd                       }"/>" title="응답 상태 코드"              maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="resStNm"                      id="resStNm"                      value="<c:out value="${resultHeader.resStNm                       }"/>" title="응답 상태 명"                maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>응답 일자</strong>
                                <p>
                                    <input type="text" name="resSerNum"                    id="resSerNum"                    value="<c:out value="${resultHeader.resSerNum                     }"/>" title="응답 일련번호"               maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="resDt"                        id="resDt"                        value="<c:out value="${resultHeader.resDtFormat                   }"/>" title="응답 상태 명"                maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>


                            <div class="input-group w-full">
                                <strong>결제 순번</strong>
                                <p>
                                    <input type="text" name="stmSeqNum"                    id="stmSeqNum"                    value="<c:out value="${resultHeader.stmSeqNum                     }"/>" title="결제 순번"                    maxlength="22"   class="w-p10" readonly="readonly"/>
                                    <input type="text" name="stmSerNum"                    id="stmSerNum"                    value="<c:out value="${resultHeader.stmSerNum                     }"/>" title="결제 일련번호"                maxlength="22"   class="w-p10" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 구분</strong>
                                <p>
                                    <input type="text" name="stmClCd"                      id="stmClCd"                      value="<c:out value="${resultHeader.stmClCd                       }"/>" title="결제 구분 코드"               maxlength="40"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmClNm"                      id="stmClNm"                      value="<c:out value="${resultHeader.stmClNm                       }"/>" title="결제 구분 명"                 maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 권한</strong>
                                <p>
                                    <input type="text" name="stmAuthCd"                    id="stmAuthCd"                    value="<c:out value="${resultHeader.stmAuthCd                     }"/>" title="결제 권한 코드"               maxlength="40"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmAuthNm"                    id="stmAuthNm"                    value="<c:out value="${resultHeader.stmAuthNm                     }"/>" title="결제 권한 명"                 maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 부서</strong>
                                <p>
                                    <input type="text" name="stmDeptId"                    id="stmDeptId"                    value="<c:out value="${resultHeader.stmDeptId                     }"/>" title="결제 부서 ID"                 maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmDeptNm"                    id="stmDeptNm"                    value="<c:out value="${resultHeader.stmDeptNm                     }"/>" title="결제 부서 명"                 maxlength="40"   class="w-p60" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>결제 사용자</strong>
                                <p>
                                    <input type="text" name="stmUserId"                    id="stmUserId"                    value="<c:out value="${resultHeader.stmUserId                     }"/>" title="결제 사용자 ID"               maxlength="20"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmUserNm"                    id="stmUserNm"                    value="<c:out value="${resultHeader.stmUserNm                     }"/>" title="결제 사용자 명"               maxlength="40"   class="w-p60" readonly="readonly"/>
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

                        </div>
                        <div class="btnarea">
                        </div>
                    </div>

                    <table class="table form">
                        <caption class="blind">상세정보</caption>
                        <colgroup>
                            <col style="width:15%">
                            <col style="width:35%">
                            <col style="width:15%">
                            <col style="width:35%">
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>서명 구분 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="signClCd"                     id="signClCd"                     class="w-full">
                                    <c:forEach var="code" items="${signClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultHeader.signClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>서명 일시</th>
                                <td>
                                    <input type="text" name="signDtm"                      id="signDtm"                      value="<c:out value="${resultHeader.signDtmFormat                 }"/>" title="서명 일시"                    maxlength="14"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>서명 내용</th>
                                <td colspan="3">
                                    <textarea          name="signCtt"                      id="signCtt"                                                                                              title="서명 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultHeader.signCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>
                    <!-- table list -->

                <!-- bodyarea -->
                <div class="bodyarea">
                    <div class="btnarea_bottom">
                        <div class="btn default" title="요청상세"   onclick="openAPRJ20051();return false;">요청상세</div>
                        <div class="btn default" title="결제상세"   onclick="openAPRJ20053();return false;">결제상세</div>
                        <div class="btn default" title="결제"       onclick="requestSave();return false;">결제</div>
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
