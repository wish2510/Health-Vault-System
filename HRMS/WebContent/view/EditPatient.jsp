<%@page import="java.util.List"%>
<%@page import="vo.vo_country"%>
<%@page import="dao.dao_country"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<%
dao_country dc = new dao_country();
vo_country vc = new vo_country();
List cntrylist = dc.select();

%>
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
		<!-- <script src="./js/smooth.js" type="text/javascript"></script> -->
		<!-- <script src="./js/smooth.menu.js" type="text/javascript"></script>
		<script src="./js/smooth.chart.js" type="text/javascript"></script>
		<script src="./js/smooth.table.js" type="text/javascript"></script>
		<script src="./js/smooth.form.js" type="text/javascript"></script>
		<script src="./js/smooth.dialog.js" type="text/javascript"></script>
		<script src="./js/smooth.autocomplete.js" type="text/javascript"></script>
		 --><link rel="stylesheet" href="./Date_picker css/jquery-ui.css" />
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
		<div id="colors-switcher" class="color">
			<a href="" class="blue" title="Blue"></a>
			<a href="" class="green" title="Green"></a>
			<a href="" class="brown" title="Brown"></a>
			<a href="" class="purple" title="Purple"></a>
			<a href="" class="red" title="Red"></a>
			<a href="" class="greyblue" title="GreyBlue"></a>
		</div>
		<!-- dialogs -->
		
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
						<a href="" title="Change Password"><span class="icon"><img src="./images/world_link.png" alt="Links" /></span><span>Change Password</span></a>
						
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
				<div id="date-picker"></div>
			</div>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
			
				<!-- forms -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>Add Patient</h5>
					</div>
					<!-- end box / title -->
					<form id="form" action="<%=request.getContextPath() %>/UserProfilecontroller" method="post">
					<input type="hidden" value="${sessionScope.hdnflag }" name="flag">
					<input type="hidden" value="${sessionScope.lsreg.userid}" name="id">
					<div class="form">
						<div class="fields">
							
							<div class="field">
								<div class="label">
									<label for="input-medium">Name:</label>
								</div>
								<div class="input input-file">
									<input type="text" id="autocomplete" name="input.autocompletefirstname" value="${sessionScope.lsreg.fstname}" class="small focus autocomplete" placeholder="First Name" required/>
									<input type="text" id="autocomplete" name="input.autocompletemiddlename" value="${sessionScope.lsreg.mdlname}" class="small focus autocomplete" placeholder="Middle Name" required/>
									<input type="text" id="autocomplete" name="input.autocompletelastname" value="${sessionScope.lsreg.lstname}" class="small focus autocomplete" placeholder="Last Name" required/>
									
								</div>
							</div>
							
							<div class="field">
								<div class="label">
									<label for="input-medium">Email:</label>
								</div>
								<div class="input input-file">
									<input type="text" id="autocomplete" name="input.autocompleteprimary" value="${sessionScope.lsreg22.emailprimary}" class="small focus autocomplete" placeholder="Primary" required/>
									<input type="text" id="autocomplete" name="input.autocompletesecondary" value="${sessionScope.lsreg22.emailsecondary}" class="small focus autocomplete" placeholder="Secondary"/>
									
									
								</div>
							</div>
							
							<div class="field">
								<div class="label">
									<label for="input-medium">Phone:</label>
								</div>
								<div class="input input-file">
									<input type="text" id="autocomplete" name="input.autocompletework" value="${sessionScope.lsreg22.phonework}" class="small focus autocomplete" placeholder="Work"/>
									<input type="text" id="autocomplete" name="input.autocompletehome" value="${sessionScope.lsreg22.phonehome}" class="small focus autocomplete" placeholder="Home"/>
									<input type="text" id="autocomplete" name="input.autocompletemobile" value="${sessionScope.lsreg22.phonemobile}" class="small focus autocomplete" placeholder="Mobile"/>
									
								</div>
							</div>
							
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">Address:</label>
								</div>
								<div class="textarea textarea-editor">
									<textarea id="textarea" value=""name="textareaaddress" cols="50" rows="6" class="editor">${sessionScope.lsreg22.address}</textarea>
								</div>
							</div>

								<div class="field">
									<div class="label">
										<label for="select">Country:</label>
									</div>
									<div class="select">
										<select name="cb_cntry" id="cntry" tabindex="1" align="center"
											class="span6" required>
											<option value="">--select--</option>
											<c:forEach items="<%=cntrylist%>" var="row">
												<option value="${row.cntryid}" id="${row.cntryid}">${row.name}</option>
											</c:forEach>
										</select>
										
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">State:</label>
									</div>
									<div class="select">
										<select id="ste" name="cb_state" tabindex="1" align="center"
											data-placeholder="Select State" class="span6" required>
											<option value="">--select--</option>

										</select>
										
									</div>
								</div>

								<div class="field">
								<div class="label">
									<label for="date">City:</label>
								</div>
								<div class="select">
								<select id="cit" name="cb_cit" tabindex="1" align="center" data-placeholder="Select State" class="span6" required>
                         		 <option value="">--Select--</option>
                           
                        		</select>
								
								</div>
								
							</div>
							
							<div class="field">
								<div class="label">
									<label for="date">Zip/Postal:</label>
								</div>
								<div class="input">
									<input type="text" id="autocomplete" name="input.autocompletezip" value="${sessionScope.lsreg22.zipcode}" class="small focus autocomplete" />
								</div>
								
							</div>
							
							
							<div class="field">
								<div class="label">
									<label for="autocomplete">Birthdate:</label>
								</div>
								<div class="input">
									<input type="text" id="datepicker" name="birthdatee" value="${sessionScope.lsreg22.birthdate}"/>
									
								</div>							
							</div>
							
							<div class="field">
								<div class="label">
									<label for="date">Sex:</label>
								</div>
								<div class="select">
									<select id="select" name="selectsex">
										<option value="--Select--">--Select--</option>
										<option value="">Male</option>
										<option value="">Female</option>
										
									</select>
								</div>
								
							</div>
							
							<div class="field">
								<div class="label">
									<label for="date">Blood Group:</label>
								</div>
								<div class="select">
									<select id="select" name="selectbloodgroup">
										<option value="--Select--">--Select--</option>
										<option value="A+">A+</option>
										<option value="A-">A-</option>
										<option value="B+">B+</option>
										<option value="B-">B-</option>
										<option value="o+">o+</option>
										<option value="o-">o-</option>
										<option value="AB+">AB+</option>
										<option value="AB-">AB-</option>
									</select>
								</div>
								
							</div>
							
							<div class="field">
								<div class="label">
									<label for="date">Height:</label>
								</div>
								
								<div class="input">
									<input type="text" id="autocomplete" name="input.autocompleteheight" value="${sessionScope.lsreg22.height}" class="small focus autocomplete" />
								</div>
								<div class="select" style="margin:0px 0px 0px 6px">
									<select id="select" name="select" >
										
										<option value="inches" >inches</option>
										
									</select>
								</div>
								
							</div>
							
							<div class="field">
								<div class="label">
									<label for="date">Weight:</label>
								</div>
								
								<div class="input">
									<input type="text" id="autocomplete" name="input.autocompleteweight" value="${sessionScope.lsreg22.weight}" class="small focus autocomplete" />
								</div>
								<div class="select" style="margin:0px 0px 0px 6px">
									<select id="select" name="select" >
										<option value="kgs" >kgs</option>
										
									</select>
								</div>
								
							</div>
							
							<div class="buttons">
								<input class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false" type="submit" name="submit" value="Submit" />
								<input class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false" type="reset" name="reset" value="Reset" />
								<input class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false" type="reset" name="cancel" value="Cancel" />
							</div>
						</div>
					</div>
					</form>
				</div>
				<!-- end forms -->
				
			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<div id="footer">
			<p>Prepared by Vishal Patel & Divyesh Patel.</p>
		</div>
		<!-- end footert -->
		
