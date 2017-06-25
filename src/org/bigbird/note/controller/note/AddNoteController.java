package org.bigbird.note.controller.note;

import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	
	@Resource
	private NoteService noteservice;
	
	@RequestMapping("add.do")
	@ResponseBody
	public NoteResult execute(String noteTitle, String bookId, String userId){
		NoteResult result = noteservice.addNote(noteTitle, bookId, userId);
		
		return result;
		
		
	}
}
