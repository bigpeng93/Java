package org.bigbird.note.dao;

import org.bigbird.note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public int save(User user);
}
