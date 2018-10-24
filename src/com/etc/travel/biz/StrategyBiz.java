package com.etc.travel.biz;

import java.util.List;

import com.etc.travel.entity.Travelstrategy;

public interface StrategyBiz {

	List<Travelstrategy> selectStrategyByTypeid(int i);

	Travelstrategy strategy_detail(String tsid);

}
