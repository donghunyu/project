    /*****************************************************************************
     *  숫자와 영문자만 입력가능
     *  onKeyPress="inputAlpha()";
     *****************************************************************************/
    function inputAlpha() {
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = event.keyCode;
        var KeyValue     = event.srcElement.value;

        if(KeyEventType == "keypress"){
            var oneChar = String.fromCharCode(KeyCodeNum);

            if( oneChar >= "0" && oneChar <= "9" ) {
                return;
            }

            if( oneChar >= "a" && oneChar <= "z" ) {
                return;
            }

            if( oneChar >= "A" && oneChar <= "Z" ) {
                return;
            }
        }

        event.returnValue = false;
        return;
    }

    /*****************************************************************************
     *  숫자와 영문자만 입력가능
     *  onFocus="inAlpha()";
     *****************************************************************************/
    function inAlpha() {
        var KeyEventType = event.type.toLowerCase();
        event.srcElement.value = getAlpha(event.srcElement.value);
    }

    /*****************************************************************************
     *  숫자와 영문자만 입력가능
     *  onBlur="blurAlpha()";
     *****************************************************************************/
    function blurAlpha() {
        var KeyEventType = event.type.toLowerCase();
        event.srcElement.value = getAlpha(event.srcElement.value);
    }


    /*****************************************************************************
     * keypress event시 영문은 대문자로 변화
     * onKeyPress event에 사용(예: onKeyPress="inputUpper()"; )
     *****************************************************************************/
    function inputUpper() {
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = event.keyCode;

        if(KeyEventType == "keypress"){
            var oneChar = String.fromCharCode(KeyCodeNum);

            if( oneChar >= "0" && oneChar <= "9" ) {
                return;
            }

            if( oneChar >= "a" && oneChar <= "z" ) {
                event.keyCode = event.keyCode & 0xDF;  // 대문자로 변경
                return;
            }

            if( oneChar >= "A" && oneChar <= "Z" ) {
                return;
            }
        }
        
        event.returnValue = false;
        return;
    }


    /*****************************************************************************
     *  숫자와 영문대문자만 입력가능
     *  onFocus="inUpper()";
     *****************************************************************************/
    function inUpper() {
        var KeyEventType = event.type.toLowerCase();
        event.srcElement.value = getUpper(event.srcElement.value);
    }



    /*****************************************************************************
     *  숫자와 영문대문자만 입력가능
     *  onBlur="blurUpper()";
     *****************************************************************************/
    function blurUpper() {
        var KeyEventType = event.type.toLowerCase();
        event.srcElement.value = getUpper(event.srcElement.value);
    }


    /*****************************************************************************
     * keypress event시 영문은 대문자로 변화
     * onKeyPress event에 사용(예: onKeyPress="inputOneByte()"; )
     *****************************************************************************/
    function inputByte() {
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = event.keyCode;

        if(KeyEventType == "keypress"){
            var oneChar = String.fromCharCode(KeyCodeNum);

      	    if (escape(oneChar).length <= 4) {
      	        return;
      	    }
        }
        
        event.returnValue = false;
        return;
    }


    /*****************************************************************************
     *  숫자와 영문대문자만 입력가능
     *  onFocus="inOneByte()";
     *****************************************************************************/
    function inByte() {
        var KeyEventType = event.type.toLowerCase();
        event.srcElement.value = getByte(event.srcElement.value);
    }



    /*****************************************************************************
     *  숫자와 영문대문자만 입력가능
     *  onBlur="blurOneByte()";
     *****************************************************************************/
    function blurByte() {
        var KeyEventType = event.type.toLowerCase();
        event.srcElement.value = getByte(event.srcElement.value);
    }


  	/*******************************************************************************
     * 영문자와 숫자로 이루어진값만 가져온다. 예외문자 포함
     * sData : 값
     * sEtc  : 예외문자
	 **************************************************************************/
    function getAlpha(data, etc) {
        var sResult = "";

        for (var i = 0; i < data.length; i++ ) {
            oneChar = data.charAt(i);
            
            if ( etc != null ) {
                if ( etc.indexOf(oneChar) > -1 ) {
                    sResult = sResult + oneChar;
                    continue;
                }
            }

            if( oneChar >= "0" && oneChar <= "9" ) {
                sResult = sResult + oneChar;
                continue;
            }

            if( oneChar >= "a" && oneChar <= "z" ) {
                sResult = sResult + oneChar;
                continue;
            }

            if( oneChar >= "A" && oneChar <= "Z" ) {
                sResult = sResult + oneChar;
                continue;
            }
        }

        return sResult;
    }
     
     
  	/*******************************************************************************
     * 영문자와 숫자로 이루어진값만 가져온다. 예외문자 포함
     * sData : 값
     * sEtc  : 예외문자
     **************************************************************************/
    function getUpper(data, etc) {
        var sResult = "";

        for (var i = 0; i < data.length; i++ ) {
            oneChar = data.charAt(i);
            
            if ( etc != null ) {
                if ( etc.indexOf(oneChar) > -1 ) {
                    sResult = sResult + oneChar;
                    continue;
                }
            }

            if( oneChar >= "0" && oneChar <= "9" ) {
                sResult = sResult + oneChar;
                continue;
            }

            if( oneChar >= "a" && oneChar <= "z" ) {
           	    oneChar = oneChar.toUpperCase();  // 대문자로 변경
                sResult = sResult + oneChar;
                continue;
            }

            if( oneChar >= "A" && oneChar <= "Z" ) {
                sResult = sResult + oneChar;
                continue;
            }
        }

        return sResult;
    }

    /*******************************************************************************
     * 영문자와 숫자로 이루어진값만 가져온다. 예외문자 포함
     * sData : 값
     * sEtc  : 예외문자
     **************************************************************************/
    function getByte(data) {
        var sResult = "";

        for (var i = 0; i < data.length; i++ ) {
            oneChar = data.charAt(i);
            
      	    if (escape(oneChar).length > 4) {
      	    	continue;
      	    }

            sResult = sResult + oneChar;
        }

        return sResult;
    }
