package practice;

import java.util.ArrayList;

public class GetMagicNumber {


	static boolean recArithmeticBoggle(int magicNum, int[] list,int start){
		int curr = list[start];
		if(start==list.length-1){
			return curr==magicNum || curr+magicNum==0;
		}
		else{
			boolean subtract = recArithmeticBoggle(magicNum-curr,list,start+1);
			if(!subtract)
				return recArithmeticBoggle(magicNum+curr,list,start+1);

			return true;
		}
	}

	public static boolean arithmeticBoggle(int magicNumber, int[] numbers) {
		if(numbers.length==0){
			if(magicNumber==0)
				return true;
			else return false;
		}
		else if(numbers.length==1){
			if(numbers[0]==magicNumber)
				return true;
			else return false;
		}
		return recArithmeticBoggle(magicNumber,numbers,0);
	}


	public static void main(String[] args) {
		System.out.println(GetMagicNumber.arithmeticBoggle(2,new int[]{1,2,4,3}));
	}
}

