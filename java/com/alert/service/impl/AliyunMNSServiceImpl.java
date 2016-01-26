package com.alert.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alert.dao.AliyunMNSDAO;
import com.alert.service.AliyunMNSService;
import com.alert.vo.AliyunMNS;

@Service
@Transactional
public class AliyunMNSServiceImpl implements AliyunMNSService {

	@Autowired
	private AliyunMNSDAO aliyunMNSDAO;

	@Override
	public void save(AliyunMNS a) {
		a.setStatus("1");
		 aliyunMNSDAO.save(a);
	}

	@Override
	public AliyunMNS saveOrUpdate(AliyunMNS a) {
		AliyunMNS aliyunMNSdb = aliyunMNSDAO.query(a.getAppkey());
		if (aliyunMNSdb != null) {
			if (aliyunMNSdb.equals(a)) 
				return aliyunMNSdb;
			return aliyunMNSDAO.update(a);
		}else {
			aliyunMNSDAO.save(a);
			a.setStatus("1");
			return a;
		}
	}

	@Override
	public AliyunMNS queryByAppkey(String appkey) {
		return aliyunMNSDAO.query(appkey);
	}

	@Override
	public List<AliyunMNS> query() {
		return aliyunMNSDAO.query();
	}

	@Override
	public AliyunMNS update(AliyunMNS a) {
		return aliyunMNSDAO.update(a);
	}

	@Override
	public void remove(AliyunMNS a) {
		aliyunMNSDAO.remove(a);
	}
	@Override
	public void delete(AliyunMNS a) {
		aliyunMNSDAO.delete(a);
	}
}