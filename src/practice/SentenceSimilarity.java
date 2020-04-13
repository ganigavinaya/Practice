package practice;

import java.util.HashMap;
import java.util.HashSet;

public class SentenceSimilarity {

	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length!=words2.length)
            return false;
        if(words1.length==0)
            return true;
        
        HashMap<String,HashSet<String>> map1 = new HashMap<>();
        HashMap<String,HashSet<String>> map2 = new HashMap<>();
        
        for(String[] s: pairs){
        	HashSet<String> set1 = map1.get(s[0]);
        	if(set1==null){
                set1 = new HashSet<>();
                map1.put(s[0],set1);
            }
        	set1.add(s[1]);
            HashSet<String> set2 = map2.get(s[1]);
            if(set2==null){
                set2 = new HashSet<>();
                map2.put(s[1],set2);
            }
            set2.add(s[0]);
        }
        
        for(int i=0;i<words1.length;i++){
    		if(!words1[i].equals(words2[i])) {
    			HashSet<String> set1 = map1.get(words1[i]);
    			if(set1==null || !set1.contains(words2[i])) {
    				HashSet<String> set2 = map2.get(words1[i]);
    				if(set2==null || !set2.contains(words2[i]))
    					return false;
    			}
    		}
        }
        
        
        
        return true;
        
    }
    
	public static void main(String[] args) {
		SentenceSimilarity ss = new SentenceSimilarity();
		System.out.println(ss.areSentencesSimilar(new String[] {"this","summer","thomas","get","actually","actually","rich","and","possess","the","actually","great","and","fine","vehicle","every","morning","he","drives","one","nice","car","around","one","great","city","to","have","single","super","excellent","super","as","his","brunch","but","he","only","eat","single","few","fine","food","as","some","fruits","he","wants","to","eat","an","unique","and","actually","healthy","life"},
				new String[] {"this","summer","thomas","get","very","very","rich","and","possess","the","very","fine","and","well","car","every","morning","he","drives","a","fine","car","around","unique","great","city","to","take","any","really","wonderful","fruits","as","his","breakfast","but","he","only","drink","an","few","excellent","breakfast","as","a","super","he","wants","to","drink","the","some","and","extremely","healthy","life"}, 
				new String[][]{{"good","nice"},{"good","excellent"},{"good","well"},{"good","great"},{"fine","nice"},{"fine","excellent"},{"fine","well"},{"fine","great"},{"wonderful","nice"},{"wonderful","excellent"},{"wonderful","well"},{"wonderful","great"},{"extraordinary","nice"},{"extraordinary","excellent"},{"extraordinary","well"},{"extraordinary","great"},{"one","a"},{"one","an"},{"one","unique"},{"one","any"},{"single","a"},{"single","an"},{"single","unique"},{"single","any"},{"the","a"},{"the","an"},{"the","unique"},{"the","any"},{"some","a"},{"some","an"},{"some","unique"},{"some","any"},{"car","vehicle"},{"car","automobile"},{"car","truck"},{"auto","vehicle"},{"auto","automobile"},{"auto","truck"},{"wagon","vehicle"},{"wagon","automobile"},{"wagon","truck"},{"have","take"},{"have","drink"},{"eat","take"},{"eat","drink"},{"entertain","take"},{"entertain","drink"},{"meal","lunch"},{"meal","dinner"},{"meal","breakfast"},{"meal","fruits"},{"super","lunch"},{"super","dinner"},{"super","breakfast"},{"super","fruits"},{"food","lunch"},{"food","dinner"},{"food","breakfast"},{"food","fruits"},{"brunch","lunch"},{"brunch","dinner"},{"brunch","breakfast"},{"brunch","fruits"},{"own","have"},{"own","possess"},{"keep","have"},{"keep","possess"},{"very","super"},{"very","actually"},{"really","super"},{"really","actually"},{"extremely","super"},{"extremely","actually"}}));

	}

}
