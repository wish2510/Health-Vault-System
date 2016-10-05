package vo;

public class UserRecordVO {
	
	private Long userRecordid;
	private Long userid;
	private Long clinicid;
	private Long typeofRcdid;
	private String title;
	private String dateofRcd;
	private String conclusion;
	private String remarks;
	
	
	
	public Long getClinicid() {
		return clinicid;
	}
	public void setClinicid(Long clinicid) {
		this.clinicid = clinicid;
	}
	public Long getUserRecordid() {
		return userRecordid;
	}
	public void setUserRecordid(Long userRecordid) {
		this.userRecordid = userRecordid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getTypeofRcdid() {
		return typeofRcdid;
	}
	public void setTypeofRcdid(Long typeofRcdid) {
		this.typeofRcdid = typeofRcdid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private String attachment;
	private String attachmenttype;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateofRcd() {
		return dateofRcd;
	}
	public void setDateofRcd(String dateofRcd) {
		this.dateofRcd = dateofRcd;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachmenttype() {
		return attachmenttype;
	}
	public void setAttachmenttype(String attachmenttype) {
		this.attachmenttype = attachmenttype;
	}
	
		
}
