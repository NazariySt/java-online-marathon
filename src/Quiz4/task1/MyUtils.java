package Quiz4.task1;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.util.*;

public class MyUtils {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("0967654321", "Petro");
        testMap.put("0677654321", "Petro");
        testMap.put("0501234567", "Ivan");
        testMap.put("0970011223", "Stepan");
        testMap.put("0631234567", "Ivan");

        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.createNotebook(testMap));

    }

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> resultMap = new HashMap<>();
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (!resultMap.containsKey(entry.getValue())) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                resultMap.put(entry.getValue(), list);
            } else {
                resultMap.get(entry.getValue()).add(entry.getKey());
            }
        }

        return resultMap;
    }
}
