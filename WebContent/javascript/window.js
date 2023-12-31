
    /*****************************************************************************
    *   팝업창 띠우기
    *   sPopupType : Popup창 종류
    *   sPageID    : Page ID
    *****************************************************************************/
    function popup(sPageUrl, nWidth, nHeight, bScroll) {
        openPopup("popup", sPageUrl, nWidth, nHeight, bScroll);
    }

    /*****************************************************************************
    *   팝업창 띠우기
    *   PopupType : 
    *   sPage     : 
    *****************************************************************************/
    function openPopup(popupName, sPage, nWidth, nHeight, bScroll, bResizable, bStatus, bMenubar, bToolbar, nTop, nLeft) {
        sConfig    = "";

        try {
        	popupName.close();
        	eval(popupName).close();
        } catch ( e ) {
        }

       
        if ( nWidth  == null ) nWidth     = 1000;
        if ( nHeight == null ) nHeight    = 770;
        if ( nTop    == null ) nTop       = (screen.height - nHeight) / 2;
        if ( nLeft   == null ) nLeft      = (screen.width  - nWidth ) / 2;
        if ( bScroll    == null ) bScroll    = "no";
        if ( bResizable == null ) bResizable = "no";
        if ( bStatus    == null ) bStatus    = "no";
        if ( bMenubar   == null ) bMenubar   = "no";
        if ( bToolbar   == null ) bToolbar   = "no";

        sConfig = "top       = " + nTop       + ","
                + "left      = " + nLeft      + ","
                + "width     = " + nWidth     + ","
                + "height    = " + nHeight    + ","
                + "resizable = " + bResizable + ","
                + "scrollbars= " + bScroll    + ","
                + "status    = " + bStatus    + ","
                + "menubar   = " + bMenubar   + ","
                + "toolbar   = " + bToolbar;

        popupName = window.open(sPage, popupName, sConfig);
        try {
            popupName.focus();
        } catch ( e )  {
        	
        }
    }

    /*****************************************************************************
     *   팝업창 띠우기
     *   PopupType : 
     *   sPage     : 
     *****************************************************************************/
    function openPopupFullScreen(popupName, sPage, nWidth, nHeight, bScroll, bResizable, bStatus, bMenubar, bToolbar, nTop, nLeft) {
        sConfig    = "";

        try {
        	popupName.close();
        	eval(popupName).close();
        } catch ( e ) {
        }

        
        if ( nWidth  == null ) nWidth     = screen.availWidth;
        if ( nHeight == null ) nHeight    = screen.availHeight;
        if ( nTop    == null ) nTop       = (screen.availHeight - nHeight) / 2;
        if ( nLeft   == null ) nLeft      = (screen.availWidth  - nWidth ) / 2;
        if ( bScroll    == null ) bScroll    = "no";
        if ( bResizable == null ) bResizable = "no";
        if ( bStatus    == null ) bStatus    = "no";
        if ( bMenubar   == null ) bMenubar   = "no";
        if ( bToolbar   == null ) bToolbar   = "no";

        sConfig = "top       = " + nTop       + ","
                + "left      = " + nLeft      + ","
                + "width     = " + (nWidth - 20)     + ","
                + "height    = " + (nHeight - 40)    + ","
                + "resizable = " + bResizable + ","
                + "scrollbars= " + bScroll    + ","
                + "status    = " + bStatus    + ","
                + "menubar   = " + bMenubar   + ","
                + "toolbar   = " + bToolbar;

        popupName = window.open(sPage, popupName, sConfig);
        popupName.focus();
    }

    function checkPopupPage(){
    	if( opener != null ){

    	}else{
    	  var surl = "pop.html";
    	  var sname = "index"; 
    	  var popupOptions = "left=0, top=0, width=1024,height=768,toolbar=no,status=no,scrollbars=yes,resizable=no,menubar=no";

    	  // MIME로 6.x와 7.0 구분해줘야 함.. 
    	  var ie7_flag = false;
    	  ie7_flag = (window.navigator.userAgent.indexOf("MSIE 7") != -1);
    	  // 팝업으로 열기      
    	  window.open(surl, sname, popupOptions);
    	  // opener창 닫아주기
    	  if (ie7_flag) {
    	   // IE 7.0
    	   window.open(surl, '_self', popupOptions).close();
    	  }else {
    	   // IE 7.0아님..
    	   window.opener = self; 
    	          self.close(); 
    	  }
    	  return;
    	} 
    	}

    
    /*****************************************************************************
    *   팝업창 자동 크기지정
    *   PopupType : 
    *   sPage     : 
    *****************************************************************************/
    function autoPopupSize(tableId)
    {
        var TableObject = document.getElementById(tableId);

        nWidth  = TableObject.clientWidth;
        nHeight = TableObject.clientHeight;
        
        nHeightMax = 400;
        
        var objBrowser = navigator.appVersion;
        var nAddWidth  = 10;
        var nAddHeight = 29;
        var os = "";

        if ( navigator.appVersion.indexOf("NT") != -1 ) {
            os = objBrowser.substr(objBrowser.indexOf("NT"), 6);
            if (os > "NT 5.0") {
                nAddWidth  = 10;
                nAddHeight = 37;
            }
        }
        
        nWidth  = nWidth  + nAddWidth ;
        nHeight = nHeight + nAddHeight;
        
        var bScroll = false;
/*
        if ( screen.availHeight < nHeight ) {
            nHeight = screen.availHeight;
            bScroll = true;
        }
*/
        if ( nHeightMax < nHeight ) {
            nHeight = nHeightMax;
            bScroll = true;
        }

        if ( screen.availWidth  < nHeight ) {
            nWidth  = screen.availWidth ;
            bScroll = true;
        }

        if ( bScroll ) {
            document.body.scroll = "AUTO";
            if ( nWidth + 17 < screen.availWidth ) {
                nWidth = nWidth + 17;
            }
        }
        self.resizeTo(nWidth, nHeight);

        var nTop       = (screen.availHeight - nHeight) / 2;
        var nLeft      = (screen.availWidth  - nWidth ) / 2;
        
        moveTo(nLeft, nTop);
    }
    
    
    
    