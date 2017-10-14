package lection01.task02;

public class Triangle {
	private double lengthA;
	private double lengthB;
	private double lengthC;
	private double area;
	private boolean renewed;

	public Triangle() {
		super();
	}

	public Triangle(double lengthA, double lengthB, double lengthC) {
		super();
		this.lengthA = lengthA;
		this.lengthB = lengthB;
		this.lengthC = lengthC;
	}

	public double calculateArea() {
		if (checkExistence(false)) {
			if (renewed) {
				double p = (lengthA + lengthB + lengthC) / 2;
				area = Math.sqrt(p * (p - lengthA) * (p - lengthB) * (p - lengthC));
			}

		}

		return area;
	}

	public boolean checkExistence(boolean inform) {
		boolean exist = true;
		if ((lengthA + lengthB <= lengthC) || (lengthA + lengthC <= lengthB) || (lengthB + lengthC <= lengthA)) {
			exist = false;
			if (inform) {
				System.out.format("Attention! %s doesn't exist", this);
				System.out.println();
			}
		}

		return exist;
	}

	public double getLengthA() {
		return lengthA;
	}

	public void setLengthA(double lengthA) {
		this.lengthA = lengthA;
		setRenewed(true);
	}

	public double getLengthB() {
		return lengthB;
	}

	public void setLengthB(double lengthB) {
		this.lengthB = lengthB;
		setRenewed(true);
	}

	public double getLengthC() {
		return lengthC;
	}

	public void setLengthC(double lengthC) {
		this.lengthC = lengthC;
		setRenewed(true);
	}

	public boolean isRenewed() {
		return renewed;
	}

	public void setRenewed(boolean renewed) {
		this.renewed = renewed;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
		setRenewed(true);
	}

	@Override
	public String toString() {
		return "Triangle [lengthA=" + lengthA + ", lengthB=" + lengthB + ", lengthC=" + lengthC + "]";
	}

}
