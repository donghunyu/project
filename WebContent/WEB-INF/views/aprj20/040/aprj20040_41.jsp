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
                            <tr>
                                <th>요청 일련번호</th>
                                <td>
                                    <input type="text" name="reqSerNum"                    id="reqSerNum"                    value="<c:out value="${resultObject.reqSerNum                     }"/>" title="요청 일련번호"                maxlength="5"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>요청 순번</th>
                                <td>
                                    <input type="text" name="reqSeqNum"                    id="reqSeqNum"                    value="<c:out value="${resultObject.reqSeqNum                     }"/>" title="요청 순번"                    maxlength="5"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>요청 종류 코드</th>
                                <td>
                                    <span class="select-box w-full">
                                    <select name="reqTypCd"                     id="reqTypCd"                     class="w-full"  onchange="requestReqTyp(); return false;">
                                    <c:forEach var="code" items="${reqTypCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.reqTypCd}">selected</c:if>>[${code.cd}] ${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <th>요청 내용</th>
                                <td colspan="3">
                                    <textarea          name="reqCtt"                       id="reqCtt"                                                                                               title="요청 내용"                    maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.reqCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>
                    
                <div id="gridLayer">
                    <br>
                    <h4>항목</h4>
                    <table class="table list" id="item_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="30%" />
                            <col width="*" />
                            <col style="width:50px">
                        </colgroup>
                        <tr>
                            <th>No.</th>
                            <th>항목 값</th>
                            <th>항목 내용</th>
                            <th><a href="#" onclick="requestAddItem(); return false;"><img src="<%= imgLoc %>/icon_add.gif"></a></th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultItmList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><c:out value="${row.itmSerNum                     }"/></td>
                            <td class="tx-left"  ><input type="text" name="itmVal" id="itmVal" value="<c:out value="${row.itmVal}"/>" class="w-full" title="항목 값"   maxlength="22" /></td>
                            <td class="tx-left"  ><input type="text" name="itmCtt" id="itmCtt" value="<c:out value="${row.itmCtt}"/>" class="w-full" title="항목 내용" maxlength="22" /></td>
                            <td class="tx-center"><a href="#" onclick="requestDelItem('<c:out value="${status.count}"/>'); return false;"><img src="<%= imgLoc %>/icon_del.gif"></a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                
<script type="text/javascript">

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("reqSerNum                     ")));
    }

    setKeyReadonly();

    
    /**************************************************************************
     *  요청 종류 코드
     **************************************************************************/
    function requestReqTyp() {
        var DivObject = document.getElementById("gridLayer");
        
        if ( document.getElementById("reqTypCd").value == '2000' || document.getElementById("reqTypCd").value == '3000' ) {
            DivObject.style.display = "block";
        } else {
            DivObject.style.display = "none";
        }
    }
    requestReqTyp();
    
    /**************************************************************************
     *  항목 추가
     **************************************************************************/
    function requestAddItem() {
     
        // 테이블지정
        var TableObject  ;
        var RowObject    ;

        var addRowObject ;
        var addCellObject;
        var nRow         ;

        TableObject = document.getElementById("item_table");

        // Row추가.
        nRow = TableObject.rows.length;
        addRowObject = TableObject.insertRow(nRow);

        var cnt = 4;
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
                    innerHtml = innerHtml + "<input type='text' name='itmVal' id='itmVal' value='' class='w-full' title='항목 값'   maxlength='22' />";
                    addCellObject.innerHTML = innerHtml;
                    break;
                    
                // 항목 내용
                case 2:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<input type='text' name='itmCtt' id='itmCtt' value='' class='w-full' title='항목 내용' maxlength='22' />";
                    addCellObject.innerHTML = innerHtml;
                    break;
                   
                // 삭제 icon
                case 3:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<a href=\"#\" onclick=\"requestDelItem('" + nRow + "'); return false;\"><img src=\"<%= imgLoc %>/icon_del.gif\"></a>";
                    addCellObject.innerHTML = innerHtml;
                    break;
            }
        }
    }
    
    
    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDelItem(rowNum) {
        var TableObject;

        TableObject = document.getElementById("item_table");
        // 중복검색
        for ( var i = 1; i <= TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];

            if ( RowObject.cells[0].innerHTML == rowNum ) {
                TableObject.deleteRow(i);
                break; 
            }
        }
        
        setRowNumItem();
    }

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function setRowNumItem() {
        // 테이블지정
        var TableObject  ;
        var RowObject    ;

        var addRowObject ;
        var addCellObject;
        var nRow         ;

        TableObject = document.getElementById("item_table");

        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            RowObject.cells[0].innerHTML = i;
            RowObject.cells[3].innerHTML = "<a href=\"#\" onclick=\"requestDelItem('" + i + "'); return false;\"><img src=\"<%= imgLoc %>/icon_del.gif\"></a>";
        }
    }

    
</script>
