
public class Cloning implements Cloneable {
	private String name;
	public Cloning(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	@Override 
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Cloning a = new Cloning("Bhavya");
		System.out.println(a);
		Cloning b = (Cloning) a.clone();
		System.out.println(b);
		a.setName("BobTheBuilder");
		System.out.println(a);
	}

}
