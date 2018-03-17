import java.util.Scanner;
class Node{
	int data;
	Node left, right;
	public Node(){
		left=null;
		right=null;
	}
}
class BinaryTree{
	public Node root;
	public BinaryTree(){
		root=null;
	}
	void insert(Node sub, int num){
		if(root==null){
			root=new Node();
			root.data=num;
			return;
		}
		else if(num<sub.data){
			if(sub.left==null){
				Node t=new Node();
				t.data=num;
				sub.left=t;
				t=null;
				return;
			}
			insert(sub.left,num);
		}
		else{
			if(sub.right==null){
				Node t=new Node();
				t.data=num;
				sub.right=t;
				t=null;
				return;
			}
			insert(sub.right,num);
		}
	}
	boolean searchNode(Node sub, boolean flag, int num){
		if(sub==null){
			return flag;
		}
		flag=searchNode(sub.left,flag,num);
		if(sub.data==num){
			return true;
		}
		flag=searchNode(sub.right,flag,num);
		return flag;
	}
	void preOrder(Node sub){
		if(sub==null){
			return;
		}
		System.out.print(sub.data+"->");
		preOrder(sub.left);
		preOrder(sub.right);
	}
	void inOrder(Node sub){
		if(sub==null){
			return;
		}
		inOrder(sub.left);
		System.out.print(sub.data+"->");
		inOrder(sub.right);
	}
	void postOrder(Node sub){
		if(sub==null){
			return;
		}
		postOrder(sub.left);
		postOrder(sub.right);
		System.out.print(sub.data+"->");
	}
	
	void menu(){
		System.out.println("Enter your choice.");
		System.out.println("1. Insert a value in BST.");
		System.out.println("2. Search for a value.");
		System.out.println("3. Display preorder Traversal.");
		System.out.println("4. Display Inorder Traversal.");
		System.out.println("5. Display postorder Traversal.");
		System.out.println("6. Exit.");
	}
}
public class BinarySearchTree{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		BinaryTree bst=new BinaryTree();
		bst.menu();	
		int choice=scan.nextInt();
		while(choice!=6){
			if(choice>5 || choice<1){
				System.out.println("Sorry, no such choice.Try again.");
				bst.menu();
			}
			else{
				int num;
				switch(choice){
					case 1:num=scan.nextInt();bst.insert(bst.root,num);break;
					case 2:System.out.println("Enter value to search.");
					num=scan.nextInt();boolean flag=false;
					flag=bst.searchNode(bst.root,flag,num);
					if(flag)
						System.out.println("Yes "+num+" is present.");
					else
						System.out.println("No "+num+" is not present.");
					break;
					case 3:bst.preOrder(bst.root);break;
					case 4:bst.inOrder(bst.root);break;
					case 5:bst.postOrder(bst.root);break;
				}
			}
			bst.menu();
			choice=scan.nextInt();
		}
		System.out.println("Thankyou, Have a nice day.");
	}
}