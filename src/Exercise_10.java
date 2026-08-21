import java.util.ArrayList;

public class Exercise_10 {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Elizabeth");
        names.add("Ana");
        names.add("Uriel");

        String nameToFind = "Uriel";
        String found = findName(names, nameToFind) ? "sí" : "no";
        System.out.println("El nombre " + nameToFind + " fue encontrado: " + found);
    }
    
    public static boolean findName(ArrayList<String>names, String name) {
        for (String value: names) {
            if(value.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
