package com.etc.travel.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.travel.dao.KeepDao;
import com.etc.travel.entity.Memory;
import com.etc.travel.entity.Travelkeep;

@Service(value="keepBiz")
public class KeepBizImpl  implements KeepBiz{

	@Autowired
	private KeepDao keepDao;
	
	@Override
	public List<Travelkeep> selectAll() {
		return keepDao.seletAll();
	}

	@Override
	public Travelkeep selecttravelByid(String tkid) {
		return keepDao.selecttravelByid(tkid);
	}

	@Override
	public void addKeep(Travelkeep keep) {
		keepDao.addKeep(keep);
	}

	@Override
	public List<Memory> selectMemoryByuserid(String userid) {
		return keepDao.selectMemoryByuserid(userid);
		
	}

}
