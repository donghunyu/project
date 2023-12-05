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

                            <jsp:include page="/include/zcom/com/include_co_detail.jsp" />
                            <tr>
                                <th>부서 ID</th>
                                <td>
                                    <input type="text" name="deptId"                       id="deptId"                       value="<c:out value="${resultObject.deptId                        }"/>" title="부서 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>부서 명</th>
                                <td>
                                    <input type="text" name="deptNm"                       id="deptNm"                       value="<c:out value="${resultObject.deptNm                        }"/>" title="부서 명"                      maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>부서 내용</th>
                                <td colspan="3">
                                    <textarea          name="deptCtt"                      id="deptCtt"                                                                                              title="부서 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.deptCtt}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>상위 부서 ID</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('SUP_DEPT'); return false;"><i class="i-search"></i>찾기</div>
                                    <input type="text" name="supDeptId"                    id="supDeptId"                    value="<c:out value="${resultObject.supDeptId                     }"/>" title="상위 부서 ID"                 maxlength="10"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>상위 부서 명</th>
                                <td>
                                    <input type="text" name="supDeptNm"                    id="supDeptNm"                    value="<c:out value="${resultObject.supDeptNm                     }"/>" title="상위 부서 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <jsp:include page="/include/zcom/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("deptId                        ")));
    }

    setKeyReadonly();

</script>
