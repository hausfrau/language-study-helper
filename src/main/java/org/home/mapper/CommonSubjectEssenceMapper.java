package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.CommonSubjectEssence;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 18.02.2014
 */
public class CommonSubjectEssenceMapper implements RowMapper<CommonSubjectEssence> {
	@Override
	public CommonSubjectEssence mapRow(ResultSet resultSet, int i) throws SQLException {
		CommonSubjectEssence cse = new CommonSubjectEssence();
		cse.setCsIdCommonSubj(resultSet.getLong("csIdCommonSubj"));
		cse.setCsNameCommonSubject(resultSet.getString("csNameCommonSubject"));
		cse.setCsLang(resultSet.getInt("csLang"));
		cse.setCsPid(resultSet.getLong("csPid"));
		cse.setCsiId(resultSet.getLong("csiId"));
		cse.setCsiIdUser(resultSet.getLong("csiIdUser"));
		cse.setCsiPid(resultSet.getLong("csiPid"));		
		cse.setBcsId(resultSet.getLong("bcsId"));
		return cse;
	}
}
