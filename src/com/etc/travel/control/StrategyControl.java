package com.etc.travel.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etc.travel.biz.StrategyBiz;
import com.etc.travel.entity.Travelstrategy;

@Controller
public class StrategyControl {
	@Autowired
	private StrategyBiz strategyBiz;
	
	///strategy.do
	@RequestMapping("/strategy")
	public String strategy(HttpServletRequest request){
		
		List<Travelstrategy> theme = strategyBiz.selectStrategyByTypeid(1001);
		List<Travelstrategy> season = strategyBiz.selectStrategyByTypeid(2001);
		
		request.setAttribute("theme", theme);
		request.setAttribute("season", season);
		
		return "strategy/strategy";
	}
	
	
	@RequestMapping("/strategy_detail")
	public String strategy_detail(String tsid,HttpServletRequest request){
		Travelstrategy strategy = strategyBiz.strategy_detail(tsid);
		System.out.println(strategy);
		request.setAttribute("strategy", strategy);
		return "strategy/strategy_detail";
	}
}
