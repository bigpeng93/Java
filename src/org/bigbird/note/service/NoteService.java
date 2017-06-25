package org.bigbird.note.service;

import org.bigbird.note.entity.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String bookId);
	public NoteResult addNote(String noteTitle,String bookId,String userId);
	public NoteResult loadNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody);
	public NoteResult shareNote(String noteId);
	public NoteResult recycleNote(String noteId);
	public NoteResult searchNote(String keyword);
	public NoteResult loadShare(String shareId);
	public NoteResult loadDelete(String userId);
	public NoteResult hightSearch(String title,String status,String begin,String end);
}
