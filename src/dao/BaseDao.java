package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseDao<T,U> implements IDao<T,U> {
	public boolean update(String sql,Object...values){
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = UntilDb.getConn();
			pstmt = connection.prepareStatement(sql);
			int parameterIndex = 1;
			for (Object value : values) {
				pstmt.setObject(parameterIndex, value);
				parameterIndex++;
			}
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false ;
		}finally{
			UntilDb.closeAll(connection, pstmt,null);
			
		}
	}
}
