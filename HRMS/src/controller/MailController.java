package controller;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailController
 */
//@WebServlet("/MailController")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public MailController() {
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
		// T(ODO Auto-generated method stub
	sendMail(request);
	
	}
	public void sendMail(HttpServletRequest request)
    {
		
		
		String toemail =request.getParameter("input.mediumto");
		String comment = request.getParameter("textarea");
		String subject = request.getParameter("input.mediumsubject");
		String random = "007";
		
		
        java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

       
        try {
            MimeMessage message = new MimeMessage(mailSession);

           
           
            //message.setContent("<a href='http:\\\\"+request.getRemoteHost()+"\\"+request.getContextPath()+"\\register\\loadRegistrationPage.htm?random="+ id +"'>Please click here to Activate SwapMeTv Account</a> ", "text/html");
 
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
       
    }

}
