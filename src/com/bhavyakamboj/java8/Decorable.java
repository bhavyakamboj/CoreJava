package java8;

@FunctionalInterface
public interface Decorable {
	void decorateWithPaint(int num);
	
	default void decorateWithCurtains() {
		System.out.println("Using curtains");
	}
	
	public static void printHello() {
		System.out.println("Hello everyone");
	}
	
	@Override
	public String toString();
	@Override
	public int hashCode();
}

