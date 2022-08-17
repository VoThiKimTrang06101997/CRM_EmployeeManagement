package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ProjectDto;
import DbConnection.MySqlConnection;
import Model.Project;

public class ProjectRepository {
	public List<Project> findAll() {
		List<Project> projects = new ArrayList<Project>();
		Connection connection = MySqlConnection.getConnection();

		String query = "SELECT * FROM project";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Project entity = new Project();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				entity.setStart_date(resultSet.getDate("start_date"));
				entity.setEnd_date(resultSet.getDate("end_date"));
				entity.setOwner(resultSet.getInt("owner"));

				projects.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}
		return projects;
	}
	
	public void add(ProjectDto projectDto) throws SQLException {
		String query = "INSERT INTO project(name, description, start_date, end_date, owner) VALUES(?,?,?,?,?)";
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, projectDto.getName());
			preparedStatement.setString(2, projectDto.getDescription());
			preparedStatement.setDate(3, projectDto.getStart_date());
			preparedStatement.setDate(4, projectDto.getEnd_date());
			preparedStatement.setInt(5, projectDto.getOwner());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public void edit(ProjectDto projectDto) throws SQLException {
		String query = "UPDATE project SET name=?, description=?, start_date=?, end_date=?, owner=? "
				+ "WHERE id=?";
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setNString(1, projectDto.getName());
			preparedStatement.setNString(2, projectDto.getDescription());
			preparedStatement.setDate(3, projectDto.getStart_date());
			preparedStatement.setDate(4, projectDto.getEnd_date());
			preparedStatement.setInt(5, projectDto.getOwner());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public ProjectDto findById(int id) {
		String query = "SELECT * FROM role WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		
		ProjectDto entity = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			// Thực thi câu lệnh truy vấn
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Chuyển dữ liệu qua Role entity
			while(resultSet.next()) {
				entity = new ProjectDto();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				entity.setStart_date(resultSet.getDate("start_date"));
				entity.setEnd_date(resultSet.getDate("end_date"));
				entity.setOwner(resultSet.getInt("owner"));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
		
	}
}
