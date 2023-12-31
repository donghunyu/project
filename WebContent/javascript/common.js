   

	var ua = navigator.userAgent.toLowerCase();
    var browser;
    

    if ( ua.indexOf("msie") > -1 ) {
        browser = "msie";
    } else 
    if ( ua.indexOf("trident") > -1 ) {
            browser = "msie";
    } else 
    if ( ua.indexOf("chrome") > -1 ) {
        browser = "chrome";
    } else 
    if ( ua.indexOf("firefox") > -1 ) {
        browser = "firefox";
    } else 
    if ( ua.indexOf("safari") > -1 ) {
        browser = "safari";
    }
    
    
    
/*
    if ( ua.indexOf("iphone") > -1 ) { 
        browser = "iphone"; 
    } 
    if ( ua.indexOf("shw-m180s") > -1 ) { 
        browser = "shw-m180s"; 
    } 
    if ( ua.indexOf("opera mobi") > -1 ) { 
        browser = "opera mobi"; 
    } 
    if ( ua.indexOf("android") > -1 ) { 
        browser = "android"; 
    } 
*/    

    function getTarget(event){
        if ( window.event ) {
            if ( window.event.srcElement ) {
                return window.event.srcElement;
            }
        } else if ( event.target ) {
            return event.target;
        }
    }


    function initEvent(event){
        if ( window.event ) {
            if ( window.event.srcElement ) {
                window.event.returnValue = false;
            }
        } else if ( event.target ) {
            event.preventDefault();
        }
    }


    function getKeyCode(event) {
        if ( window.event ) {
            if ( window.event.srcElement ) {
                return window.event.keyCode;
            }
        } else if ( event.target ) {
            return event.which;
        }
    }


    /*****************************************************************************
     * Object 정보
     *****************************************************************************/
    function getObjectInfo(obj) {
		var info = "";
	    	for(var x in obj) {
	    		info = info + "<B>"+ x + "</B>" + " : ", [obj[x]] + "<br />";
	    	}
	
		return info;
    }
    
    /*****************************************************************************
     * 문자열에서 좌우 공백제거
     *****************************************************************************/
    function Trim(data) {
        var len   = data.length;
        var first = 0;

        while ((first < len) && (data.charAt(first) <= ' ')) {
            first++;
        }

        while ((first < len) && (data.charAt(len - 1) <= ' ')) {
            len--;
        }

        return ((first > 0) || (len < data.length)) ? data.substring(first, len) : data;
    }


    /*****************************************************************************
     * 입력된 값이 space를 포함한 공백인지 검사.(Trim시 null인지 체크와 동일)
     * (공백: true)
     *****************************************************************************/
    function isEmpty(data) {

        for ( var i = 0 ; i < data.length ; i++ ) {
            if ( data.substring( i, i+1 ) != " " )
                return false;
        }

        return true;
    }


    /*****************************************************************************
     * 입력된 값이 space를 포함한 공백인지 검사.(Trim시 null인지 체크와 동일)
     * (공백: true)
     *****************************************************************************/
    function isEmptyObject(obj, objName) {

        if ( isEmpty(obj.value) ) {
            alert(objName + "은(는) 필수 입력항목입니다.");
            obj.focus();
            return true;
        }

        return false;
    }
    
    /*****************************************************************************
     * 입력된 객체가 Null 인지 체크
     * (NULL: true)
     *****************************************************************************/
    function isNull(obj) {
        if(obj == null) {
            return true;
        }
        
        if("" == obj) {
            return true;
        }
        
        if(obj == undefined) {
            return true;
        }
        
        return false;
    }
    
    /*****************************************************************************
    이중클릭체크
    *****************************************************************************/
    clickCount = 0;
    function isDoubleClicked(str) {
        if (clickCount > 0) {
            alert(str);
            return true;
        }
        clickCount++;
        return false;
    }
    
    
    /***************************************************************************
     *  입력값의 Length설정
     *  onKeyUp="setMaxLength()";
     ***************************************************************************/
    function setMaxLength(event) {
        
        if(event == null) {
            return ;
        }
        
        var KeyElemObj   = getTarget(event);
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = getKeyCode(event);
        var KeyValue     = KeyElemObj.value;
    	
        var nInt = KeyElemObj.getAttribute("maxlength");

        if ( nInt == null ) {
        	return;
        }
        
        var oneChar;
        var nByteLen      = 0;
        var i             = 0;

        for (i = 0; i < KeyValue.length; i++ ) {
        	  oneChar = KeyValue.charAt(i);

      	    if (escape(oneChar).length > 4) {
      	      nByteLen += Math.ceil(escape(oneChar).length / 4);
      	    } else {
      	      nByteLen++;
      	    }

      	    if ( nByteLen > nInt ) {
      	        alert("해당 문자열 길이인 " + nInt + "Byte를 초과하였습니다. 더 이상 입력하실 수 없습니다.");
                KeyElemObj.value = KeyValue.substring(0, i);
                break;
      	    }
        }
    }
    
    
    /***************************************************************************
     *  입력값의 Length설정
     *  onKeyUp="setMaxLengthChar()";
     ***************************************************************************/
    function setMaxLengthChar() {
        var KeyElemObj   = getTarget(event);
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = getKeyCode(event);
        var KeyValue     = KeyElemObj.value;

        var nInt     = KeyElemObj.getAttribute("maxlength");
        
  	    if ( KeyValue.length > nInt ) {
  	        alert("해당 문자열 길이인 " + nInt + "자를 초과하였습니다. 더 이상 입력하실 수 없습니다.");
            KeyElemObj.value = KeyValue.substring(0, nInt);
  	    }
    }

    /*****************************************************************************
     * 입력이 가능한 Control과 불가한 Control의 BackColor설정
     *   화면 Load후 실행
     *****************************************************************************/
    function setBackColor(obj) {
    	  if ( obj.disabled || obj.readOnly ) {
    	    obj.style.backgroundColor = "#e4e4e4";
        } else {
        	  obj.style.backgroundColor = "#FFFFFF";
    	  }
    }
    
    /*****************************************************************************
     * 입력이 가능한 Control과 불가한 Control의 BackColor설정
     *   화면 Load후 실행
     *****************************************************************************/
    function DisabledBackColor()
    {
        for ( var i = 0; i < document.forms.length; i++ ) {
            for ( var j = 0; j < document.forms[i].length; j++) {
                if (   document.forms[i].elements[j].type == "text"
                    || document.forms[i].elements[j].type == "password"
                    || document.forms[i].elements[j].type == "textarea" ) {
                    if ( document.forms[i].elements[j].disabled ) {
                        document.forms[i].elements[j].style.backgroundColor = "#F1F2F3";
                    } else {
                        document.forms[i].elements[j].style.backgroundColor = "#FFFFFF";
                    }

                    if ( document.forms[i].elements[j].readOnly ) {
                        document.forms[i].elements[j].style.backgroundColor = "#F1F2F3";
                    } else {
                        document.forms[i].elements[j].style.backgroundColor = "#FFFFFF";
                    }
                }
            }
        }
    }


    /*****************************************************************************
     * 입력이 가능한 Control과 불가한 Control의 BackColor설정
     *   화면 Load후 실행
     *****************************************************************************/
    function setObjectDisabled()
    {
        for ( var i = 0; i < document.forms.length; i++ ) {
            for ( var j = 0; j < document.forms[i].length; j++) {
            	if ( document.forms[i].elements[j].type == "button" ) {
            	continue;
            	}
            	
                if (   document.forms[i].elements[j].type == "text"
                    || document.forms[i].elements[j].type == "password"
                    || document.forms[i].elements[j].type == "textarea" ) {
                    document.forms[i].elements[j].readOnly = true;
                } else {
                    document.forms[i].elements[j].disabled = true;
                }
            }
        }
    }


    /**************************************************************************
     *  
     **************************************************************************/
    function setKeyDisabled(object) {
        if ( !isEmpty(object.value) ) {
            object.readOnly = true;
        }
    }
    
    
    /*****************************************************************************
     선택 checkbox설정
     onClick event에 사용(예 : onClick="Select_All();" )
    *****************************************************************************/
    function selectAll(event)
    {
        var KeyElemObj   = getTarget(event);
        var KeyValue     = KeyElemObj.value;

        var objAllName = "";
        var objChkName = "";
        
        var selectValue = KeyElemObj.checked;
        if ( KeyElemObj.name.indexOf("All") > 0 ) {
            objAllName = KeyElemObj.name;
            objChkName = KeyElemObj.name.substring(0, KeyElemObj.name.indexOf("All"));
        } else {
            objAllName = KeyElemObj.name + "All";
            objChkName = KeyElemObj.name;
        }

        var objAll = document.getElementsByName(objAllName);
        var objChk = document.getElementsByName(objChkName);

        if ( objAllName == KeyElemObj.name ) {
            try {
                for ( var i = 0; i < objChk.length; i++ ) {
                    objChk[i].checked = selectValue;
                }
            } catch(e) {
            }
        } else {
            try {
                if ( selectValue ) {
                    for ( var i = 0; i < objChk.length; i++ ) {
                        if ( objChk[i].checked == false ) {
                            selectValue = false;
                            break;
                        }
                    }
                }

                objAll[0].checked = selectValue;
            } catch(e) {
            }
        }
    }
    
    
    /*****************************************************************************
    선택 checkbox설정
    onClick event에 사용(예 : onClick="Select_All();" )
   *****************************************************************************/
   function isCheck(objName)
   {
       var objChk = document.getElementsByName(objName);

       for ( var i = 0; i < objChk.length; i++ ) {
           if ( objChk[i].checked == true ) {
               return true;
           }
       }

       return false;
   }


    /*****************************************************************************
     Combobox Item 삭제
     *****************************************************************************/
    function deleteComboboxItem(object, index) {
    	if ( index == null ) {
    	index = -1;
    	}
    	
    	count = object.length;
    	for ( var i = count - 1; i >= index; i-- ) {
    	object[i] = null;
    	}
    }
    
    
    function checkAttachFile(objectNanme) {
	    var size = 2;
	    var maxSize  = 1024 * 1024 * size;    // 10MB
	    var file = document.getElementsByName(objectNanme);
	    
	    var blockFile = ["com","exe","bat","sh"];
	    var fileExt   = "";
	    
	    if ( file.length > 0 ) {
	        for ( var i = 0; i < file.length; i++ ) {
	        	if ( file[i].value == "" ) continue;
	            if ( file[i].files[0].size > maxSize ) {
	                alert("첨부파일 사이즈는 " + size + "MB 이내로 등록 가능합니다.");
	                file[i].focus();
	                return false;
	            }
	            
	            fileExt = file[i].value.substring(file[i].value.lastIndexOf(".") + 1).toLowerCase();
	            if ( $.inArray(fileExt, blockFile) > -1 ) {
	                alert(fileExt + "종류의 실행파일은 첨부 하실 수 없습니다.");
	                file[i].focus();
	                return false;
	            }
	        }
	    } else {
	    	
	        if ( file.value != "" ) {
	
	            if ( file.files[0].size > maxSize ) {
	                alert("첨부파일 사이즈는 " + size + "MB 이내로 등록 가능합니다.");
	                file.focus();
	                return false;
	            }
	            
	            fileExt = file.value.substring(file.value.lastIndexOf(".") + 1).toLowerCase();
	            if ( $.inArray(fileExt, blockFile) > -1 ) {
	                alert(fileExt + "종류의 실행파일은 첨부 하실 수 없습니다.");
	                file.focus();
	                return false;
	            }
	        }
	    }
	    
	    return true;
    }
    
    /*****************************************************************************
     Lpad
    *****************************************************************************/
    function Lpad(value, len, char) {
    	if ( len < 0 ) {
    	return value;
    	}
    	if ( char == null ) {
    	char = "0";
    	}
    	
    	start = value.length;
    	for ( var i = start; i < len; i++ ) {
    	value = char + value;
    	}
    	
    	return value;
    }
    
    
    /*****************************************************************************
    getCookie(name)
   *****************************************************************************/
    function getCookie(name) {
        var arg = name + "=";
        var alen = arg.length;
        var clen = document.cookie.length;
        var i = 0;
        while (i < clen) //while open
        {
            var j = i + alen;
            if (document.cookie.substring(i, j) == arg)
                return getCookieVal (j);
            i = document.cookie.indexOf(" ", i) + 1;
            if (i == 0) break;
        } //while close
        return null;
    }


    function getCookieVal (offset) {
        var endstr = document.cookie.indexOf (";", offset);
        if (endstr == -1) endstr = document.cookie.length;
        return unescape(document.cookie.substring(offset, endstr));
    }



    function setCookie( name, value, expiredays ) {
        var todayDate = new Date();
        todayDate.setDate( todayDate.getDate() + expiredays );
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";";
    }

    
    
    function requestPrint() {
    	if( navigator.userAgent.indexOf("Chrome") > 0){
            window.print();
        } else if( navigator.userAgent.indexOf("MSIE") > 0 || navigator.userAgent.indexOf("Windows NT") > 0){
        	window.print();
//	var OLECMDID = 7;
//	var PROMPT = 1;
//	var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
//	document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
//	WebBrowser1.ExecWB( OLECMDID, PROMPT);
        }
	}
