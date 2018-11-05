package user;

import dao.DataDao;
import entity.User;

public class LoginFromCookies {
	public static User getUser(int id) {
		DataDao DBData = new DataDao(); 
		User user = DBData.queryUser(id);
		return user;
	}
}
