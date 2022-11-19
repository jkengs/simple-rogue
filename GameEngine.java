/**
 * A class to start the game and acts as a main menu where users input their commands.
 * It also creates the player and monster objects.
 */

import java.util.Scanner;

public class GameEngine {

    public static Scanner keyboard;
    private Menu menu;
    private String input;
	private Player player;
    private Monster monster;
    private boolean isNewGame = true;    // becomes false if game loop is ran before
    
    public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		 gameEngine.runGameLoop();
	}

    /**
     * Runs the Main Menu and creates Player and Monster
     * objects if it is a new game
     */
	private void runGameLoop() {
        if (isNewGame) {
            GameEngine.keyboard = new Scanner(System.in);
            this.monster = new Monster();
            this.player = new Player();
            this.menu = new Menu(player, monster);
            isNewGame = false;
            displayTitleText();
		    input();
        } else {
            displayTitleText();
            input();
        }        
	}
    
	/**
     * Prompts user keyboard input and runs the command
     * inputted by the user 
     */
    public void input(){
        input = menu.prompt();
        switch (input)
        {
            case Menu.COMMAND_COMMANDS:
                menu.commands();
                input();
                break;
            case Menu.COMMAND_HELP:
                menu.help();
                input();
                break;
            case Menu.COMMAND_PLAYER:
                menu.player(player);
                returnToMenu();
                break;
            case Menu.COMMAND_MONSTER:
                menu.monster();
				returnToMenu();
                break;
            case Menu.COMMAND_START:
                // Checks if Player and Monster are created
                if (menu.checkValidStart()) {
                    menu.start();
                    returnToMenu();
                    break;
                } else {
                    returnToMenu();
                    break;
                }
            case Menu.COMMAND_EXIT:
                menu.exit();
                break;
        }
    }

	/**
     * Displays the title text
     */
	private void displayTitleText() {
	    System.out.println(Menu.TITLE_TEXT);
        menu.showStatus();
        System.out.println(Menu.MAIN_MENU_TEXT);
	}

    /**
     * Prompts users and ask if they wish to 
     * return to the main menu
     */
    public void returnToMenu() {
        if (menu.checkReturnToMenu()) {
            runGameLoop();
        }
    } 
}
