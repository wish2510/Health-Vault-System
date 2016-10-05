package controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserLogindao;
import dao.UserProfiledao;
import dao.UserRecorddao;
import vo.UserLoginVO;
import vo.UserProfileVO;
import vo.UserRecordVO;
/**
 * Servlet implementation class UserLogincontroller
 */
//@WebServlet("/UserLogincontroller")
public class UserLogincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String idforlogin=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("edit"))
		{
			edit(request, response);
		}
		if(flag!=null && flag.equals("changepasswordfromuser"))
		{
				changepasswordfromuser(request, response);
		}
		
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		UserLoginVO loginVO =new UserLoginVO();
		UserLogindao logindao =new UserLogindao();
		loginVO.setUserid(Long.valueOf(id));
		java.util.List ls = logindao.fetch(loginVO);
		UserProfileVO userProfileVO =  new UserProfileVO();
		UserProfiledao userProfiledao = new UserProfiledao();
		userProfileVO.setUserid(Long.valueOf(id));
		List ls1 = userProfiledao.fetch(userProfileVO);
		HttpSession session =request.getSession();
		session.setAttribute("lsreg", ls.get(0));
		session.setAttribute("lsreg22", ls1.get(0));
		session.setAttribute("lsreg234", ls);
		session.setAttribute("lsreg235", ls1);
		session.setAttribute("hdnflag", "update");
		response.sendRedirect("view/EditPatient.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("search"))
		{
	      		search(request, response);
		}
		else if(flag!=null && flag.equals("insert"))
		{
	      		insert(request, response);
		}

		else if(flag!=null && flag.equals("delete"))
		{
				delete(request, response);
		}
		else if(flag!=null && flag.equals("updateuserpassword"))
		{
				updateuserpassword(request, response);
		}
		
		
	}
	
	public void updateuserpassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		

		String oldpassword = request.getParameter("input.mediumoldpassword");
		String newpassword = request.getParameter("input.mediumnewpassword");
		
		
		UserLoginVO loginVO;		
		UserLogindao logindao =new UserLogindao();
		HttpSession session = request.getSession();
		
		List l1= (List) session.getAttribute("lsreg23");
		
		loginVO = (UserLoginVO) l1.get(0);
		
		String pwd = loginVO.getPassword();
		System.out.println("qqqqqqqqqq  "+pwd);
		if(pwd.equals(oldpassword))
		{
			loginVO.setPassword(newpassword);
			
		}
		else
		{
			response.sendRedirect("view/User_ChangePassword.jsp");
		}
		logindao.update(loginVO);
		
		response.sendRedirect("view/User_ChangePassword.jsp");
		
	}

	
	private void changepasswordfromuser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		String id = request.getParameter("id3");
		
		UserLoginVO loginVO =new UserLoginVO();
		UserLogindao logindao =new UserLogindao();
		loginVO.setUserid(Long.valueOf(id));
		
		java.util.List ls = logindao.fetch(loginVO);

		HttpSession session =request.getSession();
		
		session.setAttribute("lsreg", ls.get(0));

		session.setAttribute("lsreg23", ls);

		session.setAttribute("hdnflag", "updateuserpassword");
		response.sendRedirect("view/User_ChangePassword.jsp");

		
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String frstname = request.getParameter("input.autocompletefirstname");
		String midlname = request.getParameter("input.autocompletemiddlename");
		String lastname = request.getParameter("input.autocompletelastname");
//		String usename = request.getParameter("input.autocompleteusername");
//		String pwd = request.getParameter("input.autocompletepassword");
		String regtpe = request.getParameter("selectuserrole");
		String date = new Date().toString();
		String date2 = date.substring(0, 10);
		System.out.println(date2);
		

		String addr = request.getParameter("textareaaddress");
		String cntry = request.getParameter("cb_cntry");
		String cit = request.getParameter("cb_cit");
		String stat = request.getParameter("cb_state");
		String ponhome = request.getParameter("input.autocompletehome");
		String ponwrk = request.getParameter("input.autocompletework");
		String ponmobil = request.getParameter("input.autocompletemobile");
		String emailprimry = request.getParameter("input.autocompleteprimary");
		String emilsecondary = request.getParameter("input.autocompletesecondary");
		String sex = request.getParameter("selectsex");
		String blodgrup = request.getParameter("selectbloodgroup");
		String hight = request.getParameter("input.autocompleteheight");
		String weight = request.getParameter("input.autocompleteweight");
		String birhdate = request.getParameter("birthdatee");
		String zip = request.getParameter("input.autocompletezip");
		
		if(regtpe==null)
		{
			regtpe = "Patient";
		}
		else
		{
			regtpe = request.getParameter("selectuserrole");	
		}
		
		
		Random random = new Random();
		Integer i = random.nextInt(1000);
		Integer i1 = random.nextInt(1000);
		String bd = birhdate.substring(3, 5);
