package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.ItemsT;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 20.01.2014
 */
public class ItemsTMapper implements RowMapper<ItemsT> {
	@Override
	public ItemsT mapRow(ResultSet resultSet, int i) throws SQLException {
		ItemsT it = new ItemsT();
			it.setidItemsT(resultSet.getLong("iditems_t"));
			it.setidTextType(resultSet.getInt("idtext_type"));
			it.setIdUser(resultSet.getLong("iduser"));
			it.setIdSubjItem(resultSet.getLong("idSubjItem"));
		return it;
	}
}

