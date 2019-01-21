package org.vincent.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author PengRong
 * @package org.vincent.dao.model
 * @date 2019/1/20 - 19:07
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class MysqlDbUtils {
    private static volatile MysqlDbUtils instance;
    private  Connection conn;            //连接对象

    public Connection getConn() {
        return conn;
    }

    private void setConn(Connection conn) {
        this.conn = conn;
    }

    private MysqlDbUtils() {

    }

    /**
     * load Properties
     * @param filePath classpath 文件
     * @return
     * @throws IOException
     */
    public static Properties loadProperties(String filePath) throws IOException {
        ClassLoader classLoader = MysqlDbUtils.class.getClassLoader();
        InputStream inputStream = null;
        if (classLoader != null) {
            inputStream = classLoader.getResourceAsStream(filePath);
        } else {
            inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        }
        Properties properties = new Properties();
        if (inputStream != null) {
            properties.load(inputStream);
        }
        return properties;
    }

    public static MysqlDbUtils getConn(Properties properties) {
        if (instance == null) {
            synchronized (MysqlDbUtils.class) {
                if (instance == null) {
                    try {
                        String MySqlDriver = properties.getProperty("jdbc.driver_class");
                        String MySqlURL = properties.getProperty("jdbc.url");
                        String userName = properties.getProperty("jdbc.username");
                        String password = properties.getProperty("jdbc.password");
                        Class.forName(MySqlDriver).newInstance();
                        Connection conn = DriverManager.getConnection(MySqlURL, userName, password);
                        instance =new MysqlDbUtils();
                        instance.setConn(conn);
                        return instance;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        //return "操作数据库出错，请仔细检查" ;
                        //System.err.println(e.getMessage());
                    }
                }
            }
        } else {
            return instance;
        }
        return null;
    }
}
