package main;

import java.awt.Graphics;
//import java.awt.Point;
import java.awt.image.BufferedImage;

import entities.Player;
import levels.LevelManager;
import utilz.LoadSave;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	private Player player;
	private LevelManager levelManager;

	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

	private BufferedImage backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND);

	private int xLvlOffset;
	private int leftBorder = (int)(0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int)(0.8 * Game.GAME_WIDTH);
	private int maxLvlOffsetX;


	public Game() {
		initClasses();

		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();

		startGameLoop();
	}

	private void initClasses() {
		levelManager = new LevelManager(this);
		player = new Player(200, 200, (int) (32 * Game.SCALE), (int) (48 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		player.setSpawn(levelManager.getCurrentLevel().getPlayerSpawn());
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	//private void calcLvlOffset() {
	//	maxLvlOffsetX = levelManager.getCurrentLevel().getLvlOffset();
	//}

	public void update() {
		levelManager.update();
		player.update();
		checkCloseToBorder();

	
	}

	private void checkCloseToBorder() {
		int playerX = (int)player.getHitbox().width;
		int diff = playerX - xLvlOffset;

		if(diff > rightBorder)
			xLvlOffset += diff - rightBorder;
		else if (diff < leftBorder)
			xLvlOffset += diff - leftBorder;

		if(xLvlOffset > maxLvlOffsetX)
			xLvlOffset = maxLvlOffsetX;
		else if(xLvlOffset < 0)
			xLvlOffset = 0;
	}

	public void render(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
		levelManager.draw(g, xLvlOffset);
		player.render(g, xLvlOffset);
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				gameWindow.setTitle("Bomberman | FPS: " + frames + " | UPS: " + updates);
				//System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;

			}
		}

	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}

}