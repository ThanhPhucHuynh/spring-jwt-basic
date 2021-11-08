package com.example.model.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final long id;
    private final String name;


    public JwtResponse(String jwttoken, long id, String name) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.name = name;
    }


    public String getToken() {
        return this.jwttoken;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
