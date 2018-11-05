package article;

import dao.DataDao;
import entity.Essay;

public class EssayOne {
	public static Essay TheEssay(String className, int essay_id) {
		DataDao DBData = new DataDao(); 
		Essay essay = DBData.queryEssay(className, essay_id);
		essay.setAuthor(DBData.queryUser(essay.getAuthor_id()).getUserName());
		return essay;
	}
}
