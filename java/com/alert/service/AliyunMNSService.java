package com.alert.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.alert.vo.AliyunMNS;
import com.mongodb.WriteResult;

public interface AliyunMNSService {

	public void save(AliyunMNS a);

	public AliyunMNS saveOrUpdate(AliyunMNS a);

	public AliyunMNS queryByAppkey(String appkey);

	public List<AliyunMNS> query();

	public AliyunMNS update(AliyunMNS a);

	public void remove(AliyunMNS a);
	public void delete(AliyunMNS a);
}