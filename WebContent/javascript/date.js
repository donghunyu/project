   
   var sDateSeparator = "-";
   function getDateSeparator() {
       return sDateSeparator;
   }

   /*****************************************************************************
    *  Number만 입력가능
    *  onKeyPress="inputDate()";
    *****************************************************************************/
   function inputDate() {
       var KeyEventType = event.type.toLowerCase();
       var KeyCodeNum   = event.keyCode;
       var KeyValue     = event.srcElement.value;

       if ( KeyEventType == "keypress" ) {
           var oneChar = String.fromCharCode(KeyCodeNum);

           if( oneChar >= "0" && oneChar <= "9" ) {
               return;
           }
       }

       event.returnValue = false;
       return;
   }

   
   /*****************************************************************************
    * Focus가 들어오면 모든 기능해제
    * (예 : onFocus="inNumber();" )
    *****************************************************************************/
   function inDate() {
       var KeyElemObj   = event.srcElement;
       var KeyValue     = KeyElemObj.value;

       if ( KeyElemObj.readOnly ) {
           return;
       }

       event.srcElement.value = getNumber(event.srcElement.value);
   }


   /*****************************************************************************
    * 날짜형식으로 입력되었는지 검색한다.
    * onblur event에 사용한다. ( 예: onBlur="blurDate(); )
    *****************************************************************************/
    function blurDate()
    {
        var KeyElemObj   = event.srcElement;
        KeyElemObj.value = KeyElemObj.value;
      
        if ( KeyElemObj.value == "" ) {
            return;
        }

        if ( !isDate(KeyElemObj.value) ) {
            alert("올바른 날짜가 아닙니다.");
            KeyElemObj.value = "";
            KeyElemObj.focus();
            return;
        }
      
        KeyElemObj.value = formatDate(KeyElemObj.value);
    }



   /*****************************************************************************
    * 날짜형식으로 입력되었는지 검색한다.
    *****************************************************************************/
    function formatDate(data) {
        return formatDateSeparator(data, sDateSeparator);
    }


   /*****************************************************************************
    * 날짜형식으로 입력되었는지 검색한다.
    *****************************************************************************/
    function formatDateSeparator(data, par)
    {
        var sDate        = getNumber(data);
        var sTemp        = '';

        if (sDate.length == 6 || sDate.length == 8)
        {
            if(!isDate(sDate)) {
                return sDate;
            }
            sTemp = sTemp + sDate.substring(0, 4) + par + sDate.substring(4, 6);

            if (sDate.length = 8) {
                sTemp = sTemp + par + sDate.substring(6);
            }
        } else if (sDate.length == 12 ) {
            sTemp = ( sDate.substring( 0,  4) + par +
                      sDate.substring( 4,  6) + par +
                      sDate.substring( 6,  8) + " " +
                      sDate.substring( 8, 10) + ":" +
                      sDate.substring(10    ) );
        } else if (sDate.length == 14 ) {
            sTemp = ( sDate.substring( 0,  4) + par +
                      sDate.substring( 4,  6) + par +
                      sDate.substring( 6,  8) + " " +
                      sDate.substring( 8, 10) + ":" +
                      sDate.substring(10, 12) + ":" +
                      sDate.substring(12    ) );
        } else {
            sTemp = sDate;
        }

        return sTemp;
    }


   /*****************************************************************************
    * data가 날짜형식 범위에 맞는지 검색
    *****************************************************************************/
    function isDate(sDate) {
        var isOK = false;

        sDate = getNumber(sDate);

        if ( sDate.length != 8 ) {
            return false;
        }

        var syy  = Number(sDate.substr(0, 4));
        var smm  = Number(sDate.substr(4, 2));
        var sdd  = Number(sDate.substr(6, 2));

        if((smm==1)||(smm==3)||(smm==5)||(smm==7)||(smm==8)||(smm==10)||(smm==12)) {
           if(sdd<=31) {
              isOK = true;
           }
        }
        else if((smm==4)||(smm==6)||(smm==9)||(smm==11)) {
           if(sdd<=30) {
              isOK = true;
           }
        }
        else if(smm==2) {
           if((syy%4==0) && (syy%100!=0) ||(syy%400==0)) {
              if(sdd<=29) {
                 isOK = true;
              }
           }
           else {
              if(sdd<=28) {
                 isOK = true;
              }
           }
        }

        if(!isOK || (sdd == 0)) {
            return false;
        }
        return true;
    }


   /*****************************************************************************
    * data가 날짜형식 범위에 맞는지 검색
    *****************************************************************************/
    function isDateObject(obj, objName) {
        if ( !isDate(obj.value) ) {
            alert(objName + "은(는) 존재하지 않는 날짜입니다.");
            obj.focus();
            return false;
        }

        return true;
    }

    
    /***************************************************************************
    * 년, 월에 맞는 마지막 날짜를 계산해 낸다.
    ***************************************************************************/
    function getLastDate(sDate) {
        nLastDate = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        nYear  = Number(sDate.substring(0, 4));
        nMonth = Number(sDate.substring(4, 6)) - 1;

        if((nYear%4 == 0) && (nYear%100 != 0) || (nYear%400 == 0)) {
            nLastDate[1] = 29;
        }

        return nLastDate[nMonth];
    }

    /***************************************************************************
     * Date StringFormat
     * 
     * 사용예
     * //2013년 04월 12일 오후 02시 16분 42초
     * new Date().format("yyyy년 MM월 dd일 a/p hh시 mm분 ss초");
     * 
     * //2013-04-12
     * new Date().format("yyyy-MM-dd");
     * 
     * //'13 04.12
     * new Date().format("'yy MM.dd");
     * 
     * //2013-04-12 금요일
     * new Date().format("yyyy-MM-dd E");
     * 
     * //현재년도 : 2013
     * new Date().format("yyyy");
     ***************************************************************************/
    Date.prototype.format = function(f) {
        if (!this.valueOf()) return " ";
        
        var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
        var d = this;
        
        return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
            switch ($1) {
                case "yyyy": return d.getFullYear();
                case "yy"  : return (d.getFullYear() % 1000).zf(2);
                case "MM"  : return (d.getMonth() + 1).zf(2);
                case "dd"  : return d.getDate().zf(2);
                case "E"   : return weekName[d.getDay()];
                case "HH"  : return d.getHours().zf(2);
                case "hh"  : return ((h = d.getHours() % 12) ? h : 12).zf(2);
                case "mm"  : return d.getMinutes().zf(2);
                case "ss"  : return d.getSeconds().zf(2);
                case "a/p" : return d.getHours() < 12 ? "오전" : "오후";
                default    : return $1;
            }
        });
    };
    String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
    String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
    Number.prototype.zf = function(len){return this.toString().zf(len);};
    
    /***************************************************************************
     * 월의 마지막 날짜를 계산한다.
     * 인수:dt (yyyyMMdd 형식)
     ***************************************************************************/
    function getLastDt(dt) {
        var rtnDt = new Date(dt.substr(0, 4), Number(dt.substr(4, 2)) - 1, dt.substr(6, 2));
        rtnDt.setMonth(rtnDt.getMonth() + 1);
        rtnDt.setDate(0);
        
        return rtnDt.format("yyyyMMdd");
    }
    
    /***************************************************************************
     * 월의 마지막 날짜를 계산한다.
     * 인수:dt (yyyyMMdd 형식)
     ***************************************************************************/
    function addYear(dt, n) {
        var rtnDt = new Date(dt.substr(0, 4), Number(dt.substr(4, 2)) - 1, dt.substr(6, 2));
        rtnDt.setFullYear(rtnDt.getFullYear() + n);
        
        return rtnDt.format("yyyyMMdd");
    }
    
    /***************************************************************************
     * 월의 마지막 날짜를 계산한다.
     * 인수:dt (yyyyMMdd 형식)
     ***************************************************************************/
    function addMonth(dt, n) {
        var rtnDt = new Date(dt.substr(0, 4), Number(dt.substr(4, 2)) - 1, dt.substr(6, 2));
        rtnDt.setMonth(rtnDt.getMonth() + n);
        
        return rtnDt.format("yyyyMMdd");
    }
    
    /***************************************************************************
     * 월의 마지막 날짜를 계산한다.
     * 인수:dt (yyyyMMdd 형식)
     ***************************************************************************/
    function addDay(dt, n) {
    	alert(dt);
    	dt = getNumber(dt);
        var rtnDt = new Date(dt.substr(0, 4), Number(dt.substr(4, 2)) - 1, dt.substr(6, 2));
        rtnDt.setDate(rtnDt.getDate() + n);
        alert(rtnDt.format("yyyyMMdd"));
        return rtnDt.format("yyyyMMdd");
    }
    
    /*****************************************************************************
     * 시간형식(hhmi)으로 입력되었는지 검색한다.
     * onblur event에 사용한다. ( 예: onBlur="blurHHMI(); )
     *****************************************************************************/
     function blurTime()
     {
         var KeyElemObj   = event.srcElement;
         KeyElemObj.value = KeyElemObj.value;
       
         if ( KeyElemObj.value == "" ) {
             return;
         }

         if ( !isTime(KeyElemObj.value) ) {
             alert("올바른 시간이 아닙니다.");
             KeyElemObj.value = "";
             KeyElemObj.focus();
             return;
         }
       
         KeyElemObj.value = formatTime(KeyElemObj.value);
     }
     
     function isTime(sTime) {
         var isOK = false;

         sTime = getNumber(sTime);

         if ( sTime.length != 2 && sTime.length != 4 && sTime.length != 6 ) {
             return false;
         }
         
         var shh  = Number(sTime.substr(0, 2));
         var smi  = Number(sTime.substr(2, 2));
         var sss  = Number(sTime.substr(4, 2));
         
         if (sTime.length == 2) {
        	 if (shh >= 0 && shh <= 23) {
            	 isOK = true;
             }
         }
         if (sTime.length == 4) {
        	 if (shh >= 0 && shh <= 23 && smi >= 0 && smi <= 59) {
            	 isOK = true;
             }
         }
         if (sTime.length == 6) {
        	 if (shh >= 0 && shh <= 23 && smi >= 0 && smi <= 59 && sss >= 0 && sss <= 59) {
            	 isOK = true;
             }
         }
         
         return isOK;
     }
     
     /*****************************************************************************
      * 날짜형식으로 입력되었는지 검색한다.
      *****************************************************************************/
      function formatTime(data) {
          return formatTimeSeparator(data, ":");
      }


     /*****************************************************************************
      * 날짜형식으로 입력되었는지 검색한다.
      *****************************************************************************/
      function formatTimeSeparator(data, par)
      {
    	  var sTime        = getNumber(data);
          var sTemp        = '';
          
          if (sTime.length == 2 || sTime.length == 4 || sTime.length == 6) {
        	  if(!isTime(sTime)) {
                  return sTime;
              }
        	  
        	  if (sTime.length == 2) {
        		  sTemp = sTime;
        	  }
        	  if (sTime.length == 4) {
        		  var shh  = sTime.substr(0, 2);
        	      var smi  = sTime.substr(2, 2);
        		  sTemp = shh + ":" + smi;
        	  }
        	  if (sTime.length == 6) {
        		  var shh  = sTime.substr(0, 2);
        	      var smi  = sTime.substr(2, 2);
        	      var sss  = sTime.substr(4, 2);
        	      sTemp = shh + ":" + smi + ":" + sss;
        	  }
          }
    	  
          return sTemp;
      }
