/**
 * A class that tracks characters' location and print the map of
 * the world.
 */

public class Map {

    // Default Map Dimensions
    public final static int MAP_WIDTH_DEFAULT = 6;
    public final static int MAP_HEIGHT_DEFAULT = 4;

    // Default Character Positions
    public final static int PLAYER_XPOS_DEFAULT = 1;
    public final static int PLAYER_YPOS_DEFAULT = 1;
    public final static int MONSTER_XPOS_DEFAULT = 4;
    public final static int MONSTER_YPOS_DEFAULT = 2;

    // Map Dimensions
    public int mapWidth;
    public int mapHeight;

    // Character Current Positions
    private int playerX;
    private int playerY;
    private int monsterX;
    private int monsterY;
    
    // Map Symbols
    private char playerChar;
    private char monsterChar;
    private final static String MAP_EMPTY = ".";

    /**
     * Map constructor
     * @param player player object
     * @param monster monster object
     */
    public Map (Player player, Monster monster) {
        this.mapWidth = MAP_WIDTH_DEFAULT;
        this.mapHeight = MAP_HEIGHT_DEFAULT;
        this.playerChar = player.getPlayerName().toUpperCase().charAt(0);   
        this.monsterChar = monster.getMonsterName().toLowerCase().charAt(0);
    }

    /**
     * Prints the current map which includes
     * the positions of the player and monster.
     */
    public void printMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x=0; x < mapWidth; x++) {
                if (y == playerY && x == playerX) {
                    // Player Location
                    System.out.print(playerChar);
                } else if (y == monsterY && x == monsterX) {
                    // Monster Location
                    System.out.print(monsterChar);
                } else {
                    System.out.print(MAP_EMPTY);
                }       
            }
            System.out.println();
        }
    }

    // Mutator methods which set player and monster coordinates
    public void setplayerX(int playerX){
        this.playerX = playerX;
    }
    public void setplayerY(int playerY){
        this.playerY = playerY;
    }
    public void setmonsterX(int monsterX){
        this.monsterX = monsterX;
    }
    public void setmonsterY(int monsterY){
        this.monsterY = monsterY;
    }
}

