package enums;

public class EnumExample1 {

	public static void main(String[] args) {
		for(Season1 s: Season1.values())
			System.out.println(s);
	}

}
enum Season1 {
	WINTER1, SUMMER1, SPRING1, FALL1
}