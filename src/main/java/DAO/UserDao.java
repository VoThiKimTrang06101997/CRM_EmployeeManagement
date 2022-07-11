package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import DTO.UserCreateDto;
import DbConnection.MySqlConnection;
import Model.Role;
import Model.User;

public class UserDao {
	
	public List<User> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<User> users = new LinkedList<>();
		List<Role> roles = new ArrayList<>();
		
		Connection connection = MySqlConnection.getConnection();
		String query = "SELECT u.id as id, u.name as name, u.email as email, u.phone as phone, "
				+ "r.id as role_id, r.name as role_name, r.description as role_description "
				+ "FROM user u, role r WHERE u.role_id = r.id";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				
				int roleId = resultSet.getInt("role_id");
				Role role = getRoleFromList(roles, roleId);
				
				if(role == null) {
					role = new Role();
					role.setId(resultSet.getInt("role_id"));
					role.setName(resultSet.getString("role_name"));
					role.setDescription(resultSet.getString("role_description"));
					roles.add(role);
					
				}
				user.setRole(role);
				users.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return users ;
	}



	public void deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM user WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	private Role getRoleFromList(List<Role> roles, int roleId) {
		// TODO Auto-generated method stub
		for (Role role : roles) {
			if(role.getId() == roleId)
				return role;
		}
		return null;
	}
	
	public void add(UserCreateDto dto) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO user(email, password, name, address, phone, role_id)"
				+ "VALUES(?,?,?,?,?,?)";
		
		Connection connection = MySqlConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setNString(1, dto.getEmail());
			preparedStatement.setNString(2, dto.getPassword());
			preparedStatement.setNString(3, dto.getName());
			preparedStatement.setNString(4, dto.getAddress());
			preparedStatement.setNString(5, dto.getPhone());
			preparedStatement.setInt(6, dto.getRoleId());
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
