package fr.elfoa.hello.rest.CRUD;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    private  int adresse_id;
    private int client_id;

    public Commande() {
    }

    public Commande(Date date, int adresse_id, int client_id) {
        this.date = date;
        this.adresse_id = adresse_id;
        this.client_id = client_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
