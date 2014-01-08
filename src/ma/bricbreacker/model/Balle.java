package ma.bricbreacker.model;

import com.badlogic.gdx.graphics.Texture;

public class Balle extends Image {

	private float xBalleCoefDeplacement;
	private float yBalleCoefDeplacement;
	
	public boolean isTouchTheWallW(float w) {
		if (this.getX() < 0) {
			this.setX(0);
			return true;
		}

		if (w - this.getWidth() < this.getX()) {
			this.setX(w - this.getWidth());
			return true;
		}
		
		return false;
	}

	public boolean isTouchTheWallH(float h) {
		if (this.getY() < 0) {
			this.setY(0);
			return true;
		}
		
		if (h - this.getHeight() < this.getY()) {
			this.setY(h - this.getHeight());
			return true;
		}
		
		return false;
	}
	
	public float getxBalleCoefDeplacement() {
		return xBalleCoefDeplacement;
	}

	public void setxBalleCoefDeplacement(float xBalleCoefDeplacement) {
		this.xBalleCoefDeplacement = xBalleCoefDeplacement;
	}

	public float getyBalleCoefDeplacement() {
		return yBalleCoefDeplacement;
	}

	public void setyBalleCoefDeplacement(float yBalleCoefDeplacement) {
		this.yBalleCoefDeplacement = yBalleCoefDeplacement;
	}

	public boolean isBalleFail(float w) {
		if (this.getY() <= 0) {
			return true;
		}
		 
		return false;
	}
	
	
	public boolean isBalleHitBarre(Barre barre, float xBalleCoefDeplacementTemp, float yBalleCoefDeplacementTemp) {
		if (this.isCollision(barre)) {
			this.setyBalleCoefDeplacement(-1
					* this.getyBalleCoefDeplacement());
			
			float vitesse = barre.getVitesse();
			
//			if (vitesse > this.getyBalleCoefDeplacement() / 2) {
//				vitesse = yBalleCoefDeplacementTemp / 2;
//			}
			
			this.setxBalleCoefDeplacement(this.getxBalleCoefDeplacement() / 2 + (vitesse + xBalleCoefDeplacementTemp) / 2);
			this.setY(barre.getY() + barre.getHeight());
			
			return true;
		}
		
		return false;
	}

	public Balle(Texture texture) {
		super(texture);
	}
	
	public Point getNextPoint(){
		Point point = new Point(
				this.getX() + this.getxBalleCoefDeplacement(), 
				this.getY() + this.getyBalleCoefDeplacement());
		
		return point;
	}
	
	public boolean isBalleUp() {
		return (this.getyBalleCoefDeplacement() >= 0);
	}
	
	public boolean isBalleDown() {
		return !this.isBalleUp();
	}
	
	public boolean isBalleRight() {
		return (this.getxBalleCoefDeplacement() >= 0);
	}
	
	public boolean isBalleLeft() {
		return !this.isBalleRight();
	}
}
