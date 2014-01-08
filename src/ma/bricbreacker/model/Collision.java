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

		Point pointA = balle.getPosition();
		Point pointB = balle.getNextPoint();

		Line lineBalle = new Line(pointA, pointB);

		// Rectangle bounds;
		Polygon polygon;

		// Rectangle bounds2;
		Polygon polygon2;

		// System.out.println(balle.getA());
		// System.out.println(balle.getB());
		// System.out.println(balle.getC());
		// System.out.println(balle.getD());
		// System.out.println(brique.getA());
		// System.out.println(brique.getB());
		// System.out.println(brique.getC());
		// System.out.println(brique.getD());

		// bounds = new Rectangle(0, 0, 32, 20);
		polygon = new Polygon(new float[] { balle.getA().getX(),
				balle.getA().getY(), balle.getB().getX(), balle.getB().getY(),
				balle.getC().getX(), balle.getC().getY(), balle.getD().getX(),
				balle.getD().getY() });
		// polygon = new Polygon(new
		// float[]{0,0,balle.getWidth(),0,balle.getWidth(),balle.getHeight(),0,balle.getHeight()});
		polygon.setOrigin(balle.getWidth() / 2, balle.getHeight() / 2);

		Polygon ur = new Polygon(new float[] { brique.getA().getX(),
				brique.getA().getY(), brique.getB().getX(),
				brique.getB().getY(), brique.getD().getX(),
				brique.getD().getY() });
		
		Polygon ul = new Polygon(new float[] { brique.getA().getX(),
				brique.getA().getY(), brique.getB().getX(),
				brique.getB().getY(), brique.getC().getX(),
				brique.getC().getY() });
		
		Polygon dl = new Polygon(new float[] { brique.getB().getX(),
				brique.getB().getY(), brique.getC().getX(),
				brique.getC().getY(), brique.getD().getX(),
				brique.getD().getY() });
		
		Polygon dr = new Polygon(new float[] { brique.getA().getX(),
				brique.getA().getY(), brique.getC().getX(),
				brique.getC().getY(), brique.getD().getX(),
				brique.getD().getY() });
		

		// bounds2 = new Rectangle(0, 0, 32, 20);
		polygon2 = new Polygon(new float[] { brique.getA().getX(),
				brique.getA().getY(), brique.getB().getX(),
				brique.getB().getY(), brique.getC().getX(),
				brique.getC().getY(), brique.getD().getX(),
				brique.getD().getY() });
		// polygon2 = new Polygon(new float[]{brique.getX(), brique.getY(),
		// brique.getX() + brique.getWidth(), brique.getY(), brique.getX() +
		// brique.getWidth(), brique.getY() + brique.getHeight(), brique.getX(),
		// brique.getY() + brique.getHeight()});
		// polygon2 = new Polygon(new
		// float[]{0,0,brique.getWidth(),0,brique.getWidth(),brique.getHeight(),0,brique.getHeight()});
		polygon2.setOrigin(brique.getWidth() / 2, brique.getHeight() / 2);

		// polygon.setPosition(balle.getX(), balle.getY());
		// // polygon.setRotation(car1.rotation);
		// polygon2.setPosition(brique.getX(), brique.getY());
		// // polygon2.setRotation(car2.rotation);

		if (Intersector.overlapConvexPolygons(polygon, polygon2)) {
			// COLLISION DON'T HAPPEN!!!
			this.setCollision(true);
		}

		// System.out.println(balle.isBalleUp() + ", " + balle.isBalleRight());
		//
		// System.out.println(lineBalle.collision(brique.getLineUp()) + " "
		// +lineBalle.collision(brique.getLineDown()) + " "
		// +lineBalle.collision(brique.getLineRight()) + " "
		// +lineBalle.collision(brique.getLineLeft()));

		// System.out.println("getPosition " + brique.getPosition());
		// System.out.println("getLineUp " + brique.getLineUp().getBegin() +
		// "; " + brique.getLineUp().getEnd());
		// System.out.println("getLineDown " + brique.getLineDown().getBegin() +
		// "; " + brique.getLineDown().getEnd());
		// System.out.println("getLineRight " + brique.getLineRight().getBegin()
		// + "; " + brique.getLineRight().getEnd());
		// System.out.println("getLineLeft " + brique.getLineLeft().getBegin() +
		// "; " + brique.getLineLeft().getEnd());
		//
		// System.out.println("brique.getLineUp() = " + brique.getLineUp());
		// System.out.println("brique.getLineDown() = " + brique.getLineDown());
		// System.out.println("brique.getLineRight() = " +
		// brique.getLineRight());
		// System.out.println("brique.getLineLeft() = " + brique.getLineLeft());

		// // if (balle.isBalleDown()) {
		// // if (balle.isBalleLeft()) {
		// if (lineBalle.collision(brique.getLineRight())) {
		// this.setCollisionTypeH(CollisionType.Right);
		// this.setCollision(true);
		// }
		//
		// if (lineBalle.collision(brique.getLineUp())) {
		// this.setCollisionTypeV(CollisionType.Up);
		// this.setCollision(true);
		// }
		// // }
		// //
		// // if (balle.isBalleRight()) {
		// if (lineBalle.collision(brique.getLineLeft())) {
		// this.setCollisionTypeH(CollisionType.Left);
		// this.setCollision(true);
		// }
		//
		// if (lineBalle.collision(brique.getLineUp())) {
		// this.setCollisionTypeV(CollisionType.Up);
		// this.setCollision(true);
		// }
		// // }
		// // }
		// //
		// // if (balle.isBalleUp()) {
		// // if (balle.isBalleLeft()) {
		// if (lineBalle.collision(brique.getLineRight())) {
		// this.setCollisionTypeH(CollisionType.Right);
		// this.setCollision(true);
		// }
		//
		// if (lineBalle.collision(brique.getLineDown())) {
		// this.setCollisionTypeV(CollisionType.Down);
		// this.setCollision(true);
		// }
		// // }
		// //
		// // if (balle.isBalleRight()) {
		// if (lineBalle.collision(brique.getLineLeft())) {
		// this.setCollisionTypeH(CollisionType.Left);
		// this.setCollision(true);
		// }
		//
		// if (lineBalle.collision(brique.getLineDown())) {
		// this.setCollisionTypeV(CollisionType.Down);
		// this.setCollision(true);
		// }
		// // }
		// // }
		// // Point pointC = image.getPositionCenter();
		//
		// // Point pointDeltaAB = new Point(pointA.getX() + (pointB.getX() -
		// pointA.getX()) / 2, pointA.getY() + (pointB.getY() - pointA.getY()));

		// Intersector.overlapConvexPolygons(

		// if (((image1.getX() >= image2.getX() && image1.getX() <=
		// image2.getX() + image2.getWidth())
		// || (image2.getX() >= image1.getX() && image2.getX() <= image1.getX()
		// + image1.getWidth()))
		// && ((image1.getY() <= image2.getY())
		// && (image1.getY() + image1.getHeight() >= image2.getY()))) {
		//
		// this.setCollision(true);
		//
		// if ((image2.getY() - image1.getY()) >= (image1.getY() +
		// image1.getHeight() - image2.getY())) {
		// this.setCollisionTypeV(CollisionType.Up);
		// System.out.println("Up");
		// } else {
		// this.setCollisionTypeV(CollisionType.Down);
		// System.out.println("Down");
		// }
		// }
		//
		//
		// if (((image1.getY() >= image2.getY() && image1.getY() <=
		// image2.getY() + image2.getHeight())
		// || (image2.getY() >= image1.getY() && image2.getY() <= image1.getY()
		// + image1.getHeight()))
		// && ((image2.getX() <= image1.getX())
		// && (image2.getX() + image2.getWidth() >= image1.getX()))) {
		//
		// this.setCollision(true);
		//
		// if ((image1.getX() - image2.getX()) >= (image2.getX() +
		// image2.getWidth() - image1.getX())) {
		// this.setCollisionTypeH(CollisionType.Left);
		// System.out.println("Left");
		// } else {
		// this.setCollisionTypeH(CollisionType.Right);
		// System.out.println("Right");
		// }
		// }
	}
}
