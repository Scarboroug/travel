package com.etc.travel.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.travel.dao.MemoryDao;
import com.etc.travel.entity.Comment;
import com.etc.travel.entity.Memory;
@Service(value="memoryBiz")
public class MemoryBizImpl implements MemoryBiz {
	@Autowired
	private MemoryDao memoryDao;
	
	@Override
	public List<Memory> selectMemoryByTypeid(int i) {
		return memoryDao.selectMemoryByTypeId(i);
	}

	@Override
	public Memory selectMemoryByTmid(String tmid) {
		return memoryDao.selectMemoryByTmid(tmid);
	}

	@Override
	public List<Comment> selectCommentByTmid(String tmid) {
		return memoryDao.selectCommentByTmid(tmid);
	}

	@Override
	public void addComment(Comment comment) {
		memoryDao.addComment(comment);
	}

	@Override
	public void addMemory(Memory memory) {
		memoryDao.addMemory(memory);
	}

	@Override
	public List<Memory> selectMemoryByuserid(String userid) {
		// TODO Auto-generated method stub
		return memoryDao.selectMemoryByuserId(userid);
	}

	@Override
	public void memory_listDrop(String tmid) {
		// TODO Auto-generated method stub
		memoryDao.memory_listDrop(tmid);
		
	}

}
