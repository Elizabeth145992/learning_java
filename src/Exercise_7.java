public class Exercise_7 {

    public static void main(String[] args) {
        int[] numbers = {10, 25, 8, 40, 15};
        int largestNumber = getLargestFromArray(numbers);
        System.out.println("El número más grande del arreglo es: " + largestNumber);
    }
    
    public static int getLargestFromArray(int[] arr) {
        int largestNumber = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largestNumber) {
                largestNumber = arr[i];
            }
        }
        return largestNumber;
    }
}
