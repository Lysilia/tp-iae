package fr.elfoa.hello.rest.CRUD;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client_adresse {
    @Id
    private int Client_ID;

    private int adresses_ID;

    public Client_adresse() {
    }

    public Client_adresse(int client_ID, int adresses_ID) {
        Client_ID = client_ID;
        this.adresses_ID = adresses_ID;
    }
    public int getAdresses_ID() {
        return adresses_ID;
    }

    public void setAdresses_ID(int adresses_ID) {
        this.adresses_ID = adresses_ID;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int client_ID) {
        Client_ID = client_ID;
    }

}
