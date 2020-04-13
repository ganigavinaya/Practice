package practice;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

	public int[] dailyTemperatures(int[] temperatures) {

		if(temperatures.length==0)
			return new int[]{};

		int[] stack = new int[temperatures.length];
		stack[0] = 0;

		int top = 0;

		for(int i=1;i<temperatures.length;i++){
			while(top>=0 && temperatures[stack[top]] < temperatures[i]){
				temperatures[stack[top]] = i-stack[top--];
			}
			stack[++top]=i;
		}

		while(top>=0){
			temperatures[stack[top--]] = 0;
		}

		return temperatures;
	}

	public static void main(String[] args) {

		DailyTemperature dt = new DailyTemperature();
		System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
	}
}

//73, 74, 75, 71, 69, 72, 76, 73
//	int [] stack=new int[temp.length];
//	int top = -1;
//	int [] res = new int[temp.length];
//  for(int i = 0; i < temp.length;i++){
//		while(top != -1 && temp[i] > temp[stack[top]]){
//			int index = stack [top--];
//			res[index] = i-index;
//		}
//		stack[++top]=i;
//	}
//	return res;