package it.dan.homeWork.WorkWithData.dao;

import it.dan.homeWork.WorkWithData.model.Client;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDAOTest {

    @Test
    public void delete() {
        Client client = new Client();

        client.setLogin("GogiZurabovich");
        client.setFirstName("Gogi");
        client.setSecondName("Zurabovich");
        client.setPassword("Horhe1989 Loves Chachi1997");

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.save(client);

        clientDAO.delete(client.getLogin());

        Client deletedClient = clientDAO.get(client.getLogin());

        assertNull(deletedClient);
    }

    @Test
    public void saveAndGet() {
        Client client = new Client();

        client.setLogin("GogiZurabovich");
        client.setFirstName("Gogi");
        client.setSecondName("Zurabovich");
        client.setPassword("Horhe1989 Loves Chachi1997");

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.save(client);

        Client clientFromDB = clientDAO.get(client.getLogin());
        assertNotNull(clientFromDB);
        assertEquals(client.getFirstName(), clientFromDB.getFirstName());

        clientDAO.delete(client.getLogin());
    }

    @Ignore
    @Test
    public void update() {
        Client client = new Client();

        client.setLogin("GogiZurabovich");
        client.setFirstName("Gogi");
        client.setSecondName("Zurabovich");
        client.setPassword("Horhe1989 Loves Chachi1997");

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.save(client);

        String oldPassord = client.getPassword();
        client.setPassword("Larysa Ivanovna Hachu");
        clientDAO.update(client);

        Client clientFromDB = clientDAO.get(client.getLogin());
        assertNotNull(clientFromDB);
        assertNotEquals(oldPassord, clientFromDB.getFirstName());

        clientDAO.delete(client.getLogin());
    }
}