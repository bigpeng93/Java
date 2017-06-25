package org.bigbird.note.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class NoteBook implements Serializable{
	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_notebook_type_id;
	private String cn_notebook_name;
	private String cn_notebook_desc;
	private Timestamp cn_notebook_createtime;
	
	//追加关联上属性，用于关联User
	private User user;
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param cn_notebook_createtime the cn_notebook_createtime to set
	 */
	public void setCn_notebook_createtime(Timestamp cn_notebook_createtime) {
		this.cn_notebook_createtime = cn_notebook_createtime;
	}
	/**
	 * @return the cn_notebook_id
	 */
	public String getCn_notebook_id() {
		return cn_notebook_id;
	}
	/**
	 * @param cn_notebook_id the cn_notebook_id to set
	 */
	public void setCn_notebook_id(String cn_notebook_id) {
		this.cn_notebook_id = cn_notebook_id;
	}
	/**
	 * @return the cn_user_id
	 */
	public String getCn_user_id() {
		return cn_user_id;
	}
	/**
	 * @param cn_user_id the cn_user_id to set
	 */
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	/**
	 * @return the cn_notebook_type_id
	 */
	public String getCn_notebook_type_id() {
		return cn_notebook_type_id;
	}
	/**
	 * @param cn_notebook_type_id the cn_notebook_type_id to set
	 */
	public void setCn_notebook_type_id(String cn_notebook_type_id) {
		this.cn_notebook_type_id = cn_notebook_type_id;
	}
	/**
	 * @return the cn_notebook_name
	 */
	public String getCn_notebook_name() {
		return cn_notebook_name;
	}
	/**
	 * @param cn_notebook_name the cn_notebook_name to set
	 */
	public void setCn_notebook_name(String cn_notebook_name) {
		this.cn_notebook_name = cn_notebook_name;
	}
	/**
	 * @return the cn_notebook_desc
	 */
	public String getCn_notebook_desc() {
		return cn_notebook_desc;
	}
	/**
	 * @param cn_notebook_desc the cn_notebook_desc to set
	 */
	public void setCn_notebook_desc(String cn_notebook_desc) {
		this.cn_notebook_desc = cn_notebook_desc;
	}
	/**
	 * @return the cn_notebok_createtime
	 */
	public Timestamp getCn_notebook_createtime() {
		return cn_notebook_createtime;
	}
	/**
	 * @param cn_notebok_createtime the cn_notebok_createtime to set
	 */
	public void setCn_notebok_createtime(Timestamp cn_notebook_createtime) {
		this.cn_notebook_createtime = cn_notebook_createtime;
	}
	
	
}
