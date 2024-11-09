package com.hotel.notification.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity // This tells Hibernate to make a table out of this class




public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

