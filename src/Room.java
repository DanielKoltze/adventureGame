import java.util.ArrayList;

public class Room {
    private Room east = null;
    private Room west = null;
    private Room south = null;
    private Room north = null;
    private String description;
    private String name;
    private ArrayList<Item> items = new ArrayList<>();

    public Room(String name, String description){
        this.description = description;
        this.name= name;
    }

    public Room getEast(){
        return east;
    }

    public Room getNorth(){
        return  north;
    }

    public Room getWest(){
        return west;
    }

    public Room getSouth(){
        return south;
    }

    public String getDescription() {
        return description;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public String getName() {return name;}
    public void addItemToRoom(String name){
        Item item = new Item(name);
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public int getItemSize(){
        return items.size();
    }
    public String getItemByIndex(int tal){
        return items.get(tal).getName();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public Item findItem(String itemName) {
        Item item = null;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(itemName)){
                item = items.get(i);
                items.remove(item);
                return item;
            }
        }
        return item;
    }

}
