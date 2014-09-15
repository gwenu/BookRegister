var errors = $("#errors");

function request(parameters) {
    $.ajax({
        url: parameters.url,
        type: parameters.method,
        data: parameters.requestBody,
        dataType: "xml",
        success: function (data) {
            var xmlTextArea = $("#response");
            xmlTextArea.val((new XMLSerializer()).serializeToString(data));
        },
        error: function (error) {
            console.log("Error");
            errors.text("Something go wrong!/n" + error);
        }
    });
};

function validateAndGetParams() {
    var method = $("select[name='request-method']").val();
    var url = $("#url").val();
    var parameters = $("#parameters").val();
    var requestBody = $("#request").val();

    if(method == "GET" && !url) {
        errors.text("Url is missing. Please provide correct url!");
        errors.show();
    }


    if(method == "POST" && !url && !parameters) {
        errors.text("Url or parameters are missing. Please provide correct url and parameters!");
        errors.show();
    }

    return {
        url: url,
        method: method,
        parameters: parameters,
        requestBody: requestBody
    };
};

function send() {
    var parameters = validateAndGetParams();
    request(parameters);
};