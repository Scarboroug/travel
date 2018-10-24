package com.etc.travel.control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.etc.travel.biz.KeepBiz;
import com.etc.travel.entity.Memory;
import com.etc.travel.entity.Travelkeep;
import com.etc.travel.entity.User;

@Controller
public class TravelKeepControl {

	@Autowired
	private KeepBiz keepBiz;
	
	@RequestMapping("/traveller")
	public String traveller(HttpServletRequest request){
		List<Travelkeep>  list = keepBiz.selectAll();
		request.setAttribute("travel", list);
		return "traveller/traveller";
	}
	
	
	@RequestMapping("/traveller_detail")
	public String travellerDetail(HttpServletRequest request,String tkid){
		Travelkeep  keep = keepBiz.selecttravelByid(tkid);
		request.setAttribute("keep", keep);
		return "traveller/traveller_detail";
	}
	
	
	//add_keep
	@RequestMapping("/add_keep")
	public String addKeep(MultipartFile file ,Travelkeep keep,HttpServletRequest request) throws IllegalStateException, IOException{
		String oldname = file.getOriginalFilename();
		String newsstring = UUID.randomUUID().toString().replace("-", "");
		String fix = oldname.substring(oldname.indexOf("."));
		String newName = newsstring+fix;
		
		//System.out.println(newsstring   +"    "+fix);
		//保持图片到本地图片服务器
		file.transferTo(new File("e:/workspace/travel/WebContent/images/"+newName));
		
		User user = (User)request.getSession().getAttribute("usersession");
		if(user==null){
			request.setAttribute("msg", "请登录");
			return "login/login";
		}
		
		keep.setUserid(user.getUserid());
		keep.setTkimg("/images/"+newName);
		
		
		keepBiz.addKeep(keep);
		return "user/travel_add";
	}
	@RequestMapping("/travel_list")
	public String memorylist(HttpServletRequest request,String userid){
		
		User u = (User)request.getSession().getAttribute("usersession");
		
		List<Memory> user = keepBiz.selectMemoryByuserid(u.getUserid());
		
		request.setAttribute("users", user);
		
		return "user/travel_list";
	}	
}
