package org.home.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.home.dao.UserDAO;
import org.home.mapper.RoleMapper;
import org.home.mapper.UsersMapper;
import org.home.models.Groups;
import org.home.models.Role;
import org.home.models.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@Repository(value = "userDAO")
@Service
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	
	/**
	 * ����� ������ ��� �����
	 * @author ogarkov_sa
	 * @since 25.12.2013 
	 */
	public class GroupsMapper implements RowMapper<Groups> {
		@Override
		public Groups mapRow(ResultSet resultSet, int i) throws SQLException {
			Groups g = new Groups();
				g.setId(resultSet.getLong("id"));
				g.setName(resultSet.getString("name"));
				g.setRole(resultSet.getLong("role"));
			return g;
		}
	}

	@Override
	public List<Users> getAllListUsers() {
		try {
			String sql = "select u.id,u.name,u.group_id,  g.name as groupName from words.users u inner join words.groups g on u.group_id=g.id";
			List<Users> list = jdbcTemplate.query(sql,  new UsersMapper());
			return list;
		} catch (Exception e) {
			logger.info("List of all users:",e);
			//@todo ������� �����
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Users getUserById(Long id) {
		try {
			String sql = "select u.id,u.name,u.group_id, g.name as groupName from words.users u inner join words.groups g on u.group_id=g.id where u.id=?";
			Users result = (Users)jdbcTemplate.queryForObject(sql, new Object[]{id}, new UsersMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get user by id:",e);
			//@todo ������� �����
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Groups> getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Groups getGroupById(Long id) {
		try {
			String sql = "select t.id, t.name, t.role from words.groups t where t.id=?";
			Groups result = (Groups)jdbcTemplate.queryForObject(sql, new Object[]{id}, new GroupsMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get group by id:",e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateGroup(Groups group) {
		String sql = "update words.groups t set t.name=?, t.role=? where t.id=?";
		try {
			jdbcTemplate.update(sql, group.getName(), group.getRole(), group.getId());
		} catch(Exception e) {
			logger.info("group update:",e);
			e.printStackTrace();
		}	
	}
	
	@Override
	public Users saveUser(final Users user) {		
		final String sql = user.isNew() ? 
				"insert into words.users(name,group_id, id) values(?,?,?)" : 
					"UPDATE words.users SET name = ?, group_id = ? WHERE id = ?";
			try{
				KeyHolder keyHolder = new GeneratedKeyHolder();
				 jdbcTemplate.update(new PreparedStatementCreator() {
				  public PreparedStatement createPreparedStatement(Connection connection)
				    throws SQLException {
				   PreparedStatement ps = connection.prepareStatement(sql,
				     new String[] {"name", "groupId", "id"});
				   		ps.setString(1, user.getName());
				   		ps.setString(2, user.getGroup().toString());
				   		ps.setString(3, user.isNew() ? null : user.getId().toString() );
				   return ps;
				 }
				}, keyHolder);
				 if(user.isNew()) {
					 user.setId((long)keyHolder.getKey().intValue());
				 }
				return user;
			} catch(Exception e) {
				logger.info("Сохранение пользователя",e);
			}
		return null;
	}

	/**
	 * ���������� jdbcTemplate
	 * @author �����
	 * @since 28.12.2013
	 * @return jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void deleteUser(Long id) throws Exception {
		String sql = "delete from words.users where id = ?";
		int row = jdbcTemplate.update(sql, id);
		if(row < 1) {
			 logger.info("�������� � ��������� ������������");
			 throw new Exception("�������� � ��������� ������������");
		}
	}


	@Override
	public Integer createRole(Role role) {
		String sql = "insert into role(role) values(?);";
		try{
			return jdbcTemplate.update(sql,role.getRole());
		} catch(NullPointerException e) {
			logger.info("��� ���� �����������",e);
			return null;
		} catch(Exception e) {
			logger.info("�������� ������ ����",e);
		}
		return null;
	}


	

	@Override
	public Role getRoleById(long id) {		
		try {
			String sql = "select t.id, t.role from words.role t where t.id = ?";
			Role result = (Role)jdbcTemplate.queryForObject(sql, new Object[]{id}, new RoleMapper());
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e) {
			logger.info("get role by id:",e);
		}
		return null;
	}
	
	
	@Override
	public List<Role> getListRoles() {
		try {
			String sql = "select t.id, t.role from words.role t";
			List<Role> list = jdbcTemplate.query(sql,  new RoleMapper());
			if(list != null && list.size() > 0) {
				return list;
			} else {
				return Collections.emptyList();
			}
		} catch (Exception e) {
			logger.info("List of all roles:",e);
			//@todo ������� �����
			e.printStackTrace();
		}
		return null;		
	}

	@Override
	public Integer updateRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer deleteRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*Map map = (Map)jdbcTemplate.query(query, new Object[]{parameters....},
		     new ResultSetExtractor() {
		       public Object extractData(ResultSet rs) throws SQLException {
		       Map map = new LinkedHashMap();
		       while (rs.next()) {
		         String col1 = rs.getString("col1");
		         String col2 = rs.getString("col2");
		         map.put(col1, col2);
		       }
		      return map;
		   };
		});*/
	
	

}
