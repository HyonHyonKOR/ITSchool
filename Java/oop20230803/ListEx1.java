package oop20230803;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class ListEx1 {
   
     public static void main(String[] args) {
    	 Vector vec = new Vector();
    	 System.out.println(vec.size()); //요소(components)의 갯수
    	 vec.add(3);
    	 vec.add(3.14);
    	 vec.add("HAPPY");
    	 vec.add('K');
    	 vec.add(3);
    	 System.out.println(vec.size());
    	 vec.add(new Integer(5));
    	 vec.add(new Double(3.5));
    	 System.out.println(vec.size());
    	 System.out.println("---");
    	 for(int i = 0; i < vec.size(); i++) {
    		 System.out.println(vec.get(i));
    	 }
    	 System.out.println("---");
    	 System.out.println(vec.get(3));
    	 vec.removeAllElements();
    	 System.out.println(vec.size());
    	 System.out.println("---");
    	 if(vec.isEmpty()) {
    		 System.out.println("비어있음");
    	 }
    	 else {
    		 System.out.println("component 있음");
    	 }
    	 System.out.println("---");
    	 Set set = new HashSet();
    	 set.add(3);
    	 set.add(3.14);
    	 set.add("Happy");
    	 set.add(new Integer(5));
    	 set.add(new Double(3.5));
    	 set.add(new String("Java"));
    	 System.out.println(set.size());
    	 set.add(3); //실행 안함(중복 불가능)
    	 System.out.println(set.size());
    	 System.out.println("---");
    	 HashMap map = new HashMap();
    	 map.put("one", 3);
    	 map.put("two", 3.14);
    	 map.put("three", "HAPPY");
    	 map.put("four", new Integer(5));
    	 map.put("five", 3);
    	 map.put("five", 5); //실행 함("key" 중복 불가능) --> 기존 값 인정 안함
    	 
    	 System.out.println(map.size());
    	 System.out.println(map.get("two"));
    	 System.out.println(map.get("five"));
    	 
    	 HashSet hs = new HashSet();
    	 hs.add(3);
    	 hs.add(3.14);
    	 hs.add("soul");
    	 hs.add('R');
    	 hs.add(new Integer(5));
    	 
    	 java.util.Iterator iter = hs.iterator();
    	 System.out.println("---");
    	 while(iter.hasNext()) {
    		 Object obj = iter.next();
    		 System.out.println(obj.toString());
    	 }
     }
}
