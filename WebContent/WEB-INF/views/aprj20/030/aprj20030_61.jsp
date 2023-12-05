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
                                    <input type="text" name="opId"                         id="opId"                         value="<c:out value="${resultObject.opId                          }"/>" title="업무 ID"                      maxlength="10"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>업무 버전</th>
                                <td>
                                    <input type="text" name="opSerNum"                     id="opSerNum"                     value="<c:out value="${resultObject.opSerNum                      }"/>" title="업무 일련번호"                maxlength="5"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 명</th>
                                <td colspan="3">
                                    <input type="text" name="opNm"                         id="opNm"                         value="<c:out value="${resultObject.opNm                          }"/>" title="업무 명"                      maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>업무 내용</th>
                                <td colspan="3">
                                    <textarea          name="opCtt"                        id="opCtt"                                                                                                title="업무 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" readonly="readonly"><c:out value="${resultObject.opCtt}"/></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>기간 수</th>
                                <td>
                                    <input type="text" name="prdCnt"                       id="prdCnt"                       value="<c:out value="${resultObject.prdCnt                        }"/>" title="기간 수"                      maxlength="5"    class="w-p30" readonly="readonly"/>
                                    <input type="text" name="cyclClNm"                     id="cyclClNm"                     value="<c:out value="${resultObject.cyclClNm                      }"/>" title="기간 수"                      maxlength="10"    class="w-p30" readonly="readonly"/>
                                </td>
                                <th>기준 일자</th>
                                <td>
                                    <input type="text" name="stdDt"                        id="stdDt"                        value="<c:out value="${resultObject.stdDtFormat                   }"/>" title="기준 일자"                    maxlength="10"    class="w-p40" readonly="readonly"/>
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
                        </tbody>
                    </table>
                    <br/>


<script type="text/javascript">

    //$.setDatePicker($("#stdDt"));
    
    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("opSerNum                      ")));
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
