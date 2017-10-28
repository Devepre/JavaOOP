package lection05.task01;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi there. Let's start copying...");

		String pathFolderOrig = "/home/devepr/Documents/TiJ4/";
		String pathFolderDest = "/home/devepr/Videos/";

		File directoryOrig = new File(pathFolderOrig);
		File directoryDest = new File(pathFolderDest);

		CustomFileFilter cff = new CustomFileFilter("py", "txt");

		FileHandler fHandler = new FileHandler();
		try {
			fHandler.copyDirectory(directoryOrig, directoryDest, cff);
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done!");

	}

}
