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
        System.out.println("Welcome to my adventure game");
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
                //skriv hvilke kommandoer der er
                continue;
            }
            if (currentRoom == room1) {
                if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) {
                    currentRoom = room1.getEast();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")) {
                    currentRoom = room1.getSouth();
                    System.out.println(currentRoom.getDescription());
                    continue;
                }

            }
            if (currentRoom == room2) {
                if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) {
                    currentRoom = room2.getEast();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")) {
                    currentRoom = room2.getWest();
                    System.out.println(currentRoom.getDescription());
                    continue;
                }

            }
            if (currentRoom == room3) {
                if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")) {
                    currentRoom = room3.getSouth();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")) {
                    currentRoom = room3.getWest();
                    System.out.println(currentRoom.getDescription());
                    continue;
                }
            }

            if (currentRoom == room4) {
                if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")){
                    currentRoom = room4.getSouth();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                    currentRoom = room4.getNorth();
                    System.out.println(currentRoom.getDescription());
                    continue;
                }
            }

                if (currentRoom == room5) {
                    if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")){
                        currentRoom = room5.getSouth();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }
                }

                if(currentRoom == room6){
                    if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")){
                        currentRoom = room6.getSouth();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room6.getNorth();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }
                }

                if (currentRoom == room7){
                    if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")){
                        currentRoom = room7.getEast();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room7.getNorth();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }
                }

                if (currentRoom == room8){
                    if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room8.getNorth();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")){
                        currentRoom = room8.getWest();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    } else if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")){
                        currentRoom = room8.getEast();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }
                }

                if (currentRoom == room9){
                    if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")){
                        currentRoom = room9.getWest();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    } else if (tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north")){
                        currentRoom = room9.getNorth();
                        System.out.println(currentRoom.getDescription());
                        continue;
                    }
                }
            System.out.println("You cannot walk this way");
        }
    }
    public void init(){
        //Sætter vores run op og kører med metoden i konstruktør
        room1 = new Room("Hallway", "Hallway of the school you're attending. Many foes lies lurking around");
        room2 = new Room("Staircase", "Be careful when walking up the staircase. It is almost inevitable to meet another student.");
        room3 = new Room("Classroom", "An empty room with many spots to hide");
        room4 = new Room("Codelab", "Many students vacay the room, and getting a spot alone may prove to be difficult");
        room5 = new Room("Examination room", "A dark and seamlessly empty room.");
        room6 = new Room("Design building", "This building is full of wild designers. Be careful.");
        room7 = new Room("Fredagsbar", "Over-crowded place with a way too long queue for buying beverages.");
        room8 = new Room("Courtyard", "Full of smokers");
        room9 = new Room("Elevator", "Empty right now. Press the 'close door' button fast!");
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
