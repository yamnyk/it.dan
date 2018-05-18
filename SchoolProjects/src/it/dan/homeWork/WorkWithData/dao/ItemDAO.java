package it.dan.homeWork.WorkWithData.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.dan.homeWork.WorkWithData.model.Item;

public class ItemDAO extends AbstractDAO<Item>{

    @Override
    public  void save(Item item) {


        String sql = "INSERT INTO item(article_id, name, price) VALUES(?,?,?)";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, item.getArticle_id());
            statement.setString(2, item.getName());
            statement.setInt(3, item.getPrice());

            statement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public Item get(Object articleId){
        Item item = new Item();

        String sql = "SELECT * FROM item WHERE article_id='"+articleId+"'";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rSet = statement.executeQuery();){

            while(rSet.next()) {
                item.setPrice(Integer.parseInt(rSet.getString("price")));
                item.setName(rSet.getString("name"));
                item.setArticle_id(rSet.getString("article_id"));
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void update(Item item){


        String sql = "UPDATE client SET name = ?, price = =? WHERE article_id = ?";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(3, item.getArticle_id());
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object article_id){

        String sql = "DELETE FROM item WHERE article_id = ?";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){ ;

            statement.setString(1, (String) article_id);

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
    }
}
