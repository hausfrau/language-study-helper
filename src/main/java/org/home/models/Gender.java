package org.home.models;

public class Gender extends Base {
	
	private Integer idGender;
	
	private String genderName;

	public Integer getIdGender() {
		return idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	@Override
	public String toString() {
		return "Gender [idGender=" + idGender + ", genderName=" + genderName
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((genderName == null) ? 0 : genderName.hashCode());
		result = prime * result
				+ ((idGender == null) ? 0 : idGender.hashCode());
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
		Gender other = (Gender) obj;
		if (genderName == null) {
			if (other.genderName != null)
				return false;
		} else if (!genderName.equals(other.genderName))
			return false;
		if (idGender == null) {
			if (other.idGender != null)
				return false;
		} else if (!idGender.equals(other.idGender))
			return false;
		return true;
	}
	
	

}
