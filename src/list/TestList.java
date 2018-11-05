package list;

import java.util.ArrayList;
import java.util.List;

import column.Columns;
import entity.Essay;

public class TestList {
	public static List<Essay> EssayTesting() {
		Columns columns = new Columns();
		List<Essay> essays = new ArrayList<>();
		for(String column:columns.getColumnList()) {
			essays.addAll(EssayList.listMenuOnlyTesting(column, 20, 1));
		}
		EssayList.listGetAuthorName(essays);
		return essays;
	}
}
