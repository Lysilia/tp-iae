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

    // ---------------- tests CREATE ------------------------------

    @Test
    public void createClientToDBTest(){
        Client test = new Client("client@isima.fr", "tata", "titi", "0707070707");
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals("tata", test.getNom());
        Client testFind = em.find(Client.class, test.getId());
        Assert.assertEquals(test.getPrenom(), testFind.getPrenom());
    }

    @Test
    public void createAdressToDBTest(){
        Adresse test = new Adresse("63007", 42, "France", "ISIMA", "rue");
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals(new Integer(42), test.getNum());
        Adresse testFind = em.find(Adresse.class, test.getId());
        Assert.assertEquals(test.getVoie(), testFind.getVoie());
    }

    @Test
    public void createCommandToDBTest(){
        Commande test = new Commande(new Date(2, 6, 2018), 20, 10);
        tx.begin();
        em.persist(test);
        tx.commit();

        //  Assert.assertEquals(new Integer(20), test.getAdresse_id());
        Commande testFind = em.find(Commande.class, test.getId());
        Assert.assertEquals(new Date(2, 6, 2018), testFind.getDate());

    }

    @Test
    public void createClientAdressToDBTest(){
        Client_Adresse test = new Client_Adresse(5, 6);
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals(6, test.getAdresses_ID());
        Client_Adresse testFind = em.find(Client_Adresse.class, test);
        Assert.assertEquals(test.getAdresses_ID(), testFind.getAdresses_ID());
    }

    @Test
    public void createCommandItemToDBTest(){
        Command_Item test = new Command_Item(5, 6);
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals(new Integer(6), test.getItems_ID());
        Command_Item testFind = em.find(Command_Item.class, test.getCommondItemId());
        Assert.assertEquals(test, testFind);
    }

    // ---------------- tests READ ------------------------------

    @Test
    public void readClientTest(){
        Client c = em.find(Client.class, 1000);
        Assert.assertEquals("client1@isima.fr", c.getMail());
    }

    @Test
    public void readItemToDBTest() {
        Item testFind1 = em.find(Item.class, 1);
        Assert.assertEquals("Brosse a dent", testFind1.getLabel());

        Item testFind2 = em.find(Item.class, 2);
        Assert.assertEquals("Cotton tige", testFind2.getLabel());

        Item testFind3 = em.find(Item.class, 3);
        Assert.assertEquals("Baume à lèvre", testFind3.getLabel());
    }

    // ---------------- tests UPDATE ------------------------------

    @Test
    public void updateClientTest(){

        // update du numero de telephone du client à l'ID 1000

        Client clientOrigine = em.find(Client.class, 1000);
        Assert.assertEquals("0606060606", clientOrigine.getTelephone());

        tx.begin();
        clientOrigine.setTelephone("0101010101");
        tx.commit();

        Assert.assertEquals("0101010101", clientOrigine.getTelephone());
    }

    // ---------------- tests DELETE ------------------------------

    @Test
    public void deleteClientToDBTest(){

        // create d'un client

        Client test = new Client("client@isima.fr", "tata", "titi", "0707070707");
        tx.begin();
        em.persist(test);
        tx.commit();

        Assert.assertEquals("tata", test.getNom());
        Client testFind = em.find(Client.class, test.getId());
        Assert.assertEquals(test.getPrenom(), testFind.getPrenom());

        // delete de ce client

        tx.begin();
        em.remove(test);
        tx.commit();

        Client testFind1 = em.find(Client.class, test.getId());
        Assert.assertNull(testFind1);
    }






}