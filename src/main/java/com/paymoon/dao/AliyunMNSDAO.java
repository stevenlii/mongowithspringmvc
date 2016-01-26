package com.paymoon.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.WriteResult;
import com.paymoon.common.date.DateUtil;
import com.paymoon.vo.AliyunMNS;

@Repository
@Transactional
public class AliyunMNSDAO {
	@Resource
	private MongoTemplate mongoTemplate;

	public void save(AliyunMNS a) {
		this.mongoTemplate.insert(a);
	}

	public AliyunMNS query(String appkey) {
		Query query = new Query(Criteria.where("appkey").is(appkey));
		AliyunMNS aliyunMNS = this.mongoTemplate.findOne(query, AliyunMNS.class);
		return aliyunMNS;
	}

	public List<AliyunMNS> query() {
		Query query = new Query();
		List<AliyunMNS> list = this.mongoTemplate.find(query, AliyunMNS.class);
		return list;
	}

	public AliyunMNS update(AliyunMNS a) {
		Query query = new Query(Criteria.where("appkey").is(a.getAppkey()));
		Update update = new Update();
		update.set("mnsAccountEndpoint", a.getMnsAccountEndpoint());
		update.set("mnsAccesskeyId", a.getMnsAccesskeyId());
		update.set("mnsAccesskeySecret", a.getMnsAccesskeySecret());
		update.set("queue", a.getQueue());
		update.set("timestamp",DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
		String statusCodeStr = "1";
		if (a.getStatus() != null) 
			statusCodeStr = a.getStatus() ;		
		int statusCode = Integer.valueOf(statusCodeStr);
		
		update.set("status",String.valueOf(statusCode+1));
		
		AliyunMNS p = this.mongoTemplate.findAndModify(query, update, AliyunMNS.class);
		System.out.println(p);
		p = this.mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true),
				AliyunMNS.class);// returnNew(true)将更新后的对象返回
		return p;
	}
	public void delete(AliyunMNS a) {
		Query query = new Query(Criteria.where("appkey").is(a.getAppkey()));
		Update update = new Update();
		update.set("deleted", a.getDeleted());
		update.set("timestamp",DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
		AliyunMNS p = this.mongoTemplate.findAndModify(query, update, AliyunMNS.class);
	}

	public void remove(AliyunMNS a) {
		Query query = new Query(Criteria.where("appkey").is(a.getAppkey()));
		this.mongoTemplate.findAndRemove(query, AliyunMNS.class,"aliyunMNS");// 根据query对象删除文档


		// mongoTemplate.remove(person, collection);//从指定的集合中删除文档
//		 mongoTemplate.remove(query, collectionName);//从指定的集合中根据query对象删除文档
		// mongoTemplate.remove(query, entityClass,
		// collectionName)//从指定的集合中根据query对象和class类型删除文档

	}

	public static void main(String[] args) {
		AliyunMNS aliyunMNS = new AliyunMNS();
		aliyunMNS.setMnsAccountEndpoint("111");
		aliyunMNS.setAppkey("1111");
		aliyunMNS.setMnsAccesskeyId("ididid");
		aliyunMNS.setMnsAccesskeySecret("bbbb");
		aliyunMNS.setQueue("qqqq");
		AliyunMNSDAO aliyunMNSDAO = new AliyunMNSDAO();
		aliyunMNSDAO.save(aliyunMNS);
		List<AliyunMNS> list = aliyunMNSDAO.query();
		for (AliyunMNS aliyunMNS2 : list) {
			System.out.println(aliyunMNS2.toString());

		}

	}
}