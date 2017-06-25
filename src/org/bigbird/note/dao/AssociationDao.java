package org.bigbird.note.dao;

import java.util.List;

import org.bigbird.note.entity.NoteBook;
import org.bigbird.note.entity.User;

public interface AssociationDao {
	public User findUser(String userId);
	//������󣨼��ϣ�����ӳ��
	public List<User> findAll();
	//�����������ӳ��
	public List<NoteBook> findAllBooks();
}
