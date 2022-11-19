/**
 * A class that represents the world of the game. It is where
 * the players interact with the map and monster(battle). Player movements
 * are executed here and their coordinates updated.
 */

public class World {

    private String input;
    private Player player;
    private Monster monster;
    private Map map;
    private Battle battle;
    private boolean goHome = false;      // Becomes true if user executes 'home' during the world interaction (movement)
    
    // Characters Current Positions
    private int playerX;
    private int playerY;
    private int monsterX;
    private int monsterY;

    // Movements
    private final static String DIRECTION_NORTH = "w";
    private final static String DIRECTION_EAST = "d";
    private final static String DIRECTION_SOUTH = "s";
    private final static String DIRECTION_WEST = "a";
    private final static int MOVEMENT_VALUE = 1;

    /**
     * Map Constructor which sets character's default position
     * @param player player object
     * @param monster monster object
     */
    public World (Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        this.playerX = Map.PLAYER_XPOS_DEFAULT;
        this.playerY = Map.PLAYER_YPOS_DEFAULT;
        this.monsterX = Map.MONSTER_XPOS_DEFAULT;
        this.monsterY = Map.MONSTER_YPOS_DEFAULT;
        this.map = new Map(player, monster);
        this.battle = new Battle(player, monster);
        updatePlayerLocation();
        updateMonsterLocation();
        map.printMap();
    }

    /**
     * Initiates the player interaction with the world 
     * and monster. It allows user to move the player and
     * print the updated map whilst doing so.
     */
    public void worldInteraction() {
        // Stops prompting for player movement if the user
        // wishes to return home or once player-monster
        // battle is completed.
        while (!battle.battleOver && !goHome) {
            System.out.println();
            System.out.print(Menu.PROMPT_TEXT);
            input = GameEngine.keyboard.nextLine();
            switch (input) 
            {
            case Menu.COMMAND_HOME:
                returnHome();
                break;
            case DIRECTION_NORTH:
                moveNorth();
                break;
            case DIRECTION_EAST:
                moveEast();
                break;
            case DIRECTION_SOUTH:
                moveSouth();
                break;
            case DIRECTION_WEST:
                moveWest();
                break;
            }
        }
    }

    /**
     * Updates player's current coordinates
     */
    private void updatePlayerLocation() {
        map.setplayerX(playerX);
        map.setplayerY(playerY);
    }

    /**
     * Updates monster's current coordinates
     */
    private void updateMonsterLocation() {
        map.setmonsterX(monsterX);
        map.setmonsterY(monsterY);
    }

    /**
     * Moves the player north and check if it has
     * met the monster
     */
    private void moveNorth() {
        if (playerY - MOVEMENT_VALUE >= 0) {
            playerY -= MOVEMENT_VALUE;
            
        } 
        checkEncounterMonster();
    }

    /**
     * Moves the player east and check if it has
     * met the monster
     */
    private void moveEast() {
        if (playerX + MOVEMENT_VALUE < map.mapWidth) {
            playerX += MOVEMENT_VALUE;
            
        }
        checkEncounterMonster();
    }

    /**
     * Moves the player south and check if it has
     * met the monster
     */
    private void moveSouth() {
        if (playerY + MOVEMENT_VALUE < map.mapHeight) {
            playerY += MOVEMENT_VALUE;
            
        }
        checkEncounterMonster();
    }

    /**
     * Moves the player west and check if it has
     * met the monster
     */
    private void moveWest() {
        if (playerX - MOVEMENT_VALUE >= 0) {
            playerX -= MOVEMENT_VALUE;
            
        }
        checkEncounterMonster();
    }
    
    /**
    * Check if the player has encountered the monster 
    * and starts battle if it has.
    */
    private void checkEncounterMonster() {
        if (playerX == monsterX && playerY == monsterY) {
            System.out.printf("%s encountered a %s!\n", player.getPlayerName(), monster.getMonsterName());
            battle.battleLoop();
        } else {
            updatePlayerLocation();
            map.printMap(); 
        }
    }
  
    /**
     * Initiates the 'home' command function
     */
    private void returnHome() {
        System.out.println("Returning home...");
        goHome = true;
    }
}

