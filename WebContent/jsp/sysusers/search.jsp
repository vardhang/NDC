<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="language" content="en" />
<title>National Drug Code</title>

<link rel="stylesheet" href="<c:url value="/css-common/style.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/dataTable.css"/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/css-common/jquery.dataTables.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/whitebox.css"/>"
	type="text/css" />
	<link rel="stylesheet" href="<c:url value="/css-common/cmxform.css"/>"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script src="<c:url value="/js-common/search.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.popupWindow.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.min.js" />"
	type="text/javascript"></script>
	<script src="<c:url value="/js-common/jquery.leanModal.min.js" />"
	type="text/javascript"></script>
	

<style>
body {
	background: #e1c192 url(/images/common/wood_pattern.jpg);
}

/* td {
	text-transform: capitalize;
	font-weight: 400;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.8);
	font-size: 15px;
	font-weight: bold;
	color: #7e7975;
}
 */
 
</style>
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="body-content">
				<form id="searchForm" class="form-2" action="#">
					<h1>
						<span class="log-in">Search</span>
					</h1>
					<br>
					<div class="errorClass" id="dynerr"></div>
					<br>
					<table >
						<p class="float">
						<tr>
							<td><label for="productCode">National drug code</label></td>
							<td><input type="text" name="productCode" id="productCode" ></td>
						</tr>
						</p>
						<p class="float">
						<tr>
							<td><label for="productName">Product name</label></td>
							<td><input type="text" name="productName" id="productName" ></td>
						</tr>
						</p>
					</table>
					<br>
					<p class="clearfix">
						<input type="submit" name="btnSubmit" value="Search"
							id="btnSubmit"> <input type="submit" name="btnCancel"
							value="Cancel" id="btnCancel">
					</p>
					</br>
					<div id="allproducts" >
					<a  href="allproducts?productId=" class="popup" style="color:#8A4B08;margin: 150px">Show all products</a> 
					</div>
					</br>
					<table border="0" cellpadding="0" class="popUpTable"
						width="90%" id='searchProducts'></table>

					
					<div id="compare" style="display:none">
					&nbsp;&nbsp;&nbsp;<a  href="allproducts?productId=100" class="popup" style="color:#8A4B08">Show comparison between suppliers</a> 
					</div>
					 </br></br>
					<!-- <a id="showAllProducts" href="#">All Products</a> -->
					<a href="products">Products</a> 
					<a href="suppliers">Suppliers</a> 
					<a href="rates">Product	Rates</a>
					<!-- <a href="allproducts">All Products</a> -->

				</form>
				
			</div>
			<!-- End Body-Content -->

		</div>
		<!-- End Content -->
	</div>
	<!-- End Container -->
</body>
</html>