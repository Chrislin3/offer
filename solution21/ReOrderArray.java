package solution21;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int len = array.length;
        int[] result = new int[len];

        int jihsuNum = 0;

        for(int value : array){
            if(value % 2 != 0){
                jihsuNum ++;
            }
        }
        int jishuPoint = 0;
        int oushuPoint = jihsuNum;
        for(int value : array){
            if(value % 2 == 0){
                result[oushuPoint++] = value;
            }
            else {
                result[jishuPoint++] = value;
            }
        }
        int index = 0;
        for(int value : result){
            array[index++] = value;
        }

    }
}
