package innerclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair{
	private int val1;
	private int val2;
	public Pair(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}
	public int getVal1() {
		return this.val1;
	}
	public int getVal2() {
		return this.val2;
	}
	@Override
	public String toString() {
		return "Pair <" + this.val1 + "," + this.val2 + ">";
	}
}

interface PairOperationInterface {
	Pair executeOperation();
}

abstract class PairOperation {
	public Pair operate(PairOperationInterface obj) {
		return obj.executeOperation();
	}
}

class PairOperationImpl extends PairOperation{
	int[] arr = {1,2,3,4,5,7545,-53427985,-25215,5232};
	public Pair checkPairs(PairOperationInterface obj) {
		return super.operate(obj);
	}
}
public class PairInnerClassDemo {

	public static void main(String[] args) {
		PairOperationImpl poi = new PairOperationImpl();
		Pair result = poi.checkPairs(new PairOperationInterface() {

			@Override
			public Pair executeOperation() {
				Integer min = Integer.MAX_VALUE;
				Integer max = Integer.MIN_VALUE;
				for(Integer ele: poi.arr) {
					if(ele>max)
						max = ele;
					if(ele<min)
						min = ele;
				}
				return new Pair(min,max);	
			}
		});
		System.out.println(result);
	}
}