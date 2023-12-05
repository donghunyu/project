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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99030_50 %>";

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
    	requestSrch();
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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99030_01 %>";

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
        if ( isEmptyObject(document.getElementById(Trim("userId                        ")), Trim("사용자 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userNm                        ")), Trim("사용자 명                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("userPwd                       ")), Trim("사용자 비밀번호               ")) ) return false;

        var userId  = document.getElementById(Trim("userId                        ")).value;
        var userPwd = document.getElementById(Trim("userPwd                       ")).value;
        if ( !checkPassword(userId, userPwd) ) {
            return false;
        }
        
        if ( isEmptyObject(document.getElementById(Trim("phonNum                       ")), Trim("전화 번호               ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("mailAddr                      ")), Trim("메일 주소               ")) ) return false;
        var mailAddr = document.getElementById(Trim("mailAddr                     ")).value;
        if ( !checkEmail(mailAddr) ) {
            return false;
        }
        
        return true;
    }

    
    function checkEmail(mailAddr) {

        if( !/^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/.test(mailAddr) ) {
            alert('올바른 이메일 형식이 아닙니다.');
            return false;
        }

        return true;
    }


    function checkPassword(userId, userPwd) {
        if( !/^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{10,30}$/.test(userPwd) ) {
            alert('비밀번호는 숫자와 영문자, 특수문자의 조합으로 10~30자리를 사용해야 합니다.');
            return false;
        }

        var checkNumber  = userPwd.search(/[0-9]/g);
        var checkEnglish = userPwd.search(/[a-z]/ig);

        if( checkNumber < 0 || checkEnglish < 0 ) {
            alert("비밀번호에 숫자를 포함해야 합니다.");
            return false;
        }

        if( checkNumber < 0 || checkEnglish < 0 ) {
            alert("비밀번호에 영문자를 포함해야 합니다.");
            return false;
        }

        if ( /(\w)\1\1\1/.test(userPwd) ) {
            alert('비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.');
            return false;
        }
        
        if( userPwd.search(userId) > -1 ) {
            alert("비밀번호에 아이디가 포함되었습니다.");
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

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Aprj.ACTION_ZCOM99030_80 %>";

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
                <div class="titlearea">
                    <h3>사용자 정보 변경</h3>
                </div>


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

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
                                <th>사용자 ID</th>
                                <td>
                                    <input type="text" name="userId"                       id="userId"                       value="<c:out value="${sessionUser.userId                        }"/>" title="사용자 ID"                    maxlength="20"   class="w-full" readonly="readonly"/>
                                </td>
                                <th>사용자 명</th>
                                <td>
                                    <input type="text" name="userNm"                       id="userNm"                       value="<c:out value="${sessionUser.userNm                        }"/>" title="사용자 명"                    maxlength="40"   class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>기존 비밀번호</th>
                                <td>
                                    <input type="password" name="oldUserPwd"                   id="oldUserPwd"                   value="" title="기존 비밀번호"                maxlength="30"  class="w-full" />
                                </td>
                                <th>비밀번호 수정 일자</th>
                                <td>
                                    <input type="text" name="pwdUpdtDt"                    id="pwdUpdtDt"                    value="<c:out value="${sessionUser.pwdUpdtDtFormat               }"/>" title="비밀번호 수정 일자"           maxlength="10"    class="w-full" readonly="readonly"/>
                                </td>
                            </tr>
                            <tr>
                                <th>신규 비밀번호</th>
                                <td>
                                    <input type="password" name="userPwd"                      id="userPwd"                      value="" title="신규 비밀번호"                maxlength="30"  class="w-full" />
                                </td>
                                <th>확인 비밀번호</th>
                                <td>
                                    <input type="password" name="userPwdConf"                  id="userPwdConf"                  value="" title="확인 비밀번호"                maxlength="30"  class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>전화 번호</th>
                                <td>
                                    <input type="text" name="phonNum"                      id="phonNum"                      value="<c:out value="${sessionUser.phonNum                       }"/>" title="전화 번호"                    maxlength="60"   class="w-full" />
                                </td>
                                <th>메일 주소</th>
                                <td>
                                    <input type="text" name="mailAddr"                     id="mailAddr"                     value="<c:out value="${sessionUser.mailAddr                      }"/>" title="메일 주소"                    maxlength="100"  class="w-full" />
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    </div>
                    <!-- filter area -->
                </div>
                <!-- bodyarea -->

                <!-- bodyarea -->
                <div class="bodyarea">
		            <div id="detailLayer">
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
