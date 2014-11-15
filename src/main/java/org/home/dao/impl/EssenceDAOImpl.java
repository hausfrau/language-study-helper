package org.home.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.home.dao.EssenceDAO;
import org.home.mapper.BindCommonSubjectsMapper;
import org.home.mapper.CommonSubjectEssenceMapper;
import org.home.mapper.CommonSubjectsItemsMapper;
import org.home.mapper.CommonSubjectsMapper;
import org.home.mapper.ItemsTMapper;
import org.home.mapper.SubjectsItems1Mapper;
import org.home.mapper.SubjectsItemsMapper;
import org.home.mapper.TranslateEssenceMapper;
import org.home.mapper.TranslateTMapper;
import org.home.models.BindCommonSubjects;
import org.home.models.CommonSubjectEssence;
import org.home.models.CommonSubjects;
import org.home.models.CommonSubjectsItems;
import org.home.models.ItemsT;
import org.home.models.SubjectsItems;
import org.home.models.SubjectsItems1;
import org.home.models.TranslateEssence;
import org.home.models.TranslatesT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Exception.class)
@Repository(value = "essenceDAO")
@Service
public class EssenceDAOImpl implements EssenceDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override//
	public Integer createCommonSubject(CommonSubjects cs) {
		String sql = "insert into words.commonsubjects(namecommonsubject, lang, pid) values(?, ?, ?);";
		try{
			if(cs.getNameCommonSubject()==null||cs.getNameCommonSubject().trim().length()==0) {
				throw new Exception("Название общей темы/раздела не может быть пустым!");
			}
			if(cs.getLang()==null||cs.getLang()==0) {
				throw new Exception("Неверно указан язык в названии общей темы/раздела!");
			}
			System.out.println("jdbcTemplate="+jdbcTemplate);
//			return jdbcTemplate.update(sql,cs.getNameCommonSubject(), cs.getLang(), cs.getPid());
			return jdbcTemplate.update(sql,cs.getNameCommonSubject(), cs.getLang(), cs.getPid()==0 ? null : cs.getPid());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием названия общей темы нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием названия общей темы",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public CommonSubjects getCommonSubjectByIdCommonSubj(long idCommonSubj) {
		try {
			//String sql = "select t.idCommonSubj, t.nameCommonSubject, t.lang, t.pid from words.commonsubjects t where t.idCommonSubj = ?";
			String sql = "SELECT cs.idCommonSubj, cs.nameCommonSubject, cs.lang, l.lang_name, cs.pid,"+ 
			             "       cs1.nameCommonSubject pidNameCommonSubject"+
			             "  FROM words.commonsubjects cs "+ 
			             "  left join words.commonsubjects cs1 "+ 
			             "    on cs.pid = cs1.idCommonSubj "+ 
			             "  inner join words.lang l "+
			             "     on cs.lang = l.idlang "+
			             " where cs.idCommonSubj = ? ";
			CommonSubjects result = (CommonSubjects)jdbcTemplate.queryForObject(sql, new Object[]{idCommonSubj}, new CommonSubjectsMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get CommonSubjects by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateCommonSubject(CommonSubjects cs) {
		String sql = "update words.commonsubjects t set t.nameCommonSubject = ?, t.lang = ?, t.pid = ? where t.idCommonSubj = ?";
		try {
			return jdbcTemplate.update(sql, cs.getNameCommonSubject(), cs.getLang(), cs.getPid(), cs.getIdCommonSubj());
		} catch(Exception e) {
			logger.info("CommonSubjects update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteCommonSubject(CommonSubjects cs) {
		String sql = "delete from words.commonsubjects where idCommonSubj = ?";
		try {
			return jdbcTemplate.update(sql, cs.getIdCommonSubj());
		} catch(Exception e) { 
			logger.info("Проблеммы с удалением названия общей темы");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<CommonSubjects> getListCommonSubjects() {
		try {
			//String sql = "select t.idCommonSubj, t.nameCommonSubject, t.lang, t.pid from words.commonsubjects t";
			
			String sql = "SELECT cs.idCommonSubj, cs.nameCommonSubject, cs.lang, l.lang_name, cs.pid,"+ 
		                 "       cs1.nameCommonSubject pidNameCommonSubject"+
		                 "  FROM words.commonsubjects cs "+ 
		                 "  left join words.commonsubjects cs1 "+ 
		                 "    on cs.pid = cs1.idCommonSubj "+ 
		                 "  inner join words.lang l "+
		                 "     on cs.lang = l.idlang "+
		                 "order by 1";
			List<CommonSubjects> list = jdbcTemplate.query(sql,  new CommonSubjectsMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all CommonSubjects:",e);
			e.printStackTrace();
		}
		return null;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, String> getMapCommonSubjects(Integer idLang) {
		try {
			String lang = " ";
			System.out.println("getMapCommonSubjects idLang="+idLang);
			if(idLang != null) {
			   lang =  " where cs.lang = ? ";
			}
			String sql = "SELECT cs.idCommonSubj, cs.nameCommonSubject "+
	                     "FROM words.commonsubjects cs "+lang + 
	                     "order by cs.nameCommonSubject";
			Map<String, String> map = (Map<String, String>)jdbcTemplate.query(sql, new Object[]{idLang},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> pidnameCommonSubject = new LinkedHashMap();
				       while (rs.next()) {
				         String col1 = rs.getString("idCommonSubj");
				         String col2 = rs.getString("nameCommonSubject");
				         pidnameCommonSubject.put(col1, col2);
				       }

			           return pidnameCommonSubject;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Map of name commonsubjects:",e);
			e.printStackTrace();
		}
		return null;
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, String> getMapCommonSubjectsGroup() {
		try {

			
			String sql = "SELECT csi.id csiid, cs.idCommonSubj csidcommonsubj, cs.nameCommonSubject csnamecommonsubject, "+
					     "cs.lang cslang, l.lang_name llangname "+
					     "FROM words.commonsubjects cs, "+
					     "words.commonsubjectsitems csi, "+
					     "words.bindcommonsubjects bcs, "+
					     "words.lang l "+
				         "where bcs.idComSubj=cs.idCommonSubj "+
					     "and bcs.idComSubjItem=csi.id "+
					     "and cs.lang=l.idlang "+
				         "order by bcs.idComSubjItem, cs.lang";
			System.out.println("getMapCommonSubjectsGroup sql "+sql);
			Map<String, String> map = (Map<String, String>)jdbcTemplate.query(sql, new Object[]{},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> nameCommonSubjectGroup = new LinkedHashMap();
						/*Long idItem = (long)0;
						String col1 = "";
						String col2 = "";
						int col = 0;*/
				        String col1 = "";
						String col2 = "";
				       while (rs.next()) {
					         col1 = rs.getString("csiid");
					         col2 = rs.getString("csnamecommonsubject")+" ("+rs.getString("llangname")+"); ";
					         
				    	  if(nameCommonSubjectGroup.get(col1)!=null) {
				    		  col2 = nameCommonSubjectGroup.get(col1)+" "+col2; 
				    	  }
				    	  nameCommonSubjectGroup.put(col1, col2);
				    	   
				    	   /*nameCommonSubjectGroup.put(rs.getString("csiid"), nameCommonSubjectGroup.get(rs.getString("csiid"))==null ? 
				    			   (nameCommonSubjectGroup.get(rs.getString("csiid"))+" "+rs.getString("csnamecommonsubject")+" ("+rs.getString("llangname")+"); " )
				    			   : (rs.getString("csnamecommonsubject")+" ("+rs.getString("llangname")+"); "));*/
				    	   /*if(col==0) {
				    		   idItem = rs.getLong("csiid"); 
				    	   }
				       
				    	 if(rs.getLong("csiid")==idItem) {  
				         col1 = col1+rs.getString("csiid");
				         col2 = col2+rs.getString("csnamecommonsubject")+" ("+rs.getString("llangname")+"); ";
				         idItem = rs.getLong("csiid"); 
				         col++;
				         } else {
				        	 pidnameCommonSubject.put(col1, col2); 
				        	 col1 = rs.getString("csiid");
					         col2 = rs.getString("csnamecommonsubject")+" ("+rs.getString("llangname")+"); ";
					         idItem = rs.getLong("csiid"); 
					         col++;
					        
				         }*/
				    	 
				       }
				       //pidnameCommonSubject.put(col1, col2);
			           return nameCommonSubjectGroup;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Map of name commonsubjectsgroup:",e);
			e.printStackTrace();
		}
		return null;
	}	
	
	
	
	public CommonSubjects saveCommonSubject(final CommonSubjects cs) {// throws Exception {
		final String sql = cs.isNew() ? 
				"insert into words.commonsubjects(namecommonsubject, lang, pid, idCommonSubj) values(?, ?, ?, ?);" : 
				"update words.commonsubjects t set t.nameCommonSubject = ?, t.lang = ?, t.pid = ? where t.idCommonSubj = ?";
				try{
					if(cs.getNameCommonSubject()==null||cs.getNameCommonSubject().trim().length()==0) {
						throw new Exception("Название общей темы/раздела не может быть пустым!");
					}
					if(cs.getLang()==null||cs.getLang()==0) {
						throw new Exception("Неверно указан язык в названии общей темы/раздела!");
					}
					KeyHolder keyHolder = new GeneratedKeyHolder();
					jdbcTemplate.update(new PreparedStatementCreator() {
											public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
												PreparedStatement ps = connection.prepareStatement(sql, new String[] {"namecommonsubject", "lang", "pid", "idCommonSubj"});
												ps.setString(1, cs.getNameCommonSubject());
												ps.setLong(2, cs.getLang());
												ps.setLong(3, cs.getPid());
												if(cs.isNew()) {
													ps.setNull(4,  Types.LONGNVARCHAR);
												} else {
													ps.setLong(4,  cs.getIdCommonSubj());
												}
												return ps;
											}
										}, keyHolder);
					if(cs.isNew()) {
						cs.setIdCommonSubj((long)keyHolder.getKey().intValue());
					 }
					
					return cs;
				} catch(Exception e) {
					logger.info("Сохранение общей темы",e);
					e.printStackTrace();
				}
			return null;
	}	
	
	@Override//
	public Integer createCommonSubjectsItem(CommonSubjectsItems csi) {
		String sql = "insert into words.commonsubjectsitems(idUser,pid) values(?, ?);";
		try{
//			return jdbcTemplate.update(sql,csi.getIdUser(), csi.getPid());
			if(csi.getIdUser()==null||csi.getIdUser()==0) {
				throw new Exception("Пользователь некорректен!");
			}
			return jdbcTemplate.update(sql,csi.getIdUser(), csi.getPid()==0 ? null : csi.getPid() );
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием общей темы нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием общей темы",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public CommonSubjectsItems getCommonSubjectsItemById(long id) {
		try {
			String sql = "select t.id, t.idUser, t.pid from words.commonsubjectsitems t where t.id = ?";
			CommonSubjectsItems result = (CommonSubjectsItems)jdbcTemplate.queryForObject(sql, new Object[]{id}, new CommonSubjectsItemsMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get CommonSubjectsItems by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateCommonSubjectsItem(CommonSubjectsItems csi) {
		String sql = "update words.commonsubjectsitems t set t.idUser = ?, t.pid = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, csi.getIdUser(), csi.getPid(), csi.getId());
		} catch(Exception e) {
			logger.info("CommonSubjectsItems update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteCommonSubjectsItem(CommonSubjectsItems csi) {
		String sql = "delete from words.commonsubjectsitems where id = ?";
		try {
		    return jdbcTemplate.update(sql, csi.getId());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением общей темы");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<CommonSubjectsItems> getListCommonSubjectsItems() {
		try {
			String sql = "select t.id, t.idUser, t.pid from words.commonsubjectsitems t";
			List<CommonSubjectsItems> list = jdbcTemplate.query(sql,  new CommonSubjectsItemsMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all CommonSubjectsItems:",e);
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public CommonSubjectsItems saveCommonSubjectsItems(final CommonSubjectsItems csi) {
		final String sql = csi.isNew() ? 
				"insert into words.commonsubjectsitems(idUser, pid, id) values(?, ?, ?);" : 
				"update words.commonsubjectsitems t set t.idUser = ?, t.pid = ? where t.id = ?";
				try{
					if(csi.getIdUser()==null||csi.getIdUser()==0) {
						throw new Exception("Пользователь некорректен!");
					}
					KeyHolder keyHolder = new GeneratedKeyHolder();
					jdbcTemplate.update(new PreparedStatementCreator() {
											public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
												PreparedStatement ps = connection.prepareStatement(sql, new String[] {"idUser, pid, id"});
												ps.setLong(1, csi.getIdUser());
												ps.setLong(2, csi.getPid()==0 ? null : csi.getPid());
												if(csi.isNew()) {
													ps.setNull(3,  Types.LONGNVARCHAR);
												} else {
													ps.setLong(3,  csi.getId());
												}
												return ps;
											}
										}, keyHolder);
					if(csi.isNew()) {
						csi.setId((long)keyHolder.getKey().intValue());
					 }
					return csi;
				} catch(Exception e) {
					logger.info("Сохранение сущности общей темы",e);
					e.printStackTrace();
				}
			return null;
	}
	
	
	@Override//
	public Integer createBindCommonSubject(BindCommonSubjects bcs) {
		String sql = "insert into words.bindcommonsubjects(idComSubj,idComSubjItem) values(?, ?);";
		try{
			if(bcs.getIdComSubj()==null||bcs.getIdComSubj()==0) {
				throw new Exception("Идентификатор общей темы/раздела указан неверно!");
			}
			if(bcs.getIdComSubjItem()==null||bcs.getIdComSubjItem()==0) {
				throw new Exception("Идентификатор сущности общей темы/раздела указан неверно!");
			}
			return jdbcTemplate.update(sql,bcs.getIdComSubj(), bcs.getIdComSubjItem());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием связи общей темы и ее названия нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием связи общей темы и ее названия",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public BindCommonSubjects getBindCommonSubjectById(long id) {
		try {
			String sql = "select t.id, t.idComSubj, t.idComSubjItem from words.bindcommonsubjects t where t.id = ?";
			BindCommonSubjects result = (BindCommonSubjects)jdbcTemplate.queryForObject(sql, new Object[]{id}, new BindCommonSubjectsMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get BindCommonSubjects by id:",e);
		}
		return null;
	}

	@Override
	public CommonSubjectsItems getPidCommonSubjectItemsFromCommonSubjects(long id) {
		try {
			/*String sql = "select csi.id, csi.idUser, csi.pid from  words.commonsubjectsitems csi, words.bindcommonsubjects bcs"+
                         " where csi.id = bcs.idComSubjItem"+
                         "   and bcs.idComSubj = ?";*/
			String sql = "select csi.id, csi.idUser, csi.pid "+
						 "from words.commonsubjects cs1, "+
						 "words.commonsubjectsitems csi, "+
						 "words.bindcommonsubjects bcs "+
						 "where  bcs.idComSubj = cs1.idCommonSubj "+
						 "and bcs.idComSubjItem = csi.id "+
						 "and cs1.idCommonSubj=( "+
						 "	select cs.pid from words.commonsubjects cs where cs.idCommonSubj=?)";
			System.out.println("getPidCommonSubjectItemsFromCommonSubjects "+sql);
			CommonSubjectsItems result = (CommonSubjectsItems)jdbcTemplate.queryForObject(sql, new Object[]{id}, new CommonSubjectsItemsMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get PidCommonSubjectItems From CommonSubjects:",e);
		}
		return null;
	}	
	
	@Override//
	public Integer updateBindCommonSubject(BindCommonSubjects bcs) {
		String sql = "update words.bindcommonsubjects t set t.idComSubj = ?, t.idComSubjItem = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, bcs.getIdComSubj(), bcs.getIdComSubjItem(), bcs.getId());
		} catch(Exception e) {
			logger.info("BindCommonSubjects update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteBindCommonSubject(BindCommonSubjects bcs) {
		String sql = "delete from words.bindcommonsubjects where id = ?";
		try {
		    return jdbcTemplate.update(sql, bcs.getId());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением связи общей темы и ее названия");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<BindCommonSubjects> getListBindsCommonSubjects() {
		try {
			String sql = "select t.id, t.idComSubj, t.idComSubjItem from words.bindcommonsubjects t";
			List<BindCommonSubjects> list = jdbcTemplate.query(sql,  new BindCommonSubjectsMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all BindCommonSubjects:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BindCommonSubjects saveBindCommonSubjects(final BindCommonSubjects bcs) {
		final String sql = bcs.isNew() ? 
				"insert into words.bindcommonsubjects(idComSubj,idComSubjItem, id) values(?, ?, ?);" : 
				"update words.bindcommonsubjects t set t.idComSubj = ?, t.idComSubjItem = ? where t.id = ?";
				try{
					if(bcs.getIdComSubj()==null||bcs.getIdComSubj()==0) {
						throw new Exception("Идентификатор общей темы/раздела указан неверно!");
					}
					if(bcs.getIdComSubjItem()==null||bcs.getIdComSubjItem()==0) {
						throw new Exception("Идентификатор сущности общей темы/раздела указан неверно!");
					}
					KeyHolder keyHolder = new GeneratedKeyHolder();
					jdbcTemplate.update(new PreparedStatementCreator() {
											public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
												PreparedStatement ps = connection.prepareStatement(sql, new String[] {"idComSubj,idComSubjItem, id"});
												ps.setLong(1, bcs.getIdComSubj());
												ps.setLong(2, bcs.getIdComSubjItem());
												if(bcs.isNew()) {
													ps.setNull(3,  Types.LONGNVARCHAR);
												} else {
													ps.setLong(3,  bcs.getId());
												}
												return ps;
											}
										}, keyHolder);
					if(bcs.isNew()) {
						bcs.setId((long)keyHolder.getKey().intValue());
					 }
					return bcs;
				} catch(Exception e) {
					e.printStackTrace();
					logger.info("Сохранение связи сущности общей темы и ее названия",e);
				}
			return null;
	}	
	
	@Override//
	public Integer createSubjectsItems(SubjectsItems si) {
		String sql = "insert into words.subjects_items(idsubject, iditem) values(?, ?);";
		try{
			if(si.getIdSubject()==null||si.getIdSubject()==0) {
				throw new Exception("Идентификатор пользовательской темы/раздела указан неверно!");
			}
			if(si.getIdItem()==null||si.getIdItem()==0) {
				throw new Exception("Идентификатор сущности пользовательской темы/раздела указан неверно!");
			}
			return jdbcTemplate.update(sql, si.getIdSubject(), si.getIdItem());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием связи пользовательской темы и ее названия нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием связи пользовательской темы и ее названия",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public SubjectsItems getSubjectItemById(long id) {
		try {
			String sql = "select t.id, t.idsubject, t.iditem from words.subjects_items t where t.id = ?";
			SubjectsItems result = (SubjectsItems)jdbcTemplate.queryForObject(sql, new Object[]{id}, new SubjectsItemsMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get SubjectsItems by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateSubjectItem(SubjectsItems si) {
		String sql = "update words.subjects_items t set t.idsubject = ?, t.iditem = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, si.getIdSubject(), si.getIdItem(), si.getId());
		} catch(Exception e) {
			logger.info("SubjectsItems update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteSubjectItem(SubjectsItems si) {
		String sql = "delete from words.subjects_items where id = ?";
		try {
		    return jdbcTemplate.update(sql, si.getId());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением связи пользовательской темы и ее названия");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<SubjectsItems> getListSubjectsItems() {
		try {
			String sql = "select t.id, t.idsubject, t.iditem from words.subjects_items t";
			List<SubjectsItems> list = jdbcTemplate.query(sql,  new SubjectsItemsMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all SubjectsItems:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer createSubjectItem1(SubjectsItems1 si1) {
		String sql = "insert into words.subjects_items_(idUser,pid) values(?, ?);";
		try{
			if(si1.getIdUser()==null||si1.getIdUser()==0) {
				throw new Exception("Пользователь некорректен!");
			}
			return jdbcTemplate.update(sql,si1.getIdUser(), si1.getPid()==0 ? null : si1.getPid() );
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием пользовательской темы/раздела нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием пользовательской темы/раздела",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public SubjectsItems1 getSubjectItem1ById(long id) {
		try {
			String sql = "select t.id, t.idUser, t.pid from words.subjects_items_ t where t.id = ?";
			SubjectsItems1 result = (SubjectsItems1)jdbcTemplate.queryForObject(sql, new Object[]{id}, new SubjectsItems1Mapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get SubjectItem1 by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateSubjectItem1(SubjectsItems1 si1) {
		String sql = "update words.subjects_items_ t set t.idUser = ?, t.pid = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, si1.getIdUser(), si1.getPid(), si1.getId());
		} catch(Exception e) {
			logger.info("SubjectsItem1s update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteSubjectItem1(SubjectsItems1 si1) {
		String sql = "delete from words.subjects_items_ where id = ?";
		try {
		    return jdbcTemplate.update(sql, si1.getId());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением пользовательской темы/раздела");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<SubjectsItems1> getListSubjectsItems1() {
		try {
			String sql = "select t.id, t.idUser, t.pid from words.subjects_items_ t";
			List<SubjectsItems1> list = jdbcTemplate.query(sql,  new SubjectsItems1Mapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all SubjectsItems1:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer createItemT(ItemsT it) {
		String sql = "insert into words.items_t(idtext_type, iduser, idSubjItem) values(?, ?, ?);";
		try{
			if(it.getIdUser()==null||it.getIdUser()==0) {
				throw new Exception("Пользователь некорректен!");
			}
			if(it.getidTextType()==null||it.getidTextType()==0) {
				throw new Exception("Тип текста не выбран!");
			}
			if(it.getIdSubjItem()==null||it.getIdSubjItem()==0) {
				throw new Exception("Текст не прикреплен к теме!");
			}
			return jdbcTemplate.update(sql, it.getidTextType(), it.getIdUser(), it.getIdSubjItem() );
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием сущности текста нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием сущности текста",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public ItemsT getItemsTByIdItemsT(long idItemsT) {
		try {
			String sql = "select t.iditems_t, t.idtext_type, t.iduser, t.idSubjItem  from words.items_t t where t.iditems_t = ?";
			ItemsT result = (ItemsT)jdbcTemplate.queryForObject(sql, new Object[]{idItemsT}, new ItemsTMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get ItemsT by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateItemT(ItemsT it) {
		String sql = "update words.items_t t set t.idtext_type = ?, t.iduser = ?, t.idSubjItem where t.iditems_t = ?";
		try {
			return jdbcTemplate.update(sql, it.getidTextType(), it.getIdUser(), it.getIdSubjItem(), it.getidItemsT());
		} catch(Exception e) {
			logger.info("ItemsT update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteItemT(ItemsT it) {
		String sql = "delete from words.items_t where iditems_t = ?";
		try {
		    return jdbcTemplate.update(sql, it.getidItemsT());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением сущности текста");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<ItemsT> getListItemsT() {
		try {
			String sql = "select t.iditems_t, t.idtext_type, t.iduser, t.idSubjItem from words.items_t t";
			List<ItemsT> list = jdbcTemplate.query(sql,  new ItemsTMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all ItemsT:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer createTranslateT(TranslatesT tt) {
		String sql = "insert into words.translates_t(iditem, idtranslate) values(?, ?);";
		try{
			if(tt.getIdItem()==null||tt.getIdItem()==0) {
				throw new Exception("Идентификатор сущности текста некорректен!");
			}
			if(tt.getIdTranslate()==null||tt.getIdTranslate()==0) {
				throw new Exception("Идентификатор текста некорректен!");
			}
			return jdbcTemplate.update(sql, tt.getIdItem(), tt.getIdTranslate());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием связи сущности текста и текстом нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием связи сущности текста и текстом",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public TranslatesT getTranslateTByIdTranslatesT(long id) {
		try {
			String sql = "select t.idtranslates_t, t.iditem, t.idtranslate  from words.translates_t t where t.idtranslates_t = ?";
			TranslatesT result = (TranslatesT)jdbcTemplate.queryForObject(sql, new Object[]{id}, new TranslateTMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get TranslatesT by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateTranslateT(TranslatesT tt) {
		String sql = "update words.translates_t t set t.iditem = ?, t.idtranslate = ? where t.idtranslates_t = ?";
		try {
			return jdbcTemplate.update(sql, tt.getIdItem(), tt.getIdTranslate(), tt.getIdTranslatesT());
		} catch(Exception e) {
			logger.info("TranslatesT update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteTranslatesT(TranslatesT tt) {
		String sql = "delete from words.translates_t where idtranslates_t = ?";
		try {
		    return jdbcTemplate.update(sql, tt.getIdTranslatesT());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением связи сущности текста и текстом");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<TranslatesT> getListTranslatesT() {
		try {
			String sql = "select t.idtranslates_t, t.iditem, t.idtranslate from words.translates_t  t";
			List<TranslatesT> list = jdbcTemplate.query(sql,  new TranslateTMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all TranslatesT:",e);
			e.printStackTrace();
		}
		return null;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	public CommonSubjectEssence saveCommonSubjectEssence(final CommonSubjectEssence cse) {// throws Exception {
		
	
		//CommonSubjectEssence cse = cse;
		final String sqlCS = cse.isNew() ? 
				"insert into words.commonsubjects(namecommonsubject, lang, pid, idCommonSubj) values(?, ?, ?, ?);" : 
				"update words.commonsubjects t set t.nameCommonSubject = ?, t.lang = ?, t.pid = ? where t.idCommonSubj = ?";
		final String sqlCSI = cse.isNew() ? 
				"insert into words.commonsubjectsitems(idUser, pid, id) values(?, ?, ?);" : 
				"update words.commonsubjectsitems t set t.idUser = ?, t.pid = ? where t.id = ?";
		final String sqlBCS = cse.isNew() ? 
				"insert into words.bindcommonsubjects(idComSubj,idComSubjItem, id) values(?, ?, ?);" : 
				"update words.bindcommonsubjects t set t.idComSubj = ?, t.idComSubjItem = ? where t.id = ?";
		
				try{
					if(cse.getCsNameCommonSubject()==null||cse.getCsNameCommonSubject().trim().length()==0) {
						throw new Exception("Название общей темы/раздела не может быть пустым!");
					}
					if(cse.getCsLang()==null||cse.getCsLang()==0) {
						throw new Exception("Неверно указан язык в названии общей темы/раздела!");
					}
					KeyHolder keyHolderCS = new GeneratedKeyHolder();
					System.out.println("sqlCS = "+sqlCS);
					jdbcTemplate.update(new PreparedStatementCreator() {
											public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
												PreparedStatement psCS = connection.prepareStatement(sqlCS, new String[] {"namecommonsubject", "lang", "pid", "idCommonSubj"});
												psCS.setString(1, cse.getCsNameCommonSubject());
												psCS.setLong(2, cse.getCsLang());
												if(cse.getCsPid()==null||cse.getCsPid()==0) {
													psCS.setNull(3,  Types.LONGNVARCHAR);
												} else {
													psCS.setLong(3, cse.getCsPid());
												}
												if(cse.isNew()) {
													psCS.setNull(4,  Types.LONGNVARCHAR);
												} else {
													psCS.setLong(4,  cse.getCsIdCommonSubj());
												}
												return psCS;
											}
										}, keyHolderCS);
					if(cse.isNew()) {
						cse.setCsIdCommonSubj((long)keyHolderCS.getKey().intValue());
					 }
				    /*} catch(Exception e) {
					  logger.info("Сохранение общей темы",e);
				    }*/
					
				    System.out.println("cse.CsIdCommonSubj"+cse.getCsIdCommonSubj());
					/*//вычисление pid сущности общей темы по pid названия общей темы
					
				    long pidCommonSubjectItems = getCommonSubjectItemsFromCommonSubjects(cse.getCsIdCommonSubj()).getPid();
					cse.setCsiPid(pidCommonSubjectItems);*/
				   // System.out.println("cse.CsiPid"+cse.getCsiPid());
					System.out.println("sqlCSI = "+sqlCSI);
					
					//try{
					//	if(cse.getCsiIdUser()==null||cse.getCsiIdUser()==0) {
					//				throw new Exception("Пользователь некорректен!");
					//	}
					    KeyHolder keyHolderCSI = new GeneratedKeyHolder();
						jdbcTemplate.update(new PreparedStatementCreator() {
												public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
													PreparedStatement psCSI = connection.prepareStatement(sqlCSI, new String[] {"idUser, pid, id"});
													psCSI.setLong(1, cse.getCsiIdUser());
													//psCSI.setLong(2, cse.getCsiPid()==0 ? null : cse.getCsiPid());
													if(cse.getCsiPid()==null||cse.getCsiPid()==0) {
														psCSI.setNull(2,  Types.LONGNVARCHAR);
													} else {
														psCSI.setLong(2,  cse.getCsiPid());
													}
													
													if(cse.isNew()) {
														psCSI.setNull(3,  Types.LONGNVARCHAR);
													} else {
														psCSI.setLong(3,  cse.getCsiId());
													}
													return psCSI;
												}
											}, keyHolderCSI);
					 if(cse.isNew()) {
						 cse.setCsiId((long)keyHolderCSI.getKey().intValue());
					 }
					//} catch(Exception e1) {
			//			logger.info("Сохранение общей темы",e1);
				//	}
					System.out.println("cse.CsiId"+cse.getCsiId()); 
					
					 /*try{
						 if(cse.getCsIdCommonSubj()==null||cse.getCsIdCommonSubj()==0) {
							 throw new Exception("Идентификатор общей темы/раздела указан неверно!");
						 }
						 if(cse.getCsiId()==null||cse.getCsiId()==0) {
							 throw new Exception("Идентификатор сущности общей темы/раздела указан неверно!");
						 }*/
					System.out.println("sqlBCS = "+sqlBCS);
						 KeyHolder keyHolderBCS = new GeneratedKeyHolder();
						 jdbcTemplate.update(new PreparedStatementCreator() {
						 					 	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						 					 		PreparedStatement psBCS = connection.prepareStatement(sqlBCS, new String[] {"idComSubj,idComSubjItem, id"});
													psBCS.setLong(1, cse.getCsIdCommonSubj());
													psBCS.setLong(2, cse.getCsiId());
													if(cse.isNew()) {
														psBCS.setNull(3,  Types.LONGNVARCHAR);
													} else {
														psBCS.setLong(3,  cse.getBcsId());
													}
													return psBCS;
											 }
						 }, keyHolderBCS);
						 if(cse.isNew()) {
							 cse.setBcsId((long)keyHolderBCS.getKey().intValue());
						 }	
							System.out.println("cse.BcsId"+cse.getBcsId()); 
							
					//вычисление pid сущности общей темы по pid названия общей темы
					
					long pidCommonSubjectItems = getPidCommonSubjectItemsFromCommonSubjects(cse.getCsIdCommonSubj()).getId();
					cse.setCsiPid(pidCommonSubjectItems);	
				    System.out.println("cse.CsiPid"+cse.getCsiPid());
				    updateCommonSubjectsItemByPid(cse.getCsiId(), cse.getCsiPid());
					return cse;
				    } catch(Exception e2) {
				    	e2.printStackTrace();
					  logger.info("Сохранение общей темы",e2);
				    } 
			return null;
	}
	
	@Override
	public List<List<CommonSubjectEssence>> getListCommonSubjectEssences() {
		
		List<List<CommonSubjectEssence>> list = new ArrayList<List<CommonSubjectEssence>>();
		for(CommonSubjectsItems item : getListCommonSubjectsItems()) {
			list.add(getRowCommonSubjectEssence(item.getId()));
		}
		return list;
	}
	

	private List<CommonSubjectEssence> getRowCommonSubjectEssence(Long id) {
		try {
			String where = (id == null) ? "" : (" where csi.id = "+id+"  ");
			String sql = "select bcs.id bcsId, csi.id csiId,  csi.idUser csiIdUser, csi.pid csiPid, "+
						 "		 cs.idCommonSubj csIdCommonSubj, cs.nameCommonSubject csNameCommonSubject, "+
		                 "		 cs.lang csLang, cs.pid csPid, cs1.nameCommonSubject pidNameCommonSubject "+
		                 "from words.commonsubjects cs inner join words.bindcommonsubjects bcs on cs.idCommonSubj=bcs.idComSubj "+
			             "inner join words.commonsubjectsitems csi on csi.id=bcs.idComSubjItem "+
			             "left join words.commonsubjects cs1 on cs.pid=cs1.idCommonSubj "+where+
		                 "order by bcs.idComSubjItem, cs.lang";
			System.out.println("where = "+where+" sql = "+sql);
			List<CommonSubjectEssence> list = jdbcTemplate.query(sql,  new CommonSubjectEssenceMapper());
			
			System.out.println("list.size() = "+list.size());
			return list;
		} catch (Exception e) {
			logger.info("List of all CommonSubjectEssence from CommonSubjectsItems:",e);
			e.printStackTrace();
		}
		return null;
		
		
	}
//Поиск родительской темы
	@Override
	public CommonSubjectEssence getCommonSubjectEssenceByBindCommonSubjectId(long bcsId) {
		try {
			String sql = "select bcs.id bcsId, csi.id csiId,  csi.idUser csiIdUser, csi.pid csiPid, "+
					     "cs.idCommonSubj csIdCommonSubj, cs.nameCommonSubject csNameCommonSubject, "+
	                     "cs.lang csLang, cs.pid csPid, cs1.nameCommonSubject pidNameCommonSubject "+
	                     "from words.commonsubjects cs inner join words.bindcommonsubjects bcs on cs.idCommonSubj=bcs.idComSubj "+
		                 "inner join words.commonsubjectsitems csi on csi.id=bcs.idComSubjItem "+
		                 "left join words.commonsubjects cs1 on cs.pid=cs1.idCommonSubj "+
		                 "where bcs.id = ? "+
	                     "order by bcs.idComSubjItem, cs.lang";
			System.out.println("getCommonSubjectEssenceByBindCommonSubjectId bcsId = "+bcsId+" sql = "+sql);
			CommonSubjectEssence result = (CommonSubjectEssence)jdbcTemplate.queryForObject(sql, new Object[]{bcsId}, new CommonSubjectEssenceMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get CommonSubjectEssence by bcsId:",e);
		}
		return null;
	}
	
	@Override
	public Integer updateCommonSubjectsItemByPid(Long id, Long pid) {
		String sql = "update words.commonsubjectsitems t set t.pid = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, (pid==0 ? null : pid), id);
		} catch(Exception e) {
			logger.info("CommonSubjectsItems update:",e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public TranslateEssence saveTranslateEssence(final TranslateEssence te) {

		final String sqlLT = te.isNew() ? 
				"insert into words.locale_translate(text, idlang, idgender, plur_ends, root_changes, idSubject_t, idtranslate) values(?, ?, ?, ?, ?, ?, ?);" : 
				"update words.locale_translate t set t.text = ?, t.idlang = ?, t.idgender = ?, t.plur_ends = ?, t.root_changes = ?, t.idSubject_t = ? where t.idtranslate = ?";
		final String sqlIT = (te.isNew()&&(te.getItIdItemsT()==null||te.getItIdItemsT()==0) ) ? 
				"insert into words.items_t(idtext_type, iduser, idSubjItem, iditems_t) values(?, ?, ?, ?);" : 
				"update words.items_t t set t.idtext_type = ?, t.iduser = ?, t.idSubjItem = ? where t.iditems_t = ?";
		final String sqlTT = te.isNew() ? 
				"insert into words.translates_t(iditem, idtranslate, idtranslates_t) values(?, ?, ?);" : 
				"update words.translates_t t set t.iditem = ?, t.idtranslate = ? where t.idtranslates_t = ?";
		
		
		
				try{
					if(te.getLtText()==null||te.getLtText().trim().length()==0) {
						throw new Exception("Текст не может быть пустым!");
					}
					if(te.getLtIdLang()==null||te.getLtIdLang()==0) {
						throw new Exception("Неверно указан язык текста!");
					}
					if(te.getLtIdSubjectT()==null||te.getLtIdSubjectT()==0) {
						throw new Exception("Нет привязки текста к пользовательской теме/разделу!");
					}
					KeyHolder keyHolderLT = new GeneratedKeyHolder();
					System.out.println("sqlLT= "+sqlLT);
					System.out.println("te.getLtText()= "+te.getLtText());
					System.out.println("te.getLtIdLang()= "+te.getLtIdLang());
					System.out.println("te.getLtIdGender()= "+te.getLtIdGender());
					System.out.println("te.getLtPlurEnds()= "+te.getLtPlurEnds());
					System.out.println("te.getLtRootChanges()= "+te.getLtRootChanges());
					System.out.println("te.getLtIdSubjectT()= "+te.getLtIdSubjectT());
					System.out.println("te.getLtIdTranslate()= "+te.getLtIdTranslate());
					jdbcTemplate.update(new PreparedStatementCreator() {
											public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
												PreparedStatement psLT = connection.prepareStatement(sqlLT, new String[] {"text", "idlang", "idgender", "plur_ends", "root_changes", "idSubject_t, idtranslate"});
												psLT.setString(1, te.getLtText());												
												psLT.setInt(2, te.getLtIdLang());
												if(te.getLtIdGender()==null||te.getLtIdGender()==0) {
													psLT.setNull(3, Types.LONGNVARCHAR);
												} else {
													psLT.setInt(3, te.getLtIdGender());
												}
												if(te.getLtPlurEnds()==null||te.getLtPlurEnds().length()==0) {
													psLT.setNull(4, Types.LONGVARCHAR);
												} else {
													psLT.setString(4, te.getLtPlurEnds());
												}
												
												if(te.getLtRootChanges()==null||te.getLtRootChanges().length()==0) {
													psLT.setNull(5, Types.LONGVARCHAR);
												} else {
													psLT.setString(5, te.getLtRootChanges());
												}
												
												psLT.setLong(6, te.getLtIdSubjectT());
												if(te.isNew()) {
													psLT.setNull(7,  Types.LONGNVARCHAR);
												} else {
													psLT.setLong(7, te.getLtIdTranslate());
												}
												return psLT;
											}
										}, keyHolderLT);
					if(te.isNew()) {
						te.setLtIdTranslate(keyHolderLT.getKey().longValue());
					 }
					
				    System.out.println("te.LtIdTranslate "+te.getLtIdTranslate());

					System.out.println("sqlIT = "+sqlIT);
					System.out.println("te.getItIdTextType()= "+te.getItIdTextType());
					System.out.println("te.getItIdUser()= "+te.getItIdUser());
					System.out.println("te.getItIdSubjItem()= "+te.getItIdSubjItem());
					System.out.println("te.getItIdItemsT()= "+te.getItIdItemsT());
								
					if(te.getItIdUser()==null||te.getItIdUser()==0) {
						throw new Exception("Пользователь некорректен!");
					}
					if(te.getItIdTextType()==null||te.getItIdTextType()==0) {
						throw new Exception("Тип текста не выбран!");
					}
					if(te.getItIdSubjItem()==null||te.getItIdSubjItem()==0) {
						throw new Exception("Текст не прикреплен к теме!");
					}
					    KeyHolder keyHolderIT = new GeneratedKeyHolder();
						jdbcTemplate.update(new PreparedStatementCreator() {
												public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
													PreparedStatement psIT = connection.prepareStatement(sqlIT, new String[] {"idtext_type, iduser, idSubjItem"});
													psIT.setInt(1, te.getItIdTextType());
													psIT.setLong(2, te.getItIdUser());
													psIT.setLong(3, te.getItIdSubjItem());
													if(te.isNew()&&(te.getItIdItemsT()==null||te.getItIdItemsT()==0)) {
														psIT.setNull(4,  Types.LONGNVARCHAR);
													} else {
														psIT.setLong(4,  te.getItIdItemsT());
													}
													return psIT;
												}
											}, keyHolderIT);
					 if(te.isNew()&&(te.getItIdItemsT()==null||te.getItIdItemsT()==0)) {
						 te.setItIdItemsT((long)keyHolderIT.getKey().longValue());
					 }

					System.out.println("te.getItIdItemsT() = "+te.getItIdItemsT()); 
					

					System.out.println("sqlTT = "+sqlTT);
					System.out.println("te.getItIdItemsT()= "+te.getItIdItemsT());
					System.out.println("te.getLtIdTranslate()= "+te.getLtIdTranslate());
					System.out.println("te.getTtIdTranslatesT()= "+te.getTtIdTranslatesT());
					if(te.getItIdItemsT()==null||te.getItIdItemsT()==0) {
						throw new Exception("Идентификатор сущности текста некорректен!");
					}
					if(te.getLtIdTranslate()==null||te.getLtIdTranslate()==0) {
						throw new Exception("Идентификатор текста некорректен!");
					}
						 KeyHolder keyHolderTT = new GeneratedKeyHolder();
						 jdbcTemplate.update(new PreparedStatementCreator() {
						 					 	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						 					 		PreparedStatement psTT = connection.prepareStatement(sqlTT, new String[] {"iditem, idtranslate, idtranslates_t"});
													psTT.setLong(1, te.getItIdItemsT());
													psTT.setLong(2, te.getLtIdTranslate());
													if(te.isNew()) {
														psTT.setNull(3,  Types.LONGNVARCHAR);
													} else {
														psTT.setLong(3,  te.getTtIdTranslatesT());
													}
													return psTT;
											 }
						 }, keyHolderTT);
						 if(te.isNew()) {
							 te.setTtIdTranslatesT(keyHolderTT.getKey().longValue());
						 }	
							System.out.println("te.getTtIdTranslatesT() "+te.getTtIdTranslatesT()); 
					return te;
				    } catch(Exception e2) {
				    	e2.printStackTrace();
					  logger.info("Сохранение перевода",e2);
					  System.out.println(e2.getMessage());
				    } 
			return null;

	}
	
	@Override
	public List<List<TranslateEssence>> getListTranslateEssences() {
		
		List<List<TranslateEssence>> list = new ArrayList<List<TranslateEssence>>();
		for(ItemsT item : getListItemsT()) {
			list.add(getRowTranslateEssence(item.getidItemsT()));
		}
		return list;
	}
	

	private List<TranslateEssence> getRowTranslateEssence(Long idItemsT) {
		try {
			String where = (idItemsT == null) ? "" : (" where it.iditems_t = "+idItemsT+"  ");
			String sql = "select it.iditems_t itIdItemsT, it.idtext_type itIdTextType, it.iduser itIdUser, it.idSubjItem itIdSubjItem, "+
						  "lt.idtranslate ltIdTranslate, lt.text ltText, lt.idlang ltIdLang, lt.idgender ltIdGender, lt.plur_ends ltPlurEnds, "+
						  "lt.root_changes ltRootChanges, lt.idSubject_t ltIdSubjectT, "+
						  "tt.idtranslates_t ttIdTranslatesT "+
						  "from words.locale_translate lt inner join words.translates_t tt on lt.idtranslate=tt.idtranslate "+
						  "inner join words.items_t it on it.iditems_t=tt.iditem "+where+
						  "order by tt.idtranslates_t, lt.idlang";
			System.out.println("where = "+where+" sql = "+sql);
			List<TranslateEssence> list = jdbcTemplate.query(sql,  new TranslateEssenceMapper());
			
			System.out.println("list.size() = "+list.size());
			return list;
		} catch (Exception e) {
			logger.info("List of all TranslateEssence from ItemsT:",e);
			e.printStackTrace();
		}
		return null;
		
		
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, String> getMapSubjectT(Integer lang) {
		try {
			String langs = " ";
			if(lang != null) {
			   langs =  " where st.lang = ? ";
			}
			String sql = "SELECT st.idsubject_t, st.subject_name "+
		                 "FROM words.subject_t st "+langs + 
                         "order by st.subject_name"; 
			System.out.println("getMapSubjectT lang="+lang+" sql = "+sql);
			Map<String, String> map = (Map<String, String>)jdbcTemplate.query(sql, new Object[]{lang},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> nameSubjectT = new LinkedHashMap();
				       while (rs.next()) {
				         String col1 = rs.getString("idsubject_t");
				         String col2 = rs.getString("subject_name");
				         nameSubjectT.put(col1, col2);
				       }

			           return nameSubjectT;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Map of name subjectT:",e);
			e.printStackTrace();
		}
		return null;
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, String> getMapTranslatesGroup() {
		try {

			
			String sql = "select it.iditems_t itiditemst, lt.text ltText, l.lang_name llangname "+
			             "from words.locale_translate lt inner join words.translates_t tt on lt.idtranslate=tt.idtranslate "+
			             "inner join words.items_t it on it.iditems_t=tt.iditem "+
			             "inner join words.lang l on lt.idlang = l.idlang "+
			             "order by it.iditems_t, lt.idlang";
			System.out.println("getMapTranslatesGroup sql "+sql);
			Map<String, String> map = (Map<String, String>)jdbcTemplate.query(sql, new Object[]{},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> textTranslatesGroup = new LinkedHashMap();
				        String col1 = "";
						String col2 = "";
				       while (rs.next()) {
					         col1 = rs.getString("itiditemst");
					         col2 = rs.getString("ltText")+" ("+rs.getString("llangname")+"); ";
					         
				    	  if(textTranslatesGroup.get(col1)!=null) {
				    		  col2 = textTranslatesGroup.get(col1)+" "+col2; 
				    	  }
				    	  textTranslatesGroup.put(col1, col2);
				       }
			           return textTranslatesGroup;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Map of translatesgroup:",e);
			e.printStackTrace();
		}
		return null;
	}	
	
	
	/*SELECT st.idsubject_t, st.subject_name, st.lang, st.pid
	FROM words.bindtranslatesubject bts, words.translates_t tt, words.subject_t st
	where bts.idtranslate=tt.idtranslates_t
	  and bts.idsubjectt=st.idsubject_t
	  and bts.idtranslate=6;*/

	@Override
	public TranslateEssence getTranslateEssenceByTtIdTranslatesT(long ttidtranslatest) {
		try {
			String sql = "select it.iditems_t itIdItemsT, it.idtext_type itIdTextType, it.iduser itIdUser, it.idSubjItem itIdSubjItem, "+
						  "lt.idtranslate ltIdTranslate, lt.text ltText, lt.idlang ltIdLang, lt.idgender ltIdGender, lt.plur_ends ltPlurEnds, "+
						  "lt.root_changes ltRootChanges, lt.idSubject_t ltIdSubjectT, "+
						  "tt.idtranslates_t ttIdTranslatesT "+
						  "from words.locale_translate lt inner join words.translates_t tt on lt.idtranslate=tt.idtranslate "+
						  "inner join words.items_t it on it.iditems_t=tt.iditem "+
						  "where tt.idtranslates_t = ? "+
						  "order by tt.idtranslates_t, lt.idlang";
			System.out.println("getTranslateEssenceByTtIdTranslatesT ttidtranslatest = "+ttidtranslatest+" sql = "+sql);
			TranslateEssence result = (TranslateEssence)jdbcTemplate.queryForObject(sql, new Object[]{ttidtranslatest}, new TranslateEssenceMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get TranslateEssence By ttidtranslatest:",e);
		}
		return null;
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, String> getMapSubjectsGroup() {
		try {

			
			String sql = "select si1.id itIdSubjItem, st.subject_name stsubjectname, l.lang_name llangname "+
						  "from words.subject_t st inner join words.subjects_items si "+
						  "on st.idsubject_t=si.idsubject "+
						  "inner join words.subjects_items_ si1 on si1.id=si.iditem "+
						  "inner join words.lang l on st.lang=l.idlang "+	
						  "order by si1.id, l.idlang";
			System.out.println("getMapSubjectsGroup sql "+sql);
			Map<String, String> map = (Map<String, String>)jdbcTemplate.query(sql, new Object[]{},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> subjectsGroup = new LinkedHashMap();
				        String col1 = "";
						String col2 = "";
				       while (rs.next()) {
					         col1 = rs.getString("itIdSubjItem");
					         col2 = rs.getString("stsubjectname")+" ("+rs.getString("llangname")+"); ";
					         
				    	  if(subjectsGroup.get(col1)!=null) {
				    		  col2 = subjectsGroup.get(col1)+" "+col2; 
				    	  }
				    	  subjectsGroup.put(col1, col2);
				       }
			           return subjectsGroup;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Map of subjectsGroup:",e);
			e.printStackTrace();
		}
		return null;
	}	

	
	//@Override
	public TranslateEssence getListTranslatesByIdSubjectT(long idSubjectT) {
		try {
			String sql = "select it.iditems_t itIdItemsT, it.idtext_type itIdTextType, it.iduser itIdUser, it.idSubjItem itIdSubjItem, "+
						  "lt.idtranslate ltIdTranslate, lt.text ltText, lt.idlang ltIdLang, lt.idgender ltIdGender, lt.plur_ends ltPlurEnds, "+
						  "lt.root_changes ltRootChanges, lt.idSubject_t ltIdSubjectT, "+
						  "tt.idtranslates_t ttIdTranslatesT "+
						  "from words.locale_translate lt inner join words.translates_t tt on lt.idtranslate=tt.idtranslate "+
						  "inner join words.items_t it on it.iditems_t=tt.iditem "+
						  "where tt.idtranslates_t = ? "+
						  "order by tt.idtranslates_t, lt.idlang";
			System.out.println("getTranslateEssenceByTtIdTranslatesT ttidtranslatest = "+idSubjectT+" sql = "+sql);
			TranslateEssence result = (TranslateEssence)jdbcTemplate.queryForObject(sql, new Object[]{idSubjectT}, new TranslateEssenceMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get TranslateEssence By ttidtranslatest:",e);
		}
		return null;
	}
/*	
	public Integer updateItemsTByPid(Long id, Long pid) {
		String sql = "update words.commonsubjectsitems t set t.pid = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, (pid==0 ? null : pid), id);
		} catch(Exception e) {
			logger.info("CommonSubjectsItems update:",e);
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public TranslateEssence getTranslateEssenceByTranslatesT(long ttIdItem) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
/*
 
 SELECT `bindtranslatesubject`.`id`,
    `bindtranslatesubject`.`idtranslate`,
    `bindtranslatesubject`.`idsubjectt`
FROM `words`.`bindtranslatesubject`;


SELECT `binditemstsubjitems_`.`id`,
    `binditemstsubjitems_`.`idsubjitems_`,
    `binditemstsubjitems_`.`iditemst`
FROM `words`.`binditemstsubjitems_`;


select * from words.locale_translate lt, words.translates_t tt, words.items_t it
where tt.iditem=it.iditems_t
  and tt.idtranslates_t=lt.idtranslate
and lt.idtranslate=4;

select * from words.bindtranslatesubject bts, words.locale_translate lt, words.subject_t st
where bts.idtranslate = lt.idtranslate
  and bts.idsubjectt = st.idsubject_t
and lt.idtranslate=4;

 */
}	


