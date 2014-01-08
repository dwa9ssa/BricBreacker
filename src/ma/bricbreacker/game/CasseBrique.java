package ma.bricbreacker.game;

import java.util.ArrayList;
import java.util.List;

import ma.bricbreacker.model.Balle;
import ma.bricbreacker.model.Barre;
import ma.bricbreacker.model.Brique;
import ma.bricbreacker.model.Collision;
import ma.bricbreacker.model.CollisionType;
import ma.bricbreacker.model.Image;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
public class CasseBrique {

	private Texture balleTexture = new Texture("data/balle_16.png");
	private Texture barreTexture = new Texture("data/barre.png");
	private Texture briqueTexture = new Texture("data/brique.png");
	private Texture imageGameOverTexture = new Texture("data/gameover.png");
	private Texture imageBackgroundTexture = new Texture("data/back.png");
	
	private Balle balle = new Balle(balleTexture);
	private Barre barre = new Barre(barreTexture);
	private Image imageGameOver = new Image(imageGameOverTexture);
	private Image imageBackground = new Image(imageBackgroundTexture);
	
	private List<Brique> listImageBrique = new ArrayList<Brique>();

	private Sound soundGameOver;
	private Sound soundClash;

	private List<Image> listImage;
	private List<Sound> listSound;

	private float w;
	private float h;

	private float marge = 200;

	private boolean gameOverFirstUse = true;
	private boolean isGameOver = false;

	private int margeBrique = 250 ;
	private int nbrCols;
	private int nbrBrique = 1;
	
	private float initialSpeed = 8;
	private float xBalleCoefDeplacementTemp = initialSpeed;
	private float yBalleCoefDeplacementTemp = initialSpeed;
	
	private int briqueBreaked = 0;
	private int hitOnWalls = 0;
	
	public CasseBrique(Sound soundGameOver, Sound soundClash,
			float w, float h, float margeBarre, int margeBrique, int nbrBrique, float initialSpeed) {
		this.soundGameOver = soundGameOver;
		this.soundClash = soundClash;
		this.w = w;
		this.h = h;
		this.marge = margeBarre;
		this.margeBrique = margeBrique;
		this.nbrBrique = nbrBrique;
		this.initialSpeed = initialSpeed;
		this.xBalleCoefDeplacementTemp = initialSpeed;
		this.yBalleCoefDeplacementTemp = initialSpeed;

		barre.setY(barre.getHeight() + this.marge);
		
		this.getBalle().setY(this.getBarre().getY() - 2 * this.getBalle().getWidth());

		this.getBalle().setxBalleCoefDeplacement(xBalleCoefDeplacementTemp);
		this.getBalle().setyBalleCoefDeplacement(yBalleCoefDeplacementTemp);
		
		nbrCols = (int) w / (briqueTexture.getWidth() + margeBrique);
		
		int currentCols = 0;
		
		for (int i = 0; i < nbrBrique; i++) {
			
			if ((i % nbrCols) == 0) {
				currentCols++;
			}
			
			Brique brique = new Brique(briqueTexture);
			brique.setX(margeBrique + ((i % nbrCols) * (brique.getWidth() + margeBrique)));
			brique.setY(h - (currentCols * (brique.getHeight() + margeBrique)));

			brique.makeLines();
			
			listImageBrique.add(brique);
		}

		this.getImageBackground().setX(0);
		this.getImageBackground().setY(0);
	}

