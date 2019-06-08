package solution65;

public class Add {
    public int add(int num1,int num2) {
        int temp=0;
        if (num2 == 0) {
            return num1;
        }
        while (num2 != 0) {
            temp = num1 ^ num2;
            num2 = (num1 & num2)<<1;
            num1 = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(3, 15));
    }
}
