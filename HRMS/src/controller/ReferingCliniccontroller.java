package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReferingClinicdao;
import vo.ReferingClinicVO;
/**
 * Servlet implementation class ReferingCliniccontroller
 */
//@WebServlet("/ReferingCliniccontroller")
public class ReferingCliniccontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReferingCliniccontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		ReferingClinicdao referingClinicdao =new ReferingClinicdao();
		ReferingClinicVO referingClinicVO = new ReferingClinicVO();
		List ls = referingClinicdao.search(referingClinicVO);
		HttpSession session = request.getSession();
		session.setAttribute("ls", ls);
		response.sendRedirect("view/User_CreateRecords.jsp");
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
	    		insert(request, response);
		}
		else if(flag!=null && flag.equals("delete"))
		{	
	//			delete(request, response);
		}
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String clininame = request.getParameter("input.autocompleteclinicname");
		String cliniprimryemailid = request.getParameter("input.autocompleteemailprimary");
		String clinisecondryemilid = request.getParameter("input.autocompleteemailsecondary");
		String cliniponework = request.getParameter("input.autocompletephonework");
		String cliniponehome = request.getParameter("input.autocompletephonehome");
		String cliniponemobile = request.getParameter("input.autocompletephonemobile");
		String clinicounty = request.getParameter("cb_cntry");
		String clinistate = request.getParameter("cb_state");
		String clinicity = request.getParameter("cb_cit");
		
		ReferingClinicVO referingClinicVO =new ReferingClinicVO();
		
		referingClinicVO.setClinicname(clininame);
		referingClinicVO.setClinicprimaryemailid(cliniprimryemailid);
		referingClinicVO.setClinicsecondaryemailid(clinisecondryemilid);
		referingClinicVO.setClinicphonework(cliniponework);
		referingClinicVO.setClinicphonehome(cliniponehome);
		referingClinicVO.setClinicphonemobile(cliniponemobile);
		referingClinicVO.setCliniccountry(clinicounty);
		referingClinicVO.setClinicstate(clinistate);
		referingClinicVO.setCliniccity(clinicity);
		
		ReferingClinicdao referingClinicdao =new ReferingClinicdao();
		referingClinicdao.insert(referingClinicVO);

		response.sendRedirect("view/Add Refering Clinic.jsp");
	}
	
	

}
