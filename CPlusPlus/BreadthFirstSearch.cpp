#include <iostream>
#include <list>
using namespace std;
class Graph{
	int v;
	list<int> *adj;
public:
	Graph(int v){
		this->v=v;
		adj=new list<int>[v];
	}
	void addEdge(int v1,int v2);
	void BFS(int s);
};
void Graph :: addEdge(int v1,int v2){
	adj[v1].push_back(v2);
}
void Graph :: BFS(int s){
	bool visited[v];
	for(int i=0;i<v;i++)
		visited[i]=false;
	list<int> queue;
	queue.push_back(s);
	visited[s]=true;
	
	while(!queue.empty()){
		s=queue.front();
		cout<<s<<" ";
		queue.pop_front();
		//int length=adj[s].size();
		//cout<<"Length "<<length;
		
		for(list<int>::iterator i=adj[s].begin();i!=adj[s].end();i++){
			if(visited[*i]==0){
				visited[*i]=1;
				queue.push_back(*i);
			}
		}
	}
}
int main(){
	int num_ver, num_edges;
	cout<<"Enter the number of vertices.->";
	cin>>num_ver;
	Graph g(num_ver);
	cout<<"Enter the number of edges->";
	cin>>num_edges;
	cout<<"Enter all edges one by one."<<endl;
	cout<<"Vertices are from 0 to "<<num_ver-1<<endl;
	for(int i=0;i<num_edges;i++){
		int v, w;
		cin>>v>>w;
		g.addEdge(v,w);
	}
	int s;
	cout<<"Enter the source vertex.->";
	cin>>s;
	g.BFS(s);
	return 0;
}
