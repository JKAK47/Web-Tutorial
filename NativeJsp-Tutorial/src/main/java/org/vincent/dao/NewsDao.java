package org.vincent.dao;

import org.vincent.dao.model.News;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author PengRong
 * @package org.vincent.dao
 * @date 2019/1/20 - 19:48
 * @ProjectName Web-Tutorial
 * @Description: 操作news 表
 */
public class NewsDao {
    private static Connection connection = null;

    static {
        try {
            Properties properties = null;
            properties = MysqlDbUtils.loadProperties("mysql.properties");
            MysqlDbUtils dbUtils = MysqlDbUtils.getConn(properties);
            connection = dbUtils.getConn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<News> querys() {
        List<News> news = new ArrayList<>();

        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from news order by NewsID desc");
                while (resultSet.next()){
                    int NewsID = resultSet.getInt("NewsID");
                    String NewsTitle = resultSet.getString("NewsTitle");
                    String NewsContent = resultSet.getString("NewsContent");
                    String NewsTime = resultSet.getString("NewsTime");
                    String AdminName = resultSet.getString("AdminName");
                    News tempNew=new News(NewsID,NewsTitle,NewsTime,AdminName,NewsContent);
                    news.add(tempNew);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
               try {
                   connection.close();
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        }
        return news;
    }
}
