import java.util.Scanner;
class Node{
	int data;
	Node next;
}
public class LinkedList{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter total number.");
		int num=scan.nextInt();
		Node start=null;
		for(int i=0;i<num;i++){
			int temp=scan.nextInt();
			if(start==null){
				Node t=new Node();
				start=t;
				t.data=temp;
			}
			else{
				Node t=new Node();
				t.data=temp;
				Node abc=start;
				while(abc.next!=null){
					abc=abc.next;
				}
				abc.next=t;
			}
		}
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
		Node abc=start;
		while(abc!=null){
			System.out.print(abc.data+" -> ");
			abc=abc.next;
		}
	}
}
