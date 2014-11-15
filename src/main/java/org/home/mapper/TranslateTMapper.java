package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.TranslatesT;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 21.01.2014
 */
public class TranslateTMapper  implements RowMapper<TranslatesT> {
	@Override
	public TranslatesT mapRow(ResultSet resultSet, int i) throws SQLException {
		TranslatesT tt = new TranslatesT();
		    tt.setIdTranslatesT(resultSet.getLong("idtranslates_t"));
			tt.setIdItem(resultSet.getLong("iditem"));
			tt.setIdTranslate(resultSet.getLong("idtranslate"));
		return tt;
	}
}
