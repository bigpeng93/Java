package org.bigbird.note.dao;

import java.util.List;
import java.util.Map;

import org.bigbird.note.entity.Share;

public interface ShareDao {
	public void save(Share share);
	public Share findByNoteId(String noteId);
	public List<Map> findLikeTitle(String keyword);
	public Share findById(String id);
}
