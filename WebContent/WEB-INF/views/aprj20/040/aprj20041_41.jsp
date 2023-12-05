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
                                <th>항목 일련번호</th>
                                <td>
                                    <input type="text" name="itmSerNum"                    id="itmSerNum"                    value="<c:out value="${resultObject.itmSerNum                     }"/>" title="항목 일련번호"                maxlength="22"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>항목 값</th>
                                <td>
                                    <input type="text" name="itmVal"                       id="itmVal"                       value="<c:out value="${resultObject.itmVal                        }"/>" title="항목 값"                      maxlength="20"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>항목 내용</th>
                                <td colspan="3">
                                    <textarea          name="itmCtt"                       id="itmCtt"                                                                                               title="항목 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.itmCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />

                        </tbody>
                    </table>


<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("itmSerNum                     ")));
    }

    setKeyReadonly();

</script>
