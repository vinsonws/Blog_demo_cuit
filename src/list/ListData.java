package list;

import java.util.ArrayList;
import java.util.List;


import entity.Essay;


public class ListData {
	
	public static List<Essay> removePass(List<Essay> essayList) {
		List<Essay> afterEssayList = new ArrayList<>();
		for(Essay essay:essayList) {
			if(essay.getEssayStatus() != 3) {
				afterEssayList.add(essay);
			}
		}
		return afterEssayList;
	}
	
	public static List<Essay> removeTesting(List<Essay> essayList) {
		List<Essay> afterEssayList = new ArrayList<>();
		for(Essay essay:essayList) {
			if(essay.getEssayStatus() != 2) {
				afterEssayList.add(essay);
			}
		}
		return afterEssayList;
	}
	
	public static List<Essay> removeFailed(List<Essay> essayList) {
		List<Essay> afterEssayList = new ArrayList<>();
		for(Essay essay:essayList) {
			if(essay.getEssayStatus() != 1) {
				afterEssayList.add(essay);
			}
		}
		return afterEssayList;
	}
	
	
	
	public static List<Essay> paging(List<Essay> essayList,int maxNum,int page) {
		List<Essay> afterList = new ArrayList<Essay>();
		for(int i = 0; i<essayList.size();i++) {
			if(i >= page*maxNum - maxNum && i < page*maxNum) {
				afterList.add(essayList.get(i));
			}
		}
		
		return afterList;
	}
	
	public static int pageNum(List<Essay> essayList,int maxNum,int page) {
		int pages = 0;
		if(essayList.size()<maxNum) {
			pages = 1;
		} else if (essayList.size() % maxNum == 0) {
			pages = essayList.size() / maxNum;
		} else {
			pages = (essayList.size() / maxNum) + 1;
		}
		return pages;
	}
	
	/*
	public static List<Essay> paging(List<Essay> essayList,int maxNum,int page) {
		List<Essay> afterList = new ArrayList<Essay>();
		for(int i = 0; i<essayList.size();i++) {
			if(i >= page*maxNum - maxNum && i < page*maxNum) {
				afterList.add(essayList.get(i));
			}
		}
		
		return afterList;
	}
	*/
}
