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
                                <th>결제 ID</th>
                                <td>
                                    <input type="text" name="stmId"                        id="stmId"                        value="<c:out value="${resultObject.stmId                         }"/>" title="결제 ID"                      maxlength="10"   class="w-full" />
                                </td>
                                <th>결제 명</th>
                                <td>
                                    <input type="text" name="stmNm"                        id="stmNm"                        value="<c:out value="${resultObject.stmNm                         }"/>" title="결제 명"                      maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>결제 내용</th>
                                <td colspan="3">
                                    <textarea          name="stmCtt"                       id="stmCtt"                                                                                               title="결제 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.stmCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>
<!-- 
                    <br>
                    <h4>결제자</h4>
                    <table class="table list" id="stm_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col width="10%" />
                            <col width="*" />
                            <col style="width:50px">
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>결제 구분 명</th>
                            <th><a href="#" onclick="rowAddStm(); return false;"><img src="<%= imgLoc %>/icon_add.gif"></a></th>
                        </tr>

                        <c:forEach var="row" items="${resultStmList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><c:out value="${status.count                   }"/></td>
                            <td class="tx-center">
                                    <span class="select-box w-full">
                                    <select name="stmClCd"                      id="stmClCd"                      class="w-full">
                                    <c:forEach var="code" items="${stmClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == row.stmClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                            </td>
                            <td class="tx-center"><a href="#" onclick="requestDelStm('<c:out value="${status.count}"/>');"><img src="<%= imgLoc %>/icon_del.gif"></a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
 -->
<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("stmId                         ")));
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
