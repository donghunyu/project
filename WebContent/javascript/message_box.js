    /**************************************************************************
     *  화면크기 변경시
     **************************************************************************/
    function resizeRock() {
        try {
            removeMsg();
        } catch ( e ) {
            
        }
    }

    /**************************************************************************
     *  화면 스크롤시
     **************************************************************************/
    function scrollPage() {
        try {
            removeMsg();
        } catch ( e ) {
            
        }
    }

    /**************************************************************************
     *  객체 사라짐
     **************************************************************************/
    function alphaBox(target, alpha, duration ) {
        try {
            var interval = 250;
            
            var origin = Number((target.style.opacity)?target.style.opacity:1);
            
            if ( duration > 0 ) {
                var stepNum = Math.floor( duration / interval );
                var targetAlpha = origin + (alpha - origin) / stepNum;
                
                // IE
                if ( navigator.userAgent.toLowerCase().indexOf("msie") != -1 ) {
                    target.style.filter = "alpha(opacity="+(targetAlpha*100)+")";
                } else {
                    target.style.opacity = targetAlpha;
                }
            } else {
                removeMsg();
            }
            
            duration -= interval;
            if ( duration >= 0 ) target.tween = setTimeout(function(){ alphaBox(target, alpha, duration);},interval);
        } catch ( e ) {
            
        }
    }

    function createMsg(message) {
    	return;
    	
        var objBody = document.body;
        var objMsgDivID = "iframeMsg";
        var objDiv  = document.getElementById(objMsgDivID);
        
        if ( objDiv == null ) {
            objDiv = document.createElement("div");
            objDiv.setAttribute("id" ,objMsgDivID);
        }

        var nTop    = 0;
        var nLeft   = 0;
        var nHeight = 30;
        var nWidth  = 0;
        
        // IE
        if ( navigator.userAgent.toLowerCase().indexOf("msie") != -1 ) {
            nTop    = window.innerHeight;
            nWidth  = window.innerWidth ;
        } else {
            nTop    = window.innerHeight;
            nWidth  = window.innerWidth ;
        }
        
        if ( nWidth > 1260 ) {
        	nWidth = 1260;
        }

        objDiv.style.top             = (nTop - nHeight) + "px";
        objDiv.style.left            = nLeft            + "px";
        objDiv.style.width           = nWidth           + "px";
        objDiv.style.height          = nHeight          + "px";
        objDiv.style.position        = "absolute";
        objDiv.style.overflow        = "hidden";
        objDiv.style.borderStyle     = "solid";
        objDiv.style.borderColor     = "#8b4513";
        objDiv.style.borderWidth     = "0";
        objDiv.style.backgroundColor = "#8b4513";
        objDiv.style.color           = "#FFFFFF";
        objDiv.style.fontWeight      = "bold";
        
        var innerHtml = "";
        innerHtml += "<table id=\"main_table\" width=\"100%\" height=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">";
        innerHtml += "  <tr>";
        innerHtml += "    <td>&nbsp;"+ message;
        innerHtml += "    </td>";
        innerHtml += "    <td width=\"30\" style=\"text-align:center; cursor:pointer;\" onclick=\"removeMsg();\">닫기";
        innerHtml += "    </td>";
        innerHtml += "  </tr>";
        innerHtml += "</table>";
        
        objDiv.innerHTML = innerHtml; 
        if ( document.getElementById(objMsgDivID) == null ) {        
            objBody.appendChild(objDiv);
        }
        
        alphaBox(objDiv, 0, 5000 );
    }
    
    function removeMsg() {
        var objBody = document.body;
        var objMsgDivID = "iframeMsg";
        var objDiv  = document.getElementById(objMsgDivID);
        
        if ( objDiv == null ) {
            return;
        }

        objBody.removeChild(objDiv);
        objDiv = null;
    }

    window.onresize    = resizeRock;
