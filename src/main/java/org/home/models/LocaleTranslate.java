package org.home.models;

/**
 * 
 * 
 * @
 * @author �����
 *
 */
public class LocaleTranslate extends Base {
	
	private Long idTranslate; //sdfsdf
	
	private String text;
	
	private Integer idLang;
	
	private Integer idGender = null;
	
	private String plurEnds = null;;
	
	private String rootChanges = null;;
	
	private Long idSubjectT;

	public Long getIdTranslate() {
		return idTranslate;
	}

	public void setIdTranslate(Long idTranslate) {
		this.idTranslate = idTranslate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getIdLang() {
		return idLang;
	}

	public void setIdLang(Integer idLang) {
		this.idLang = idLang;
	}

	public Integer getIdGender() {
		return idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public String getPlurEnds() {
		return plurEnds;
	}

	public void setPlurEnds(String plurEnds) {
		this.plurEnds = plurEnds;
	}

	public Long getIdSubjectT() { 
		return idSubjectT;
	}

	public void setIdSubjectT(Long idSubjectT) {
		this.idSubjectT = idSubjectT;
	}

	@Override
	public String toString() {
		return "LocaleTranslate [idTranslate=" + idTranslate + ", text=" + text
				+ ", idLang=" + idLang + ", idGender=" + idGender
				+ ", plurEnds=" + plurEnds + ", idSubjectT=" + idSubjectT + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idGender == null) ? 0 : idGender.hashCode());
		result = prime * result + ((idLang == null) ? 0 : idLang.hashCode());
		result = prime * result
				+ ((idSubjectT == null) ? 0 : idSubjectT.hashCode());
		result = prime * result
				+ ((idTranslate == null) ? 0 : idTranslate.hashCode());
		result = prime * result
				+ ((plurEnds == null) ? 0 : plurEnds.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		LocaleTranslate other = (LocaleTranslate) obj;
		if (idGender == null) {
			if (other.idGender != null)
				return false;
		} else if (!idGender.equals(other.idGender))
			return false;
		if (idLang == null) {
			if (other.idLang != null)
				return false;
		} else if (!idLang.equals(other.idLang))
			return false;
		if (idSubjectT == null) {
			if (other.idSubjectT != null)
				return false;
		} else if (!idSubjectT.equals(other.idSubjectT))
			return false;
		if (idTranslate == null) {
			if (other.idTranslate != null)
				return false;
		} else if (!idTranslate.equals(other.idTranslate))
			return false;
		if (plurEnds == null) {
			if (other.plurEnds != null)
				return false;
		} else if (!plurEnds.equals(other.plurEnds))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	public String getRootChanges() {
		return rootChanges;
	}

	public void setRootChanges(String rootChanges) {
		this.rootChanges = rootChanges;
	}
	
	
	
	
	

}
