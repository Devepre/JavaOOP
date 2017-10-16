package lection02.task01;

public class Circle extends Shape {
	private Point centerPoint;
	private Point radiusPoint;

	public Circle() {
		super();
		centerPoint = new Point();
		radiusPoint = new Point();
	}

	public Circle(Point centerPoint, Point radiusPoint) {
		super();
		this.centerPoint = centerPoint;
		this.radiusPoint = radiusPoint;
	}

	@Override
	public double getPerimetr() {
		double perimetr = -1;
		if (checkPoints()) {
			perimetr = 2 * Math.PI * getRadius();
		}
		return perimetr;
	}

	@Override
	public double getArea() {
		double area = -1;
		if (checkPoints()) {
			double radius = getRadius();
			area = Math.PI * radius * radius;
		}
		return area;
	}

	protected double getRadius() {
		double radius = 0;
		if (checkPoints()) {
			radius = centerPoint.getDistanceTo(radiusPoint);
		}
		return radius;
	}

	protected boolean checkPoints() {
		if (Point.checkPoints(centerPoint, radiusPoint)) {
			return true;
		}
		return false;
	}

	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	public Point getCirclePoint() {
		return radiusPoint;
	}

	public void setCirclePoint(Point circlePoint) {
		this.radiusPoint = circlePoint;
	}

	@Override
	public String toString() {
		return "Circle [centerPoint=" + centerPoint + ", radiusPoint=" + radiusPoint + "]";
	}

}
