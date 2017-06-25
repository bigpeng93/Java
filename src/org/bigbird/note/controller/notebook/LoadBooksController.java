package org.bigbird.note.controller.notebook;

import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.NoteBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notebook")
public class LoadBooksController {
	
	@Resource
	private NoteBookService bookService;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result=bookService.loadBooks(userId);
		System.out.println(userId);
		return result;
	}
}
