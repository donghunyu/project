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
                                <th>일련번호</th>
                                <td>
                                    <input type="text" name="serNum"                       id="serNum"                       value="<c:out value="${resultObject.serNum                        }"/>" title="일련번호"                     maxlength="22"   class="w-full"  readonly="readonly"/>
                                </td>
                                <th>메뉴 권한 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="menuAuthCd"                   id="menuAuthCd"                   class="w-full" onchange="changeMenuAuthCd(); return false;">
                                    <c:forEach var="code" items="${menuAuthCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.menuAuthCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                            </tr>
                            <tr id="menuAuthCd_1000">
                                <th>사용자 권한 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="userAuthCd"                   id="userAuthCd"                   class="w-full">
                                    <c:forEach var="code" items="${userAuthCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.userAuthCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                            </tr>
                            <tr id="menuAuthCd_2000">
                                <th>사용자 ID</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('USER'); return false;"><i class="i-search"></i>찾기</div>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${resultObject.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-p50" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${resultObject.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <!-- 
                            <tr>
                                <th>유효 일자</th>
                                <td colspan="3">
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date"></span>
                                </td>
                            </tr>
                             -->
                            <jsp:include page="/include/zcom/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("serNum                        ")));
        
//         if ( isEmpty(document.getElementById("effStaDt").value) ) {
//             var now  = new Date();
//             document.getElementById("effStaDt").value = now.format("yyyy-MM-dd");
//         }
//         if ( isEmpty(document.getElementById("effEndDt").value) ) {
//             document.getElementById("effEndDt").value = "9999-12-31";
//         }
    }

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function changeMenuAuthCd() {
    	if ( document.getElementById("menuAuthCd").value == "1000" ) {
            document.getElementById("menuAuthCd_1000").style.display = "";
            document.getElementById("menuAuthCd_2000").style.display = "none";
    	} else {
            document.getElementById("menuAuthCd_1000").style.display = "none";
            document.getElementById("menuAuthCd_2000").style.display = "";
    	}
    }

    setKeyReadonly();
    changeMenuAuthCd();

</script>
