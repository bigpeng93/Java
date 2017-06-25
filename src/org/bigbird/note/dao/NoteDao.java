package org.bigbird.note.dao;

import java.util.List;
import java.util.Map;

import org.bigbird.note.entity.Note;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	public void save(Note note);
	public Note findById(String noteId);
	public void update(Note note);
	public void updateStatus(String noteId);
	public List<Map> findDelete(String userId);
	public List<Note> HightSearch(Map params);
	public void dynamicUpdate(Note note);
	public int deleteNotes(String[] ids);
}
