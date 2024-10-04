package DataStructure.ArrayListTheme;

import java.util.ArrayList;

public class ArrayList_pt_2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();

        student1.setName("Max");
        student1.setAge(18);
        student1.setGpa(4.5);

        student2.setName("Art");
        student2.setAge(17);
        student2.setGpa(5.0);

        student3.setName("Bob");
        student3.setAge(19);
        student3.setGpa(3.7);

        student4.setName("John");
        student4.setAge(19);
        student4.setGpa(3.9);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //students.remove("John");

        System.out.println(students.toString());

        System.out.println(getMaxGpa(students));
        System.out.println(getMinGpa(students));
        System.out.println(getAvgGpa(students));
    }

    public static Student getMaxGpa(ArrayList<Student> students){
        double x = 0;
        int j = 0;
        for (int i = 0; i < students.size(); i++) {

            if(students.get(i).getGpa() > x){
                x = students.get(i).getGpa();
                j = i;
            }

        }
        return students.get(j);
    }

    public static Student getMinGpa(ArrayList<Student> students){
        double x = 10;
        int j = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getGpa() < x){
                x = students.get(i).getGpa();
                j = i;
            }
        }
        return students.get(j);
    }

    public static double getAvgGpa(ArrayList<Student> students){
        double x = 0;
        for (int i = 0; i < students.size(); i++) {
            x += students.get(i).getGpa();
        }
        x /= students.size();
        return x;
    }


}
