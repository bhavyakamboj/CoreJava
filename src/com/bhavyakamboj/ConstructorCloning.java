import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorCloning {

	private String name;
	ConstructorCloning(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructorCloning cc1 = new ConstructorCloning("original");
		System.out.println("Original object: "+ cc1.getName());
		
		try {
			//Class.getDeclaredConstructor(String.class).newInstance("HERESMYARG");
//TODO
			ConstructorCloning cc2 = cc1.getClass().getDeclaredConstructor(ConstructorCloning.class).newInstance("bhavya");
			System.out.println("Cloned object:"+cc2.getName());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
