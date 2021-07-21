package com.example.API1.BulkMessages.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseResultBean {
	String mailTransationId;
	String statusCode;
	String description;
}
