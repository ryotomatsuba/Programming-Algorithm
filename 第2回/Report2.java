import java.io.BufferedReader;

public class Report2 {
	public static void main(String[] args) {
		Node firstNode = null; // 最初のノード
		Node lastNode = null;  // 最後のノード
		int buf;	
		do {
			System.out.print("整数を入力してください（0を入力すると終了）：");
			buf = intReader ();
			if (buf !=0) {
				Node newNode = new Node(buf);
				newNode.next = null;
				if (lastNode != null) { // 最初のノード以外
					//すでにあるリストの末尾に新しいノードをつなげる
					lastNode.next = newNode;
					newNode.prev = lastNode;
					lastNode = newNode;
				} else { // 最初のノードの場合
					firstNode = lastNode = newNode;
					newNode.prev = null;
				}
			}
		} while(buf != 0);


		//削除
		do {
			System.out.print ("削除する値を入力してください（0を入力すると終了） :");
			buf = intReader ();
			if (buf !=0) {
				for (Node node = firstNode; node != null; node = node.next) {
					if(node.data==buf){
						if (node.prev!=null) { // 最初のノード以外
							node.prev.next=node.next;
							node.next.prev=node.prev;
						} else { // 最初のノードの場合
							node.next.prev=null;
							firstNode=node.next;
						}
						System.out.println(buf+"は削除しました。");
						break;
					}
					if(node.next==null){
						System.out.println(buf+"は存在しません");
					}
					
				}
			}
		} while(buf != 0);


		System.out.println ("‐‐残っているのは以下の数です‐‐");
		for (Node node = firstNode; node != null; node = node.next) {
			System.out.print (node.data + " ");
		}
	}
	
	// 標準出力から整数を入力。入力された整数をint型として戻す
	private static int intReader () {
		try {
			BufferedReader read = 
					new BufferedReader (new java.io.InputStreamReader (System.in));
			String str = read.readLine();
			return Integer.parseInt(str);
		} catch (Exception e) {
			System.err.println ("エラーが起きました");
			return 0;
		}
	}
}
