package controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReferingClinicdao;
import dao.UserLogindao;
import dao.UserProfiledao;
import dao.UserRecorddao;
import vo.ReferingClinicVO;
import vo.UserLoginVO;
import vo.UserProfileVO;
import vo.UserRecordVO;
/**
 * Servlet implementation class Userrecordcontroller
 */
//@WebServlet("/Userrecordcontroller")
public class Userrecordcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userrecordcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("search"))
		{			
	     		search(request, response);
		}
		else if(flag!=null && flag.equals("cr"))
		{	
			HttpSession session = request.getSession();
			ReferingClinicdao referingClinicdao =new ReferingClinicdao();
			ReferingClinicVO referingClinicVO = new ReferingClinicVO();
			java.util.List ls2=referingClinicdao.search(referingClinicVO);
			session.setAttribute("ls2", ls2);	
			response.sendRedirect("view/User_CreateRecords.jsp");
		}
		else if(flag!=null && flag.equals("search_user"))
		{
			search_user(request,response);
		}
		else if(flag!=null && flag.equals("search_doctor"))
		{
			search_doctor(request,response);
		}
		else
		{
			UserLogindao  logindao = new UserLogindao();
			UserLoginVO loginVO =new UserLoginVO();
			java.util.List ls= logindao.search(loginVO);
			HttpSession session =request.getSession();
			session.setAttribute("ls",ls);	
			ReferingClinicdao referingClinicdao =new ReferingClinicdao();
			ReferingClinicVO referingClinicVO = new ReferingClinicVO();
			java.util.List ls1=referingClinicdao.search(referingClinicVO);
			session.setAttribute("ls1", ls1);
			
			response.sendRedirect("view/Submit Records.jsp");

		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		if(flag!=null && flag.equals("insert"))
		{
	     		insert(request, response);
		}

		else if(flag!=null && flag.equals("delete"))
		{
			
				delete(request, response);
		}
		else if(flag!=null && flag.equals("insertfromuser"))
		{
			
				insertfromuser(request, response);
		}
	}
	
	public void insertfromuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
	HttpSession session = request.getSession();
	String ctgofrecord = request.getParameter("select");
	String typeofRcd = request.getParameter("selecttypeofrecord");
	String recordtitle = request.getParameter("input.mediumrecordtitile");
	String referingclinic = request.getParameter("selectreferingclinic");
	String otherclinic = request.getParameter("input.mediumotherclinic");
	String remark = request.getParameter("textarea");
	String date = new Date().toString();
	String date2 = date.substring(0, 10);
	
	
	String maxid = null;
	if(referingclinic.equals("other"))
	{
		ReferingClinicVO referingClinicVO = new ReferingClinicVO();
		ReferingClinicdao referingClinicdao = new ReferingClinicdao();
		referingClinicVO.setClinicname(otherclinic);
		referingClinicdao.insert(referingClinicVO);
	List ls123 = referingClinicdao.search1(referingClinicVO);
	maxid = ls123.get(0).toString();
	}
	
	String s = (String)session.getAttribute("filename");
	UserRecordVO userRecordVO = new UserRecordVO();
	if(maxid == null) {
	
		Long refericlinic = (Long.parseLong(request.getParameter("selectreferingclinic")));
		userRecordVO.setClinicid(refericlinic);
	}else  {
		userRecordVO.setClinicid(Long.parseLong(maxid));
	}
	String s123 = session.getAttribute("id1234_f").toString();
	userRecordVO.setUserid(Long.parseLong(s123));
	userRecordVO.setTitle(recordtitle);
	userRecordVO.setRemarks(remark);
//	userRecordVO.setConclusion(conclusion);
//	userRecordVO.setRemarks(remarks);
	userRecordVO.setAttachment(s);
	userRecordVO.setDateofRcd(date2);
	
	
	userRecordVO.setAttachmenttype(s.substring(s.lastIndexOf('.') + 1));
	
	
	
	UserRecorddao userRecorddao =new UserRecorddao();
	
	
	userRecorddao.insert(userRecordVO);

	response.sendRedirect("view/User_CreateRecords.jsp");
	
	
	}	

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
	HttpSession session = request.getSession();
	String title = request.getParameter("input.medium");
	String dateofrecord = request.getParameter("dateofrecord");
	String conclusion = request.getParameter("conclusion");
	String remarks = request.getParameter("textarea");
