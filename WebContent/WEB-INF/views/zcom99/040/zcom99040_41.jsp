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
                                <th>임시 로그인 ID</th>
                                <td>
                                    <input type="text" name="tmpLoginId"                   id="tmpLoginId"                   value="<c:out value="${resultObject.tmpLoginId                    }"/>" title="임시 로그인 ID"               maxlength="100"  class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>화면 URL</th>
                                <td colspan="3">
                                    <textarea          name="scrUrl"                       id="scrUrl"                                                                                               title="화면 URL"                     maxlength="200"  class="w-full" onKeyUp="setMaxLength();" readonly="readonly"><c:out value="${resultObject.scrUrl}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>유효 일자</th>
                                <td colspan="3">
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date" readonly="readonly"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date" readonly="readonly"></span>
                                </td>
                            </tr>
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
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("tmpLoginId                    ")));
    }

    setKeyReadonly();

</script>
