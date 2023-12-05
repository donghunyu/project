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
                                <th>자산 구분 ID</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('AST_CL'); return false;">찾기</div>
                                    <input type="text" name="astClId"                        id="astClId"                        value="<c:out value="${resultObject.astClId                         }"/>" title="자산 구분 ID"                      maxlength="10"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>자산 구분 명</th>
                                <td>
                                    <input type="text" name="astClNm"                        id="astClNm"                        value="<c:out value="${resultObject.astClNm                         }"/>" title="자산 구분 명"                      maxlength="40"   class="w-full" readonly="readonly"/>
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
        setKeyDisabled(document.getElementById(Trim("astClId                         ")));
    }

    setKeyReadonly();

</script>
