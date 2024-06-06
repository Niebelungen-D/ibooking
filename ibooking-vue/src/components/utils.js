export function getDateFormat(){
    var date = new Date();
    var month = date.getMonth() + 1;
    if (month < 10) month = '0' + month;
    var day = date.getDate();
    if (day < 10) day = '0' + day;
    var ret = date.getFullYear() + "-" + month + "-" + day;
    return ret;
}
export function getTimeFormat(){
    var date = new Date();
    var month = date.getMonth() + 1;
    if (month < 10) month = '0' + month;
    var day = date.getDate();
    if (day < 10) day = '0' + day;

    var hour = date.getHours();
    if (hour < 10) hour = '0' + hour;
    var minute = date.getMinutes();
    if (minute < 10) minute = '0' + minute;
    var second = date.getSeconds();
    if (second < 10) second = '0' + second;

    var ret = date.getFullYear() + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
    return ret;
}

export function checkDateFormat(str){
    var reg = /^[1-9]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[1-2][0-9]|3[0-1])$/;
    var regExp = new RegExp(reg)
    return regExp.test(str);
}

export function checkTimeFormat(str){
    var reg = /^[1-9]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[1-2][0-9]|3[0-1])\s+(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d$/;
    var regExp = new RegExp(reg)
    return regExp.test(str);
}

export function checkCanCheckin(nowtime, startTime){

}
