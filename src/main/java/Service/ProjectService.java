package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DTO.ProjectDto;
import Model.Project;
import Repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		projectRepository = new ProjectRepository();
	}
	
	public List<ProjectDto> getAll() {
		List<ProjectDto> dtos = new ArrayList<ProjectDto>();
		List<ProjectDto> entities = projectRepository.findAll();
		
		
		for (ProjectDto project : entities) {
			ProjectDto projectDto = new ProjectDto();
			projectDto.setId(project.getId());
			projectDto.setName(project.getName());
			projectDto.setDescription(project.getDescription());
			projectDto.setStart_date(project.getStart_date());
			projectDto.setEnd_date(project.getEnd_date());
			projectDto.setOwner(project.getOwner());
			
			dtos.add(projectDto);
			
		}
		
		return dtos;	
	}
	
	public void insert(ProjectDto projectDto) {
		ProjectDto entity = new ProjectDto();
		
		// entity.setId(projectDto.getId());
		entity.setName(projectDto.getName());
		entity.setDescription(projectDto.getDescription());
		entity.setStart_date(projectDto.getStart_date());
		entity.setEnd_date(projectDto.getEnd_date());
		entity.setOwner(projectDto.getOwner());
		try {
			projectRepository.add(projectDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};	
	}

	public void update(ProjectDto projectDto) throws SQLException {
		ProjectDto entity = projectRepository.findById(projectDto.getId());
		
		if(entity != null) {
			entity.setId(projectDto.getId());
			entity.setName(projectDto.getName());
			entity.setDescription(projectDto.getDescription());
			entity.setStart_date(projectDto.getStart_date());
			entity.setEnd_date(projectDto.getEnd_date());
			entity.setOwner(projectDto.getOwner());
		}
		projectRepository.add(entity);
	}

}
