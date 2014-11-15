package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.Role;
import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role> {
	@Override
	public Role mapRow(ResultSet resultSet, int i) throws SQLException {
		Role r = new Role();
			r.setId(resultSet.getLong("id"));
			r.setRole(resultSet.getString("role"));				
		return r;
	}
}

