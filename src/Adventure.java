import java.util.Scanner;

public class Adventure {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    public Adventure(){
        init();
    }
    public void run() throws InterruptedException {
        boolean gameIsRunning = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to our adventure game!\n\nIn this game you play the character of an introverted student whose greatest fear is the social contact with other people.\nYour mission is to graduate school with the least amount of social interaction as possible. Type 'help' if you need guidance.\n\nGood luck!\n\n");
        Thread.sleep(1000);
        Room currentRoom = room1;
        System.out.println(currentRoom.getDescription());

        while (gameIsRunning) {
            String tekst = sc.next();
            if (tekst.equals("look")) {
                System.out.println("Looking around");
                Thread.sleep(1000);
                System.out.println(currentRoom.getDescription());
                continue;
            }
            if (tekst.equals("exit")) {
                System.out.println("You have exited");
                gameIsRunning = false;
                continue;
            }
            if (tekst.equals("help")) {
                System.out.println("\nTo move around type either one of these commands:\n " +
                    "\nNorth: go north/ north/ n" +
                    "\nSouth: go south/ south/ s" +
                    "\nEast: go east/ east/ e" +
                    "\nWest: go west/ west/ w" +
                    "\n\nTry one of them out now!");
                continue;
            }
            if (currentRoom == room1) {
                if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) {
                    currentRoom = room1.getEast();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")) {
                    currentRoom = room1.getSouth();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                }

            }
            if (currentRoom == room2) {
                if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) {
                    currentRoom = room2.getEast();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")) {
                    currentRoom = room2.getWest();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                }

            }
            if (currentRoom == room3) {
                if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")) {
                    currentRoom = room3.getSouth();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")) {
                    currentRoom = room3.getWest();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                }
            }

            if (currentRoom == room4) {
                if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")){
                    currentRoom = room4.getSouth();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                    currentRoom = room4.getNorth();
                    System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                    continue;
                }
            }

                if (currentRoom == room5) {
                    if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")){
                        currentRoom = room5.getSouth();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }
                }

                if(currentRoom == room6){
                    if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")){
                        currentRoom = room6.getSouth();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room6.getNorth();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }
                }

                if (currentRoom == room7){
                    if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")){
                        currentRoom = room7.getEast();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room7.getNorth();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }
                }

                if (currentRoom == room8){
                    if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room8.getNorth();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")){
                        currentRoom = room8.getWest();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    } else if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")){
                        currentRoom = room8.getEast();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }
                }

                if (currentRoom == room9){
                    if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")){
                        currentRoom = room9.getWest();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    } else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room9.getNorth();
                        System.out.println("Entering " + currentRoom.name + ". " + currentRoom.getDescription());
                        continue;
                    }
                }
            System.out.println("You search this way, but unfortunately it goes directly into a wall. Try another way!");
        }
    }
    public void init(){
        //Sætter vores run op og kører med metoden i konstruktør
        room1 = new Room("Hallway", "It is morning and you have entered the hallway of the school you're attending. Many foes lies lurking around. Be careful!");
        room2 = new Room("Staircase", "Be careful when walking up the staircase. It is almost inevitable to meet another student.");
        room3 = new Room("Codelab", "Many students vacay the room, and getting a spot alone may prove to be difficult");
        room4 = new Room("Elevator", "Empty right now. Press the 'close door' button fast!");
        room5 = new Room("Examination room", "The dark room seems to be empty. Maybe you should look around.");
        room6 = new Room("Design building", "This building is full of wild designers. Be careful.");
        room7 = new Room("Classroom", "A few students hang around here. Be careful not to make eye contact.");
        room8 = new Room("Courtyard", "Full of smokers");
        room9 = new Room("Fredagsbar", "Over-crowded place with a way too long queue for buying beverages.");
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setEast(room8);
        room7.setNorth(room4);
        room8.setWest(room7);
        room8.setEast(room9);
        room8.setNorth(room5);
        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public static void main(String[] args) throws InterruptedException {
        //kører vores program
        Adventure adventure = new Adventure();
        adventure.run();
    }
}
