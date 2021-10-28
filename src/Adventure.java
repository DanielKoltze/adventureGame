import java.util.Scanner;
//måske adgang til et rum via studentcard

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();
    private Enemy enemy = null;
    public void run() throws InterruptedException {
        boolean gameIsRunning = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to KEA!\n\nIn this game you play the character of an introverted student whose " +
                "greatest fear is the social contact with other people.\nYour mission is to graduate school with the least" +
                " amount of social interaction as possible. Type 'help' if you need guidance.\n" +
                "\nGood luck!");
        dots(3);
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
                if(player.checkEnemy()){
                    enemy = player.getEnemy();
                    Thread.sleep(1000);
                    System.out.println("You have encountered " + enemy.getDescription() + "!!!");
                    Thread.sleep(1000);
                    System.out.println("You have to kill the " + enemy.getName() + " fast");
                    Thread.sleep(1000);
                    System.out.println("Type help for commands");
                    while(player.getHealth() >= 0 && enemy.getHealth() >= 0){
                        enemy.setPlayer(player);
                        tekst = sc.nextLine();
                        if(tekst.equalsIgnoreCase("status")){
                            status();
                        } else if(tekst.equalsIgnoreCase("help")){
                            helpEncounter();
                        }else if(tekst.equalsIgnoreCase("attack")){
                            attackEnemy();
                            Thread.sleep(1000);
                            enemyAttack();
                        }else if(tekst.equalsIgnoreCase("auto attack")){
                            autoAttack();
                            break;
                        }else{
                            System.out.println("This is not a command");
                        }
                    }
                    //lave if else hvis mna  dør eller enemy dør
                }else{
                printItemsInCurrentRoom();}
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
            } else if(tekst.contains("take ")){
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
                if(player.checkWeapon()){
                    System.out.println("You have a " + player.getWeapon().getName() + " equipped");
                }else{
                    System.out.println("You have no weapon equipped however you can still use your bare hands");
                }
            } else if(tekst.contains("drop ")){
                tekst = tekst.substring(5);
                dropItem(tekst);
            } else if(tekst.equalsIgnoreCase("health")){
                System.out.println("You currently have " + player.getHealth() + " health");
            }else if(tekst.contains("eat ")){
                tekst = tekst.substring(4);
                eat(tekst);
            }else if(tekst.contains("drink ")){
                tekst = tekst.substring(6);
                drink(tekst);
            }else if(tekst.contains("equip ")){
                tekst = tekst.substring(6);
                eqiup(tekst);
                //man kan open chest hvis man har keys. så får man to gode items
            }else if(tekst.contains("open ")){
                tekst = tekst.substring(5);
                openChest(tekst);
            }
            else {
                System.out.println("You search this way, but unfortunately it goes directly into a wall. Try another way!");
                }
            }
        }

    private void autoAttack() {
        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            attackEnemy();
            enemyAttack();
        }
    }

    private void status() {
        System.out.println("you have " + player.getWeapon().getDamage() + " damage and " + player.getHealth() + " health");
        System.out.println("Enemy has " + enemy.getWeapon().getDamage() + " damage and " + enemy.getHealth() + " health");
    }

    private void enemyAttack() {
        enemy.attack();
        System.out.println("Enemy hit you for " + enemy.getWeapon().getDamage() + ". You have " + player.getHealth() + " health");
    }

    private void attackEnemy() {
        player.attack();
        System.out.println("You hit enemy for " + player.getWeapon().getDamage() + ". enemy has " + enemy.getHealth() + " health");
    }

    private void helpEncounter() {
        System.out.println("Attack - Attack enemy \n" +
                "status - your health and damage + enemy health and damage \n" +
                "Auto attack - you will attack until you or the enemy dies");
    }
    private void openChest(String tekst) {
        if(tekst.equalsIgnoreCase("Chest")){
            boolean canOpen = player.openChest();
            if(canOpen){
                System.out.println("You have successfully opened the chest!!!! \n" +
                        "Check your inventory to see what you have gotten");
            } else{
                System.out.println("You do not have a chest in your inventory");
            }
        } else{
            System.out.println("You cant open " + tekst);
        }
    }

    private void eqiup(String itemName) {
        boolean cases = player.equip(itemName);
        if(cases){
            System.out.println("You have equiped the " + itemName);
        }else{
            System.out.println("You do not have a " + itemName + " in your inventory");
        }
    }

    private void eat(String itemName) {
        boolean cases = player.eat(itemName);
        if(cases){
            System.out.println("You have eaten the " + itemName + " and your health is now " + player.getHealth());
        }else{
            System.out.println("You cant eat " + itemName);
        }
    }
    private void drink(String itemName) {
        boolean cases = player.drink(itemName);
        if(cases){
            System.out.println("You have drunk the " + itemName + " and your health is now " + player.getHealth());
        } else{
            System.out.println("You cant drink " + itemName);
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
            System.out.println("You have picked up the " + tekst + " from the ground.");
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
    public void dots(int tal) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < tal; i++) {
            System.out.println("...");
            Thread.sleep(1000);
        }
        System.out.println();

    }
}


