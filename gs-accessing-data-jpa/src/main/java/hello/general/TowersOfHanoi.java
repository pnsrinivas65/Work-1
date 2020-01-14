package hello.general;

public class TowersOfHanoi {
	
	public static void main(String s[]) {
		
		TowersOfHanoi toh = new TowersOfHanoi();
		toh.move(3, 'A', 'C', 'B');
	}
	
	public void move(int nofDiscs, char from, char to, char inter) {
		
		if(nofDiscs >0) {
			move(nofDiscs-1, from, inter, to);
		
			System.out.println("Moving disc "+nofDiscs+" from "+ from+" to "+to);
		
			move(nofDiscs-1, inter, to, from);
		}
		
		
	}

}
