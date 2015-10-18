/**
 * Created by kangald on 16/07/2015.
 */

var DEFAULT_SERVICE = "tureng";
var PREFERRED_SERVICE = "preferredService";

function getPreferredService() {
    var preferred = getLocal(PREFERRED_SERVICE);
    return (preferred != null) ? preferred : DEFAULT_SERVICE;
}

function savePreferredService(value) {
    value = (value != null) ? value : DEFAULT_SERVICE;
    saveLocal(PREFERRED_SERVICE, value);
}

function getLocal(key) {
    var value = localStorage.getItem(key);
    console.log("GET LOCAL:", key, value);
    return value;
}

function saveLocal(key, value) {
    localStorage.setItem(key, value);
    console.log("SAVE LOCAL", key, value);
}

function httpGet(url) {
    console.log("HTTP REQUEST URL: ", url);

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url, false);
    xmlHttp.send(null);

    console.log("HTTP RESPONSE STATUS: ", xmlHttp.status);
    console.log("HTTP RESPONSE TEXT: ", xmlHttp.responseText);

    return xmlHttp;
}