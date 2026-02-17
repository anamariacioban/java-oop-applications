package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    private String student_name;
    private int student_id;
    private HashMap<String, Integer> grades;

    public Student(String student_name, int student_id) {
        this.student_name = student_name;
        this.student_id = student_id;
        this.grades = new HashMap<>();
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public void setGrade(String subject, int grade) {
        grades.put(subject, grade);
        System.out.println("Nota pentru subiectul " + subject + " a fost setată la " + grade);
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{name='" + student_name + "', id=" + student_id + "}";
    }
}