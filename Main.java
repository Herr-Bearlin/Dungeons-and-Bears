 package ProjectPPJ.projectppj;

import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class 1
        Main {
    public static final Random random = new Random();
    public static DungeonRoom[][] playingDungeonRoom;
    public static Player playingCharacterPlayer;
    public static final Scanner playerCommand = new Scanner(System.in);
    /*
    Features - POINTS:
    Store information about player - there is class player for health, maxdamage, enhancers, food - 1pt.

    Place player on the grid - The player begins the game in the middle square of the dungeon [5][5] - 1pt.

    Allow player to move on the board - During movement pressing 'n' moves player in north direction, 's' south etc. - 1pt.

    Add some elemens on map - Dungeon is filled with monsters, enhancers, food - 1pt.

    Add randomness - Every time you play, rooms are randomised, random monsters, random things to loot; also damage is randomised in a fight - 2pt.

    Add 4 types of elements - You can eat food to heal, you can enhance maxmeleedamage, you can enhance maxrangeddamage, you can fight monsters etc.

    Add NPCs - Each room is filled with an enemy, you can attack it. At the beginning an npc talks to you - 2pts.

    Allow to lose/win - If health is <=0, then player.isDead() is true and the game is over. If player defeats a monster
    that is the dragon, the player wins the game. -2pts.

    Add Option to upgrade - You can upgrade, increase your maxRangedDamage or maxMeleeDamage through the use of
    Melee/RangedEnhancers found on the map - 3pts.

    Allow player to change a cell - When player kills the enemy and picks up items from it, the cell becomes just a
    normal corridor - 3pts

    All of the points sum up to: 1+1+1+1+2+2+2+3+3 = 18;
     */




    public static void main(String[] args) throws InterruptedException {
        menu();
    }

    public static void menu() throws InterruptedException {
        boolean loop = false;
        do {
            Interface.messageWelcome();
            Scanner playerCommand = new Scanner(System.in);
            String playerInput = playerCommand.nextLine();
            switch (playerInput) {
                case "1":
                    gameNewGame();
                    loop = true;
                    break;
                case "2":
                    System.out.println("Exiting the game...");
                    System.exit(0);
            }
        } while (loop == false);
    }

    public static void gameNewGame() throws InterruptedException {
        DungeonLevel dungeonLevel = new DungeonLevel();
        boolean loop = false;
        do {
            Interface.introductionNewGame();
            String playerInput = playerCommand.nextLine();
            switch (playerInput) {
            case "1":
                    playingCharacterPlayer = Player.knight();
                    System.out.println("Ah, I see. You're a knight from the LionHeart order. I have heard so much about you!" +
                    "\nI am sure you will manage to fulfill your mission in that dungeon but please be careful." +
                    "\nOne more thing, there is a big dragon down there somewhere." +
                    "\nIt has trapped my beloved bear friend." +
                    "\nPlease, if you find it rescue it and bring here. I will reward you greatly.");
                    System.out.println("\n\n\n\n\n\n\n\n\n\n You enter the dungeon. Good luck.");
                    break;
            case "2":
                playingCharacterPlayer = Player.ranger();
                System.out.println("Ah, I see. You're a ranger from 'round here. Rarely can I see one of your kind." +
                "\nWoods are your specialty, not dark caves, so please be careful!" +
                "\nOne more thing, there is a big dragon down there somewhere." +
                "\nIt has trapped my beloved bear friend." +
                "\nPlease, if you find it rescue it and bring here. I will reward you greatly.");
                System.out.println("\n\n\n\n\n\n\n\n\n\n You enter the dungeon. Good luck.");
                break;
            case "3":
                playingCharacterPlayer = Player.adventurer();
                System.out.println("Ah, I see. You're just an adventurer. Many you alike has come this way." +
                    "\nIt is dangerous to go there, so please be careful..." +
                    "\nOne more thing, there is a big dragon down there somewhere." +
                    "\nIt has trapped my beloved bear friend." +
                    "\nPlease, if you find it rescue it and bring here. I will reward you greatly.");
                System.out.println("\n\n\n\n\n\n You enter the dungeon. Good luck.");
                break;
            }
        }while (loop = false) ;
        playingDungeonRoom = DungeonLevel.newDungeon(playingCharacterPlayer);
        dungeonLevel.battleMovementStop(playingCharacterPlayer, playingDungeonRoom);
    }
}

