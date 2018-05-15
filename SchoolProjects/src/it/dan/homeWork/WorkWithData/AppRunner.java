package it.dan.homeWork.WorkWithData;

import it.dan.homeWork.WorkWithData.dao.ClientDAO;
import it.dan.homeWork.WorkWithData.dao.ItemDAO;
import it.dan.homeWork.WorkWithData.dao.OrderDAO;
import it.dan.homeWork.WorkWithData.model.Client;
import it.dan.homeWork.WorkWithData.model.Item;
import it.dan.homeWork.WorkWithData.model.Order;

public class AppRunner {

    public static void main(String[] args) {

        /*Client client = new Client();

        client.setLogin("testLogin");
        client.setPassword("12345");
        client.setFirstName("Alex");
        client.setSecondName("Ignatenko");

        ClientDAO.save(client);

        Item item = new Item();

        item.setArticleId("12345");
        item.setName("GogiDall");
        item.setPrice(150); //price by cents

        ItemDAO.save(item);*/

        Order order = new Order();

        order.setOrderId(777);
        order.setItemId("12345");
        order.setAmount(558);
        order.setClientId("testLogin");

        OrderDAO.save(order);
    }
}