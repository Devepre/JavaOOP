package lection01.task01;

import java.util.Arrays;
import java.util.Random;

public class Cat {
	private String name;
	private int age;
	private int lives;
	private String breed;
	private String[] words;
	private int power;
	private boolean alive;
	private Random rnd;

	public Cat(String name, int age, int lives, String breed, String[] words) {
		this();		
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.words = words;
	}

	public Cat() {
		super();
		this.lives = 7;
		this.power = 100;
		this.alive = true;
	}

	public void hitAnotherCat(Cat enemyCat) {
		if (alive && enemyCat.isAlive()) {
			rnd = new Random();
			int strength = rnd.nextInt(20) + 1;
			System.out.format("%s attacking %s with power %d", getDescription(), enemyCat.getDescription(), strength);
			System.out.println();
			enemyCat.receiveHit(strength);
		}
	}

	public void receiveHit(int strength) {
		if (alive) {
			rnd = new Random();
			int protection = rnd.nextInt(strength);
			System.out.format("%s attack recieved! Trying to protect. Damage is %d", getDescription(),
					strength - protection);
			System.out.println();
			power = power - strength + protection;
			checkHealth();
		}
	}

	public void checkHealth() {
		if (alive && power < 0) {
			lives--;
			power = 100;
			System.out.println(getDescription() + " ouch! I could be dead. " + getLives() + " lifes left");
		}
		if (lives <= 0) {
			System.out.println(getDescription() + " dying...");
			alive = false;
			power = 0;
		}
	}

	public String getDescription() {
		return String.format("[%s-%s]", this.getClass().getSimpleName(), name);
	}

	public void giveSound() {
		if (alive) {
			if (checkWords()) {
				rnd = new Random();
				String word = words[rnd.nextInt(words.length)];
				System.out.format("%s %s %s", getDescription(), word, System.lineSeparator());
			}
		}
	}

	private boolean checkWords() {
		return !(words == null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getLives() {
		return lives;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", lives=" + lives + ", breed=" + breed + ", words="
				+ Arrays.toString(words) + ", power=" + power + ", alive=" + alive + ", rnd=" + rnd + "]";
	}
}
