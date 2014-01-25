<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>boadicafarmacia</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/application.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<ul>
			<c:forEach items="${contentFakes}" var="contentfake">
				<li>
					<h3> <a href="#"> ${contentfake.name}</a></h3>

					<p>${contentfake.description}</p>
				</li>
			</c:forEach>
		</ul>

	</div>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>