
<%@page import="java.util.List"%>
<%@page import="vo.vo_country"%>
<%@page import="dao.dao_country"%>
<html>
<head>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<link rel="st-ylesheet" type="text/css" media="all"
	href="../../calendar css/jsDatePick_ltr.min.css" />
<script type="text/javascript"
	src="../../calendar js/jsDatePick.min.1.3.js"></script>
<script type="text/javascript">

	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"inputField",
			dateFormat:"%d-%M-%Y"
			
		});
	};
</script>
</head>
<body>

	<div id="slideout">
		<a class="link-settings-colors"><i class="icon-cog"></i></a>
		<div id="slideout_inner">
			<form id="switchform">
				<ul>
					<li><a class="colordefault"
						href="javascript:chooseStyle('none', 30)">Default style</a></li>
					<li><a class="colorred"
						href="javascript:chooseStyle('red-theme', 30)">Red theme</a></li>
					<li><a class="colorpurple"
						href="javascript:chooseStyle('purple-theme', 30)">Purple theme</a></li>
					<li><a class="colorblue"
						href="javascript:chooseStyle('blue-theme', 30)">Blue theme</a></li>
					<li><a class="colororange"
						href="javascript:chooseStyle('orange-theme', 30)">Orange theme</a></li>
					<li><a class="colorgreen"
						href="javascript:chooseStyle('green-theme', 30)">Green theme</a></li>
					<li class="switch-fixed"><strong>Fixed:</strong><br> <a
						class="afixed" href="#">Yes</a> / <a class="arespon" href="#">No</a></li>
				</ul>
			</form>
			<%
