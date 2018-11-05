package user;

import dao.DataDao;
import entity.User;

public class UserPremission {
	public static boolean IsAdmin(User u) {
		DataDao DBData = new DataDao(); 
		if(DBData.permission(u) == 1) return true;
		else return false;
	}
}
