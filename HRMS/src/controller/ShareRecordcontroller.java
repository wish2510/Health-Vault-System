package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShareRecorddao;
import dao.UserLogindao;
import vo.ShareRecordVO;
import vo.UserLoginVO;

/**
 * Servlet implementation class ShareRecordcontroller
 */
//@WebServlet("/ShareRecordcontroller")
public class ShareRecordcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String idall=null;
	String idall2 =null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareRecordcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag!=null && flag.equals("user_share"))
		{
			user_share(request,response);
		}
		if(flag!=null && flag.equals("usersharerecordsearch"))
		{
			usersharerecordsearch(request,response);
		}
		if(flag!=null && flag.equals("trusteesearch"))
		{
			trusteesearch(request , response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag!=null && flag.equals("sharerecordinsert"))
		{
			sharerecordinsert(request,response);
		}
		if(flag!=null && flag.equals("deletesharedcontact"))
		{
			deletesharedcontact(request,response);
		}
	}

	private void user_share(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
		String recordid= request.getParameter("rcdid");
		String useridofowner = request.getParameter("useid");
		idall=recordid;
		idall2=useridofowner;
		UserLogindao  logindao = new UserLogindao();
		UserLoginVO loginVO =new UserLoginVO();
		loginVO.setUserid(Long.valueOf(useridofowner));
		
		java.util.List lslogin= logindao.dd(loginVO);
		HttpSession session =request.getSession();
		session.setAttribute("ls",lslogin);	
		
		response.sendRedirect("view/User_sharerecordtoanotheruser.jsp");
	}
	

	private void sharerecordinsert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String useridsharerecord = request.getParameter("selectpatient");
		String userrecordid= idall;
		String useridofowner = idall2;
		
		System.out.println("userid of user who is owner   "+useridofowner);
		System.out.println("userid of user to which send share record   "+useridsharerecord);
		System.out.println("userrecord id   "+userrecordid);
		
		ShareRecordVO shareRecordVO = new ShareRecordVO();
		ShareRecorddao shareRecorddao = new ShareRecorddao();

		shareRecordVO.setUserrecordid(Long.parseLong(userrecordid));
		shareRecordVO.setTrustee(idall2);
		shareRecordVO.setTrustedcontact(useridsharerecord);
		
		shareRecorddao.insert(shareRecordVO);
		
		response.sendRedirect("view/User_Homepage.jsp");
		
	}


	private void usersharerecordsearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		String idser = request.getParameter("idser");
		
		ShareRecordVO shareRecordVO = new ShareRecordVO();
		ShareRecorddao shareRecorddao = new ShareRecorddao();
		
		if(idser == null)
		{
			idser = idall2;
			System.out.println("idser           "+idser);
		}
		shareRecordVO.setTrustee(idser);
		List lscontact = shareRecorddao.searchsharecontact(shareRecordVO);
		
		System.out.println("temp    "+lscontact);
		HttpSession session = request.getSession();
		session.setAttribute("lssearch", lscontact);
		response.sendRedirect("view/User_ShareRecord.jsp");
	}
	

	private void deletesharedcontact(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String[] deleterecord = request.getParameterValues("chk");
		//	String sarchbydate = request.getParameter("searchbydate");

			ShareRecordVO shareRecordVO = new ShareRecordVO();
			ShareRecorddao shareRecorddao = new ShareRecorddao();
						
			for (int i = 0; i < deleterecord.length; i++) {
				System.out.println("Hello     "+deleterecord[i]);
				shareRecordVO.setSharerecordid(Long.valueOf(deleterecord[i]));
				shareRecorddao.deletesharecontact(shareRecordVO);
			}
		usersharerecordsearch(request, response);	
	}
	


	private void trusteesearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String idser = request.getParameter("idser");
		
		ShareRecordVO shareRecordVO = new ShareRecordVO();
		ShareRecorddao shareRecorddao = new ShareRecorddao();
		
		if(idser == null)
		{
			idser = idall2;
			System.out.println("idser           "+idser);
		}
		shareRecordVO.setTrustedcontact(idser);
		List lscontact = shareRecorddao.searchtrustee(shareRecordVO);
		
		System.out.println("temp    "+lscontact);
		HttpSession session = request.getSession();
		session.setAttribute("lssearch", lscontact);
		response.sendRedirect("view/User_Trustee.jsp");

	}


	
}
