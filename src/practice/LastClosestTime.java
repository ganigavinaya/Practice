package practice;

import java.util.TreeSet;

public class LastClosestTime {

	public static String lastClosestTime(String time) {
        
        int[] digit = new int[4];
        int k=0;
        
        for(char c:time.toCharArray()){            
            if(c!=':'){
                digit[k++]=Integer.parseInt(c+"");
            }
        }
        
        TreeSet<Integer> hour = new TreeSet<>();
        TreeSet<Integer> minute = new TreeSet<>();
        
        for(int i=0;i<digit.length;i++){
            for(int j=0;j<digit.length;j++){
                int temp = Integer.parseInt(""+digit[i]+digit[j]);
                if(temp<24){
                    hour.add(temp);
                    minute.add(temp);
                }
                else if(temp<60){
                    minute.add(temp);
                }  
            }
        }
        
        int minInt = digit[2]*10+digit[3];
        int hourInt = digit[0]*10+digit[1];
        
        Integer newMin = minute.floor(minInt-1);
        if(newMin!=null && newMin!=minInt) {
        	return (hourInt<10?"0"+hourInt:hourInt)+":"+(newMin<10?"0"+newMin:newMin);
        }
        
        newMin = minute.last();
        Integer newHour = hour.floor(hourInt-1);
        if(newHour!=null && newHour!=hourInt) {
        	return (newHour<10?"0"+newHour:newHour)+":"+(newMin<10?"0"+newMin:newMin);
        }
        
        newHour = hour.last();
        return (newHour<10?"0"+newHour:newHour)+":"+(newMin<10?"0"+newMin:newMin);
    }

	public static void main(String[] args) {
		System.out.println(lastClosestTime("23:23"));

	}

}
