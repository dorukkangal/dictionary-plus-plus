/**
 * Created by kangald on 14/07/2015.
 */

document.addEventListener("DOMContentLoaded", onInit, false);

function onInit() {
    showAvailableServices();
    selectPreferredService();
    document.getElementById("save_settings").addEventListener("click", saveOption);
    document.getElementById("reset_settings").addEventListener("click", resetOption);
}

function showAvailableServices() {
    var services = JSON.parse(availableServices());

    var container = document.getElementById("services");
    var i;
    for (i = 0; i < services.length; i++) {
        if (services[i] && services[i].length > 0) {
            var html = "<label class='radio'>";
            html += "<input type='radio' name='selection'";
            html += " id='" + services[i].toLowerCase() + "'";
            html += " value='" + services[i].toLowerCase() + "'";
            html += " />";
            html += services[i];
            html += "</label>";
            console.log("html:", html);
            container.innerHTML += html;
        }
    }
}

function availableServices() {
    var url = "http://dictionary-plus-plus.elasticbeanstalk.com/settings";
    var dictionaries = httpGet(url);
    return dictionaries.responseText;
}

function selectPreferredService() {
    var preferred = getPreferredService();
    document.getElementById(preferred).checked = true;
}

function resetOption() {
    savePreferredService(null);
}

function saveOption() {
    var selection = getSelection();
    savePreferredService(selection);
}

function getSelection() {
    var radioButtons = document.getElementsByName("selection");
    var i, selection;
    for (i = 0; i < radioButtons.length; i++) {
        if (radioButtons[i].checked) {
            selection = radioButtons[i].value;
        }
    }
    console.log("selection: ", selection);
    return selection;
}
