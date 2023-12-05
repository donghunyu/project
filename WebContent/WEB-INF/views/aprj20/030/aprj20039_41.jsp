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
                                <th>업체 ID</th>
                                <td>
                                    <input type="text" name="coId"                         id="coId"                         value="<c:out value="${resultObject.coId                          }"/>" title="업체 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>업무 ID</th>
                                <td>
                                    <input type="text" name="opId"                         id="opId"                         value="<c:out value="${resultObject.opId                          }"/>" title="업무 ID"                      maxlength="10"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>업무 일련번호</th>
                                <td>
                                    <input type="text" name="opSerNum"                     id="opSerNum"                     value="<c:out value="${resultObject.opSerNum                      }"/>" title="업무 일련번호"                maxlength="22"   class="w-full" />
                                </td>
                                <th>프로젝트 ID</th>
                                <td>
                                    <input type="text" name="prjId"                        id="prjId"                        value="<c:out value="${resultObject.prjId                         }"/>" title="프로젝트 ID"                  maxlength="10"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>통제 번호</th>
                                <td>
                                    <input type="text" name="ctrlNum"                      id="ctrlNum"                      value="<c:out value="${resultObject.ctrlNum                       }"/>" title="통제 번호"                    maxlength="20"   class="w-full" />
                                </td>
                                <th>자산 구분 ID</th>
                                <td>
                                    <input type="text" name="astClId"                      id="astClId"                      value="<c:out value="${resultObject.astClId                       }"/>" title="자산 구분 ID"                 maxlength="10"   class="w-full" />
                                </td>
                            </tr>
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
                                <td>
                                    <textarea          name="astCtt"                       id="astCtt"                                                                                               title="자산 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.astCtt}"/></textarea>
                                </td>
                            <tr>
                                <th>유효 일자</th>
                                <td colspan="3">
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date"></span>
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
        setKeyDisabled(document.getElementById(Trim("opId                          ")));
        setKeyDisabled(document.getElementById(Trim("opSerNum                      ")));
        setKeyDisabled(document.getElementById(Trim("prjId                         ")));
        setKeyDisabled(document.getElementById(Trim("ctrlNum                       ")));
        setKeyDisabled(document.getElementById(Trim("astClId                       ")));
        setKeyDisabled(document.getElementById(Trim("astId                         ")));
    }

    setKeyReadonly();

</script>
