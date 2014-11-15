package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.SubjectsItems1;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 17.01.2014
 */
public class SubjectsItems1Mapper  implements RowMapper<SubjectsItems1> {
	@Override
	public SubjectsItems1 mapRow(ResultSet resultSet, int i) throws SQLException {
		SubjectsItems1 csi = new SubjectsItems1();
			csi.setId(resultSet.getLong("id"));
			csi.setIdUser(resultSet.getLong("idUser"));
			csi.setPid(resultSet.getLong("pid"));
		return csi;
	}
}