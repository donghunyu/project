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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20040_50 %>";

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
        var reqSerNum = "";

        requestDtl(reqSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(reqSerNum) {
        if ( !chkDtl() ) {
            return false;
        }

        return;
        document.getElementById("reqSerNum").value = reqSerNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20040_51 %>" + getParam();

        document.getElementById("targetLayer").value = "detailLayer";
        requestPostAjax(action, setTable, document.getElementById("targetLayer").value);
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDtl() {

        return true;
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_00 %>";

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
    	/*
        if ( isEmptyObject(document.getElementById(Trim("coId                          ")), Trim("업체 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opId                          ")), Trim("업무 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opSerNum                      ")), Trim("업무 일련번호                 ")) ) return false;
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
        */
        return true;
    }

    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDel() {
        if ( !chkDel() ) {
            alert("삭제 대상이 없습니다. 삭제 대상을 선택하십시요.");
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20040_80 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDel() {
        del = document.getElementsByName("delKey");
        if ( del.length > 0 ) {
            for ( var i = 0; i < del.length; i++ ) {
                if ( del[i].checked == true ) {
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        DisabledBackColor();
        fncInitControl();
        
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


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>업무 > 요청 > 응답</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />

               </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            
            
                    <div class="list-top">
                        <div class="select-box">

                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="삭제" onclick="requestDel();return false;">삭제</div>
                        </div>
                    </div>

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="*" />
                            <col width="50%" />
                        </colgroup>
                        <tr>
                            <th>순번</th>
                            <th>요청 종류 코드</th>
                            <th>요청 내용</th>
                            <th>항목</th>
                        </tr>

                        <!-- 리스트 -->
                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        
                        <c:if test="${reqSerNum == row.reqSerNum}">
                        <tr>
                            <td class="tx-left"   >
                            <c:if test="${row.reqTypCd == '1000' }">
                                <input type="text" name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="" maxlength="100"  class="w-full"/>
                            </c:if>
                            <c:if test="${row.reqTypCd == '2000' }">
                                <input type="radio" name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" />
                            </c:if>
                            <c:if test="${row.reqTypCd == '3000' }">
                                <input type="checkbox" name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>" />
                            </c:if>
                            <c:out value="${row.itmVal                        }"/>
                            </td>
                        </tr>
                        </c:if>
        
        
                        <c:if test="${reqSerNum != row.reqSerNum}">
                        <c:set var="reqSerNum" value="${row.reqSerNum}"/>
                        <c:set var="rowspan" value="${row.itmCnt}"/>
                        <tr>
                            <td class="tx-center" rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqSerNum                     }"/></td>
                            <td class="tx-left"   rowspan="<c:out value="${rowspan}"/>"><c:out value="${row.reqTypNm                      }"/></td>
                            <td class="tx-left"   rowspan="<c:out value="${rowspan}"/>"><a href="#" onclick="requestDtl('<c:out value="${row.reqSerNum}"/>');"><c:out value="${row.reqCtt                        }"/></a></td>
                            
                            <c:if test="${row.reqTypCd == '1000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '2000' }">
                            <td class="tx-left"   >
                                <input type="radio"    name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>"/><c:out value="${row.itmVal}"/>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '3000' }">
                            <td class="tx-left"   >
                                <input type="checkbox" name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmSerNum}"/>"/><c:out value="${row.itmVal}"/>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '4000' }">
                            <td class="tx-left"   >
                                    <textarea          name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" maxlength="1000" class="w-full" onKeyUp="setMaxLength();" ><c:out value="${row.itmCtt}"/></textarea>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '5000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmVal}"/>"  class="w-full"/>
                                <div class="btn point-b" title="찾기" onclick="requestPopup('DEPT'); return false;"><i class="i-search"></i>찾기</div>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '6000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmVal}"/>"  class="w-full"/>
                                <div class="btn point-b" title="찾기" onclick="requestPopup('DEPT'); return false;"><i class="i-search"></i>찾기</div>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '7000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmVal}"/>"  class="w-full"/>
                                <div class="btn point-b" title="찾기" onclick="requestPopup('DEPT'); return false;"><i class="i-search"></i>찾기</div>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '8000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmVal}"/>"  class="w-full"/>
                                <div class="btn point-b" title="찾기" onclick="requestPopup('DEPT'); return false;"><i class="i-search"></i>찾기</div>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                            
                            <c:if test="${row.reqTypCd == '9000' }">
                            <td class="tx-left"   >
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmVal}"/>"  class="w-full"/>
                                <div class="btn point-b" title="찾기" onclick="requestPopup('DEPT'); return false;"><i class="i-search"></i>찾기</div>
                                <input type="text"     name="itm_<c:out value="${row.reqSerNum}"/>" id="itm_<c:out value="${row.reqSerNum}"/>" value="<c:out value="${row.itmCtt}"/>"  class="w-full"/>
                            </td>
                            </c:if>
                        </tr>
                        </c:if>

                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

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
