package com.etc.travel.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.travel.dao.UserDao;
import com.etc.travel.entity.User;

@Service(value="userBiz")
public class UserBizImpl implements UserBiz{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	@Override
	public void register(User user) {
		userDao.register(user);
	}

	@Override
	public int checkUserName(String username) {

		return userDao.checkUserName(username);
	}

	@Override
	public void UpDate(String userid, String password) {
		System.out.println("imp password = "+password);
		userDao.Update(userid,password);
		
	}

	@Override
	public void UpdateDatail(String username, String email, String sex, String nickname, String userphone) {
		System.out.println("imp sex = "+sex);
		userDao.Updatedatail(username,email,sex,nickname,userphone);
		
		
	}

}
