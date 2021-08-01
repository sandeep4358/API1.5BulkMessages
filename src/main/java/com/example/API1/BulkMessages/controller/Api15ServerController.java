package com.example.API1.BulkMessages.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API1.BulkMessages.bean.APIDetailsBean;
import com.example.API1.BulkMessages.bean.RequestBean;
import com.example.API1.BulkMessages.bean.ResponseResultBean;
import com.example.API1.BulkMessages.service.Api15SendEmailService;

@RestController
@RequestMapping("/rest/auth/")
@EnableEurekaClient
public class Api15ServerController {

	@Autowired
	Api15SendEmailService service;

	@PostMapping(path = "/save/serverDatils")
	public APIDetailsBean saveServerDeatils(@RequestBody APIDetailsBean serverBean) {
		System.out.println("saving the server details................");
		return service.saveServerDetails(serverBean);
	}
	
	
	@PostMapping(path = "/sendMessage")
	public ResponseResultBean sendMessage(@RequestBody RequestBean requestBean) {
		ResponseResultBean result = new ResponseResultBean(null, null, null);
		
		Optional<APIDetailsBean> optional = Optional.ofNullable(service.getServerDetails(requestBean.getApiDtl().getMailServerId()));
		APIDetailsBean apiDetailsBean = null;
		if(optional.isPresent()) {
			apiDetailsBean = optional.get();
			result.setStatusCode(apiDetailsBean.getApiDescription());
		}		
		
		return result;
	}
	
	@PostMapping(path = "/getServerDeatils")
	public APIDetailsBean getMailServerDeatils(@RequestBody APIDetailsBean bean) {		
		
		Optional<APIDetailsBean> optional = Optional.ofNullable(service.getServerDetails(bean.getMailServerId()));
		APIDetailsBean apiDetailsBean = null;
		if(optional.isPresent()) {
			apiDetailsBean = optional.get();		
			apiDetailsBean = service.getServerDetails(apiDetailsBean.getMailServerId());
		}else {
			apiDetailsBean = new APIDetailsBean();
			apiDetailsBean.setApiDescription("Error :-- No mail server present");
		}
		
		return apiDetailsBean;
	}
}
