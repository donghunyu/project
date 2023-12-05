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
                                <th>업무 ID</th>
                                <td>
                                    <input type="text" name="opId"                         id="opId"                         value="<c:out value="${resultObject.opId                          }"/>" title="업무 ID"                      maxlength="10"   class="w-full"/>
                                </td>
                                <th>업무 버전</th>
                                <td>
                                    <input type="text" name="opSerNum"                     id="opSerNum"                     value="<c:out value="${resultObject.opSerNum                      }"/>" title="업무 일련번호"                maxlength="5"   class="w-p40" readonly="readonly"/>
                                    <div class="btn point-b" title="복사" onclick="requestCopy(); return false;">복사</div>
                                </td>
                            </tr>
<!-- 
                            <tr>
                                <th>업무 버전</th>
                                <td>
                                    <input type="text" name="opVer"                        id="opVer"                        value="<c:out value="${resultObject.opVer                         }"/>" title="업무 버전"                    maxlength="10"   class="w-full" />
                                </td>
                            </tr>
 -->
                            <tr>
                                <th>업무 명</th>
                                <td colspan="3">
                                    <input type="text" name="opNm"                         id="opNm"                         value="<c:out value="${resultObject.opNm                          }"/>" title="업무 명"                      maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>업무 내용</th>
                                <td colspan="3">
                                    <textarea          name="opCtt"                        id="opCtt"                                                                                                title="업무 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.opCtt}"/></textarea>
                                </td>
                            </tr>
<!-- 
                            <tr>
                                <th>주기 ID</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('CYCL'); return false;">찾기</div>
                                    <input type="text" name="cyclId"                       id="cyclId"                       value="<c:out value="${resultObject.cyclId                        }"/>" title="주기 ID"                      maxlength="10"   class="w-p50" format="upper" readonly="readonly"/>
                                </td>
                                <th>주기 명</th>
                                <td>
                                    <input type="text" name="cyclNm"                       id="cyclNm"                       value="<c:out value="${resultObject.cyclNm                        }"/>" title="주기 명"                      maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
 -->
                            <tr>
                                <th>기간 수</th>
                                <td>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('CYCL'); return false;">찾기</div>
                                    <input type="text" name="prdCnt"                       id="prdCnt"                       value="<c:out value="${resultObject.prdCnt                        }"/>" title="기간 수"                      maxlength="5"    class="w-p30" format="numeric" />
                                    <span class="select-box w-p20">
                                    <select name="cyclClCd"                     id="cyclClCd"                     class="w-full">
                                    <c:forEach var="code" items="${cyclClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.cyclClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>기준 일자</th>
                                <td>
                                    <span class="date_box"><input type="text" name="stdDt"                        id="stdDt"                        value="<c:out value="${resultObject.stdDtFormat                   }"/>" title="기준 일자"                    maxlength="10"    class="w-p40" format="date"/></span>
                                </td>
                            </tr>
                            <tr>
                                <th>기안 사용자 ID</th>
                                <td>
                                    <input type="text" name="drftUserId"                    id="drftUserId"                    value="<c:if test="${empty resultObject.drftUserId}"><c:out value="${sessionUser.userId}"/></c:if><c:out value="${resultObject.drftUserId                     }"/>" title="기안 사용자 ID"               maxlength="20"   class="w-p30" readonly="readonly"/>
                                    <div class="btn point-b" title="찾기" onclick="requestPopup('DRFT_USER'); return false;"><i class="i-search"></i>찾기</div>
                                    <input type="text" name="drftUserNm"                    id="drftUserNm"                    value="<c:if test="${empty resultObject.drftUserId}"><c:out value="${sessionUser.userNm}"/></c:if><c:out value="${resultObject.drftUserNm                     }"/>" title="기안 사용자 명"               maxlength="40"   class="w-p40" readonly="readonly"/>
                                </td>
                                <th>유효기간</th>
                                <td>
                                    <input type="text" name="effStaDt"                        id="effStaDt"                        value="<c:out value="${resultObject.effStaDtFormat                   }"/>" title="유효 시작 일자"                    maxlength="10"    class="w-p40" readonly="readonly"/>
                                    ~
                                    <input type="text" name="effEndDt"                        id="effEndDt"                        value="<c:out value="${resultObject.effEndDtFormat                   }"/>" title="유효 종료 일자"                    maxlength="10"    class="w-p40" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>자동 구분</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="autoClCd"                     id="autoClCd"                     class="w-full">
                                    <c:forEach var="code" items="${autoClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.autoClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                                <th>처리 상태</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="tranStCd"                     id="tranStCd"                     class="w-full">
                                    <c:forEach var="code" items="${tranStCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.tranStCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>
                    <br/>


<script type="text/javascript">

    $.setDatePicker($("#stdDt"));
    
    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("opId                          ")));
        setKeyDisabled(document.getElementById(Trim("opSerNum                      ")));
        
        if ( isEmpty(document.getElementById("stdDt").value) ) {
            var now  = new Date();
            document.getElementById("stdDt").value = now.format("yyyy-MM-dd");
        }
    }

    setKeyReadonly();

    /**************************************************************************
     *  항목 추가
     **************************************************************************/
    function setStm(data) {
        rowAddStm(data);
    }


    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function rowAddStm() {

        // 테이블지정
        var TableObject  ;
        var RowObject    ;
    
        var addRowObject ;
        var addCellObject;
        var nRow         ;
    
        TableObject = document.getElementById("stm_table");
    
        // Row추가.
        nRow = TableObject.rows.length;
        addRowObject = TableObject.insertRow(nRow);
    
        var cnt = 3;
        for ( var i = 0; i < cnt; i++ )
        {
            addCellObject = addRowObject.insertCell();
            
            switch ( i ) {
                // 순번
                case 0:
                    addCellObject.innerHTML = nRow;
                    break;
             
                // 항목 값
                case 1:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<span class='select-box w-full'>";
                    innerHtml = innerHtml + "<select name='stmClCd' id='stmClCd' class='w-full'>";
                    
                    <c:forEach var="code" items="${stmClCdList}" varStatus="status">
                    innerHtml = innerHtml + "    <option value='${code.cd}'>${code.cdNm}</option>";
                    </c:forEach>

                    innerHtml = innerHtml + "</select>";
                    innerHtml = innerHtml + "</span>";
                    
                    addCellObject.innerHTML = innerHtml;
                    break;
                    
                // 삭제 icon
                case 2:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<a href='#' onclick='requestDelStm(" + nRow + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
                    addCellObject.innerHTML = innerHtml;
                    break;
            }
        }
    }

    
    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDelStm(rowNum) {
        var TableObject;
    
        TableObject = document.getElementById("stm_table");
        // 중복검색
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
    
            if ( RowObject.cells[0].innerHTML == rowNum ) {
                TableObject.deleteRow(i);
                break; 
            }
        }
        
        setRowNumStm();
    }
    
    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function setRowNumStm() {
        // 테이블지정
        var TableObject  ;
        var RowObject    ;
    
        var addRowObject ;
        var addCellObject;
        var nRow         ;
    
        TableObject = document.getElementById("stm_table");
    
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            RowObject.cells[0].innerHTML = i;
            RowObject.cells[2].innerHTML = "<a href='#' onclick='requestDelStm(" + i + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
        }
    }
    
</script>
