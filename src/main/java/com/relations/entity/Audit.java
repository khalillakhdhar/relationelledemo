package com.relations.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@MappedSuperclass
@Data
public class Audit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
private Date dateCreation;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date dateUpdate;	
}
