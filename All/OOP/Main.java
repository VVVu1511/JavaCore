package OOP;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer a = 5;
        a += 5;

        List < Integer > list1 = new ArrayList< Integer >();
        System.out.println(list1.hashCode());

        List < Integer > list2 = new ArrayList< Integer >();
        System.out.println(list2.hashCode());

        list1.add(5);
        list1.add(10);

        System.out.println(list1);

        Map<String,String> map = new TreeMap<>();
        map.put("Vu","TTruc");
        map.put("Vu","TVy");
        map.put("Vu","LDan");
        map.remove("Vu");
        // map.put("Vu","LDan");
        System.out.println(map.toString());
    }
}
