package org.bigbird.note.controller.notebook;

import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.NoteBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notebook")
public class AddBookController {
	
	@Resource
	private NoteBookService bookService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String bookName,String userId){
		NoteResult result = bookService.addBook(bookName, userId);
		return result;		
	}
}
