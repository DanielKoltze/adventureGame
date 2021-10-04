public class Room {
    private Room east = null;
    private Room west = null;
    private Room south = null;
    private Room north = null;
    private String description;
    private String name;


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
}
