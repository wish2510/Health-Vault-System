<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Health Record Management System</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="./css/reset.css" />
		<link rel="stylesheet" type="text/css" href="./css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="./css/blue.css" />
		<!-- scripts (jquery) -->
		<script src="./js/jquery-1.6.4.min.js" type="text/javascript"></script>
		<!--[if IE]><script language="javascript" type="text/javascript" src="./js/excanvas.min.js"></script><![endif]-->
		<script src="./js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
		<script src="./js/jquery.ui.selectmenu.js" type="text/javascript"></script>
		<script src="./js/jquery.flot.min.js" type="text/javascript"></script>
		<script src="./js/tiny_mce.js" type="text/javascript"></script>
		<script src="./js/jquery.tinymce.js" type="text/javascript"></script>
		<!-- scripts (custom) -->
		<script src="./js/smooth.js" type="text/javascript"></script>
		<script src="./js/smooth.menu.js" type="text/javascript"></script>
		<script src="./js/smooth.chart.js" type="text/javascript"></script>
		<script src="./js/smooth.table.js" type="text/javascript"></script>
		<script src="./js/smooth.form.js" type="text/javascript"></script>
		<script src="./js/smooth.dialog.js" type="text/javascript"></script>
		<script src="./js/smooth.autocomplete.js" type="text/javascript"></script>
		
		<link rel="stylesheet" href="./Date_picker css/jquery-ui.css" />
		<script src="./Date_picker js/jquery-1.9.1.js"></script>
		<script src="./Date_picker js/jquery-ui.js"></script>
		<link rel="stylesheet" href="./Date_picker css/style.css" />
		<script>
		$(function() {
			$( "#datepicker" ).datepicker();
		});
		</script>		
		
		
	</head>
	<body>
		
		<!-- header -->
		<div id="header">
			<!-- logo -->
			<div id="logo">
				<h1>Health Record Management System</h1>
			</div>
			<!-- end logo -->
			<!-- user -->
			<ul id="user">
				<li class="first"><a href="">Account</a></li>
				
				<li><a href="">Logout</a></li>
				<li class="highlight last"><a href="">View Site</a></li>
			</ul>
			<!-- end user -->
			<div id="header-inner">
				<div id="home">
					<a href="User_Homepage.jsp" title="Home"></a>
				</div>
				<!-- quick -->
				<ul id="quick">
					<li>
						<a href="<%=request.getContextPath() %>/Userrecordcontroller?flag=cr" title="Create Records"><span class="normal">Create Records</span></a>
						
					</li>
					<li>
						<a href="" title="Medical Profile"><span class="icon"><img src="./images/application_double.png" alt="" /></span><span>Medical Profile</span></a>
						
					</li>
					<li>
						<a href="<%=request.getContextPath() %>/ShareRecordcontroller?flag=trusteesearch&idser=${sessionScope.lis1[0][0].userid}" title="Trustee"><span class="icon"><img src="./images/calendar1.png" alt="" /></span><span>Trustee</span></a>
						
					</li>
					<li>
						<a href="" title="Trusted Contact"><span class="icon"><img src="./images/page_white_copy.png" alt="" /></span><span>Trusted Contacts</span></a>
						
					</li>
					
					<li>
						<a href="" title="Doctors and Nurses"><span class="icon"><img src="./images/calendar1.png" alt="" /></span><span>Doctors and Nurses</span></a>
						
					</li>
					<li>
						<a href="<%=request.getContextPath() %>/UserLogincontroller?flag=changepasswordfromuser&id3=${sessionScope.lis1[0][0].userid}" title="Change Password"><span class="icon"><img src="./images/cog.png" alt="" /></span><span>Change Password</span></a>
						
					</li>
					<li>
						<a href="" title="Logout"><span class="icon"><img src="./images/cog.png" alt="Settings" /></span><span>Logout</span></a>
						
					</li>
				</ul>
				<!-- end quick -->
				<div class="corner tl"></div>
				<div class="corner tr"></div>
			</div>
		</div>
		<!-- end header -->
		<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<div id="left">
				<div id="menu">
					<h6 id="h-menu-products" class="selected"><a href="#products"><span>Options</span></a></h6>
					<ul id="menu-products" class="opened">
						<li><a href="<%=request.getContextPath() %>/Userrecordcontroller?flag=cr">Create Records</a></li>
						<li class="selected"><a href="">Medical Profile</a></li>
						
					</ul>
					<h6 id="h-menu-pages"><a href="<%=request.getContextPath() %>/ShareRecordcontroller?flag=trusteesearch&idser=${sessionScope.lis1[0][0].userid}"><span>Trustee</span></a></h6>
					
					<h6 id="h-menu-pages"><a href=""><span>Trusted Contacts</span></a></h6>
					
					<h6 id="h-menu-pages"><a href=""><span>Doctors and Nurses</span></a></h6>
					
					<h6 id="h-menu-events"><a href="<%=request.getContextPath() %>/UserLogincontroller?flag=changepasswordfromuser&id3=${sessionScope.lis1[0][0].userid}"><span>Change Password</span></a></h6>
					
					<h6 id="h-menu-links"><a href="#links"><span>Logout</span></a></h6>
					
					
				</div>
				<div id="date-picker"></div>
			</div>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						
						<h5>Trusted Contacts</h5>
						
					</div>
					<!-- end box / title -->
					<div class="table">
						<form action="<%=request.getContextPath() %>/ShareRecordcontroller" method="post">
						<input type="hidden" value="deletesharedcontact" name="flag"/>
						<table style="margin-top: 12px">
							<thead>
								<tr>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
									<th class="left">Name</th>
									<th>Email</th>
									<th>Country</th>
									<th>State</th>
									<th>Phone Mo.</th>					
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${sessionScope.lssearch}" var="row">
								<tr>
									<td class="selected last"><input type="checkbox" class="checkall" value="${row[0].sharerecordid}" name="chk" /></td>
									<td class="left">${row[1].fstname}</td>
									<td>${row[2].emailprimary}</td>
									<td>${row[3].name}</td>
									<td>${row[4].name}</td>	
									<td>${row[2].phonemobile}</td>					
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<!-- pagination -->
						<div class="pagination pagination-left">
							<ul class="pager">
								<li class="disabled">&laquo; prev</li>
								<li class="current">1</li>
								<li><a href="">next &raquo;</a></li>
							</ul>
						</div>
						<!-- end pagination -->
						<!-- table action -->
						<div class="action">
							<select name="action">
								<option value="" class="locked">Set status to Removed</option>
								
							</select>
							<div class="button">
								<input class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false" type="submit" name="submit" value="Apply to Selected" />
							</div>
						</div>
						<!-- end table action -->
						</form>
					</div>
				</div>
				<!-- end table -->
				
				<!-- end box / right -->
			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<div id="footer">
			<p>Prepared by Vishal Patel & Divyesh Patel.</p>
		</div>
		<!-- end footert -->
		
		
		
	</body>
</html>