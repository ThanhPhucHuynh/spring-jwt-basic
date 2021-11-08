package com.example.model.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private long id;
    private String name;
    private String email;
    private String password;

    //default constructor for JSON Parsing
    public JwtRequest()
    {
    }

    public JwtRequest(long id, String name, String email, String password) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "JwtRequest [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
    
}