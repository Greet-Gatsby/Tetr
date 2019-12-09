package infrastructure;

import java.awt.FontFormatException;
import java.io.IOException;

import game.Block;
import game.Game;
import io.DataHandler;
import ui.Gui;

public class Main {
	


	public static void main(String[] args) {
		
		DataHandler.load();
	
		Game.currentBlock = new Block();
		Game.blocks.add(Game.currentBlock);
		Game.nextBlock = new Block();
		
		try {
			Gui g = new Gui();
			g.create();
		} catch (FontFormatException | IOException e) {
			System.out.println("Failed to create GUI.");
			e.printStackTrace();
		}
		
		startLoop();
		
		
	}
	
	public static void startLoop() {
		GameLoop loop = new GameLoop();
		loop.start();
	}

}
