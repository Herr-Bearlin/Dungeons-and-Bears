package ProjectPPJ.projectppj;

import java.util.Scanner;
import java.lang.*;

public class Interface {
    public static void messageWelcome() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println("This game was made as a project for PPJ programming at the PJAIT university in Warsaw." +
                "\nAuthor of this game is J. Malicki by the supervision of Professor Tomasz Werner. " +
                "\nSources of inspiration and tutorials used are written down in readme.txt file in the game folder." +
                "\nI hope that you will find this game enjoyable. Let's begin your adventure!");
        Thread.sleep(10000); //12 seconds delay
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome to Dungeons And Bears.");
        System.out.println();
        System.out.println("==============================");
        System.out.println("           Main Menu          ");
        System.out.println("==============================");
        System.out.println();
        System.out.println(" 1.       New Game           ");
        System.out.println(" 2.       Exit Game          ");
        System.out.println();
        System.out.println("Choose an option by pressing '1' or '2'");
        System.out.println();
        System.out.println();
    }

    public static void introductionNewGame() throws InterruptedException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("==============================");
        System.out.println("          Introduction        ");
        System.out.println("==============================");
        System.out.println();
        System.out.println("They say many people have come to this dungeon and fell. \nIt is a dangerous place, where only the bravest heroes and adventurers " +
                "can find glory.\n Most of them do not come out. There are many treasures lying ahead.\n Remember to bring some weapons and food with you." +
                "But what do I know? Never been there, too scared.\n My mother always said. If living life means killing monsters and looking for treasures " +
                "\n then the life is sure to be short. Hahahah." +
                "\nIt is surely brave of you, to go down there thought... But I do not know you. Who are you?");
        Thread.sleep(10000);
        System.out.println("==============================");
        System.out.println("     Choose your Character    ");
        System.out.println("==============================");
        System.out.println();
        System.out.println("1. Knight");
        System.out.println("(Knights, the most noble of all. Quite tough and strong melee fighters.");
        System.out.println("Max Health: 115,  Melee Damage: 10,  Ranged Damage: 2, Food Amount: 2");
        System.out.println();
        System.out.println("2. Ranger");
        System.out.println("(Rangers, the most cunning of all. Marksmen raining damage from the distance, vulnerable in close combat. ");
        System.out.println("Max Health: 95,  Melee Damage: 8,  Ranged Damage: 4, Food Amount: 3");
        System.out.println();
        System.out.println("3. Adventurer");
        System.out.println("(Adventurers, the jacks of all trades. What they lack in skill, they make up in being prepared, balanced individuals.");
        System.out.println("Max Health: 105, Melee Damage: 7, Ranged Damage: 3, Food Amount: 6");
        System.out.println();
        System.out.println();
        System.out.println("Choose a correct option by pressing: '1' , '2' or '3'");
    }
    //this is a method that asks the player where he would like to travel and allows the player to do so
    public static void playerMoveAction(Player player){
        while(player.getRangedEnhancerAmount() > 0 || player.getMeleeEnhancerAmount() > 0){
            if(player.getMeleeEnhancerAmount() > 0){
                System.out.println("You have gained a red crystal. Do you want to use it? (press 'r')");
            }
            if(player.getRangedEnhancerAmount() > 0){
                System.out.println("You have gained a green crystal. Do you want to use it? (press 'g')");
            }
            System.out.println("If you do not wish to use it. (Press 'u' ");
            String playerChoice = Main.playerCommand.nextLine();
            if(playerChoice.equals("u")){
                System.out.println("You do not wish to get better, so you continue moving forward.");
                break;
            }
            if(playerChoice.equals("r") && player.getMeleeEnhancerAmount() > 0){
                player.enhanceMeleeDamage(player.getMeleeEnhancerAmount());
            }
            if(playerChoice.equals("g") && player.getRangedEnhancerAmount() > 0){
                player.enhanceRangedDamage(player.getRangedEnhancerAmount());
            }
        }
        System.out.println("Where do you want to go? Corridor leads in following directions: ");

        if(DungeonLevel.doesNorthExist()){
            System.out.println("North (press 'n')");
        }
        if(DungeonLevel.doesSouthExist()){
            System.out.println("\nSouth (press 's')");
        }
        if(DungeonLevel.doesWestExist()){
            System.out.println("\nWest (press 'w')");
        }
        if(DungeonLevel.doesEastExist()){
            System.out.println("\nEast (press 'e')");
        }
        String playerInput = Main.playerCommand.nextLine();
        if(playerInput.equals("n") && DungeonLevel.doesNorthExist()){
            player.setCurrentY(player.getCurrentY() + 1);
        } else if(playerInput.equals("s") && DungeonLevel.doesSouthExist()){
            player.setCurrentY(player.getCurrentY() - 1);
        } else if(playerInput.equals("w") && DungeonLevel.doesWestExist()){
            player.setCurrentX(player.getCurrentX() - 1);
        } else if(playerInput.equals("e") && DungeonLevel.doesEastExist()){
            player.setCurrentX(player.getCurrentX() + 1);
        }
    }

    public static void enteringRoom(Player player, DungeonRoom dungeonRoom){
        System.out.println("You walk into the room: [" + player.getCurrentX() + "] [" + player.getCurrentY() +"]");
        System.out.println("\n" + dungeonRoom.getRoomDescription());
        System.out.println("\n" + dungeonRoom.getMonster().getMonsterName() + "Approaches you.");
    }


    public static void battle(Player player, Monster monster, DungeonRoom dungeonRoom){
        while (!player.isDead() && !monster.isDead()){
            System.out.println("The battle has started. You can: " + "\n Attack (press 'a')\n Consume food to heal (press 'c')");
            //for three turns one can attack with the ranged weapon, monster does not attack;
            for(int i = 0; i < 3 &&!monster.isDead(); i++){
                Scanner scanner = new Scanner(System.in);
                System.out.println("The " + monster.getMonsterName() + " approaches you, if you want to attack him you can only do it from the distance");
                String commandChoice = scanner.nextLine();
                if(commandChoice.equals("a")){ //this deals damage to the monster, function that is required returns current health and prints damage done
                    monster.getMonsterHealthMinusRangedDamage(player, monster);
                }
                if(commandChoice.equals("c")){
                    player.eatFood(player.getFoodAmount());
                }
            }
            if(!monster.isDead()){
                System.out.println("The " + monster.getMonsterName() + "gets to you. Time for some close combat!");
            }
            for(int j = 0; !player.isDead() && !monster.isDead() && j < 200 ; j++){
                System.out.println(" You can: " + "\n Attack (press 'a')\n Consume food to heal (press 'c')");
                String commandChoice = Main.playerCommand.nextLine();
                if(commandChoice.equals("a")){
                    monster.getMonsterHealthMinusMeleeDamage(player, monster);
                }
                if(commandChoice.equals("c")){
                    player.eatFood(player.getFoodAmount());
                }
                player.getPlayerHealthMinusDamage(monster);
                if(!player.isDead() && !monster.isDead()){
                    System.out.println("The battle continues. You have: " + player.getPlayerHealth() + " health left. Monster has " +
                            monster.getmonsterHealth() + " health left.");
                }
            }
        }if (monster.isDead()){
            System.out.println("The " + monster.getMonsterName() + " is defeated. You look around the room searching for loot.");
        }else if(player.isDead()) {
            System.out.println("You feel your consciousness fading away as the " + monster.getMonsterName() + " hits you. You fell to your knees as " +
                    "you feel you are not leaving this dungeon alive. \nWith one last breath you strike the " + monster.getMonsterName() +
                    "\n\n\n\n\n\n Your body is left in the dungeon like the rest of the adventurers. ");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Thank you for playing. Restart the program to try again.");
            System.out.println("Exiting the game...");
            System.exit(0);
        }if ((monster.getMonsterName().equals("Dragon") && monster.isDead())){
        playerWin();
        System.out.println("You can exit the game now.");
    }
    }

    public static void playerHitMessage(int damage, Monster monster){
        System.out.println(monster.getMonsterName() + "hits you and deals you " + damage + " damage.");
    }
    public static void monsterHitMessage(int damage, Monster monster){
        System.out.println(monster.getMonsterName() + " is hit and you deal " + damage + " damage.");
    }
    public static void playerWin(){
        System.out.println("Congratulations, you have killed the dragon! As you look around the chamber you can see a bear \nlocked up in chains." +
                "\nYou free the bear and slowly escort it to the exit. \nAs you finally approach the entrance to the dungeon, you can feel " +
                "sunlight hurting your eyes. Seconds later you are outside, seeing an old man hugging his beloved pet. " +
                "He speaks up: \n 'I did not think I would see you alive! Thank the Gods that Kokuma is safe! Thank " +
                "you! As a token of my reward and friendship take this bag full of gold! Till next time!");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Thank you for playing! Exiting the game now...");
        System.exit(0);
    }
}
