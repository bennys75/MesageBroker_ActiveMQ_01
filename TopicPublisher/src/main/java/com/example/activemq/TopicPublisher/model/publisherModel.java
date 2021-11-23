package com.example.activemq.TopicPublisher.model;

import java.io.Serializable;

public class publisherModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String message;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
    public String toString() {
        return "SystemMessage{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
	
	
}