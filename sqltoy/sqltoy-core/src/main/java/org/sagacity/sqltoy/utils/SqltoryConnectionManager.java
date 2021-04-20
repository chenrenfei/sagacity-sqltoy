package org.sagacity.sqltoy.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SqltoryConnectionManager implements ConnectionManager {
    static class ConnectionHoder {
        static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

        public static Connection get() {
            return connectionThreadLocal.get();
        }

        public static void set(Connection conn) {
            connectionThreadLocal.set(conn);
        }
    }

    @Override
    public String name() {
        return "sqltoy";
    }


    @Override
    public Connection getConnection(DataSource datasource) {
        try {
            Connection conn = ConnectionHoder.get();
            if (null == conn || conn.isClosed()) {
                conn = datasource.getConnection();
            }
            ConnectionHoder.set(conn);
            conn.setAutoCommit(false);
            System.out.println("conn======" + conn);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void commit() {
        Connection conn = ConnectionHoder.get();
        if (null != conn) {
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        Connection conn = ConnectionHoder.get();
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void rollback() {
        Connection conn = ConnectionHoder.get();
        if (null != conn) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    @Override
    public void releaseConnection(Connection conn, DataSource datasource) {
        try {
            //sqltoy是手动管理事务,无需实现
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
