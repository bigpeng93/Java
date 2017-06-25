package org.bigbird.note.test;

import org.bigbird.note.dao.UserDao;
import org.bigbird.note.entity.User;

public class TestUserDao extends TestBase{
	public static void main(String[] args) {
		UserDao userDao=getContext().getBean("userDao",UserDao.class);
		User user=userDao.findByName("demo");
		if(user==null){
			System.out.println("用户名不正确");
		}else{
			System.out.println(user.getCn_user_password());
		}
	}
}
