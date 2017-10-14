package lection01.task03;

public class Main {

	public static void main(String[] args) {
		Vector3d vectorOne = new Vector3d(2, 4, 2);
		Vector3d vectorTwo = new Vector3d(4, 2, 5);
		Vector3d vectorThree = new Vector3d(1, 1, 1);

		Vector3d vectorSum = Vector3d.sum(vectorOne, vectorTwo, vectorThree);
		double multi = Vector3d.scalarMultiply(vectorOne, vectorTwo);		
		
		Vector3d vectorMulti = Vector3d.vectorMultiply(vectorOne, vectorTwo);
		Vector3d vectorMulti2 = Vector3d.vectorMultiply(new Vector3d(16, -2, -12), vectorThree);
		Vector3d vectorMulti3 = Vector3d.vectorMultiply(vectorOne, vectorTwo, vectorThree);

		System.out.println(vectorOne);
		System.out.println(vectorTwo);
		System.out.println(vectorThree);		
		System.out.println("Sum = " + vectorSum);
		System.out.println(multi);		
		System.out.println(vectorMulti);
		System.out.println(vectorMulti2);
		System.out.println(vectorMulti3);
	}

}
