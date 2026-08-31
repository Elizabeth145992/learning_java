public class Exercise_12 {

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre 0.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            double result = divide(20, 0);
             System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}