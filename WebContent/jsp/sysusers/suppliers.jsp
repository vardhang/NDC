<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="language" content="en" />
<title>Suppliers</title>
<link rel="stylesheet" href="<c:url value="/css-common/cmxform.css"/>"	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/style.css"/>"	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/jquery.dataTables.css"/>"	type="text/css" />
<link rel="stylesheet" href="<c:url value="/css-common/whitebox.css"/>"	type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script src="<c:url value="/js-common/supplier.js" />" type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.js" />" type="text/javascript"></script>
<script src="<c:url value="/js-common/jquery.dataTables.min.js" />" type="text/javascript"></script>

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
<form class="form-2"  action="#" id="supplierForm">
			<h1>
				<span class="log-in">Supplier</span>
			</h1>
			<br>
			<div class="errorClass" id="dynerr"></div>
			<table>
			<p class="float">
				<tr> <td><label for="supplierName">Supplier name<label><span class="asterisk_input">  </span></td>
				<td> <input type="text" name="supplierName" id="supplierName" required >
				</td></tr>
			</p>
			<p class="float">
			<tr><td><label for="contact">Contact #</label><span class="asterisk_input">  </span> </td>
			<td><input type="text" name="contact"  id="contact" required>
			</td></tr>
			</p>
			<p class="float">
			<tr><td><label for="contactPerson">Contact person</label><span class="asterisk_input">  </span> </td>
			<td><input type="text" name="contactPerson"  id="contactPerson" required>
			</td></tr>
			</p>
			<p class="float">
			<tr><td><label for="supplierDetails">Details</label> </td>
			<td><textarea id="supplierDetails" rows="4" cols="21"></textarea></td></tr>
			</p>
			</table>
			<br>
			<p class="clearfix">
				<input type="submit" name="btnSubmit" value="Add" id="btnSubmit">
				<input type="submit" name="btnCancel" value="Cancel" id="btnCancel">
			</p>
			</br></br>
			<a href="index">Home</a>
			<a href="products">Products</a>
			<a href="rates">Product Rates</a>
			</form>
			
			<!--  <table id="searchAllProducts"></table>
			 <div id="searchProducts"></div>   -->
			         
            
</div><!-- End Body-Content -->

</div><!-- End Content -->
</div><!-- End Container -->
</body></html>