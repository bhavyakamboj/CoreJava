package staticclass;

class Elephant {
	   private static int count;
	   static {
		   count++;
		   count++;
	   }
	   public Elephant() { 
	   count++;
	   }   
	   public static int getCount() { 
	    return count;
	} 
}

public class StaticDriverProgram {
	public static void main(String[] args) {
		int count = Elephant.getCount();
		System.out.println(count);
	}
}