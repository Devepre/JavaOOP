package lection02.task01;

public class Triangle extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Triangle() {
		super();
		pointA = new Point();
		pointB = new Point();
		pointC = new Point();
	}

	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	@Override
	public double getPerimetr() {
		if (checkExistance()) {
			double perimetr = 0;
			perimetr = pointA.getDistanceTo(pointB) + pointB.getDistanceTo(pointC) + pointC.getDistanceTo(pointA);
			return perimetr;
		}
		return -1;
	}

	@Override
	public double getArea() {
		if (checkExistance()) {
			double area = 0;
			double a = pointA.getDistanceTo(pointB);
			double b = pointB.getDistanceTo(pointC);
			double c = pointC.getDistanceTo(pointA);
			double halfPerimetr = (a + b + c) / 2;
			area = Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
			return area;
		}
		return -1;
	}

	protected boolean checkNullPoints() {
		return Point.checkPoints(pointA, pointB, pointC) ? true : false;
	}

	protected boolean checkExistance() {
		if (checkNullPoints()) {
			double a = pointA.getDistanceTo(pointB);
			double b = pointB.getDistanceTo(pointC);
			double c = pointC.getDistanceTo(pointA);
			if (a + b <= c || a + c <= b || b + c <= a) {
				return false;
			} else {
				return true;
			}
		}
		return false;
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

	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}

}
