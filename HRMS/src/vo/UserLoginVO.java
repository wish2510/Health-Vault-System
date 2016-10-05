package vo;

import java.io.Serializable;

public class UserLoginVO implements Serializable {

	private Long userid;
	private String fstname;
	private String mdlname;
	private String lstname;
	private String username;
	private String password;
	private String regtype;
	private String adddate;
	
	
	
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getFstname() {
		return fstname;
	}
	public void setFstname(String fstname) {
		this.fstname = fstname;
	}
	public String getMdlname() {
		return mdlname;
	}
	public void setMdlname(String mdlname) {
		this.mdlname = mdlname;
	}
	public String getLstname() {
		return lstname;
	}
	public void setLstname(String lstname) {
		this.lstname = lstname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegtype() {
		return regtype;
	}
	public void setRegtype(String regtype) {
		this.regtype = regtype;
	}
		
}
