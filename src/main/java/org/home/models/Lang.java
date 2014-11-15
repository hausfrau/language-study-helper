package org.home.models;

public class Lang extends Base {
	
	private Long idLang = null;
	private String langName;
	//private Lang This = this;
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	/*public Lang () {
		this.setInsSql("insert into words.lang(lang_name, idlang) values(?, ?);");
		this.setUpdSql("update words.lang t set t.lang_name = ? where t.idlang = ?");
	}*/

	/*@Override
	public void setId(Long id) {
		super.setId(id);
		this.setIdLang(id);
		
	}*/
	public Long getIdLang() {
		return idLang;
	}

	public void setIdLang(Long idLang) {
		this.idLang = idLang;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	@Override
	public String toString() {
		return "Lang [idLang=" + idLang + ", langName=" + langName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idLang ^ (idLang >>> 32));
		result = prime * result
				+ ((langName == null) ? 0 : langName.hashCode());
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
		Lang other = (Lang) obj;
		if (idLang != other.idLang)
			return false;
		if (langName == null) {
			if (other.langName != null)
				return false;
		} else if (!langName.equals(other.langName))
			return false;
		return true;
	}
	
	/*@Override
	public PreparedStatement bindValues (Connection connection) throws SQLException {
		PreparedStatement ps = null;
		try {
			System.out.println(this.getSql());
			System.out.println("this.isNew()="+this.isNew());
			System.out.println("this.getIdLang()="+this.getIdLang());
			ps = (PreparedStatement) connection.prepareStatement(this.getSql(), new String[] {"lang_name", "idlang"});
			ps.setString(1, this.getLangName());
			if(this.isNew()) {
			ps.setNull(2, Types.LONGVARBINARY); 
			} else {
			      ps.setLong(2, this.getIdLang());
			  }
			return ps;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}*/
}
