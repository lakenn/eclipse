package com.eclipseoptions.javatest.majority.api;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class HashMapSortMain {


    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        // some dummy data:
        map.put("1", new Student(1, "d", 12));
        map.put("2", new Student(2, "b", 10));
        map.put("3", new Student(3, "c", 11));

        Collection<Student> students = map.values();
        List<Student> list = new ArrayList<>(students);
        Collections.sort(list);

        for (Iterator<Student> it = list.iterator(); it.hasNext();) {
            Student stdn = (Student) it.next();
            System.out.println("Student id : " + stdn.getName() + "Age :" + stdn.getAge());

        }

        map.get("1").setAge(8);

        Collections.sort(list, Comparator.comparing((Student p)->p.getName())
                .thenComparing(p->p.getAge()));

        for (Iterator<Student> it = list.iterator(); it.hasNext();) {
            Student stdn = (Student) it.next();
            System.out.println("Student id : " + stdn.getName() + "Age :" + stdn.getAge());

        }

        // java stream
        List<Map.Entry<String, Student>> comparingByValue = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

        for (Map.Entry entry : comparingByValue) {
            Student stdn = (Student) entry.getValue();
            System.out.println("Student id : " + stdn.getName() + "Age :" + stdn.getAge());

        }

        // java stream
        List<Map.Entry<String, Student>> comparingByValue2 = map.entrySet().stream().sorted(Map.Entry.comparingByValue(
                Comparator.comparing((Student p)->p.getName())
                        .thenComparing(p->p.getAge())
        )).collect(Collectors.toList());

        for (Map.Entry entry : comparingByValue2) {
            Student stdn = (Student) entry.getValue();
            System.out.println("Student id : " + stdn.getName() + "Age :" + stdn.getAge());

        }

        Map<String, Student> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        Comparator<Student> rollNoComparator = Comparator.comparing(Student::getRollno);
        Map<String, Student> result2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(rollNoComparator.reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println();
        System.out.println(result2.size());

        map.remove("1");
        System.out.println(result2.size());
        System.out.println(map.size());

        result2.remove("1");

        List<String> list2 = Arrays.asList("A", "B", "C");
        list2.forEach( System.out::println );

        AtomicInteger i = new AtomicInteger(0);
        Map<Integer, String> fileNumWithContentMapper = list2.stream()
                .collect( Collectors.toMap( e->i.incrementAndGet(),s1->s1));

        System.out.println(fileNumWithContentMapper);
    }
}
