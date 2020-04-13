package JavaPractice;

import java.util.*;

public class IteratorPractice {

	class Node{
		int val;

		Node(int val){
			this.val = val;
		}
	}

	Node[] n = new Node[10];
	int index=0;

	int lastInd = n.length-1;


	Iterator<Node> createNodeArray(){

		for(int i=0;i<n.length;i++){
			n[i]= new Node(i+10);
		}


		Iterator<Node> it = new Iterator<Node>() {
			@Override
			public boolean hasNext() {
				return index<n.length;
			}

			@Override
			public Node next() {
				Node temp =  n[index];
				index+=1;
				return temp;
			}
		};

		Iterator<Node> Descit = new Iterator<Node>() {
			@Override
			public boolean hasNext() {
				return lastInd>=0;
			}

			@Override
			public Node next() {
				Node temp =  n[lastInd];
				lastInd-=1;
				return temp;
			}
		};


		return it;

	}

	public static void main(String[] args) {
//		IteratorPractice it = new IteratorPractice();
//
//		Iterator<Node> iterator  = it.createNodeArray();
//
//		while(iterator.hasNext()){
//			System.out.println(iterator.next().val);
//		}


		LinkedList<Integer> list = new LinkedList<>();

		for(int i=0;i<10;i++){
			list.add(i+1);
		}

		for(Integer x:list){
			System.out.println(x);
		}


		System.out.println("descending iterator");

		Iterator<Integer> descIt = list.descendingIterator();

		while(descIt.hasNext()){
			System.out.println(descIt.next());
		}


	}

}
