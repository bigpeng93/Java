package org.bigbird.note.controller.note;


import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {

	@Resource
	private NoteService noteservice;
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult execute(String noteId,String noteTitle,String noteBody){
		NoteResult result = noteservice.updateNote(noteId, noteTitle, noteBody);
		return result;
	}
	
}
