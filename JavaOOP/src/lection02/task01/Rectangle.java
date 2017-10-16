package lection02.task01;

public class Rectangle extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;

	public Rectangle() {
		super();
		pointA = new Point();
		pointB = new Point();
		pointC = new Point();
		pointD = new Point();
	}

	public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
	}

	@Override
	public double getPerimetr() {
		if (checkNullPoints()) {
			double a = pointA.getDistanceTo(pointB);
			double b = pointB.getDistanceTo(pointC);
			double c = pointC.getDistanceTo(pointD);
			double d = pointD.getDistanceTo(pointA);
			double perimetr = a + b + c + d;
			return perimetr;
		}
		return -1;
	}

	@Override
	public double getArea() {
		if (checkNullPoints()) {
			double a = pointA.getDistanceTo(pointB);
			double b = pointB.getDistanceTo(pointC);
			double area = a * b;
			return area;
		}
		return -1;
	}

	protected boolean checkNullPoints() {
		return Point.checkPoints(pointA, pointB, pointC, pointD) ? true : false;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", pointD=" + pointD + "]";
	}

}
