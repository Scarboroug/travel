package com.etc.travel.control;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.etc.travel.biz.MemoryBiz;
import com.etc.travel.entity.Comment;
import com.etc.travel.entity.Memory;
import com.etc.travel.entity.User;

@Controller
public class MemoryControl {
	
	@Autowired
	private MemoryBiz memoryBiz;
	

	@RequestMapping("/memory")
	public String memory(HttpServletRequest request){
		
		List<Memory> hai = memoryBiz.selectMemoryByTypeid(1001);
		List<Memory> gu = memoryBiz.selectMemoryByTypeid(1002);
		List<Memory> chi = memoryBiz.selectMemoryByTypeid(1003);
		List<Memory> hu = memoryBiz.selectMemoryByTypeid(1004);
		request.setAttribute("hai", hai);
		request.setAttribute("gu", gu);
		request.setAttribute("chi", chi);
		request.setAttribute("hu", hu);
		return "memory/memory";
	}	
	
	@RequestMapping("/memory_detail")
	public String memoryDetail(HttpServletRequest request,String tmid){
		//��ѯ������Ϣ
		Memory memory = memoryBiz.selectMemoryByTmid(tmid);
		request.setAttribute("memory", memory);
		//��ѯ�ü����������Ϣ
		List<Comment> list = memoryBiz.selectCommentByTmid(tmid);
		request.setAttribute("comments", list);
		return "memory/memory_detail";		
	
	}
	
	@RequestMapping("/add_comment")
	public String addComment(HttpServletRequest request,String tmid,String commentcontent){
	
		User user = (User)request.getSession().getAttribute("usersession");
		if(user == null){
			request.setAttribute("msg", "û�е�¼���ܽ������ۣ����¼��");
			
			return "login/login";
		}
		
	
		Comment comment = new Comment();
		comment.setCommentcontent(commentcontent);
		comment.setMemoryid(tmid);
		comment.setCommentdate(new Date());
		comment.setUserid(user.getUserid());
		
		memoryBiz.addComment(comment);
		return  memoryDetail(request,tmid);
	}
	
	//CommonsMultipartResolver
	
	
	@RequestMapping("/add_Memory")
	public String addMemory(MultipartFile file,Memory memory,HttpServletRequest request) throws IllegalStateException, IOException{
		String oldname = file.getOriginalFilename();
		String newsstring = UUID.randomUUID().toString().replace("-", "");
		String fix = oldname.substring(oldname.indexOf("."));
		String newName = newsstring+fix;
		
	
		file.transferTo(new File("e:/workspace/travel/WebContent/images/"+newName));
		
		User user = (User)request.getSession().getAttribute("usersession");
		if(user==null){
			request.setAttribute("msg", "���¼");
			return "login/login";
		}
		//�������ɵ����ݿ�
		memory.setTmimg("/images/"+newName);
		memory.setUserid(user.getUserid());
		memoryBiz.addMemory(memory);
		return "user/memory_list.do";
		
	}
	@RequestMapping("/memory_list")
	public String memorylist(HttpServletRequest request,String userid){
		
		User u = (User)request.getSession().getAttribute("usersession");
		
		List<Memory> user = memoryBiz.selectMemoryByuserid(u.getUserid());
		
		request.setAttribute("users", user);
		
		return "user/memory_list";
	}	
	@RequestMapping("/memory_listDrop")
	public String memory_listDrop(String tmid,HttpServletRequest request) {
		User u = (User)request.getSession().getAttribute("usersession");
		memoryBiz.memory_listDrop(tmid);
		return memorylist(request,u.getUserid());
	}
}
