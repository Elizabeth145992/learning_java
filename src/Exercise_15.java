public class Exercise_15 {
    public static void testFinally() {
        try {
            System.out.println("Dentro del try");
            throw new RuntimeException("Algo salió mal");
        } catch (RuntimeException e) {
            System.out.println("Dentro del catch");
        } finally {
            System.out.println("Dentro del finally");
        }
    }

    public static void main(String[] args) {
        testFinally();
    }
}
