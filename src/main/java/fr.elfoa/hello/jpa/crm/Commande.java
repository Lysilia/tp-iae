package fr.elfoa.hello.jpa.crm;




import javax.persistence.*;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Integer id;
    private Date date;

    private Client_Adresse clientAdresse;
   /* @ManyToOne(targetEntity = Adresse.class)
    private  Integer adresse_id;
    @ManyToOne(targetEntity = Client.class)
    private Integer client_id;*/

    public Commande() {
    }

    public Commande(Date date, Integer adresse_id, Integer client_id) {
        this.date = date;
        this.clientAdresse = new Client_Adresse(adresse_id, client_id);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

 /*   public Integer getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(Integer adresse_id) {
        this.adresse_id = adresse_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}