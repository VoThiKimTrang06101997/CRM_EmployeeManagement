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
		List<Project> entities = projectRepository.findAll();
		
		
		for (Project project : entities) {
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
		
		
//		Iterator<ProjectDto> project = dtos.iterator();
//		while(project.hasNext()) {
//			ProjectDto projectDto = new ProjectDto();
//			projectDto.setId(((ProjectDto) project).getId());
//			projectDto.setName(project.getName());
//			projectDto.setDescription(project.getDescription());
//			projectDto.setStart_date(project.getStart_date());
//			projectDto.setEnd_date(project.getEnd_date());
//			projectDto.setOwner(project.getOwner());
//
//			
//			dtos.add(projectDto);
//		} 
//		project.remove();
        
		
	}
	

}
