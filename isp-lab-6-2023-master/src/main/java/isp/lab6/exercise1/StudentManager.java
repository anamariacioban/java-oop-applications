package isp.lab6.exercise1;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added!");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i) + ", Average Grade: " + getAverageGrade(students.get(i)));
            }
        }
    }


    public double getAverageGrade(Student student) {
        HashMap<String, Integer> grades = student.getGrades();
        if (grades.isEmpty()) return 0;
        int suma = 0;
        for (int grade : grades.values()) {
            suma= suma+grade;
        }
        return suma / (double) grades.size();
    }


    public void removeStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudent_id() == studentId) {
                students.remove(i);
                System.out.println("Student removed.");
            }
        }
    }

    /// pt teste
    public List<Student> getStudents() {
        return students;
    }
}