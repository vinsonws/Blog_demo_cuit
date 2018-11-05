package article;

import dao.DataDao;
import entity.Essay;

public class DoEssay {
	public static boolean insertEssay(Essay essay) {
		DataDao DBData = new DataDao(); 
		return DBData.insertEssay(essay);
	}
	
	public static boolean deleteEssay() {
		return false;
	}
	
	public static boolean passEssay(Essay essay) {
		DataDao DBData = new DataDao(); 
		essay.setEssayStatus(3);
		return DBData.updateEssay(essay);
	}
	
	public static boolean failedEssay(Essay essay) {
		DataDao DBData = new DataDao(); 
		essay.setEssayStatus(1);
		return DBData.updateEssay(essay);
	}
}
