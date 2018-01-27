package fr.elfoa.hello.jpa.crm;


import javax.persistence.*;

@Entity
public class Command_Item {
    @EmbeddedId
    private CommandItemId commandItemId;

  /*  @Id
    @ManyToOne(targetEntity = Commande.class)
    private Integer Command_ID;

    @Id
    @ManyToOne(targetEntity = Item.class)
    private Integer items_ID;*/

    public Command_Item() {
    }

    public Command_Item(Integer command_ID, Integer items_ID) {
        //Command_ID = command_ID;
        //this.items_ID = items_ID;
        commandItemId = new CommandItemId(command_ID, items_ID);
    }

  /*  public Integer getCommand_ID() {
        return Command_ID;
    }

    public void setCommand_ID(Integer command_ID) {
        Command_ID = command_ID;
    }

    public Integer getItems_ID() {
        return items_ID;
    }

    public void setItems_ID(Integer items_ID) {
        this.items_ID = items_ID;
    }*/
}

@Embeddable
class CommandItemId{

    private Integer Command_ID;

    private Integer items_ID;

    public CommandItemId(Integer command_ID, Integer items_ID) {
        Command_ID = command_ID;
        this.items_ID = items_ID;
    }
}