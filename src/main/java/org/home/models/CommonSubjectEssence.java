package org.home.models;

public class CommonSubjectEssence extends Base {
/*
 * 
 * select bcs.id bsId, csi.id csiId,  csi.idUser csiIdUser, csi.pid csiPid,
       cs.idCommonSubj csIdCommonSubj, cs.nameCommonSubject,
       cs.lang csLang, l.lang_name, cs.pid csPid, cs1.nameCommonSubject pidNameCommonSubject
from words.commonsubjects cs inner join words.bindcommonsubjects bcs on cs.idCommonSubj=bcs.idComSubj
	 inner join words.commonsubjectsitems csi on csi.id=bcs.idComSubjItem 
     inner join words.lang l on cs.lang=l.idLang
     left join words.commonsubjects cs1 on cs.pid=cs1.idCommonSubj
  order by bcs.idComSubjItem, cs.lang;
 * 
 * 
 * */
	
	private Long csIdCommonSubj;
	
	private String csNameCommonSubject;
	
	private Integer csLang;
	
	private Long csPid;
	
	private Long csiId;
	
	private Long csiIdUser;
	
	private Long csiPid;

	private Long bcsId;
	
	private String csiIdGroup;
	
	public CommonSubjectEssence() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "CommonSubjectEssence [csNameCommonSubject="
				+ csNameCommonSubject + "]";
	}


	public Long getCsIdCommonSubj() {
		return csIdCommonSubj;
	}


	public void setCsIdCommonSubj(Long csIdCommonSubj) {
		this.csIdCommonSubj = csIdCommonSubj;
	}


	public String getCsNameCommonSubject() {
		return csNameCommonSubject;
	}


	public void setCsNameCommonSubject(String csNameCommonSubject) {
		this.csNameCommonSubject = csNameCommonSubject;
	}


	public Integer getCsLang() {
		return csLang;
	}


	public void setCsLang(Integer csLang) {
		this.csLang = csLang;
	}


	public Long getCsPid() {
		return csPid;
	}


	public void setCsPid(Long csPid) {
		this.csPid = csPid;
	}


	public Long getCsiId() {
		return csiId;
	}


	public void setCsiId(Long csiId) {
		this.csiId = csiId;
	}


	public Long getCsiIdUser() {
		return csiIdUser;
	}


	public void setCsiIdUser(Long csiIdUser) {
		this.csiIdUser = csiIdUser;
	}


	public Long getCsiPid() {
		return csiPid;
	}


	public void setCsiPid(Long csiPid) {
		this.csiPid = csiPid;
	}


	public Long getBcsId() {
		return bcsId;
	}


	public void setBcsId(Long bcsId) {
		this.bcsId = bcsId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bcsId == null) ? 0 : bcsId.hashCode());
		result = prime * result
				+ ((csIdCommonSubj == null) ? 0 : csIdCommonSubj.hashCode());
		result = prime * result + ((csLang == null) ? 0 : csLang.hashCode());
		result = prime
				* result
				+ ((csNameCommonSubject == null) ? 0 : csNameCommonSubject
						.hashCode());
		result = prime * result + ((csPid == null) ? 0 : csPid.hashCode());
		result = prime * result + ((csiId == null) ? 0 : csiId.hashCode());
		result = prime * result
				+ ((csiIdUser == null) ? 0 : csiIdUser.hashCode());
		result = prime * result + ((csiPid == null) ? 0 : csiPid.hashCode());
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
		CommonSubjectEssence other = (CommonSubjectEssence) obj;
		if (bcsId == null) {
			if (other.bcsId != null)
				return false;
		} else if (!bcsId.equals(other.bcsId))
			return false;
		if (csIdCommonSubj == null) {
			if (other.csIdCommonSubj != null)
				return false;
		} else if (!csIdCommonSubj.equals(other.csIdCommonSubj))
			return false;
		if (csLang == null) {
			if (other.csLang != null)
				return false;
		} else if (!csLang.equals(other.csLang))
			return false;
		if (csNameCommonSubject == null) {
			if (other.csNameCommonSubject != null)
				return false;
		} else if (!csNameCommonSubject.equals(other.csNameCommonSubject))
			return false;
		if (csPid == null) {
			if (other.csPid != null)
				return false;
		} else if (!csPid.equals(other.csPid))
			return false;
		if (csiId == null) {
			if (other.csiId != null)
				return false;
		} else if (!csiId.equals(other.csiId))
			return false;
		if (csiIdUser == null) {
			if (other.csiIdUser != null)
				return false;
		} else if (!csiIdUser.equals(other.csiIdUser))
			return false;
		if (csiPid == null) {
			if (other.csiPid != null)
				return false;
		} else if (!csiPid.equals(other.csiPid))
			return false;
		return true;
	}


	public String getCsiIdGroup() {
		return csiIdGroup;
	}


	public void setCsiIdGroup(String csiIdGroup) {
		this.csiIdGroup = csiIdGroup;
	}


}