//		System.out.println(bd);
		String usernme = frstname+"."+regtpe+bd+"@"+i+"_"+i1;
		System.out.println(usernme);
		
		Random random2 = new Random();
		
		String pwd = frstname.substring(0, 1)+random2.nextInt(100)+midlname.substring(0, 1)+random2.nextInt(100)+lastname.substring(0, 1)+random2.nextInt(100);
		
		HttpSession session =  request.getSession();
		session.setAttribute("ls1", usernme);
		session.setAttribute("ls2", pwd);
		
		
		
		
		UserLoginVO loginVO =new UserLoginVO();
		UserProfileVO userProfileVO = new UserProfileVO();
		
		
		loginVO.setFstname(frstname);
		loginVO.setMdlname(midlname);
		loginVO.setLstname(lastname);
		loginVO.setUsername(usernme);
		loginVO.setPassword(pwd);
		loginVO.setRegtype(regtpe);
		loginVO.setAdddate(date2);
		
		userProfileVO.setCountry(cntry);
		userProfileVO.setAddress(addr);
		userProfileVO.setCity(cit);
		userProfileVO.setState(stat);
		userProfileVO.setPhonehome(ponhome);
		userProfileVO.setPhonework(ponwrk);
		userProfileVO.setPhonemobile(ponmobil);
		userProfileVO.setEmailprimary(emailprimry);
		userProfileVO.setEmailsecondary(emilsecondary);
		userProfileVO.setSex(sex);
		userProfileVO.setBloodgroup(blodgrup);
		userProfileVO.setHeight(hight);
		userProfileVO.setWeight(weight);
		userProfileVO.setBirthdate(birhdate);
		userProfileVO.setZipcode(zip);
		
		UserLogindao logindao =new UserLogindao();
		UserProfiledao userProfiledao =new UserProfiledao();
		logindao.insert(loginVO);
		
		Long userid = loginVO.getUserid();
		userProfileVO.setUserid(userid);
		
		
		userProfiledao.insert(userProfileVO);
		
		sendMail(request, response);
		
	}
	
	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		String sarchbypatient = request.getParameter("searchbypatient");
	//	String sarchbydate = request.getParameter("searchbydate");
		
		
		UserLoginVO loginVO =new UserLoginVO();
		loginVO.setFstname(sarchbypatient);
		
		UserLogindao logindao =new UserLogindao();
		java.util.List ls = logindao.search(loginVO);
		
		HttpSession session =request.getSession();
		
		session.setAttribute("lsreg", ls);
		
		response.sendRedirect("view/Admin Homepage.jsp?rd=cont");
		
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String[] deleterecord = request.getParameterValues("chk");
	//	String sarchbydate = request.getParameter("searchbydate");

		
		UserLoginVO loginVO =new UserLoginVO();
		UserLogindao logindao =new UserLogindao();
		
		UserProfileVO profileVO = new UserProfileVO();
		UserProfiledao profiledao = new UserProfiledao();
		
		UserRecordVO userRecordVO = new UserRecordVO();
		UserRecorddao userRecorddao = new UserRecorddao();
		
		for (int i = 0; i < deleterecord.length; i++) {
			loginVO.setUserid(Long.valueOf(deleterecord[i]));
			logindao.delete(loginVO);
			
			profileVO.setUserProfileid(Long.valueOf(deleterecord[i]));
			profiledao.delete(profileVO);
			
			userRecordVO.setUserid(Long.valueOf(deleterecord[i]));
			userRecorddao.delete(userRecordVO);
		}
	//	search(request,response);
		
		response.sendRedirect("view/Admin Homepage.jsp");
		
	}
	
	
	public void sendMail(HttpServletRequest request ,HttpServletResponse response) throws IOException
    {
		
		
		HttpSession session = request.getSession();
		String s1= (String)session.getAttribute("ls1");
		System.out.println(s1);
		String s2= (String)session.getAttribute("ls2");
		
		String toemail =request.getParameter("input.autocompleteprimary");
		String comment = "Your HRMS Login Information:<br>Username:"+s1+"<br>Password"+s2;
		String subject = "Health Record Management System";
	//	String random = "007";
		
		
        java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

       
        try {
            MimeMessage message = new MimeMessage(mailSession);

           
           
            //message.setContent("<a href='http:\\\\"+request.getRemoteHost()+"\\"+request.getContextPath()+"\\register\\loadRegistrationPage.htm?random="+ id +"'>Please click here to Activate SwapMeTv Account</a> ", "text/html");
           // message.setContent("<a target='_blank' style='cursor:pointer' href='http:\\\\"+request.getRemoteHost()+":8080\\"+request.getContextPath()+"\\temp.jsp?random="+ random +"'>Please click here to Activate Bank Account</a> ", "text/html");
            message.setSubject(subject);
            message.setText(comment);
           
            InternetAddress sender = new InternetAddress("vishalpatel.ldce@gmail.com", "Health Records");
            InternetAddress receiver = new InternetAddress(toemail);
            message.setFrom(sender);
            message.setRecipient(Message.RecipientType.TO, receiver);
            message.saveChanges();
           
            javax.mail.Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", 587, "vishal.hrms@gmail.com", "godisgreate");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

           
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("view/add users.jsp");
    }

	
}
