package lection02.task01;

public class Triangle extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Triangle() {
		super();
	}

	public Triangle(Point pA, Point pB, Point pC) {
		super();
		this.pointA = pA;
		this.pointB = pB;
		this.pointC = pC;
	}

	@Override
	public double getPerimetr() {
		double perimetr = 0;
		perimetr = getLength(pointA, pointB) + getLength(pointB, pointC) + getLength(pointC, pointA);				
		return perimetr;
	}

	private double getLength(Point pointA, Point pointB) {
		double length = 0;
		length = Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2) + Math.pow(pointB.getY() - pointA.getY(), 2));
		return length;
	}

	@Override
	public double getArea() {
		
		return 0;
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
