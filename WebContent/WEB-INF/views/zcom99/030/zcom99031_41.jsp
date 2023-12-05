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
                                <th>업체 ID</th>
                                <td>
                                    <input type="text" name="coId"                         id="coId"                         value="<c:out value="${resultObject.coId                          }"/>" title="업체 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>업체 명</th>
                                <td>
                                    <input type="text" name="coNm"                         id="coNm"                         value="<c:out value="${resultObject.coNm                          }"/>" title="업체 명"                      maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>업체 사업자 번호</th>
                                <td>
                                    <input type="text" name="coBizNum"                     id="coBizNum"                     value="<c:out value="${resultObject.coBizNum                      }"/>" title="업체 사업자 번호"             maxlength="12"   class="w-full" />
                                </td>
                                <th>업체 전화 번호</th>
                                <td>
                                    <input type="text" name="coPhonNum"                    id="coPhonNum"                    value="<c:out value="${resultObject.coPhonNum                     }"/>" title="업체 전화 번호"               maxlength="60"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>업체 주소</th>
                                <td colspan="3">
                                    <textarea          name="coAddr"                       id="coAddr"                                                                                               title="업체 주소"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.coAddr}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>업체 내용</th>
                                <td colspan="3">
                                    <textarea          name="coCtt"                        id="coCtt"                                                                                                title="업체 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.coCtt}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>유효 일자</th>
                                <td colspan="3">
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date"></span>
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
        
        if ( isEmpty(document.getElementById("effStaDt").value) ) {
            var now  = new Date();
            document.getElementById("effStaDt").value = now.format("yyyy-MM-dd");
        }
        if ( isEmpty(document.getElementById("effEndDt").value) ) {
            document.getElementById("effEndDt").value = "9999-12-31";
        }
    }

    setKeyReadonly();

</script>
