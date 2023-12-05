    var objEvent = {};
    objEvent.addListener = function(element, eventName, eventHandler) {
        // msie
        if ( element.attachEvent ) {
            element.attachEvent('on' + eventName, eventHandler);
        } else if ( element.addEventListener ) {
            element.addEventListener(eventName, eventHandler, false);
        }
    }


    /*****************************************************************************
     입력된 값이 숫자인지 검색
     입력되 값이 숫자이면 true
    *****************************************************************************/
    function fncInitControl() {
    
        //INPUT CONTROL 
        var arrObjTextarea = document.getElementsByTagName("textarea");
        for ( var i = 0; i < arrObjTextarea.length; i++ ) {
            var obj       = arrObjTextarea[i];
            var objType   = obj.getAttribute("type");
            var objFormat = obj.getAttribute("format");
            
            setBackColor(obj);
            objEvent.addListener(obj, "keyup"   , setMaxLength);
        }
      
        var arrObj = document.getElementsByTagName("input");
        for ( var i = 0; i < arrObj.length; i++ ) {
            var obj       = arrObj[i];
            var objType   = obj.getAttribute("type");
            var objFormat = obj.getAttribute("format");

            if ( objType == "text" || objType == "password" ) {
                setBackColor(obj);
                objEvent.addListener(obj, "keyup"   , setMaxLength);
            }
            
            if ( objType != "text" ) {
                continue;
            }
        
            switch ( objFormat ) {
            
                case "numeric" :
                    objEvent.addListener(obj, "focus"   , inNumeric);
                    objEvent.addListener(obj, "blur"    , blurNumeric);
                    objEvent.addListener(obj, "keypress", inputNumeric);
                  
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "right";
                    break;
                    
                case "number" :
                    objEvent.addListener(obj, "focus"   , inNumber);
                    objEvent.addListener(obj, "blur"    , blurNumber);
                    objEvent.addListener(obj, "keypress", inputNumber);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "left";
                    break;
                  
                case "currency" :
                    objEvent.addListener(obj, "focus"   , inCurrency);
                    objEvent.addListener(obj, "blur"    , blurCurrency);
                    objEvent.addListener(obj, "keypress", inputCurrency);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "right";
                    break;
        
                case "date" :
                    objEvent.addListener(obj, "blur"    , blurDate);
                    objEvent.addListener(obj, "keypress", inputDate);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "left";
                    obj.maxLength = 10;
                    break;
                    
                case "time24hhmi" :
                    objEvent.addListener(obj, "focus"   , inDate);
                    objEvent.addListener(obj, "blur"    , blurTime);
                    objEvent.addListener(obj, "keypress", inputDate);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "left";
                    obj.maxLength = 4;
                    break;
        
                case "alpha" :
                    objEvent.addListener(obj, "focus"   , inAlpha);
                    objEvent.addListener(obj, "blur"    , blurAlpha);
                    objEvent.addListener(obj, "keypress", inputAlpha);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "left";
                    break;
                  
                case "upper" :
                    objEvent.addListener(obj, "focus"   , inUpper);
                    objEvent.addListener(obj, "blur"    , blurUpper);
                    objEvent.addListener(obj, "keypress", inputUpper);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "left";
                    break;
                  
                case "byte" :
                    objEvent.addListener(obj, "focus"   , inByte);
                    objEvent.addListener(obj, "blur"    , blurByte);
                    objEvent.addListener(obj, "keypress", inputByte);
                    if ( browser == "msie" || browser == "firefox" ) {
                        obj.style.imeMode   = "disabled";
                    } else {
                        objEvent.addListener(obj, "keydown", setImeMode);
                    }
                    obj.style.textAlign = "left";
                    break;
                  
                default :
                    obj.style.imeMode   = "active";
                    obj.style.textAlign = "left";
            }
        }
    }
  
    /*****************************************************************************
     *  Number만 입력가능
     *  onKeyPress="inputNumber()";
     *****************************************************************************/
    function setImeMode(event) {
        var KeyElemObj   = getTarget(event);
        var KeyCodeNum   = getKeyCode(event);
        var KeyValue     = KeyElemObj.value;

        var oneChar = String.fromCharCode(KeyCodeNum);

        if (escape(oneChar) == "%E5" ) {
            initEvent(event);
        }
    }

