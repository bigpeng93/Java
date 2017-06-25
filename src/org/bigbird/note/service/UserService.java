package org.bigbird.note.service;


import org.bigbird.note.entity.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name,String pwd) throws Exception ;
	public NoteResult regist(String name,String password,String nickname) throws Exception;
}
