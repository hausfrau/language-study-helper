package org.home.models;

public class CommonSubjectsName extends Base {
	
	private Long idCommonSubj;
	
	private String nameCommonSubject;
	
	@Override
	public String toString() {
		return "CommonSubjectsName [idCommonSubj=" + idCommonSubj
				+ ", nameCommonSubject=" + nameCommonSubject + "]";
	}

	public Long getIdCommonSubj() {
		return idCommonSubj;
	}

	public void setIdCommonSubj(Long idCommonSubj) {
		this.idCommonSubj = idCommonSubj;
	}

	public String getNameCommonSubject() {
		return nameCommonSubject;
	}

	public void setNameCommonSubject(String nameCommonSubject) {
		this.nameCommonSubject = nameCommonSubject;
	}


}
