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
                            <jsp:include page="/include/aprj/com/include_co_detail.jsp" />

                            <tr>
                                <th>양식 ID</th>
                                <td>
                                    <input type="text" name="formId"                       id="formId"                       value="<c:out value="${resultObject.formId                        }"/>" title="양식 ID"                      maxlength="10"   class="w-full" format="upper"/>
                                </td>
                                <th>양식 버전</th>
                                <td>
                                    <input type="text" name="formVer"                      id="formVer"                      value="<c:out value="${resultObject.formVer                       }"/>" title="양식 버전"                    maxlength="10"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>양식 명</th>
                                <td colspan="3">
                                    <input type="text" name="formNm"                       id="formNm"                       value="<c:out value="${resultObject.formNm                        }"/>" title="양식 명"                      maxlength="100"  class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>양식 내용</th>
                                <td colspan="3">
                                    <textarea          name="formCtt"                      id="formCtt"                                                                                              title="양식 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.formCtt}"/></textarea>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <br>
                    <h4>요청 리스트</h4>
                    <input type="hidden" name="reqSerNum" id="reqSerNum" value="" title="요청 일련 번호" />
                    <table class="table list" id="item_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:30px">
		                    <col style="width:60px">
		                    <col width="10%" />
		                    <col width="*" />
		                    <col width="20%" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyReqAll" id="delKeyReqAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>순번</th>
		                    <th>요청 종류 코드</th>
		                    <th>요청 내용</th>
		                    <th>항목</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultReqList}" varStatus="status">
                        
		                <c:if test="${reqSerNum == row.reqSerNum}">
		                <tr>
		                    <td class="tx-left"   >
		                    <c:if test="${row.reqTypCd == '1000' }">
		                        <input type="text" name="itm<c:out value="${row.reqSerNum}"/>" id="itm<c:out value="${row.reqSerNum}"/>" value="" maxlength="100"  class="w-full"/>
		                    </c:if>
		                    <c:if test="${row.reqTypCd == '2000' }">
		                        <input type="radio" name="itm<c:out value="${row.reqSerNum}"/>" id="itm<c:out value="${row.reqSerNum}"/>" value="" />
		                    </c:if>
		                    <c:if test="${row.reqTypCd == '3000' }">
		                        <input type="checkbox" name="itm<c:out value="${row.reqSerNum}"/>" id="itm<c:out value="${row.reqSerNum}"/>" value="" />
		                    </c:if>
		                    <c:out value="${row.itmVal                        }"/>
		                    </td>
		                </tr>
		                </c:if>
		
		
		                <c:if test="${reqSerNum != row.reqSerNum}">
		                <c:set var="reqSerNum" value="${row.reqSerNum}"/>
		                <c:set var="rowspan" value="${row.itmCnt}"/>
		                <tr>
                            <td class="tx-center" rowspan="<c:out value="${rowspan}"/>"><input type="checkbox" name="delKeyReq" id="delKeyReq" title="선택" onclick="selectAll(event);" value="<c:out value="${row.reqSerNum}"/>"></td>
		                    <td class="tx-center" rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqSeqNum                     }"/></td>
		                    <td class="tx-left"   rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqTypNm                      }"/></td>
		                    <td class="tx-left"   rowspan="<c:out value="${rowspan}"/>"><a href="#" onclick="openReq('<c:out value="${row.reqSerNum}"/>');"><c:out value="${row.reqCtt                        }"/></a></td>
		                    <td class="tx-left"   >
		                    <c:if test="${row.reqTypCd == '1000' }">
		                        <input type="text" name="itm<c:out value="${row.reqSerNum}"/>" id="itm<c:out value="${row.reqSerNum}"/>" value=""  class="w-full"/>
		                    </c:if>
		                    <c:if test="${row.reqTypCd == '2000' }">
		                        <input type="radio" name="itm<c:out value="${row.reqSerNum}"/>" id="itm<c:out value="${row.reqSerNum}"/>" value=""/>
		                    </c:if>
		                    <c:if test="${row.reqTypCd == '3000' }">
		                        <input type="checkbox" name="itm<c:out value="${row.reqSerNum}"/>" id="itm<c:out value="${row.reqSerNum}"/>" value=""/>
		                    </c:if>
		                    
		                    <c:out value="${row.itmVal                        }"/>
		                    </td>
		                </tr>
		                </c:if>

                        </c:forEach>
                        </tbody>
                    </table>


<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("formId                        ")));
    }

    setKeyReadonly();

</script>
