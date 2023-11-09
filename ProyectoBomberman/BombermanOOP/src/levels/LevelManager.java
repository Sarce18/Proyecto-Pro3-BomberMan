package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import utilz.LoadSave;

public class LevelManager {

	private Game game;
	private BufferedImage[] levelSprite;
	private ArrayList<Level> levels;
	private int lvlIndex = 0;

	public LevelManager(Game game) {
		this.game = game;
		importOutsideSprites();
		levels = new ArrayList<>();
		buildAllLevels();
	}

	public void loadNextLevel(){
		lvlIndex++;
		if(lvlIndex >= levels.size())
			lvlIndex = 0;
	}	

	private void buildAllLevels() {
		BufferedImage[] allLevels = LoadSave.GetAllLevels();
		for(BufferedImage img : allLevels)
			levels.add(new Level(img));
	}

	private void importOutsideSprites() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		levelSprite = new BufferedImage[48];
		for (int j = 0; j < 4; j++)
			for (int i = 0; i < 12; i++) {
				int index = j * 12 + i;
				levelSprite[index] = img.getSubimage(i * 32, j * 32, 32, 32);
			}
	}

	//public void draw(Graphics g) {
	//	for (int j = 0; j < Game.TILES_IN_HEIGHT; j++)
	//		for (int i = 0; i < Game.TILES_IN_WIDTH; i++) {
	//			int index = levelOne.getSpriteIndex(i, j);
	//			g.drawImage(levelSprite[index], Game.TILES_SIZE * i , Game.TILES_SIZE * j, Game.TILES_SIZE, Game.TILES_SIZE, null);
	//		}
	//}

	public void draw(Graphics g, int lvlOffset) {
		for (int j = 0; j < Game.TILES_IN_HEIGHT; j++)
			for (int i = 0; i < levels.get(lvlIndex).getLevelData()[0].length; i++) {
				int index = levels.get(lvlIndex).getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Game.TILES_SIZE * i - lvlOffset, Game.TILES_SIZE * j, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
	}


	public void update() {

	}

	public Level getCurrentLevel(){
		return levels.get(lvlIndex);
	}

	public int getAmountOfLevels(){
		return levels.size();
	}
}