package lection02.task01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Work with separate objects:");
		
		Point pOne = new Point(1, 1);
		Point pTwo = new Point(0, 2);
		Point pThree = new Point(0, 3);
		
		Triangle tri = new Triangle(pOne, pTwo, pThree);
		Triangle triN = new Triangle(null, null, null);
		double triArea = tri.getArea();
		double triPerimetr = tri.getPerimetr();

		System.out.println(tri);
		System.out.println("Area: " + triArea);
		System.out.println("Perimetr: " + triPerimetr);
		
		Circle cir = new Circle(new Point(), pTwo);
		System.out.println(cir);
		System.out.println("Circle length is: " + cir.getPerimetr());
		System.out.println("Circle area is: " + cir.getArea());
		
		Semicircle semiCircle = new Semicircle(new Point(), pTwo);
		System.out.println("Semicircle length is; " + semiCircle.getPerimetr());
		System.out.println("Semicircle area is: " + semiCircle.getArea());
		
		System.out.println();
		System.out.println("Work with Board: ");
		
		Board shBoard = new Board();
		shBoard.printBoard();
		shBoard.addShape(tri);		
		shBoard.addShape(2, cir);	
		shBoard.printBoard();
		shBoard.addShape(1, semiCircle);
		//shBoard.addShape(triN);		
		shBoard.addShape(new Rectangle(pThree, pOne, pTwo, new Point()));
		
		shBoard.printBoard();
	
	}

}
