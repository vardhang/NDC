<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="language" content="en" />
<title>National Drug Code</title>

<link rel="stylesheet" href="<c:url value="/css-common/style.css"/>"	type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="<c:url value="/js-common/login.js" />" type="text/javascript"></script>


<style>
body {
	background: #e1c192 url(/images/common/wood_pattern.jpg);
}
</style>
</head>
<body>
	<div class="container">

		<header>
		<h1>
			<strong>National Drug Control</strong>
		</h1>

		<div class="support-note">
			<span class="note-ie">Sorry, only modern browsers.</span>
		</div>

		</header>

		<form class="form-2"  action="#">
			<h1>
				<span class="log-in">Log in</span> or <span class="sign-up">sign
					up</span>
			</h1>
			<p class="float">
				<label for="login"><i class="icon-user"></i>Username</label> <input
					type="text" name="login" id="login" placeholder="Username or email">
			</p>
			<p class="float">
				<label for="password"><i class="icon-lock"></i>Password</label> <input
					type="password" name="password" placeholder="Password" id="password"
					class="showpassword">
			</p>
			<p class="clearfix">
				<input type="submit" name="btnSubmit" value="Log in" id="btnSubmit">
			</p>
		</form>

	</div>

</body>
</html>