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
import vo.UserLoginVO;
import vo.UserProfileVO;
/**
 * Servlet implementation class UserProfilecontroller
 */
//@WebServlet("/UserProfilecontroller")
public class UserProfilecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfilecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("search"))
		{
	  //    	search(request, response);
		}
		else if(flag!=null && flag.equals("update"))
		{
	     		update(request, response);
		}

		else if(flag!=null && flag.equals("delete"))
		{
			
		//		delete(request, response);
		}
		else{
				insert(request, response);
		}


	}
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String frstname = request.getParameter("input.autocompletefirstname");
		String midlname = request.getParameter("input.autocompletemiddlename");
		String lastname = request.getParameter("input.autocompletelastname");
	//	String usename = request.getParameter("input.autocompleteusername");
	//	String pwd = request.getParameter("input.autocompletepassword");
		String regtpe = "Patient";
		String date = new Date().toString();
		String date2 = date.substring(0, 10);
		System.out.println(date2);
		System.out.println("FAfgssdga"+request.getParameter("cb_cit"));
		String addr = request.getParameter("textareaaddress");
		String cntry = request.getParameter("cb_cntry");
		String cit = request.getParameter("cb_cit").trim();
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
		Random random = new Random();
		Integer i = random.nextInt(1000);
		Integer i1 = random.nextInt(1000);
		String bd = birhdate.substring(3, 5);
		System.out.println(bd);
		String usernme = frstname+"."+regtpe+bd+"@"+i+"_"+i1;
		System.out.println(usernme);
		Random random2 = new Random();
		String pwd = frstname.substring(0, 1)+random2.nextInt(100)+midlname.substring(0, 1)+random2.nextInt(100)+lastname.substring(0, 1)+random2.nextInt(100);
	//	HttpSession session = request.getSession();
	//	session.setAttribute("ls3", request.getParameter("input.autocompleteprimary"));
		
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
		System.out.println(userProfileVO.getCity()+"          fdafs");
		UserLogindao logindao =new UserLogindao();
		UserProfiledao userProfiledao =new UserProfiledao();
		
		
		logindao.insert(loginVO);
		
		Long userid = loginVO.getUserid();
		userProfileVO.setUserid(userid);
		
		userProfiledao.insert(userProfileVO);
		
		sendMail(request, response);

	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		UserLoginVO userLoginVO;
		List ls2 = (List)session.getAttribute("lsreg234");
		List ls3 = (List)session.getAttribute("lsreg235");
		
		userLoginVO = (UserLoginVO) ls2.get(0);
		
		String username = userLoginVO.getUsername();
		System.out.println("pppp"+username);
		String password = userLoginVO.getPassword();
		String regtpe = userLoginVO.getRegtype();
		String adddate = userLoginVO.getAdddate();
		
		String frstname = request.getParameter("input.autocompletefirstname");
		String midlname = request.getParameter("input.autocompletemiddlename");
		String lastname = request.getParameter("input.autocompletelastname");
	//	String usename = request.getParameter("input.autocompleteusername");
	//	String pwd = request.getParameter("input.autocompletepassword");
	//	String regtpe = request.getParameter("selectuserrole");
			
		
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
		
		
		UserLoginVO loginVO =new UserLoginVO();
		UserProfileVO userProfileVO = new UserProfileVO();
		
			
		loginVO.setUserid(Long.valueOf(id));
		loginVO.setFstname(frstname);
		loginVO.setMdlname(midlname);
		loginVO.setLstname(lastname);
		loginVO.setUsername(username);
		loginVO.setPassword(password);
		loginVO.setAdddate(adddate);
		loginVO.setRegtype(regtpe);
		
		
		
		userProfileVO.setUserProfileid(Long.valueOf(id));
		userProfileVO.setUserid(Long.valueOf(id));
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
		UserProfiledao userProfiledao = new UserProfiledao();
		
		
		logindao.update(loginVO);
		userProfiledao.update(userProfileVO);
		HttpSession session2 = request.getSession();
		session2.removeAttribute("lsreg");
		session2.removeAttribute("lsreg22");
		session2.removeAttribute("hdnflag");
		response.sendRedirect("view/Add Patient.jsp");
		
	}

	public void sendMail(HttpServletRequest request ,HttpServletResponse response) throws IOException
    {
		
		
		HttpSession session = request.getSession();
		String s1= (String)session.getAttribute("ls1");
		System.out.println(s1);
		String s2= (String)session.getAttribute("ls2");
		
		String toemail =request.getParameter("input.autocompleteprimary");
		String comment = "Your HRMS Login Information:"+"Username:"+s1+"Password"+s2;
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
        response.sendRedirect("view/Add Patient.jsp");

    }

}

