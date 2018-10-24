package com.etc.travel.control;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.etc.travel.biz.UserBiz;
import com.etc.travel.biz.UserBizImpl;
import com.etc.travel.entity.User;
import com.mysql.jdbc.Driver;

@Controller   //扫描注解后创建对象
public class UserController {
	
	@Autowired//从spring的工厂中拿适合的匹配的对象给下面的属性
	private UserBiz UserBiz;
	
	/**
	 * 注销登录
	 */
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	
	}
	/**
	 * 注册
	 */
	@RequestMapping("/register")
	public String RegisterableService(User u,String checkcode,HttpServletRequest request) {
		String code = (String)request.getSession().getAttribute("code");
		if(!code.equalsIgnoreCase(checkcode)) {
			request.setAttribute("msg", "验证码错误！");
			return "login/register";
		}
		UserBiz.register(u);
		request.setAttribute("un", u.getUsername());
		request.setAttribute("password", u.getPassword());
		return "login/login";
		
	}
	
	
	@RequestMapping("/login")
	//当页面中的name的值和参数的名字一致的时候，可以直接把数据封装到参数上，不一致则不行
	public String login(String username,String password,String checkcode,HttpServletRequest request){
		//获取图片上的字符验证码
		String code = (String)request.getSession().getAttribute("code");
		if(!code.equalsIgnoreCase(checkcode)) {
			request.setAttribute("msg", "验证码错误！");
			return "login/login";
		}
		//获取用户名和密码
		User user = UserBiz.login(username, password);
		if(user==null){
			request.setAttribute("msg","登录密码错误！");
			return "login/login";
		}
		else
		{
			request.getSession().setAttribute("usersession", user);
		return "index";
		}
	}
	@RequestMapping("/password_change")
	public String Update(HttpServletRequest request, String oldpassword,String password, String newpassword){
		//判断验证码
		User user = (User) request.getSession().getAttribute("usersession");
		System.out.print(user.getPassword());
		System.out.println("userid = "+ user.getUserid());
		if(oldpassword.equals(user.getPassword())){
			if(password.equals(newpassword)){
				user.setPassword(password);
				System.out.println(user.getPassword());
				UserBiz.UpDate(user.getUserid(),user.getPassword());
			}
		}

		return "/login/login";
	}
	@RequestMapping("/account_detail")
	public String UpdateDatail(HttpServletRequest request,String email,String sex,String nickname,String userphone){
		User user = (User) request.getSession().getAttribute("usersession");
		System.out.println(sex);
		UserBiz.UpdateDatail(user.getUsername(),email,sex,nickname,userphone);
		return "/user/account_detail";
	}
	@RequestMapping("/checkUserNameExit")
	public @ResponseBody int checkUserNameExit(String username) {
		int flag = UserBiz.checkUserName(username);
		return flag;
	}
	
	
	//InternalResourceViewResolver  视图解析器
	
	
	
}
