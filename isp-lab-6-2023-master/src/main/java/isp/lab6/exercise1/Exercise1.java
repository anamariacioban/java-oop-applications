package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Student s1 = new Student("Andrei Marinescu", 1);
        Student s2 = new Student("Carla Cristea", 2);
        Student s3 = new Student("Maria Popescu", 3);

        StudentManager studentManager=new StudentManager();

        studentManager.addStudent(s1);
        studentManager.addStudent(s2);
        studentManager.addStudent(s3);

        s1.addGrade("Psihologie", 93);
        s1.addGrade("Filozofie", 100);

        s2.addGrade("Romana", 90);
        s2.addGrade("Matematica", 65);

        s3.addGrade("Infotmatica", 70);
        s3.addGrade("Biologie", 98);


        System.out.println("Lista studenti: ");
        studentManager.displayAllStudents();

        System.out.println(" Actualizare student_name cu id 2: ");
        s2.setStudent_name("Carla Marculescu");

        System.out.println(" Actualizare grade cu id 2: ");
        s2.setGrade("Romana", 100);


        System.out.println("Ștergere student cu id=1");
        studentManager.removeStudent( 1);

        System.out.println("Lista finală a studenților: ");
        studentManager.displayAllStudents();
    }
}
