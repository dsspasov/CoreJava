package student;

public class Student implements Comparable<Object> {
    private String name;
    private int grade;
    
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getGrade() {
        return grade;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }


    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Student(String name, int grade) {
        super();
        this.name = name;
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student [name=" + name + ", grade=" + grade + "]";
    }


    @Override
    public int compareTo(Object student) {
        
        Student studentt = (Student)student;
        if(this.grade>studentt.grade){
            return 1;
        }else if(this.grade<studentt.getGrade()){
            return -1;
        }else{
            return this.name.compareToIgnoreCase((studentt.getName()));
        }        
    }
}