package solution3;

public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null){
            return false;
        }
        for(int i = 0;i<length;i++){
            while (numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }


        }
        return false;
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
