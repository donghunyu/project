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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_50 %>";

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
        var coId     = "";
        var opId     = "";
        var opSerNum = "";
        var opChrgId = "";
        var userId   = "";

        requestDtl(coId, opId, opSerNum, opChrgId, userId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(coId, opId, opSerNum, opChrgId, userId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("coId"    ).value = coId;
        document.getElementById("opId"    ).value = opId;
        document.getElementById("opSerNum").value = opSerNum;
        document.getElementById("opChrgId").value = opChrgId;
        document.getElementById("userId"  ).value = userId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_51 %>" + getParam();

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_00 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("opId                          ")), Trim("업무 ID                       ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("opNm                          ")), Trim("업무 명                       ")) ) return false;
//        if ( isEmptyObject(document.getElementById(Trim("opSeqNum                      ")), Trim("업무 순번                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("prdCnt                        ")), Trim("기간 수                       ")) ) return false;

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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_APRJ20030_80 %>";

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

    
    /**************************************************************************
     *  요청
     **************************************************************************/
    function openAPRJ20050() {
        key  = document.getElementById(Trim("opSerNum"));
        name = "업무";
        if ( Trim(key.value) == "" ) {
            alert(name + "을(를) 선택하세요.");
            return false;
        }
        
        if ( key.readOnly == false ) {
            alert(name + "을(를) 먼저 등록하세요.");
            return false;
        }

        addParam("newPage", true);
        var action = ctx + "/" + "<%= ActionConstants_Aprj.ACTION_APRJ20050_40 %>" + getParam();
        var target = "APRJ20050";
        openPopup(target, '', 1200, 800, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }

    
</script>


<body>
<form id="form1" name="form1" class="form-inline">
<div class="wrap">

    <!-- top menu -->
    <jsp:include page="/include/aprj/menu/topMenu.jsp" />


    <div class="container">
        <div class="inner">

        <!-- top menu -->
        <jsp:include page="/include/aprj/menu/leftMenu.jsp" />

            <div class="content">


            <!-- navi Menu -->
                <div class="titlearea">
                    <h3>업무</h3>
                    <ul class="location">
                        <li>프로젝트</li>
                        <li>업무</li>
                    </ul>
                </div>


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

                            <jsp:include page="/include/aprj/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>프로젝트 ID</strong>
                                <p>
                                <input type="text" name="srchPrjId"                    id="srchPrjId"                    value="<c:out value="${srchPrjId                     }"/>" class="w-full" title="프로젝트 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>프로젝트 명</strong>
                                <p>
                                <input type="text" name="srchPrjNm"                    id="srchPrjNm"                    value="<c:out value="${srchPrjNm                     }"/>" class="w-full" title="프로젝트 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 ID</strong>
                                <p>
                                <input type="text" name="srchCtrlId"                   id="srchCtrlId"                   value="<c:out value="${srchCtrlId                    }"/>" class="w-full" title="통제 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>통제 명</strong>
                                <p>
                                <input type="text" name="srchCtrlNm"                   id="srchCtrlNm"                   value="<c:out value="${srchCtrlNm                    }"/>" class="w-full" title="통제 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 ID</strong>
                                <p>
                                <input type="text" name="srchOpId"                     id="srchOpId"                     value="<c:out value="${srchOpId                      }"/>" class="w-full" title="업무 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>업무 명</strong>
                                <p>
                                <input type="text" name="srchOpNm"                     id="srchOpNm"                     value="<c:out value="${srchOpNm                      }"/>" class="w-full" title="업무 명" />
                                </p>
                            </div>
<c:if test="${sessionUser.userAuthCd == '1000'}">
                            <div class="input-group">
                                <strong>사용자 ID</strong>
                                <p>
                                <input type="text" name="srchUserId"                   id="srchUserId"                   value="<c:out value="${srchUserId                    }"/>" class="w-full" title="사용자 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 명</strong>
                                <p>
                                <input type="text" name="srchUserNm"                   id="srchUserNm"                   value="<c:out value="${srchUserNm                    }"/>" class="w-full" title="사용자 명" />
                                </p>
                            </div>
</c:if>
<c:if test="${sessionUser.userAuthCd != '1000'}">
                            <div class="input-group">
                                <strong>사용자 ID</strong>
                                <p>
                                <input type="text" name="srchUserId"                   id="srchUserId"                   value="<c:out value="${sessionUser.userId            }"/>" class="w-full" title="사용자 ID" readonly="readonly"/>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>사용자 명</strong>
                                <p>
                                <input type="text" name="srchUserNm"                   id="srchUserNm"                   value="<c:out value="${sessionUser.userNm            }"/>" class="w-full" title="사용자 명" readonly="readonly"/>
                                </p>
                            </div>
</c:if>
                            <div class="input-group">
                                <strong>응답 상태</strong>
                                <p>
                                    <span class="select-box w-full">
                                    <select name="srchResStCd"                      id="srchResStCd"                      class="w-full" >
                                        <option value="0000" >전체</option>
                                    <c:forEach var="code" items="${resStCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == srchResStCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>서명 구분</strong>
                                <p>
                                    <span class="select-box w-full">
                                    <select name="srchSignClCd"                      id="srchSignClCd"                      class="w-full" >
                                        <option value="" >전체</option>
                                    <c:forEach var="code" items="${signClCdList}" varStatus="status">
                                        <option value="${code.cd}" <c:if test="${code.cd == srchSignClCd}">selected</c:if>>${code.cdNm}</option>
                                    </c:forEach>
                                    </select>
                                    </span>
                                </p>
                            </div>


                        </div>

                        <div class="btnarea">
                            <div class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</div>
                        </div>
                    </div>

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
                    <table class="table list" id="item_table">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:50px">
                            <col width="20%" />
                            <col width="20%" />
                            <col width="*" />
                            <col width="10%" />
                            <col width="10%" />
                        </colgroup>
                        <tr>
                            <th>번호</th>
                            <th>업무 담당 명</th>
                            <th>업무 명</th>
                            <th>업무 내용</th>
                            <th>응답 상태</th>
                            <th>서명 구분</th>
                        </tr>

                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.coId}"/>', '<c:out value="${row.opId}"/>', '<c:out value="${row.opSerNum}"/>', '<c:out value="${row.opChrgId}"/>', '<c:out value="${row.userId}"/>');">
                            <td class="tx-center"><c:out value="${status.count                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opChrgNm                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opNm                          }"/></td>
                            <td class="tx-left"  ><c:out value="${row.opCtt                         }"/></td>
                            <td class="tx-left"  ><c:out value="${row.resStNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.signClNm                      }"/></td>
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
                    <h4>업무 상세정보</h4>
                    <div id="detailLayer">
                    </div>
                    <div class="btnarea_bottom">
                        <div class="btn default" title="요청"       onclick="openAPRJ20050();return false;">요청</div>
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
    <jsp:include page="/include/aprj/include_footer.jsp" />
    <!--//footer -->
</div>
<!--//wrap -->

</form>
</body>
</html>
