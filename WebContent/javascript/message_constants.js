    function setMessageText(messageCode) {

    	var messge_text = "";
        switch (messageCode)
        {
            case "search" :
            	messge_text = "조회중입니다. 잠시만 기다려 주시기 바랍니다.";
                break;
            case "save"   :
            	messge_text = "저장중입니다. 잠시만 기다려 주시기 바랍니다.";
                break;
            case "delete" :
            	messge_text = "삭제중입니다. 잠시만 기다려 주시기 바랍니다.";
                break;
            case "move"   :
            	messge_text = "화면이동중입니다. 잠시만 기다려 주시기 바랍니다.";
                break;
            default :
            	messge_text = "작업 처리중입니다. 잠시만 기다려 주시기 바랍니다.";
                break;
        }

        return messge_text;
    }
