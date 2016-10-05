package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_state;
import vo.vo_state;

/**
 * Servlet implementation class ser_state
 */
//@WebServlet("/ser_state")
public class ser_state extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ser_state() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("flag") !=null && request.getParameter("flag").equals("select"))
		{
			dao_state ds = new dao_state();
			HttpSession session = request.getSession();
			session.setAttribute("statelist", ds.select_all());
			response.sendRedirect("view/state_manage.jsp");
		}
		if(request.getParameter("flag") !=null && request.getParameter("flag").equals("edit"))
		{
			search(request,response);
		}
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Search");
		
		dao_state ds = new dao_state();
		vo_state vs = new vo_state();
		List list= ds.select_all(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("upstate", list.get(0));
		response.sendRedirect("view/state.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("flag") !=null && request.getParameter("flag").equals("update"))
		{
			update(request,response);
		}
		else if(request.getParameter("flag") !=null && request.getParameter("flag").equals("delete"))
		{
			delete(request,response);
		}
		else
		{
	dao_state ds = new dao_state();
	vo_state vs = new vo_state();
	
	
	  List objlist = ds.select();
      String sid="S";

     Iterator iterator = objlist.iterator();

   while (iterator.hasNext()) {
    vs=	(vo_state) iterator.next();
   }

   System.out.println((""+ (vs.getId()+1)).length());
   for(int i=(""+ (vs.getId()+1)).length(); i<3;i++)
   {
   	sid = sid + "0";
   }
   sid= sid+ (vs.getId()+1);
   System.out.println(sid);

   vs.setStateid(sid);
   vs.setName(request.getParameter("txt_state"));
   vs.setDesc(request.getParameter("txt_desc"));
   vs.setCtrid(request.getParameter("cb_cntry").trim());
   System.out.println(vs.getName());
   System.out.println(vs.getCtrid());
   
   int i =ds.insert(vs);
   if(!request.getParameter("x").toString().equals("null"))
   {
	   response.sendRedirect("view/"+ request.getParameter("x"));
	   
   }
   else
	   response.sendRedirect("view/AddState.jsp");
	}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao_state ds =new dao_state();
		vo_state vs = new vo_state();
		vs.setId(Long.parseLong(request.getParameter("id")));
		ds.delete(vs);
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
			vo_state vs= new vo_state();
			dao_state ds =new dao_state();
			
		   vs.setId(Long.valueOf(request.getParameter("id")));
		   vs.setStateid(request.getParameter("stateid"));
		   vs.setName(request.getParameter("txt_state"));
		   vs.setDesc(request.getParameter("txt_desc"));
		   vs.setCtrid(request.getParameter("cb_cntry").trim());
		   System.out.println("UPDARE:");
		   System.out.println(vs.getCtrid());
		   ds.update(vs);
		   HttpSession session = request.getSession();
		   session.removeAttribute("upstate");
		   response.sendRedirect(request.getContextPath() + "/ser_state?flag=select");
		
	}
}
