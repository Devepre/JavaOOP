package lection01.task02;

public class Main {

	public static void main(String[] args) {
		double a = 2;
		double b = 2;
		double c = 2;
		Triangle tOne = new Triangle(a, b, c);
		double areaOne = tOne.calculateArea();
		boolean isExist = tOne.checkExistence(true);
		System.out.format("Area tOne [%.2f %.2f %.2f] is: %.2f%s", tOne.getLengthA(), tOne.getLengthB(),
				tOne.getLengthC(), areaOne, System.lineSeparator());

		c = 5;
		Triangle tTwo = new Triangle(a, b, c);
		double areaTwo = tTwo.calculateArea();
		isExist = tTwo.checkExistence(true);
		System.out.format("Area tTwo [%.2f %.2f %.2f] is: %.2f%s", tTwo.getLengthA(), tTwo.getLengthB(),
				tTwo.getLengthC(), areaTwo, System.lineSeparator());

		a = 3;
		c = 7;
		Triangle tThree = new Triangle(3, 2, 7);
		double areaThree = tThree.calculateArea();
		isExist = tThree.checkExistence(false);
		System.out.format("Area tThree [%.2f %.2f %.2f] is: %.2f%s", tThree.getLengthA(), tThree.getLengthB(),
				tThree.getLengthC(), areaThree, System.lineSeparator());

		tThree.setLengthB(8);
		areaThree = tThree.calculateArea();
		isExist = tThree.checkExistence(true);
		System.out.format("Area tThree [%.2f %.2f %.2f] is: %.2f%s", tThree.getLengthA(), tThree.getLengthB(),
				tThree.getLengthC(), areaThree, System.lineSeparator());
		
		tThree.setLengthB(9);
		areaThree = tThree.calculateArea();
		isExist = tThree.checkExistence(true);
		System.out.format("Area tThree [%.2f %.2f %.2f] is: %.2f%s", tThree.getLengthA(), tThree.getLengthB(),
				tThree.getLengthC(), areaThree, System.lineSeparator());
		
		tThree.setArea(3.14);
		
		System.out.format("Area tThree [%.2f %.2f %.2f] is: %.2f%s", tThree.getLengthA(), tThree.getLengthB(),
				tThree.getLengthC(), tThree.getArea(), System.lineSeparator());
		
		System.out.format("Area tThree [%.2f %.2f %.2f] is: %.2f%s", tThree.getLengthA(), tThree.getLengthB(),
				tThree.getLengthC(), tThree.calculateArea(), System.lineSeparator());
	}

}