<script type="text/javascript">

document.getElementById("${sessionScope.lsreg22.country}").selected = "selected";

abcd();
function abcd()
{
		var x=	$("#cntry").val();
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
{
if (xmlhttp.readyState==4 && xmlhttp.status==200)
  {
	
	var name=xmlhttp.responseXML.documentElement.getElementsByTagName("name");
	var val=xmlhttp.responseXML.documentElement.getElementsByTagName("val");
	
	for(var i=0;i<name.length;i++)
		{
		var abc = "${sessionScope.lsreg22.state}";
		var x = val[i].firstChild.nodeValue.trim();
		
	if(val[i].firstChild.nodeValue.trim() == "${sessionScope.lsreg22.state}")
			{
	$("#ste").append( $("<option  selected='selected' id=" +val[i].firstChild.nodeValue.trim() + ">")
		    .val(val[i].firstChild.nodeValue.trim())
		    .html(name[i].firstChild.nodeValue.trim())
		  
		);
	
    }
	else
	{
	$("#ste").append( $("<option  id=" +val[i].firstChild.nodeValue.trim() + ">")
		    .val(val[i].firstChild.nodeValue.trim())
		    .html(name[i].firstChild.nodeValue.trim())		  
		);
	
	}
	
	}
  }
};

xmlhttp.open("post","<%=request.getContextPath() %>/cbcnt?X="+x,true);
xmlhttp.send();
}

