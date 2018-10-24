package com.etc.travel.biz;

import com.etc.travel.entity.User;

public interface UserBiz {
	
	User login(String username,String password);

	void register(User user);

	int checkUserName(String username);
	
	void UpDate(String userid,String password);

	void UpdateDatail(String username, String email, String sex,
			String nickname, String userphone);
}
