package search;

import java.util.ArrayList;
import java.util.List;

import dao.DataDao;
import entity.Essay;
import entity.User;

public class SearchEssay {
	public static List<Essay> fromEssayName(String className,String essayName) {
		DataDao DBData = new DataDao();
		List<Essay> essays = DBData.queryEssays(className,essayName);
		return essays;
	}
	
	public static List<Essay> fromUserName(String className,String userName) {
		DataDao DBData = new DataDao();
		List<Essay> essays = new ArrayList<>();
		List<User> users = DBData.queryUsersByName(userName);
		for(int i = 0;i<users.size();i++) {
			List<Essay> userEssays = DBData.queryEssaysByUserID(className, users.get(i).getId());
			for(int j = 0;j<userEssays.size();j++) {
				essays.add(userEssays.get(j));
			}
		}
		return essays;
	}
	
}
