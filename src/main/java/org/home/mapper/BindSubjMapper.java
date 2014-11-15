package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.BindSubj;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 19.01.2014
 */
public class BindSubjMapper implements RowMapper<BindSubj> {
	@Override
	public BindSubj mapRow(ResultSet resultSet, int i) throws SQLException {
		BindSubj bs = new BindSubj();
			bs.setId(resultSet.getLong("id"));
			bs.setIdCommonSubject(resultSet.getLong("idCommonSubject"));
			bs.setIdSubjectT(resultSet.getLong("idSubject_t"));
		return bs;
	}
}