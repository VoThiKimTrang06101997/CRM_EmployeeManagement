package Service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import DAO.AuthDao;
import DTO.UserLoginDto;

public class AuthService {
	private AuthDao authDao;
	
	public AuthService() {
		authDao = new AuthDao();
	}

	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		UserLoginDto userLoginDto = null;
		
		try {
			userLoginDto = authDao.findUserLogin(email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		if(userLoginDto == null) {
			return false;
		}
		return BCrypt.checkpw(password, userLoginDto.getPassword());
		
	}
	
}
