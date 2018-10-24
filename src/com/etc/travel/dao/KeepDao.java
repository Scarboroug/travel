package com.etc.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.etc.travel.entity.Memory;
import com.etc.travel.entity.Travelkeep;

public interface KeepDao {

	@Select("select t.* ,u.* from travelkeep t ,users u where t.userid = u.userid and tkbegintime > sysdate() order by tkbegintime asc, tktime desc ")
	List<Travelkeep> seletAll();

	
	@Select("select t.* ,u.* from travelkeep t ,users u where t.userid = u.userid and tkid=#{tkid}")
	Travelkeep selecttravelByid(String tkid);


	@SelectKey(statement="select replace(uuid(),'-','')",before=true,keyColumn="tkid",keyProperty="tkid",resultType=String.class)
	@Insert("insert into travelkeep values(#{tkid},#{tktitle},#{tkdestination},#{tkbegintime},#{tkaftertime},#{userid},now(),#{tkphone},#{tkdetails},#{tkimg})")
	void addKeep(Travelkeep keep);

	@Select("select * from travelkeep userid = #{userid}")
	List<Memory> selectMemoryByuserid(String userid);

}
