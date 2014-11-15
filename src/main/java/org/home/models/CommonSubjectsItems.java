package org.home.models;

public class CommonSubjectsItems extends Base {
	
	private Long id;
	
	private Long idUser;
	
	private Long pid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "CommonSubjectsItems [id=" + id + ", idUser=" + idUser
				+ ", pid=" + pid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + (int) (pid ^ (pid >>> 32));
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
		CommonSubjectsItems other = (CommonSubjectsItems) obj;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}
	
	

}
