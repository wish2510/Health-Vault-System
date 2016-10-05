package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActivityListdao;
import vo.ActivityListVO;

/**
 * Servlet implementation class ActivityListcontroller
 */
//@WebServlet("/ActivityListcontroller")
public class ActivityListcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityListcontroller() {
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
	 //     		search(request, response);
		}
		else if(flag!=null && flag.equals("insert"))
		{
	//    		insert(request, response);
		}

		else if(flag!=null && flag.equals("delete"))
		{
			
	//			delete(request, response);
		}

				}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String activitytype = request.getParameter("");
	String activitydate = request.getParameter("");
	String activityby = request.getParameter("");
	
	ActivityListVO activityListVO =new ActivityListVO();
	
	activityListVO.setActivitytype(activitytype);
	activityListVO.setActivitydate(activitydate);
	activityListVO.setActivityby(activityby);
	
	ActivityListdao activityListdao =new ActivityListdao();
	
	activityListdao.insert(activityListVO);
	
	
	response.sendRedirect("view/Activity list.jsp");
	
	}
	
}
