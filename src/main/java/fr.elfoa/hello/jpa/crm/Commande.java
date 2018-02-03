package fr.elfoa.hello.jpa.crm;




import javax.persistence.*;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Integer id;
    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client_Adresse clientAdresse;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}