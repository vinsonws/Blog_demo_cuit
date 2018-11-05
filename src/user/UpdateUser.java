package user;

import dao.DataDao;
import entity.User;

public class UpdateUser {
	public static User updateUserPwd(User user,String pwd) throws Exception {
		DataDao DBData = new DataDao(); 
		user.setPassword(pwd);
		try {
			DBData.updateUser(user);
		} catch (Exception e) {
			throw new Exception("用户密码更改错误，重新登录");
		}
		return user;
	}
}
