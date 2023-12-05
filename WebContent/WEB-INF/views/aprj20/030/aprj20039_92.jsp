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

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="15%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업무 담당 ID</th>
                            <th>업무 담당 명</th>
                            <th>업무 담당자 ID</th>
                            <th>업무 담당자 명</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultStmList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="returnDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.opChrgId}"/>', '<c:out value="${row.opChrgNm}"/>', '<c:out value="${row.userId}"/>', '<c:out value="${row.userNm}"/>');">
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgId                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userId                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.userNm                        }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                
<script type="text/javascript">

    
</script>
