package list;

import java.util.List;

import dao.DataDao;
import entity.Essay;

public class EssayList {
	public static String getZHName(String className) {
		DataDao DBData = new DataDao(); 
		return DBData.queryColumn(className);
	}
	
	public static int getEssayListPageNum(String className,int maxNum,int page) {
		DataDao DBData = new DataDao(); 
		List<Essay> essayList = DBData.queryEssays(className);
		return ListData.pageNum(essayList, maxNum, page);		
	}
	
	public static List<Essay> listMenuOnlyPass(String className,int maxNum,int page) {
		DataDao DBData = new DataDao(); 
		List<Essay> essayList = DBData.queryEssays(className);
		essayList = ListData.removeFailed(essayList);
		essayList = ListData.removeTesting(essayList);
		List<Essay> afterList = ListData.paging(essayList, maxNum, page);
		return afterList;
	}
	
	public static List<Essay> listMenuOnlyPass(String className,int maxNum) {
		DataDao DBData = new DataDao(); 
		List<Essay> essayList = DBData.queryEssays(className);
		essayList = ListData.removeFailed(essayList);
		essayList = ListData.removeTesting(essayList);
		List<Essay> afterList = ListData.paging(essayList, maxNum, 1);
		return afterList;
	}
	
	public static List<Essay> listMenuOnlyTesting(String className,int maxNum,int page) {
		DataDao DBData = new DataDao(); 
		List<Essay> essayList = DBData.queryEssays(className);
		essayList = ListData.removeFailed(essayList);
		essayList = ListData.removePass(essayList);
		List<Essay> afterList = ListData.paging(essayList, maxNum, page);
		return afterList;
	}
	
	public static List<Essay> listMenuAll(String className,int maxNum,int page) {
		DataDao DBData = new DataDao(); 
		List<Essay> essayList = DBData.queryEssays(className);
		List<Essay> afterList = ListData.paging(essayList, maxNum, page);
		return afterList;
	}
	
	public static List<Essay> listGetAuthorName(List<Essay> essayList) {
		DataDao DBData = new DataDao(); 
		for(Essay essay:essayList) {
			essay.setAuthor(DBData.queryUser(essay.getAuthor_id()).getUserName());
		}
		return essayList ;
	}
}
