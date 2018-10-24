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

@Controller   //ɨ��ע��󴴽�����
public class UserController {
	
	@Autowired//��spring�Ĺ��������ʺϵ�ƥ��Ķ�������������
	private UserBiz UserBiz;
	
	/**
	 * ע����¼
	 */
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	
	}
	/**
	 * ע��
	 */
	@RequestMapping("/register")
	public String RegisterableService(User u,String checkcode,HttpServletRequest request) {
		String code = (String)request.getSession().getAttribute("code");
		if(!code.equalsIgnoreCase(checkcode)) {
			request.setAttribute("msg", "��֤�����");
			return "login/register";
		}
		UserBiz.register(u);
		request.setAttribute("un", u.getUsername());
		request.setAttribute("password", u.getPassword());
		return "login/login";
		
	}
	
	
	@RequestMapping("/login")
	//��ҳ���е�name��ֵ�Ͳ���������һ�µ�ʱ�򣬿���ֱ�Ӱ����ݷ�װ�������ϣ���һ������
	public String login(String username,String password,String checkcode,HttpServletRequest request){
		//��ȡͼƬ�ϵ��ַ���֤��
		String code = (String)request.getSession().getAttribute("code");
		if(!code.equalsIgnoreCase(checkcode)) {
			request.setAttribute("msg", "��֤�����");
			return "login/login";
		}
		//��ȡ�û���������
		User user = UserBiz.login(username, password);
		if(user==null){
			request.setAttribute("msg","��¼�������");
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
		//�ж���֤��
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
	
	
	//InternalResourceViewResolver  ��ͼ������
	
	
	
}
