public class Exercise_13 {
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad es menor a 0.");
        }
    }

    public static void registerUser(int age) throws IllegalArgumentException {
        validateAge(age);
    }

    public static void main(String[] args) {
        try {
            registerUser(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
