public class Exercise_2 {

    public static void main(String[] args) {
        int age = calculateAge(1997, 2026);
        System.out.println("La edad calculada es: " + age);

    }

    public static int calculateAge(int birthYear, int currentYear) {
        int age = currentYear - birthYear;
        return age;
    }
}
