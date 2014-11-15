package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.TranslateEssence;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 28.02.2014
 */
public class TranslateEssenceMapper implements RowMapper<TranslateEssence> {
	@Override
	public TranslateEssence mapRow(ResultSet resultSet, int i) throws SQLException {
		TranslateEssence te = new TranslateEssence();
		te.setItIdItemsT(resultSet.getLong("itIdItemsT"));
		te.setItIdTextType(resultSet.getInt("itIdTextType"));
		te.setItIdUser(resultSet.getLong("itIdUser"));
		te.setItIdSubjItem(resultSet.getLong("itIdSubjItem"));
		te.setLtIdTranslate(resultSet.getLong("ltIdTranslate"));
		te.setLtText(resultSet.getString("ltText"));
		te.setLtIdLang(resultSet.getInt("ltIdLang"));
		te.setLtIdGender(resultSet.getInt("ltIdGender"));
		te.setLtPlurEnds(resultSet.getString("ltPlurEnds"));
		te.setLtRootChanges(resultSet.getString("ltRootChanges"));
		te.setLtIdSubjectT(resultSet.getLong("ltIdSubjectT"));
		te.setTtIdTranslatesT(resultSet.getLong("ttIdTranslatesT"));
		return te;
	}
}
