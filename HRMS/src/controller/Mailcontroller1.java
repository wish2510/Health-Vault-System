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
 * Servlet implementation class Mailcontroller
 */
//@WebServlet("/Mailcontroller1")
public class Mailcontroller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mailcontroller1() {
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
		sendMail(request);
	}
	public void sendMail(HttpServletRequest request)
    {
		String toemail = request.getParameter("input.medium");
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
            message.setContent("Health Records... ","text/html");
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
    }
}
