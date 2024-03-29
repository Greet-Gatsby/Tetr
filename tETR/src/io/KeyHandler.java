package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Collision;
import game.Game;
import game.GameState;
import infrastructure.GameLoop;
import infrastructure.Main;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Game.gamestate == GameState.start) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Game.gamestate = GameState.ingame;

			}
		}

		if (Game.gamestate == GameState.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				try {
					if (!Collision.collideInRotation(Game.currentBlock)) {
						Game.currentBlock.rotate();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				try {
				if (!Collision.collideWithWall(Game.currentBlock, 0)
						&& !Collision.collideWithBlock(Game.currentBlock, 0)) {
					Game.currentBlock.setY(Game.currentBlock.getY() + 1);
					Collision.collideWithWall(Game.currentBlock, 0);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				Game.speedup = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

				try {
					if (!Collision.collideWithWall(Game.currentBlock, 1)
							&& !Collision.collideWithBlock(Game.currentBlock, 1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() + 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				try {
					if (!Collision.collideWithWall(Game.currentBlock, -1)
							&& !Collision.collideWithBlock(Game.currentBlock, -1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() - 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.gamestate = GameState.pause;

			}
		} else if (Game.gamestate == GameState.pause) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.gamestate = GameState.ingame;
			}

		} else if (Game.gamestate == GameState.gameover) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Game.gamestate = GameState.ingame;
				Game.clear();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Game.gamestate == GameState.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Game.speedup = false;
			}
		}

	}

}
