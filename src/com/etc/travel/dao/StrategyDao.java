package com.etc.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.etc.travel.entity.Travelstrategy;

public interface StrategyDao {

	@Select("select * from travelstrategy where stypesid = #{typeid} order by tswant desc limit 4")
	List<Travelstrategy> selectStrategyByTypeid(int i);

	@Select("select * from travelstrategy where tsid = #{tsid}")
	Travelstrategy strategy_detail(String tsid);

	
	
}
