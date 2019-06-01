package solution39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {
    public int moreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!resultMap.containsKey(array[i])) {
                resultMap.put(array[i], 1);
            } else {
                resultMap.put(array[i], resultMap.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                //          System.out.println(entry.getValue());
                result = entry.getKey();
            }
        }
//        System.out.println(resultMap);
//        System.out.println(result);
        return result;
    }
}