$("#cntry").change(abcd);

function abcde(s){
	
	
	$("#ste").empty();

	$("#ste").append( $("<option>")
		    .val("")
		    .html("")
		);

	$("#cit").empty();
		
			
	var x=	$("#cntry").val();
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
{

if (xmlhttp.readyState==4 && xmlhttp.status==200)
  {
	
	var name=xmlhttp.responseXML.documentElement.getElementsByTagName("name");
	var val=xmlhttp.responseXML.documentElement.getElementsByTagName("val");
	
	for(var i=0;i<name.length;i++)
		{
		var abc = s;
		var x = val[i].firstChild.nodeValue.trim();
		

	if(val[i].firstChild.nodeValue.trim() == s)
			{
	

 	
	$("#ste").append( $("<option  selected='selected' id=" +val[i].firstChild.nodeValue.trim() + ">")
		    .val(val[i].firstChild.nodeValue.trim())
		    .html(name[i].firstChild.nodeValue.trim())
		  
		);
	document.getElementById(val[i].firstChild.nodeValue.trim()).selected = "selected";

	
 	abcity("${sessionScope.lsreg22.city}");
	
    }
	else
	{
	$("#ste").append( $("<option  id=" +val[i].firstChild.nodeValue.trim() + ">")
		    .val(val[i].firstChild.nodeValue.trim())
		    .html(name[i].firstChild.nodeValue.trim())
		  
		);
	
	}
	
	}
  }
};

xmlhttp.open("post","../cbcnt?X="+x,true);
xmlhttp.send();

	}

function abcity(s){

	$("#cit").empty();
	$("#cit").append( $("<option>")
		    .val("")
		    .html("")
		    
		);
	var x=	$("#ste").val();

var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
{

if (xmlhttp.readyState==4 && xmlhttp.status==200)
  {
	
	
	var name=xmlhttp.responseXML.documentElement.getElementsByTagName("name");
	var val=xmlhttp.responseXML.documentElement.getElementsByTagName("val");
	
	for(var i=0;i<name.length;i++)
		{

		if(val[i].firstChild.nodeValue.trim() == s)
		{
			 
	$("#cit").append( $("<option selected='selected'>")
		    .val(val[i].firstChild.nodeValue.trim())
		    .html(name[i].firstChild.nodeValue.trim()));
		}
		else
			{

			$("#cit").append( $("<option>")
				    .val(val[i].firstChild.nodeValue.trim())
				    .html(name[i].firstChild.nodeValue.trim()));		
			}
	}
  }
};

xmlhttp.open("get","../cbcnt?X="+x,true);
xmlhttp.send();

	}
$("#ste").change(function(){

var x=	$("#ste").val();
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
{

if (xmlhttp.readyState==4 && xmlhttp.status==200)
{
var name=xmlhttp.responseXML.documentElement.getElementsByTagName("name");
var val=xmlhttp.responseXML.documentElement.getElementsByTagName("val");

for(var i=0;i<name.length;i++)
{

$("#cit").append( $("<option>")
    .val(val[i].firstChild.nodeValue)
    .html(name[i].firstChild.nodeValue) 
);
}
}
};

xmlhttp.open("get","<%=request.getContextPath()%>/cbcnt?X="+x,true);
xmlhttp.send();
});

	</script>
	</body>
</html>