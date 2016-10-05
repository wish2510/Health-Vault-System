
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Health Record Management System</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="css/blue.css" />
		<!-- scripts (jquery) -->
		<script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>
		<script src="js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
		<script src="js/smooth.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				style_path = "css/colors";

				$("input.focus").focus(function () {
					if (this.value == this.defaultValue) {
						this.value = "";
					}
					else {
						this.select();
					}
				});

				$("input.focus").blur(function () {
					if ($.trim(this.value) == "") {
						this.value = (this.defaultValue ? this.defaultValue : "");
					}
				});

				$("input:submit, input:reset").button();
			});
			
		</script>
	</head>
	<body>

		<div id="login">
			<!-- login -->
			<div class="title">
				<h5>Sign In to HRMS</h5>
				<div class="corner tl"></div>
				<div class="corner tr"></div>
			</div>
<!--  		<div class="messages">
				<div id="message-error" class="message message-error">
					<div class="image">
						<img src="images/error.png" alt="Error" height="32" />
					</div>
					<div class="text">
						<h6>Error Message</h6>
						<span>This is the error message.</span>
					</div>
					<div class="dismiss">
						<a href="#message-error"></a>
					</div>
				</div>
				
			</div>
	-->		
			<div class="inner">
				<form action="<%=request.getContextPath() %>/Logincontroller" method="get">
				<input type = "hidden" value="Loginsearch" name="flag">
				<div class="form">
					<!-- fields -->
					<div class="fields">
						<div class="field">
							<div class="label">
								
								<label for="username">Username:</label>
							</div>
							<div class="input">
								<input type="text" id="username" name="username" size="40" value="" class="focus" />
							</div>
						</div>
						<div class="field">
							<div class="label">
								<label for="password">Password:</label>
							</div>
							<div class="input">
								<input type="password" id="password" name="password" size="40" value="" class="focus" />
							</div>
						</div>
						<div class="field">
							<div class="checkbox">
								<input type="checkbox" id="remember" name="remember" />
								<label for="remember">Remember me</label>
							</div>
						</div>
						<span style="color: red;" id="Divisible" name="Divisible">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
			<% 
			if(session.getAttribute("invalid")!=null)
			{
				out.print(session.getAttribute("invalid"));
				session.removeAttribute("invalid");
		}
			if(session.getAttribute("success")!=null)
			{
				out.print(session.getAttribute("success"));
				session.removeAttribute("success");
			}
		%>
			<br></br>
						</span>
						<div class="buttons">
							<input type="submit" value="Sign In" />
						</div>
					</div>
					<!-- end fields -->
					<!-- links -->
					<div class="links">
						<a href="Forgotusername.jsp">Forgot your Username?</a>
					</div>
					<div class="links">
						<a href="ForgotPassword.jsp">Forgot your password?</a>
					</div>
					<!-- end links -->
				</div>
				</form>
			</div>
			<!-- end login -->
			
		</div>
	</body>
</html>