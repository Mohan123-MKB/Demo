import java.util.*;
interface enrollable{
    void enrollStudent(Student student);
}

abstract class Course implements enrollable{
    private String courseName;
    private String instructor;
    private List<Student> students=new ArrayList<>();
    public Course(String cn,String ins){
        courseName=cn;
        instructor=ins;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getInstructor(){
        return instructor;
    }
    public List<Student> getStudents(){
        return students;
    }
    @Override
    public void enrollStudent(Student student){
        students.add(student);
        System.out.println(student.getName()+" " +" enrolled in"+" "+courseName);
    }
    public abstract void deliverCourse();
}

class OnlineCourse extends Course{
    public OnlineCourse(String cn,String in){
        super(cn,in);
    }
    @Override
    public void deliverCourse(){
        System.out.println("delivering online course:"+getCourseName()+" "+"via zoom");
    }
}
class OfflineCourse extends Course{
    public OfflineCourse(String cn,String in){
        super(cn,in);
    }
    @Override
    public void deliverCourse(){
        System.out.println("delivering offline course:"+getCourseName()+" "+"in classroom");
    }
}

class Student{
    private String name;
    private int id;
    Student(String n,int id){
        name=n;
        this.id=id;
    } 
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
}
public class StudentCourseEnrollmentSystem {
    public static void main(String[] args) {
        Course c1=new OnlineCourse("Java", "Mr.Smith");
        Course c2=new OfflineCourse("Maths", "Mr.Johnson");
        Student s1=new Student("Bob",101);
        Student s2=new Student("Alice",102);
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c1.deliverCourse();
        c2.enrollStudent(s2);
        c2.deliverCourse();
    }
    
}
