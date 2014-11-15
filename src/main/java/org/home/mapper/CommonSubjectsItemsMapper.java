package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.CommonSubjectsItems;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 13.01.2014
 */
public class CommonSubjectsItemsMapper  implements RowMapper<CommonSubjectsItems> {
	@Override
	public CommonSubjectsItems mapRow(ResultSet resultSet, int i) throws SQLException {
		CommonSubjectsItems csi = new CommonSubjectsItems();
			csi.setId(resultSet.getLong("id"));
			csi.setIdUser(resultSet.getLong("idUser"));
			csi.setPid(resultSet.getLong("pid"));
		return csi;
	}
}
