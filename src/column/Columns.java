package column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DataDao;

public class Columns {
	Map<String,String> columnMap = new HashMap<String,String>();


	public Columns() {
		super();
		setColumnMap();
	}

	private void setColumnMap() {
		DataDao DBData = new DataDao(); 
		columnMap = DBData.queryColumns();
	}
	
	public Map<String, String> getColumnMap() {
		return columnMap;
	}

	public List<String> getColumnList() {
		return new ArrayList<>(columnMap.keySet());
	}


}
