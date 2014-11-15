package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.Users;
import org.springframework.jdbc.core.RowMapper;

/**
 * ����� ������ ��� �������������
 * @author ogarkov_sa
 * @since 25.12.2013
 */
public class UsersMapper implements RowMapper<Users> {
	@Override
	public Users mapRow(ResultSet resultSet, int i) throws SQLException {
		Users u = new Users();
			u.setId(resultSet.getLong("id"));
			u.setName(resultSet.getString("name"));
			u.setGroup(resultSet.getLong("group_id"));
			u.setGroupName(resultSet.getString("groupName"));
		return u;
	}
}