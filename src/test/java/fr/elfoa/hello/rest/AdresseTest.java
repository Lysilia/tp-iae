package fr.elfoa.hello.rest;

import fr.elfoa.hello.rest.CRUD.Adresse;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;

import static org.junit.Assert.assertEquals;

public class AdresseTest extends JerseyTest {


    @Override
    protected Application configure() {
        return new ResourceConfig(Adresse.class);
    }


    @Before
    public void addAdresses(){
        target("adresse/69007/37/France/Jean Jaures/avenue").request().post(Entity.form(new Form()));
        target("adresse/63007/56/France/Blaise Pascal/avenue").request().post(Entity.form(new Form()));
        target("adresse/54000/23/France/des Jardiniers/rue").request().post(Entity.form(new Form()));
        target("adresse/57000/5/France/Saint Vincent/rue").request().post(Entity.form(new Form()));
        int a = target("adresse").request().get(int.class);
        assertEquals(4, a);
    }

    @Test
    public void testGet(){
        int a = target("adresse").request().get(int.class);
        assertEquals(4,  a);

        int num = target("adresse/num/3").request().get(int.class);
        assertEquals(5, num);

        String cp = target("adresse/cp/2").request().get(String.class);
        assertEquals("54000", cp);

        String pays = target("adresse/pays/0").request().get(String.class);
        assertEquals("France", pays);

        String voie = target("adresse/voie/1").request().get(String.class);
        assertEquals("Blaise Pascal", voie);

        String voietype = target("adresse/voietype/3").request().get(String.class);
        assertEquals("rue", voietype);
    }

    @Test
    public void testPut() {
        target("adresse/newCp/75000/2").request().put(Entity.form(new Form()));
        String cp = target("adresse/cp/2").request().get(String.class);
        assertEquals("75000", cp);

        target("adresse/newNum/641/0").request().put(Entity.form(new Form()));
        int num = target("adresse/num/0").request().get(int.class);
        assertEquals(641, num);

        target("adresse/newPays/CANADA/1").request().put(Entity.form(new Form()));
        String pays = target("adresse/pays/1").request().get(String.class);
        assertEquals("CANADA", pays);

        target("adresse/newVoie/Lapointe/2").request().put(Entity.form(new Form()));
        String voie = target("adresse/voie/2").request().get(String.class);
        assertEquals("Lapointe", voie);

        target("adresse/newVoieType/avenue/3").request().put(Entity.form(new Form()));
        String voietype = target("adresse/voietype/3").request().get(String.class);
        assertEquals("avenue", voietype);


    }

    @After
    public void testDelete(){
        target("adresse/delete/0").request().delete();
        target("adresse/delete/0").request().delete();
        target("adresse/delete/0").request().delete();
        target("adresse/delete/0").request().delete();
        int a = target("adresse").request().get(int.class);
        assertEquals(0, a);
    }
}