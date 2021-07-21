package com.example.API1.BulkMessages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API1.BulkMessages.bean.APIDetailsBean;

@Repository
public interface API15Repository extends JpaRepository<APIDetailsBean, Integer> {
	public APIDetailsBean findBymailServerId(String mail_server_id);
}
