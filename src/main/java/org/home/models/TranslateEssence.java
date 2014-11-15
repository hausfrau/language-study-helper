package org.home.models;

public class TranslateEssence extends Base {
	/*запрос на перевод
	 * SELECT it.iditems_t itIdItemsT, it.idtext_type itIdTextType, it.iduser itIdUser, it.idSubjItem itIdSubjItem,
       lt.idtranslate ltIdTranslate, lt.text ltText, lt.idlang ltIdLang, lt.idgender ltIdGender, 
       lt.plur_ends ltPlurEnds, lt.root_changes ltRootChanges, lt.idSubject_t ltIdSubjectT,
	   tt.iditem ttIdItem, tt.idtranslate ttIdTranslate, tt.idtranslates_t ttIdTranslatesT
FROM words.items_t it, words.locale_translate lt, words.translates_t tt
where tt.iditem = it.iditems_t
  and tt.idtranslate = lt.idtranslate;
	 */
	
	private Long itIdItemsT;
	
	private Integer itIdTextType;
	
	private Long itIdUser;
	
	private Long itIdSubjItem;
	
	private Long ltIdTranslate;
	
	private String ltText;
	
	private Integer ltIdLang;
	
	private Integer ltIdGender;
	
	private String ltPlurEnds;
	
	private String ltRootChanges;
	
	private Long ltIdSubjectT;
	
	private Long ttIdTranslatesT;
	
	private String itIdItemsTGroup;
	
	public TranslateEssence() {
		// TODO Auto-generated constructor stub
	}

	public Integer getItIdTextType() {
		return itIdTextType;
	}

	public void setItIdTextType(Integer itIdTextType) {
		this.itIdTextType = itIdTextType;
	}

	public Long getItIdUser() {
		return itIdUser;
	}

	public void setItIdUser(Long itIdUser) {
		this.itIdUser = itIdUser;
	}

	public Long getItIdSubjItem() {
		return itIdSubjItem;
	}

	public void setItIdSubjItem(Long itIdSubjItem) {
		this.itIdSubjItem = itIdSubjItem;
	}

	public Long getLtIdTranslate() {
		return ltIdTranslate;
	}

	public void setLtIdTranslate(Long ltIdTranslate) {
		this.ltIdTranslate = ltIdTranslate;
	}

	public String getLtText() {
		return ltText;
	}

	public void setLtText(String ltText) {
		this.ltText = ltText;
	}

	public Integer getLtIdLang() {
		return ltIdLang;
	}

	public void setLtIdLang(Integer ltIdLang) {
		this.ltIdLang = ltIdLang;
	}

	public Integer getLtIdGender() {
		return ltIdGender;
	}

	public void setLtIdGender(Integer ltIdGender) {
		this.ltIdGender = ltIdGender;
	}

	public String getLtPlurEnds() {
		return ltPlurEnds;
	}

	public void setLtPlurEnds(String ltPlurEnds) {
		this.ltPlurEnds = ltPlurEnds;
	}

	public String getLtRootChanges() {
		return ltRootChanges;
	}

	public void setLtRootChanges(String ltRootChanges) {
		this.ltRootChanges = ltRootChanges;
	}

	public Long getLtIdSubjectT() {
		return ltIdSubjectT;
	}

	public void setLtIdSubjectT(Long ltIdSubjectT) {
		this.ltIdSubjectT = ltIdSubjectT;
	}

	public Long getTtIdTranslatesT() {
		return ttIdTranslatesT;
	}

