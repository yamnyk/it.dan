package it.dan.homeWork.WorkWithData.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.dan.homeWork.WorkWithData.model.Item;

public class ItemDAO {
    public static void save(Item item) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO item(article_id, name, price) VALUES(?,?,?)";

        try {
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, item.getArticleId());
            statement.setString(2, item.getName());
            statement.setInt(3, item.getPrice());

            statement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            ConnectionToDB.closeConnection(statement, connection);
        }
    }

    public static Item get(String articleId){
        Item item = new Item();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rSet = null;

        String sql = "SELECT * FROM item WHERE article_id='"+articleId+"'";

        try{
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            rSet = statement.executeQuery();
            while(rSet.next()) {
                item.setPrice(Integer.parseInt(rSet.getString("price")));
                item.setName(rSet.getString("name"));
                item.setArticleId(rSet.getString("article_id"));
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        finally{
            ConnectionToDB.closeConnection(rSet, statement, connection);
        }
        return item;
    }

    public static void update(Item item){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE client SET name = ?, price = =? WHERE article_id = ?";

        try{
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(3, item.getArticleId());
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        finally{
            ConnectionToDB.closeConnection(statement, connection);
        }
    }

    public static void delete(String article_id){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "DELETE FROM item WHERE article_id = ?";

        try{
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, article_id);

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        finally{
            ConnectionToDB.closeConnection(statement, connection);
        }
    }
}
