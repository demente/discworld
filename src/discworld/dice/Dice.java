package discworld.dice;

public class Dice {

	public static int roll(){
		return (int) (Math.random()*12+1);
	}
	
}
