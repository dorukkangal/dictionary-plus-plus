// After first installation, show options page

function install_notice() {
    if (localStorage.getItem("install_time"))
        return;

    var now = new Date().getTime();
    localStorage.setItem("install_time", now);
    chrome.tabs.create({url: "options.html"});
}
install_notice();

chrome.runtime.onMessage.addListener(function (request, sender, sendResponse) {
    console.log("REQUEST: ", request);
    if (request["method"] == "search") {
        var result = search(request["key"]);
        sendResponse({status: result.response});
    } else {
        sendResponse({status: "bbb"}); // snub them.
    }
});

function search(text) {
    var preferredService = getPreferredService();
    var url = "http://dictionary-plus-plus.elasticbeanstalk.com/search/" + preferredService + "/" + encodeURIComponent(text);
    return httpGet(url);
}