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
                                <th>자산 ID</th>
                                <td>
                                    <input type="text" name="astId"                        id="astId"                        value="<c:out value="${resultObject.astId                         }"/>" title="자산 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>자산 명</th>
                                <td>
                                    <input type="text" name="astNm"                        id="astNm"                        value="<c:out value="${resultObject.astNm                         }"/>" title="자산 명"                      maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>자산 내용</th>
                                <td colspan="3">
                                    <textarea          name="astCtt"                       id="astCtt"                                                                                               title="자산 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.astCtt}"/></textarea>
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
        setKeyDisabled(document.getElementById(Trim("astId                         ")));
    }

    setKeyReadonly();

</script>
