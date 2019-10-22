import java.util.Random;

public class Report3 {

	private static final int N = 100;
	private static int[] sort = new int[N];
	private static boolean PRINT = true; // 大きなNで実行する際はfalseにする
	private static boolean CHECK = true;
	
	public static void xxxSort () {
		// ソートの処理を追加する
	}
	
	public static void main(String[] args) {
		int j, t;
		Random random = new Random ();
		for (int i=0; i<N; ++i) {
			sort[i] = i + 1;
		}
		// Fisher-Yatesアルゴリズムで1~Nのランダムな数列を構築する
		for (int i=N-1; 0<i; --i) {
			j = random.nextInt (i+1);
			t = sort[i];
			sort[i] = sort[j];
			sort[j] = t;
		}
		if (PRINT) {
			for (int i=0; i<N; ++i) {
				System.out.print(sort[i] + " ");
			}
			System.out.print("\n");
		}		
		System.out.print("Sort start...");
		long start = System.nanoTime();
		xxxSort();   // ソートを行う関数の呼び出し
		long stop = System.nanoTime();
		System.out.println ("Sort end.");
		if (PRINT) {
			for (int i=0; i<N; ++i) {
				System.out.print(sort[i] + " ");
			}
			System.out.print("\n");
		}
		if (CHECK) {
			for (int i=0; i<N-1; i++) {
				if (sort[i] > sort[i+1]) {
					System.out.println ("*** Not sorted ***");
					break;
				}
			}
		}
		System.out.println("Elapsed time: " + (stop - start)/1000000 + " mili sec.");
	}

}
