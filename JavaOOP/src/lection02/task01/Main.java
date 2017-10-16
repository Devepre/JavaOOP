package lection02.task01;

public class Main {

	public static void main(String[] args) {
		Point pOne = new Point(1, 1);
		Point pTwo = new Point(0, 2);
		Point pThree = new Point(0, 3);
		
		Triangle tri = new Triangle(pOne, pTwo, pThree);
		//Triangle tri = new Triangle(null, null, null);
		double triArea = tri.getArea();
		double triPerimetr = tri.getPerimetr();

		System.out.println(tri);
		System.out.println("Area: " + triArea);
		System.out.println("Perimetr: " + triPerimetr);
		
		Circle cir = new Circle(new Point(), pTwo);
		System.out.println(cir);
		System.out.println("Circle length is: " + cir.getPerimetr());
		System.out.println("Circle area is: " + cir.getArea());
	}

}
