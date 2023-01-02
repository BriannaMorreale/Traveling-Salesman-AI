
public class TMp {

	public static void main(String [] args) {
		
		for(int i=100; i > 0; i--) {
			int randomNumber = (int)(Math.random()*100);
			if(i > randomNumber ) {
				System.out.println(i);
			}
		}
		
	}
}
