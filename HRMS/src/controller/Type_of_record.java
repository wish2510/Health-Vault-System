package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Typeofrecorddao;
import vo.Type_Of_RecordVO;

/**
 * Servlet implementation class type_of_record
 */
//@WebServlet("/Type_of_record")
public class Type_of_record extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Type_of_record() {
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
		Typeofrecorddao td = new Typeofrecorddao();
		Type_Of_RecordVO tv =new Type_Of_RecordVO();
		tv.setCategoryofrecordid(Long.valueOf(request.getParameter("rid")));
		
	}

}
