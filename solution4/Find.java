package solution4;

public class Find {
    public boolean find(int target, int [][] array) {
        if((array==null||array.length==0)||(array.length==1 && array[0].length==0)){ //
            return false;
        }
        int row = array.length;
        int col = array[0].length;

        int i = 0;
        int j = col - 1;
        while (array[i][j] != target){
            if(array[i][j] < target){
                i++;
                if(i >= row){
                    return false;
                }
            }
            else {
                j--;
                if(j < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
