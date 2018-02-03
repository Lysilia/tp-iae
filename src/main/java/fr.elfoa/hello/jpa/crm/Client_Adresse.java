package fr.elfoa.hello.jpa.crm;


import javax.persistence.*;

@Entity @IdClass(Client_Adresse.class)
public class Client_Adresse {

    @Id
    private Integer Client_ID;

    @Id
    private Integer adresses_ID;

    public Client_Adresse() {

    }

    public Client_Adresse(Integer client_ID, Integer adresses_ID) {
        Client_ID = client_ID;
        this.adresses_ID = adresses_ID;
    }

    public int getAdresses_ID() {
        return adresses_ID;
    }

    public void setAdresses_ID(Integer adresses_ID) {
        this.adresses_ID = adresses_ID;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(Integer client_ID) {
        Client_ID = client_ID;
    }
}
