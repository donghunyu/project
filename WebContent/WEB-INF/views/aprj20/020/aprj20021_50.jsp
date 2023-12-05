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


            <jsp:include page="/include/aprj/com/include_co_detail.jsp" />

            <div class="row">
                <div class="col-xs-2"><label>업체 ID</label></div>
                <div class="col-xs-4">
                    <input type="text" name="coId"                         id="coId"                         value="<c:out value="${resultObject.coId                          }"/>" class="form-control input-sm" placeholder="업체 ID"                      maxlength="10"   style="width: 200px;" />
                </div>
                <div class="col-xs-2"><label>프로젝트 ID</label></div>
                <div class="col-xs-4">
                    <input type="text" name="prjId"                        id="prjId"                        value="<c:out value="${resultObject.prjId                         }"/>" class="form-control input-sm" placeholder="프로젝트 ID"                  maxlength="10"   style="width: 200px;" />
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2"><label>통제 번호</label></div>
                <div class="col-xs-4">
                    <input type="text" name="ctrlNum"                      id="ctrlNum"                      value="<c:out value="${resultObject.ctrlNum                       }"/>" class="form-control input-sm" placeholder="통제 번호"                    maxlength="20"   style="width: 200px;" />
                </div>
                <div class="col-xs-2"><label>자산 코드</label></div>
                <div class="col-xs-4">
                    <select name="astCd"                        id="astCd"                       class="form-control input-sm">
                    <c:forEach var="code" items="${astCdList}" varStatus="status">
                        <option value="${code.cd}" <c:if test="${code.cd == resultObject.astCd}">selected</c:if>>${code.cdNm}</option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            </div>
            <div class="row">
                <div class="col-xs-2"><label>유효 일자</label></div>
                <div class="col-xs-4">
                    <input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" class="form-control input-sm" placeholder="유효 시작 일자"               maxlength="8"    style="width: 100px;" format="date"/>
                    ~
                    <input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" class="form-control input-sm" placeholder="유효 종료 일자"               maxlength="8"    style="width: 100px;" format="date"/>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2"><label>등록자</label></div>
                <div class="col-xs-4">
                    <input type="text" name="rgstId"                       id="rgstId"                       value="<c:out value="${resultObject.rgstId                        }"/>" class="form-control input-sm" placeholder="등록 ID"                      maxlength="20"   style="width: 100px;" readonly="readonly"/>
                    <input type="text" name="rgstNm"                       id="rgstNm"                       value="<c:out value="${resultObject.rgstNm                        }"/>" class="form-control input-sm" placeholder="등록 명"                      maxlength="20"   style="width: 100px;" readonly="readonly"/>
                </div>
                <div class="col-xs-2"><label>등록 일시 / IP</label></div>
                <div class="col-xs-4">
                    <input type="text" name="rgstDtm"                      id="rgstDtm"                      value="<c:out value="${resultObject.rgstDtmFormat                 }"/>" class="form-control input-sm" placeholder="등록 일시"                    maxlength="20"   style="width: 150px;" readonly="readonly"/>
                    <input type="text" name="rgstIp"                       id="rgstIp"                       value="<c:out value="${resultObject.rgstIp                        }"/>" class="form-control input-sm" placeholder="등록 IP"                      maxlength="20"   style="width: 150px;" readonly="readonly"/>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2"><label>수정자</label></div>
                <div class="col-xs-4">
                    <input type="text" name="updtId"                       id="updtId"                       value="<c:out value="${resultObject.updtId                        }"/>" class="form-control input-sm" placeholder="수정 ID"                      maxlength="20"   style="width: 100px;" readonly="readonly"/>
                    <input type="text" name="updtNm"                       id="updtNm"                       value="<c:out value="${resultObject.updtNm                        }"/>" class="form-control input-sm" placeholder="수정 명"                      maxlength="20"   style="width: 100px;" readonly="readonly"/>
                </div>
                <div class="col-xs-2"><label>수정 일시 / IP</label></div>
                <div class="col-xs-4">
                    <input type="text" name="updtDtm"                      id="updtDtm"                      value="<c:out value="${resultObject.updtDtmFormat                 }"/>" class="form-control input-sm" placeholder="수정 일시"                    maxlength="20"   style="width: 150px;" readonly="readonly"/>
                    <input type="text" name="updtIp"                       id="updtIp"                       value="<c:out value="${resultObject.updtIp                        }"/>" class="form-control input-sm" placeholder="수정 IP"                      maxlength="20"   style="width: 150px;" readonly="readonly"/>
                </div>
            </div>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("coId                          ")));
        setKeyDisabled(document.getElementById(Trim("prjId                         ")));
        setKeyDisabled(document.getElementById(Trim("ctrlNum                       ")));
        setKeyDisabled(document.getElementById(Trim("astCd                         ")));
    }

    setKeyReadonly();

</script>
