package org.bigbird.note.dao.test;

import org.bigbird.note.dao.NoteDao;
import org.bigbird.note.entity.Note;
import org.bigbird.note.test.TestBase;

public class TestDynamicUpdate extends TestBase{
	public static void main(String[] args) {
		NoteDao noteDao=getContext().getBean("noteDao", NoteDao.class);
		//测试动态更新，回收站恢复笔记
		Note note = new Note();
		note.setCn_note_status_id("1");
		note.setCn_notebook_id("0001");
		note.setCn_note_id("051538a6-0f8e-472c-8765-251a795bc88f");
		noteDao.dynamicUpdate(note);
	}
}
