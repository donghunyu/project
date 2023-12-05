    var srcObj;              // 호출된 Object

    var nYear;               // 해당 년
    var nMonth;              // 해당 월
    var nDate;               // 해당 일
    var nWeekend;            // 해당 날짜 주일

    var cYear;               // 현재 년
    var cMon;                // 현재 월
    var cDate;               // 현재 일

    var sScreen;             // 화면에 뿌려질 모든 내용

    var FontFace = "굴림";
    var FontSize = -1;

    var sImagePath = "/rfid.w/javascript/";

    sMonths   = ["1월", "2월", "3월", "4월", "5월", "6월","7월", "8월", "9월", "10월", "11월", "12월"];
    nLastDate = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];


    var objDatePickerDivID = "datePicker";
    var objDatePickerDiv   = document.getElementById(objDatePickerDivID);
    
    
    function createDatePickermessage() {
        var objBody = document.body;
        
        if ( objDatePickerDiv == null ) {
            objDatePickerDiv = document.createElement("div");
            objDatePickerDiv.setAttribute("id" ,objDatePickerDivID);
        }

        objDatePickerDiv.style.position        = "absolute";
        objDatePickerDiv.style.overflow        = "hidden";
        objDatePickerDiv.style.borderStyle     = "solid";
        objDatePickerDiv.style.borderColor     = "#8b4513";
        objDatePickerDiv.style.borderWidth     = "0";
        
        if ( document.getElementById(objDatePickerDivID) == null ) {        
            objBody.appendChild(objDatePickerDiv);
        }
    }


    /***************************************************************************
    * 현재 날짜를 구한다.
    ***************************************************************************/
    function CurrDate() {
        var now  = new Date();

        cYear    = now.getYear();
        cMon     = now.getMonth();
        cDate    = now.getDate();
    }

    
    /***************************************************************************
     * 현재 날짜를 구해 document의 id값에 넣어준다.
     ***************************************************************************/
     function getCurrDate(id) {
         var now  = new Date();
         
         now.format("yyyy-MM-dd");
         
         document.getElementById(id).value = now.format("yyyy-MM-dd");
     }

     
    /***************************************************************************
    * Obj로 넘어온 값을 처리한다.
    ***************************************************************************/
    function getDatePicker(objTarget, event) {
        srcObj = document.getElementById(objTarget);
        createDatePickermessage();
        
        var nTop    = 0;
        var nLeft   = 0;

        // IE
        if ( browser == "msie" ) {
            nTop    = event.clientY + document.documentElement.scrollTop  - 15;
            nLeft   = event.clientX + document.documentElement.scrollLeft - 10;
        } else {
            nTop    = event.pageY + document.documentElement.scrollTop  - 15;
            nLeft   = event.pageX + document.documentElement.scrollLeft - 10;
        }
        
    	objDatePickerDiv.style.top  = nTop  + "px";
    	objDatePickerDiv.style.left = nLeft + "px";

        getYearMonthDay(getNumber(srcObj.value));
    }


    /***************************************************************************
    * String으로 넘어온 날짜 형식에서 년, 월, 일을 분리한다.
    ***************************************************************************/
    function getYearMonthDay(sStr) {
      
        if(sStr.length != 8) {
            var FromDate = new Date();

            nYear  = FromDate.getFullYear();
            nMonth = FromDate.getMonth();
            nDate  = FromDate.getDate();

        } else {
            nYear  = Number(sStr.substring(0, 4));
            nMonth = Number(sStr.substring(4, 6)) - 1;
            nDate  = Number(sStr.substring(6, 8));
        }

        sScreen = "";

        CurrDate();
        getWeekend();
        getLastDay();
        ShowDatePickerTop();
        ShowDatePickerMiddle();

        objDatePickerDiv.innerHTML=sScreen;
        objDatePickerDiv.style.display="inline";
    }

    /***************************************************************************
    * 년, 월, 일에 맞는 요일을 찾아낸다.
    ***************************************************************************/
    function getWeekend() {
        tempDate = new Date(nYear, nMonth, 1);
        nWeekend = tempDate.getDay();

        return nWeekend;
    }


    /***************************************************************************
    * 해당년에서 nNum만큼 떨어진 년도의 해당 날짜를 리턴한다.
    ***************************************************************************/
    function getComputeYear(nNum) {
        var sReturn = "";

        sReturn += (nYear + nNum).toString();
        sReturn += (((nMonth + 1) < 10) ? "0" : "") + (nMonth + 1);
        sReturn += ((nDate < 10) ? "0" : "") + nDate;

        return sReturn;
    }


    /***************************************************************************
    * 해당년월에서 nNum만큼 떨어진 월의 해당 날짜를 리턴한다.
    ***************************************************************************/
    function getComputeMonth(nNum) {
        tempYear = nYear;
        cMonth = nMonth + nNum;

        if (cMonth > 11) {
            tempYear += 1;
            cMonth = 0;
        } else if (cMonth < 0) {
            tempYear -= 1;
            cMonth = 11;
        }

        var sReturn = "";

        sReturn += (tempYear).toString();
        sReturn += (((cMonth + 1) < 10) ? "0" : "") + (cMonth + 1);
        sReturn += ((nDate < 10) ? "0" : "") + nDate;

        return sReturn;
    }


    /***************************************************************************
    * 년, 월에 맞는 마지막 날짜를 계산해 낸다.
    ***************************************************************************/
    function getLastDay() {
        if((nYear%4 == 0) && (nYear%100 != 0) || (nYear%400 == 0)) {
            nLastDate[1] = 29;
        }

        return nLastDate[1];
    }


    /***************************************************************************
    * 선택된 날짜를 리턴한다.
    ***************************************************************************/
    function getSelectDay(nNum) {
        nDate = nNum;
        temp = "";

      	temp = nYear;
      	temp += (((nMonth + 1) < 10) ? "0" : "") + (nMonth + 1);
      	temp += ((nDate < 10) ? "0" : "") + nDate;

        srcObj.value = formatDate(temp);

        HideDatePicker();
    }

    /***************************************************************************
    * 달력의 상위 메뉴 및 환경을 보여준다.
    ***************************************************************************/
    function ShowDatePickerTop() {

      	sScreen += "\n" + "<table width='162' border='1' cellspacing='0' cellpadding='0' bgcolor='#666666' onMouseOut='HideDatePicker();' onMouseOver='MouseOn();' >";
      	sScreen += "\n" + "  <tr>";
      	sScreen += "\n" + "    <td bgcolor='#FFFFFF'>";
      	sScreen += "\n" + "      <table width='160' border='0' cellspacing='0' cellpadding='0'>";
      	sScreen += "\n" + "        <tr>";
      	sScreen += "\n" + "          <td width='34' colspan='2' valign='top'><img src='" + sImagePath + "/datepicker/t_year.gif' width='34' height='12'></td>";
      	sScreen += "\n" + "          <td rowspan='2' align='center' bgcolor='#b9e4d6'><font face=" + FontFace + " size='2'><b>" + nYear + "년 " + sMonths[nMonth] + "</b></font></td>";
      	sScreen += "\n" + "          <td width='34' colspan='2' valign='top'><img src='" + sImagePath + "/datepicker/t_mon.gif' width='34' height='12'></td>";
      	sScreen += "\n" + "        </tr>";
      	sScreen += "\n" + "        <tr> ";
      	sScreen += "\n" + "          <td width='17' bgcolor=9ccfce style='cursor:pointer'><a href=\"#\" onclick=\"getYearMonthDay('" + getComputeYear (-1) + "');\">";
      	sScreen += "\n" + "            <img src='" + sImagePath + "/datepicker/prev.gif' width=15 height=9 hspace=3 vspace=3 border=0 alt='이전 년도'></a></td>";
      	sScreen += "\n" + "          <td width='17' bgcolor=9ccfce style='cursor:pointer'><a href=\"#\" onclick=\"getYearMonthDay('" + getComputeYear ( 1) + "');\">";
      	sScreen += "\n" + "            <img src='" + sImagePath + "/datepicker/next.gif' width=15 height=9 hspace=3 vspace=3 border=0 alt='다음 년도'></a></td>";
      	sScreen += "\n" + "          <td width='17' bgcolor=9ccfce style='cursor:pointer'><a href=\"#\" onclick=\"getYearMonthDay('" + getComputeMonth(-1) + "');\">";
      	sScreen += "\n" + "            <img src='" + sImagePath + "/datepicker/prev.gif' width=15 height=9 hspace=3 vspace=3 border=0 alt='이전 월'></a></td>";
      	sScreen += "\n" + "          <td width='17' bgcolor=9ccfce style='cursor:pointer'><a href=\"#\" onclick=\"getYearMonthDay('" + getComputeMonth( 1) + "');\">";
      	sScreen += "\n" + "            <img src='" + sImagePath + "/datepicker/next.gif' width=15 height=9 hspace=3 vspace=3 border=0 alt='다음 월'></a></td>";
      	sScreen += "\n" + "        </tr>";
      	sScreen += "\n" + "      </table>";

      	// 요일을 표시한다.
      	sScreen += "\n" + "      <table width='160' border='0' cellspacing='0' cellpadding='0' bgcolor='#ffffff'>";
      	sScreen += "\n" + "        <tr>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/sun.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/mon.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/tue.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/wed.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/thu.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/fri.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "          <td><img src='" + sImagePath + "/datepicker/sat.gif' width='23' height='17' hspace='0' vspace='1'></td>";
      	sScreen += "\n" + "        </tr>";

    }



    /***************************************************************************
    * 달력의 실제 날짜를 설정한다.
    ***************************************************************************/
    function ShowDatePickerMiddle() {
        var nDay = 1;
        var bNext = false;
      	sScreen += "\n" + "        <tr align='center'>";

      	// 각 달의 1일이 나올때 까지 공백을 채운다.
      	for(var i = 0; i < nWeekend; i++)
            sScreen += "\n" + "          <td height='19'></td>";

        //
        for(var i = nWeekend; i < 7; i++) {
   			    if( nDay == nDate) {
                if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                    sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor='' BGCOLOR='navyblue'><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'><b>" + nDay+	"</b></FONT></a></TD>";
                } else {
                    sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor='' BGCOLOR='navyblue'><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'>" + nDay+	"</FONT></a></TD>";
                }
   			    } else {
  			        if ( i == 0) {
                    if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='FF0000'><b>" + nDay+	"</b></FONT></a></TD>";
                    } else {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='FF0000'>" + nDay+	"</FONT></a></TD>";
                    }
                } else if ( i == 6) {
                    if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='0000FF'><b>" + nDay+	"</b></FONT></a></TD>";
                    } else {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='0000FF'>" + nDay+	"</FONT></a></TD>";
                    }
                } else {
                    if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'><b>" + nDay+	"</b></FONT></a></TD>";
                    } else {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'>" + nDay+	"</FONT></a></TD>";
                    }
                }
            }
            nDay++;
        }
      	sScreen += "\n" + "        </tr> ";


      	// 두번째 ~ 마지막주까지 보여주기
      	for (var i = 1; i < 6; i++) {

          	sScreen += "\n" + "        <tr align='center'> ";

      		  for (var j = 0; j < 7; j++) {
      			    if(( nDay == nDate) && (!bNext)) {
                    if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor='' BGCOLOR='navyblue'><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'><b>" + nDay+	"</b></FONT></a></TD>";
                    } else {
                        sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor='' BGCOLOR='navyblue'><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'>" + nDay+	"</FONT></a></TD>";
                    }
      			    } else if(!bNext) {
      			        if ( j == 0) {
                        if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                            sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='FF0000'><b>" + nDay+	"</b></FONT></a></TD>";
                        } else {
                            sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='FF0000'>" + nDay+	"</FONT></a></TD>";
                        }
                    } else if ( j == 6) {
                        if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                            sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='0000FF'><b>" + nDay+	"</b></FONT></a></TD>";
                        } else {
                            sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='0000FF'>" + nDay+	"</FONT></a></TD>";
                        }
                    } else {
                        if ((nYear == cYear) && (nMonth == cMon) && (nDay == cDate)) {
                            sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'><b>" + nDay+	"</b></FONT></a></TD>";
                        } else {
                            sScreen += "\n" + "          <td height='19' style='cursor:pointer' onMouseOver=this.style.backgroundColor='#E9EAF6' onMouseOut=this.style.backgroundColor=''><a href='#' onclick='getSelectDay(" + nDay + ");return false;'><FONT SIZE='-1' FACE='" + FontFace + "'>" + nDay+	"</FONT></a></TD>";
                        }
                    }
                } else {
                    sScreen += "\n" + "          <td height=19><FONT SIZE='-1' FACE='" + FontFace + "' COLOR='CCCCCC'>" + nDay+	"</FONT></TD>";
                }
          			nDay++;

                // 현재 월의 마지막일 보다 크면 다음달로 체크한다.
          			if (nDay > nLastDate[nMonth])
          			{
          				  nDay = 1;
                    bNext = true;
          			}

            }

          	sScreen += "\n" + "        </tr>";
            if (bNext) break;
      	}

      	sScreen += "\n" + "      </table>";
      	sScreen += "\n" + "    </td>";
      	sScreen += "\n" + "  </tr>";
      	sScreen += "\n" + "</table>";

    }

    var stime

    function MouseOn() {
        window.clearTimeout(stime);
    }


    function HideDatePicker() {
        stime=window.setTimeout("document.getElementById('"  + objDatePickerDivID + "').style.display='none'", 200);
    }

