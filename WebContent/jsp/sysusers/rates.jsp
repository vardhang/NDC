<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="language" content="en" />
<title>Rates</title>

<link rel="stylesheet" href="<c:url value="/css-common/cmxform.css"/>"	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/style.css"/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/css-common/jquery.dataTables.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/dataTable.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/whitebox.css"/>"
	type="text/css" />
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<script src="<c:url value="/js-common/rate.js" />"
	type="text/javascript"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script src="<c:url value="/js-common/jquery.dataTables.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.min.js" />"
	type="text/javascript"></script>
<%-- <script src="<c:url value="/js-common/jquery.leanModal.min.js" />"
	type="text/javascript"></script>
 --%>
<style>
body {
	background: #e1c192 url(/images/common/wood_pattern.jpg);
}
.asterisk_input:after {
content:" *"; 
color: #e32;
margin: 0px 0px 0px 0px; 
font-size: xx-large; 
padding: 0px 5px 0 0; }

</style>
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="body-content">
				<form class="form-2" action="#" id="ratesForm">
					<h1>
						<span class="log-in">Rates</span>
					</h1>
					<br>
					<div class="errorClass" id="dynerr"></div>
					<table>
						<p class="float">
						<tr>
							<td><label for="productName">Product name<label></td>
							<td><input type="text" name="productName" id="productName" required><span class="asterisk_input">  </span>
							</td>
						</tr>
						</p>
						<p class="float">
						<tr>
							<td><label for="supplierName">Suppliers</label><span class="asterisk_input">  </span></td>
							<td>
							<input type="text" name="supplierName" id="supplierName" required>
							</td>
						</tr>
						</p>
						<p class="float">
						<tr>
							<td><label for="rate">Rate</label><span class="asterisk_input">  </span></td>
							<td><input type="text" name="rate" id="rate" required></td>
						</tr>
						</p>
					</table>
					<br>
					<p class="clearfix">
						<input type="submit" name="btnSubmit" value="Add"
							id="btnSubmit"> <input type="submit" name="btnCancel"
							value="Cancel" id="btnCancel">
					</p>
					
					</br> </br> </br> 
					<a href="index">Home</a>
					<a href="products">Products</a> 
					<a href="suppliers">Suppliers</a>

				</form>


			<!-- 	<div id="signup">
					<div id="signup-ct">
						<div id="signup-header">
							<h2>Product Lookup</h2>
							<a class="modal_close" href="#"></a>
						</div>



						<div class="txt-fld">
							<label for="">Name</label> <input id="lookupProductName"
								class="good_input" name="lookupProductName" type="text" />
						</div>

						<div class="btn-fld">
							<button type="submit" name="btnLookup" id="btnLookup">Look
								Up &raquo;</button>

						</div>

					</div>
					<br>
					<table class="dataGrid display" id="searchAllProducts"></table>
				</div>
 -->
			</div>
			<!-- End Body-Content -->

		</div>
		<!-- End Content -->
	</div>
	<!-- End Container -->
</body>
</html>