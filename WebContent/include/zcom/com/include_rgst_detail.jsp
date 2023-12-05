<%@ page
  info         = "DongHun Yu"
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

<c:if test="${sessionUser.userAuthCd == '1000'}">
                            <tr>
                                <th>등록자</th>
                                <td>
                                    <input type="text" name="rgstId"                       id="rgstId"                       value="<c:out value="${resultObject.rgstId                        }"/>" class="w-p40" title="등록자 ID" readonly="readonly" placeholder="등록자 ID">
                                    <input type="text" name="rgstNm"                       id="rgstNm"                       value="<c:out value="${resultObject.rgstNm                        }"/>" class="w-p40" title="등록자 명" readonly="readonly" placeholder="등록자 명">
                                </td>
                                <th>등록 일시 / IP</th>
                                <td>
                                    <input type="text" name="rgstDtm"                      id="rgstDtm"                      value="<c:out value="${resultObject.rgstDtmFormat                 }"/>" class="w-p50" title="등록 일시" readonly="readonly" placeholder="등록 일시">
                                    <input type="text" name="rgstIp"                       id="rgstIp"                       value="<c:out value="${resultObject.rgstIp                        }"/>" class="w-p40" title="등록 IP"   readonly="readonly" placeholder="등록 IP">
                                </td>
                            </tr>
                            <tr>
                                <th>수정자</th>
                                <td>
                                    <input type="text" name="updtId"                       id="updtId"                       value="<c:out value="${resultObject.updtId                        }"/>" class="w-p40" title="수정자 ID" readonly="readonly" placeholder="수정자 ID">
                                    <input type="text" name="updtNm"                       id="updtNm"                       value="<c:out value="${resultObject.updtNm                        }"/>" class="w-p40" title="수정자 명" readonly="readonly" placeholder="수정자 명">
                                </td>
                                <th>수정 일시 / IP</th>
                                <td>
                                    <input type="text" name="updtDtm"                      id="updtDtm"                      value="<c:out value="${resultObject.updtDtmFormat                 }"/>" class="w-p50" title="수정 일시" readonly="readonly" placeholder="수정 일시">
                                    <input type="text" name="updtIp"                       id="updtIp"                       value="<c:out value="${resultObject.updtIp                        }"/>" class="w-p40" title="수정 IP"   readonly="readonly" placeholder="수정 IP">
                                </td>
                            </tr>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
</c:if>
