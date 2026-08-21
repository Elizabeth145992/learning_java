public class Exercise_4 {
    
    public static void main(String[] args) {
        int largestNumber = getLargest(10, 25, 8);
        System.out.println("El número más grande es: " + largestNumber);
    }

    public static int getLargest(int num1, int num2, int num3) {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }
}
