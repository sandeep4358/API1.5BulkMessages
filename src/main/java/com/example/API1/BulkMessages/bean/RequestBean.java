package com.example.API1.BulkMessages.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestBean {
	String requestId;
	String sentMessage;
	APIDetailsBean apiDtl;	
}
