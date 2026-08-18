public class Exercise_8 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 10, 13, 20, 21};
        int currentEvenCount = countEvenNumbers(numbers);
        System.out.println("La cantidad de números pares en el arreglo es: " + currentEvenCount);
    }
    
    public static int countEvenNumbers(int [] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
