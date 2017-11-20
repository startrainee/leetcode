package meituan.meituan_design;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface ListFilter {
    boolean filter(String s);
}
public class Design2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        ListFilter listFilter = s -> !s.equals("1");
        List<String> newList = list.stream().filter(listFilter::filter).collect(Collectors.toList());
        newList.forEach(System.out::println);
        }
    }


