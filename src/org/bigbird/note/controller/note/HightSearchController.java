package org.bigbird.note.controller.note;

import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class HightSearchController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/hightSearch.do")
	@ResponseBody
	public NoteResult execute(String title,String status,String begin,String end){		
		NoteResult result = noteService.hightSearch(title, status, begin, end);
		return result;
	}
}
