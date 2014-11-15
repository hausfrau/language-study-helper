package org.home.models;

public class TextType extends Base {
	
	private Long idTextType;
	
	private String textTypeName;

	public Long getIdTextType() {
		return idTextType;
	}

	public void setIdTextType(Long idTextType) {
		this.idTextType = idTextType;
	}

	public String getTextTypeName() {
		return textTypeName;
	}

	public void setTextTypeName(String textTypeName) {
		this.textTypeName = textTypeName;
	}

	@Override
	public String toString() {
		return "TextType [idTextType=" + idTextType + ", textTypeName="
				+ textTypeName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idTextType ^ (idTextType >>> 32));
		result = prime * result
				+ ((textTypeName == null) ? 0 : textTypeName.hashCode());
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
		TextType other = (TextType) obj;
		if (idTextType != other.idTextType)
			return false;
		if (textTypeName == null) {
			if (other.textTypeName != null)
				return false;
		} else if (!textTypeName.equals(other.textTypeName))
			return false;
		return true;
	}
	
	

}
