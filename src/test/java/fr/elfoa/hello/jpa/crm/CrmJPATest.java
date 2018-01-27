package fr.elfoa.hello.jpa.crm;

import fr.elfoa.hello.jpa.crm.*;
import org.eclipse.persistence.annotations.PrimaryKey;
import org.eclipse.persistence.internal.jpa.config.columns.PrimaryKeyImpl;
import org.eclipse.persistence.jpa.config.Id;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.Date;


/**
 * @author Leonor Perquy
 */
public class CrmJPATest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm-database");
    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void getClientTest(){
        Client a = em.find(Client.class, 1000);

        Assert.assertEquals("client1@isima.fr", a.getMail());
    }

    @Test
    public void addItemToDBTest(){
        Item test = new Item(20, 300, "ItemTest");
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals(new Integer(20), test.getSize());
        Item testFind = em.find(Item.class, test.getId());
        Assert.assertEquals(test.getWeight(), testFind.getWeight());

    }

    @Test
    public void addClientToDBTest(){
        Client test = new Client("client@isima.fr", "tata", "titi", "0707070707");
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals("tata", test.getNom());
        Client testFind = em.find(Client.class, test.getId());
        Assert.assertEquals(test.getPrenom(), testFind.getPrenom());

    }

    @Test
    public void addAdressToDBTest(){
        Adresse test = new Adresse("63007", 42, "France", "ISIMA", "rue");
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals(new Integer(42), test.getNum());
        Adresse testFind = em.find(Adresse.class, test.getId());
        Assert.assertEquals(test.getVoie(), testFind.getVoie());
    }

    @Test
    public void addCommandToDBTest(){
        Commande test = new Commande(new Date(2, 6, 2018), 20, 10);
        tx.begin();
        em.persist(test);
        tx.commit();

      //  Assert.assertEquals(new Integer(20), test.getAdresse_id());
        Commande testFind = em.find(Commande.class, test.getId());
        Assert.assertEquals(new Date(2, 6, 2018), testFind.getDate());

    }

    @Test
    public void addClientAdressToDBTest(){
        Client_Adresse test = new Client_Adresse(5, 6);
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals(6, test.getAdresses_ID());
        Client_Adresse testFind = em.find(Client_Adresse.class, test.getClient_ID());
        Assert.assertEquals(test.getAdresses_ID(), testFind.getAdresses_ID());
    }

    @Test
    public void addItemCommandItemToDBTest(){
        Command_Item test = new Command_Item(5, 6);
        tx.begin();
        em.persist(test);
        tx.commit();


     /*   Assert.assertEquals(new Integer(6), test.getItems_ID());
        Command_Item testFind = em.find(Command_Item.class, test.getCommand_ID());
        Assert.assertEquals(test.getItems_ID(), testFind.getItems_ID());*/
    }
}