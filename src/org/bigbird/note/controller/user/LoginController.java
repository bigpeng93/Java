package org.bigbird.note.controller.user;

import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //ע��
@RequestMapping("/user")
public class LoginController {
	
	@Resource //ע��
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody  //������ֵNoteResultת��Json���
	public NoteResult execute(String name,String pwd) throws Exception{
		System.out.println(name+pwd);
		NoteResult result= userService.checkLogin(name, pwd);
		return result;
	}
}
