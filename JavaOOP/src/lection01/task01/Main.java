package lection01.task01;

import java.util.Random;

public class Main {
	static final int PEACE = 47;

	public static void main(String[] args) {
		Cat catJack = new Cat("Jack", 3, 5, "Cornish Rex",
				new String[] { "meow", "meeo", "meooww", "hrrr-hrrr", "ffff" });
		Cat catTail = new Cat("Tail", 2, 7, "Norge", new String[] { "meow", "meeo", "meooww", "hrrr-hrrr", "arrr" });
		Random rnd = new Random();
		catJack.setPower(rnd.nextInt(50) + 50);
		catTail.setPower(rnd.nextInt(50) + 50);

		int rounds = 0;
		int peace;
		do {
			peace = rnd.nextInt(80);
			if (peace == PEACE) {
				break;
			}
			catJack.giveSound();
			catJack.hitAnotherCat(catTail);
			catTail.giveSound();
			catTail.hitAnotherCat(catJack);
			rounds++;
		} while (catJack.isAlive() && catTail.isAlive());

		if (peace != PEACE) {
			System.out.format("It took %s rounds to %s win", rounds,
					catJack.isAlive() ? catJack.getDescription() : catTail.getDescription());
			System.out.println();
		} else {
			System.out.println("Peace!");
		}

		System.out.println(catJack);
		System.out.println(catTail);
	}

}
