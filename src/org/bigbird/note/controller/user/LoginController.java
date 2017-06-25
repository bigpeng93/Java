package org.bigbird.note.controller.user;

import javax.annotation.Resource;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //注入
@RequestMapping("/user")
public class LoginController {
	
	@Resource //注入
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody  //将返回值NoteResult转成Json输出
	public NoteResult execute(String name,String pwd) throws Exception{
		System.out.println(name+pwd);
		NoteResult result= userService.checkLogin(name, pwd);
		return result;
	}
}
