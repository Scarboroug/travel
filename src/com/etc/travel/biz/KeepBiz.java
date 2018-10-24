package com.etc.travel.biz;

import java.util.List;

import com.etc.travel.entity.Memory;
import com.etc.travel.entity.Travelkeep;

public interface KeepBiz {

	List<Travelkeep> selectAll();

	Travelkeep selecttravelByid(String tkid);

	void addKeep(Travelkeep keep);

	List<Memory> selectMemoryByuserid(String userid);

}
