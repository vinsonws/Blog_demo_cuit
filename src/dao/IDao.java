package dao;

import java.util.List;
import java.util.Map;

public interface IDao<E,U> {
	int permission(U u);
	int setPermission(U u);
	boolean deleteEssay(E e);
	boolean insertEssay(E e);
	boolean updateEssay(E e);
	boolean deleteUser(int id);
	boolean insertUser(U u);
	boolean updateUser(U u);
	U queryUser(int id);
	E queryEssay(String className,int id);
	U queryUser(String userName, String password);
	List<E> queryEssays(String className);
	List<E> queryEssays(String className,String essayName);
	List<E> queryEssaysByUserID(String className,int id);
	List<U> queryUsers();
	List<U> queryUsersByName(String userName);
	
	String queryColumn(String className);
	Map<String, String> queryColumns();
}
