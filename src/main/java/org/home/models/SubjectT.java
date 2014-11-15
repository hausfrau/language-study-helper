package org.home.models;

public class SubjectT extends Base {
	
	private Long idSubjectT;
	
	private String subjectName;
	
	private Integer lang;
	
	private Long pid;

	public Long getIdSubjectT() {
		return idSubjectT;
	}

	public void setIdSubjectT(Long idSubjectT) {
		this.idSubjectT = idSubjectT;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getLang() {
		return lang;
	}

	public void setLang(Integer lang) {
		this.lang = lang;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "SubjectT [idSubjectT=" + idSubjectT + ", subjectName="
				+ subjectName + ", lang=" + lang + ", pid=" + pid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSubjectT ^ (idSubjectT >>> 32));
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + (int) (pid ^ (pid >>> 32));
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		SubjectT other = (SubjectT) obj;
		if (idSubjectT != other.idSubjectT)
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (pid != other.pid)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	
	

}
