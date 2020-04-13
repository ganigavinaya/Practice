package practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	List<String> ans;
	
	public List<String> generateParenthesis(int n) {
		ans = new ArrayList<>();
        backtrack("", 0, 0, n);
        return ans;
    }

    public void backtrack(String cur, int open, int close, int max){
		if (open == max) {
			while(close < max) {
				cur += ")";
				close++;
			}
			ans.add(cur);
			return;
		}
		backtrack(cur + "(", open + 1, close, max);
        if (close < open) {
            backtrack(cur+")", open, close+1, max);
        }
            
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp = new GenerateParenthesis();
		List<String> list = gp.generateParenthesis(3);
		
		for(String s:list) {
			System.out.println(s);
		}
	}

}
