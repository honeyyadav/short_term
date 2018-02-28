import java.util.Scanner;
class Node{
	int data;
	Node next;
}
class List{
	private Node start=null;
	void push_back(int num){
		if(start==null){
			Node t=new Node();
			start=t;
			t.data=num;
		}
		else{
			Node t=new Node();
			t.data=num;
			Node x=start;
			while(x.next!=null){
				x=x.next;
			}
			x.next=t;
		}
	}
	void pop_back(){
		if(start==null){
			System.out.println("Sorry list is empty.");
		}
		else{
			Node x=start;
			Node y=null;
			while(x.next!=null){
				y=x;
				x=x.next;
			}
			y.next=null;
			x=null;
		}
	}
	void push_front(int num){
		if(start==null){
			Node t=new Node();
			start=t;
			t.data=num;
		}
		else{
			Node t=new Node();
			t.data=num;
			t.next=start;
			start=t;
		}
	}
	void pop_front(){
		if(start==null){
			System.out.println("Sorry list is empty.");
		}
		else{
			Node x=start;
			start=start.next;
			x=null;
		}
	}
	void display(){
		Node x=start;
		while(x!=null){
			System.out.print(x.data+" -> ");
			x=x.next;
		}
		System.out.print("\n");
	}
	void menu(){
		System.out.println("Enter your choice.");
		System.out.println("1. Insert at back.");
		System.out.println("2. Insert at front.");
		System.out.println("3. Delete from back.");
		System.out.println("4. Delete from front.");
		System.out.println("5. Exit.");
	}
}
public class LinkedList{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		List l=new List();
		l.menu();	
		int choice=scan.nextInt();
		while(choice!=5){
			if(choice>5 || choice<1){
				System.out.println("Sorry, no such choice.Try again.");
				l.menu();
			}
			else{
				int num;
				switch(choice){
					case 1:
					num=scan.nextInt();
					l.push_back(num);l.display();break;
					case 2: 
					num=scan.nextInt();
					l.push_front(num);l.display();break;
					case 3: l.pop_back();l.display();break;
					case 4: l.pop_front();l.display();break;
				}
			}
			l.menu();
			choice=scan.nextInt();
		}
		System.out.println("Thankyou, Have a nice day.");
	}
}
