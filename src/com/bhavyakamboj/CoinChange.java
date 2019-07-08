import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CoinChange {
	public static int amount = 5000;
	public static final int[] denoms =  {200,100,50,20,10,5,2,1};
	public static final int[] maxCoins;
	static {
		maxCoins = new int[denoms.length];
		
		for(int i=0; i<denoms.length; i++)
			maxCoins[i] = amount / denoms[i];
	}
	public static int findCoins(int amount, int i) {
		if(i>=denoms.length) {
			// no combination
			return 0;
		}
		
		if(maxCoins[i]==0) {
			findCoins(amount,i+1);
		}
		if(amount < denoms[i]) {
			findCoins(amount, i+1);
		}
		if(amount == 0) {
			return 1;
		}
		if(amount <0) {
			return 0;
		}
		
		return findCoins(amount-denoms[i],i) + findCoins(amount,i+1);
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(denoms) + " " + Arrays.toString(maxCoins));
		long t1 = System.currentTimeMillis();
		int result = findCoins(amount,0);
		long t2 = System.currentTimeMillis();
		System.out.println("Time taken " + (t2-t1) + " ms");
	}

}
