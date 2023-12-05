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
                                <th>업무 담당 ID</th>
                                <td>
                                    <input type="text" name="opChrgId"                     id="opChrgId"                     value="<c:out value="${resultObject.opChrgId                      }"/>" title="업무 담당 ID"                 maxlength="10"   class="w-full" />
                                </td>
                                <th>업무 담당 명</th>
                                <td>
                                    <input type="text" name="opChrgNm"                     id="opChrgNm"                     value="<c:out value="${resultObject.opChrgNm                      }"/>" title="업무 담당 명"                 maxlength="40"   class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>업무 담당 내용</th>
                                <td colspan="3">
                                    <textarea          name="opChrgCtt"                    id="opChrgCtt"                                                                                            title="업무 담당 내용"               maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.opChrgCtt}"/></textarea>
                                </td>
                            </tr>
                            <jsp:include page="/include/aprj/com/include_rgst_detail.jsp" />
                        </tbody>
                    </table>
<!-- 
                    <br>
                    <h4>담당자</h4>
                    <table class="table list" id="user_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:50px">
                            <col width="20%" />
                            <col width="*" />
                            <col style="width:50px">
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>사용자 ID</th>
                            <th>사용자 명</th>
                            <th><a href="#" onclick="requestPopup('USER'); return false;"><img src="<%= imgLoc %>/icon_add.gif"></a></th>
                        </tr>

                        <c:forEach var="row" items="${resultUserList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-center"><input type='hidden' name='userId' id='userId' value='<c:out value="${row.userId}"/>' title='사용자 ID' class='w-full' readonly='readonly' /><c:out value="${row.userId                         }"/></td>
                            <td class="tx-center"><c:out value="${row.userNm                       }"/></td>
                            <td class="tx-center"><a href="#" onclick="requestDelAstCl('<c:out value="${status.count}"/>');"><img src="<%= imgLoc %>/icon_del.gif"></a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <br>
                    <h4>업무 자산 구분</h4>
                    <table class="table list" id="ast_cl_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:50px">
                            <col width="20%" />
                            <col width="*" />
                            <col style="width:50px">
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>자산 구분 ID</th>
                            <th>자산 구분 명</th>
                            <th><a href="#" onclick="requestPopup('AST_CL'); return false;"><img src="<%= imgLoc %>/icon_add.gif"></a></th>
                        </tr>

                        <c:forEach var="row" items="${resultAstList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-center"><input type='hidden' name='astClId' id='astClId' value='<c:out value="${row.astClId}"/>' title='자산 구분 ID' class='w-full' readonly='readonly' /><c:out value="${row.astClId                         }"/></td>
                            <td class="tx-center"><c:out value="${row.astClNm                       }"/></td>
                            <td class="tx-center"><a href="#" onclick="requestDelAstCl('<c:out value="${status.count}"/>');"><img src="<%= imgLoc %>/icon_del.gif"></a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
 -->
<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("opChrgId                      ")));
    }

    setKeyReadonly();

    
    /**************************************************************************
     *  항목 추가
     **************************************************************************/
    function setUser(data) {
        rowAddUser(data);
    }


    /**************************************************************************
     *  사용자 설정
     **************************************************************************/
    function rowAddUser(data) {

        // 테이블지정
        var TableObject  ;
        var RowObject    ;
    
        var addRowObject ;
        var addCellObject;
        var nRow         ;
    
        TableObject = document.getElementById("user_table");
    
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
             
                // 자산 ID
                case 1:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<input type='hidden' name='userId' id='userId' value='" + data.astClId + "' title='자산 구분 ID' class='w-full' readonly='readonly' />";
                    innerHtml = innerHtml + data.userId;
                    addCellObject.innerHTML = innerHtml;
                    break;
                    
                // 자산 명
                case 2:
                    var innerHtml = "";
                    innerHtml = innerHtml + data.userNm;
                    addCellObject.innerHTML = innerHtml;
                    break;
                   
                // 삭제 icon
                case 3:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<a href='#' onclick='requestDelUser(" + nRow + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
                    addCellObject.innerHTML = innerHtml;
                    break;
            }
        }
    }

    
    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDelUser(rowNum) {
        var TableObject;

        TableObject = document.getElementById("user_table");
        // 중복검색
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
    
            if ( RowObject.cells[0].innerHTML == rowNum ) {
                TableObject.deleteRow(i);
                break;
            }
        }
        
        setRowNumUser();
    }
    
    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function setRowNumUser() {
        // 테이블지정
        var TableObject  ;
        var RowObject    ;
    
        var addRowObject ;
        var addCellObject;
        var nRow         ;
    
        TableObject = document.getElementById("user_table");
    
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            RowObject.cells[0].innerHTML = i;
            RowObject.cells[3].innerHTML = "<a href='#' onclick='requestDelUser(" + i + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
        }
    }

    
    /**************************************************************************
     *  항목 추가
     **************************************************************************/
    function setAstCl(data) {
        rowAddAstCl(data);
    }


    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function rowAddAstCl(data) {

        // 테이블지정
        var TableObject  ;
        var RowObject    ;
    
        var addRowObject ;
        var addCellObject;
        var nRow         ;
    
        TableObject = document.getElementById("ast_cl_table");
    
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
             
                // 자산 ID
                case 1:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<input type='hidden' name='astClId' id='astClId' value='" + data.astClId + "' title='자산 구분 ID' class='w-full' readonly='readonly' />";
                    innerHtml = innerHtml + data.astClId;
                    addCellObject.innerHTML = innerHtml;
                    break;
                    
                // 자산 명
                case 2:
                    var innerHtml = "";
                    innerHtml = innerHtml + data.astClNm;
                    addCellObject.innerHTML = innerHtml;
                    break;
                   
                // 삭제 icon
                case 3:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<a href='#' onclick='requestDelAstCl(" + nRow + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
                    addCellObject.innerHTML = innerHtml;
                    break;
            }
        }
    }

    
    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDelAstCl(rowNum) {
        var TableObject;

        TableObject = document.getElementById("ast_cl_table");
        // 중복검색
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
    
            if ( RowObject.cells[0].innerHTML == rowNum ) {
                TableObject.deleteRow(i);
                break;
            }
        }
        
        setRowNumAstCl();
    }
    
    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function setRowNumAstCl() {
        // 테이블지정
        var TableObject  ;
        var RowObject    ;
    
        var addRowObject ;
        var addCellObject;
        var nRow         ;
    
        TableObject = document.getElementById("ast_cl_table");
    
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            RowObject.cells[0].innerHTML = i;
            RowObject.cells[3].innerHTML = "<a href='#' onclick='requestDelAstCl(" + i + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
        }
    }
    
</script>
