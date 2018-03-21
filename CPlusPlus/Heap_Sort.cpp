#include <iostream>
using namespace std;
void swap(int *x, int *y){
	int z=*x;
	*x=*y;
	*y=z;
}
class Heap{
	int* arr;
	int current_size;
	int capacity;
public:
	Heap(){
		current_size=0;
	}
	Heap(int size){
		current_size=0;
		arr=new int[size];
		capacity=size;
	}
	int parent(int child){ return (child-1)/2; }
	int leftchild(int child){ return ((2*child)+1); }
	int rightchild(int child){ return ((2*child)+2); }
	void insert(int num){
		if(current_size>capacity-1){
			return;
		}
		arr[current_size]=num;
		current_size++;
		for(int i=current_size-1;i!=0 && arr[i]<=arr[parent(i)];i=parent(i)){
			swap(arr[i],arr[parent(i)]);
		}
	}
	void display(){
		for(int i=capacity-1;i>=0;i--){
			cout<<arr[i]<<" ";
		}
		cout<<endl;
	}
	void remove(int pos){
		current_size--;
		swap(arr[current_size],arr[pos]);
		
		for(int i=pos;i<current_size;){
			if(leftchild(i)>=current_size)
				return;
			else if(rightchild(i)>=current_size){
				if(arr[leftchild(i)]<arr[i]){
					swap(arr[leftchild(i)],arr[i]);
					i=leftchild(i);
				}
				return;
			}
			if(arr[i]<arr[leftchild(i)] && arr[i]<arr[rightchild(i)])
				break;
			else if(arr[leftchild(i)]<arr[rightchild(i)]){
				swap(arr[leftchild(i)],arr[i]);
				i=leftchild(i);
			}
			else{
				swap(arr[rightchild(i)],arr[i]);
				i=rightchild(i);
			}
		}
	}
};

int main(){
	int num;
	cout<<"Enter total number.->";
	cin>>num;
	Heap h(num);
	cout<<"Enter "<<num<<" numbers."<<endl;
	for(int i=0;i<num;i++){
		int temp;
		cin>>temp;
		h.insert(temp);
	}
	for(int i=0;i<num;i++){
		h.remove(0);
	}
	cout<<"Sorted list is below:->"<<endl;
	h.display();
}