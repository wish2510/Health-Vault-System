package controller;

import java.io.IOException;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShareRecorddao;
import dao.UserLogindao;
import dao.UserProfiledao;
import dao.UserRecorddao;
import vo.ShareRecordVO;
import vo.UserLoginVO;
import vo.UserProfileVO;
import vo.UserRecordVO;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
String id1234 = null;


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("Loginsearch"))
		{
			loginsearch(request, response);
		}
		if(flag!=null && flag.equals("forgotusername"))
		{
			forgotusername(request , response);
		}
		if(flag!=null && flag.equals("forgotpassword"))
		{
			forgotpassword(request,response);
		}
	}

	private void forgotpassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		
		UserLoginVO userLoginVO = new UserLoginVO();
		UserProfileVO userProfileVO = new UserProfileVO();
		UserLogindao userLogindao = new UserLogindao();
		UserProfiledao userProfiledao = new UserProfiledao();
		userLoginVO.setUsername(username);
		
		HttpSession session = request.getSession();
		
		List l = userLogindao.fu2(userLoginVO);
	
		if(l.size()>0)
		{
			
			userLoginVO = (UserLoginVO) l.get(0);
			userProfileVO.setUserid(userLoginVO.getUserid());
			List ls1 = userProfiledao.fu3(userProfileVO);
			
			userProfileVO= (UserProfileVO) ls1.get(0);
			
			
			String toemail = userProfileVO.getEmailprimary();
			//String comment = request.getParameter("comment");
			//String subject = request.getParameter("subject");	
	        java.util.Properties properties = new java.util.Properties();
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
	        try {
	            MimeMessage message = new MimeMessage(mailSession);
	           // message.setContent("<a href='http:\\\\"+request.getRemoteHost()+"\\"+request.getContextPath()+"\\register\\loadRegistrationPage.htm?random="+ id +"'>Please click here to Activate SwapMeTv Account</a> ", "text/html");
	            /*message.setContent("<a target='_blank' style='cursor:pointer' href='http:\\\\"+request.getRemoteHost()+":8080\\"+request.getContextPath()+"\\temp.jsp?random="+ random +"'>Please click here to Activate Bank Account</a> ", "text/html");*/
	            message.setSubject("Password information");
	            message.setContent("Password is " + userLoginVO.getPassword(),"text/html");
	            InternetAddress sender = new InternetAddress("vishal.hrms@gmail.com", "Health Records...");
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

		session.setAttribute("success", "Mail Is sent to you at your Email Address");	
			
		}
		else
		{

			session.setAttribute("error", "Sorryy!!! Your information doesn't Match");	
				
		}
		response.sendRedirect("view/ForgotPassword.jsp");

	}

	private void forgotusername(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("emailaddress");
		String dob= request.getParameter("dob");
		UserLoginVO uv = new UserLoginVO();
		UserProfileVO upv = new UserProfileVO();
		UserLogindao ud = new UserLogindao();
		upv.setEmailprimary(email);
		upv.setBirthdate(dob);
		HttpSession session = request.getSession();
		
		List l = ud.fu(upv);
		if(l.size()>0)
		{
		upv= (UserProfileVO) l.get(0);
		uv.setUserid(upv.getUserid());
		List ls= 	ud.search(uv);
		Object[] ob =(Object[]) ls.get(0);
		uv= (UserLoginVO) ob[0];
			
			
			String toemail = upv.getEmailprimary();
			//String comment = request.getParameter("comment");
			//String subject = request.getParameter("subject");	
	        java.util.Properties properties = new java.util.Properties();
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
	        try {
	            MimeMessage message = new MimeMessage(mailSession);
	           // message.setContent("<a href='http:\\\\"+request.getRemoteHost()+"\\"+request.getContextPath()+"\\register\\loadRegistrationPage.htm?random="+ id +"'>Please click here to Activate SwapMeTv Account</a> ", "text/html");
	            /*message.setContent("<a target='_blank' style='cursor:pointer' href='http:\\\\"+request.getRemoteHost()+":8080\\"+request.getContextPath()+"\\temp.jsp?random="+ random +"'>Please click here to Activate Bank Account</a> ", "text/html");*/
	            message.setSubject("Confromation Mail");
	            message.setContent("Username is " + uv.getUsername(),"text/html");
	            InternetAddress sender = new InternetAddress("vishalpatel.ldce@gmail.com", "Health Records...");
	            InternetAddress receiver = new InternetAddress(toemail);
	            message.setFrom(sender);
	            message.setRecipient(Message.RecipientType.TO, receiver);          
	            message.saveChanges();
	            javax.mail.Transport transport = mailSession.getTransport("smtp");
	            transport.connect("smtp.gmail.com", 587, "vishalpatel.ldce@gmail.com", "bestin1991");
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		session.setAttribute("success", "Mail Is sent to you at your Email Address");	
			
		}
		else
		{

			session.setAttribute("error", "Sorryy!!! Your information doesn't Match");	
				
		}
		response.sendRedirect("view/ForgotPassword.jsp");
	}

	private void loginsearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserLoginVO userLoginVO = new UserLoginVO();
		userLoginVO.setUsername(username);
		userLoginVO.setPassword(password);
		
		UserLogindao logindao =new UserLogindao();
		java.util.List ls = logindao.loginsearch(userLoginVO);
		
		HttpSession session =request.getSession();

		session.setAttribute("login", ls);
		

		
//		List ls123 =(List) session.getAttribute("lis");
		
		if(ls.size()>0)
		{
			userLoginVO = (UserLoginVO)ls.get(0);
			String regtype=userLoginVO.getRegtype();
			String id = userLoginVO.getUserid().toString();
			id1234 = id;
			session.setAttribute("id1234_f",id1234);
			System.out.println(id);
			search(request,response);
			
			if(regtype!=null && regtype.equals("Admin"))
			{	
				response.sendRedirect("view/Admin Homepage.jsp");
			}
			if(regtype!=null && regtype.equals("Doctor"))
			{
				response.sendRedirect("view/Doctor_Homepage.jsp");
			}
			if(regtype!=null && regtype.equals("Patient"))
			{
				response.sendRedirect("view/User_Homepage.jsp");
			}
			if(regtype!=null && regtype.equals("Nurse"))
			{
				response.sendRedirect("view/Nurse_Homepage.jsp");
			}
		}
		else
		{
			
			session.setAttribute("invalid","Wrong Username and Password!!");
			response.sendRedirect("view/login.jsp");
		}
	
	}

	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		UserRecorddao userRecorddao = new UserRecorddao();
		UserRecordVO userRecordVO = new UserRecordVO();
	
		UserLogindao userLogindao = new UserLogindao();
		UserLoginVO loginVO = new UserLoginVO();
		
		UserProfiledao userProfiledao = new UserProfiledao();
		UserProfileVO profileVO = new UserProfileVO();
		
		ShareRecordVO shareRecordVO = new ShareRecordVO();
		ShareRecorddao shareRecorddao = new ShareRecorddao();
		
		HttpSession session = request.getSession();
		
		shareRecordVO.setTrustedcontact(id1234);
		userRecordVO.setUserid(Long.valueOf(id1234));
		loginVO.setUserid(Long.valueOf((id1234)));
		profileVO.setUserid(Long.valueOf((id1234)));
		
		List ls = userRecorddao.search(userRecordVO);
		List ls1 = userLogindao.search(loginVO);
		List ls25 = shareRecorddao.searchtrustee(shareRecordVO);
		session.setAttribute("lis", ls);
		session.setAttribute("lis1", ls1);
		session.setAttribute("ls256", ls25);

		}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
