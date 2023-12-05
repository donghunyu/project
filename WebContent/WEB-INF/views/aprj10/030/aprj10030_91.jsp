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
                                <th>결제 ID</th>
                                <td>
                                    <input type="hidden" name="coId"                         id="coId"                         value="<c:out value="${resultObject.coId                          }"/>" title="업체 ID"                      maxlength="10"   class="w-full" readonly="readonly"/>
                                    <input type="text" name="stmId"                        id="stmId"                        value="<c:out value="${resultObject.stmId                         }"/>" title="결제 ID"                      maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>결제 명</th>
                                <td>
                                    <input type="text" name="stmNm"                        id="stmNm"                        value="<c:out value="${resultObject.stmNm                         }"/>" title="결제 명"                      maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <br>
                    <h4>결제자</h4>
                    <table class="table list" id="stm_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col width="10%" />
                            <col width="20%" />
                            <col width="20%" />
                            <col width="20%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>결제 구분 명</th>
                            <th>결제 권한</th>
                            <th>업무 담당 ID</th>
                            <th>업무 담당 명</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultStmList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-center"><c:out value="${row.stmClNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmAuthNm                     }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmOpChrgId                   }"/></td>
                            <td class="tx-left"  ><c:out value="${row.stmOpChrgNm                   }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>

