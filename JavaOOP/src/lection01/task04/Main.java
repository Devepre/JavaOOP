package lection01.task04;

public class Main {

	public static void main(String[] args) {		
		Network kyivCell = new Network("KyivCell");
		kyivCell.setName("KyivCell 4G");
		
		Phone nokiaOne = new Phone("Nokia S", "097-999-66-55");
		Phone samsungOne = new Phone();
		Phone samsungTwo = new Phone("Samsung Galaxy", "094-666-44-78");
		Phone samsungThree = new Phone("Lenovo", "094-666-44-78");
		
		nokiaOne.registerToNetwork(kyivCell);	
		kyivCell.registerNewPhone(samsungOne);
		samsungTwo.registerToNetwork(kyivCell);
		samsungThree.registerToNetwork(kyivCell);
		
		samsungOne.setOn(true);
		samsungOne.call("1111");
				
		nokiaOne.call("097-999-66-55");
		nokiaOne.call("094-666-44-78");
		
		nokiaOne.setOn(true);
		nokiaOne.call("097-999-66-55");
		nokiaOne.call("094-666-44-78");
		
		samsungTwo.setOn(true);
		samsungTwo.call("097-999-66-55");
		nokiaOne.call("094-666-44-78");
		nokiaOne.call("911");
				
		samsungTwo.setOn(false);
		nokiaOne.setOn(false);
		
		//System.out.println(kyivCell);

	}

}
