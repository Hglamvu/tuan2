import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class demo2 {
    public static void main(String args[]){
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("J", "Java");
        map.put("C", "C++");
        map.put("P", "PHP");
        map.put("Py", "Python");

        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()){
            System.out.println(map.get(itr.next()));
        }
    }
}
