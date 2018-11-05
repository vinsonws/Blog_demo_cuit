package user;

import dao.DataDao;
import entity.User;

public class RegisterOneUser {
	public static User register(String userName, String password) {
		DataDao DBData = new DataDao(); 
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		DBData.insertUser(user);
		user = DBData.queryUser(userName, password);
		DBData.setPermission(user);
		return user;
	}
}
