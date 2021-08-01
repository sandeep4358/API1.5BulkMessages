package com.example.API1.BulkMessages.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apidetails_bean")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIDetailsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int apiID;

	@Column(name = "description")
	String apiDescription;

	@Column(name = "attachment_flag")
	String containsAttachmentFalg;

	String mailServerId;

}
