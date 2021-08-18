package com.example.conferences;

/**
 * Pool of SQL queries
 */
public enum SQL {
    ADD_USER("INSERT INTO users" +
            " (username, email, password) VALUES " +
            " (?, ?, ?)");


    private final String query;

    SQL(String query){
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
}