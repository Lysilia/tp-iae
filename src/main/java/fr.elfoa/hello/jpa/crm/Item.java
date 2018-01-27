package fr.elfoa.hello.jpa.crm;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Pierre Colomb
 */
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer size;

    private Integer weight;
    private String label;

    public Item(Integer size, Integer weight, String label) {
        this.size = size;
        this.weight = weight;
        this.label = label;
    }

    public Item(){}
    public Integer getSize() {
        return size;
    }



    public Integer getWeight() {
        return weight;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
