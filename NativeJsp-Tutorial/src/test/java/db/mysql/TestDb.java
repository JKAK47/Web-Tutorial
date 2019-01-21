package db.mysql;

import org.junit.Assert;
import org.junit.Test;
import org.vincent.dao.MysqlDbUtils;
import org.vincent.dao.NewsDao;
import org.vincent.dao.model.News;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * @author PengRong
 * @package db.mysql
 * @date 2019/1/20 - 18:51
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class TestDb {

    @Test
    public void testQuery() throws IOException, SQLException {
        Properties properties = MysqlDbUtils.loadProperties("mysql.properties");
        Assert.assertNotNull(properties);
        MysqlDbUtils dbUtils = MysqlDbUtils.getConn(properties);
        Connection connection = dbUtils.getConn();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from news order by NewsID desc");
                Assert.assertNotNull(resultSet);
                System.out.println(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Test
    public void testNews() {
        System.out.println("asdf");
        NewsDao dao =new NewsDao();
        List<News> news =dao.querys();
        Assert.assertNotNull(news);
    }
}
