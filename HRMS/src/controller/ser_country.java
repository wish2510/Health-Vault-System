package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_country;
import vo.vo_country;

/**
 * Servlet implementation class ser_country
 */
//@WebServlet("/ser_country")
public class ser_country extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ser_country() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flg= request.getParameter("flag");
			if(flg!=null & flg.equals("edit"))
			{
				search(request,response);
	
			}
				dao_country dc =new dao_country();
		}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		vo_country vc = new vo_country();
		dao_country dc = new dao_country();
		
	List ls= dc.select(id);

	HttpSession session= request.getSession();
	session.setAttribute("upcnt", ls);

	response.sendRedirect("view/Add Patient.jsp");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		vo_country vc = new vo_country();
		dao_country dc = new dao_country();

		if(request.getParameter("flag") !=null && request.getParameter("flag").equals("select"))
    	{
    		HttpSession session = request.getSession();
    		session.setAttribute("cntrylist", dc.select());
    		response.sendRedirect("view/Add Patient.jsp");
    	}
		else if(request.getParameter("flag") !=null && request.getParameter("flag").equals("delete"))
		{
			dc.delete(request.getParameter("id"));
		}
		else if(request.getParameter("flag") !=null && request.getParameter("flag").equals("update"))
		{
			Update(request,response);
			HttpSession session = request.getSession();
			session.removeAttribute("upcnt");
		}
		
		else
		{
			List objlist = 	dc.select_id();
			String cid="C";

        Iterator n1 = objlist.iterator();

     while (n1.hasNext()) {
      vc=	(vo_country) n1.next();

     }

     System.out.println((""+ (vc.getId()+1)).length());
     for(int i=(""+ (vc.getId()+1)).length(); i<3;i++)
     {
     	cid = cid + "0";
     }
     cid= cid+ (vc.getId()+1);
     
     System.out.println(cid);

     vc.setCntryid(cid.trim());
     vc.setName(request.getParameter("txt_name"));
     vc.setDesc(request.getParameter("txt_desc"));
     
     int i= dc.insert(vc);
     System.out.println("DADSA" +request.getParameter("x").toString());
     
     if(!request.getParameter("x").toString().equals("null"))
	   {
		   response.sendRedirect("view/"+ request.getParameter("x"));
		   
	   }
	   else
		   response.sendRedirect("view/AddCountry.jsp");
		}
}

	private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		vo_country vc = new vo_country();
		dao_country dc = new dao_country();
		vc.setId(Long.parseLong(request.getParameter("id")));
		vc.setCntryid(request.getParameter("ctrid"));
		vc.setName(request.getParameter("txt_name"));
		vc.setDesc(request.getParameter("txt_desc"));
		dc.update(vc);
		
		response.sendRedirect(request.getContextPath() + "/ser_country?flag=select");
		
	}

	
}
