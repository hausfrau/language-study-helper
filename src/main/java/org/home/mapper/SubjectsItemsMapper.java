package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.SubjectsItems;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 17.01.2014
 */
public class SubjectsItemsMapper implements RowMapper<SubjectsItems> {
	@Override
	public SubjectsItems mapRow(ResultSet resultSet, int i) throws SQLException {
		SubjectsItems si = new SubjectsItems();
			si.setId(resultSet.getLong("id"));
			si.setIdSubject(resultSet.getLong("idsubject"));
			si.setIdItem(resultSet.getLong("iditem"));
		return si;
	}
}
