package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.CommonSubjects;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 13.01.2014
 */
public class CommonSubjectsMapper  implements RowMapper<CommonSubjects> {
	@Override
	public CommonSubjects mapRow(ResultSet resultSet, int i) throws SQLException {
		CommonSubjects cs = new CommonSubjects();
			cs.setIdCommonSubj(resultSet.getLong("idCommonSubj"));
			cs.setNameCommonSubject(resultSet.getString("nameCommonSubject"));
			cs.setLang(resultSet.getInt("lang"));
			cs.setLangName(resultSet.getString("lang_name"));
			cs.setPid(resultSet.getLong("pid"));
			cs.setPidNameCommonSubject(resultSet.getString("pidNameCommonSubject"));
		return cs;
	}
}
