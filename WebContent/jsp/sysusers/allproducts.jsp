<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="language" content="en" />
<title>Products</title>

<link rel="stylesheet" href="<c:url value="/css-common/style.css"/>"	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/jquery.dataTables.css"/>"	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/dataTable.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/whitebox.css"/>"	type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<script src="<c:url value="/js-common/allproducts.js" />" type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.js" />" type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.min.js" />" type="text/javascript"></script>

<style>
body {
	background: #e1c192 url(/images/common/wood_pattern.jpg);
}

</style>
</head>
<body>
<div id="container">
<div id="content">
<div id="body-content">
			<h1>
				<span class="log-in">Products</span>
			</h1>
			<br>
			 <table class="popUpTable" id="allProducts"></table>
			       
</div><!-- End Body-Content -->

</div><!-- End Content -->
</div><!-- End Container -->
</body></html>