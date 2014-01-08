package ma.bricbreacker.model;

public class Line {

	private Point begin;
	private Point end;
	
	private Float a;
	private Float b;
	
	public Line() {
	}

	public Line(Point begin, Point end) {
		this.begin = begin;
		this.end = end;
	}
	
	public float f(float x) {
		return this.getA() * x + this.getB();
	}
	
	public float collisionX(Line line) {
		return (this.getB() - line.getB()) / (line.getA() -this.getA());
	}
	
	public boolean collision(Line line) {
		float result = collisionX(line);

		float beginXA = line.getBegin().getX();
		float endXA = line.getEnd().getX();
		
		float beginXB = this.getBegin().getX();
		float endXB = this.getEnd().getX();

		if (beginXA >= endXA) {
			float temp = beginXA;
			beginXA = endXA;
			endXA = temp;
		}
		
		if (beginXB >= endXB) {
			float temp = beginXB;
			beginXB = endXB;
			endXB = temp;
		}

		if (beginXA < beginXB) { beginXA = beginXB; }
		if (endXA > endXB) { endXA = endXB; }
		
		if ((this.f(result) == line.f(result)) &&  (result >= beginXA && result <= endXA)){
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return this.getA() + "x + " + this.getB();
	}
	
	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	

	public float getA() {
		if (a == null) {
			a = (end.getY() - begin.getY()) / (end.getX() - begin.getX());   
		}
		
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		if (b == null) {
			b = begin.getY() - this.getA() * begin.getX();
		}
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}
}
