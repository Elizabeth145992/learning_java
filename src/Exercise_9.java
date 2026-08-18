import java.util.ArrayList;

public class Exercise_9 {
    
    public static void main(String[] args) {
        String[] namesArray = {"Elizabeth", "Ana", "Carlos", "Uriel", "María"};
        ArrayList<String> names = new ArrayList<>();

        for (String name : namesArray) {
            names = addNames(name, names);
        }

        printNames(names);
    }

    public static ArrayList<String> addNames(String name, ArrayList<String> names) {
        names.add(name);
        return names;
    }

    public static void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
