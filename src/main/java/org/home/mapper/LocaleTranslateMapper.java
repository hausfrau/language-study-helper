package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.LocaleTranslate;
import org.springframework.jdbc.core.RowMapper;


/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 21.01.2014
 */
public class LocaleTranslateMapper  implements RowMapper<LocaleTranslate> {
	@Override
	public LocaleTranslate mapRow(ResultSet resultSet, int i) throws SQLException {
		LocaleTranslate lt = new LocaleTranslate();
			lt.setIdTranslate(resultSet.getLong("idtranslate"));
			lt.setText(resultSet.getString("text"));
			lt.setIdLang(resultSet.getInt("idlang"));
			lt.setIdGender(resultSet.getInt("idgender"));
			lt.setPlurEnds(resultSet.getString("plur_ends"));
			lt.setRootChanges(resultSet.getString("root_changes"));
			lt.setIdSubjectT(resultSet.getLong("idSubject_t"));
		return lt;
	}
}