	public void renderGame() {
		listImage = new ArrayList<Image>();
		listSound = new ArrayList<Sound>();
		
		listImage.add(this.getImageBackground());

		this.getBalle().makeLines();
		
		boolean isStillBalle = false;
		
		if (!this.isGameOver()) {
			if (this.getBalle().isBalleFail(this.getH())) {
				this.setGameOver(true);
			}
			
			boolean isBalleHitBarre = this.getBalle().isBalleHitBarre(this.getBarre(), xBalleCoefDeplacementTemp, yBalleCoefDeplacementTemp);
				
			if (isBalleHitBarre) {
				listSound.add(this.getSoundClash());
			}
			
			if (this.getBalle().isTouchTheWallW(this.getW())) {
				this.getBalle().setxBalleCoefDeplacement(-1
						* this.getBalle().getxBalleCoefDeplacement());
				hitOnWalls++;
				listSound.add(this.getSoundClash());
			}
	
			if (this.getBalle().isTouchTheWallH(this.getH())) {
				this.getBalle().setyBalleCoefDeplacement(-1
						* this.getBalle().getyBalleCoefDeplacement());
				hitOnWalls++;
				listSound.add(this.getSoundClash());
			}
	
			boolean isHitBriqueX = false;
			boolean isHitBriqueY = false;
			for (Brique brique : listImageBrique) {
				if (brique.isVisible()) {
					isStillBalle = true;
					
					Collision collision = new Collision(balle, brique);
					
					if (collision.isCollision()) {
						brique.setVisible(false);
						briqueBreaked++;
//						this.getBalle().setxBalleCoefDeplacement(-1
//								* this.getBalle().getxBalleCoefDeplacement());
						this.getBalle().setyBalleCoefDeplacement(-1
								* this.getBalle().getyBalleCoefDeplacement());
						
////						System.out.println(collision.getCollisionTypeH() + " " + collision.getCollisionTypeV());
//						
//						if (collision.getCollisionTypeH() != null) {
//	//						if (collision.getCollisionTypeH().equals(CollisionType.Left)) {
//								this.getBalle().setxBalleCoefDeplacement(-1
//										* this.getBalle().getxBalleCoefDeplacement());
//	//						} else {
//	//							this.getBalle().setxBalleCoefDeplacement(1
//	//									* this.getBalle().getxBalleCoefDeplacement());
//	//						}
//							listSound.add(this.getSoundClash());
//						}
//						
//						if (collision.getCollisionTypeV() != null) {
//	//						if (collision.getCollisionTypeV().equals(CollisionType.Up)) {
//	//							this.getBalle().setyBalleCoefDeplacement(1
//	//									* this.getBalle().getyBalleCoefDeplacement());
//	//						} else {
//								this.getBalle().setyBalleCoefDeplacement(-1
//										* this.getBalle().getyBalleCoefDeplacement());
//	//						}
//							listSound.add(this.getSoundClash());
//						}
					} else {
						listImage.add(brique);
					}
				}
			}
		}

		listImage.add(this.getBarre()); // #17
		listImage.add(this.getBalle()); // #17
		
		if (!this.isGameOver() && isStillBalle) {
			this.getBalle().setPosition(this.getBalle().getNextPoint());
//			this.getBalle().setX(this.getBalle().getX() + this.getBalle().getxBalleCoefDeplacement());
//			this.getBalle().setY(this.getBalle().getY() + this.getBalle().getyBalleCoefDeplacement());
		} else {
			if (this.isGameOverFirstUse()) {
				listSound.add(this.getSoundGameOver());
				this.setGameOverFirstUse(false);
			}
		}
	}

	public Balle getBalle() {
		return balle;
	}

	public void setBalle(Balle balle) {
		this.balle = balle;
	}

	public Barre getBarre() {
		return barre;
	}

	public void setBarre(Barre barre) {
		this.barre = barre;
	}

	public Image getImageGameOver() {
		return imageGameOver;
	}

	public void setImageGameOver(Image imageGameOver) {
		this.imageGameOver = imageGameOver;
	}

	public Image getImageBackground() {
		return imageBackground;
	}

	public void setImageBackground(Image imageBackground) {
		this.imageBackground = imageBackground;
	}

	public List<Brique> getListImageBrique() {
		return listImageBrique;
	}

	public void setListImageBrique(List<Brique> listImageBrique) {
		this.listImageBrique = listImageBrique;
	}

	public Sound getSoundGameOver() {
		return soundGameOver;
	}

	public void setSoundGameOver(Sound soundGameOver) {
		this.soundGameOver = soundGameOver;
	}

	public Sound getSoundClash() {
		return soundClash;
	}

	public void setSoundClash(Sound soundClash) {
		this.soundClash = soundClash;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getMarge() {
		return marge;
	}

	public float getEffectiveMarge() {
		float diffCoefDep = this.getH() / this.getBalle().getyBalleCoefDeplacement();
		float diffMarge = this.getH() / marge;
		
		float maxDiff = diffCoefDep;
		if (maxDiff > diffMarge) {
			maxDiff = diffMarge;
		}
		
		return marge;
	}

	public void setMarge(float marge) {
		this.marge = marge;
	}

	public boolean isGameOverFirstUse() {
		return gameOverFirstUse;
	}

	public void setGameOverFirstUse(boolean gameOverFirstUse) {
		this.gameOverFirstUse = gameOverFirstUse;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public List<Image> getListImage() {
		return listImage;
	}

	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}

	public List<Sound> getListSound() {
		return listSound;
	}

	public void setListSound(List<Sound> listSound) {
		this.listSound = listSound;
	}

	public int getBriqueBreaked() {
		return briqueBreaked;
	}

	public void setBriqueBreaked(int briqueBreaked) {
		this.briqueBreaked = briqueBreaked;
	}

	public int getHitOnWalls() {
		return hitOnWalls;
	}

	public void setHitOnWalls(int hitOnWalls) {
		this.hitOnWalls = hitOnWalls;
	}

}
