package lection01.task03;

public class Vector3d {
	private double cX;
	private double cY;
	private double cZ;

	public Vector3d() {
		super();
		this.cX = 0;
		this.cY = 0;
		this.cZ = 0;
	}

	public Vector3d(double cX, double cY, double cZ) {
		super();
		this.cX = cX;
		this.cY = cY;
		this.cZ = cZ;
	}

	public static Vector3d sum(Vector3d... vectors) {
		double sumX = 0;
		double sumY = 0;
		double sumZ = 0;
		for (Vector3d vectorCurrent : vectors) {
			sumX += vectorCurrent.getcX();
			sumY += vectorCurrent.getcY();
			sumZ += vectorCurrent.getcZ();
		}
		Vector3d vectorSum = new Vector3d(sumX, sumY, sumZ);

		return vectorSum;
	}

	public static double scalarMultiply(Vector3d vectorOne, Vector3d vectorTwo) {
		double result = 0;
		double multX = vectorOne.getcX();
		double multY = vectorOne.getcY();
		double multZ = vectorOne.getcZ();

		multX *= vectorTwo.getcX();
		multY *= vectorTwo.getcY();
		multZ *= vectorTwo.getcZ();
		result = multX + multY + multZ;

		return result;
	}

	public static Vector3d vectorMultiply(Vector3d vectorOne, Vector3d vectorTwo) {
		double resX = vectorOne.getcY() * vectorTwo.getcZ() - vectorOne.getcZ() * vectorTwo.getcY();
		double resY = vectorOne.getcZ() * vectorTwo.getcX() - vectorOne.getcX() * vectorTwo.getcZ();
		double resZ = vectorOne.getcX() * vectorTwo.getcY() - vectorOne.getcY() * vectorTwo.getcX();
		Vector3d vectorRes = new Vector3d(resX, resY, resZ);

		return vectorRes;
	}

	public static Vector3d vectorMultiply(Vector3d... vectors) {
		Vector3d vectorRes = vectors[0];
		for (int i = 1; i < vectors.length; i++) {
			vectorRes = Vector3d.vectorMultiply(vectorRes, vectors[i]);
		}

		return vectorRes;
	}

	public double getcX() {
		return cX;
	}

	public void setcX(double cX) {
		this.cX = cX;
	}

	public double getcY() {
		return cY;
	}

	public void setcY(double cY) {
		this.cY = cY;
	}

	public double getcZ() {
		return cZ;
	}

	public void setcZ(double cZ) {
		this.cZ = cZ;
	}

	@Override
	public String toString() {
		return "Vector3d [cX=" + cX + ", cY=" + cY + ", cZ=" + cZ + "]";
	}

}
