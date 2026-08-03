package me.eldodebug.soar.utils;

import java.util.Random;

public class RandomUtils {

	private static final Random RANDOM = new Random();

	public static int getRandomInt(int min, int max) {
		return min + RANDOM.nextInt(max - min + 1);
	}
	
	public static long getRandomLong(int min, int max) {
		return min + (long)RANDOM.nextInt(max - min + 1);
	}
}
