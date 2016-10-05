package vo;
public class NotesVO {
	public Long noteid;
	public Long userrecordid;
	public String note;
	public String notetype;
	public String notedate;
	public String discription;
	
	public String getNotedate() {
		return notedate;
	}
	public void setNotedate(String notedate) {
		this.notedate = notedate;
	}
	public Long getNoteid() {
		return noteid;
	}
	public void setNoteid(Long noteid) {
		this.noteid = noteid;
	}
	public Long getUserrecordid() {
		return userrecordid;
	}
	public void setUserrecordid(Long userrecordid) {
		this.userrecordid = userrecordid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNotetype() {
		return notetype;
	}
	public void setNotetype(String notetype) {
		this.notetype = notetype;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	

}
