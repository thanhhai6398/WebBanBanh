package vn.ithcmute.util;

import java.util.Random;
import java.util.UUID;

public class RandomUUID {

	public static String getRandomID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static int getRandom() {	
		Random generator = new Random();
		int value = generator.nextInt((1000 - 1) + 1) + 1;
		return value;
	}
}