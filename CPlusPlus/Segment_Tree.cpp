#include <list>
#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iomanip>
//main definations
#define endl "\n"
#define UI unsigned int
#define LLI long long int
#define ULLI unsigned long long int
#define PI 3.14159258
 
//codechef only
#define TC for(UI defined_i=1;defined_i<=t;defined_i++)
//int b_s(int arr[], int n, int find);
using namespace std;	
class SegmentTree{
	int *arr; //pointer to initial array
	int *st; // pointer to segment tree(st)
	int sizeofarray; // size of initial array
	int max_size; // maximum size of segment tree
public:
	SegmentTree(){
		arr=NULL;
		st=NULL;
		sizeofarray=0;
		max_size=0;
	}
	SegmentTree(int size){
		//arr=new int[size];
		sizeofarray=size;
		arr=NULL;
		st=NULL;
	}
	getArray(int* a){
		arr=a;
	}
	int getMid(int s, int e){ return s + (e -s)/2;	}
	int constructsUtil(int arr[], int ss, int se, int *st, int si){
		if(ss==se){
			st[si]=arr[ss];
			return arr[ss];
		}
		int mid=getMid(ss,se);
		st[si]=constructsUtil(arr, ss, mid, st, si*2+1)+constructsUtil(arr, mid+1, se, st, si*2+2);
		return st[si];
	}
	int* constructST(){
		max_size=(int)ceil(log2(sizeofarray))+1;
		max_size=pow(2,max_size)-1;
		st=new int[max_size];
		constructsUtil(arr, 0, sizeofarray-1, st, 0);
		return st;
	}
	void display(){
		for(int i=0;i<max_size;i++){
			cout<<st[i]<<" ";
		}
	}
};
int main(){
	SegmentTree s(6);
	int arr[]={1,3,5,7,9,11};
	s.getArray(arr);
	s.constructST();
	s.display();
}