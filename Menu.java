/**
 * A class that runs the game commands inputted by users in the 
 * main menu (GameEngine).
 */

public class Menu {
        
    private String input;
    private Player player;
    private Monster monster;
    private World world;

    // Menu Text
    public final static String MAIN_MENU_TEXT = "Please enter a command to continue.\nType \'help\' to learn how to get started.";
    public final static String TITLE_TEXT = " ____                        \n" + 
    "|  _ \\ ___   __ _ _   _  ___ \n" + 
    "| |_) / _ \\ / _` | | | |/ _ \\\n" + 
    "|  _ < (_) | (_| | |_| |  __/\n" + 
    "|_| \\_\\___/ \\__, |\\__,_|\\___|";

    // Input Commands 
    public final static String COMMAND_COMMANDS = "commands";
    public final static String COMMAND_HELP = "help";
    public final static String COMMAND_PLAYER = "player";
    public final static String COMMAND_MONSTER = "monster";
    public final static String COMMAND_START = "start";
    public final static String COMMAND_EXIT = "exit";
    public final static String COMMAND_HOME = "home";   
    
    // Command Texts
    public final static String PROMPT_TEXT = "> ";
    private final String DISPLAY_COMMAND_PLAYER = "What is your character's name?";
    private final String DISPLAY_COMMAND_HELP = "Type \'commands\' to list all available commands\nType \'start\' to start a new game\nCreate a character, battle monsters, and find treasure!";
    private final String DISPLAY_RETURN_TO_MENU = "\n(Press enter key to return to main menu)\n";
    private final String DISPLAY_EXIT = "Thank you for playing Rogue!";
    private final String NO_PLAYER = "No player found, please create a player with 'player' first.";
    private final String NO_MONSTER = "No monster found, please create a monster with 'monster' first.";

    /**
     * Menu constructor
     * 
     * @param player player object
     * @param monster monster object
     */
    public Menu(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    /**
     * Prints the prompt text and calls
     * the scanner to read user input.
     * 
     * @return  user keyboard input 
     */
    public String prompt(){
        System.out.println();
        System.out.print(Menu.PROMPT_TEXT);
        return keyboardInput();
    }

    /**
     * Executes 'commands' command which
     * prints out the list of menu commands.
     */
    public void commands(){
        System.out.println(COMMAND_HELP);
        System.out.println(COMMAND_PLAYER);
        System.out.println(COMMAND_MONSTER);
        System.out.println(COMMAND_START);
        System.out.println(COMMAND_EXIT);
    }

    /**
     * Executes 'help' command.
     */
    public void help(){
        System.out.println(DISPLAY_COMMAND_HELP);
    }

   /**
    * Executes 'player' command which lets the user
    * create their player for the first time.
    * @param player player object
    */ 
    public void player(Player player){
        if (!checkPlayerStatus()) {
            createPlayer();
        } else {
            // Prints player stats if there a player was already created
            System.out.printf("%s (Lv. %d)\n", player.getPlayerName(), player.getPlayerLevel());
            System.out.printf("Damage: %d\n", player.getPlayerDamage());
            System.out.printf("Health: %d/%d\n", player.getPlayerCurrHealth(), player.getPlayerMaxHealth());
        }   
    }

    /**
     * Asks the user for their player name
     * and set the default attributes for
     * the player.
     */
    private void createPlayer() {
        System.out.println(DISPLAY_COMMAND_PLAYER);
        String playerName = keyboardInput();
        player.setPlayerName(playerName);
        player.setDefaultPlayerLevel();
        player.setPlayerMaxHealth();
        player.restoreToFullHP();
        player.setPlayerDamage();
        System.out.println("Player \'" + playerName + "\' created.");
    }

    /**
     * Executes 'monster' command which lets the user
     * create a monster and overwrite if there is
     * an exisiting monster already.
     */
    public void monster(){
        createMonster();
    }
    
    /**
     * Asks user to input the monster name, monster
     * health and monster damage that they wish
     * their new monster to have.
     */
    private void createMonster() {
        System.out.print("Monster name: ");
        input = keyboardInput();
        monster.setMonsterName(input);
        System.out.print("Monster health: ");
        input = keyboardInput();
        int monsterHealth = Integer.parseInt(input);
        monster.setMonsterMaxHealth(monsterHealth);
        monster.restoreToFullHP();
        System.out.print("Monster damage: ");
        input = keyboardInput();
        int monsterDamage = Integer.parseInt(input);
        monster.setMonsterDamage(monsterDamage);
        System.out.printf("Monster \'%s\' created.\n", monster.getMonsterName());
    }

    /**
     * Executes the 'start' command which first restores player's
     * and monster's healths to full before creating a new
     * world and allowing players to interact with it.
     */
    public void start(){
        player.restoreToFullHP();
        monster.restoreToFullHP();
        this.world = new World(player, monster);
        world.worldInteraction();   
    }
    
    /**
     * Executes the 'exit' command which closes the
     * scanner object and exit the program.
     */
    public void exit(){
        System.out.println(DISPLAY_EXIT);
        GameEngine.keyboard.close();
        System.exit(0);
    }

    /**
     * Prints the character status including the name and
     * health, below the main menu display text.
     */
    public void showStatus() {
        System.out.println();
        System.out.print(getPlayerInfo() + " | " + getMonsterInfo());
        System.out.println();
    }

    /**
     * Checks if there is an existing player and returning 
     * his/her attributes such as name, current/max health.
     * 
     * @return string which holds the player information to be displayed in the status
     *         on the main menu
     */
    private String getPlayerInfo(){
        if (!checkPlayerStatus()) {
            return String.format("Player: %s ","[None]");
        } else {
            return String.format("Player: %s %d/%d ", player.getPlayerName(), player.getPlayerCurrHealth(), player.getPlayerMaxHealth());
        }
    }

    /**
     * Checks if there is an existing monster and 
     * returning its such as name, current/max health.
     * 
     * @return string which holds the monster information to be displayed in the status
     *         on the main menu
     */
    private String getMonsterInfo(){
        if (!checkMonsterStatus()) {
            return String.format("Monster: %s\n","[None]");
        } else {
            return String.format("Monster: %s %d/%d\n", monster.getMonsterName(), monster.getMonsterCurrHealth(), monster.getMonsterMaxHealth());
        }
    }
    
    /**
     * Returns true if a player character was created before.
     * 
     * @return boolean 
     */
    private boolean checkPlayerStatus() {
        if (player.getPlayerName() == null) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
    * Returns true if a monster was created before.
    *
    * @return boolean
    */
    private boolean checkMonsterStatus() {
        if (monster.getMonsterName() == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if both a monster and player has been
     * created and returns true if it is. Both objects
     * are needed before executing the 'start' command. 
     * @return boolean
     */
    public boolean checkValidStart() {
        if (!checkPlayerStatus()) {
            System.out.println(NO_PLAYER);
            return false;
        } else if (checkPlayerStatus() && !checkMonsterStatus()) {
            System.out.println(NO_MONSTER);
            return false;
        } else {
            return true;
        }
    }

    /**
    * Prompts users if they wish to return to the main menu.
    * Returns true if they press enter.
    * @return boolean
    */
    public boolean checkReturnToMenu() {
        System.out.print(DISPLAY_RETURN_TO_MENU);
        input = keyboardInput();
        if (input.equals("")){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Call the next line function of the scanner 
     * @return string of keyboard input
     */
    private String keyboardInput() {
        input = GameEngine.keyboard.nextLine();
        return input;
    }
}

