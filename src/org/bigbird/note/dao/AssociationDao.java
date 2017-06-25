package org.bigbird.note.dao;

import java.util.List;

import org.bigbird.note.entity.NoteBook;
import org.bigbird.note.entity.User;

public interface AssociationDao {
	public User findUser(String userId);
	//多个对象（集合）关联映射
	public List<User> findAll();
	//单个对象关联映射
	public List<NoteBook> findAllBooks();
}
