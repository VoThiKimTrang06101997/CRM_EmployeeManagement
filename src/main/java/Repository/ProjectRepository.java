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
}
