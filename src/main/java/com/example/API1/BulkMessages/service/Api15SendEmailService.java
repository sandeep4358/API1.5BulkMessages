package com.example.API1.BulkMessages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.BulkMessages.bean.APIDetailsBean;
import com.example.API1.BulkMessages.repository.API15Repository;

@Service
public class Api15SendEmailService {

	@Autowired
	API15Repository repository;

	public APIDetailsBean getServerDetails(String mail_server_id) {
		return repository.findBymailServerId(mail_server_id);
	}

	public APIDetailsBean saveServerDetails(APIDetailsBean details) {
		return repository.save(details);
	}
	
	public APIDetailsBean getServerInfo(APIDetailsBean details) {
		return repository.save(details);
	}
	
}
