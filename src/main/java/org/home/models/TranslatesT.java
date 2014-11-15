package org.home.models;

public class TranslatesT extends Base {
	
	private Long idItem;
	
	private Long idTranslate;

	private Long idTranslatesT;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdTranslate() {
		return idTranslate;
	}

	public void setIdTranslate(Long idTranslate) {
		this.idTranslate = idTranslate;
	}

	public Long getIdTranslatesT() {
		return idTranslatesT;
	}

	public void setIdTranslatesT(Long idTranslatesT) {
		this.idTranslatesT = idTranslatesT;
	}

	@Override
	public String toString() {
		return "TranslatesT [idItem=" + idItem + ", idTranslate=" + idTranslate
				+ ", idTranslatesT=" + idTranslatesT + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idItem ^ (idItem >>> 32));
		result = prime * result + (int) (idTranslate ^ (idTranslate >>> 32));
		result = prime * result
				+ (int) (idTranslatesT ^ (idTranslatesT >>> 32));
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
		TranslatesT other = (TranslatesT) obj;
		if (idItem != other.idItem)
			return false;
		if (idTranslate != other.idTranslate)
			return false;
		if (idTranslatesT != other.idTranslatesT)
			return false;
		return true;
	}
	
	
}
