import java.util.Scanner;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();
    public void run() throws InterruptedException {
        boolean gameIsRunning = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to KEA!\n\nIn this game you play the character of an introverted student whose " +
                "greatest fear is the social contact with other people.\nYour mission is to graduate school with the least" +
                " amount of social interaction as possible. Type 'help' if you need guidance.\n" +
                "\nGood luck!");
        dots();
        player.setCurrentRoom(map.getRoom1());
        System.out.println(player.getCurrentRoomDescription());
        printItemsInCurrentRoom();
        while (gameIsRunning) {
            String tekst = sc.nextLine().trim();
            if (tekst.equals("look")) {
                System.out.println("Looking around...");
                Thread.sleep(1000);
                System.out.println(player.getCurrentRoomName());
                printItemsInCurrentRoom();
            } else if (tekst.equals("exit")) {
                System.out.println("You have exited");
                gameIsRunning = false;
            } else if (tekst.equals("help")) {
                System.out.println("\nTo move around type either one of these commands:\n " +
                    "\nNorth: go north/ north/ n" +
                    "\nSouth: go south/ south/ s" +
                    "\nEast: go east/ east/ e" +
                    "\nWest: go west/ west/ w" +
                        "\n\nTry one of them out now!\n" +
                        "\nTo pick something up type: 'take' + 'name of the item'" +
                        "\nTo drop the item again type: 'drop' + 'name of the item'" +
                        "\nType 'inventory' to see all your items");
            } else if ((tekst.equalsIgnoreCase("east")
                || tekst.equalsIgnoreCase("e")
                || tekst.equalsIgnoreCase("go east"))
                && player.getEastRoom() != null) {
                // go east
                walking("east");
                player.goEast();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                printItemsInCurrentRoom();
            } else if ((tekst.equalsIgnoreCase("south")
                || tekst.equalsIgnoreCase("s")
                || tekst.equalsIgnoreCase("go south"))
                && player.getSouthRoom() != null) {
                // go south
                walking("south");
                player.goSouth();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                printItemsInCurrentRoom();
            } else if ((tekst.equalsIgnoreCase("west")
                || tekst.equalsIgnoreCase("w")
                || tekst.equalsIgnoreCase("go west"))
                && player.getWestRoom() != null) {
                // go west
                walking("west");
                player.goWest();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                printItemsInCurrentRoom();
             } else if ((tekst.equalsIgnoreCase("north")
                || tekst.equalsIgnoreCase("n")
                || tekst.equalsIgnoreCase("go north"))
                && player.getNorthRoom() != null) {
                // go north
                walking("north");
                player.goNorth();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                printItemsInCurrentRoom();
            } else if(tekst.contains("take")){
                tekst = tekst.substring(5);
                takeItem(tekst);
            } else if(tekst.equals("inventory")){
                if(player.getInventory().size() == 0){
                    System.out.println("You have nothing in your inventory");
                  } else {
                      System.out.print("Your inventory: ");
                      for (int i = 0; i < player.getInventory().size(); i++) {
                          System.out.print(player.getInventory().get(i));
                          if (i == player.getInventory().size() - 2) {
                              System.out.print(" and ");
                          } else if (i <= player.getInventory().size() - 2) {
                              System.out.print(", ");
                          }
                      }
                      System.out.println();
                  }
            } else if(tekst.contains("drop")){
                tekst = tekst.substring(5);
                dropItem(tekst);
            } else if(tekst.equalsIgnoreCase("health")){
                System.out.println("You currently have " + player.getHealth() + " health");

            }else if(tekst.contains("eat")){
                tekst = tekst.substring(4);
                eatFood(tekst);
            }
            else {
                System.out.println("You search this way, but unfortunately it goes directly into a wall. Try another way!");
                }
            }
        }

    private void eatFood(String tekst) {
        boolean foodEaten = player.eat(tekst);
        if(foodEaten){
            System.out.println("You have consumed the " + tekst + " and your health is now " + player.getHealth());
        } else{
            System.out.println("You cant consume this");
        }
    }

    public void walking(String direction) throws InterruptedException {
        System.out.println("Leaving " + player.getCurrentRoomName() + " and walking " + direction + "...");
        Thread.sleep(1000);
    }
    //kan gøres pænere
    public void printItemsInCurrentRoom() {
        if (player.getCurrentRoomItemSize() == 0) {
            System.out.println("This room has no items");
        } else {
            System.out.print("You take a quick look around and find: ");
            for (int i = 0; i < player.getCurrentRoomItemSize(); i++) {
                System.out.print(player.getCurrentRoomItemList(i));
                if (i == player.getCurrentRoomItemSize() - 2) {
                    System.out.print(" and ");
                } else if (i <= player.getCurrentRoomItemSize() - 2) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    public void takeItem(String tekst){
        boolean itemTaken = player.takeItem(tekst);
        if (itemTaken){
            System.out.println("You have picked up " + tekst + " from the ground.");
        } else{
            System.out.println(tekst + " doesnt exist in this room");
        }
    }
    public void dropItem(String tekst){
        boolean itemDropped = player.dropItem(tekst);
        if (itemDropped){
            System.out.println("You dropped " +  tekst + " on the ground");
        } else{
            System.out.println(tekst + " doesnt exist in your inventory");
        }
    }
    public void dots() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("...\n");
    }
}


