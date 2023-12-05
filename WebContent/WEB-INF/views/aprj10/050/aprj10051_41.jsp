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

<%@ include file="/include/aprj/include_header.jsp" %>

<script type="text/javascript">

    /**************************************************************************
     *  검색
     **************************************************************************/
    function requestSrch() {
        requestPage(1);
    }

    /**************************************************************************
     *  검색 요청
     **************************************************************************/
    function requestPage(pageNo) {
        if ( !chkPage() ) {
            return false;
        }

        document.getElementById("pageNo").value = pageNo;

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10051_41 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkPage() {

        return true;
    }

    /**************************************************************************
     *  초기화
     **************************************************************************/
    function requestInit() {
        document.getElementById("reqSerNum").value = "";

        requestPage(1);
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ10051_00 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkSave() {
        if ( isEmptyObject(document.getElementById(Trim("reqSeqNum                     ")), Trim("요청 순번                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("reqTypCd                      ")), Trim("요청 종류 코드                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("reqCtt                        ")), Trim("요청 내용                     ")) ) return false;

        if ( document.getElementById("reqTypCd").value != "1000" ) {
            var objName = "항목값";
            var obj = document.getElementsByName("itmVal");
            
            if ( obj.length > 0 ) {
                for ( var i = 0; i < obj.length; i++ ) {
                    if ( isEmpty(obj[i].value) ) {
                        alert(objName + "은(는) 필수 입력항목입니다.");
                        obj[i].focus();
                        return false;
                    }
                }
            } else {
                alert(objName + "은(는) 필수 입력항목입니다.");
                return false;
            }
        }
        
        return true;
    }


    /**************************************************************************
     *  요청 종류 코드
     **************************************************************************/
    function requestReqTyp() {
        var DivObject = document.getElementById("gridLayer");
        
        if ( document.getElementById("reqTypCd").value != 1000 ) {
            DivObject.style.display = "block";
        } else {
            DivObject.style.display = "none";
        }
    }
    
    
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
                    innerHtml = innerHtml + "<a href='#' onclick='requestDelItem(" + nRow + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
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

        for ( var i = 1; i <= TableObject.rows.length; i++ ) {
            RowObject   = TableObject.rows[i];
            RowObject.cells[0].innerHTML = i;
            RowObject.cells[3].innerHTML = "<a href='#' onclick='requestDelItem(" + i + ")'><img src='<%= imgLoc %>/icon_del.gif'></a>";
        }
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        DisabledBackColor();
        fncInitControl();
        requestReqTyp();
        
        try {
            setPaging();
        } catch (e) {

        }
        try {
            $.setDatePickerRange($("#srchStaDt"), $("#srchEndDt"));
        } catch (e) {

        }
        try {
            message();
        } catch (e) {

        }
    }

    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( getKeyCode(event) == 13 )
        {
            if ( event.srcElement.name.indexOf("srch") == 0 ) {
                requestSrch();
            }
        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>


<c:if test="${msgCd == 'info.common.save.success'}" >
<script type="text/javascript">

    function saveSuccess() {
    	opener.requestDtl('<c:out value="${coId}"/>', '<c:out value="${formId}"/>');
    }
    
    saveSuccess();
</script>
</c:if>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>업무 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                                <input type="hidden" name="coId"                     id="coId"                     value="<c:out value="${coId                      }"/>" title="업체 ID"        />
                                <input type="hidden" name="formId"                   id="formId"                   value="<c:out value="${formId                    }"/>" title="양식 ID"        />
                                <input type="hidden" name="reqSerNum"                id="reqSerNum"                value="<c:out value="${resultReq.reqSerNum       }"/>" title="요청 일련번호"  />

                            <div class="input-group">
                                <strong>요청 순번</strong>
                                <p>
                                <input type="text" name="reqSeqNum"                id="reqSeqNum"                value="<c:out value="${resultReq.reqSeqNum       }"/>" class="w-p40"  title="요청 순번" maxlength="5" format="numeric" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>요청 종류 코드</strong>
                                <p>
                                    <span class="select-box w-full">
                                    <select name="reqTypCd"                      id="reqTypCd"                      class="w-full" onchange="requestReqTyp();">
                                    <c:forEach var="code" items="${reqTypCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == resultReq.reqTypCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </p>
                            </div>
                            <div class="input-group w-full">
                                <strong>요청 내용</strong>
                                <p>
                                <textarea          name="reqCtt"                       id="reqCtt"                                                                                               class="w-full"  title="요청 내용"                    maxlength="200"  onKeyUp="setMaxLength();" ><c:out value="${resultReq.reqCtt}"/></textarea>
                                </p>
                            </div>
                </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            
                <div id="gridLayer">
            
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
		                    <th><a href="#" onclick="requestAddItem()"><img src="<%= imgLoc %>/icon_add.gif"></a></th>
                        </tr>

                        <!-- 리스트 -->
		                <c:forEach var="row" items="${resultList}" varStatus="status">
		                <tr>
		                    <td class="tx-center"><c:out value="${row.itmSerNum                     }"/></td>
		                    <td class="tx-left"  ><input type="text" name="itmVal" id="itmVal" value="<c:out value="${row.itmVal}"/>" class="w-full" title="항목 값"   maxlength="22" /></td>
		                    <td class="tx-left"  ><input type="text" name="itmCtt" id="itmCtt" value="<c:out value="${row.itmCtt}"/>" class="w-full" title="항목 내용" maxlength="22" /></td>
		                    <td class="tx-left"  ><a href="#" onclick="requestDtlItem()"><img src="<%= imgLoc %>/icon_del.gif"></a></td>
		                </tr>
		                </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                
                <!-- bodyarea -->
                <div class="bodyarea">
                    <div class="btnarea_bottom">
                        <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
                        <div class="btn default" title="초기화"   onclick="requestInit();return false;">초기화</div>
                    </div>
                </div>
                <!--//bodyarea-->
                
        </div>
        <!--//본문 bodyarea--> 
    </div>
    <!--//box-->
    
    <!-- footer -->
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
    
</div>
<!--//modal-->
</form>
</body>
</html>
