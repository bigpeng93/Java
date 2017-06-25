package org.bigbird.note.dao;

import java.util.List;

import org.bigbird.note.entity.NoteBook;

public interface NoteBookDao {
	public List<NoteBook> findByUser(String userId);
	public void save(NoteBook book);
}
