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
                                <th>프로젝트 ID</th>
                                <td>
                                    <input type="text" name="prjId"                        id="prjId"                        value="<c:out value="${resultObject.prjId                         }"/>" title="프로젝트 ID"                  maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>프로젝트 명</th>
                                <td colspan="3">
                                    <input type="text" name="prjNm"                        id="prjNm"                        value="<c:out value="${resultObject.prjNm                         }"/>" title="프로젝트 명"                  maxlength="100"  class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>통제 번호</th>
                                <td>
                                    <input type="text" name="ctrlNum"                      id="ctrlNum"                      value="<c:out value="${resultObject.ctrlNum                       }"/>" title="통제 번호"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>통제 명</th>
                                <td>
                                    <input type="text" name="ctrlNm"                       id="ctrlNm"                       value="<c:out value="${resultObject.ctrlNm                        }"/>" title="통제 명"                      maxlength="100"  class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>자산 구분 ID</th>
                                <td>
                                    <input type="text" name="astClId"                      id="astClId"                      value="<c:out value="${resultObject.astClId                       }"/>" title="자산 구분 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>자산 구분 명</th>
                                <td>
                                    <input type="text" name="astClNm"                      id="astClNm"                      value="<c:out value="${resultObject.astClNm                       }"/>" title="자산 구분 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultObject.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>업무 담당 명</th>
                                <td>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultObject.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            <tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            <tr>
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
        setKeyDisabled(document.getElementById(Trim("opChrgId                      ")));
        setKeyDisabled(document.getElementById(Trim("userId                        ")));
    }

    setKeyReadonly();

</script>
