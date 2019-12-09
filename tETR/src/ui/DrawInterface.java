package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import data.Conversion;
import game.Game;

public class DrawInterface extends JLabel{
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Game.nextBlock.getColor());
		for (int j = 0; j < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length; j++) {
			for (int k = 0; k < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][j].length; k++) {

				if (Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][j][k] == 1) {
					g.fillRect(Conversion.cellToCoord(1 + j),
							Conversion.cellToCoord(k), 32, 32);
				}
			}
		}
		
		
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				g.drawRect(i*32 +32, j*32, 32, 32);
			}
		}
	
		g.setColor(Color.BLACK);
		g.drawRect(32, 0,128, 128);
		
		g.setFont(Gui.pixelfont);
		g.drawString("SCORE: " + Game.score, 32, 200);
		
		g.drawString("BEST: " + Game.highscore, 32, 250);
		
		repaint();
	}

}