dao_country dc = new dao_country();
vo_country vc = new vo_country();
List cntrylist = dc.select();
%>
		</div>
	</div>
	<!-- switcher color END-->

	<header>
		<div id="centered-head" class="res">
			<!-- Logo -->
			<h1>
				<a class="logo" href="dashboard.jsp">OEM Admin Panel</a>
			</h1>
			<!-- Logo end -->

			<!-- Navigation -->
			<nav>
				<ul>
					<li id="login"><span id="login-trigger"> <span
							id="login-triggers"> <span id="user-panel-check"></span> <span
								id="user-panel-title">My Account</span>
						</span>
					</span>
						<div id="login-content">
							<ul>
								<li><a href="#"><img alt=""
										src="../../images/setting.png"> <span>Settings</span></a></li>
								<li><a href="#"><img alt="" src="../../images/help.png"><span>Help</span></a></li>
								<li><a href="index.jsp"><img alt=""
										src="../../images/logout.png"><span>Log Out</span></a></li>
							</ul>
						</div></li>
				</ul>
			</nav>

			<div class="account-name">
				<p>
					<span class="welcome">Welcome,</span> <strong>John Doe</strong>
				</p>
				<div class="account-separator"></div>
			</div>
			<div class="account-name">
				<p>Language:</p>
				<ul class="language">
					<li><a class="ukraine" href="#">ukraine</a></li>
					<li class="language-active"><a class="usa" href="#">usa</a></li>
					<li><a class="europe" href="#">europe</a></li>
				</ul>
				<div class="account-separator"></div>
			</div>
			<!-- Navigation end-->

		</div>
	</header>


	<section id="middle" class="res">
		<div id="container-main">
			<div id="container">
				<div id="content">



					<div class="speedbar">
						<div class="speedbar-nav">
							<a href="#">Manage Employee</a> › <a href="#"></a>
						</div>

						<div class="search">
							<form>
								<input type="text">
							</form>
						</div>
						<div class="link-drop-menu">
							<a class="a-link-drop-menu" href="#"></a>
						</div>
					</div>


					<!--Form-->
					<div class="grid-1">
						<div class="title-grid">
							Create Emolyee <span></span>
						</div>
						<div class="content-gird">
							<div class="form">
							
								<form action="<%=request.getContextPath() %>/employee_controller"
									id="customForm" method="post">
									<c:choose>	
									<c:when test="${sessionScope.emp_obj == null}">
									<input type="hidden" value="insert" name="flag" />
									</c:when>
									<c:otherwise>
									<input type="hidden" value="update" name="flag" />
									</c:otherwise>
									</c:choose>
									<input type="hidden" value="${sessionScope.emp_obj.emp_id }" name="emp_id" />
									<div class="elem">
										<label>Branch Name :</label>
										<div class="indent">
											<select class="chzn-select medium-select select"
												style="width: 250px;" name="branch_name">
												<option value="5">5</option>
												<option value="a">a</option>
												<option value="b">b</option>
												<option value="c">c</option>
												<option value="d">d</option>
											</select>
										</div>
									</div>
									<div class="elem">
										<label> First Name: </label>
										<div class="indent">
											<input type="text" class="medium" name="f_name" id="f_name"
											value="${sessionScope.emp_obj.f_name }"	required>
										</div>
									</div>
									<div class="elem">
										<label>Last Name: </label>
										<div class="indent">
											<input type="text" class="medium" name="l_name" id="l_name"
											value="${sessionScope.emp_obj.l_name }">
										</div>
									</div>
									<div class="elem">
										<label>Mid Name: </label>
										<div class="indent">
											<input type="text" class="medium" name="m_name" id="m_name"
											value="${sessionScope.emp_obj.m_name }">
										</div>
									</div>
									<div class="elem">
										<label class="left">Gander:</label>
										<div class="indent distance">

											<p>
													<input type="Radio" name="gander" value="Male" <c:if test="${sessionScope.empobj.gander=='Male' }">checked=checked</c:if> /> Male
													<input type="Radio" name="gander" value="Female" <c:if test="${sessionScope.empobj.gander=='Female'}">checked=checked</c:if> /> Female
											</p>

										</div>
									</div>

									<div class="elem">
										<label>Address 1:</label>
										<div class="indent">
											<textarea rows="5" name="address1" id="address1" class="medium"></textarea>
											<br> <br>

										</div>
									</div>
									<div class="elem">
										<label>Address 2:</label>
										<div class="indent">
											<textarea rows="5" name="address2" id="address2" class="medium"></textarea>
											<br> <br>

										</div>
									</div>
									<div class="elem">
										<label>City : </label>
										<div class="indent">
											<input type="text" class="medium" name="city" id="name"
											value="${sessionScope.emp_obj.city }">
										</div>

									</div>
									<div class="elem">
										<label>Pincode : </label>
										<div class="indent">
											<input type="text" class="medium" name="pincode" id="name">
										</div>
									</div>
									<div class="elem">
										<label>Country : </label>
										<div class="indent">
																  <select name="cb_cntry" id="cntry" tabindex="1" align="center" data-placeholder="Select country" class="span6" required>
                           <option value=""></option>
 <c:forEach var="row" items="<%=cntrylist%>" > 
 						<option value="${row.cntryid }" id="${row.cntryid }">${row.name}</option>
            </c:forEach>       
            </select>   	
										</div>
									</div>
									<div class="elem">
										<label>State : </label>
										<div class="indent">
						
            	<select id="ste" name="cb_state" tabindex="1" align="center" data-placeholder="Select State" class="span6" required>
                           <option value=""></option>
                           
                        </select>
											
										</div>
									</div>
									<div class="elem">
										<label>State : </label>
										<div class="indent">
	        	<select id="cit" name="cb_cit" tabindex="1" align="center" data-placeholder="Select State" class="span6" required>
                           <option value=""></option>
                           
                        </select>
											
										</div>
									</div>

									<div class="elem">
										<label>E-mail :</label>
										<div class="indent">
											<input type="text" class="medium" name="email" id="email" 
											value="${sessionScope.emp_obj.email }" required>
											<table>
											<tr>
											<td></td>
											<td><font color="#0033FF"/><i>Ex: <u>Csagar_23@ymail.com</u></i></td>
											</tr>
											</table>
										</div>
									</div>
									<div class="elem">
										<label>Contact Number :</label>
										<div class="indent">
											<input type="text" class="medium" name="contact_number" id="name"
											value="${sessionScope.emp_obj.contact_number }">
										</div>
									</div>
									<div class="elem">
										<label>Input password:</label>
										<div class="indent">
											<input type="password" class="medium" name="password" id="pass1"
											value="${sessionScope.emp_obj.password }">
										</div>
									</div>
									<div class="elem">
										<label>Confirm Pass:</label>
										<div class="indent">
											<input type="password" class="medium" name="re_password" id="pass2"
											value="${sessionScope.emp_obj.re_password }">
										</div>
									</div>
