package org.home.models;

public class ItemsT extends Base {
	
	private Long idItemsT;
	
	private Integer idTextType;
	
	private Long idUser;
	
	private Long idSubjItem;

	public Long getidItemsT() {
		return idItemsT;
	}

	public void setidItemsT(Long idItemsT) {
		this.idItemsT = idItemsT;
	}

	public Integer getidTextType() {
		return idTextType;
	}

	public void setidTextType(Integer idTextType) {
		this.idTextType = idTextType;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdSubjItem() {
		return idSubjItem;
	}

	public void setIdSubjItem(Long idSubjItem) {
		this.idSubjItem = idSubjItem;
	}

	@Override
	public String toString() {
		return "ItemsT [idItemsT=" + idItemsT + ", idTextType=" + idTextType
				+ ", idUser=" + idUser + ", idSubjItem=" + idSubjItem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSubjItem ^ (idSubjItem >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + (int) (idItemsT ^ (idItemsT >>> 32));
		result = prime * result
				+ ((idTextType == null) ? 0 : idTextType.hashCode());
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
		ItemsT other = (ItemsT) obj;
		if (idSubjItem != other.idSubjItem)
			return false;
		if (idUser != other.idUser)
			return false;
		if (idItemsT != other.idItemsT)
			return false;
		if (idTextType == null) {
			if (other.idTextType != null)
				return false;
		} else if (!idTextType.equals(other.idTextType))
			return false;
		return true;
	}
	
	

}
