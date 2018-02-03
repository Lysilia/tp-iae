package fr.elfoa.hello.rest.CRUD;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Command_Item {
    @Id
    private int Command_ID;

    private int items_ID;

    public Command_Item() {
    }

    public Command_Item(int command_ID, int items_ID) {
        Command_ID = command_ID;
        this.items_ID = items_ID;
    }

    public int getCommand_ID() {
        return Command_ID;
    }

    public void setCommand_ID(int command_ID) {
        Command_ID = command_ID;
    }

    public int getItems_ID() {
        return items_ID;
    }

    public void setItems_ID(int items_ID) {
        this.items_ID = items_ID;
    }
}
