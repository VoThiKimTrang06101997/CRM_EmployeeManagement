package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.UserLoginDto;
import DbConnection.MySqlConnection;

public class AuthDao {
	// Xuống Database lấy dữ liệu lên
	public int login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = MySqlConnection.getConnection();
		
		String query = "SELECT count(*) AS result FROM user WHERE email = ? AND password = ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				return 0;
			} 
			return resultSet.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return 0;
	}

	public UserLoginDto findUserLogin(String email) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = MySqlConnection.getConnection();
		
		String query = "SELECT email, password FROM user WHERE email = ? ";
		UserLoginDto userLoginDto = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userLoginDto = new UserLoginDto();
				userLoginDto.setEmail(resultSet.getString("email"));
				userLoginDto.setPassword(resultSet.getString("password"));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return userLoginDto;
	}


	
	
}
