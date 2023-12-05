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

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>통제 번호</th>
                            <th>통제 명</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.ctrlNum}"/>" <c:if test="${!empty row.opCtrlNum}">checked</c:if>></td>
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ctrlNum                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.ctrlNm                        }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->


<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {

    }

    setKeyReadonly();

</script>
