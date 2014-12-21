<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Starter</title>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js" type="text/javascript"></script>
	<script src="public/index.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="public/index.css">
	<link rel="stylesheet" type="text/css" href="public/bootstrap.min.css">
</head>

<body>
	<div id="content">
		<div class="form-horizontal">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Request
					Method</label>
				<div class="col-sm-10">
					<select id="request-method" name="request-method"
						class="form-control">
						<option value="GET">GET</option>
						<option value="POST">POST</option>
						<%--<option value="PUT">PUT</option>--%>
						<%--<option value="DELETE">DELETE</option>--%>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Request
					URL</label>
				<div class="col-sm-10">
					<input type="text" id="url" class="form-control" value=""
						name="url" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Parameters</label>
				<div class="col-sm-10">
					<input type="text" id="parameters" class="form-control" value=""
						name="parameters" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" onclick="send()">Run</button>
				</div>
			</div>

			<div id="errors"></div>

			<div id="requestXml" class="form-group">
				<label for="request">Request Body</label>
				<textarea name="request" id="request" class="form-control"></textarea>
			</div>
			<div id="responseXml" class="form-group">
				<label for="response">Response</label>
				<textarea name="response" id="response" class="form-control"></textarea>
			</div>
		</div>
	</div>
</body>
</html>
