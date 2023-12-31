    var arParamName;
    var arParamValue;

    /*****************************************************************************
    *   파라메터 추가
    *****************************************************************************/
    function addParam(sName, sValue) {
        if ( arParamName == null ) {
        	arParamName  = new Array();
        	arParamValue = new Array();
        }

        arParamName .push(sName );
        arParamValue.push(sValue);
    }

    /*****************************************************************************
    *   파라메터 String으로 반환
    *****************************************************************************/
    function getParam() {

    	return getParamSep('?');
    }
    
    function getParamSep(sep) {
        var sParam = "";

        if ( arParamName == null ) return sParam;

        var nCount = arParamName.length;
        for ( var i = 0; i < nCount; i++ ) {
        	sParam = sParam + arParamName [i] + "=";
        	sParam = sParam + arParamValue[i];

            if ( (i + 1) != nCount ) {
            	sParam = sParam + "&";
            }
        }

        arParamName  = null;
        arParamValue = null;

        return sep + sParam;
    }

