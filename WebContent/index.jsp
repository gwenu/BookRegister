<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Starter</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js" type="text/javascript"></script>
    <script src="public/index.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="public/index.css">
</head>

<body>
    <div id="params">
        <div>
            <label>Request Method</label>
            <select id="request-method" name="request-method"">
            <option value="GET">GET</option>
            <option value="POST">POST</option>
            <%--<option value="PUT">PUT</option>--%>
            <%--<option value="DELETE">DELETE</option>--%>
            </select>
        </div>
        <div>
            <label>Request URL</label>
            <input id="url" type="text" value="" name="url"/>
            <label>Parameters</label> <input id="parameters" type="text" value="" name="parameters"/>
        </div>
    </div>

    <div>
        <input type="button" name="run" value="Run" onclick="send()"/>
    </div>

    <div id="errors"></div>

    <div id="requestXml">
        <textarea name="request" id="request"></textarea>
    </div>
    <div id="responseXml">
        <textarea name="response" id="response"></textarea>
    </div>
</body>
</html>
