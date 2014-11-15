package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.CommonSubjectEssence;
import org.home.models.SubjectEssence;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 19.03.2014
 */
public class SubjectEssenceMapper implements RowMapper<SubjectEssence> {
	@Override
	public SubjectEssence mapRow(ResultSet resultSet, int i) throws SQLException {
		SubjectEssence se = new SubjectEssence();
		se.setStIdSubjectT(resultSet.getLong("stIdSubjectT"));
		se.setStSubjectName(resultSet.getString("stSubjectName"));
		se.setStLang(resultSet.getInt("stLang"));
		se.setStPid(resultSet.getLong("stPid"));		
		se.setSiId(resultSet.getLong("siId"));
		se.setSi1Id(resultSet.getLong("si1Id"));
		se.setSi1IdUser(resultSet.getLong("si1IdUser"));
		se.setSi1Pid(resultSet.getLong("si1Pid"));		
		return se;
	}
}
