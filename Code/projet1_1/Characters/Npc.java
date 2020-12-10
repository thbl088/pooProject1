package Characters;

import Items.*;

public class Npc extends Enemy {
    String dialog;

    public Npc(String name, Item item){
        this.name = name;
        this.object = item;
    }

    public Npc(String name, Item item, String dialog){
        this.name = name;
        this.object = item;
        this.dialog = dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getDialog() { return this.dialog; }

    public Item getItem() {
        Item returnItem = this.object;
        object = null;
        if ( this.name.equals("crazy_man")){
            this.dialog = "Mark [Crazy man] : \"I was trying to sleep on it but it’s too hard.\"";
        }
        else if( this.name.equals("samuel")){
            this.dialog = "Samuel : \" Now you can save the world.\"";
        }
        return returnItem;
    }
}
