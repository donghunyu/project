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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_40 %>";

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
        requestDtl(coId, fileSerNum);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, fileSerNum) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId").value = coId;
        document.getElementById("fileSerNum").value = fileSerNum;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("uploadFile                    ")), Trim("파일                          ")) ) return false;

        if ( !checkAttachFile("uploadFile") ) {
            return false;
        }
        
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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_80 %>";

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

    
    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function addFile() {
        var keyNm = "prjId";
        var key = document.getElementById(keyNm);
        
        if ( Trim(key.value) == "" ) {
            alert("프로젝트를 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert("프로젝트를 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20011_41 %>" + getParam();
        var target = "fileUpload";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

    }

    
    /**************************************************************************
     *  점검요청 첨부파일 다운로드
     **************************************************************************/
    function requestDownload(coId, fileSerNum) {
         
        addParam("fileSerNum", fileSerNum);
         
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_FILE_DOWNLOAD %>";

        document.form1.target = "_self";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
     
</script>


<body>
<!--전체시작 -->
<form id="form1" name="form1" class="form-inline" enctype="multipart/form-data">
<div>
    <div class="box modal">
        <div class="close" onclick="requestClose(); return false;">창닫기</div>
        <h1>첨부파일 리스트</h1>
        
        <!--본문-->
        <div class="bodyarea">
            <div class="filter">
                <div class="form-group">
                
<c:if test="${empty resultHeader.opId}">
                            <jsp:include page="/include/aprj/com/include_co_popup.jsp" />
                            <div class="input-group">
                                <strong>프로젝트 ID</strong>
                                <p>
                                <input type="text" name="prjId"                     id="prjId"                     value="<c:out value="${resultHeader.prjId                      }"/>" class="w-full" title="프로젝트 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>프로젝트 명</strong>
                                <p>
                                <input type="text" name="prjNm"                     id="prjNm"                     value="<c:out value="${resultHeader.prjNm                      }"/>" class="w-full" title="프로젝트 명" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
<c:if test="${!empty resultHeader.opId}">
                            <jsp:include page="/include/aprj/com/include_op_header.jsp" />
</c:if>

               </div>
                <!--//form-group-->
                <div class="btnarea">
                    <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                </div>
            </div>
            <!--//filter-->
            
            
                    <div class="list-top">
                        <div class="select-box">
                            <select title="정렬방법">
                                <option>10개씩 보기</option>
                                <option>20개씩 보기</option>
                                <option>30개씩 보기</option>
                            </select>
                        </div>
                        <div class="btnarea">
                            <div class="btn default" title="삭제" onclick="requestDel();return false;">삭제</div>
                        </div>
                    </div>
                    
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
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr>
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" onclick="selectAll(event);" value="<c:out value="${row.fileSerNum}"/>"></td>
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
	                    <td class="tx-left"  ><a href="#" onclick="requestDownload('<c:out value="${row.coId}"/>', '<c:out value="${row.fileSerNum}"/>'); return false;"><c:out value="${row.lgcFileNm                     }"/></a></td>
	                    <td class="tx-right" ><c:out value="${row.fileSizeFormat                }"/></td>
	                </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>

<c:if test="${sessionUser.userId == resultHeader.rgstId || sessionUser.userId == resultHeader.updtId}">
                <!-- bodyarea -->
                <div class="bodyarea">
                    <h4>첨부파일 등록</h4>
                    <div id="detailLayer">
                        <jsp:include page="./aprj20011_41.jsp" />
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
                        <div class="btn default" title="초기화"   onclick="requestInit();return false;">초기화</div>
                    </div>
                </div>
                <!--//bodyarea-->
</c:if>
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
