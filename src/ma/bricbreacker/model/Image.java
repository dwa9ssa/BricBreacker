package ma.bricbreacker.model;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Image {
	
	private Point position = new Point();
	private Texture texture;

	private Point a;
	private Point b;
	private Point c;
	private Point d;
	
//	private Line lineUp;
//	private Line lineDown;
//	private Line lineRight;
//	private Line lineLeft;

	public Image(Texture texture) {
		this.texture = texture;
	}
	
	public void makeLines() {
		a = new Point(this.getX(), this.getY() + this. getHeight());
		b = new Point(this.getX() + this.getWidth(), this.getY() + this.getHeight());
		c = new Point(this.getX() + this.getWidth(), this.getY());
		d = position;
		
//		lineUp = new Line(a, b);
//		
//		lineDown = new Line(d, c);
//		
//		lineLeft = new Line(a, d);
//		
//		lineRight = new Line(b, c);
	}

	public float getX() {
		return position.getX();
	}
	
	public void setX(float x) {
		this.position.setX(x);
	}
	
	public float getY() {
		return position.getY();
	}
	
	public void setY(float y) {
		this.position.setY(y);
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public Point getPositionCenter() {
		Point point = new Point();

		point.setX(this.getX() + this.getWidth() / 2);
		point.setY(this.getY() + this.getHeight() / 2);
		
		return point;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public int getHeight() {
		return texture.getHeight();
	}
	
	public int getWidth() {
		return texture.getWidth();
	}
	
	public boolean isCollision(Image image) {
		return isCollisionUp(image) || isCollisionDown(image) || isCollisionLeft(image) || isCollisionRight(image);
	}
	
	public boolean isCollisionUp(Image image) {
		if (((this.getX() >= image.getX() && this.getX() <= image.getX() + image.getWidth()) 
			|| (image.getX() >= this.getX() && image.getX() <= this.getX() + this.getWidth())) 
			&& ((this.getY() <= image.getY()) 
				&& (this.getY() + this.getHeight() >= image.getY()))) {
			System.out.println("isCollisionUp");
			return true;
		}
		
		return false;
	}
	
	public boolean isCollisionDown(Image image) {
		if (((this.getX() >= image.getX() && this.getX() <= image.getX() + image.getWidth()) 
			|| (image.getX() >= this.getX() && image.getX() <= this.getX() + this.getWidth())) 
			&& ((image.getY() <= this.getY()) 
				&& (image.getY() + image.getHeight() >= this.getY() ))) {
			System.out.println("isCollisionDown");
			return true;
		}
		
		return false;
	}
	
	public boolean isCollisionLeft(Image image) {
		if (((this.getY() >= image.getY() && this.getY() <= image.getY() + image.getHeight()) 
			|| (image.getY() >= this.getY() && image.getY() <= this.getY() + this.getHeight())) 
			&& ((image.getX() <= this.getX()) 
				&& (image.getX() + image.getWidth() >= this.getX()))) {
			System.out.println("isCollisionLeft");
			return true;
		}
		
		return false;
	}
	
	public boolean isCollisionRight(Image image) {
		if (((this.getY() >= image.getY() && this.getY() <= image.getY() + image.getHeight()) 
			|| (image.getY() >= this.getY() && image.getY() <= this.getY() + this.getHeight())) 
			&& ((this.getX() <= image.getX()) 
				&& (this.getX() + this.getWidth() >= image.getX()))) {
			System.out.println("isCollisionRight");
			return true;
		}
		
		return false;
	}
	
	public String toString () {
		return "X = " + this.getX() + "; Y = " + this.getY() + "; Height = " + this.getHeight() + "; Width = " + this.getWidth() + ";";
	}
	
	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	public Point getD() {
		return d;
	}

	public void setD(Point d) {
		this.d = d;
	}

	
	
//	public Line getLineUp() {
//		return lineUp;
//	}
//
//	public void setLineUp(Line lineUp) {
//		this.lineUp = lineUp;
//	}
//
//	public Line getLineDown() {
//		return lineDown;
//	}
//
//	public void setLineDown(Line lineDown) {
//		this.lineDown = lineDown;
//	}
//
//	public Line getLineRight() {
//		return lineRight;
//	}
//
//	public void setLineRight(Line lineRight) {
//		this.lineRight = lineRight;
//	}
//
//	public Line getLineLeft() {
//		return lineLeft;
//	}
//
//	public void setLineLeft(Line lineLeft) {
//		this.lineLeft = lineLeft;
//	}
}
