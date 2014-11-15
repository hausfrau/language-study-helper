package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.Lang;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 24.01.2014
 */
public class LangMapper implements RowMapper<Lang> {
	@Override
	public Lang mapRow(ResultSet resultSet, int i) throws SQLException {
		Lang l = new Lang();
			l.setIdLang(resultSet.getLong("idlang"));
			l.setLangName(resultSet.getString("lang_name"));
		return l;
	}
}
