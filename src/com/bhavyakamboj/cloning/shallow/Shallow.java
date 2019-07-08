package cloning.shallow;
import java.util.Arrays;

public class Shallow {
	private int[] data;
	public Shallow(int[] values) {
		this.data = values;
	}
	public void showData() {
		System.out.println(Arrays.toString(data));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myVals = {1,2,3};
		Shallow sh = new Shallow(myVals);
		sh.showData();
		myVals[0] = -1;
		sh.showData();
	}

}