	public void setTtIdTranslatesT(Long ttIdTranslatesT) {
		this.ttIdTranslatesT = ttIdTranslatesT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itIdItemsT == null) ? 0 : itIdItemsT.hashCode());
		result = prime * result
				+ ((itIdItemsTGroup == null) ? 0 : itIdItemsTGroup.hashCode());
		result = prime * result
				+ ((itIdSubjItem == null) ? 0 : itIdSubjItem.hashCode());
		result = prime * result
				+ ((itIdTextType == null) ? 0 : itIdTextType.hashCode());
		result = prime * result
				+ ((itIdUser == null) ? 0 : itIdUser.hashCode());
		result = prime * result
				+ ((ltIdGender == null) ? 0 : ltIdGender.hashCode());
		result = prime * result
				+ ((ltIdLang == null) ? 0 : ltIdLang.hashCode());
		result = prime * result
				+ ((ltIdSubjectT == null) ? 0 : ltIdSubjectT.hashCode());
		result = prime * result
				+ ((ltIdTranslate == null) ? 0 : ltIdTranslate.hashCode());
		result = prime * result
				+ ((ltPlurEnds == null) ? 0 : ltPlurEnds.hashCode());
		result = prime * result
				+ ((ltRootChanges == null) ? 0 : ltRootChanges.hashCode());
		result = prime * result + ((ltText == null) ? 0 : ltText.hashCode());
		result = prime * result
				+ ((ttIdTranslatesT == null) ? 0 : ttIdTranslatesT.hashCode());
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
		TranslateEssence other = (TranslateEssence) obj;
		if (itIdItemsT == null) {
			if (other.itIdItemsT != null)
				return false;
		} else if (!itIdItemsT.equals(other.itIdItemsT))
			return false;
		if (itIdItemsTGroup == null) {
			if (other.itIdItemsTGroup != null)
				return false;
		} else if (!itIdItemsTGroup.equals(other.itIdItemsTGroup))
			return false;
		if (itIdSubjItem == null) {
			if (other.itIdSubjItem != null)
				return false;
		} else if (!itIdSubjItem.equals(other.itIdSubjItem))
			return false;
		if (itIdTextType == null) {
			if (other.itIdTextType != null)
				return false;
		} else if (!itIdTextType.equals(other.itIdTextType))
			return false;
		if (itIdUser == null) {
			if (other.itIdUser != null)
				return false;
		} else if (!itIdUser.equals(other.itIdUser))
			return false;
		if (ltIdGender == null) {
			if (other.ltIdGender != null)
				return false;
		} else if (!ltIdGender.equals(other.ltIdGender))
			return false;
		if (ltIdLang == null) {
			if (other.ltIdLang != null)
				return false;
		} else if (!ltIdLang.equals(other.ltIdLang))
			return false;
		if (ltIdSubjectT == null) {
			if (other.ltIdSubjectT != null)
				return false;
		} else if (!ltIdSubjectT.equals(other.ltIdSubjectT))
			return false;
		if (ltIdTranslate == null) {
			if (other.ltIdTranslate != null)
				return false;
		} else if (!ltIdTranslate.equals(other.ltIdTranslate))
			return false;
		if (ltPlurEnds == null) {
			if (other.ltPlurEnds != null)
				return false;
		} else if (!ltPlurEnds.equals(other.ltPlurEnds))
			return false;
		if (ltRootChanges == null) {
			if (other.ltRootChanges != null)
				return false;
		} else if (!ltRootChanges.equals(other.ltRootChanges))
			return false;
		if (ltText == null) {
			if (other.ltText != null)
				return false;
		} else if (!ltText.equals(other.ltText))
			return false;
		if (ttIdTranslatesT == null) {
			if (other.ttIdTranslatesT != null)
				return false;
		} else if (!ttIdTranslatesT.equals(other.ttIdTranslatesT))
			return false;
		return true;
	}

	public String getItIdItemsTGroup() {
		return itIdItemsTGroup;
	}

	public void setItIdItemsTGroup(String itIdItemsTGroup) {
		this.itIdItemsTGroup = itIdItemsTGroup;
	}

	public Long getItIdItemsT() {
		return itIdItemsT;
	}

	public void setItIdItemsT(Long itIdItemsT) {
		this.itIdItemsT = itIdItemsT;
	}

}
