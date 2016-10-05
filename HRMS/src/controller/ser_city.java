package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_city;
import vo.vo_city;

/**
 * Servlet implementation class ser_city
 */
//@WebServlet("/ser_city")
public class ser_city extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ser_city() {
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
		else if(request.getParameter("flag") !=null && request.getParameter("flag").equals("select"))
		{
			 select(request,response);
			 response.sendRedirect("view/city_manage.jsp");
		}
	
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		dao_city dci = new dao_city();
		vo_city vci = new vo_city();
		List list= dci.select_all(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("upcity", list);
		response.sendRedirect("view/city.jsp");
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		
		dao_city dci = new dao_city();
		vo_city vci = new vo_city();
		
		if(request.getParameter("flag") !=null && request.getParameter("flag").equals("delete"))
		{
			vci.setId(Long.parseLong(request.getParameter("id")));
			dci.delete(vci);
		}
		else if(request.getParameter("flag") !=null && request.getParameter("flag").equals("select"))
		{
			 select(request,response);
		}
		else if(request.getParameter("flag") !=null && request.getParameter("flag").equals("update"))
		{
			 update(request,response);
		}
	
		else
		{
		
		String cid="C";
		
		List list = dci.select();
		Iterator iterator = list.iterator();
		while(iterator.hasNext())
			vci = (vo_city)iterator.next();
		
		System.out.println((""+ (vci.getId()+1)).length());
	     for(int i=(""+ (vci.getId()+1)).length(); i<3;i++)
	     {
	     	cid = cid + "0";
	     }
	     cid= cid+ (vci.getId()+1);

	     System.out.println(cid);
	     vci.setCityid(cid);
	     vci.setName(request.getParameter("txt_city"));
	     vci.setDesc(request.getParameter("txt_desc"));
	     
	     vci.setStateid(request.getParameter("cb_state").trim());
	     System.out.println("Stata" +vci.getStateid());
	     
	     int i = dci.insert(vci);
	     if(!request.getParameter("x").toString().equals("null"))
	     {
	  	   response.sendRedirect("view/"+ request.getParameter("x"));
	  	   
	     }
	     else
	  	   response.sendRedirect("view/AddCity.jsp");
	  	}   
	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		vo_city vci = new vo_city();
		dao_city dci = new dao_city();
		vci.setCityid(request.getParameter("cityid"));
		vci.setId(Long.valueOf(request.getParameter("id")));
	     vci.setName(request.getParameter("txt_city"));
	     vci.setDesc(request.getParameter("txt_desc"));
	     
	     vci.setStateid(request.getParameter("cb_state").trim());
	    dci.update(vci);
	    HttpSession session = request.getSession();
	    session.removeAttribute("upcity");
	    response.sendRedirect(request.getContextPath() +"/ser_city?flag=select");
		
		
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao_city dc = new dao_city();
		List list= dc.select_all();
		HttpSession session = request.getSession();
		session.setAttribute("citylist", list);
		
	}
	
	}


