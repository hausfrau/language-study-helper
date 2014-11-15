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

import org.home.dao.ParticularDAO;
import org.home.mapper.BindSubjMapper;
import org.home.mapper.LangMapper;
import org.home.mapper.LocaleTranslateMapper;
import org.home.mapper.SubjectTMapper;
import org.home.mapper.TextTypeMapper;
import org.home.mapper.TranslateEssenceMapper;
import org.home.models.BindSubj;
import org.home.models.ItemsT;
import org.home.models.Lang;
import org.home.models.LocaleTranslate;
import org.home.models.SubjectT;
import org.home.models.Tests;
import org.home.models.TextType;
import org.home.models.TranslateEssence;
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

@Repository(value = "particularDAO")
@Service
public class ParticularDAOImpl implements ParticularDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	@Override//
	public Integer createLang(Lang l) {
		String sql = "insert into words.lang(lang_name) values(?);";
		System.out.println("createLang() "+l.getLangName()+" sql="+sql);
		try{
			if(l.getLangName()==null||l.getLangName().trim().length()==0) {
				throw new Exception("Язык некорректен!");
			}
			return jdbcTemplate.update(sql, l.getLangName());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием названия языка нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием языка",e);
			e.printStackTrace();
		}
		return null;
	}*/

	@Override//
	public Lang getLangByIdLang(long id) {
		try {
			String sql = "select t.idlang, t.lang_name from words.lang t where t.idlang = ?";
			System.out.println("getLangByIdLang("+id+") sql="+sql);
			Lang result = (Lang)jdbcTemplate.queryForObject(sql, new Object[]{id}, new LangMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			logger.info("Error get Lang by id Empty:",e);
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("Error get Lang by id:",e);
		}
		return null;
	}
/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	@Override//
	public Integer updateLang(Lang l) {
		String sql = "update words.lang t set t.lang_name = ? where t.idlang = ?";
		System.out.println("updateLang("+l.getIdLang()+") sql="+sql);
		try {
			return jdbcTemplate.update(sql, l.getLangName(), l.getIdLang());
		} catch(Exception e) {
			logger.info("Lang update:",e);
			e.printStackTrace();
		}
		return null;
	}*/

	@Override//
	public Integer deleteLang(Lang l) {
		String sql = "delete from words.lang where idlang = ?";
		System.out.println("deleteLang("+l.getIdLang()+") sql="+sql);
		try {
		    return jdbcTemplate.update(sql, l.getIdLang());
		} catch(Exception e) {  
			logger.info("Проблеммы с удалением языка");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<Lang> getListLangs() {
		try {
			String sql = "select t.idlang, t.lang_name from words.lang t";
			List<Lang> list = jdbcTemplate.query(sql,  new LangMapper());
			System.out.println("getListLangs() sql="+sql);
			return list;
		} catch (Exception e) {
			logger.info("Error List of all Lang:",e);
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Map getMapLangs() {
		try {
			String sql = "select t.idlang, t.lang_name from words.lang t";
			System.out.println("getMapLangs sql="+sql);
			Map map = (Map)jdbcTemplate.query(sql, new Object[]{},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> map = new LinkedHashMap();
				       while (rs.next()) {
				         String col1 = rs.getString("idlang");
				         String col2 = rs.getString("lang_name");
				         map.put(col1, col2);
				       }
			           return map;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Error Map of all Lang:",e);
			e.printStackTrace();
		}
		return null;
	}	

	
	@Override//
	public Integer createTextType(TextType tt) {
		String sql = "insert into words.text_type(text_typename) values(?);";
		try{
			if(tt.getTextTypeName()==null||tt.getTextTypeName().trim().length()==0) {
				throw new Exception("Тип текста некорректен!");
			}
			return jdbcTemplate.update(sql, tt.getTextTypeName());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием типа текста нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием типа текста",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public TextType getTextTypeByIdTextType(long id) {
		try {
			String sql = "select t.idtext_type, t.text_typename from words.text_type t where t.idtext_type = ?";
			TextType result = (TextType)jdbcTemplate.queryForObject(sql, new Object[]{id}, new TextTypeMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get TextType by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateTextType(TextType tt) {
		String sql = "update words.text_type t set t.text_typename = ? where t.idtext_type = ?";
		try {
			return jdbcTemplate.update(sql, tt.getTextTypeName(), tt.getIdTextType());
		} catch(Exception e) {
			logger.info("TextType update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteTextType(TextType tt) {
		String sql = "delete from words.text_type where idtext_type = ?";
		try {
			return jdbcTemplate.update(sql, tt.getIdTextType());
		} catch(Exception e) { 
			logger.info("Проблеммы с удалением типа текста");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<TextType> getListTextTypes() {
		try {
			String sql = "select t.idtext_type, t.text_typename from words.text_type t";
			List<TextType> list = jdbcTemplate.query(sql,  new TextTypeMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all TextType:",e);
			e.printStackTrace();
		}
		return null;
	}


	@Override//
	public Integer createBindSubj(BindSubj bs) {
		String sql = "insert into words.bindsubj(idCommonSubject, idSubject_t) values(?, ?);";
		try{
			if(bs.getIdCommonSubject()==null||bs.getIdCommonSubject()==0) {
				throw new Exception("Идентификатор названия общей темы/раздела указан неверно!");
			}
			if(bs.getIdSubjectT()==null||bs.getIdSubjectT()==0) {
				throw new Exception("Идентификатор названия пользовательской темы/раздела указан неверно!");
			}
			System.out.println("jdbcTemplate="+jdbcTemplate);
			return jdbcTemplate.update(sql, bs.getIdCommonSubject(), bs.getIdSubjectT());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием свази названия общей темы и названия пользовательской темы/раздела нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием свази названия общей темы и названия пользовательской темы/раздела",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public BindSubj getBindSubjById(long id) {
		try {
			String sql = "select t.id, t.idCommonSubject, t.idSubject_t from words.bindsubj t where t.id = ?";
			BindSubj result = (BindSubj)jdbcTemplate.queryForObject(sql, new Object[]{id}, new BindSubjMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get BindSubj by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateBindSubj(BindSubj bs) {
		String sql = "update words.bindsubj t set t.idCommonSubject = ?, idSubject_t = ? where t.id = ?";
		try {
			return jdbcTemplate.update(sql, bs.getIdCommonSubject(), bs.getIdSubjectT(), bs.getId());
		} catch(Exception e) {
			logger.info("BindSubj update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteBindSubj(BindSubj bs) {
		String sql = "delete from words.bindsubj where id = ?";
		try {
			return jdbcTemplate.update(sql, bs.getId());
		} catch(Exception e) { 
			logger.info("Проблеммы с удалением свази названия общей темы и названия пользовательской темы/раздела");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<BindSubj> getListBindsSubj() {
		try {
			String sql = "select t.id, t.idCommonSubject, t.idSubject_t from words.bindsubj t";
			List<BindSubj> list = jdbcTemplate.query(sql,  new BindSubjMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all BindSubj:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer createSubjectT(SubjectT st) {
		String sql = "insert into words.subject_t(subject_name, lang, pid) values(?, ?, ?);";
		try{
			if(st.getSubjectName()==null||st.getSubjectName().trim().length()==0) {
				throw new Exception("Название пользовательской темы/раздела не может быть пустым!");
			}
			if(st.getLang()==null||st.getLang()==0) {
				throw new Exception("Неверно указан язык в названии пользовательской темы/раздела!");
			}
			System.out.println("jdbcTemplate="+jdbcTemplate);
			return jdbcTemplate.update(sql,st.getSubjectName(), st.getLang(), st.getPid()==0 ? null : st.getPid());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием названия пользовательской темы нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием названия пользовательской темы",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public SubjectT getSubjectTByIdSubjectT(long idSubjectT) {
		try {
			String sql = "select t.idsubject_t, t.subject_name, t.lang, t.pid from words.subject_t t where t.idsubject_t = ?";
			SubjectT result = (SubjectT)jdbcTemplate.queryForObject(sql, new Object[]{idSubjectT}, new SubjectTMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get SubjectT by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateSubjectT(SubjectT st) {
		String sql = "update words.subject_t t set t.subject_name = ?, t.lang = ?, t.pid = ? where t.idsubject_t = ?";
		try {
			return jdbcTemplate.update(sql, st.getSubjectName(), st.getLang(), st.getPid(), st.getIdSubjectT());
		} catch(Exception e) {
			logger.info("SubjectT update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteSubjectT(SubjectT st) {
		String sql = "delete from words.subject_t where idsubject_t = ?";
		try {
			return jdbcTemplate.update(sql, st.getIdSubjectT());
		} catch(Exception e) { 
			logger.info("Проблеммы с удалением названия пользовательской темы");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<SubjectT> getListSubjectTs() {
		try {
			String sql = "select t.idsubject_t, t.subject_name, t.lang, t.pid from words.subject_t t";
			List<SubjectT> list = jdbcTemplate.query(sql,  new SubjectTMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all SubjectT:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer createLocaleTranslate(LocaleTranslate lt) {
		String sql = "insert into words.locale_translate(text, idlang, idgender, plur_ends, root_changes, idSubject_t) values(?, ?, ?, ?, ?, ?);";
		try{
			if(lt.getText()==null||lt.getText().trim().length()==0) {
				throw new Exception("Текст не может быть пустым!");
			}
			if(lt.getIdLang()==null||lt.getIdLang()==0) {
				throw new Exception("Неверно указан язык текста!");
			}
			if(lt.getIdSubjectT()==null||lt.getIdSubjectT()==0) {
				throw new Exception("Нет привязки текста к пользовательской теме/разделу!");
			}
			System.out.println("jdbcTemplate="+jdbcTemplate);
			return jdbcTemplate.update(sql,lt.getText(), lt.getIdLang(), lt.getIdGender(), lt.getPlurEnds(), lt.getRootChanges(), lt.getIdSubjectT());
		} catch(NullPointerException e) {
			logger.info("проблемы с созданием текста нуль",e);
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("проблемы с созданием текста",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public LocaleTranslate getLocaleTranslateByIdTranslate(long idt) {
		try {
			String sql = "select t.idtranslate, t.text, t.idlang, t.idgender, t.plur_ends, t.root_changes, t.idSubject_t from words.locale_translate t where t.idtranslate = ?";
			LocaleTranslate result = (LocaleTranslate)jdbcTemplate.queryForObject(sql, new Object[]{idt}, new LocaleTranslateMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get SubjectT by id:",e);
		}
		return null;
	}

	@Override//
	public Integer updateLocaleTranslate(LocaleTranslate lt) {
		String sql = "update words.locale_translate t set t.text = ?, t.idlang = ?, t.idgender = ?, t.plur_ends = ?, t.root_changes = ?, t.idSubject_t = ? where t.idtranslate = ?";
		try {
			return jdbcTemplate.update(sql, lt.getText(), lt.getIdLang(), lt.getIdGender(), lt.getPlurEnds(), lt.getRootChanges(), lt.getIdSubjectT(), lt.getIdTranslate());
		} catch(Exception e) {
			logger.info("LocaleTranslate update:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public Integer deleteLocaleTranslate(LocaleTranslate lt) {
		String sql = "delete from words.locale_translate where idtranslate = ?";
		try {
			return jdbcTemplate.update(sql, lt.getIdTranslate());
		} catch(Exception e) { 
			logger.info("Проблеммы с удалением текста");
			e.printStackTrace();
		}
		return null;
	}

	@Override//
	public List<LocaleTranslate> getListLocaleTranslates() {
		try {
			String sql = "select t.idtranslate, t.text, t.idlang, t.idgender, t.plur_ends, t.root_changes, t.idSubject_t from words.locale_translate t";
			List<LocaleTranslate> list = jdbcTemplate.query(sql,  new LocaleTranslateMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all LocaleTranslate:",e);
			e.printStackTrace();
		}
		return null;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public Lang saveLang(final Lang lang) {		
		final String sql = lang.isNew() ? 
			"insert into words.lang(lang_name, idlang) values(?, ?);" : 
			"update words.lang t set t.lang_name = ? where t.idlang = ?";
		System.out.println("saveLang "+lang.getLangName()+" sql="+sql);
			try{
				KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(new PreparedStatementCreator() {
										public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
											PreparedStatement ps = connection.prepareStatement(sql, new String[] {"lang_name", "idlang"});
											ps.setString(1, lang.getLangName());
											if(lang.isNew()) {
												ps.setNull(2,  Types.LONGNVARCHAR);
											} else {
												ps.setLong(2,  lang.getIdLang());
											}
									   		//ps.setLong(2, lang.isNew() ? null : lang.getIdLang());
											return ps;
										}
									}, keyHolder);
				if(lang.isNew()) {
					lang.setIdLang((long)keyHolder.getKey().intValue());
				 }
				return lang;
			} catch(Exception e) {
				e.printStackTrace();
				logger.info("Сохранение языка",e);
			}
		return null;
	}

	@Override
	public TextType saveTextType(final TextType tt) {
		final String sql = tt.isNew() ? 
				"insert into words.text_type(text_typename, idtext_type) values(?, ?);" : 
				"update words.text_type t set t.text_typename = ? where t.idtext_type = ?";
				try{
					KeyHolder keyHolder = new GeneratedKeyHolder();
					jdbcTemplate.update(new PreparedStatementCreator() {
											public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
												PreparedStatement ps = connection.prepareStatement(sql, new String[] {"text_typename", "idtext_type"});
												ps.setString(1, tt.getTextTypeName());
												if(tt.isNew()) {
													ps.setNull(2,  Types.LONGNVARCHAR);
												} else {
													ps.setLong(2,  tt.getIdTextType());
												}
												return ps;
											}
										}, keyHolder);
					if(tt.isNew()) {
						tt.setIdTextType((long)keyHolder.getKey().intValue());
					 }
					return tt;
				} catch(Exception e) {
					logger.info("Сохранение типа текста",e);
				}
			return null;
	}

	
	@Override
	public List<BindSubj> getBindSubjDependencyOfCommonSubjects(long id) {
		try {
			String sql = "select bs.id, bs.idCommonSubject, bs.idSubject_t "+
		                 "  from words.bindsubj bs"+ 
		                 " where bs.idCommonSubject = ?";
			List<BindSubj> list = jdbcTemplate.query(sql, new BindSubjMapper());
			return list;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get BindSubj Dependency Of CommonSubjects: idCommonSubjects",e);
		}
		return null;

	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public Map getMapTextTypes() {
		try {
			String sql = "SELECT t.idtext_type, t.text_typename FROM words.text_type t";
 			Map map = (Map)jdbcTemplate.query(sql, new Object[]{},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> map = new LinkedHashMap();
				       while (rs.next()) {
				         String col1 = rs.getString("idtext_type");
				         String col2 = rs.getString("text_typename");
				         map.put(col1, col2);
				       }

			           return map;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Map of all testtype:",e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override 
	public String getStringFromGetListChildsIdSubjectTByParentIDSubjectT(long id) {
		List<Long> idst = getListChildsIdSubjectTByParentIDSubjectT(id);
		String idsts = (idst!=null) ? idst.get(0).toString() : "";
		if(idst.size()>1) {
			for(int i=1;i<idst.size();i++) {
				idsts = idsts+", "+idst.get(i);
			}
		}
		System.out.println("getStringFromGetListChildsIdSubjectTByParentIDSubjectT idsts = "+idsts);
		return idsts;
	}
	//выбор одного случайного частного переводов по теме, включая подтемы если нужно
	@Override
	public LocaleTranslate getRandomLocaleTranslateByIdSubjectT(String ids) {
		try {
			/*String idst = (idsts!=null) ? idsts.get(0).toString() : "";
			if(idsts.size()>1) {
				for(int i=1;i<idsts.size();i++) {
					idst = idst+", "+idsts.get(i);
				}
			}*/
			System.out.println("Зашли в getRandomLocaleTranslateByIdSubjectT");
			String idst = ids.length()>0 ? "and bts.idsubjectt in ("+ids+") " : "";
			String sql = "SELECT lt.idtranslate, lt.text, lt.idlang, "+
					     "lt.idgender, lt.plur_ends, "+ 
	                     "lt.root_changes, lt.idSubject_t "+
	                     "FROM words.bindtranslatesubject bts, words.locale_translate lt "+
	                     "where bts.idtranslate=lt.idtranslate "+idst+
	                     "order by RAND( ) LIMIT 1";
			System.out.println("getRandomLocaleTranslateByIdSubjectT sql= "+sql);
			/*LocaleTranslate result = (LocaleTranslate)jdbcTemplate.queryForObject(sql, new Object[]{"ltIdTranslate", "ltText", "ltIdLang", "ltIdGender", "ltPlurEnds", "ltRootChanges", "ltIdSubjectT"}, 
					new LocaleTranslateMapper());*/
			LocaleTranslate result = (LocaleTranslate)jdbcTemplate.queryForObject(sql, new Object[]{}, new LocaleTranslateMapper());
			
			//List<LocaleTranslate> list = jdbcTemplate.query(sql,  new LocaleTranslateMapper());
			//System.out.println("getRandomLocaleTranslateByIdSubjectT "+result.toString());
			return result;
		} catch (EmptyResultDataAccessException e) {
			System.out.println("ошибка в getRandomLocaleTranslateByIdSubjectT 111");
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			System.out.println("ошибка в getRandomLocaleTranslateByIdSubjectT");
			e.printStackTrace();
			logger.info(" get RandomLocaleTranslate By IdSubjectT:",e);
		}
		return null;
	}
	@Override
	public Tests saveTest(Tests test) {
	  return null;	
	}
	
	@Override
	public List<Long> getListChildsIdSubjectTByParentIDSubjectT(long id) {
		try {
			String sql = "SELECT idsubject_t FROM words.subject_t where pid= "+id+" "+
                         "order by idSubject_t";
//возвращаем id-шники всех тем, которые являются дочерними к переданному id
			List<Long> list = new ArrayList<Long>();
			list.add(id);
			
			List<Long> listId = (List<Long>) jdbcTemplate.queryForList(sql, Long.class);
		//для каждого найденного id рекурсивно ищем дочерние темы
			for(Long ids: listId) {
				List<Long> listChilds = new ArrayList<Long>(); 
				listChilds = getListChildsSubject(ids);
				if(listChilds!=null && listChilds.size()!=0) {
					for(int i=0; i<listChilds.size(); i++) {
						list.add(listChilds.get(i));
					}
				}
			}

			System.out.println("getListChildsIdSubjectTByParentIDSubjectT pid="+id+" list.size="+list.size());			
			return list;
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get BindSubj Dependency Of CommonSubjects: idCommonSubjects",e);
		}
		return null;

	}
	
	private List<Long> getListChildsSubject(Long id) {
		
		String sql = "SELECT idsubject_t FROM words.subject_t where pid = "+id+" "+
                "order by idSubject_t";
		List<Long> list = new ArrayList<Long>();
		list.add(id);
		try {
			List<Long> listId = (List<Long>) jdbcTemplate.queryForList(sql, Long.class);

	//для каждого найденного id рекурсивно ищем дочерние темы
			for(Long ids: listId) {
				List<Long> listChilds = new ArrayList<Long>(); 

				listChilds = getListChildsSubject(ids);
				if(listChilds!=null && listChilds.size()!=0) {
					for(int i=0; i<listChilds.size(); i++) {
						list.add(listChilds.get(i));
					}
				}
			}
			System.out.println("getListChildsSubject idsubject_tpid="+id+" list.size="+list.size()); 
			return list;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			logger.info("getListChildsSubject "+id,e);
			e.printStackTrace();
		}
	 return null;
	}	
	
	

	@Override//
	public LocaleTranslate getAnswerLocaleTranslateByIditemOfTranslatesT(long iditem, long idlang) {
		try {
			String sql = "select lt.idtranslate, lt.text, lt.idlang, "+
						 "lt.idgender, lt.plur_ends, lt.root_changes, "+ 
						 "lt.idSubject_t "+
						 "from words.locale_translate lt "+ 
						 "inner join words.translates_t tt on lt.idtranslate=tt.idtranslate "+ 
						 "where tt.iditem=? "+
						 "and lt.idlang=?";
			System.out.println("getAnswerLocaleTranslateByIditemOfTranslatesT iditem = "+iditem+ " idlang = "+idlang+ " sql = "+sql);
			LocaleTranslate result = (LocaleTranslate)jdbcTemplate.queryForObject(sql, new Object[]{iditem, idlang}, new LocaleTranslateMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("getAnswerLocaleTranslateByIditemOfTranslatesT",e);
		}
		return null;
	}
	@Override
	public Long getItemsTIdItemsTByLocaleTranslateIdTranslate(long idTranslate) {
		try {
			String sql = "select tt.iditem "+
					"from words.locale_translate lt, words.translates_t tt  "+
					"where lt.idtranslate = tt.idtranslate "+
					"and lt.idtranslate = ?";
			System.out.println("getItemsTIdItemsTByLocaleTranslateIdTranslate tidTranslate = "+idTranslate+" sql = "+sql);
			//TranslateEssence result = (TranslateEssence)jdbcTemplate.queryForObject(sql, new Object[]{idSubjectT}, new TranslateEssenceMapper());
			Long idItemsT = (Long)jdbcTemplate.query(sql, new Object[]{idTranslate},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				    	   Long id = null;
				       while (rs.next()) {
				         id = rs.getLong("iditem");
				       }

			           return id;
					   };
			});
			
			return idItemsT;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get ItemsTIdItemsT By LocaleTranslateIdTranslate ",e);
		}
		return null;
	}
	
	
	/*
	@Override
	public LocaleTranslate getTranslateessenceByText(String text) {
		try {
			String sql = "select tt.iditem "+
					"from words.locale_translate lt, words.translates_t tt  "+
					"where lt.idtranslate = tt.idtranslate "+
					"and lt.idtranslate = ?";
			System.out.println("getTranslateessenceByText text = "+text+" sql = "+sql);
			//TranslateEssence result = (TranslateEssence)jdbcTemplate.queryForObject(sql, new Object[]{idSubjectT}, new TranslateEssenceMapper());
			Long idItemsT = (Long)jdbcTemplate.query(sql, new Object[]{idTranslate},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				    	   Long id = null;
				       while (rs.next()) {
				         id = rs.getLong("iditem");
				       }

			           return id;
					   };
			});
			
			return idItemsT;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("get getTranslateessence By Text ",e);
		}
		return null;
	}*/
	
	
	@Override
	public Map getAjaxAllLang() {
		try {
			String sql = "select t.idlang, t.lang_name from words.lang t";
			System.out.println("getMapLangs sql="+sql);
			Map map = (Map)jdbcTemplate.query(sql, new Object[]{},
				     new ResultSetExtractor() {
				       public Object extractData(ResultSet rs) throws SQLException {
				       Map<String,String> map = new LinkedHashMap();
				       while (rs.next()) {
				         String col1 = rs.getString("idlang");
				         String col2 = rs.getString("lang_name");
				         map.put(col1, col2);
				       }
			           return map;
					   };
			});
			return map;

		} catch (Exception e) {
			logger.info("Error Map of all Lang:",e);
			e.printStackTrace();
		}
		return null;
	}	
}
