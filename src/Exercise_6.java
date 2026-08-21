public class Exercise_6 {

    public static void main(String[] args) {
        int numbers = 5;
        int sum = sumNumbers(numbers);
        System.out.println("La suma de los números del 1 al " + numbers + " es: " + sum);
    }

    public static int sumNumbers(int numbers) {
        int sum = 0;

        for (int i= 1; i <= numbers; i++) {
            sum += i;
        }
        return sum;
    }
}