//	String attachment = request.getParameter("uploadfilename");
		
	Long userrecor =(Long.parseLong(request.getParameter("selectpatient"))) ;
	
	Long refericlinic = (Long.parseLong(request.getParameter("selectreferingclinic")));
	String s = (String)session.getAttribute("filename");
	UserRecordVO userRecordVO = new UserRecordVO();
	userRecordVO.setClinicid(refericlinic);
	userRecordVO.setTitle(title);
	userRecordVO.setDateofRcd(dateofrecord);
	userRecordVO.setConclusion(conclusion);
	userRecordVO.setRemarks(remarks);
	userRecordVO.setAttachment(s);
	userRecordVO.setUserid(userrecor);
	userRecordVO.setAttachmenttype(s.substring(s.lastIndexOf('.') + 1));
	
	UserRecorddao userRecorddao =new UserRecorddao();
	
	
	userRecorddao.insert(userRecordVO);

	response.sendRedirect("view/Submit Records.jsp");
	
	
	}	
	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		UserRecorddao userRecorddao = new UserRecorddao();
		UserRecordVO userRecordVO = new UserRecordVO();
	
		UserLogindao userLogindao = new UserLogindao();
		UserLoginVO loginVO = new UserLoginVO();
		
		UserProfiledao userProfiledao = new UserProfiledao();
		UserProfileVO profileVO = new UserProfileVO();
		HttpSession session = request.getSession();
		String struserid =request.getParameter("id");
		
		if(struserid!=null&& !struserid.equals(""))
		{
			
		}
		else
		{
			struserid =(String)session.getAttribute("userid_search");
			
		}
		
		userRecordVO.setUserid(Long.valueOf(struserid));
		loginVO.setUserid(Long.valueOf((struserid)));
		profileVO.setUserid(Long.valueOf((struserid)));
		
		List ls = userRecorddao.search(userRecordVO);
		List ls1 = userLogindao.search(loginVO);
		
		session.setAttribute("lis", ls);
		session.setAttribute("lis1", ls1);
		session.setAttribute("userid_search", request.getParameter("id"));
		response.sendRedirect("view/Users Records.jsp");
		
		}	
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String[] deleterecord = request.getParameterValues("chk2");

		UserRecordVO userRecordVO = new UserRecordVO();
		UserRecorddao userRecorddao = new UserRecorddao();
		
		
		for (int i = 0; i < deleterecord.length; i++) {
			
			userRecordVO.setUserRecordid(Long.valueOf(deleterecord[i]));
			userRecorddao.delete(userRecordVO);
		}
		
		search(request,response);
	}	

	
	public void search_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String struserrecordid = request.getParameter("id");
		String struserid= request.getParameter("id1");
		
		System.out.println("struserrecordid"+struserrecordid);
		System.out.println("struserid"+struserid);
		
		
		UserRecorddao userRecorddao = new UserRecorddao();
		UserRecordVO userRecordVO = new UserRecordVO();
	
		UserLogindao userLogindao = new UserLogindao();
		UserLoginVO loginVO = new UserLoginVO();
		
		UserProfiledao userProfiledao = new UserProfiledao();
		UserProfileVO profileVO = new UserProfileVO();
		
		HttpSession session = request.getSession();
		
		userRecordVO.setUserRecordid(Long.valueOf(struserrecordid));
		loginVO.setUserid(Long.valueOf((struserid)));
		profileVO.setUserid(Long.valueOf((struserid)));
		
		List ls = userRecorddao.searchpersonalrecord(userRecordVO);
		List ls1 = userLogindao.search(loginVO);
		
		session.setAttribute("lis", ls);
		session.setAttribute("lis1", ls1);
		session.setAttribute("userid_search", request.getParameter("id"));
		response.sendRedirect("view/User_Personal_Records.jsp");
		
		}
	
	public void search_doctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String struserrecordid = request.getParameter("id");
		String struserid= request.getParameter("id1");
		
		System.out.println("struserrecordid"+struserrecordid);
		System.out.println("struserid"+struserid);
		
		
		UserRecorddao userRecorddao = new UserRecorddao();
		UserRecordVO userRecordVO = new UserRecordVO();
	
		UserLogindao userLogindao = new UserLogindao();
		UserLoginVO loginVO = new UserLoginVO();
		
		UserProfiledao userProfiledao = new UserProfiledao();
		UserProfileVO profileVO = new UserProfileVO();
		
		HttpSession session = request.getSession();
		
		userRecordVO.setUserRecordid(Long.valueOf(struserrecordid));
		loginVO.setUserid(Long.valueOf((struserid)));
		profileVO.setUserid(Long.valueOf((struserid)));
		
		List ls = userRecorddao.searchpersonalrecord(userRecordVO);
		List ls1 = userLogindao.search(loginVO);
		
		session.setAttribute("lis", ls);
		session.setAttribute("lis1", ls1);
		session.setAttribute("userid_search", request.getParameter("id"));
		response.sendRedirect("view/Doctor_Records.jsp");
		
		}
	
}
