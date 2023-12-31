	var NumberEtc = "";

    /*****************************************************************************
     *  Numeric만 입력가능
     *  onKeyPress="inputNumeric()";
     *****************************************************************************/
    function inputNumeric() {
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = event.keyCode;
        var KeyValue     = event.srcElement.value;

        if ( KeyEventType == "keypress" ) {
            var oneChar = String.fromCharCode(KeyCodeNum);

            // 값이 0인 경우 다시 0이 입력되지 않도록
            if( oneChar == "0" ) {
                if ( KeyValue == "0" ) {
                    event.returnValue = false;
                    return;
                }
            }

            if( oneChar >= "0" && oneChar <= "9" ) {
                return;
            }
            
            if( oneChar == "." ) {
               if ( KeyValue.indexOf(oneChar) < 0 ) {
                   return;
               }
            }
            
            if( oneChar == "-" ) {
                if ( KeyValue.indexOf(oneChar) < 0 ) {
                	event.srcElement.value = oneChar + KeyValue;
                    event.returnValue = false;
                    return;
                }
             }
        }

        event.returnValue = false;
        return;
    }

    /*****************************************************************************
     * Focus가 들어오면 모든 기능해제
     * (예 : onFocus="inNumeric();" )
     *****************************************************************************/
    function inNumeric() {
        var KeyElemObj   = event.srcElement;
        var KeyValue     = KeyElemObj.value;

        if ( KeyElemObj.readOnly ) {
            return;
        }

        event.srcElement.value = getNumber(event.srcElement.value, "-.");
    }

    /*****************************************************************************
     * 숫자로 이루어진경우 3자리마다 ','를 붙여준다.
     * (예 : onBlur="blurNumeric();" )
     *****************************************************************************/
    function blurNumeric() {
        var KeyElemObj   = event.srcElement;
        KeyElemObj.value = formatNumeric(KeyElemObj.value, 5);
    }

    
    /*****************************************************************************
     *  Numeric만 입력가능
     *  onKeyPress="inputCurrency()";
     *****************************************************************************/
    function inputCurrency() {
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = event.keyCode;
        var KeyValue     = event.srcElement.value;

        if ( KeyEventType == "keypress" ) {
            var oneChar = String.fromCharCode(KeyCodeNum);

            // 값이 0인 경우 다시 0이 입력되지 않도록
            if( oneChar == "0" ) {
                if ( KeyValue == "0" ) {
                    event.returnValue = false;
                    return;
                }
            }

            if( oneChar >= "0" && oneChar <= "9" ) {
                return;
            }
            
            if( oneChar == "." ) {
               if ( KeyValue.indexOf(oneChar) < 0 ) {
                   return;
               }
            }
        }

        event.returnValue = false;
        return;
    }

    /*****************************************************************************
     * Focus가 들어오면 모든 기능해제
     * (예 : onFocus="inCurrency();" )
     *****************************************************************************/
    function inCurrency() {
        var KeyElemObj   = event.srcElement;
        var KeyValue     = KeyElemObj.value;

        if ( KeyElemObj.readOnly ) {
            return;
        }

        event.srcElement.value = getNumber(event.srcElement.value, "-.");
    }

    /*****************************************************************************
     * 숫자로 이루어진경우 3자리마다 ','를 붙여준다.
     * (예 : onBlur="blurCurrency();" )
     *****************************************************************************/
    function blurCurrency() {
        var KeyElemObj   = event.srcElement;
        KeyElemObj.value = formatNumeric(KeyElemObj.value, 2);
    }    

    
    
    /*****************************************************************************
     *  Number만 입력가능
     *  onKeyPress="inputNumber()";
     *****************************************************************************/
    function inputNumber() {
        var KeyEventType = event.type.toLowerCase();
        var KeyCodeNum   = event.keyCode;
        var KeyValue     = event.srcElement.value;

        if ( KeyEventType == "keypress" ) {
            var oneChar = String.fromCharCode(KeyCodeNum);

            if( oneChar >= "0" && oneChar <= "9" ) {
                return;
            }
            
            if ( NumberEtc != null ) {
                if ( NumberEtc.indexOf(oneChar) > -1 ) {
                    return;
                }
            }

        }

        event.returnValue = false;
        return;
    }

    /*****************************************************************************
     * Focus가 들어오면 모든 기능해제
     * (예 : onFocus="inNumber();" )
     *****************************************************************************/
    function inNumber() {
        var KeyElemObj   = event.srcElement;
        var KeyValue     = KeyElemObj.value;

        if ( KeyElemObj.readOnly ) {
            return;
        }

        event.srcElement.value = getNumber(event.srcElement.value, NumberEtc);
    }


    /*****************************************************************************
     * 숫자로 이루어진경우 3자리마다 ','를 붙여준다.
     * (예 : onBlur="blurNumber();" )
     *****************************************************************************/
    function blurNumber() {
        var KeyElemObj   = event.srcElement;
        KeyElemObj.value = getNumber(event.srcElement.value, NumberEtc);
    }

    
	/*******************************************************************************
     * 숫자로 이루어진값만 가져온다. 예외문자 포함
     * sData : 값
     * sEtc  : 예외문자
     * 예    : getNumber(2002/02/24) -> 20020224
	 **************************************************************************/
    function getNumber(data, etc) {
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
        }

        return sResult;
    }
    
    
    /*****************************************************************************
     * 숫자로 이루어진경우 3자리마다 ','를 붙여준다.
     *****************************************************************************/
    function formatNumeric(data, round) {
        data = data.toString();
        
        var sNum = getNumber(data, "-.");

        if ( sNum == "." || sNum == "-" || sNum == "" ) return "";

        var sMinus = "";
        if ( parseFloat(sNum) < 0 ) {
        	sMinus = "-";
        	sNum = sNum.substring(1);
        }

        sNum = (parseFloat(sNum)).toString();
        
        var sReturn = "";
        var sTemp   = "";
        var sInt    = "";
        var sReal   = "";

        if ( sNum.indexOf(".") > 0 ) {
            sInt    = sNum.substring(0, sNum.indexOf("."));
            sReal   = sNum.substring(sNum.indexOf("."));

            if ( sReal.length > round ) {
                sReal = sReal.substring(0, round);
            }
        } else {
            sInt    = sNum;
            sReal   = "";
        }

        while(1) {
            if ((sInt.length) > 3) {
                sTemp = sInt.substr(sInt.length - 3, 3);
                if ((sReturn.length) > 0) {
                    sReturn = sTemp + "," + sReturn;
                } else {
                    sReturn = sTemp;
                }

                sInt = sInt.substr(0, sInt.length - 3);
            } else {
                if ((sReturn.length) > 0) {
                    sReturn = sInt + "," + sReturn;
                } else {
                    sReturn = sInt;
                }
                break;
            }
        }

        return sMinus + sReturn + sReal;
    }
    
    /*****************************************************************************
     * 소수부 반올림
     *****************************************************************************/
    function roundXL(n, digits) {
	  if (digits >= 0) return parseFloat(n.toFixed(digits)); // 소수부 반올림

	  digits = Math.pow(10, digits); // 정수부 반올림
	  var t = Math.round(n * digits) / digits;

	  return parseFloat(t.toFixed(0));
	}


