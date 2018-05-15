package it.dan.homeWork.WorkWithData.dao;

import it.dan.homeWork.WorkWithData.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public static void save(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO public.order (order_id, item_id, amount, client_id) VALUES(?,?,?,?)";

        try {
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getItemId());
            statement.setInt(3, order.getAmount());
            statement.setString(4, order.getClientId());

            statement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            ConnectionToDB.closeConnection(statement, connection);
        }

    }

    public static Order get(Integer order_id){
        Order order = new Order();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rSet = null;

        String sql = "SELECT * FROM order WHERE order_id ='"+order_id+"'";

        try{
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            rSet = statement.executeQuery();
            while(rSet.next()) {
                order.setOrderId(rSet.getInt("order_id"));
                order.setItemId(rSet.getString(2));
                order.setAmount(rSet.getInt("amount"));
                order.setClientId(rSet.getString(4));
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        finally{
            ConnectionToDB.closeConnection(rSet, statement, connection);
        }
        return order;
    }

    public static void update(Order order){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE order SET item_id = ?, amount = ?, client_id = ? WHERE order_id = ?";

        try{
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(4, order.getOrderId());
            statement.setString(2, order.getItemId());
            statement.setInt(1, order.getAmount());
            statement.setString(3, order.getClientId());

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        finally{
            ConnectionToDB.closeConnection(statement, connection);
        }
    }

    public static void delete(Integer order_id){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "DELETE FROM order WHERE order_id = ?";

        try{
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, order_id);

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        finally{
            ConnectionToDB.closeConnection(statement, connection);
        }
    }

    public static List<Order> getClientOrders(String client_id){
        List<Order> orders = new ArrayList<>();
        //TODO: realisation that gives all orders by clientId

        return null;
    }
}
