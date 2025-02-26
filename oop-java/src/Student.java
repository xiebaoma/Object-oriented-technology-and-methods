public class Student {
    // 属性
    private String name;
    private int age;
    private String studentId;
    private double grade;

    // 构造函数
    public Student(String name, int age, String studentId, double grade) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.grade = grade;
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // 输出学生信息
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", grade=" + grade +
                '}';
    }

}
