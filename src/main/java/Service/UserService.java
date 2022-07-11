package Service;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import DAO.UserDao;
import DTO.UserCreateDto;
import Model.User;
import Util.PasswordUtils;

public class UserService {
	private UserDao userDao;
	private BCrypt encoder;
	
	public UserService() {
		userDao = new UserDao();
		encoder = new BCrypt();
	}
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users = null;
		try {
			users = userDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		try {
			userDao.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void add(UserCreateDto dto) {
		// TODO Auto-generated method stub
		String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		dto.setPassword(hashedPassword);
		
		try {
			userDao.add(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
