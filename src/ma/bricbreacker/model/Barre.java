package ma.bricbreacker.model;

import com.badlogic.gdx.graphics.Texture;

public class Barre extends Image {

	private float oldX = 0;

	public Barre(Texture texture) {
		super(texture);
	}

	public void move(float position) {
		this.setOldX(this.getX());
		this.setX(position - (this.getWidth() / 2));
	}
	
	public float getVitesse() {
		return 
//				Math.abs(
						this.getX() - this.getOldX()
//						)
						;
	}
	
	public float getOldX() {
		return oldX;
	}

	public void setOldX(float oldX) {
		this.oldX = oldX;
	}
}
