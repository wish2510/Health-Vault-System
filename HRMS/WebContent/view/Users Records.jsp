<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
		<script type="text/javascript">
			$(document).ready(function () {
				style_path = "resources/css/colors";

				$("#date-picker").datepicker();

				$("#box-tabs, #box-left-tabs").tabs();
			});
		</script>
		
		<link rel="stylesheet" href="./Date_picker css/jquery-ui.css" />
		<script src="./Date_picker js/jquery-1.9.1.js"></script>
		<script src="./Date_picker js/jquery-ui.js"></script>
		<link rel="stylesheet" href="./Date_picker css/style.css" />
		
	</head>
	<body>
		<div id="colors-switcher" class="color">
			<a href="" class="blue" title="Blue"></a>
			<a href="" class="green" title="Green"></a>
			<a href="" class="brown" title="Brown"></a>
			<a href="" class="purple" title="Purple"></a>
			<a href="" class="red" title="Red"></a>
			<a href="" class="greyblue" title="GreyBlue"></a>
		</div>
		<!-- dialogs -->
		
		<!-- end dialogs -->
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
					<a href="Admin Homepage.jsp" title="Home"></a>
				</div>
				<!-- quick -->
				<ul id="quick">
					<li>
						<a href="<%=request.getContextPath() %>/Userrecordcontroller" title="Submit Records"><span class="normal">Submit Records</span></a>
						
					</li>
					<li>
						<a href="Admin Homepage.jsp" title="View Records"><span class="icon"><img src="./images/application_double.png" alt="Products" /></span><span>View Records</span></a>
						
					</li>
					<li>
						<a href="" title="Users"><span class="icon"><img src="./images/calendar1.png" alt="Events" /></span><span>Users</span></a>
						<ul>
							<li><a href="view users.jsp">View Users</a></li>
							<li class="last"><a href="add users.jsp">Add Users</a></li>
						</ul>
					</li>
					<li>
						<a href="Activity list.jsp" title="Activity List"><span class="icon"><img src="./images/page_white_copy.png" alt="Pages" /></span><span>Activity List</span></a>
						
					</li>
					<li>
						<a href="" title="Doctors and Nurses"><span class="icon"><img src="./images/calendar1.png" alt="Pages" /></span><span>Doctors and Nurses</span></a>
						
					</li>
					<li>
						<a href="" title="Change Password"><span class="icon"><img src="./images/cog.png" alt="Links" /></span><span>Change Password</span></a>
						
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
						<li><a href="<%=request.getContextPath() %>/Userrecordcontroller">Submit Records</a></li>
						<li class="selected"><a href="Admin Homepage.jsp">View Records</a></li>
						<li class="collapsible">
							<a href="#" class="collapsible plus">Users</a>
							<ul id="whatever" class="collapsed">
								<li><a href="view users.jsp">View user</a></li>
								<li><a href="add users.jsp">Add User</a></li>
								
							</ul>
						</li>
						
					</ul>
					<h6 id="h-menu-pages"><a href="Activity list.jsp"><span>Activity List</span></a></h6>
					
					<h6 id="h-menu-pages"><a href=""><span>Doctors and Nurses</span></a></h6>
					
					<h6 id="h-menu-events"><a href="#events"><span>Change Password</span></a></h6>
					
					<h6 id="h-menu-links"><a href="#links"><span>Logout</span></a></h6>
					
					
				</div>
				
			</div>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						
						<div class="search" style="float: left">
							
								<div class="button">
									<a href="Admin Homepage.jsp"><input class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false" type="submit" name="submitback" value="<< Back" /></a>
								</div>
						</div>
						
				
					</div>
					<!-- end box / title -->
					<div class="table">
						<form action="<%=request.getContextPath() %>/Userrecordcontroller" method="post">
						<input type="hidden" value="delete" name="flag">
							Name:  ${sessionScope.lis1[0][0].fstname} <br/><br/>
							Email: ${sessionScope.lis1[0][1].emailprimary}  <br/>
						<table style="margin-top: 12px">
							<thead>
								<tr>
									<th class="selected last"><input type="checkbox" class="checkall" /></th>
									<th class="left">Date</th>
									<th>Record Title</th>
									<th>Category Of Record</th>
									<th>Type Of Record</th>
									<th>Created By</th>
									<th>Action</th>		
								</tr>
							</thead>
							<tbody>
						
				<c:set value="0" var="i"></c:set>
				<c:set value="0" var="j"></c:set>
				
							 	<c:forEach items="${sessionScope.lis}" var="x">
						<c:set  value="5" var="i"></c:set>
								<tr>
									<td class="selected last"><input type="checkbox" class="checkall" name="chk2" value="${x[2].userRecordid}" /></td>
									<td class="left"><a href="personal_Records.jsp?d=${j}">${x[2].dateofRcd}</a> </td>
									<td><a href="personal_Records.jsp?d=${j}">${x[2].title}</a> </td>
									<td></td>
									<td></td>								
									<td>${x[3].clinicname} </td>
									<td><a href="">edit</a><a href="<%=request.getContextPath() %>/Notescontroller?idn=${x[2].userRecordid}&flag=search"> Notes</a><a href=""> Print</a><a href=""> Share</a><a href=""> Mail</a></td>
								</tr>
								
						<c:set value="${j+1}" var="j" ></c:set>
								</c:forEach>
								<c:if test="${i==0}">
								<tr><td colspan="6" align="center">No records Present</td></tr>	
								</c:if>
						
							</tbody>
						</table>
						<!-- pagination -->
						<div class="pagination pagination-left">
							<div class="results">
								<span>showing results 1-10 of 207</span>
							</div>
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
								<option value="" class="locked">Set status to Deleted</option>
								
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