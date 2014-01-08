package ma.bricbreacker.model;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class Collision {

	private boolean isCollision;
	private CollisionType collisionTypeV;
	private CollisionType collisionTypeH;

	public boolean isCollision() {
		return isCollision;
	}

	public void setCollision(boolean isCollision) {
		this.isCollision = isCollision;
	}

	public CollisionType getCollisionTypeV() {
		return collisionTypeV;
	}

	public void setCollisionTypeV(CollisionType collisionTypeV) {
		this.collisionTypeV = collisionTypeV;
	}

	public CollisionType getCollisionTypeH() {
		return collisionTypeH;
	}

	public void setCollisionTypeH(CollisionType collisionTypeH) {
		this.collisionTypeH = collisionTypeH;
	}

	public Collision(Balle balle, Brique brique) {
		Polygon polygonBalle = new Polygon(new float[] { balle.getA().getX(),
				balle.getA().getY(), balle.getB().getX(), balle.getB().getY(),
				balle.getC().getX(), balle.getC().getY(), balle.getD().getX(),
				balle.getD().getY() });

		if (balle.isBalleUp()) {
			if (balle.isBalleRight()) {
				Polygon ur = new Polygon(new float[] { brique.getA().getX(),
						brique.getA().getY(), brique.getB().getX(),
						brique.getB().getY(), brique.getD().getX(),
						brique.getD().getY() });
				
				Polygon dl = new Polygon(new float[] { brique.getB().getX(),
						brique.getB().getY(), brique.getC().getX(),
						brique.getC().getY(), brique.getD().getX(),
						brique.getD().getY() });
				
				if (Intersector.overlapConvexPolygons(polygonBalle, ur)) {
					balle.setxBalleCoefDeplacement(-1 * balle.getxBalleCoefDeplacement());
					this.setCollision(true);
				} else
				if (Intersector.overlapConvexPolygons(polygonBalle, dl)) {
					balle.setyBalleCoefDeplacement(-1 * balle.getyBalleCoefDeplacement());
					this.setCollision(true);
				}
			}
			if (balle.isBalleLeft()) {				
				Polygon ul = new Polygon(new float[] { brique.getA().getX(),
						brique.getA().getY(), brique.getB().getX(),
						brique.getB().getY(), brique.getC().getX(),
						brique.getC().getY() });
				
				Polygon dr = new Polygon(new float[] { brique.getA().getX(),
						brique.getA().getY(), brique.getC().getX(),
						brique.getC().getY(), brique.getD().getX(),
						brique.getD().getY() });
				
				if (Intersector.overlapConvexPolygons(polygonBalle, dr)) {
					balle.setyBalleCoefDeplacement(-1 * balle.getyBalleCoefDeplacement());
					this.setCollision(true);
				} else
				if (Intersector.overlapConvexPolygons(polygonBalle, ul)) {
					balle.setxBalleCoefDeplacement(-1 * balle.getxBalleCoefDeplacement());
					this.setCollision(true);
				}
			}
		} else
		if (balle.isBalleDown()) {
			if (balle.isBalleRight()) {
				Polygon ul = new Polygon(new float[] { brique.getA().getX(),
						brique.getA().getY(), brique.getB().getX(),
						brique.getB().getY(), brique.getC().getX(),
						brique.getC().getY() });
				
				Polygon dr = new Polygon(new float[] { brique.getA().getX(),
						brique.getA().getY(), brique.getC().getX(),
						brique.getC().getY(), brique.getD().getX(),
						brique.getD().getY() });
				
				if (Intersector.overlapConvexPolygons(polygonBalle, dr)) {
					balle.setxBalleCoefDeplacement(-1 * balle.getxBalleCoefDeplacement());
					this.setCollision(true);
				} else
				if (Intersector.overlapConvexPolygons(polygonBalle, ul)) {
					balle.setyBalleCoefDeplacement(-1 * balle.getyBalleCoefDeplacement());
					this.setCollision(true);
				}
			}
			if (balle.isBalleLeft()) {
				Polygon ur = new Polygon(new float[] { brique.getA().getX(),
						brique.getA().getY(), brique.getB().getX(),
						brique.getB().getY(), brique.getD().getX(),
						brique.getD().getY() });
				
				Polygon dl = new Polygon(new float[] { brique.getB().getX(),
						brique.getB().getY(), brique.getC().getX(),
						brique.getC().getY(), brique.getD().getX(),
						brique.getD().getY() });
				
				if (Intersector.overlapConvexPolygons(polygonBalle, ur)) {
					balle.setyBalleCoefDeplacement(-1 * balle.getyBalleCoefDeplacement());
					this.setCollision(true);
				} else
				if (Intersector.overlapConvexPolygons(polygonBalle, dl)) {
					balle.setxBalleCoefDeplacement(-1 * balle.getxBalleCoefDeplacement());
					this.setCollision(true);
				}
			}
		}
	}
}
