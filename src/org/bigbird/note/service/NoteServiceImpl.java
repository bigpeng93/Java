package org.bigbird.note.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.bigbird.note.dao.NoteDao;
import org.bigbird.note.dao.ShareDao;
import org.bigbird.note.entity.Note;
import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.entity.Share;
import org.bigbird.note.util.NoteUtil;
import org.springframework.stereotype.Service;



@Service
public class NoteServiceImpl implements NoteService{

	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	
	public NoteResult loadNotes(String bookId) {
		List<Map> list=noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}

	public NoteResult addNote(String noteTitle, String bookId, String userId) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		note.setCn_note_title(noteTitle);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		noteDao.save(note);
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(noteId);
		return result;
	}

	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findById(noteId);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(note);
		return result;
	}

	public NoteResult updateNote(String noteId, String noteTitle, String noteBody) {
		NoteResult result = new NoteResult();
		//更新
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.update(note);
		result.setStatus(0);
		result.setMsg("更新笔记成功");
		return result;		
	}

	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//检查该笔记是否分享过
		System.out.println("noteId:"+noteId);
		Share has_share=new Share();
		has_share = shareDao.findByNoteId(noteId);
		System.out.println(has_share.toString());
		if(has_share!=null){
			result.setStatus(1);
			result.setMsg("该笔记已经被分享过");
			return result;
		}
		//未被分享，分享处理
		Note note = noteDao.findById(noteId);
		System.out.println(note);
		Share share = new Share();
		share.setCn_share_title(note.getCn_note_title());
		System.out.println("share_title:"+share.getCn_share_title());
		share.setCn_share_body(note.getCn_note_body());
		System.out.println("share_body:"+share.getCn_share_body());
		share.setCn_note_id(noteId);
		
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		System.out.println(share);
		shareDao.save(share);
		System.out.println("-----");
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		return result;
	}

	
	public NoteResult recycleNote(String noteId) {
		noteDao.updateStatus(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("删除笔记成功");
		return result;
	}

	public NoteResult searchNote(String keyword) {
		System.out.println(keyword);
		NoteResult result = new NoteResult();
		if(keyword != null && !"".equals(keyword)){
			keyword = "%"+keyword+"%";
		}else{
			keyword="%";	
		}
		List<Map> list=shareDao.findLikeTitle(keyword);
		System.out.println("list:"+list);
		result.setStatus(0);
		result.setMsg("检索分享笔记成功");
		result.setData(list);
		return result;
	}

	public NoteResult loadShare(String shareId) {
		NoteResult result = new NoteResult();
		Share share=shareDao.findById(shareId);
		result.setStatus(0);
		result.setMsg("查询分享笔记成功");
		result.setData(share);
		return result;
	}


	public NoteResult loadDelete(String userId) {
		NoteResult result = new NoteResult();
		List<Map> list = noteDao.findDelete(userId);
		result.setStatus(0);
		result.setMsg("查询回收站信息成功");
		result.setData(list);
		return result;
	}


	public NoteResult hightSearch(String title, String status, String begin, String end) {
		System.out.println(title+status+begin+end);
		Map params= new HashMap();
		//如果标题不为空，就添加map参数
		if(title!=null&&!"".equals(title)){
			title="%"+title+"%";
			params.put("title", title);
			
		}
		//如果状态没有选择全部，就添加map参数
		if(status !=null && "0".equals(status)){
			params.put("status", status);
		}
		//如果开始日期不为空，就添加map参数
		if(begin != null){
			//将字符串转成日期（Long表示）
			Date begindate = java.sql.Date.valueOf(begin);
			params.put("deginDate", begindate.getTime());
		}
		//如果结束日期不为空，就添加map参数
		if(end !=null){
			//将字符串转成日期（Long表示）
			Date enddate= java.sql.Date.valueOf(end);
			params.put("endDate",enddate.getTime());
		}
		//调用dao
		List<Note> list=noteDao.HightSearch(params);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("搜索成功");
		result.setData(list);
		return result;
	}	
}
