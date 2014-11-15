package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.BindCommonSubjects;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 13.01.2014
 */
public class BindCommonSubjectsMapper implements RowMapper<BindCommonSubjects> {
	@Override
	public BindCommonSubjects mapRow(ResultSet resultSet, int i) throws SQLException {
		BindCommonSubjects bcs = new BindCommonSubjects();
			bcs.setId(resultSet.getLong("id"));
			bcs.setIdComSubj(resultSet.getLong("idComSubj"));
			bcs.setIdComSubjItem(resultSet.getLong("idComSubjItem"));
		return bcs;
	}
}
