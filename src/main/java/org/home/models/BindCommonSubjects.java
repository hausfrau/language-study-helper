package org.home.models;

public class BindCommonSubjects extends Base {
	
	private Long id;
	
	private Long idComSubj;
	
	private Long idComSubjItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdComSubj() {
		return idComSubj;
	}

	public void setIdComSubj(Long idComSubj) {
		this.idComSubj = idComSubj;
	}

	public Long getIdComSubjItem() {
		return idComSubjItem;
	}

	public void setIdComSubjItem(Long idComSubjItem) {
		this.idComSubjItem = idComSubjItem;
	}

	@Override
	public String toString() {
		return "BindCommonSubjects [id=" + id + ", idComSubj=" + idComSubj
				+ ", idComSubjItem=" + idComSubjItem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idComSubj ^ (idComSubj >>> 32));
		result = prime * result
				+ (int) (idComSubjItem ^ (idComSubjItem >>> 32));
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
		BindCommonSubjects other = (BindCommonSubjects) obj;
		if (id != other.id)
			return false;
		if (idComSubj != other.idComSubj)
			return false;
		if (idComSubjItem != other.idComSubjItem)
			return false;
		return true;
	}
	
	

}
