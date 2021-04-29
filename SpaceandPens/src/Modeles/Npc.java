package Modeles;


public class Npc extends Enemy {
    String dialog;

    public Npc(String name, Item item, String dialog, int x, int y){
        this.name = name;
        this.object = item;
        this.dialog = dialog;
        this.position_x = x;
        this.position_y = y;
    }

    public String getDialog() { return this.dialog; }

    public Item getItem() {                                                  // Méthode permettant de récupérer les objets des pnj
        Item returnItem = this.object;
        if ( this.name.equals("crazy_man")){                                     // On vérifie qu'elle pnj c'est pour modifier son dialogue après
            this.dialog = "Mark [Crazy man] : \"I was trying to sleep on it but it’s too hard.\"";
        }
        else if( this.name.equals("samuel")){
            this.dialog = "Samuel : \" Now you can save the world.\"";
        }
        return returnItem;
    }
    
    public void removeItem()
    {
        this.object = null;
    }
}
