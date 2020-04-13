package JavaPractice;

import java.util.*;

public class ArrayListPractice {

//	class Node{
//		int i_val;
//		float f_val;
//
//		public Node(int i_val, float f_val) {
//			this.i_val = i_val;
//			this.f_val = f_val;
//		}
//
//		Node(int i){
//			i_val = i;
//			f_val = 20;
//		}
//
//		public String toString(){
//			return i_val+" "+Float.toString(f_val);
//		}
//	}
//
//	Node[] n_arr = new Node[10];
//
//	ArrayListPractice(){
//		for(int i=0;i<n_arr.length;i++){
//			n_arr[i] = new Node(i);
//		}
//	}

//	void iterateNode(){
//
//		for(Node n:n_arr){
//			System.out.println(n);
//		}
//	}



	public static void main(String[] args) {
//		ArrayListPractice ap = new ArrayListPractice();
//		ap.iterateNode();

		Integer[] i_arr = new Integer[]{10,9,5,6,3,1,8,7};

		List<Integer> arr = Arrays.asList(i_arr);
	}
}