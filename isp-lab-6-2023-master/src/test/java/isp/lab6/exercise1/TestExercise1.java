package isp.lab6.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExercise1 {
    @Test
    public void testAddStudent() {
        StudentManager studentManager=new StudentManager();
        Student student1 = new Student("Mara Popescu", 1);
        studentManager.addStudent(student1);
        assertEquals(1, studentManager.getStudents().size());

        Student student2 = new Student("Mihaela Cristea", 2);
        studentManager.addStudent(student2);
        assertEquals(2, studentManager.getStudents().size());

        Student student3 = new Student("Cristian Muresan", 3);
        studentManager.addStudent(student3);
        assertEquals(3, studentManager.getStudents().size());

        Student student4 = new Student("Carina Deac", 4);
        studentManager.addStudent(student4);
        assertEquals(4, studentManager.getStudents().size());

    }
    @Test
    public void testAddGrades() {
        Student student = new Student("Mara Popescu", 1);
        student.addGrade("Matematica", 75);
        student.addGrade("Romana", 90);
        assertEquals(75, student.getGrades().get("Matematica").intValue());
        assertEquals(90, student.getGrades().get("Romana").intValue());
    }
    @Test
    public void testRemoveStudent(){
        StudentManager studentManager=new StudentManager();
        Student student1 = new Student("Mara Popescu", 1);
        Student student2 = new Student("Mihaela Cristea", 2);
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);

        studentManager.removeStudent(student1.getStudent_id());

        assertEquals(1, studentManager.getStudents().size());
        assertEquals("Mihaela Cristea", studentManager.getStudents().get(0).getStudent_name());
    }
    @Test
    public void testUpdateStudentName() {
        StudentManager studentManager=new StudentManager();
        Student student = new Student("Alex Pop", 4);
        studentManager.addStudent(student);
        student.setStudent_name("Alexandru Pop");

        assertEquals("Alexandru Pop", student.getStudent_name());
    }
}
