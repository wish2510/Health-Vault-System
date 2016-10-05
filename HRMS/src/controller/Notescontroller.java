package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Notesdao;
import vo.NotesVO;

/**
 * Servlet implementation class Notescontroller
 */
//@WebServlet("/Notescontroller")
public class Notescontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String idall=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notescontroller() {
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
			search(request,response);
		}
		if(flag!=null && flag.equals("usernotesearch"))
		{
			usernotesearch(request,response);
		}
		if(flag!=null && flag.equals("displaynotes"))
		{
			displaynotes(request,response);
		}
	}

	
	private void displaynotes(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String id= request.getParameter("id");
		
		NotesVO notesVO =  new NotesVO();
		Notesdao notesdao = new Notesdao();
		
		notesVO.setNoteid(Long.parseLong(id));
		List ls = notesdao.searchnotesforclickonnotes(notesVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("lsser", ls);
		System.out.println(ls);
		response.sendRedirect("view/User_onclickofnotes.jsp");
	}

	private void usernotesearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("idn");
		idall= id;
		NotesVO notesVO = new NotesVO();
		Notesdao notesdao = new Notesdao();
		HttpSession session = request.getSession();
		if(id==null)
		{
			id=(String)session.getAttribute("lsins");	
			idall=id;
		}
		else
		{
			
		}
		notesVO.setUserrecordid(Long.parseLong(id));
		List ls = notesdao.search(notesVO);
		session.setAttribute("lsser", ls);
		response.sendRedirect("view/User_Notes.jsp");
	}
	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub	
		String id = request.getParameter("idn");
		idall= id;
		System.out.println("idall    nunnnnnnn"+idall);
		System.out.println("1111111111111111"+id);
		NotesVO notesVO = new NotesVO();
		Notesdao notesdao = new Notesdao();
		HttpSession session = request.getSession();
		if(id==null)
		{
			System.out.println("iddddddd");
			id=(String)session.getAttribute("lsins");
			System.out.println("laaaaaaaaasssssssssttttt"+id);
			idall=id;
		}
		else
		{
			
		}
		
		notesVO.setUserrecordid(Long.parseLong(id));
		List ls = notesdao.search(notesVO);

		session.setAttribute("lsser", ls);
		
		System.out.println("qqqqqqqqqqqqqq"+ls);
		
		response.sendRedirect("view/Admin_Notes.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("search"))
		{
	  //   		search(request, response);
		}
		else if(flag!=null && flag.equals("insert"))
		{
	      		insert(request, response);
		}

		else if(flag!=null && flag.equals("deletenotes"))
		{
				deletenotes(request, response);
		}
		else if(flag!=null && flag.equals("usernoteinsert"))
		{
			usernoteinsert(request,response);
		}
		else if(flag!=null && flag.equals("doctornoteinsert"))
		{
			doctornoteinsert(request, response);
		}
		
		
	}
	private void usernoteinsert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(idall);
		
		String noteselect = request.getParameter("selectnotes");
		String note = request.getParameter("input.mediumnote");
		String description = request.getParameter("textareadescription");
		
		NotesVO notesVO = new NotesVO();
		Notesdao notesdao = new Notesdao();
		notesVO.setNote(note);
		notesVO.setNotetype(noteselect);
		notesVO.setDiscription(description);
		notesVO.setUserrecordid(Long.parseLong(idall));
		notesdao.insert(notesVO);
		HttpSession session = request.getSession();
		session.setAttribute("lsins", idall);

		usernotesearch(request,response);

	}

	private void doctornoteinsert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String idd = request.getParameter("iddd");
		System.out.println("asdfghhjk asdnasjdka    "+idd);
		String date =new Date().toString();
	
		
		String noteselect = request.getParameter("selectnotes");
		String note = request.getParameter("input.mediumnote");
		String description = request.getParameter("textareadescription");
		
		NotesVO notesVO = new NotesVO();
		Notesdao notesdao = new Notesdao();
		notesVO.setNote(note);
		notesVO.setNotedate(date.substring(0, 10));
		notesVO.setNotetype(noteselect);
		notesVO.setDiscription(description);
		notesVO.setUserrecordid(Long.valueOf(idd));
		notesdao.insert(notesVO);
		response.sendRedirect("view/Doctor_Homepage.jsp");

	}

	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println(idall);
		
		String noteselect = request.getParameter("selectnotes");
		String note = request.getParameter("input.mediumnote");
		String description = request.getParameter("textareadescription");
		
		NotesVO notesVO = new NotesVO();
		Notesdao notesdao = new Notesdao();
		notesVO.setNote(note);
		notesVO.setNotetype(noteselect);
		notesVO.setDiscription(description);
		notesVO.setUserrecordid(Long.parseLong(idall));
		notesdao.insert(notesVO);
		HttpSession session = request.getSession();
		session.setAttribute("lsins", idall);

		search(request,response);
	}
	
	public void deletenotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String[] deleterecord = request.getParameterValues("chk3");

		NotesVO notesVO = new NotesVO();
		Notesdao notesdao = new Notesdao();
		
		for (int i = 0; i < deleterecord.length; i++) {
			
			notesVO.setNoteid(Long.valueOf(deleterecord[i]));
			notesdao.deletenotes(notesVO);
		}
		HttpSession session = request.getSession();
		session.setAttribute("lsins", idall);

		usernotesearch(request,response);
	}	

	
}

