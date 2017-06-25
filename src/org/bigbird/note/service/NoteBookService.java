package org.bigbird.note.service;

import org.bigbird.note.entity.NoteResult;

public interface NoteBookService {
	public NoteResult loadBooks(String userId);
	public NoteResult addBook(String bookName,String userId);
}
