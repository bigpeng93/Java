package org.bigbird.note.service.test;

import java.util.List;

import org.bigbird.note.entity.Note;
import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.NoteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHightSearch {
	public static void main(String[] args) {
		String conf="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		NoteService service = ac.getBean("noteServiceImpl",NoteService.class);
		NoteResult result  = service.hightSearch(null, null, null, null);
		List<Note> list=(List)result.getData();
		
		for(Note n:list){
			System.out.println(n.getCn_note_title());
			
		}
		System.out.println("搜索结果数量："+list.size());
		
	}
}
