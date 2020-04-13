package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DNAAnalyzer {


	static void analyze(String[] strands, HashMap<String,String> mapping){
		//validation

		List<String> validStrands = new ArrayList<>();

		HashMap<String,Integer> first = new HashMap<>();
		HashMap<String,Integer> last = new HashMap<>();

		for(int i=0;i<strands.length;i++){
			int length = strands[i].length();
			if(length>10 && length<100){
				char[] char_arr = strands[i].toCharArray();

				boolean valid = true;
				for(char c:char_arr){
					if(c!='A' && c!='T' && c!='G' && c!='C'){
						valid = false;
					}
				}

				if(valid){
					validStrands.add(strands[i]);
					first.put(strands[i].substring(0,3),validStrands.size()-1);
					last.put(strands[i].substring(strands[i].length()-3),validStrands.size()-1);
				}
			}
		}

		if(validStrands.size()<3){
			System.out.println("empty string");
		}

		StringBuilder finalStr = new StringBuilder();

		String firstString = "";

		for(String s:first.keySet()){
			if(!last.containsKey(s)){
				firstString = validStrands.get(first.get(s));
				break;
			}
		}

		String current = firstString;

		while(true){

			Integer firstIndex = first.get(current.substring(current.length()-3));

			if(firstIndex!=null){
				finalStr.append(current);
				finalStr.append(validStrands.get(firstIndex).substring(3));
				current = validStrands.get(firstIndex);
			}
			else{
				break;
			}
		}

		HashMap<String,Integer> result = new HashMap<>();
		for(int i=0;i<finalStr.length();i+=3){
			String triplet = finalStr.substring(i,i+3);
			String amino = mapping.get(triplet);
			Integer count = result.getOrDefault(amino,0);
			result.put(amino,count+1);
		}



	}


	public static void main(String[] args) {
		HashMap<String,String> mapping = new HashMap<>();
		analyze(new String[]{"AATTGGCCAATTG","TTGAATTGGCCAAAA","AAATTTGGGCCC","AAAEEERRRTTT","NEWUSER123"},mapping);
	}
}
