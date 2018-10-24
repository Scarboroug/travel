package com.etc.travel.biz;

import java.util.List;

import com.etc.travel.entity.Comment;
import com.etc.travel.entity.Memory;

public interface MemoryBiz {

	List<Memory> selectMemoryByTypeid(int i);

	Memory selectMemoryByTmid(String tmid);

	List<Comment> selectCommentByTmid(String tmid);

	void addComment(Comment comment);

	void addMemory(Memory memory);

	List<Memory> selectMemoryByuserid(String userid);

	void memory_listDrop(String tmid);


}
