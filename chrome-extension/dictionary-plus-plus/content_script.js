/**
 * Created by kangald on 14/07/2015.
 */

document.body.addEventListener("dblclick", function () {
    var selection = window.getSelection().toString();
    console.log("SELECTION: ", selection);
    var json = {};
    json["method"] = "search";
    json["key"] = selection;
    chrome.runtime.sendMessage(json, function (response) {
        var results = parse(response.status);
        showResultsInDialogBox(results);
    });
});

function parse(response) {
    var results = "";
    var obj = JSON.parse(response);
    var i;
    for (i = 0; i < obj.results.length; i++) {
        results = results + obj.results[i] + ", ";
    }
    return results.substring(0, results.lastIndexOf(","));
}

function showResultsInDialogBox(text) {
    var dialogBox = document.createElement("div");
    dialogBox.setAttribute("id", "dialog");
    dialogBox.setAttribute("class", "result-dialog");

    var pNode = document.createElement("p");
    pNode.innerHTML = text;
    dialogBox.appendChild(pNode);

    document.body.appendChild(dialogBox);

    $("#dialog").click(function (e) {
        var x = e.pageX - $(document).scrollLeft();
        var y = e.pageY - $(document).scrollTop();
        $("#dialog").dialog({
            autoOpen: false,
            show: "blind",
            hide: "explode",
            position: [x, y]
        });
        $("#dialog").dialog('open');
    });
}