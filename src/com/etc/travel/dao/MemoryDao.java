package com.etc.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.etc.travel.entity.Comment;
import com.etc.travel.entity.Memory;

public interface MemoryDao {

	@Select("select m.*,u.* from users u, travelmemory m where u.userid = m.userid  and memorytypeid = #{id} order by tmtime  desc limit 4;")
	List<Memory> selectMemoryByTypeId(int id);

	@Select("select m.*,u.* from users u, travelmemory m where u.userid = m.userid  and tmid = #{tmid} limit 1")
	Memory selectMemoryByTmid(String tmid);

	@Select("select m.*,u.* from users u, comment m where u.userid = m.userid  and memoryid = #{tmid} order by commentdate desc")
	List<Comment> selectCommentByTmid(String tmid);

	@SelectKey(statement="select replace(uuid(),'-','')",before=true,keyColumn="commentid",keyProperty="commentid",resultType=String.class)
	@Insert("insert into comment values(#{commentid},#{userid},#{commentcontent},now(),#{memoryid})")
	void addComment(Comment comment);

	
	@SelectKey(statement="select replace(uuid(),'-','')",before=true,keyColumn="tmid",keyProperty="tmid",resultType=String.class)
	@Insert("insert into travelmemory values(#{tmid},#{tmtitle},#{memorytypeid},#{tmimg},#{userid},now(),#{tmcontent})")
	void addMemory(Memory memory);

	//@SelectKey(statement="select replace(uuid(),'-','')",before=true,keyColumn="userid",keyProperty="userid",resultType=String.class)
	@Select("select * from travelmemory where userid = #{userid} ")
	List<Memory> selectMemoryByuserId(String userid);

	@Delete("delete from travelmemory where tmid = #{tmid}")
	void memory_listDrop(String tmid);

	

}
