package org.bigbird.note.service;


import java.io.IOException;

import javax.annotation.Resource;

import org.bigbird.note.dao.UserDao;
import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.entity.User;
import org.bigbird.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //ɨ��Service���

public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;//ע��
	
	@Transactional(readOnly=true,rollbackFor=IOException.class)
	public NoteResult checkLogin(String name, String pwd) throws Exception {
		NoteResult result=new NoteResult();
		User user=userDao.findByName(name);
		
		//�������null��˵����name��ѯ���������㣬��ʾname�����ݿⲻ����
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//�������user��Ϊnull��˵���û�����ȷ��Ȼ��ȶ�����
		//���û������pwd�������
		String md5_pwd = NoteUtil.md5(pwd);
		//�����ݿ�����ȶ�
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("���벻��ȷ");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û�����������ȷ");
		result.setData(user.getCn_user_id());//�����û�ID
		return result;
	}
	

	public NoteResult regist(String name, String password, String nickname) throws Exception {
		NoteResult result=new NoteResult();
		//����û����Ƿ񱻵���
		User has_user=userDao.findByName(name);
		if(has_user !=null){
			result.setStatus(1);
			result.setMsg("�û����ѱ�ռ��");
			return result;
		}
		//ע��
		User user=new User();
		user.setCn_user_name(name);			//�����û���
		user.setCn_user_nick(nickname);		//�����ǳ�
		String md5_pwd=NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);	//���ü��ܺ������
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId); 		//����ID
		//����UserDao����
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
	}
}
