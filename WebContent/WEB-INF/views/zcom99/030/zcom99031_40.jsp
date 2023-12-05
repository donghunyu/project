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

<%@ include file="/include/zcom/include_header.jsp" %>

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99031_40 %>";

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
    	var coId = "";
        requestDtl(coId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId").value = coId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99031_41 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99031_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("coId                          ")), Trim("업체 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("coNm                          ")), Trim("업체 명                       ")) ) return false;
        
        if ( isEmptyObject(document.getElementById(Trim("coBizNum                      ")), Trim("업체 사업자 번호              ")) ) return false;
        var coBizNum = document.getElementById("coBizNum").value;
        if ( !chkCoBizNum(coBizNum) ) {
        	return false;
        }
        
        if ( isEmptyObject(document.getElementById(Trim("effStaDt                      ")), Trim("유효 시작 일자                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effEndDt                      ")), Trim("유효 종료 일자                ")) ) return false;

        return true;
    }

    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkCoBizNum(coBizNum) {
    	coBizNum = getNumber(coBizNum);
    	
    	if ( coBizNum.length != 10 ) {
    		alert("사업자번호는 숫자 10자리로 구성되어야 합니다.");
    		return false;
    	}
    	
        // bizID는 숫자만 10자리로 해서 문자열로 넘긴다.
        var checkID = new Array(1, 3, 7, 1, 3, 7, 1, 3, 5, 1);
        var tmpBizID, i, chkSum = 0, c2, remander;
        var bizID = coBizNum;

        for  ( i = 0; i <= 7; i++ )  {
            chkSum += checkID[i] * bizID.charAt(i);
        }
        c2 = "0" + (checkID[8] * bizID.charAt(8));
        c2 = c2.substring(c2.length - 2, c2.length);
        chkSum += Math.floor(c2.charAt(0)) + Math.floor(c2.charAt(1));
        remander = (10 - (chkSum % 10)) % 10;

        if  ( Math.floor(bizID.charAt(9)) != remander ) {
            alert("사업자 번호가 유효하지 않습니다. 사업자 번호를 확인 하시기바랍니다.");
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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99031_80 %>";

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
        	
            if ( isEmpty(document.getElementById("srchStaDt").value) ) {
                var now  = new Date();
                document.getElementById("srchStaDt").value = now.format("yyyy-MM-dd");
            }
            if ( isEmpty(document.getElementById("srchEndDt").value) ) {
                document.getElementById("srchEndDt").value = now.format("yyyy-MM-dd");
            }
        } catch (e) {

        }
        try {
        	message();
        } catch (e) {

        }
    }


    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>


<body>
<form id="form1" name="form1" class="form-inline">
<div class="wrap">

    <!-- top menu -->
    <jsp:include page="/include/zcom/menu/topMenu.jsp" />


    <div class="container">
        <div class="inner">

	    <!-- top menu -->
	    <jsp:include page="/include/zcom/menu/leftMenu.jsp" />

            <div class="content">


            <!-- navi Menu -->
            <jsp:include page="/include/zcom/menu/naviMenu.jsp" />


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

                            <div class="input-group">
                                <strong>업체 ID</strong>
                                <p>
                                <input type="text" name="srchCoId"                     id="srchCoId"                     value="<c:out value="${srchCoId                      }"/>" class="w-full" title="업체 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 명</strong>
                                <p>
                                <input type="text" name="srchCoNm"                     id="srchCoNm"                     value="<c:out value="${srchCoNm                      }"/>" class="w-full" title="업체 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>조회 일자</strong>
                                <p>
                                    <span class="date_box"><input type="text" name="srchStaDt" id="srchStaDt" value="${srchStaDt}" title="조회 시작 일자" format="date"/></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="srchEndDt" id="srchEndDt" value="${srchEndDt}" title="조회 종료 일자" format="date"/></span>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업체 사업자 번호</strong>
                                <p>
                                <input type="text" name="srchCoBizNum"                 id="srchCoBizNum"                 value="<c:out value="${srchCoBizNum                  }"/>" class="w-full" title="업체 사업자 번호" />
                                </p>
                            </div>
                        </div>
                        <!-- form-group -->

                        <div class="btnarea">
                            <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                        </div>

                    </div>
                    <!-- filter area -->


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
                            <col width="10%" />
                            <col width="20%" />
                            <col width="13%" />
                            <col width="*" />
                            <col width="20%" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>업체 ID</th>
                            <th>업체 명</th>
                            <th>업체 사업자 번호</th>
                            <th>업체 전화 번호</th>
                            <th>유효 일자</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>');">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.coId}"/>"></td>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-center"><c:out value="${row.coId                          }"/></td>
                            <td class="tx-left"  ><c:out value="${row.coNm                          }"/></td>
                            <td class="tx-center"><c:out value="${row.coBizNum                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.coPhonNum                     }"/></td>
                            <td class="tx-center"><c:out value="${row.effDt                         }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>
                </div>
                <!-- bodyarea -->

                <!-- bodyarea -->
                <div class="bodyarea">
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
		            <div id="detailLayer">
		                <jsp:include page="./zcom99031_41.jsp" />
		            </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="저장"     onclick="requestSave();return false;">저장</div>
                        <div class="btn default" title="초기화"   onclick="requestInit();return false;">초기화</div>
                    </div>
                </div>
                <!--//bodyarea-->
            </div>
            <!--//content-->
        </div>
        <!--//inner -->
    </div>
    <!--//container -->

    <!-- footer -->
    <jsp:include page="/include/zcom/include_footer.jsp" />
    <!--//footer -->
</div>
<!--//wrap -->

</form>
</body>
</html>