package org.home.models;

public class SubjectEssence extends Base{
	
	/*select st.idsubject_t stidsubject_t, st.subject_name stsubject_name, st.lang stlang, st.pid stpid,
	si.id siid, si1.id si1id, si1.idUser si1idUser, si1.pid si1pid
							  from words.subject_t st inner join words.subjects_items si 						  
	on st.idsubject_t=si.idsubject 
				inner join words.subjects_items_ si1 on si1.id=si.iditem 
							  order by si1.id, st.lang;*/
	
	private Long stIdSubjectT;
	
	private String stSubjectName;
	
	private Integer stLang;
	
	private Long stPid;
	
	private Long siId;
	
	private Long si1Id;
	
	private Long si1IdUser;
	
	private Long si1Pid;

	
	
	public SubjectEssence() {
		// TODO Auto-generated constructor stub
	}



	public Long getStIdSubjectT() {
		return stIdSubjectT;
	}



	public void setStIdSubjectT(Long stIdSubjectT) {
		this.stIdSubjectT = stIdSubjectT;
	}



	public String getStSubjectName() {
		return stSubjectName;
	}



	public void setStSubjectName(String stSubjectName) {
		this.stSubjectName = stSubjectName;
	}



	public Integer getStLang() {
		return stLang;
	}



	public void setStLang(Integer stLang) {
		this.stLang = stLang;
	}



	public Long getStPid() {
		return stPid;
	}



	public void setStPid(Long stPid) {
		this.stPid = stPid;
	}



	public Long getSiId() {
		return siId;
	}



	public void setSiId(Long siId) {
		this.siId = siId;
	}



	public Long getSi1Id() {
		return si1Id;
	}



	public void setSi1Id(Long si1Id) {
		this.si1Id = si1Id;
	}



	public Long getSi1IdUser() {
		return si1IdUser;
	}



	public void setSi1IdUser(Long si1IdUser) {
		this.si1IdUser = si1IdUser;
	}



	public Long getSi1Pid() {
		return si1Pid;
	}



	public void setSi1Pid(Long si1Pid) {
		this.si1Pid = si1Pid;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((si1Id == null) ? 0 : si1Id.hashCode());
		result = prime * result
				+ ((si1IdUser == null) ? 0 : si1IdUser.hashCode());
		result = prime * result + ((si1Pid == null) ? 0 : si1Pid.hashCode());
		result = prime * result + ((siId == null) ? 0 : siId.hashCode());
		result = prime * result
				+ ((stIdSubjectT == null) ? 0 : stIdSubjectT.hashCode());
		result = prime * result + ((stLang == null) ? 0 : stLang.hashCode());
		result = prime * result + ((stPid == null) ? 0 : stPid.hashCode());
		result = prime * result
				+ ((stSubjectName == null) ? 0 : stSubjectName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectEssence other = (SubjectEssence) obj;
		if (si1Id == null) {
			if (other.si1Id != null)
				return false;
		} else if (!si1Id.equals(other.si1Id))
			return false;
		if (si1IdUser == null) {
			if (other.si1IdUser != null)
				return false;
		} else if (!si1IdUser.equals(other.si1IdUser))
			return false;
		if (si1Pid == null) {
			if (other.si1Pid != null)
				return false;
		} else if (!si1Pid.equals(other.si1Pid))
			return false;
		if (siId == null) {
			if (other.siId != null)
				return false;
		} else if (!siId.equals(other.siId))
			return false;
		if (stIdSubjectT == null) {
			if (other.stIdSubjectT != null)
				return false;
		} else if (!stIdSubjectT.equals(other.stIdSubjectT))
			return false;
		if (stLang == null) {
			if (other.stLang != null)
				return false;
		} else if (!stLang.equals(other.stLang))
			return false;
		if (stPid == null) {
			if (other.stPid != null)
				return false;
		} else if (!stPid.equals(other.stPid))
			return false;
		if (stSubjectName == null) {
			if (other.stSubjectName != null)
				return false;
		} else if (!stSubjectName.equals(other.stSubjectName))
			return false;
		return true;
	}
	
	

}
