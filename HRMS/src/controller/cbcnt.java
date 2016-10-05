package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao_city;
import dao.dao_state;
import vo.vo_city;
import vo.vo_state;

/**
 * Servlet implementation class cbcnt
 */
//@WebServlet("/cbcnt")
public class cbcnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cbcnt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		response.setContentType("text/xml");
       	PrintWriter out = response.getWriter();
    
       	String id=request.getParameter("X");
       	dao_city dc = new dao_city();
       	vo_city vc  = new vo_city();
       	List list = dc.select(id);
       	Iterator iterator = list.iterator();
	   /*ArrayList val = new ArrayList();
	   ArrayList  = new ArrayList();
	   */
	   out.println("<root>");
	   
	   while(iterator.hasNext())
	   {
		
		   vc = (vo_city)iterator.next();
		   String x=vc.getName();
		   String y=vc.getCityid();
		  

		   out.println("<name>");
		   out.println(x);
			  
		   
		   out.println("</name>");
		  
		   out.println("<val>");
		   out.println(y);
			  
		   
		   out.println("</val>");
		  
		  
	   }
	   
	   out.println("</root>");
	   
	   
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml");
       	PrintWriter out = response.getWriter();
		
		String id=request.getParameter("X");
	   dao_state ds = new dao_state();
	   vo_state vs  = new vo_state();
	   List list = ds.select(id);
	   Iterator iterator = list.iterator();
	   /*ArrayList val = new ArrayList();
	   ArrayList  = new ArrayList();
	   */
	   out.println("<root>");
	   
	   while(iterator.hasNext())
	   {
		
		   vs = (vo_state)iterator.next();
		   String x=vs.getName();
		   String y=vs.getStateid();
		  
		   System.out.println(vs.getName());

		   out.println("<name>");
		   out.println(x);
		   out.println("</name>");
		   out.println("<val>");
		   out.println(y);
		   out.println("</val>");
		}
	   
	   out.println("</root>");
	   }
		
	}


