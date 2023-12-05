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
                                <th>결제 구분 명</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="stmClCd"                   id="stmClCd"                   class="w-full">
                                    <c:forEach var="code" items="${stmClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.stmClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>결제 권한 명</th>
                                <td>
                                    <input type="hidden" name="stmAuthCd"                    id="stmAuthCd"                    value="<c:out value="${resultObject.stmAuthCd                     }"/>" title="결제 권한 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                    <input type="text" name="stmAuthNm"                    id="stmAuthNm"                    value="<c:out value="${resultObject.stmAuthNm                     }"/>" title="결제 권한 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>결제 부서</th>
                                <td>
                                    <input type="text" name="stmDeptId"                    id="stmDeptId"                    value="<c:out value="${resultObject.stmDeptId                     }"/>" title="결제 부서 ID"                 maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmDeptNm"                    id="stmDeptNm"                    value="<c:out value="${resultObject.stmDeptNm                     }"/>" title="결제 부서 명"                 maxlength="40"   class="w-p60" readonly="readonly"/>
                                </td>
                                <th>결제 업무 담당</th>
                                <td>
                                    <input type="text" name="stmOpChrgId"                  id="stmOpChrgId"                  value="<c:out value="${resultObject.stmOpChrgId                   }"/>" title="결제 업무 담당 ID"            maxlength="10"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmOpChrgNm"                  id="stmOpChrgNm"                  value="<c:out value="${resultObject.stmOpChrgNm                   }"/>" title="결제 업무 담당 명"            maxlength="40"   class="w-p60" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>결제 순번</th>
                                <td>
                                    <input type="hidden" name="stmSerNum"                    id="stmSerNum"                    value="<c:out value="${resultObject.stmSerNum                     }"/>" title="결제 일련번호"                maxlength="22"   class="w-p30" readonly="readonly"/>
                                    <input type="text" name="stmSeqNum"                    id="stmSeqNum"                    value="<c:out value="${resultObject.stmSeqNum                     }"/>" title="결제 순번"                    maxlength="22"   class="w-p30" format="numeric"/>
                                </td>
                                <th>결제 사용자 ID</th>
                                <td>
                                    <input type="text" name="stmUserId"                    id="stmUserId"                    value="<c:out value="${resultObject.stmUserId                     }"/>" title="결제 사용자 ID"               maxlength="20"   class="w-p30" readonly="readonly"/>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('USER'); return false;"><i class="i-search"></i>찾기</div>
                                    <input type="text" name="stmUserNm"                    id="stmUserNm"                    value="<c:out value="${resultObject.stmUserNm                     }"/>" title="결제 사용자 명"               maxlength="40"   class="w-p40" readonly="readonly"/>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("opId                          ")));
        setKeyDisabled(document.getElementById(Trim("opSerNum                      ")));
        setKeyDisabled(document.getElementById(Trim("stmSerNum                     ")));
        setKeyDisabled(document.getElementById(Trim("opChrgId                      ")));
        setKeyDisabled(document.getElementById(Trim("userId                        ")));
        
        if ( isEmpty(document.getElementById("stmAuthCd").value) ) {
            document.getElementById("stmAuthCd"  ).value = "3000";
            document.getElementById("stmAuthNm"  ).value = "사용자 추가";
        } 
    }

    setKeyReadonly();

    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setUser(data) {
        document.getElementById("stmUserId").value = data.userId;
        document.getElementById("stmUserNm").value = data.userNm;
    }

</script>
