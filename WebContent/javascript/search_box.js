    var srcSearchBoxObj;              // 호출된 Object
    var srcSearchBoxObjRow = 0;
    
    var objSearchBoxDivID = "searchBox";
    var objSearchBoxDiv   = document.getElementById(objSearchBoxDivID);

    
    function findPosX(obj) {
    	var curleft = 0;
    	var temp = 0;
    	if ( obj.offsetParent) {
    		while(1) {
    		    try {
    		        temp = obj.offset().left;
    		    } catch(e){
    		        temp = 0;
    		    }
    		    curleft += temp;
    			if ( !obj.offsetParent ) {
    				break;
    			}
    			obj = obj.offsetParent;
    		}
    	} else if ( obj.x ) {
    		curleft += obj.x;
    	}
    	
    	return curleft;
    }
    
    
    function findPosY(obj) {
    	var curtop = 0;
    	var temp = 0;
    	if ( obj.offsetParent) {
    		while(1) {
    		    try {
    		        temp = obj.offset().top;
    		    } catch(e){
    		        temp = 0;
                }
    		    curtop += temp;
    			if ( !obj.offsetParent ) {
    				break;
    			}
    			obj = obj.offsetParent;
    		}
    	} else if ( obj.y ) {
    		curtop += obj.y;
    	}
    	
    	return curtop;
    }
    
    
    /***************************************************************************
     * 생성
     ***************************************************************************/
    function createSearchBox() {
        var objBody = document.body;
        
        if ( objSearchBoxDiv == null ) {
        	objSearchBoxDiv = document.createElement("div");
        	objSearchBoxDiv.setAttribute("id" ,objSearchBoxDivID);
        }

        objSearchBoxDiv.style.position        = "absolute";
        objSearchBoxDiv.style.overflow        = "hidden";
        objSearchBoxDiv.style.borderStyle     = "solid";
        objSearchBoxDiv.style.borderColor     = "#8b4513";
        objSearchBoxDiv.style.borderWidth     = "0";
        
        var nTop  = findPosY(srcSearchBoxObj) + 20; 
        var nLeft = findPosX(srcSearchBoxObj); 
        
        var srcObjs = document.getElementsByName(srcSearchBoxObj.id);
        for ( var i = 0; i < srcObjs.length; i++ ) {
        	if ( srcObjs[i] == srcSearchBoxObj ) {
        		srcSearchBoxObjRow = i;
        	}
        }
        
//        nTop  = nTop + srcSearchBoxObj + (srcSearchBoxObjRow * 30);
//        nLeft = nLeft + srcSearchBoxObj + (srcSearchBoxObjRow * 30);
        
        objSearchBoxDiv.style.top  = nTop  + "px";
        objSearchBoxDiv.style.left = nLeft + "px";

    	if ( document.getElementById(objSearchBoxDivID) == null ) {
            objBody.appendChild(objSearchBoxDiv);
        }
    }


    /***************************************************************************
     * 생성
     ***************************************************************************/
    function setSearchBoxHtml(msg) {
    	createSearchBox();
    	
    	objSearchBoxDiv.innerHTML = msg;
    	objSearchBoxDiv.style.display="inline";
    }
    
    /***************************************************************************
     * 생성
     ***************************************************************************/
    function setSearchBoxHtml2(msg) {
    	createSearchBox();
    	
    	objSearchBoxDiv.innerHTML = msg;
    	adjustSearchBoxPosition(25, 220);
    	objSearchBoxDiv.style.display="inline";
    }

    
    /***************************************************************************
     * 생성
     ***************************************************************************/
    function removeSearchBox() {
        if(objSearchBoxDiv == null) {
        	return;
        }

        objSearchBoxDiv.innerHTML = "";
        stime=window.setTimeout("document.getElementById('"  + objSearchBoxDivID + "').style.display='none'", 200);
    }
    
    
    /***************************************************************************
     * - 팝업되는 div위치 지정.
     * - 팝업되는 div가 화면 아래를 넘지 않도록 조절.
     ***************************************************************************/
    function adjustSearchBoxPosition(adjX, adjY) {
      
        var bHeight = $(window).height();             // 브라우저 height
        var nTop  = findPosY(srcSearchBoxObj) - adjX; // 팝업div y위치
        var nLeft = findPosX(srcSearchBoxObj) - adjY; // 팝업div x위치
        var adjHeight = 0;
        
        objSearchBoxDiv.style.left = nLeft + "px";
        objSearchBoxDiv.style.top  = nTop  + "px";
/*
        if (nTop + $(objSearchBoxDiv).height() > bHeight) {
            adjHeight = nTop + $(objSearchBoxDiv).height() - bHeight;
            objSearchBoxDiv.style.top  = nTop - adjHeight + "px";
        }
*/
    }

