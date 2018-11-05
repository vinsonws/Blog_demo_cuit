package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import entity.Essay;
import entity.User;

public class DataDao extends BaseDao<Essay, User> {

	@Override
	public boolean deleteEssay(Essay e) {
		String sql = "DELETE FROM "+ e.getClassName() +" WEHRE id = ?";
		return update(sql,e.getId());
	}

	@Override
	public boolean insertEssay(Essay e) {
		String sql = "INSERT INTO "+ e.getClassName() +"(essayName,author_id,class,content,essayStatus,time) VALUES(?,?,?,?,?,?)";
		return update(sql,e.getEssayName(),e.getAuthor_id(),e.getClassName(),e.getContent(),e.getEssayStatus(),(new Date()));
	}

	@Override
	public boolean updateEssay(Essay e) {
		String sql = "UPDATE "+ e.getClassName() +" SET essayName = ?, author_id = ?, class = ?, content = ?, essayStatus = ? WHERE id = ?";
		return update(sql,e.getEssayName(),e.getAuthor_id(),e.getClassName(),e.getContent(),e.getEssayStatus(),e.getId());
	}

	@Override
	public boolean deleteUser(int id) {
		String sql = "DELETE FROM users WEHRE id = ?";
		return update(sql,id);
	}

	@Override
	public boolean insertUser(User u) {
		String sql = "INSERT INTO users	(userName,password) VALUES(?,?)";
		return update(sql,u.getUserName(),u.getPassword());
	}

	@Override
	public boolean updateUser(User u) {
		String sql = "UPDATE users SET userName = ?, password = ? WHERE id = ?";
		return update(sql,u.getUserName(),u.getPassword(),u.getId());
	}

	@Override
	public User queryUser(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where id = ?";
		User user = new User();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			user.setId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public Essay queryEssay(String className,int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "+ className +" where id = ?  ORDER BY id DESC";
		Essay essay = new Essay();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			essay.setId(rs.getInt(1));
			essay.setEssayName(rs.getString(2));
			essay.setTime(rs.getString(3));
			essay.setAuthor_id(rs.getInt(4));
			essay.setClassName(rs.getString(5));
			essay.setContent(rs.getString(6));
			essay.setEssayStatus(rs.getInt(7));
			return essay;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public User queryUser(String userName, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where userName = ? and password = ?";
		User user = new User();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			rs.next();
			user.setId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public List<Essay> queryEssays(String className) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "+ className +" ORDER BY id DESC";
		List<Essay> essayList = new ArrayList<Essay>();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Essay essay = new Essay();
				essay.setId(rs.getInt(1));
				essay.setEssayName(rs.getString(2));
				essay.setTime(rs.getString(3));
				essay.setAuthor_id(rs.getInt(4));
				essay.setClassName(rs.getString(5));
				essay.setContent(rs.getString(6));
				essay.setEssayStatus(rs.getInt(7));
				essayList.add(essay);
			}
			return essayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public List<User> queryUsers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users ";
		List<User> userList = new ArrayList<User>();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public List<User> queryUsersByName(String userName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where userName = ?";
		List<User> userList = new ArrayList<User>();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public List<Essay> queryEssays(String className, String essayName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "+ className +" where essayName = ?  ORDER BY id DESC";
		List<Essay> essayList = new ArrayList<Essay>();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, essayName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Essay essay = new Essay();
				essay.setId(rs.getInt(1));
				essay.setEssayName(rs.getString(2));
				essay.setTime(rs.getString(3));
				essay.setAuthor_id(rs.getInt(4));
				essay.setClassName(rs.getString(5));
				essay.setContent(rs.getString(6));
				essay.setEssayStatus(rs.getInt(7));
				essayList.add(essay);
			}
			return essayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public List<Essay> queryEssaysByUserID(String className, int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "+ className +" where author_id = ? ORDER BY id DESC";
		List<Essay> essayList = new ArrayList<Essay>();
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Essay essay = new Essay();
				essay.setId(rs.getInt(1));
				essay.setEssayName(rs.getString(2));
				essay.setTime(rs.getString(3));
				essay.setAuthor_id(rs.getInt(4));
				essay.setClassName(rs.getString(5));
				essay.setContent(rs.getString(6));
				essay.setEssayStatus(rs.getInt(7));
				essayList.add(essay);
			}
			return essayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public Map<String, String> queryColumns() {
		Map<String, String> columns = new  HashMap<String,String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from navs";
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				columns.put(rs.getString(2), rs.getString(3));
			}
			return columns;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public String queryColumn(String className) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from navs where nav = ?";
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, className);
			rs = pstmt.executeQuery();
			rs.next();		
			return rs.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public int permission(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from userpermission where userID = ?";
		try {
			conn = UntilDb.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getId());
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(2);
		} catch (SQLException e) {
			return 0;
		} finally {
			UntilDb.closeAll(conn, pstmt, rs);
		}
	}

	@Override
	public int setPermission(User u) {
		String sql = "INSERT INTO userpermission (userID,permissionID) VALUES(?,?)";
		update(sql, u.getId(), 2);
		return 2;
	}


}
