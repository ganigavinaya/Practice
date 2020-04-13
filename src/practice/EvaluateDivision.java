package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class EvaluateDivision {


	HashMap<String,HashMap<String,Double>> map = new HashMap<>();
	Set<String> visited;
	void createDependency(String[][] equations,double[] values) {
		for(int i=0;i<equations.length;i++) {
			HashMap<String,Double> connections = map.get(equations[i][0]);
			
			if(connections==null) {
				connections = new HashMap<>();
				map.put(equations[i][0], connections);
			}
			connections.put(equations[i][1], values[i]);
			
			connections = map.get(equations[i][1]);
			if(connections==null) {
				connections = new HashMap<>();
				map.put(equations[i][1], connections);
			}
			connections.put(equations[i][0], 1.0/values[i]);
			
		}
	}
	
	Double getValueRec(HashMap<String,Double> connection,String variable) {
		Double result = connection.get(variable);
		if(result!=null) {
			return result;
		}
		for(Entry<String, Double> e:connection.entrySet()) {
			String key = e.getKey();
			if(!visited.contains(key) ) {
				visited.add(key);
				result = getValueRec( map.get( key ), variable);
				if(result!=-1.0) {
					return result*e.getValue();
				}
			}
			
		}
		return -1.0;
		
	}
	
	void evaluateEquation(String[][] queries,double[] result) {
		
		for(int i=0;i<queries.length;i++) {
			HashMap<String,Double> v1 = map.get(queries[i][0]);
			HashMap<String,Double> v2 = map.get(queries[i][1]);
			if(v1==null || v2==null) {
				result[i]=-1;
			}
			else {
				visited = new HashSet<>();
				visited.add(queries[i][0]);
				result[i] = getValueRec(v1,queries[i][1]);
			}			
		}
	}
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        createDependency(equations,values);
        evaluateEquation(queries,result);
        return result;
    }

	public static void main(String[] args) {
		EvaluateDivision ed = new EvaluateDivision();
		double[] result = ed.calcEquation(
//				new String[][]{{"a","b"},{"b","c"},{"c","d"},{"d","e"}}, 
//				new double[]{2.0,3.0,4.0,5.0}, 
//				new String[][]{{"a","e"}});
				new String[][]{{"a","b"},{"b","c"}}, 
				new double[]{2.0,3.0}, 
				new String[][]{{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}});
		System.out.println(Arrays.toString(result));

	}

}
