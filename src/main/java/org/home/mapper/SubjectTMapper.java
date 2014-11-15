package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.SubjectT;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 17.01.2014
 */
public class SubjectTMapper  implements RowMapper<SubjectT> {
	@Override
	public SubjectT mapRow(ResultSet resultSet, int i) throws SQLException {
		SubjectT st = new SubjectT();
			st.setIdSubjectT(resultSet.getLong("idsubject_t"));
			st.setSubjectName(resultSet.getString("subject_name"));
			st.setLang(resultSet.getInt("lang"));
			st.setPid(resultSet.getLong("pid"));
		return st;
	}
}
