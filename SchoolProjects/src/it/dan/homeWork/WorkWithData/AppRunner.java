package it.dan.homeWork.WorkWithData;

import it.dan.homeWork.WorkWithData.dao.ClientDAO;
import it.dan.homeWork.WorkWithData.dao.ItemDAO;
import it.dan.homeWork.WorkWithData.dao.OrderDAO;
import it.dan.homeWork.WorkWithData.model.Client;
import it.dan.homeWork.WorkWithData.model.Item;
import it.dan.homeWork.WorkWithData.model.Order;

public class AppRunner {

    public static void main(String[] args) {

        fillDB(15);


    }

    private static void fillDB(int N) {
        fillClient(N);
        fillItem(N);
        fillOrder(N);
    }

    private static void fillClient(int N) {
        for (int i = 0; i < N; i++) {
            Client client = new Client();

            client.setLogin("client_" + i);
            client.setPassword(randomWord(6,8) + createRandom(999,9999));
            client.setFirstName(randomWord(5, 9));
            client.setSecondName(randomWord(7, 11));

            ClientDAO.save(client);
        }
    }

    private static void fillItem(int N) {
        for (int i = 0; i < N; i++) {
            Item item = new Item();

            item.setName(randomWord(5,8));
            item.setArticleId(Integer.toString(i));
            item.setPrice(createRandom(99,9999)); //price by cents

            ItemDAO.save(item);
        }
    }

    private static void fillOrder(int N) {
        for (int i = 0; i < N; i++) {
            Order order = new Order();

            order.setOrderId(createRandom(99,9999));
            order.setItemId(Integer.toString(i));
            order.setAmount(createRandom(1, 99));
            order.setClientId("client_" + i);

            OrderDAO.save(order);
        }
    }

    private static String randomWord(int min, int max) {
        String chars = "qwertyuiopasdfghjklzxcvbnm";

        StringBuilder sb = new StringBuilder();
        int N = createRandom(min, max);
        for (int i = 0; i < N; i++) {
            int randomChar = (int) (Math.random() * 10);
            sb.append(chars.charAt(randomChar));
        }
        return sb.toString();
    }

    private static int createRandom(int min, int max) {
        return (int) (min + (Math.random() * (max - min + 1)));
    }
}