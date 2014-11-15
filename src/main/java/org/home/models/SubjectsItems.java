package org.home.models;

public class SubjectsItems extends Base {
	
	private Long id;
	
	private Long idItem;
	
	private Long idSubject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Long idSubject) {
		this.idSubject = idSubject;
	}

	@Override
	public String toString() {
		return "SubjectsItems [id=" + id + ", idItem=" + idItem
				+ ", idSubject=" + idSubject + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idItem ^ (idItem >>> 32));
		result = prime * result + (int) (idSubject ^ (idSubject >>> 32));
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
		SubjectsItems other = (SubjectsItems) obj;
		if (id != other.id)
			return false;
		if (idItem != other.idItem)
			return false;
		if (idSubject != other.idSubject)
			return false;
		return true;
	}
	
	

}
