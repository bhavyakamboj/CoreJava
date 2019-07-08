package innerclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import innerclass.StaticPairOperationImpl.Pair1;

interface PairOperationInterface1 {
	Pair1 executeOperation();
}

abstract class PairOperation1 {
	public Pair1 operate(PairOperationInterface1 obj) {
		return obj.executeOperation();
	}
}

class StaticPairOperationImpl extends PairOperation1{
	int[] arr = {1,2,3,4,5,7545,-53427985,-25215,5232};
	public Pair1 checkPairs(PairOperationInterface1 obj) {
		return super.operate(obj);
	}
	static class Pair1{
		private int val1;
		private int val2;
		public Pair1(int val1, int val2) {
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
}

public class PairStaticInnerClassDemo {

	public static void main(String[] args) {
		StaticPairOperationImpl spoi = new StaticPairOperationImpl();
		StaticPairOperationImpl.Pair1 result = spoi.checkPairs(new PairOperationInterface1() {

			@Override
			public Pair1 executeOperation() {
				Integer min = Integer.MAX_VALUE;
				Integer max = Integer.MIN_VALUE;
				for(Integer ele: spoi.arr) {
					if(ele>max)
						max = ele;
					if(ele<min)
						min = ele;
				}
				return new Pair1(min,max);	
			}
		});
		System.out.println(result);
	}
}