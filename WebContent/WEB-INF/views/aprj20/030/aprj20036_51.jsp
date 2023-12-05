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
                            <jsp:include page="/include/aprj/com/include_co_detail.jsp" />
                            
                            <tr>
                                <th>업무 ID</th>
                                <td>
                                    <input type="text" name="opId"                         id="opId"                         value="<c:out value="${resultObject.opId                          }"/>" title="업무 ID"                      maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>업무 버전</th>
                                <td>
                                    <input type="text" name="opSerNum"                     id="opSerNum"                     value="<c:out value="${resultObject.opSerNum                      }"/>" title="업무 일련번호"                maxlength="5"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 명</th>
                                <td colspan="3">
                                    <input type="text" name="opNm"                         id="opNm"                         value="<c:out value="${resultObject.opNm                          }"/>" title="업무 명"                      maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultObject.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>업무 담당 명</th>
                                <td>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultObject.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            <tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            <tr>
                            <tr>
                                <th>결제 순번</th>
                                <td>
                                    <input type="text" name="stmSeqNum"                    id="stmSeqNum"                    value="<c:out value="${resultObject.stmSeqNum                     }"/>" title="결제 순번"                    maxlength="22"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 일련번호</th>
                                <td>
                                    <input type="text" name="stmSerNum"                    id="stmSerNum"                    value="<c:out value="${resultObject.stmSerNum                     }"/>" title="결제 일련번호"                maxlength="22"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>결제 구분 명</th>
                                <td>
                                    <input type="text" name="stmClNm"                      id="stmClNm"                      value="<c:out value="${resultObject.stmClNm                       }"/>" title="결제 구분 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 권한 명</th>
                                <td>
                                    <input type="text" name="stmAuthNm"                    id="stmAuthNm"                    value="<c:out value="${resultObject.stmAuthNm                     }"/>" title="결제 권한 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>결제 부서 ID</th>
                                <td>
                                    <input type="text" name="stmDeptId"                    id="stmDeptId"                    value="<c:out value="${resultObject.stmDeptId                     }"/>" title="결제 부서 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 부서 명</th>
                                <td>
                                    <input type="text" name="stmDeptNm"                    id="stmDeptNm"                    value="<c:out value="${resultObject.stmDeptNm                     }"/>" title="결제 부서 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>결제 사용자 ID</th>
                                <td>
                                    <input type="text" name="stmUserId"                    id="stmUserId"                    value="<c:out value="${resultObject.stmUserId                     }"/>" title="결제 사용자 ID"               maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 사용자 명</th>
                                <td>
                                    <input type="text" name="stmUserNm"                    id="stmUserNm"                    value="<c:out value="${resultObject.stmUserNm                     }"/>" title="결제 사용자 명"               maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>결제 업무 담당 ID</th>
                                <td>
                                    <input type="text" name="stmOpChrgId"                  id="stmOpChrgId"                  value="<c:out value="${resultObject.stmOpChrgId                   }"/>" title="결제 업무 담당 ID"            maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 업무 담당 명</th>
                                <td>
                                    <input type="text" name="stmOpChrgNm"                  id="stmOpChrgNm"                  value="<c:out value="${resultObject.stmOpChrgNm                   }"/>" title="결제 업무 담당 명"            maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>서명 구분 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="signClCd"                     id="signClCd"                     class="w-full">
                                    <c:forEach var="code" items="${signClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.signClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>서명 일시</th>
                                <td>
                                    <input type="text" name="signDtm"                      id="signDtm"                      value="<c:out value="${resultObject.signDtm                       }"/>" title="서명 일시"                    maxlength="14"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>서명 내용</th>
                                <td colspan="3">
                                    <textarea          name="signCtt"                      id="signCtt"                                                                                              title="서명 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.signCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>

                                <input type="hidden" name="srchOpChrgUser"            id="srchOpChrgUser"            value="<c:out value="${resultObject.opChrgId            }"/>_<c:out value="${resultObject.userId              }"/>" class="w-full" title="업무 담당 ID" readonly="readonly"/>
                                <input type="hidden" name="srchOpChrgId"              id="srchOpChrgId"              value="<c:out value="${resultObject.opChrgId            }"/>" class="w-full" title="업무 담당 ID" readonly="readonly"/>
                                <input type="hidden" name="srchOpChrgNm"              id="srchOpChrgNm"              value="<c:out value="${resultObject.opChrgNm            }"/>" class="w-full" title="업무 담당 명" readonly="readonly"/>
                                <input type="hidden" name="srchUserId"                id="srchUserId"                value="<c:out value="${resultObject.userId              }"/>" class="w-full" title="사용자 ID" readonly="readonly"/>
                                <input type="hidden" name="srchUserNm"                id="srchUserNm"                value="<c:out value="${resultObject.userNm              }"/>" class="w-full" title="사용자 명" readonly="readonly"/>

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
    }

    setKeyReadonly();

</script>
