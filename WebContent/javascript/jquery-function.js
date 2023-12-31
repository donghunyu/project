
    var execTime;
    var timerid;
    /*
     * @변경이력: 
     * @설명
     * 1. uri           : 호출되는 주소
     * 2. param         : 파라미터값 (post일 경우는 폼 Id를 넘겨준다.)
     * 3. callback      : 성공후 실행 function
     * 4. asynchValue   : true, false
     * 5. type          : get / post
     * 6. dataTypeValue : xml, html, JSON, JSONP, script, text
     * 7. loadingType   : 로딩바 노출여부
     */
    function requestPostAjax(strUrl, callback, targetId, form, asynch, type, dataType, loadingType) {
        if ( form        == undefined || form        == "" ) {     form        = "form1";}
        if ( asynch      == undefined || asynch      == "" ) {     asynch      = "true"; }
        if ( dataType    == undefined || dataType    == "" ) {     dataType    = "html"; }
        if ( type        == undefined || type        == "" ) {     type        = "post"; }
        if ( loadingType == undefined || loadingType == "" ) {     loadingType = "true"; }
    
        // 로딩 이미지 레이어 노출
        if (loadingType == "true") {
            loading(true);
        }
        //if ( loadingType == "true" ) {
            //loading(false, targetId);
        //}
    
        /*
         * 1. url : 호출되는 주소 
         * 2. data : 파라미터값
         * 3. type : get / post
         * 4. async : true, false
         * 5. dataType : xml, html, JSON, JSONP, script, text
         * 6. error : 에러 발생시 실행되는 메소드명
         * 7. success : 성공시 실행되는 메소드명
         */
        var param = $("form[name=" + form + "]").serialize();
        $.ajax({
            url       : strUrl,
            type      : type,
            data      : param,
            async     : asynch,
            dataType  : dataType,
            beforeSend: function() {},
            error     : function() {if(loadingType == "true") {loadEnd()} alert('접속상태에 문제로 인해 페이지 호출이 중단되었습니다. 페이지를 새로고침 해 주십시오.');},
            complete  : function() {if(loadingType == "true") {loadEnd()} },
            success   : callback
        });
    }
    
    function requestPostAjaxWithParam(strUrl, callback, targetId, param, asynch, type, dataType, loadingType) {
        if ( param       == undefined || param       == "" ) {     form        = {}    ; }
        if ( asynch      == undefined || asynch      == "" ) {     asynch      = "true"; }
        if ( dataType    == undefined || dataType    == "" ) {     dataType    = "html"; }
        if ( type        == undefined || type        == "" ) {     type        = "post"; }
        if ( loadingType == undefined || loadingType == "" ) {     loadingType = "true"; }
    
        // 로딩 이미지 레이어 노출
        if (loadingType == "true") {
            loading(true);
        }
        //if ( loadingType == "true" ) {
            //loading(false, targetId);
        //}
    
        /*
         * 1. url : 호출되는 주소 
         * 2. data : 파라미터값
         * 3. type : get / post
         * 4. async : true, false
         * 5. dataType : xml, html, JSON, JSONP, script, text
         * 6. error : 에러 발생시 실행되는 메소드명
         * 7. success : 성공시 실행되는 메소드명
         */
        $.ajax({
            url       : strUrl,
            type      : type,
            data      : param,
            async     : asynch,
            dataType  : dataType,
            beforeSend: function() {},
            error     : function() {if(loadingType == "true") {loadEnd()} alert('접속상태에 문제로 인해 페이지 호출이 중단되었습니다. 페이지를 새로고침 해 주십시오.');},
            complete  : function() {if(loadingType == "true") {loadEnd()} },
            success   : callback
        });
    }

    
    function getFormData(form) {
        var strFormData = "";
        var formElem;
        var strLastElemName = "";
        
        for ( var i = 0; i < form.elements.length; i++ ) {
            formElem = form.elements[i];
            switch ( formElem.type ) {
                case "text"       :
                case "hidden"     :
                case "password"   :
                case "textarea"   :
                case "select-one" :
                    strFormData += formElem.name + "=" + formElem.value + "&";
                    break;
                case "radio"      :
                    if ( formElem.checked ) {
                        strFormData += formElem.name + "=" + formElem.value + "&";
                    }
                    break;
                case "checkbox"   :
                    if ( formElem.checked ) {
                        if ( formElem.name == strLastElemName ) {
                            if ( strFormData.lastIndexOf("&") == (strFormData.length - 1) ) {
                                strFormData = strFormData.substr(0, strFormData.length - 1);
                            }
                            strFormData += "," + formElem.value;
                        } else {
                            strFormData += formElem.name + "=" + formElem.value;
                        }
                        
                        strFormData += "&";
                        strLastElemName = formElem.name;
                    }
                    break;
            }
        }
        
        if ( strFormData.length > 0 ) {
            strFormData = strFormData.substr(0, strFormData.length - 1);
        }
        return strFormData;
    }
    
    
    /**
     * @param isModal true:모달, false:비모달
     * @param targetId
     */
    /*
    var loadingModal;
    function loading(isModal, targetId) {
        if ( isModal == undefined || isModal == "" ) { isModal = true;}
        
        var $objBody = $("body");
        
        var $objLoadingDiv = $("#loading");
        
        var sImagePath = "/javascript";
        
        // 로딩이미지 레이어
        var objLoading_ = "";
        objLoading_ += "<div class='modal fade' id='loading_' tabindex='-1' role='dialog' data-backdrop='static' data-keyboard='false'>";
        objLoading_ += "  <div class='modal-dialog modal-sm'>";
        objLoading_ += "    <div class='modal-content'>";
        objLoading_ += "      <div class='modal-header'>";
        objLoading_ += "        처리중...&nbsp;<span id='time'></span>";
        objLoading_ += "      </div>";
        objLoading_ += "    <div class='modal-body'>";
        objLoading_ += "      <div class='progress'>";
        objLoading_ += "        <div class='progress-bar progress-bar-striped active' role='progressbar' style='width:100%;'></div>";
        objLoading_ += "      </div>";
        objLoading_ += "    </div>";
        objLoading_ += "    </div>";
        objLoading_ += "  </div>";
        objLoading_ += "</div>";
        
        var nTop  = 0;
        var nLeft = 0;
        if (targetId != undefined && targetId != "") {
            var posY = findPosY($('#'+targetId));
            var posX = findPosX($('#'+targetId));
            nTop     = ($('#'+targetId).height() / 2) - 20 + posY;
            nLeft    = ($('#'+targetId).width()  / 2) - 20 + posX;
        }
        
        //$.modal.close();
        if (isModal) {
            if (targetId != undefined && targetId != "") {
                loadingModal = $objLoadingDiv.modal({
                    opacity:50,
                    close:false,
                    position:[nTop, nLeft],
                    overlayCss: {backgroundColor:"#000"}
                });
            } else {
                loadingModal = $(objLoading_).modal();
            }
        } else {
            if (targetId != undefined && targetId != "") {
                loadingModal = $objLoadingDiv.modal({
                    modal:false,
                    close:false,
                    position:[nTop, nLeft]
                });
            } else {
                loadingModal = $objLoadingDiv.modal({
                    modal:false,
                    close:false
                });
            }
        }
        
        execTime = 0;
        setExecTime();
    }
    */
    
    
    function setExecTime() {
        execTime = execTime + 1;
        $('#time').html(execTime + "초");
        timerid = setTimeout(function(){ setExecTime(); }, 1000);
    }
    
    /*
    function loadEnd() {
        $("#loading_").html("");
        loadingModal.modal("hide");
        //$("#loading_").remove();
        //$("#loading" ).remove();
        clearTimeout(timerid);
    }
    */
    function loading(isModal, targetId) {
    	$('body').loading({
            stoppable: true,
            message: '데이터 처리 중 입니다. 잠시만 기다려 주십시요.',
            theme: 'dark'
          });
    }
    
    
    function loadEnd() {
    	$(':loading').loading('stop');
    }
    
    
    
    /*****************************************************************************
    공백인 텍스트노드 삭제.
    
    *IE9브라우저(Tident/5.0 = IE9.0)에서 대량의 테이블을 표시할때 테이블 깨짐이 발생할때 사용.
    *사용예)  $("#tableId").htmlClean();
    *****************************************************************************/
    $.fn.htmlClean = function() {
        this.contents().filter(function() {
           
            var trident = navigator.userAgent.match(/Trident\/(\d.\d)/i);
            
            if (trident != null && trident[1] == "5.0") {  // Tident/5.0 = IE9.0
                
                if (this.nodeType != 3) {
                    // 텍스트노드가 아닌경우.
                    $(this).htmlClean();
                    return false;
                } else {
                    // 텍스트노드인 경우, 공백인지 체크.
                    return !/\S/.test(this.nodeValue);
                }
            } else {
                return false;
            }
        }).remove(); //공백삭제.
        return this;
    };
    
    /**
     * element 존재여부 판단.
     * return true : 있음. false : 없음.
     */
    $.fn.exists = function() {
        return this.length !== 0;
    };
    
    // Jquey UI Datapicker 설정
    /*
    $.datepicker.regional['kr'] = {
            closeText         : '닫기', // 닫기 버튼 텍스트 변경
            currentText       : '오늘', // 오늘 텍스트 변경
            monthNames        : ['1 월','2 월','3 월','4 월','5 월','6 월','7 월','8 월','9 월','10 월','11 월','12 월'], // 개월 텍스트 설정
            monthNamesShort   : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], // 개월 텍스트 축약 설정
            dayNames          : ['일요일', '월요일','화요일','수요일','목요일','금요일','토요일'], // 요일 텍스트 설정
            dayNamesShort     : ['일','월','화','수','목','금','토'], // 요일 텍스트 축약 설정
            dayNamesMin       : ['일','월','화','수','목','금','토'], // 요일 최소 축약 텍스트 설정
            weekHeader        : "주",
            showMonthAfterYear: true,
            yearSuffix        : "년",
            dateFormat        : 'yy-mm-dd' // 날짜 포맷 설정
    };
    */
    $.datepicker.regional['kr'] = {
    		showOn         : "both", 
    		buttonImage    : "/images/ico_calendar.png", 
    		buttonImageOnly: true,
    		dayNames       : [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ],
    		dayNamesMin    : [ "일", "월", "화", "수", "목", "금", "토" ],
    		dayNamesShort  : [ "일", "월", "화", "수", "목", "금", "토" ],
    		monthNames     : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
    		monthNamesShort: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
    		closeText      : '닫기',
    		weekHeader     : '주',
    		dateFormat     : 'yy-mm-dd',
    		isRTL          : false,
    		showMonthAfterYear: true,
    		yearSuffix: '년'
    };
    
    
    // jquery-ui의 datepicker 키보드숏컷 해제
    $.extend($.datepicker, {
        _doKeyDown: function(event){
        }
    });
    
    
    
    
    $.setDatePickerRange = function(staDtObj, endDtObj) {
        $.datepicker.setDefaults($.datepicker.regional['kr']);
        staDtObj.datepicker(
                {
                    showButtonPanel: false
                  , onClose        : function( selectedDate ) {
                	  endDtObj.datepicker("option", "minDate", selectedDate);
                    }
                }
        );
        endDtObj.datepicker(
                {
                    showButtonPanel: false
                  , onClose: function( selectedDate ) {
                	  staDtObj.datepicker("option", "maxDate", selectedDate);
                    }
                }
        );
    }
    
    
    
    $.setDatePicker = function(dtObj) {
        $.datepicker.setDefaults($.datepicker.regional['kr']);
        dtObj.datepicker(
                {
                    showButtonPanel: true
                }
        );
    }
    
    
    
    function callDummy() {
        console.log("callDummy");
    }
