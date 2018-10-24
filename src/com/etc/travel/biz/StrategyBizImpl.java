package com.etc.travel.biz;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.travel.dao.StrategyDao;
import com.etc.travel.entity.Travelstrategy;
@Service(value="strategyBiz")
public class StrategyBizImpl implements StrategyBiz{
	@Autowired
	private StrategyDao strategyDao;
	
	@Override
	public List<Travelstrategy> selectStrategyByTypeid(int i) {
		return strategyDao.selectStrategyByTypeid(i);
	}

	@Override
	public Travelstrategy strategy_detail(String tsid) {
		return strategyDao.strategy_detail(tsid);
	}

}
