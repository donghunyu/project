/*
 *
 */
var version = "1.0.0",
    object_control = {};

object_control.comboDisabled = function(objectId, disabledYn) {
    var $objectId = $("#" + objectId);

    if("Y" == disabledYn) {
        $objectId.attr("disabled", "disabled");
        $objectId.attr("style", "background: #e4e4e4");
    } else {
        $objectId.removeAttr("disabled");
        $objectId.removeAttr("style");
    }
};

object_control.inputReadonly = function(objectId, readonlyYn) {
    var $objectId = $("#" + objectId);

    if("Y" == disabledYn) {
        $objectId.attr("disabled", "readonly");
        $objectId.attr("style", "background: #e4e4e4");
    } else {
        $objectId.removeAttr("readonly");
        $objectId.removeAttr("style");
    }
};

/**
 * Readonly 값으로 변경한다.
 * @param objectId 객체 ID
 * @param objectType Object Type
 * @param readonlyYn "Y" readonly, "N" not readonly
 */
object_control.readonly = function(objectId, objectType, readonlyYn) {

    var $objectId = $("#" + objectId + " " + objectType);

    if("Y" == readonlyYn) {
        addAttr($objectId, objectType);
    } else {
        removeAttr($objectId, objectType);
    }

    /**
     * attribute 를 추가한다.
     * @param $ jquery 객체
     * @param objectType Object Type
     */
    function addAttr($, objectType) {
        if("input" == objectType) {
            $.attr("readonly", "readonly");
        } else {
            $.attr("disabled", "disabled");
        }

        $.attr("style", "background: #e4e4e4");
    }

    /**
     * attribute를 삭제한다.
     * @param $ jquery 객체
     * @param objectType Object Type
     */
    function removeAttr($, objectType) {
        if("input" == objectType) {
            $.removeAttr("readonly", "readonly");
        } else {
            $.removeAttr("disabled", "disabled");
        }
        $.removeAttr("style");
    }
};

/**
 * Combobox에 시간을 추가한다.
 * @param objectId 객체ID
 * @param type hour 시간, min 분
 */
object_control.addTimeInCombobox = function(objectId, type) {

    var $objectId = $("#" + objectId),
        html = "",
        hour = 0,
        endHour = getEndNumber(type);

    for(var i = 0; i < endHour; i++) {
        html += "<option value=";
        hour = i + "";

        if(hour.length < 2) {
            hour = "0" + i;
        }

        html += "\"" + hour + "\"" + ">" + hour + "</option>";
    }

    $objectId.html(html);

    /**
     * 종료번호를 가져온다.
     * @param type hour 시간, min 분
     * @return hour 24, min 60, otherwise 0
     */
    function getEndNumber(type) {
        if("hour" == type) {
            return 24;
        } else if("min" == type) {
            return 60;
        } else {
            return 0;
        }
    }
};
