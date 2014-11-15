package org.home.models;

public class CommonSubjects extends Base {
	
	private Long idCommonSubj;
	
	private String nameCommonSubject;
	
	private Integer lang;
	
	private Long pid;
	
	private String langName;
	
	private String pidNameCommonSubject;

	public Long getIdCommonSubj() {
		return idCommonSubj;
	}

	public void setIdCommonSubj(Long idCommonSubj) {
		this.idCommonSubj = idCommonSubj;
	}

	public String getNameCommonSubject() {
		return nameCommonSubject;
	}

	public void setNameCommonSubject(String nameCommonSubject) {
		this.nameCommonSubject = nameCommonSubject;
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
		return "CommonSubjects [idCommonSubj=" + idCommonSubj
				+ ", nameCommonSubject=" + nameCommonSubject + ", lang=" + lang
				+ ", pid=" + pid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCommonSubj ^ (idCommonSubj >>> 32));
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime
				* result
				+ ((nameCommonSubject == null) ? 0 : nameCommonSubject
						.hashCode());
		result = prime * result + (int) (pid ^ (pid >>> 32));
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
		CommonSubjects other = (CommonSubjects) obj;
		if (idCommonSubj != other.idCommonSubj)
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (nameCommonSubject == null) {
			if (other.nameCommonSubject != null)
				return false;
		} else if (!nameCommonSubject.equals(other.nameCommonSubject))
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}

	public String getPidNameCommonSubject() {
		return pidNameCommonSubject;
	}

	public void setPidNameCommonSubject(String pidNameCommonSubject) {
		this.pidNameCommonSubject = pidNameCommonSubject;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}
	
	

}
