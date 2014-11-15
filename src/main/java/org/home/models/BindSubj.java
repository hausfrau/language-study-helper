package org.home.models;

public class BindSubj extends Base {
	
	private Long id;
	
	private Long idCommonSubject;
	
	private Long idSubjectT;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCommonSubject() {
		return idCommonSubject;
	}

	public void setIdCommonSubject(Long idCommonSubject) {
		this.idCommonSubject = idCommonSubject;
	}

	public Long getIdSubjectT() {
		return idSubjectT;
	}

	public void setIdSubjectT(Long idSubjectT) {
		this.idSubjectT = idSubjectT;
	}

	@Override
	public String toString() {
		return "BindSubj [id=" + id + ", idCommonSubject=" + idCommonSubject
				+ ", idSubjectT=" + idSubjectT + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ (int) (idCommonSubject ^ (idCommonSubject >>> 32));
		result = prime * result + (int) (idSubjectT ^ (idSubjectT >>> 32));
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
		BindSubj other = (BindSubj) obj;
		if (id != other.id)
			return false;
		if (idCommonSubject != other.idCommonSubject)
			return false;
		if (idSubjectT != other.idSubjectT)
			return false;
		return true;
	}
	
	

}
