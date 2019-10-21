import java.io.BufferedReader;

public class Report2 {

public static void main(String[] args) {
  Node firstNode = null; //始めのノードの最初の定義
  Node lastNode = null; //終わりのノードの最初の定義
  int buf1, buf2; //buf1は数字の追加に、buf2は削除に使う
  do {
   System.out.print("整数を入力してください (0を入力で終了) :");
    buf1 = intReader ();
    Node newNode = new Node(buf1); //入力した値をノードに追加する
    newNode.next = null;
   if(buf1 !=0) {
    if (lastNode != null) {
     lastNode.next = newNode;
     newNode.prev = lastNode;
     lastNode = newNode; //lastとnewを同じにしnewに記憶する
    } else {
     firstNode = lastNode = newNode; //一番初めの時は3つのノードは全て同じ
     newNode.prev = null;
    }
   }
  } while(buf1 != 0);

  do {
   System.out.print("削除したい整数を入力してください (0を入力で終了) :");
   buf2 = intReader ();
   Node node = firstNode;
   firstNode = remove(buf2, node); //removeメソッドを利用する
   
  } while(buf2 != 0);

  System.out.println ("--残った整数はこちらです--");
  for (Node node = firstNode; node != null; node = node.next) {
   System.out.print(node.data + " ");
   System.out.println();
  }
 }

 public static Node remove(int p, Node q){
    Node tansa = q; //buf1で作ったノードを呼び出す
    int sakuzyo; //削除する数字
 do{
    sakuzyo = p; //buf2で入力した数字を呼び出す
    while(sakuzyo != 0){
    if(q != null){
        if(sakuzyo == q.data){
        //tansa.next.prev = null;//ここがだめ！！！！
        tansa.next.prev=tansa.prev;
        //tansa = tansa.next;//だめ
        tansa.prev.next=tansa.next;
        System.out.println(+ sakuzyo + "をリストから削除しました");
        System.out.println("!");
        return tansa;
    }else{ 
        while(tansa.next.data != sakuzyo){
            tansa = tansa.next; //次の物に移る
            if(tansa.next == null){ //最後の値まで削除したい数字が無かった時
                System.out.println (+ sakuzyo + "はリスト上に存在しません");
                return tansa;
            }
        }
    Node crnt = tansa.next;
    crnt.prev.next = crnt.next; //ポインタを1つ飛ばすことで削除
    System.out.println(+ sakuzyo + "をリストから削除しました");
    return tansa;
    }   
}
}
} while(sakuzyo != 0);
return tansa;
}


private static int intReader () { //入力した値を読み取るメソッド
try {
BufferedReader read = 
    new BufferedReader (new java.io.InputStreamReader (System.in));
String str = read.readLine();
return Integer.parseInt(str);
} catch (Exception e) {
System.err.println ("エラーが発生しました");
return 0;
}
}
}



