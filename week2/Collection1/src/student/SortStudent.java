package student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortStudent {
    public static List<Student> listOfStudents = new LinkedList<Student>();

    public static void main(String[] args) {

        listOfStudents.add(new Student("a", 6));
        listOfStudents.add(new Student("b", 6));
        listOfStudents.add(new Student("c", 2));
        listOfStudents.add(new Student("d", 5));
        listOfStudents.add(new Student("e", 4));

        Collections.sort(listOfStudents);
        System.out.println(listOfStudents.toString());
    }
}