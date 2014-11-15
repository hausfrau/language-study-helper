package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.TextType;
import org.springframework.jdbc.core.RowMapper;


/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 24.01.2014
 */
public class TextTypeMapper implements RowMapper<TextType> {
	@Override
	public TextType mapRow(ResultSet resultSet, int i) throws SQLException {
		TextType tt = new TextType();
			tt.setIdTextType(resultSet.getLong("idtext_type"));
			tt.setTextTypeName(resultSet.getString("text_typename"));
		return tt;
	}
}
