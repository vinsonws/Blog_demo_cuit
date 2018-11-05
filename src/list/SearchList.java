package list;

import java.util.ArrayList;
import java.util.List;

import column.Columns;
import entity.Essay;
import search.SearchEssay;

public class SearchList {
	public static List<Essay> getEssayList(String searchData) {
		Columns columns = new Columns();
		List<Essay> essays = new ArrayList<>();
		for(String column:columns.getColumnList()) {
			essays.addAll(SearchEssay.fromEssayName(column, searchData));
			essays.addAll(SearchEssay.fromUserName(column, searchData));
		}
			
		return essays;
	}
	
	public static List<Essay> afterPage(List<Essay> essayList,int maxNum,int page) {
		return ListData.paging(essayList, maxNum, page);
	}
	
	public static int afterPageNum(List<Essay> essayList,int maxNum,int page) {
		return ListData.pageNum(essayList, maxNum, page);
	}
}
