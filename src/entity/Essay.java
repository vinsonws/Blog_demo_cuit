package entity;

import java.io.Serializable;

public class Essay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String essayName;
	private String time;
	private String author;
	private int author_id;
	private String className;
	private String content;
	private int essayStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEssayName() {
		return essayName;
	}
	public void setEssayName(String essayName) {
		this.essayName = essayName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getEssayStatus() {
		return essayStatus;
	}
	public void setEssayStatus(int essayStatus) {
		this.essayStatus = essayStatus;
	}

}
