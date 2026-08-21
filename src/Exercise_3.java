public class Exercise_3 {
    public static void main(String[] args) {
        boolean adultStatus = isAdult(20);
        String status = adultStatus ? "SI" : "NO";
        System.out.println("La persona es adulta: " + status);
    }
    
    public static boolean isAdult(int age) {
         if (age >= 18) {
            return true;
         }
         return false;
    }
}
