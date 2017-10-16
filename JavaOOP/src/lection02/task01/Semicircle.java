package lection02.task01;

public class Semicircle extends Circle {

	public Semicircle(Point centerPoint, Point radiusPoint) {
		super(centerPoint, radiusPoint);
	}
	
	@Override
	public double getPerimetr() {
		if (checkNullPoints()) {
			double perimetr = super.getPerimetr() / 2 + getRadius() * 2;
			return perimetr;
		}
		return -1;
	}

	@Override
	public double getArea() {
		if (checkNullPoints()) {
			double area = super.getArea() / 2;
			return area;
		}
		return -1;
	}

}
