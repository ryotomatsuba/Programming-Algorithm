import java.util.Random;

public class Report3 {

	private static final int N = 100;
	private static int[] sort = new int[N];
	private static boolean PRINT = true; // 大きなNで実行する際はfalseにする
	private static boolean CHECK = true;
	
	
	public static void  bubbleSort () {
		// バブルソートの処理を追加する
		for(int i=0;i<(sort.length-1);++i){
			for(int j=0;j<sort.length-1;++j){
				if(sort[j]>sort[j+1]){
					int hoge=sort[j];
					sort[j]=sort[j+1];
					sort[j+1]=hoge;
				}
			}
		}
	}

	public static void heapSort(){
		//ヒープ構築の処理
		int i=0;
		while(i<sort.length){
			upHeap(i);
			i++;
		}

		//ヒープから最大値を取り出し
		while(i>1){
			i--;
			hoge = sort[0];
			sort[0] = sort[i];
			sort[i] = hoge;
			//ヒープの再構成
        	downheap(i-1);
		}
	}

	public static void upHeap(int n){
		while(n!=0){
			int parent = (int)((n-1)/2);
			if(sort[n]>sort[parent]){
				//親より大きな値の場合親子の値を交換
				hoge = sort[n];
				sort[n] = sort[parent];
				sort[parent] = hoge;
				n = parent;
			}
		}
	}
	public static void downHeap(int n){
		if( n == 0){return;}
    	int parent = 0;
    	while (True){
			int child = 2 * parent + 1; //sort[n]の子要素
			if (child > n){
				break;
			}
			if ((child < n)&& (sort[child] < sort[child + 1])){
				child++;
				if( sort[parent] < sort[child]){//子要素より小さい場合スワップ
				tmp = sort[child];
				sort[child] = sort[parent];
				sort[parent] = tmp;
				parent = child;//交換後のインデックスを保持
				}else{
					break;
				}
			}
		}
        
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
			t = sort[i];//i番目とj番目入れ替える
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
		heapSort();   // ソートを行う関数の呼び出し
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
