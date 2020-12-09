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
        return returnItem;
    }
}
