package ma.bricbreacker.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;

public class Brique extends Image {

	private boolean isVisible = true;
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Brique(Texture texture) {
		super(texture);
	}
}