<!-- 									<div class="elem"> -->
<!-- 										<label>Employee Post : </label> -->
<!-- 										<div class="indent"> -->
<!-- 											<input type="text" class="medium" name="emp_post" id="name" -->
<%-- 											value="${sessionScope.emp_obj.emp_post }"> --%>
<!-- 										</div> -->
<!-- 									</div> -->
									<div class="elem">
										<label>Employee Post :</label>
										<div class="indent">

											<select class="chzn-select medium-select select"
												style="width: 250px;" name="emp_post"
												value="${sessionScope.emp_obj.emp_post }">
												<c:forEach items="${sessionScope.postvo}" var = "row1">
																<option value="${row1.post_id} ">${row1.post_name}</option>
												</c:forEach>
												
											</select>
										</div>
									</div>
									<div class="elem">
										<label>Employee Join Date:</label>
										<div class="indent">
											<input type="text" size="12" id="inputField" name="emp_join_date" 
											value="${sessionScope.emp_obj.emp_join_date }"/>
										</div>
									</div>


									<div class="elem">
										<label>Upload:</label>
										<div class="indent">
											<div class="uploader black">
												<input type="text" readonly="" class="filename" name="upload_file"> <input
													type="button" value="Browse..." class="button_files "
													name="file"> <input type="file">
											</div>
										</div>

									</div>
									<div class="elem">
										<label>Note:</label>
										<div class="indent">
											<textarea rows="5" name="note" id="message" class="medium"></textarea>
											<br> <br> <input type="submit" value="Send"
												class="button-a gray" name="send" id="send">
											&nbsp;&nbsp;
											<button class="button-a dark-blue">Clear</button>
										</div>
									</div>
								</form>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<!--Form end-->


					<div class="clear"></div>
				</div>
				<!-- #content-->
			</div>
			<!-- #container-->

			
		</div>
		<!-- #sideLeft -->
		<!-- #container main-->


		<footer>
			<div class="info-footer">
				<div id="left">
					<p>Parmar Nikhil</p>
				</div>
				<div id="right">
					<p>
						<a href="http://themeforest.net/user/dimka_ua_kh/portfolio">OEM</a>
					</p>
				</div>
			</div>
		</footer>


	</section>
	<!-- #middle-->


	<div class="clear"></div>




	<div id="fancybox-tmp"></div>
	<div id="fancybox-loading">
		<div></div>
	</div>
	<div id="fancybox-overlay"></div>
	<div id="fancybox-wrap">
		<div id="fancybox-outer">
			<div id="fancybox-bg-n" class="fancybox-bg"></div>
			<div id="fancybox-bg-ne" class="fancybox-bg"></div>
			<div id="fancybox-bg-e" class="fancybox-bg"></div>
			<div id="fancybox-bg-se" class="fancybox-bg"></div>
			<div id="fancybox-bg-s" class="fancybox-bg"></div>
			<div id="fancybox-bg-sw" class="fancybox-bg"></div>
			<div id="fancybox-bg-w" class="fancybox-bg"></div>
			<div id="fancybox-bg-nw" class="fancybox-bg"></div>
			<div id="fancybox-content"></div>
			<a id="fancybox-close"></a>
			<div id="fancybox-title"></div>
			<a id="fancybox-left" href="javascript:;"><span
				id="fancybox-left-ico" class="fancy-ico"></span></a><a
				id="fancybox-right" href="javascript:;"><span
				id="fancybox-right-ico" class="fancy-ico"></span></a>
		</div>
	</div>
	<div
		class="ui-datepicker ui-widget ui-widget-content-calendar ui-helper-clearfix ui-corner-all"
		id="ui-datepicker-div"></div>
	<div class="colorpicker" id="collorpicker_113">
		<div class="colorpicker_color"
			style="background-color: rgb(255, 0, 0);">
			<div>
				<div style="left: 150px; top: 0px;"></div>
			</div>
		</div>
		<div class="colorpicker_hue">
			<div style="top: 150px;"></div>
		</div>
		<div class="colorpicker_new_color"
			style="background-color: rgb(255, 0, 0);"></div>
		<div class="colorpicker_current_color"
			style="background-color: rgb(255, 0, 0);"></div>
		<div class="colorpicker_hex">
			<input type="text" size="6" maxlength="6">
		</div>
		<div class="colorpicker_rgb_r colorpicker_field">
			<input type="text" size="3" maxlength="3"><span></span>
		</div>
		<div class="colorpicker_rgb_g colorpicker_field">
			<input type="text" size="3" maxlength="3"><span></span>
		</div>
		<div class="colorpicker_rgb_b colorpicker_field">
			<input type="text" size="3" maxlength="3"><span></span>
		</div>
		<div class="colorpicker_hsb_h colorpicker_field">
			<input type="text" size="3" maxlength="3"><span></span>
		</div>
		<div class="colorpicker_hsb_s colorpicker_field">
			<input type="text" size="3" maxlength="3"><span></span>
		</div>
		<div class="colorpicker_hsb_b colorpicker_field">
			<input type="text" size="3" maxlength="3"><span></span>
		</div>
		<div class="colorpicker_submit"></div>
	</div>
	<div style="max-width: 200px;" id="tiptip_holder">
		<div id="tiptip_arrow">
			<div id="tiptip_arrow_inner"></div>
		</div>
		<div id="tiptip_content"></div>
	</div>
</body>
</html>