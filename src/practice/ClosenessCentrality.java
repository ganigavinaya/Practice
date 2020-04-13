package practice;

import java.util.HashMap;
import java.util.Scanner;

public class ClosenessCentrality {

	class Node{
		int val;
		HashMap<Integer,Integer> adjList = new HashMap<>();

		Node(int v){
			val = v;
		}
	}

	HashMap<Integer,Node> nodes= new HashMap<>();

	int getDistance(Node n1, Node target){
		if(n1.adjList.containsKey(target.val)){
			return n1.adjList.get(target.val);
		}

		int min = Integer.MAX_VALUE;

		for(Integer n:n1.adjList.keySet()){
			min = Math.min(min,getDistance(nodes.get(n),target)+1);
		}

		n1.adjList.put(target.val,min);
		return min;
	}

	float calculateCentrality(){
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		for(int i=0;i<N;i++){
			int n = in.nextInt();
			nodes.put(n,new Node(n));
		}

		Node target = nodes.get(in.nextInt());

		int edges = in.nextInt();

		for(int i=0;i<edges;i++){
			Node n1 =  nodes.get(in.nextInt());
			Node n2 =  nodes.get(in.nextInt());

			n1.adjList.put(n2.val,1);
			n2.adjList.put(n1.val,1);
		}

		int total = 0;
		for(Integer n:nodes.keySet()){
			if(target.val==n)
				continue;
			if(!target.adjList.containsKey(n))
				total+=getDistance(nodes.get(n),target);
			else
				total+=target.adjList.get(n);
		}

		return ((N-1)/(float)total);
	}

	public static void main(String[] args) {
		ClosenessCentrality cc = new ClosenessCentrality();

		System.out.println(cc.calculateCentrality());
	}
}
