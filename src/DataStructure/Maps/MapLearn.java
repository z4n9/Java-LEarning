package DataStructure.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapLearn {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        //типа add в других коллекциях, только add добавляет в конец, а put сует по ключу
        map.put(1, "String 1");
        System.out.println(map);
        //чистит мапу
        map.clear();
        System.out.println(map);
        System.out.println();

        map.put(1, "String 1");
        System.out.println(map);
        System.out.println();

        map.put(2, "String 2");
        map.put(3, "String 3");
        map.put(4, "String 4");
        System.out.println(map);
        System.out.println();

        map.put(2, "String 5");
        System.out.println(map);
        System.out.println();

        map.put(2, "String 2");
        map.put(5, "String 5");
        System.out.println(map.get(2));
        System.out.println();
    }
}
