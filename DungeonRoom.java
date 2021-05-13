package ProjectPPJ.projectppj;
import java.util.Random;
public class DungeonRoom {
    private final String roomDescription;
    public  Monster monster;
    private static boolean hasMonster;
    private final boolean isBossRoom;
    static int max = 7; static int  min = 1;
    static int range = (max - min) + 1;
    private static boolean maxBossRoom = false;

    private DungeonRoom(String roomDescription, Monster monster, boolean hasMonster, boolean isBossRoom){
        this.roomDescription = roomDescription;
        this.monster = monster;
        this.hasMonster = hasMonster;
        this.isBossRoom = isBossRoom;
    }

    public static DungeonRoom newRoom() {
        String roomDescription = null;
        boolean hasMonster = false;
        boolean isBossRoom = false;
        int random = Main.random.nextInt(8);
        switch (random) {
            case 0:
                roomDescription = "A square room with litter lying all around. A single burned torch hanging on the wall. Quiet and safe at first" +
                        " glance but soon you realise you are not alone in here.";
                hasMonster = true;
                break;
            case 1:
                roomDescription = "This room must have been a camp of some adventurers before you. There is a single firepit in the middle covered with ash." +
                        "\nYou can see some torn bags as well as some rotten food. The smell here is unberable, " +
                        "\nyou should quickly go somewhere else but as you take a step something attacks you!";
                hasMonster = true;
                break;
            case 2:
                roomDescription = "Long corridor bestows upon you. In the darkness you hear some sound slowly approaching you. As it becomes louder" +
                        "\nyou realise something wants to attack you. Prepare for a fight!";
                hasMonster = true;
                break;
            case 3:
                roomDescription = "A wall of this big room must have been destroyed a long time ago. Only a few stones lie on the ground. As you enter" +
                        "\n the chamber you hear some movement in the distance. Looking around, you spot a glowing pair of eyes in the darkness. They do not look friendly." +
                        "\n You're gonna have to fight your way out.";
                hasMonster = true;
                break;
            case 4:
                roomDescription = "As you open the door to the room. A loud squeak echoes around the walls. You feel you're not alone in here." +
                        "\nYou take out your weapon.";
                hasMonster = true;
                break;
            case 5:
                roomDescription = "You move in and feel your legs are soaking in water. There is a big puddle of water on the ground." +
                        "\n Air all around feels moist, there is some old food and equipment lying around. At first it does not look like much, but " +
                        "\nyou soon realise its someone's or something's home. And you're not alone. Get ready.";
                hasMonster = true;
                break;
            case 6:
                roomDescription = "It is substantially warmer in here. You loosen your armour just to rest for a moment. This small chamber looks " +
                        "\nvery safe and comfortable. You rest for a moment before going forth. As you prepare to leave the " +
                        "room, you hear something creeping in the corner.";
                hasMonster = true;
                break;
            case 7:
                roomDescription = "As soon as you enter, you feel this is no ordinary room. You can hear growling of something giant in the distance." +
                        "\n As you make another step, you can hear a sound of coins falling on the ground fill the chamber. Something moves in the darkness and you" +
                        "\n can see a big eye glowing in the shadows. You see two big claws slashing away a pile full of gold. It's a very dangerous fight, are you ready?";
                hasMonster = true;
                isBossRoom = true;

                break;
        }
        if (!maxBossRoom) {
            maxBossRoom = true;
            return new DungeonRoom(roomDescription, Monster.dragon(), true, true);
        } else {
            return new DungeonRoom(roomDescription, Monster.newMonsterRandom(), true, isBossRoom);
        }
    }

    @Override
    public String toString(){
        return roomDescription;
    }

    public String getRoomDescription(){
        return roomDescription;
    }

    public Monster getMonster(){
        return monster;
    }

    public boolean isBossRoom(){
        return isBossRoom;
    }


}
