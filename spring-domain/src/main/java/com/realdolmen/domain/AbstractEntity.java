package com.realdolmen.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Version
	private int version;

	public int getVersion() {
		return version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




}
