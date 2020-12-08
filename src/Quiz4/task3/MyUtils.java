package Quiz4.task3;

import java.util.*;

public class MyUtils {


    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        boolean result = true;

        for (String ourMap : map.values()) {
            if (list.contains(ourMap)) {
                continue;
            } else {
                result = false;
            }
        }
        return result;
    }

public static void main(String[]args){
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        Map<String, String> map=new HashMap<>();
        map.put("1","aa");
        map.put("2","aa");
        map.put("3","bb");
        map.put("4","bb");
        MyUtils myUtils=new MyUtils();
        System.out.println(myUtils.listMapCompare(list,map));
        }

        }
