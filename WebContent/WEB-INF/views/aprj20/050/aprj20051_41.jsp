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

<c:if test="${!empty resultFileList}">
                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="*" />
                            <col width="15%" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>파일 명</th>
                            <th>파일 크기</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultFileList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" onclick="selectAll(event);" value="<c:out value="${row.fileSerNum}"/>"></td>
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-left"  ><a href="#" onclick="requestDownload2('<c:out value="${row.coId}"/>', '<c:out value="${row.fileSerNum}"/>'); return false;"><c:out value="${row.lgcFileNm                     }"/></a></td>
                            <td class="tx-right" ><c:out value="${row.fileSizeFormat                }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
                    <!-- table list -->
                    <div class="list-top">
                        <div class="select-box">
                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="파일삭제" onclick="requestDel();return false;">파일삭제</div>
                        </div>
                    </div>
</c:if>

                    <table class="table list" id="file_table">
                        <caption class="blind">첨부파일</caption>
                        <colgroup>
                            <col style="width:10%">
                            <col                  >
                            <col style="width:10%">
                        </colgroup>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>
                                    <input type="file" name="uploadFile" id="uploadFile" value="" title="첨부파일" class="w-full" />
                                </td>
                                <td><a href="#" onclick="requestAddFile(); return false;"><img src="<%= imgLoc %>/icon_add.gif"></a></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    
<script type="text/javascript">

    /**************************************************************************
     *  항목 추가
     **************************************************************************/
    function requestAddFile() {
     
        // 테이블지정
        var TableObject  ;
        var RowObject    ;

        var addRowObject ;
        var addCellObject;
        var nRow         ;

        TableObject = document.getElementById("file_table");

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
                    innerHtml = innerHtml + "<input type=\"file\" name=\"uploadFile\" id=\"uploadFile\" value=\"\" title=\"첨부파일\" class=\"w-full\" />";
                    addCellObject.innerHTML = innerHtml;
                    break;
                    
                // 삭제 icon
                case 2:
                    var innerHtml = "";
                    innerHtml = innerHtml + "<a href=\"#\" onclick=\"requestDelFile('" + nRow + "'); return false;\"><img src=\"<%= imgLoc %>/icon_del.gif\"></a>";
                    addCellObject.innerHTML = innerHtml;
                    break;
            }
        }
    }
    
    
    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDelFile(rowNum) {
        var TableObject;

        TableObject = document.getElementById("file_table");
        // 중복검색
        for ( var i = 1; i <= TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            
            if ( RowObject.cells[0].innerHTML == rowNum ) {
                TableObject.deleteRow(i);
                break; 
            }
        }
        
        setRowNumFile();
    }

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function setRowNumFile() {
        // 테이블지정
        var TableObject  ;
        var RowObject    ;

        var addRowObject ;
        var addCellObject;
        var nRow         ;

        TableObject = document.getElementById("file_table");
        for ( var i = 1; i < TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            nRow = i + 1;
            
            RowObject.cells[0].innerHTML = nRow;
            RowObject.cells[2].innerHTML = "<a href=\"#\" onclick=\"requestDelFile('" + nRow + "'); return false;\"><img src=\"<%= imgLoc %>/icon_del.gif\"></a>";
        }
    }

    
</script>
