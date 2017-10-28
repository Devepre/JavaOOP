package lection05.task01;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi there. Let's start copying...");

		String pathFolderOrig = "G:\\Temp";
		String pathFolderDest = "E:\\temp\\Exp";

		File directoryOrig = new File(pathFolderOrig);
		File directoryDest = new File(pathFolderDest);

		CustomFileFilter cff = new CustomFileFilter("doc", "txt");

		FileHandler fHandler = new FileHandler();
		try {
			fHandler.copyDirectory(directoryOrig, directoryDest, cff);
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done!");

	}

}
