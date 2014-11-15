package org.home.dao;

import java.util.List;

import org.home.models.Groups;
import org.home.models.Role;
import org.home.models.Users;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * DAO ���������� ��������������
 * 
 * @author ogarkov_sa
 * @since 25.12.2013
 *
 */
public interface UserDAO {
	/**
	 * ������� ���� �������������
	 * @author ogarkov_sa
	 * @since 25.12.2013
	 * @return ������ ������������� List<Users>
	 * 
	 */
	public List<Users> getAllListUsers();
	
	/**
	 * ������� ������������ �� id
	 * @author ogarkov_sa
	 * @param id ������������
	 * @since 25.12.2013
	 * @return ������������ Users
	 */	
	public Users getUserById(Long id);
	
	/**
	 * ������� ��� ������ �������������
	 * @author ogarkov_sa 
	 * @since 25.12.2013
	 * @return ������ ����� ������������� List<Groups>
	 */
	public List<Groups> getAllGroups();
	
	
	/**
	 * ������� ������ �� Id
	 * @author ogarkov_sa
	 * @since 25.12.2013
	 * @param id ������
	 * @return ������ Groups
	 */
	public Groups getGroupById(Long id);
	
	/**
	 * ���������� ������
	 * @author ogarkov_sa
	 * @since 25.12.2013
	 * @param group ������ Groups
	 */
	public void updateGroup(Groups group);
	
	/**
	 * ��������� ������������
	 * @author �����
	 * @since 26.12.2013 
	 * @param user ������������
	 * @return ���������� �������
	 */
	public Users saveUser(Users user); 
	
	/**
	 * ���������� ������� � ����
	 * @return  JdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate();
	
	/**
	 * ������� ������������ �� �������
	 * @param id - ������������
	 */
	public void deleteUser(Long id)  throws Exception;
	
	
	
	public Integer createRole(Role role);
	
	public Role getRoleById(long id);
	
	public Integer updateRole(Role role);
	
	public Integer deleteRole(Role role);
	
	public List<Role> getListRoles();
	
	
	
	

}
