package it.dan.homeWork.WorkWithData.dao;

import it.dan.homeWork.WorkWithData.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO<Order>{
    @Override
    public void save(Order order) {

        String sql = "INSERT INTO public.order (order_id, item_id, amount, client_id) VALUES(?,?,?,?)";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getOrder_id());
            statement.setString(2, order.getItem_id());
            statement.setInt(3, order.getAmount());
            statement.setString(4, order.getClient_id());

            statement.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public Order get(Object order_id) {
        Order order = new Order();

        String sql = "SELECT * FROM public.order WHERE order_id='" + order_id + "'";

        try (Connection        connection  = ConnectionToDB.getConnection();
             PreparedStatement statement  = connection.prepareStatement(sql);
             ResultSet rSet = statement.executeQuery()){

            while ( rSet.next() ){
                order.setOrder_id(rSet.getInt("order_id"));
                order.setClient_id(rSet.getString("client_id"));
                order.setItem_id(rSet.getString("item_id"));
                order.setAmount(rSet.getInt("amount"));
                return order;
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Order order) {

        String sql = "UPDATE order SET item_id = ?, amount = ?, client_id = ? WHERE order_id = ?";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(4, order.getOrder_id());
            statement.setString(2, order.getItem_id());
            statement.setInt(1, order.getAmount());
            statement.setString(3, order.getClient_id());

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Object order_id) {

        String sql = "DELETE FROM order WHERE order_id = ?";

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);){

            statement.setInt(1, (Integer) order_id);

            statement.executeUpdate();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
    }

    public static List<Order> getByClient(String client_id){
        List<Order> listOrders = new ArrayList<>();
        Order order = new Order();

        String sql = "SELECT * FROM public.order WHERE client_id='" + client_id + "'";

        try (Connection        connection  = ConnectionToDB.getConnection();
             PreparedStatement statement  = connection.prepareStatement(sql);
             ResultSet rSet = statement.executeQuery()){

            while ( rSet.next() ){
                order.setOrder_id(rSet.getInt("order_id"));
                order.setClient_id(rSet.getString("client_id"));
                order.setItem_id(rSet.getString("item_id"));
                order.setAmount(rSet.getInt("amount"));

                listOrders.add(order);
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        return listOrders;
    }
}
