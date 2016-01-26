package com.alert.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alert.common.date.DateUtil;
import com.alert.service.AliyunMNSService;
import com.alert.vo.AliyunMNS;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/mongo")
public class MongoController {
	
	@Autowired
	private AliyunMNSService aliyunMNSService;
	
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	public @ResponseBody DataResponse queryById(HttpServletRequest req, HttpServletResponse resp,@PathVariable("id") String id) {
		
		DataResponse result=new DataResponse();
					result.setResult(result.R_SUCESS);
					result.setCode("200");
					result.setData(id);
					return result;
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody DataResponse query(HttpServletRequest req, HttpServletResponse resp) {
		List<AliyunMNS> list = aliyunMNSService.query();
		DataResponse result=new DataResponse();
			result.setResult(result.R_SUCESS);
			result.setCode("200");
			result.setData(list);
			return result;
		
	}
	@RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
	public @ResponseBody DataResponse saveorupdate(HttpServletRequest req, HttpServletResponse resp,@RequestBody String body) {
		Map<String, String> paramMap = new HashMap<>();
		List<AliyunMNS> list = new ArrayList<>();
		AliyunMNS aliyunMNS = new AliyunMNS();
		AliyunMNS rtnAliyunMNS = new AliyunMNS();
		ObjectMapper mapper = new ObjectMapper();
		DataResponse result=new DataResponse();
		try {
			paramMap = mapper.readValue(body, Map.class);
			
			aliyunMNS.setMnsAccountEndpoint(paramMap.get("mnsAccountEndpoint"));
			aliyunMNS.setMnsAccesskeyId(paramMap.get("mnsAccesskeyId"));
			aliyunMNS.setMnsAccesskeySecret(paramMap.get("mnsAccesskeySecret"));
			aliyunMNS.setAppkey(paramMap.get("appkey"));
			aliyunMNS.setQueue(paramMap.get("queue"));
			
			rtnAliyunMNS = aliyunMNSService.saveOrUpdate(aliyunMNS);
			list.add(rtnAliyunMNS);
			result.setResult(result.R_SUCESS);
			result.setCode("200");
			result.setData(list);
			return result;
		} catch (IOException e) {
			result.setResult(result.R_SUCESS);
			result.setCode("414");
			result.setData(list);
			return result;
		}
		
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody DataResponse delete(HttpServletRequest req, HttpServletResponse resp,@RequestBody String body) {
		Map<String, String> paramMap = new HashMap<>();
		List<AliyunMNS> list = new ArrayList<>();
		AliyunMNS aliyunMNS = new AliyunMNS();
		AliyunMNS rtnAliyunMNS = new AliyunMNS();
		ObjectMapper mapper = new ObjectMapper();
		DataResponse result=new DataResponse();
		try {
			paramMap = mapper.readValue(body, Map.class);
			
			aliyunMNS.setAppkey(paramMap.get("appkey"));
			aliyunMNS.setDeleted(paramMap.get("deleted"));
			
			aliyunMNSService.remove(aliyunMNS);
			list.add(rtnAliyunMNS);
			result.setResult(result.R_SUCESS);
			result.setCode("200");
			result.setData("delete success");
			return result;
		} catch (IOException e) {
			result.setResult(result.R_SUCESS);
			result.setCode("414");
			result.setData("delete failed");
			return result;
		}
		
	}
}