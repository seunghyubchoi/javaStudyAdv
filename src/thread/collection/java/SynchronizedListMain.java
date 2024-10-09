package thread.collection.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListMain {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.getClass());
        System.out.println("list = " + list);
    }
}
