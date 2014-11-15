package org.home.models;

public class Base {
	
	//private String insSql = "";
	//private String updSql = "";
//	private Long id = null;
//	private Base this_ = this;
	
	private boolean isNew = true;
	//@Autowired
	//EssenceDAOImpl essenceDAO;	
	//@Autowired	
	//ParticularDAOImpl particularDAO;
	
	
	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	/*public String getInsSql() {
		return insSql;
	}

	public void setInsSql(String insSql) {
		this.insSql = insSql;
	}

	public String getUpdSql() {
		return updSql;
	}

	public void setUpdSql(String updSql) {
		this.updSql = updSql;
	}
	
	public void bindValues() {
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}
    
	public String getSql(){
		return this.isNew() ? this.insSql : this.updSql;
	}
	
	public void save(JdbcTemplate jdbcTemplate) {		
		try {
			System.out.println("зашли в базовый сейв");
			System.out.println("jdbcTemplate="+jdbcTemplate);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
			     new PreparedStatementCreator() {
			    	 public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			    		 System.out.println("перед биндваловс");
				    		return this_.bindValues (connection);
				     }
				 }, keyHolder);
			//getKeyHolder(keyHolder);
			if(this.isNew()) {
				System.out.println("keyHolder="+keyHolder);
				System.out.println("keyHolder.getKey()"+keyHolder.getKey());
				System.out.println("новый id="+(long)keyHolder.getKey().intValue());
				this.setId((long)keyHolder.getKey().intValue());
			}
				
		} catch(Exception e) {
				e.printStackTrace();//logger.info("Сохранение",e);
		  }
		//return null;
	}
	
	public PreparedStatement bindValues (Connection connection) throws SQLException {
		System.out.println("базовый bindValues");
		//return connection.prepareStatement("");		
		return null;
	}

	void getKeyHolder (KeyHolder keyHolder) {
	}*/

}
