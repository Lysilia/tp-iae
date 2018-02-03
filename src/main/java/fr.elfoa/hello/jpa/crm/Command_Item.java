package fr.elfoa.hello.jpa.crm;


import javax.persistence.*;

@Entity
public class Command_Item {
    @EmbeddedId
    private CommandItemId commandItemId;

    public Command_Item() {

    }

    public Command_Item(Integer command_ID, Integer items_ID) {
        commandItemId = new CommandItemId(command_ID, items_ID);
    }

    public Integer getCommand_ID() {
        return commandItemId.getCommand_ID();
    }

    public void setCommand_ID(Integer command_ID) {
        commandItemId.setCommand_ID(command_ID);
    }

    public CommandItemId getCommondItemId() {
        return commandItemId;
    }

    public Integer getItems_ID() {
        return commandItemId.getItems_ID();
    }

    public void setItems_ID(Integer items_ID) {
        commandItemId.setItems_ID(items_ID);
    }
}

@Embeddable
class CommandItemId{

    private Integer command_ID;

    private Integer items_ID;

    public CommandItemId(Integer command_ID, Integer items_ID) {
        this.command_ID = command_ID;
        this.items_ID = items_ID;
    }

    public CommandItemId() {

    }

    public Integer getCommand_ID(){
        return this.command_ID;
    }

    public Integer getItems_ID(){
        return this.items_ID;
    }

    public void setCommand_ID(Integer command_ID) {
        this.command_ID = command_ID;
    }

    public void setItems_ID(Integer items_ID) {
        this.items_ID = items_ID;
    }
}