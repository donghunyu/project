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

<%@ include file="/include/aprj/include_resource.jsp" %>

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
                                <th>통제 번호</th>
                                <td>
                                    <input type="text" name="ctrlNum"                      id="ctrlNum"                      value="<c:out value="${resultObject.ctrlNum                       }"/>" title="통제 번호"                    maxlength="20"   class="w-full" />
                                </td>
                                <th>통제 명</th>
                                <td>
                                    <input type="text" name="ctrlNm"                       id="ctrlNm"                       value="<c:out value="${resultObject.ctrlNm                        }"/>" title="통제 명"                      maxlength="100"  class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>통제 내용</th>
                                <td colspan="3">
                                    <textarea          name="ctrlCtt"                      id="ctrlCtt"                                                                                              title="통제 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.ctrlCtt}"/></textarea>
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
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("prjId                         ")));
        setKeyDisabled(document.getElementById(Trim("ctrlNum                       ")));
    }

    setKeyReadonly();

</script>
