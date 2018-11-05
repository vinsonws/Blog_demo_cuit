package user;

import dao.DataDao;
import entity.User;

public class DoLogin {
	public static User doLog(String userName,String password) {
		DataDao DBData = new DataDao(); 
		User user = DBData.queryUser(userName, password);
		return user;	
	}
}
