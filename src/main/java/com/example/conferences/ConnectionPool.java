package com.example.conferences;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Implementation of object pool pattern, used to manage database connections.
 * Created with tomcat JNDI.
 */

public class ConnectionPool {
    //static final Logger LOG = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance = null;
    private static Context context = null;
    private static DataSource ds = null;

    private ConnectionPool() {
        //private constructor for singleton
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        try {
            context = new InitialContext();
        } catch (NamingException e) {
            //LOG.error("Can`t get context", e);
        }
        try {
            ds = (DataSource) context.lookup("java:comp/env/jdbc/conferencesdb");
        } catch (NamingException e) {
            //LOG.error("Can`t create datasource", e);
        }
        return ds.getConnection();
    }
}