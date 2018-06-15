import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class PickPeaks {
    
    public static Map<String, List<Integer>>  getPeaks(int[] arr) {
        Map <String, List<Integer>> peakMap = new HashMap <String, List<Integer>>();
        List<Integer> peakList = new ArrayList<>();
        List<Integer> posList = new ArrayList<>();
    
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                posList.add(i);
                peakList.add(arr[i]);
            }
        }

        peakMap.put("pos", posList);
        peakMap.put("peaks", peakList);

        return peakMap;
    }
    
    public static void main(String[] args) {

       // test
       int[] arr = {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3}; 

       Map <String, List<Integer>> mp = getPeaks(arr);
        
       for (String s: mp.keySet()) {
           System.out.println(s + " = " + Arrays.toString(mp.get(s).toArray()));
       }        
    }

}

