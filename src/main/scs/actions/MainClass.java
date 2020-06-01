package main.scs.actions;

public class MainClass
{

	public static void main(String[] args)
	{
		String input = "1";
		char[] array = input.toCharArray();
		int[] myArray = new int[array.length];

		for (int i = 0; i < array.length; i++)
		{
			char character = array[i];
			int ascii = (int) character;
			myArray[i] = ascii;

		}
	}

}
