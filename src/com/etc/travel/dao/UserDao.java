package com.etc.travel.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import com.etc.travel.entity.User;

public interface UserDao {
	
	@Select("select * from users where username = #{username} and password =#{password} limit 1")
	User login(@Param("username")String username,@Param("password")String password);

	
	@SelectKey(statement="select replace(uuid(),'-','')",before=true,keyColumn="userid",keyProperty="userid",resultType=String.class)//×Ö·ûÖ÷¼ü
	@Insert("INSERT INTO users VALUES (#{userid},#{username}, #{password}, #{userphone}, #{email}, #{sex}, #{userstate}, #{nickname}, #{usercount})")
	void register(User user);

	@Select("select count(*) from users where username = #{username}")
	int checkUserName(String username);


	@SelectKey(statement="select replace(uuid(),'-','')",before=true,keyColumn="userid",keyProperty="userid",resultType=String.class)//×Ö·ûÖ÷¼ü
	@Update("update users set password = #{1} where userid=#{0}")
	void Update(String userid,String password);

	@Update("update users set email=#{1},sex=#{2},nickname=#{3},userphone=#{4} where username=#{0}")
	void Updatedatail(String username, String email, String sex,
			String nickname, String userphone);
	
}
