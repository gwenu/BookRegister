function request(parameters) {
    $.ajax({
        url: parameters.url,
        type: parameters.method,
        data: parameters.requestBody,
        dataType: "xml",
        success: function (data) {
        	$("#errors").text("");
            var xmlTextArea = $("#response");
            xmlTextArea.val((new XMLSerializer()).serializeToString(data));
        },
        error: function (error) {
            console.log("Error");
            $("#errors").text("Something go wrong with ajax!");
        }
    });
};

function validateAndGetParams() {
    var method = $("select[name='request-method']").val();
    var url = $("select[name='url']").val();
    var parameters = $("#parameters").val();
    var requestBody = $("#request").val();

    if(method == "GET" && !url) {
        $("#errors").text("Url is missing. Please provide correct url!");
        return false;
    }


    if(method == "POST" && !url && !parameters) {
        $("#errors").text("Url or parameters are missing. Please provide correct url and parameters!");
        return false;
    }
    
    return {
        url: formUrl(url, parameters),
        method: method,
        parameters: parameters,
        requestBody: requestBody
    };
};

function formUrl(url, parameters){
	return url + "?" + parameters.replace(",", "&");
}

function send() {
    var parameters = validateAndGetParams();
    if(parameters) {
        request(parameters);
    }
};