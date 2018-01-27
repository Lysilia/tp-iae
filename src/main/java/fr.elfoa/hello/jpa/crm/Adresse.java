package fr.elfoa.hello.jpa.crm;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adresse {
    @Id
    @GeneratedValue
    private Integer id;
    private String cp;
    private Integer num;
    private String pays;
    private String voie;
    private String voietype;

    public Adresse() {
    }

    public Adresse(String cp, int num, String pays, String voie, String voietype) {
        this.cp = cp;
        this.num = num;
        this.pays = pays;
        this.voie = voie;
        this.voietype = voietype;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getVoietype() {
        return voietype;
    }

    public void setVoietype(String voietype) {
        this.voietype = voietype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
