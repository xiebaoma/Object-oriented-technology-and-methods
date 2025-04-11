public class Student {
    // 数据成员
    private String studentId;  // 学号
    private String name;       // 姓名
    private char gender;       // 性别
    private int age;           // 年龄
    private static int totalStudents = 0;  // 学生总数

    // 无参构造方法
    public Student() {
        totalStudents++;  // 每创建一个学生对象，学生总数加1
    }

    // 带参数的构造方法
    public Student(String studentId, String name, char gender, int age) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        totalStudents++;  // 每创建一个学生对象，学生总数加1
    }

    // Getter 和 Setter 方法
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 获取学生总数的静态方法
    public static int getTotalStudents() {
        return totalStudents;
    }

    // 重写toString方法，方便打印学生信息
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    
}