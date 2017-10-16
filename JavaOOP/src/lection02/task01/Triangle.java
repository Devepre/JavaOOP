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

	public Triangle(Point pA, Point pB, Point pC) {
		super();
		this.pointA = pA;
		this.pointB = pB;
		this.pointC = pC;
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
		if (Point.checkPoints(pointA, pointB, pointC)) {
			return true;
		}
		return false;
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

	public Point getpA() {
		return pointA;
	}

	public void setpA(Point pA) {
		this.pointA = pA;
	}

	public Point getpB() {
		return pointB;
	}

	public void setpB(Point pB) {
		this.pointB = pB;
	}

	public Point getpC() {
		return pointC;
	}

	public void setpC(Point pC) {
		this.pointC = pC;
	}

	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}

}
