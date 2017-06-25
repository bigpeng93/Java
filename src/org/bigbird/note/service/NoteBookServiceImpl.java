package org.bigbird.note.service;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.bigbird.note.dao.NoteBookDao;
import org.bigbird.note.entity.NoteBook;
import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.util.NoteUtil;
import org.springframework.stereotype.Service;

@Service
public class NoteBookServiceImpl implements NoteBookService{

	@Resource
	private NoteBookDao bookDao;
	
	public NoteResult loadBooks(String userId) {
		List<NoteBook> list=bookDao.findByUser(userId);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记本成功");
		result.setData(list);
		return result;
	}

	
	public NoteResult addBook(String bookName, String userId) {
		NoteResult result=new NoteResult();
		//创建笔记本
		NoteBook book=new NoteBook();
		book.setCn_notebook_name(bookName);
		book.setCn_user_id(userId);
		book.setCn_notebook_type_id("5");
		String noteId=NoteUtil.createId();
		book.setCn_notebook_id(noteId);
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		book.setCn_notebok_createtime(createTime);
		bookDao.save(book);	//保存笔记
		result.setStatus(0);
		result.setMsg("创建笔记本成功");
		result.setData(noteId); 	//返回笔记本ID
		return result;
	}
	

}
